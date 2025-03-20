
package cn.featherfly.hammer.sqldb.dsl.entity.query;

import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.common.function.FoConsumer;
import cn.featherfly.common.function.FoFunction;
import cn.featherfly.hammer.config.HammerConfig;
import cn.featherfly.hammer.dsl.entity.query.EntityQueryConditionGroup4;
import cn.featherfly.hammer.dsl.entity.query.EntityQueryConditionGroupLogic4;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.entity.EntityWhereExpression4;
import cn.featherfly.hammer.expression.entity.condition.EntityConditionsGroupExpression;
import cn.featherfly.hammer.expression.entity.query.EntityQuerySortExpression4;
import cn.featherfly.hammer.expression.entity.query.EntityQuerySortedExpression4;
import cn.featherfly.hammer.expression.entity.query.EntitySortable4;
import cn.featherfly.hammer.expression.entity.query.sort.EntitySortExpression;
import cn.featherfly.hammer.expression.entity.query.sort.EntitySortedExpression;
import cn.featherfly.hammer.sqldb.dsl.entity.EntitySqlQueryRelation;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;

/**
 * The Class AbstractEntitySqlQueryFetch4.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <E2> the generic type
 * @param <E3> the generic type
 * @param <E4> the generic type
 * @param <R> the generic type
 */
public abstract class AbstractEntitySqlQueryFetch4<E, E2, E3, E4, R> extends AbstractEntitySqlQuery<R> implements
    EntityWhereExpression4<E, E2, E3, E4, EntityQueryConditionGroup4<E, E2, E3, E4, R>,
        EntityQueryConditionGroupLogic4<E, E2, E3, E4, R>>,
    EntitySortable4<E, E2, E3, E4, EntityQuerySortExpression4<E, E2, E3, E4, R>,
        EntityQuerySortedExpression4<E, E2, E3, E4, R>> {

    /**
     * Instantiates a new abstract entity sql query fetched.
     *
     * @param hammerConfig the hammer config
     * @param factory the factory
     * @param sqlPageFactory the sql page factory
     * @param entitySqlQueryRelation the entity sql query relation
     */
    protected AbstractEntitySqlQueryFetch4(HammerConfig hammerConfig, JdbcMappingFactory factory,
        SqlPageFactory sqlPageFactory, EntitySqlQueryRelation entitySqlQueryRelation) {
        super(hammerConfig, factory, sqlPageFactory, entitySqlQueryRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQueryConditionGroup4<E, E2, E3, E4, R> where() {
        return new EntitySqlQueryExpression4<>(hammerConfig, factory, sqlPageFactory, queryRelation);
    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public EntityQueryConditionGroup4<E, E2, E3, E4, R> where(
    //            Consumer<EntityQueryConditionGroup4<E, E2, E3, E4, R>> consumer) {
    //        EntitySqlQueryExpression4<E, E2, E3, E4,
    //                R> exp = new EntitySqlQueryExpression4<>(factory, sqlPageFactory, queryRelation);
    //        if (consumer != null) {
    //            consumer.accept(exp);
    //        }
    //        return exp;
    //    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQueryConditionGroupLogic4<E, E2, E3, E4, R> where(
        FoFunction<EntityConditionsGroupExpression<E, ?, ?>, EntityConditionsGroupExpression<E2, ?, ?>,
            EntityConditionsGroupExpression<E3, ?, ?>, EntityConditionsGroupExpression<E4, ?, ?>,
            LogicExpression<?, ?>> entityPropertyFuntion) {
        EntitySqlQueryExpression4<E, E2, E3, E4,
            R> exp = new EntitySqlQueryExpression4<>(hammerConfig, factory, sqlPageFactory, queryRelation);
        if (entityPropertyFuntion != null) {
            exp.addCondition(
                entityPropertyFuntion.apply(new EntitySqlQueryConditionsGroupExpression<>(0, factory, queryRelation),
                    new EntitySqlQueryConditionsGroupExpression<>(1, factory, queryRelation),
                    new EntitySqlQueryConditionsGroupExpression<>(2, factory, queryRelation),
                    new EntitySqlQueryConditionsGroupExpression<>(3, factory, queryRelation)));
        }
        return exp;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQuerySortExpression4<E, E2, E3, E4, R> sort() {
        return new EntitySqlQueryExpression4<>(hammerConfig, factory, sqlPageFactory, queryRelation);
    }

    @Override
    public <S1 extends EntitySortedExpression<E, S1>, S2 extends EntitySortedExpression<E2, S2>,
        S3 extends EntitySortedExpression<E3, S3>,
        S4 extends EntitySortedExpression<E4, S4>> EntityQuerySortedExpression4<E, E2, E3, E4, R> sort(
            FoConsumer<EntitySortExpression<E, S1>, EntitySortExpression<E2, S2>, EntitySortExpression<E3, S3>,
                EntitySortExpression<E4, S4>> entitySortExpresions) {
        return new EntitySqlQueryExpression4<E, E2, E3, E4, R>(hammerConfig, factory, sqlPageFactory, queryRelation)
            .sort(entitySortExpresions);
    }

}
