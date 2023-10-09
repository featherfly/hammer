
package cn.featherfly.hammer.sqldb.jdbc.dsl.entity.query;

import java.util.List;

import cn.featherfly.common.constant.Chars;
import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.common.lang.AssertIllegalArgument;
import cn.featherfly.common.operator.AggregateFunction;
import cn.featherfly.common.structure.page.Limit;
import cn.featherfly.common.structure.page.PaginationResults;
import cn.featherfly.hammer.expression.entity.query.EntityQueryConditionLimit;
import cn.featherfly.hammer.expression.entity.query.EntityQueryLimitExecutor;
import cn.featherfly.hammer.expression.query.QueryCountExecutor;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.EntitySqlQueryRelation;
import cn.featherfly.hammer.sqldb.jdbc.dsl.query.SqlQueryExpression;

/**
 * abstract entity sql query entity properties.
 *
 * @author zhongj
 * @param <R> the query result type
 * @param <P> the generic type
 */
public abstract class AbstractEntitySqlQuery<R>
        implements EntityQueryConditionLimit<R>, EntityQueryLimitExecutor<R>, QueryCountExecutor {

    protected JdbcMappingFactory factory;

    protected SqlPageFactory sqlPageFactory;

    protected EntitySqlQueryRelation queryRelation;

    /** The limit. */
    protected Limit limit;

    /**
     * Instantiates a new abstract sql query entity properties.
     *
     * @param <E>                    the element type
     * @param factory                the factory
     * @param sqlPageFactory         the sql page factory
     * @param entitySqlQueryRelation the entity sql query relation
     */
    protected AbstractEntitySqlQuery(JdbcMappingFactory factory, SqlPageFactory sqlPageFactory,
            EntitySqlQueryRelation entitySqlQueryRelation) {
        AssertIllegalArgument.isNotNull(entitySqlQueryRelation, "entitySqlQueryRelation");
        queryRelation = entitySqlQueryRelation;
        this.factory = factory;
        this.sqlPageFactory = sqlPageFactory;
    }

    @Override
    public EntityQueryLimitExecutor<R> limit(Limit limit) {
        this.limit = limit;
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<R> list() {
        return new EntitySqlQueryExpression<R>(factory, sqlPageFactory, queryRelation).limit(limit).list();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public R single() {
        return new EntitySqlQueryExpression<R>(factory, sqlPageFactory, queryRelation).limit(limit).single();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public R unique() {
        return new EntitySqlQueryExpression<R>(factory, sqlPageFactory, queryRelation).limit(limit).unique();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PaginationResults<R> pagination() {
        return new EntitySqlQueryExpression<R>(factory, sqlPageFactory, queryRelation).limit(limit).pagination();
    }

    @Override
    public long count() {
        return new SqlQueryExpression(queryRelation.getJdbc(), sqlPageFactory,
                queryRelation.getBuilder().clearColumns().addColumn(AggregateFunction.COUNT, Chars.STAR),
                queryRelation.getIgnorePolicy()).longInt();
    }

    //    protected String getPropertyName(Serializable property) {
    //        return LambdaUtils.getLambdaPropertyName(property);
    //    }
}
