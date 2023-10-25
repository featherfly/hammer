
package cn.featherfly.hammer.sqldb.jdbc.dsl.entity.query;

import java.util.function.Consumer;

import cn.featherfly.common.db.mapping.JdbcClassMapping;
import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.operator.AggregateFunction;
import cn.featherfly.hammer.config.dsl.QueryConfig;
import cn.featherfly.hammer.dsl.entity.query.EntityQueryConditionGroup;
import cn.featherfly.hammer.dsl.entity.query.EntityQueryConditionGroupLogic;
import cn.featherfly.hammer.dsl.entity.query.EntityQueryFetch;
import cn.featherfly.hammer.dsl.entity.query.EntityQueryFetchedProperties;
import cn.featherfly.hammer.dsl.entity.query.EntityQueryFetchedProperty;
import cn.featherfly.hammer.dsl.entity.query.EntityQueryOneFetchedProperty;
import cn.featherfly.hammer.expression.entity.query.EntityQueryExpression;
import cn.featherfly.hammer.expression.entity.query.EntityQuerySortExpression;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.EntitySqlQueryRelation;

/**
 * The Class EntitySqlQueryFetch.
 *
 * @author zhongj
 * @param <E> the element type
 */
public class EntitySqlQueryFetch<E> extends AbstractEntitySqlQueryFetch<E> implements EntityQueryFetch<E> {

    /**
     * Instantiates a new entity sql query fetch.
     *
     * @param factory                the factory
     * @param sqlPageFactory         the sql page factory
     * @param entitySqlQueryRelation the entity sql query relation
     * @param classMapping           the class mapping
     */
    public EntitySqlQueryFetch(JdbcMappingFactory factory, SqlPageFactory sqlPageFactory,
            EntitySqlQueryRelation entitySqlQueryRelation, JdbcClassMapping<E> classMapping) {
        super(factory, sqlPageFactory, entitySqlQueryRelation);
        // 第一个查询对象，自动获取（fetch）
        entitySqlQueryRelation.query(classMapping).fetch(0);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQueryConditionGroup<E> where() {
        return new EntitySqlQueryExpression<>(factory, sqlPageFactory, queryRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQueryConditionGroup<E> where(Consumer<EntityQueryConditionGroup<E>> consumer) {
        EntitySqlQueryExpression<E> exp = new EntitySqlQueryExpression<>(factory, sqlPageFactory, queryRelation);
        if (consumer != null) {
            consumer.accept(exp);
        }
        return exp;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQuerySortExpression<E> sort() {
        return new EntitySqlQueryExpression<>(factory, sqlPageFactory, queryRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQueryFetchedProperties<E> property(
            @SuppressWarnings("unchecked") SerializableFunction<E, ?>... propertyNames) {
        return new EntitySqlQueryFetchedProperties<>(factory, sqlPageFactory, queryRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <V> EntityQueryFetchedProperty<E, V> property(boolean distinct, SerializableFunction<E, V> propertyName) {
        return new EntitySqlQueryFetchedProperty<>(factory, sqlPageFactory, queryRelation, distinct, propertyName);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <V> EntityQueryOneFetchedProperty<E, V> property(AggregateFunction aggregateFunction, boolean distinct,
            SerializableFunction<E, V> propertyName) {
        return new EntitySqlQueryFetchedOneProperty<>(factory, sqlPageFactory, queryRelation, aggregateFunction,
                distinct, propertyName);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQueryExpression<E, EntityQueryConditionGroup<E>, EntityQueryConditionGroupLogic<E>,
            EntityQuerySortExpression<E>> configure(Consumer<QueryConfig> configure) {
        if (configure != null) {
            configure.accept(queryRelation.getConfig());
        }
        return this;
    }
}
