
package cn.featherfly.hammer.sqldb.dsl.entity.query;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.lang.LambdaUtils;
import cn.featherfly.common.lang.LambdaUtils.SerializedLambdaInfo;
import cn.featherfly.common.operator.AggregateFunction;
import cn.featherfly.hammer.config.HammerConfig;
import cn.featherfly.hammer.dsl.entity.query.EntityQueryFetchedProperties;
import cn.featherfly.hammer.dsl.entity.query.EntityQueryOneFetchedProperty;
import cn.featherfly.hammer.dsl.entity.query.EntityQueryValueConditionGroup;
import cn.featherfly.hammer.dsl.entity.query.EntityQueryValueConditionGroupLogic;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.entity.condition.EntityConditionsGroupExpression;
import cn.featherfly.hammer.expression.entity.query.EntityQueryValueLimitExecutor;
import cn.featherfly.hammer.expression.entity.query.EntityQueryValueSortExpression;
import cn.featherfly.hammer.sqldb.dsl.entity.EntitySqlQueryRelation;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;

/**
 * entity sql entity query fetched one property.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <V> the value type
 */
public class EntitySqlQueryFetchedOneProperty<E, V> extends
    AbstractEntitySqlQueryFetchedProperties<E, EntityQueryFetchedProperties<E>, EntityQueryValueLimitExecutor<E, V>>
    implements EntityQueryOneFetchedProperty<E, V> {
    private final Class<V> valueType;

    /**
     * Instantiates a new entity sql query fetched property.
     *
     * @param hammerConfig the hammer config
     * @param factory the factory
     * @param sqlPageFactory the sql page factory
     * @param entitySqlQueryRelation the entity sql query relation
     * @param property the property
     */
    public EntitySqlQueryFetchedOneProperty(HammerConfig hammerConfig, JdbcMappingFactory factory,
        SqlPageFactory sqlPageFactory, EntitySqlQueryRelation entitySqlQueryRelation,
        SerializableFunction<E, V> property) {
        this(hammerConfig, factory, sqlPageFactory, entitySqlQueryRelation, false, property);
    }

    /**
     * Instantiates a new entity sql query fetched property.
     *
     * @param hammerConfig the hammer config
     * @param factory the factory
     * @param sqlPageFactory the sql page factory
     * @param entitySqlQueryRelation the entity sql query relation
     * @param distinct the distinct
     * @param property the property
     */
    public EntitySqlQueryFetchedOneProperty(HammerConfig hammerConfig, JdbcMappingFactory factory,
        SqlPageFactory sqlPageFactory, EntitySqlQueryRelation entitySqlQueryRelation, boolean distinct,
        SerializableFunction<E, V> property) {
        this(hammerConfig, factory, sqlPageFactory, entitySqlQueryRelation, null, distinct, property);
    }

    /**
     * Instantiates a new entity sql query fetched property.
     *
     * @param hammerConfig the hammer config
     * @param factory the factory
     * @param sqlPageFactory the sql page factory
     * @param entitySqlQueryRelation the entity sql query relation
     * @param aggregateFunction the aggregate function
     * @param distinct the distinct
     * @param property the property
     */
    @SuppressWarnings("unchecked")
    public EntitySqlQueryFetchedOneProperty(HammerConfig hammerConfig, JdbcMappingFactory factory,
        SqlPageFactory sqlPageFactory, EntitySqlQueryRelation entitySqlQueryRelation,
        AggregateFunction aggregateFunction, boolean distinct, SerializableFunction<E, V> property) {
        super(hammerConfig, factory, sqlPageFactory, entitySqlQueryRelation);
        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(property);
        if (aggregateFunction != null) {
            property(aggregateFunction, distinct, property);
        } else {
            property(distinct, property);
        }
        valueType = (Class<V>) info.getPropertyType();
    }

    /**
     * Property.
     *
     * @param propertyNames the property names
     * @return the e
     */
    @Override
    public EntityQueryFetchedProperties<E> property(String... propertyNames) {
        return new EntitySqlQueryFetchedProperties<E>(hammerConfig, factory, sqlPageFactory, queryRelation)
            .property(propertyNames);
    }

    /**
     * Property.
     *
     * @param propertyNames the property names
     * @return the e
     */
    @Override
    public EntityQueryFetchedProperties<E> property(Collection<String> propertyNames) {
        return new EntitySqlQueryFetchedProperties<E>(hammerConfig, factory, sqlPageFactory, queryRelation)
            .property(propertyNames);
    }

    /**
     * Property.
     *
     * @param distinct the distinct
     * @param propertyName the property name
     * @return the e
     */
    @Override
    public EntityQueryFetchedProperties<E> property(boolean distinct, String propertyName) {
        return new EntitySqlQueryFetchedProperties<E>(hammerConfig, factory, sqlPageFactory, queryRelation)
            .property(distinct, propertyName);
    }

    /**
     * Property.
     *
     * @param aggregateFunction the aggregate function
     * @param distinct the distinct
     * @param propertyName the property name
     * @return the e
     */
    @Override
    public EntityQueryFetchedProperties<E> property(AggregateFunction aggregateFunction, boolean distinct,
        String propertyName) {
        return new EntitySqlQueryFetchedProperties<E>(hammerConfig, factory, sqlPageFactory, queryRelation)
            .property(aggregateFunction, distinct, propertyName);
    }

    /**
     * Property alias.
     *
     * @param columnName the column name
     * @param alias the alias
     * @return the e
     */
    @Override
    public EntityQueryFetchedProperties<E> propertyAlias(String columnName, String alias) {
        return new EntitySqlQueryFetchedProperties<E>(hammerConfig, factory, sqlPageFactory, queryRelation)
            .propertyAlias(columnName, alias);
    }

    /**
     * Property alias.
     *
     * @param columnNameMap the column name map
     * @return the e
     */
    @Override
    public EntityQueryFetchedProperties<E> propertyAlias(Map<String, String> columnNameMap) {
        return new EntitySqlQueryFetchedProperties<E>(hammerConfig, factory, sqlPageFactory, queryRelation)
            .propertyAlias(columnNameMap);
    }

    /**
     * Id.
     *
     * @param propertyName the property name
     * @return the e
     */
    @Override
    public EntityQueryFetchedProperties<E> id(String propertyName) {
        return new EntitySqlQueryFetchedProperties<E>(hammerConfig, factory, sqlPageFactory, queryRelation)
            .id(propertyName);
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
    public EntityQueryValueConditionGroupLogic<E, V> where(
        Function<EntityConditionsGroupExpression<E, ?, ?>, LogicExpression<?, ?>> function) {
        EntitySqlQueryValueExpression<E,
            V> exp = new EntitySqlQueryValueExpression<>(factory, sqlPageFactory, queryRelation, valueType);
        if (function != null) {
            exp.addCondition(function.apply(new EntitySqlQueryConditionsGroupExpression<>(0, factory, queryRelation)));
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

    /**
     * {@inheritDoc}
     */
    @Override
    public V value() {
        return new EntitySqlQueryValueExpression<E, V>(factory, sqlPageFactory, queryRelation, valueType).value();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<V> valueList() {
        return new EntitySqlQueryValueExpression<E, V>(factory, sqlPageFactory, queryRelation, valueType).valueList();
    }
}
