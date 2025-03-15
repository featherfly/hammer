
package cn.featherfly.hammer.sqldb.dsl.entity.query;

import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.common.function.FiveArgusConsumer;
import cn.featherfly.common.function.FiveArgusFunction;
import cn.featherfly.hammer.config.HammerConfig;
import cn.featherfly.hammer.dsl.entity.query.EntityQueryConditionGroup5;
import cn.featherfly.hammer.dsl.entity.query.EntityQueryConditionGroupLogic5;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.entity.EntityWhereExpression5;
import cn.featherfly.hammer.expression.entity.condition.EntityConditionsGroupExpression;
import cn.featherfly.hammer.expression.entity.query.EntityQuerySortExpression5;
import cn.featherfly.hammer.expression.entity.query.EntityQuerySortedExpression5;
import cn.featherfly.hammer.expression.entity.query.EntitySortable5;
import cn.featherfly.hammer.expression.entity.query.sort.EntitySortExpression;
import cn.featherfly.hammer.expression.entity.query.sort.EntitySortedExpression;
import cn.featherfly.hammer.sqldb.dsl.entity.EntitySqlQueryRelation;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;

/**
 * The Class AbstractEntitySqlQueryFetch5.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <E2> the generic type
 * @param <E3> the generic type
 * @param <E4> the generic type
 * @param <E5> the generic type
 * @param <R> the generic type
 */
public abstract class AbstractEntitySqlQueryFetch5<E, E2, E3, E4, E5, R> extends AbstractEntitySqlQuery<R> implements
    EntityWhereExpression5<E, E2, E3, E4, E5, EntityQueryConditionGroup5<E, E2, E3, E4, E5, R>,
        EntityQueryConditionGroupLogic5<E, E2, E3, E4, E5, R>>,
    EntitySortable5<E, E2, E3, E4, E5, EntityQuerySortExpression5<E, E2, E3, E4, E5, R>,
        EntityQuerySortedExpression5<E, E2, E3, E4, E5, R>> {

    /**
     * Instantiates a new abstract entity sql query fetched.
     *
     * @param hammerConfig the hammer config
     * @param factory the factory
     * @param sqlPageFactory the sql page factory
     * @param entitySqlQueryRelation the entity sql query relation
     */
    protected AbstractEntitySqlQueryFetch5(HammerConfig hammerConfig, JdbcMappingFactory factory,
        SqlPageFactory sqlPageFactory, EntitySqlQueryRelation entitySqlQueryRelation) {
        super(hammerConfig, factory, sqlPageFactory, entitySqlQueryRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQueryConditionGroup5<E, E2, E3, E4, E5, R> where() {
        return new EntitySqlQueryExpression5<>(hammerConfig, factory, sqlPageFactory, queryRelation);
    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public EntityQueryConditionGroup5<E, E2, E3, E4, E5, R> where(
    //            Consumer<EntityQueryConditionGroup5<E, E2, E3, E4, E5, R>> consumer) {
    //        EntitySqlQueryExpression5<E, E2, E3, E4, E5,
    //                R> exp = new EntitySqlQueryExpression5<>(factory, sqlPageFactory, queryRelation);
    //        if (consumer != null) {
    //            consumer.accept(exp);
    //        }
    //        return exp;
    //    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQueryConditionGroupLogic5<E, E2, E3, E4, E5, R> where(
        FiveArgusFunction<EntityConditionsGroupExpression<E, ?, ?>, EntityConditionsGroupExpression<E2, ?, ?>,
            EntityConditionsGroupExpression<E3, ?, ?>, EntityConditionsGroupExpression<E4, ?, ?>,
            EntityConditionsGroupExpression<E5, ?, ?>, LogicExpression<?, ?>> entityPropertyFuntion) {
        EntitySqlQueryExpression5<E, E2, E3, E4, E5,
            R> exp = new EntitySqlQueryExpression5<>(hammerConfig, factory, sqlPageFactory, queryRelation);
        if (entityPropertyFuntion != null) {
            exp.addCondition(
                entityPropertyFuntion.apply(new EntitySqlQueryConditionsGroupExpression<>(0, factory, queryRelation),
                    new EntitySqlQueryConditionsGroupExpression<>(1, factory, queryRelation),
                    new EntitySqlQueryConditionsGroupExpression<>(2, factory, queryRelation),
                    new EntitySqlQueryConditionsGroupExpression<>(3, factory, queryRelation),
                    new EntitySqlQueryConditionsGroupExpression<>(4, factory, queryRelation)));
        }
        return exp;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQuerySortExpression5<E, E2, E3, E4, E5, R> sort() {
        return new EntitySqlQueryExpression5<>(hammerConfig, factory, sqlPageFactory, queryRelation);
    }

    @Override
    public <S1 extends EntitySortedExpression<E, S1>, S2 extends EntitySortedExpression<E2, S2>,
        S3 extends EntitySortedExpression<E3, S3>, S4 extends EntitySortedExpression<E4, S4>,
        S5 extends EntitySortedExpression<E5, S5>> EntityQuerySortedExpression5<E, E2, E3, E4, E5, R> sort(
            FiveArgusConsumer<EntitySortExpression<E, S1>, EntitySortExpression<E2, S2>, EntitySortExpression<E3, S3>,
                EntitySortExpression<E4, S4>, EntitySortExpression<E5, S5>> entitySortExpresions) {
        return new EntitySqlQueryExpression5<E, E2, E3, E4, E5, R>(hammerConfig, factory, sqlPageFactory, queryRelation)
            .sort(entitySortExpresions);
    }

}
