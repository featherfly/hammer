
package cn.featherfly.hammer.sqldb.dsl.entity.query;

import java.util.function.Consumer;
import java.util.function.Function;

import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.hammer.config.HammerConfig;
import cn.featherfly.hammer.config.dsl.DslQueryConfig;
import cn.featherfly.hammer.dsl.entity.query.EntityQueryConditionGroup;
import cn.featherfly.hammer.dsl.entity.query.EntityQueryConditionGroupLogic;
import cn.featherfly.hammer.dsl.entity.query.EntityQueryFetchedProperties;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.entity.condition.EntityConditionsGroupExpression;
import cn.featherfly.hammer.expression.entity.query.EntityQueryLimitExecutor;
import cn.featherfly.hammer.expression.entity.query.EntityQuerySortExpression;
import cn.featherfly.hammer.sqldb.dsl.entity.EntitySqlQueryRelation;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;

/**
 * abstract entity sql query entity properties.
 *
 * @author zhongj
 * @param <E> the element type
 */
public class EntitySqlQueryFetchedProperties<E>
    extends AbstractEntitySqlQueryFetchedProperties<E, EntityQueryFetchedProperties<E>, EntityQueryLimitExecutor<E>>
    implements EntityQueryFetchedProperties<E> {

    /**
     * Instantiates a new entity sql query fetch.
     *
     * @param hammerConfig the hammer config
     * @param factory the factory
     * @param sqlPageFactory the sql page factory
     * @param entitySqlQueryRelation the entity sql query relation
     */
    public EntitySqlQueryFetchedProperties(HammerConfig hammerConfig, JdbcMappingFactory factory,
        SqlPageFactory sqlPageFactory, EntitySqlQueryRelation entitySqlQueryRelation) {
        super(hammerConfig, factory, sqlPageFactory, entitySqlQueryRelation);
    }

    /**
     * Instantiates a new entity sql query fetch.
     *
     * @param hammerConfig the hammer config
     * @param factory the factory
     * @param sqlPageFactory the sql page factory
     * @param entitySqlQueryRelation the entity sql query relation
     * @param properties the properties
     */
    public EntitySqlQueryFetchedProperties(HammerConfig hammerConfig, JdbcMappingFactory factory,
        SqlPageFactory sqlPageFactory, EntitySqlQueryRelation entitySqlQueryRelation,
        @SuppressWarnings("unchecked") SerializableFunction<E, ?>... properties) {
        super(hammerConfig, factory, sqlPageFactory, entitySqlQueryRelation);
        property(properties);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQueryConditionGroup<E> where() {
        return new EntitySqlQueryExpression<>(hammerConfig, factory, sqlPageFactory, queryRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQueryConditionGroupLogic<E> where(
        Function<EntityConditionsGroupExpression<E, ?, ?>, LogicExpression<?, ?>> function) {
        EntitySqlQueryExpression<
            E> exp = new EntitySqlQueryExpression<>(hammerConfig, factory, sqlPageFactory, queryRelation);
        if (function != null) {
            exp.addCondition(function.apply(new EntitySqlQueryConditionsGroupExpression<>(0, factory, queryRelation)));
        }
        return exp;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQuerySortExpression<E> sort() {
        return new EntitySqlQueryExpression<>(hammerConfig, factory, sqlPageFactory, queryRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQueryFetchedProperties<E> configure(Consumer<DslQueryConfig> configure) {
        if (configure != null) {
            configure.accept(queryRelation.getConfig());
        }
        return this;
    }
}
