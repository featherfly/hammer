
package cn.featherfly.hammer.sqldb.dsl.entity.query;

import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.common.function.ThConsumer;
import cn.featherfly.common.function.ThFunction;
import cn.featherfly.hammer.config.HammerConfig;
import cn.featherfly.hammer.dsl.entity.query.EntityQueryConditionGroup3;
import cn.featherfly.hammer.dsl.entity.query.EntityQueryConditionGroupLogic3;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.entity.EntityWhereExpression3;
import cn.featherfly.hammer.expression.entity.condition.EntityConditionsGroupExpression;
import cn.featherfly.hammer.expression.entity.query.EntityQuerySortExpression3;
import cn.featherfly.hammer.expression.entity.query.EntityQuerySortedExpression3;
import cn.featherfly.hammer.expression.entity.query.EntitySortable3;
import cn.featherfly.hammer.expression.entity.query.sort.EntitySortExpression;
import cn.featherfly.hammer.expression.entity.query.sort.EntitySortedExpression;
import cn.featherfly.hammer.sqldb.dsl.entity.EntitySqlQueryRelation;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;

/**
 * The Class AbstractEntitySqlQueryFetch3.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <E2> the generic type
 * @param <E3> the generic type
 * @param <R> the generic type
 */
public abstract class AbstractEntitySqlQueryFetch3<E, E2, E3, R> extends AbstractEntitySqlQuery<R> implements
    EntityWhereExpression3<E, E2, E3, EntityQueryConditionGroup3<E, E2, E3, R>,
        EntityQueryConditionGroupLogic3<E, E2, E3, R>>,
    EntitySortable3<E, E2, E3, EntityQuerySortExpression3<E, E2, E3, R>, EntityQuerySortedExpression3<E, E2, E3, R>> {

    /**
     * Instantiates a new abstract entity sql query fetched.
     *
     * @param hammerConfig the hammer config
     * @param factory the factory
     * @param sqlPageFactory the sql page factory
     * @param entitySqlQueryRelation the entity sql query relation
     */
    protected AbstractEntitySqlQueryFetch3(HammerConfig hammerConfig, JdbcMappingFactory factory,
        SqlPageFactory sqlPageFactory, EntitySqlQueryRelation entitySqlQueryRelation) {
        super(hammerConfig, factory, sqlPageFactory, entitySqlQueryRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQueryConditionGroup3<E, E2, E3, R> where() {
        return new EntitySqlQueryExpression3<>(hammerConfig, factory, sqlPageFactory, queryRelation);
    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public EntityQueryConditionGroup3<E, E2, E3, R> where(Consumer<EntityQueryConditionGroup3<E, E2, E3, R>> consumer) {
    //        EntityQueryConditionGroup3<E, E2, E3,
    //                R> exp = new EntitySqlQueryExpression3<>(factory, sqlPageFactory, queryRelation);
    //        if (consumer != null) {
    //            consumer.accept(exp);
    //        }
    //        return exp;
    //    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQueryConditionGroupLogic3<E, E2, E3, R> where(
        ThFunction<EntityConditionsGroupExpression<E, ?, ?>, EntityConditionsGroupExpression<E2, ?, ?>,
            EntityConditionsGroupExpression<E3, ?, ?>, LogicExpression<?, ?>> entityPropertyFuntion) {
        EntitySqlQueryExpression3<E, E2, E3,
            R> exp = new EntitySqlQueryExpression3<>(hammerConfig, factory, sqlPageFactory, queryRelation);
        if (entityPropertyFuntion != null) {
            exp.addCondition(
                entityPropertyFuntion.apply(new EntitySqlQueryConditionsGroupExpression<>(0, factory, queryRelation),
                    new EntitySqlQueryConditionsGroupExpression<>(1, factory, queryRelation),
                    new EntitySqlQueryConditionsGroupExpression<>(2, factory, queryRelation)));
        }
        return exp;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQuerySortExpression3<E, E2, E3, R> sort() {
        return new EntitySqlQueryExpression3<>(hammerConfig, factory, sqlPageFactory, queryRelation);
    }

    @Override
    public <S1 extends EntitySortedExpression<E, S1>, S2 extends EntitySortedExpression<E2, S2>,
        S3 extends EntitySortedExpression<E3, S3>> EntityQuerySortedExpression3<E, E2, E3, R> sort(
            ThConsumer<EntitySortExpression<E, S1>, EntitySortExpression<E2, S2>,
                EntitySortExpression<E3, S3>> entitySortExpresions) {
        return new EntitySqlQueryExpression3<E, E2, E3, R>(hammerConfig, factory, sqlPageFactory, queryRelation)
            .sort(entitySortExpresions);
    }

}
