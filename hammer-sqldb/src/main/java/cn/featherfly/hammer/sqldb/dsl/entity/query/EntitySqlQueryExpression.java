
package cn.featherfly.hammer.sqldb.dsl.entity.query;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import javax.cache.Cache;

import org.apache.commons.lang3.StringUtils;

import com.speedment.common.tuple.Tuple3;
import com.speedment.common.tuple.Tuple7;
import com.speedment.common.tuple.Tuple8;
import com.speedment.common.tuple.Tuples;

import cn.featherfly.common.constant.Chars;
import cn.featherfly.common.db.dialect.Dialect;
import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.common.lang.Lang;
import cn.featherfly.common.repository.builder.dml.SortBuilder;
import cn.featherfly.common.structure.page.Limit;
import cn.featherfly.hammer.config.HammerConfig;
import cn.featherfly.hammer.config.cache.QueryPageResult;
import cn.featherfly.hammer.config.cache.QueryPageResult.PageInfo;
import cn.featherfly.hammer.dsl.entity.query.EntityQueryConditionGroup;
import cn.featherfly.hammer.dsl.entity.query.EntityQueryConditionGroupLogic;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.sqldb.SqldbHammerException;
import cn.featherfly.hammer.sqldb.dsl.entity.AbstractMulitiEntitySqlConditionsGroupExpressionBase;
import cn.featherfly.hammer.sqldb.dsl.entity.EntitySqlQueryRelation;
import cn.featherfly.hammer.sqldb.dsl.entity.EntitySqlRelation.EntityRelation;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;

/**
 * EntitySqlQueryExpression .
 *
 * @author zhongj
 * @param <T> the element type
 */
public class EntitySqlQueryExpression<T> extends AbstractMulitiEntitySqlQueryConditionsGroupExpression<T,
    EntityQueryConditionGroup<T>, EntityQueryConditionGroupLogic<T>>
    implements EntityQueryConditionGroup<T>, EntityQueryConditionGroupLogic<T> {

    /**
     * Instantiates a new entity sql query expression.
     *
     * @param hammerConfig the hammer config
     * @param factory the factory
     * @param sqlPageFactory the sql page factory
     * @param queryRelation the query relation
     */
    public EntitySqlQueryExpression(HammerConfig hammerConfig, JdbcMappingFactory factory,
        SqlPageFactory sqlPageFactory, EntitySqlQueryRelation queryRelation) {
        this(null, hammerConfig, factory, sqlPageFactory, queryRelation);
    }

    /**
     * Instantiates a new entity sql query expression.
     *
     * @param parent the parent
     * @param hammerConfig the hammer config
     * @param factory the factory
     * @param sqlPageFactory the sql page factory
     * @param queryRelation the query relation
     */
    EntitySqlQueryExpression(EntityQueryConditionGroupLogic<T> parent, HammerConfig hammerConfig,
        JdbcMappingFactory factory, SqlPageFactory sqlPageFactory, EntitySqlQueryRelation queryRelation) {
        super(parent, hammerConfig, factory, sqlPageFactory, queryRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected EntitySqlQueryExpression<T> createGroup(EntityQueryConditionGroupLogic<T> parent) {
        return new EntitySqlQueryExpression<>(parent, hammerConfig, factory, sqlPageFactory, entityRelation);
    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public long count() {
    //        queryRelation.getSelectBuilder().addColumn(AggregateFunction.COUNT, Chars.STAR);
    //        return queryRelation.getJdbc().queryLong(getRoot().expression(), getRoot().getParamsArray());
    //    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String expression() {
        String condition = super.expression();
        return expression(condition, parent, entityRelation, getRootSortBuilder(), dialect);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Tuple7<String, List<Serializable>, Optional<Limit>, Optional<QueryPageResult>, String,
        Function<Object, Serializable>, Optional<Boolean>> prepareList(Limit limit) {
        return prepareList(hammerConfig, this, super.expression(), parent, entityRelation, getRootSortBuilder(),
            dialect, limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Tuple8<String, String, List<Serializable>, Optional<Limit>, Optional<QueryPageResult>, String,
        Function<Object, Serializable>, Optional<Boolean>> preparePagination(Limit limit) {
        return preparePage(hammerConfig, this, super.expression(), parent, entityRelation, getRootSortBuilder(),
            dialect, limit);
    }

    /**
     * Expression.
     *
     * @param condition the condition
     * @param parent the parent
     * @param queryRelation the query relation
     * @param sortBuilder the sort builder
     * @param dialect the dialect
     * @return the string
     */
    static String expression(String condition, LogicExpression<?, ?> parent, EntitySqlQueryRelation queryRelation,
        SortBuilder sortBuilder, Dialect dialect) {
        if (parent == null) {
            String result = queryRelation.buildSelectSql();
            if (Lang.isEmpty(condition)) {
                return result + Chars.SPACE + sortBuilder.build();
            } else {
                return result + Chars.SPACE + dialect.getKeywords().where() + Chars.SPACE + condition + Chars.SPACE
                    + sortBuilder.build();
            }
        } else {
            return condition;
        }
    }

    /**
     * Prepare list.
     *
     * @param hammerConfig the hammer config
     * @param exp the exp
     * @param condition the condition
     * @param parent the parent
     * @param queryRelation the query relation
     * @param sortBuilder the sort builder
     * @param dialect the dialect
     * @param limit the limit
     * @return the tuple 6
     */
    static Tuple7<String, List<Serializable>, Optional<Limit>, Optional<QueryPageResult>, String,
        Function<Object, Serializable>, Optional<Boolean>> prepareList(HammerConfig hammerConfig,
            AbstractMulitiEntitySqlConditionsGroupExpressionBase<?, ?, ?, ?, ?, ?> exp, String condition,
            LogicExpression<?, ?> parent, EntitySqlQueryRelation queryRelation, SortBuilder sortBuilder,
            Dialect dialect, Limit limit) {

        if (parent == null) {
            String select = null;
            String selectSql = null;

            String sort = sortBuilder.build();

            Cache<Object,
                QueryPageResult> queryPageResultCache = hammerConfig.getCacheConfig().getQueryPageResultCache();
            QueryPageResult queryPageResult = null;
            List<Serializable> params = exp.getParams();

            if (queryPageResultCache != null
                && queryRelation.getEntityRelation(0).getClassMapping().isPrimaryKeyOrdered()
                && StringUtils.isBlank(sort)) {
                List<Serializable> key = new ArrayList<>(params);
                // ENHANCE 这里生成sql，在没有命中缓存时就浪费了,所以需要一个更好的唯一标识来处理
                selectSql = expression(condition, parent, queryRelation, sortBuilder, dialect);
                key.add(0, selectSql);
                queryPageResult = queryPageResultCache.get(key);

                if (queryPageResult != null
                    && (queryPageResult.getLimit() == null || queryPageResult.getLimit() == limit.getLimit())) {
                    Tuple3<String, Limit, Optional<Boolean>> conditionAndLimit = processLimit(queryRelation, condition,
                        limit, queryPageResult, dialect);

                    select = queryRelation.buildSelectSql() + Chars.SPACE + dialect.getKeywords().where() + Chars.SPACE
                        + conditionAndLimit.get0() + Chars.SPACE + sort;
                    return Tuples.of(select, params, Optional.ofNullable(conditionAndLimit.get1()),
                        Optional.of(queryPageResult), selectSql, queryRelation.getEntityRelation(0).getClassMapping()
                            .getPrimaryKeyPropertyMappings().get(0).getGetter(),
                        conditionAndLimit.get2());
                }
            }

            if (selectSql == null) {
                select = queryRelation.buildSelectSql();
            } else {
                select = selectSql;
            }
            if (Lang.isEmpty(condition)) {
                select = queryRelation.buildSelectSql() + Chars.SPACE + sort;
            } else {
                select = queryRelation.buildSelectSql() + Chars.SPACE + dialect.getKeywords().where() + Chars.SPACE
                    + condition + Chars.SPACE + sort;
            }
            return Tuples.of(select, params, Optional.ofNullable(limit), Optional.ofNullable(queryPageResult), select,
                queryRelation.getEntityRelation(0).getClassMapping().getPrimaryKeyPropertyMappings().get(0).getGetter(),
                Optional.of(true));
        } else {
            // ENHANCE 后续来把逻辑改为外部调用的都自己找到parent去调用，而属性结果的调用放到内部方法进行
            throw new SqldbHammerException("not root expression, only root expression can invoke this method");
        }
    }

    /**
     * @param hammerConfig the hammer config
     * @param exp the exp
     * @param condition the condition
     * @param parent the parent
     * @param queryRelation the query relation
     * @param sortBuilder the sort builder
     * @param dialect the dialect
     * @param limit the limit
     * @return the tuple 7
     */
    static Tuple8<String, String, List<Serializable>, Optional<Limit>, Optional<QueryPageResult>, String,
        Function<Object, Serializable>, Optional<Boolean>> preparePage(HammerConfig hammerConfig,
            AbstractMulitiEntitySqlConditionsGroupExpressionBase<?, ?, ?, ?, ?, ?> exp, String condition,
            LogicExpression<?, ?> parent, EntitySqlQueryRelation queryRelation, SortBuilder sortBuilder,
            Dialect dialect, Limit limit) {
        if (parent == null) {
            String select = null;
            String selectCount = null;
            String selectSql = null;
            QueryPageResult queryPageResult = null;

            String sort = sortBuilder.build();
            List<Serializable> params = exp.getParams();

            if (queryRelation.getConfig().isPagingOptimization() && limit != null) {
                Cache<Object,
                    QueryPageResult> queryPageResultCache = hammerConfig.getCacheConfig().getQueryPageResultCache();

                if (queryPageResultCache != null
                    && queryRelation.getEntityRelation(0).getClassMapping().isPrimaryKeyOrdered()
                    && StringUtils.isBlank(sort)) {
                    List<Object> key = new ArrayList<>(params);
                    // ENHANCE 这里生成sql，在没有命中缓存时就浪费了,所以需要一个更好的唯一标识来处理
                    selectSql = expression(condition, parent, queryRelation, sortBuilder, dialect);
                    key.add(0, selectSql);
                    queryPageResult = queryPageResultCache.get(key);

                    if (queryPageResult == null) { // query first time
                        // new QueryPageResult for Follow Up, then only need decide queryPageResult is null
                        queryPageResult = new QueryPageResult();
                    } else if (queryPageResult.getLimit() != null && queryPageResult.getLimit() == limit.getLimit()) {
                        Tuple3<String, Limit, Optional<Boolean>> conditionAndLimit = processLimit(queryRelation,
                            condition, limit, queryPageResult, dialect);

                        select = queryRelation.buildSelectSql() + Chars.SPACE + dialect.getKeywords().where()
                            + Chars.SPACE + conditionAndLimit.get0() + Chars.SPACE + sort;
                        if (Lang.isEmpty(condition)) {
                            selectCount = queryRelation.buildSelectCountSql() + Chars.SPACE + sort;
                        } else {
                            selectCount = queryRelation.buildSelectCountSql() + Chars.SPACE
                                + dialect.getKeywords().where() + Chars.SPACE + condition + Chars.SPACE + sort;
                        }
                        return Tuples.of(select, selectCount, params, Optional.ofNullable(conditionAndLimit.get1()),
                            Optional.of(queryPageResult), selectSql, queryRelation.getEntityRelation(0)
                                .getClassMapping().getPrimaryKeyPropertyMappings().get(0).getGetter(),
                            conditionAndLimit.get2());
                    }
                }
            }

            if (selectSql == null) {
                if (Lang.isEmpty(condition)) {
                    select = queryRelation.buildSelectSql() + Chars.SPACE + sort;
                } else {
                    select = queryRelation.buildSelectSql() + Chars.SPACE + dialect.getKeywords().where() + Chars.SPACE
                        + condition + Chars.SPACE + sort;
                }
            } else {
                select = selectSql;
            }
            if (limit != null) {
                if (Lang.isEmpty(condition)) {
                    selectCount = queryRelation.buildSelectCountSql() + Chars.SPACE + sort;
                } else {
                    selectCount = queryRelation.buildSelectCountSql() + Chars.SPACE + dialect.getKeywords().where()
                        + Chars.SPACE + condition + Chars.SPACE + sort;
                }
            }
            return Tuples.of(select, selectCount, params, Optional.ofNullable(limit),
                Optional.ofNullable(queryPageResult), select,
                queryRelation.getEntityRelation(0).getClassMapping().getPrimaryKeyPropertyMappings().get(0).getGetter(),
                Optional.of(true));
        } else {
            // ENHANCE 后续来把逻辑改为外部调用的都自己找到parent去调用，而属性结果的调用放到内部方法进行
            throw new SqldbHammerException("not root expression, only root expression can invoke this method");
        }
    }

    private static Tuple3<String, Limit, Optional<Boolean>> processLimit(EntitySqlQueryRelation queryRelation,
        String condition, Limit limit, QueryPageResult queryPageResult, Dialect dialect) {
        String pageCondition = null;
        EntityRelation<?> er = queryRelation.getEntityRelation(0);
        String idField = er.getClassMapping().getPrimaryKeyPropertyMappings().get(0).getRepositoryFieldName();
        PageInfo pageInfo = queryPageResult.getNearestQueryPageResult(limit);

        if (queryPageResult.getTotal() != null && queryPageResult.getTotal()
            / limit.getLimit() < (limit.getOffset() + limit.getLimit()) / limit.getLimit()) {
            return Tuples.of(condition, limit, Optional.empty());
            // ENHANCE 后续优化异常
            //            throw new SqldbHammerException(
            //                Strings.format("query results max page number {} < query limit page number {}",
            //                    queryPageResult.getTotal() / limit.getLimit(),
            //                    (limit.getOffset() + limit.getLimit()) / limit.getLimit()));
        }
        if (pageInfo.getFirstId() == null) { // 未查出数据
            return Tuples.of(condition, limit, Optional.of(true));
        }
        if (limit.getOffset() > pageInfo.getOffset().intValue()) {
            // 向前翻页 where id > result.getLastId()
            pageCondition = er.getTableAlias() + Chars.DOT + dialect.wrapName(idField) + " > "
                + pageInfo.getLastId().longValue() + Chars.SPACE
                + Lang.ifNotEmpty(condition, c -> Chars.SPACE + dialect.keywords().and() + Chars.SPACE + c);
            // 添加到参数可能遇到参数位置不对的情况，有可能在查询条件前就有?占位符了，所以这里先用sql拼接
            // 而且id是框架内部从查询回来的实体对象id拿到的，应该是不会有sql注入风险
            // params.add(0, result.getLastId()); // 添加到第一个参数
            return Tuples.of(pageCondition,
                new Limit(limit.getOffset() - pageInfo.getOffset() - pageInfo.getLimit(), limit.getLimit()),
                Optional.of(true));
        } else if (limit.getOffset() < pageInfo.getOffset().intValue()) {
            // 往回翻页 where id < result.getFirstId()
            pageCondition = er.getTableAlias() + Chars.DOT
                + er.getClassMapping().getPrimaryKeyPropertyMappings().get(0).getRepositoryFieldName() + " < "
                + pageInfo.getFirstId().longValue() + Chars.SPACE
                + Lang.ifNotEmpty(condition, c -> Chars.SPACE + dialect.keywords().and() + Chars.SPACE + c);
            return Tuples.of(pageCondition,
                new Limit(pageInfo.getOffset() - limit.getOffset() - limit.getLimit(), limit.getLimit()),
                Optional.of(true));
        } else {
            // 当前页 where id >= result.getFirstId()
            pageCondition = er.getTableAlias() + Chars.DOT + dialect.wrapName(idField) + " >= "
                + pageInfo.getFirstId().longValue()
                + Lang.ifNotEmpty(condition, c -> Chars.SPACE + dialect.keywords().and() + Chars.SPACE + c);
            // 不需要更改limit
            return Tuples.of(pageCondition, limit, Optional.of(true));
        }
    }
}
