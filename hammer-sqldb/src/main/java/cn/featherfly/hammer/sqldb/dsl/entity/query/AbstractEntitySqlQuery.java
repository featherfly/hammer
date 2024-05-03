
package cn.featherfly.hammer.sqldb.dsl.entity.query;

import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.hammer.expression.entity.query.EntityQueryLimitExecutor;
import cn.featherfly.hammer.sqldb.dsl.entity.EntitySqlQueryRelation;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;

/**
 * abstract entity sql query entity properties.
 *
 * @author zhongj
 * @param <E> the element type
 */
public abstract class AbstractEntitySqlQuery<E> extends AbstractEntitySqlQueryBase<E, EntityQueryLimitExecutor<E>> {

    //    protected JdbcMappingFactory factory;
    //
    //    protected SqlPageFactory sqlPageFactory;
    //
    //    protected EntitySqlQueryRelation queryRelation;
    //
    //    /** The limit. */
    //    protected Limit limit;
    //
    /**
     * Instantiates a new abstract sql query entity properties.
     *
     * @param factory                the factory
     * @param sqlPageFactory         the sql page factory
     * @param entitySqlQueryRelation the entity sql query relation
     */
    protected AbstractEntitySqlQuery(JdbcMappingFactory factory, SqlPageFactory sqlPageFactory,
            EntitySqlQueryRelation entitySqlQueryRelation) {
        super(factory, sqlPageFactory, entitySqlQueryRelation);
    }
    //
    //    //    /**
    //    //     * Instantiates a new abstract sql query entity properties.
    //    //     *
    //    //     * @param <E>                    the element type
    //    //     * @param factory                the factory
    //    //     * @param sqlPageFactory         the sql page factory
    //    //     * @param entitySqlQueryRelation the entity sql query relation
    //    //     */
    //    //    protected AbstractEntitySqlQuery(JdbcMappingFactory factory, SqlPageFactory sqlPageFactory,
    //    //            EntitySqlQueryRelation entitySqlQueryRelation, Class<E> valueType) {
    //    //        AssertIllegalArgument.isNotNull(entitySqlQueryRelation, "entitySqlQueryRelation");
    //    //        queryRelation = entitySqlQueryRelation;
    //    //        this.factory = factory;
    //    //        this.sqlPageFactory = sqlPageFactory;
    //    //        //        this.valueType = valueType;
    //    //    }
    //
    //    @SuppressWarnings("unchecked")
    //    @Override
    //    public L limit(Limit limit) {
    //        this.limit = limit;
    //        return (L) this;
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public List<E> list() {
    //        return new EntitySqlQueryExpression<E>(factory, sqlPageFactory, queryRelation).limit(limit).list();
    //        //        if (valueType != null) {
    //        //            return new EntitySqlQueryValueExpression<>(factory, sqlPageFactory, queryRelation, valueType).limit(limit)
    //        //                    .list();
    //        //        } else {
    //        //            return new EntitySqlQueryExpression<V>(factory, sqlPageFactory, queryRelation).limit(limit).list();
    //        //        }
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public E single() {
    //        return new EntitySqlQueryExpression<E>(factory, sqlPageFactory, queryRelation).limit(limit).single();
    //        //        if (valueType != null) {
    //        //            return new EntitySqlQueryValueExpression<>(factory, sqlPageFactory, queryRelation, valueType).limit(limit)
    //        //                    .single();
    //        //        } else {
    //        //            return new EntitySqlQueryExpression<V>(factory, sqlPageFactory, queryRelation).limit(limit).single();
    //        //        }
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public E unique() {
    //        return new EntitySqlQueryExpression<E>(factory, sqlPageFactory, queryRelation).limit(limit).unique();
    //        //        if (valueType != null) {
    //        //            return new EntitySqlQueryValueExpression<>(factory, sqlPageFactory, queryRelation, valueType).limit(limit)
    //        //                    .unique();
    //        //        } else {
    //        //            return new EntitySqlQueryExpression<V>(factory, sqlPageFactory, queryRelation).limit(limit).unique();
    //        //        }
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public PaginationResults<E> pagination() {
    //        return new EntitySqlQueryExpression<E>(factory, sqlPageFactory, queryRelation).limit(limit).pagination();
    //        //        if (valueType != null) {
    //        //            return new EntitySqlQueryValueExpression<>(factory, sqlPageFactory, queryRelation, valueType).limit(limit)
    //        //                    .pagination();
    //        //        } else {
    //        //            return new EntitySqlQueryExpression<V>(factory, sqlPageFactory, queryRelation).limit(limit).pagination();
    //        //        }
    //    }
    //
    //    @Override
    //    public long count() {
    //        return new RepositorySqlQueryValueExpression(queryRelation.getJdbc(), sqlPageFactory,
    //                queryRelation.getBuilder().clearColumns().addColumn(AggregateFunction.COUNT, Chars.STAR),
    //                queryRelation.getConfig()).count();
    //    }
}
