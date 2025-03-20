
package cn.featherfly.hammer.sqldb.dsl.entity.query;

import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.common.function.SiConsumer;
import cn.featherfly.common.function.SiFunction;
import cn.featherfly.hammer.config.HammerConfig;
import cn.featherfly.hammer.dsl.entity.query.EntityQueryConditionGroup6;
import cn.featherfly.hammer.dsl.entity.query.EntityQueryConditionGroupLogic6;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.entity.EntityWhereExpression6;
import cn.featherfly.hammer.expression.entity.condition.EntityConditionsGroupExpression;
import cn.featherfly.hammer.expression.entity.query.EntityQuerySortExpression6;
import cn.featherfly.hammer.expression.entity.query.EntityQuerySortedExpression6;
import cn.featherfly.hammer.expression.entity.query.EntitySortable6;
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
 * @param <E6> the generic type
 * @param <R> the generic type
 */
public abstract class AbstractEntitySqlQueryFetch6<E, E2, E3, E4, E5, E6, R> extends AbstractEntitySqlQuery<R>
    implements
    EntityWhereExpression6<E, E2, E3, E4, E5, E6, EntityQueryConditionGroup6<E, E2, E3, E4, E5, E6, R>,
        EntityQueryConditionGroupLogic6<E, E2, E3, E4, E5, E6, R>>,
    EntitySortable6<E, E2, E3, E4, E5, E6, EntityQuerySortExpression6<E, E2, E3, E4, E5, E6, R>,
        EntityQuerySortedExpression6<E, E2, E3, E4, E5, E6, R>> {

    /**
     * Instantiates a new abstract entity sql query fetched.
     *
     * @param hammerConfig the hammer config
     * @param factory the factory
     * @param sqlPageFactory the sql page factory
     * @param entitySqlQueryRelation the entity sql query relation
     */
    protected AbstractEntitySqlQueryFetch6(HammerConfig hammerConfig, JdbcMappingFactory factory,
        SqlPageFactory sqlPageFactory, EntitySqlQueryRelation entitySqlQueryRelation) {
        super(hammerConfig, factory, sqlPageFactory, entitySqlQueryRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQueryConditionGroup6<E, E2, E3, E4, E5, E6, R> where() {
        return new EntitySqlQueryExpression6<>(hammerConfig, factory, sqlPageFactory, queryRelation);
    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public EntityQueryConditionGroup6<E, E2, E3, E4, E5, E6, R> where(
    //            Consumer<EntityQueryConditionGroup6<E, E2, E3, E4, E5, E6, R>> consumer) {
    //        EntitySqlQueryExpression6<E, E2, E3, E4, E5, E6,
    //                R> exp = new EntitySqlQueryExpression6<>(factory, sqlPageFactory, queryRelation);
    //        if (consumer != null) {
    //            consumer.accept(exp);
    //        }
    //        return exp;
    //    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQueryConditionGroupLogic6<E, E2, E3, E4, E5, E6, R> where(
        SiFunction<EntityConditionsGroupExpression<E, ?, ?>, EntityConditionsGroupExpression<E2, ?, ?>,
            EntityConditionsGroupExpression<E3, ?, ?>, EntityConditionsGroupExpression<E4, ?, ?>,
            EntityConditionsGroupExpression<E5, ?, ?>, EntityConditionsGroupExpression<E6, ?, ?>,
            LogicExpression<?, ?>> entityPropertyFuntion) {
        EntitySqlQueryExpression6<E, E2, E3, E4, E5, E6,
            R> exp = new EntitySqlQueryExpression6<>(hammerConfig, factory, sqlPageFactory, queryRelation);
        if (entityPropertyFuntion != null) {
            exp.addCondition(
                entityPropertyFuntion.apply(new EntitySqlQueryConditionsGroupExpression<>(0, factory, queryRelation),
                    new EntitySqlQueryConditionsGroupExpression<>(1, factory, queryRelation),
                    new EntitySqlQueryConditionsGroupExpression<>(2, factory, queryRelation),
                    new EntitySqlQueryConditionsGroupExpression<>(3, factory, queryRelation),
                    new EntitySqlQueryConditionsGroupExpression<>(4, factory, queryRelation),
                    new EntitySqlQueryConditionsGroupExpression<>(5, factory, queryRelation)));
        }
        return exp;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQuerySortExpression6<E, E2, E3, E4, E5, E6, R> sort() {
        return new EntitySqlQueryExpression6<>(hammerConfig, factory, sqlPageFactory, queryRelation);
    }

    @Override
    public <S1 extends EntitySortedExpression<E, S1>, S2 extends EntitySortedExpression<E2, S2>,
        S3 extends EntitySortedExpression<E3, S3>, S4 extends EntitySortedExpression<E4, S4>,
        S5 extends EntitySortedExpression<E5, S5>,
        S6 extends EntitySortedExpression<E6, S6>> EntityQuerySortedExpression6<E, E2, E3, E4, E5, E6, R> sort(
            SiConsumer<EntitySortExpression<E, S1>, EntitySortExpression<E2, S2>, EntitySortExpression<E3, S3>,
                EntitySortExpression<E4, S4>, EntitySortExpression<E5, S5>,
                EntitySortExpression<E6, S6>> entitySortExpresions) {
        return new EntitySqlQueryExpression6<E, E2, E3, E4, E5, E6, R>(hammerConfig, factory, sqlPageFactory,
            queryRelation).sort(entitySortExpresions);
    }

}
