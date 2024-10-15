
package cn.featherfly.hammer.sqldb.dsl.repository.query;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import cn.featherfly.common.tuple.Tuple1;
import cn.featherfly.common.tuple.Tuple2;
import cn.featherfly.common.tuple.Tuples;

import cn.featherfly.common.constant.Chars;
import cn.featherfly.common.db.builder.dml.SqlSortBuilder;
import cn.featherfly.common.db.builder.dml.basic.SqlSelectBasicBuilder;
import cn.featherfly.common.db.dialect.Dialect;
import cn.featherfly.common.lang.Lang;
import cn.featherfly.common.operator.AggregateFunction;
import cn.featherfly.common.repository.builder.dml.SortBuilder;
import cn.featherfly.common.repository.mapper.RowMapper;
import cn.featherfly.common.structure.page.Limit;
import cn.featherfly.common.structure.page.PaginationResults;
import cn.featherfly.hammer.config.dsl.QueryConditionConfig;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroup;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroupLogic;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.query.QueryLimitExecutor;
import cn.featherfly.hammer.expression.repository.query.RepositoryQuerySortExpression;
import cn.featherfly.hammer.expression.repository.query.RepositoryQuerySortedExpression;
import cn.featherfly.hammer.sqldb.SqldbHammerException;
import cn.featherfly.hammer.sqldb.dsl.repository.AbstractMulitiRepositorySqlConditionsGroupExpressionBase;
import cn.featherfly.hammer.sqldb.dsl.repository.RepositorySqlQueryConditionGroupQuery;
import cn.featherfly.hammer.sqldb.dsl.repository.RepositorySqlQueryRelation;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;

/**
 * abstract muliti repository sql query conditions group expression.
 *
 * @author zhongj
 */
public abstract class AbstractMulitiRepositorySqlQueryConditionsGroupExpression extends
    AbstractMulitiRepositorySqlConditionsGroupExpressionBase<RepositoryQueryConditionsGroup,
        RepositoryQueryConditionsGroupLogic, Tuple1<Integer>, QueryConditionConfig, RepositorySqlQueryRelation,
        SqlSelectBasicBuilder>
    implements
    //    RepositoryQueryableExpression<RepositoryQuerySortExpression, QueryLimitExecutor>, //
    //    ConditionConfigureExpression<RepositoryQuery, QueryConditionConfig>, //
    RepositoryQueryConditionsGroup, RepositoryQueryConditionsGroupLogic, //
    RepositoryQuerySortExpression, RepositoryQuerySortedExpression {

    private SqlSortBuilder sortBuilder;

    /** The sql page factory. */
    protected SqlPageFactory sqlPageFactory;

    private final RepositorySqlQueryConditionGroupQuery repositorySqlQueryConditionGroupQuery;

    /**
     * Instantiates a new abstract muliti repository sql query conditions group
     * expression.
     *
     * @param parent the parent
     * @param index the index
     * @param queryRelation the query relation
     * @param sqlPageFactory the sql page factory
     */
    protected AbstractMulitiRepositorySqlQueryConditionsGroupExpression(RepositoryQueryConditionsGroupLogic parent,
        int index, RepositorySqlQueryRelation queryRelation, SqlPageFactory sqlPageFactory) {
        super(parent, index, queryRelation);
        this.sqlPageFactory = sqlPageFactory;
        if (parent == null) {
            // use root only, see getRootSortBuilder()
            sortBuilder = new SqlSortBuilder(dialect, repositoryAlias);
        }
        repositorySqlQueryConditionGroupQuery = new RepositorySqlQueryConditionGroupQuery(this, sqlPageFactory,
            queryRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryLimitExecutor limit(Limit limit) {
        repositorySqlQueryConditionGroupQuery.setLimit(limit);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public long count() {
        repositoryRelation.getBuilder().clearColumns().addColumn(AggregateFunction.COUNT, Chars.STAR);
        return repositoryRelation.getJdbc().queryLong(getRoot().expression(), getRoot().getParamsArray());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Map<String, Serializable>> list() {
        return repositorySqlQueryConditionGroupQuery.list();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> List<E> list(Class<E> type) {
        return repositorySqlQueryConditionGroupQuery.list(type);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> List<E> list(RowMapper<E> rowMapper) {
        return repositorySqlQueryConditionGroupQuery.list(rowMapper);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PaginationResults<Map<String, Serializable>> pagination() {
        return repositorySqlQueryConditionGroupQuery.pagination();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> PaginationResults<E> pagination(Class<E> type) {
        return repositorySqlQueryConditionGroupQuery.pagination(type);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> PaginationResults<E> pagination(RowMapper<E> rowMapper) {
        return repositorySqlQueryConditionGroupQuery.pagination(rowMapper);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Map<String, Serializable> single() {
        return repositorySqlQueryConditionGroupQuery.single();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> E single(Class<E> type) {
        return repositorySqlQueryConditionGroupQuery.single(type);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> E single(RowMapper<E> rowMapper) {
        return repositorySqlQueryConditionGroupQuery.single(rowMapper);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Map<String, Serializable> unique() {
        return repositorySqlQueryConditionGroupQuery.unique();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> E unique(Class<E> type) {
        return repositorySqlQueryConditionGroupQuery.unique(type);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> E unique(RowMapper<E> rowMapper) {
        return repositorySqlQueryConditionGroupQuery.unique(rowMapper);
    }

    // ****************************************************************************************************************
    //	sort
    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryQuerySortExpression sort() {
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryQuerySortedExpression asc(String... names) {
        getRootSortBuilder().asc(names);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryQuerySortedExpression desc(String... names) {
        getRootSortBuilder().desc(names);
        return this;
    }

    // ****************************************************************************************************************
    //	private method
    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    protected Tuple1<Integer> createTuple() {
        return Tuples.of(0);
    }

    /**
     * Gets the root sort builder.
     *
     * @return the root sort builder
     */
    protected SortBuilder getRootSortBuilder() {
        return ((AbstractMulitiRepositorySqlQueryConditionsGroupExpression) getRoot()).sortBuilder;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String expression() {
        return expression(super.expression(), parent, repositoryRelation, getRootSortBuilder(), dialect);
    }

    /**
     * Expression page.
     *
     * @return the tuple 2
     */
    public Tuple2<String, String> expressionPage() {
        return expressionPage(super.expression(), parent, repositoryRelation, getRootSortBuilder(), dialect);
    }

    static String expression(String condition, LogicExpression<?, ?> parent, RepositorySqlQueryRelation queryRelation,
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

    static Tuple2<String, String> expressionPage(String condition, LogicExpression<?, ?> parent,
        RepositorySqlQueryRelation queryRelation, SortBuilder sortBuilder, Dialect dialect) {
        if (parent == null) {
            String select;
            String selectCount;
            select = queryRelation.buildSelectSql();
            selectCount = queryRelation.buildSelectCountSql();

            String sort = sortBuilder.build();
            if (Lang.isEmpty(condition)) {
                return Tuples.of(select + Chars.SPACE + sort, selectCount + Chars.SPACE + sort);
            } else {
                return Tuples.of(
                    select + Chars.SPACE + dialect.getKeywords().where() + Chars.SPACE + condition + Chars.SPACE + sort,
                    selectCount + Chars.SPACE + dialect.getKeywords().where() + Chars.SPACE + condition + Chars.SPACE
                        + sort);
            }
        } else {
            // ENHANCE 后续来把逻辑改为外部调用的都自己找到parent去调用，而属性结果的调用放到内部方法进行
            throw new SqldbHammerException("not root expression, only root expression can invoke this method");
        }
    }
}
