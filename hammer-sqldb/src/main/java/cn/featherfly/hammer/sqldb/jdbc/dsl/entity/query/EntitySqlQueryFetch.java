
package cn.featherfly.hammer.sqldb.jdbc.dsl.entity.query;

import java.util.function.Consumer;

import cn.featherfly.common.db.mapping.JdbcClassMapping;
import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.common.lang.function.SerializableFunction;
import cn.featherfly.common.operator.AggregateFunction;
import cn.featherfly.hammer.dsl.query.type.EntityQueryConditionGroup;
import cn.featherfly.hammer.dsl.query.type.EntityQueryFetch;
import cn.featherfly.hammer.dsl.query.type.EntityQueryFetchedProperty;
import cn.featherfly.hammer.expression.condition.ConditionGroupConfig;
import cn.featherfly.hammer.expression.entity.query.EntityQuerySortExpression;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.EntitySqlQueryRelation;

/**
 * The Class EntitySqlQueryFetch.
 *
 * @author zhongj
 * @param <E> the element type
 */
public class EntitySqlQueryFetch<E> extends AbstractEntitySqlQueryFetch<E, EntityQueryFetchedProperty<E>>
        implements EntityQueryFetch<E> {

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
    public EntityQueryConditionGroup<E> where(Consumer<ConditionGroupConfig<EntityQueryConditionGroup<E>>> consumer) {
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
    public <R> EntityQueryFetchedProperty<E> property(boolean distinct, SerializableFunction<E, R> propertyName) {
        return new EntitySqlQueryFetchedProperty<E>(factory, sqlPageFactory, queryRelation).property(distinct,
                propertyName);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQueryFetchedProperty<E> property(
            @SuppressWarnings("unchecked") SerializableFunction<E, ?>... propertyNames) {
        return new EntitySqlQueryFetchedProperty<E>(factory, sqlPageFactory, queryRelation).property(propertyNames);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> EntityQueryFetchedProperty<E> property(AggregateFunction aggregateFunction, boolean distinct,
            SerializableFunction<E, R> propertyName) {
        return new EntitySqlQueryFetchedProperty<E>(factory, sqlPageFactory, queryRelation).property(aggregateFunction,
                distinct, propertyName);
    }
}
