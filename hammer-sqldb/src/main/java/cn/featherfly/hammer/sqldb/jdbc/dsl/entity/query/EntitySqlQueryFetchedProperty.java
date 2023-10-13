
package cn.featherfly.hammer.sqldb.jdbc.dsl.entity.query;

import java.util.function.Consumer;

import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.lang.LambdaUtils;
import cn.featherfly.common.lang.LambdaUtils.SerializedLambdaInfo;
import cn.featherfly.common.operator.AggregateFunction;
import cn.featherfly.hammer.dsl.entity.query.EntityQueryFetchedProperties;
import cn.featherfly.hammer.dsl.entity.query.EntityQueryFetchedProperty;
import cn.featherfly.hammer.dsl.entity.query.EntityQueryValueConditionGroup;
import cn.featherfly.hammer.expression.condition.ConditionGroupConfig;
import cn.featherfly.hammer.expression.entity.query.EntityQueryValueSortExpression;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.EntitySqlQueryRelation;

/**
 * entity sql entity query fetched property.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <V> the value type
 */
public class EntitySqlQueryFetchedProperty<E, V>
        extends AbstractEntitySqlQueryFetchedProperties<E, V, EntityQueryFetchedProperties<E>>
        implements EntityQueryFetchedProperty<E, V> {

    /**
     * Instantiates a new entity sql query fetched property.
     *
     * @param factory                the factory
     * @param sqlPageFactory         the sql page factory
     * @param entitySqlQueryRelation the entity sql query relation
     * @param property               the property
     */
    public EntitySqlQueryFetchedProperty(JdbcMappingFactory factory, SqlPageFactory sqlPageFactory,
            EntitySqlQueryRelation entitySqlQueryRelation, SerializableFunction<E, V> property) {
        this(factory, sqlPageFactory, entitySqlQueryRelation, false, property);
    }

    /**
     * Instantiates a new entity sql query fetched property.
     *
     * @param factory                the factory
     * @param sqlPageFactory         the sql page factory
     * @param entitySqlQueryRelation the entity sql query relation
     * @param distinct               the distinct
     * @param property               the property
     */
    public EntitySqlQueryFetchedProperty(JdbcMappingFactory factory, SqlPageFactory sqlPageFactory,
            EntitySqlQueryRelation entitySqlQueryRelation, boolean distinct, SerializableFunction<E, V> property) {
        this(factory, sqlPageFactory, entitySqlQueryRelation, null, distinct, property);
    }

    /**
     * Instantiates a new entity sql query fetched property.
     *
     * @param factory                the factory
     * @param sqlPageFactory         the sql page factory
     * @param entitySqlQueryRelation the entity sql query relation
     * @param distinct               the distinct
     * @param aggregateFunction      the aggregate function
     * @param property               the property
     */
    @SuppressWarnings("unchecked")
    public EntitySqlQueryFetchedProperty(JdbcMappingFactory factory, SqlPageFactory sqlPageFactory,
            EntitySqlQueryRelation entitySqlQueryRelation, AggregateFunction aggregateFunction, boolean distinct,
            SerializableFunction<E, V> property) {
        super(factory, sqlPageFactory, entitySqlQueryRelation, null); // 下面手动设置valueType
        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(property);
        if (aggregateFunction != null) {
            property(aggregateFunction, distinct, property);
        } else {
            property(distinct, property);
        }
        valueType = (Class<V>) info.getPropertyType();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQueryValueConditionGroup<E, V> where() {
        return new EntitySqlQueryValueExpression<>(factory, sqlPageFactory, queryRelation, valueType);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQueryValueConditionGroup<E, V> where(
            Consumer<ConditionGroupConfig<EntityQueryValueConditionGroup<E, V>>> consumer) {
        EntitySqlQueryValueExpression<E,
                V> exp = new EntitySqlQueryValueExpression<>(factory, sqlPageFactory, queryRelation, valueType);
        if (consumer != null) {
            consumer.accept(exp);
        }
        return exp;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQueryValueSortExpression<E, V> sort() {
        return new EntitySqlQueryValueExpression<>(factory, sqlPageFactory, queryRelation, valueType);
    }
}
