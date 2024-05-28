
package cn.featherfly.hammer.sqldb.dsl.entity.query;

import com.speedment.common.tuple.Tuple2;
import com.speedment.common.tuple.Tuples;

import cn.featherfly.common.constant.Chars;
import cn.featherfly.common.db.dialect.Dialect;
import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.common.lang.Lang;
import cn.featherfly.common.repository.builder.dml.SortBuilder;
import cn.featherfly.hammer.config.HammerConfig;
import cn.featherfly.hammer.dsl.entity.query.EntityQueryConditionGroup;
import cn.featherfly.hammer.dsl.entity.query.EntityQueryConditionGroupLogic;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.sqldb.SqldbHammerException;
import cn.featherfly.hammer.sqldb.dsl.entity.EntitySqlQueryRelation;
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
    //        return queryRelation.getJdbc().queryLong(getRoot().expression(), getRoot().getParams().toArray());
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
    public Tuple2<String, String> expressionPage() {
        return expressionPage(super.expression(), parent, entityRelation, getRootSortBuilder(), dialect);
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
     * Expression page.
     *
     * @param condition the condition
     * @param parent the parent
     * @param queryRelation the query relation
     * @param sortBuilder the sort builder
     * @param dialect the dialect
     * @return the tuple 2
     */
    static Tuple2<String, String> expressionPage(String condition, LogicExpression<?, ?> parent,
        EntitySqlQueryRelation queryRelation, SortBuilder sortBuilder, Dialect dialect) {
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
