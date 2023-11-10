
package cn.featherfly.hammer.sqldb.jdbc.dsl.entity.query;

import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.common.function.FourArgusFunction;
import cn.featherfly.hammer.dsl.entity.query.EntityQueryConditionGroup4;
import cn.featherfly.hammer.dsl.entity.query.EntityQueryConditionGroupLogic4;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.entity.EntityWhereExpression4;
import cn.featherfly.hammer.expression.entity.condition.EntityConditionsGroupExpression;
import cn.featherfly.hammer.expression.entity.query.EntityQuerySortExpression4;
import cn.featherfly.hammer.expression.query.Sortable;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.EntitySqlQueryRelation;

/**
 * The Class AbstractEntitySqlQueryFetch4.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <E2> the generic type
 * @param <E3> the generic type
 * @param <E4> the generic type
 * @param <R>  the generic type
 */
public abstract class AbstractEntitySqlQueryFetch4<E, E2, E3, E4, R> extends AbstractEntitySqlQuery<R> implements
        EntityWhereExpression4<E, E2, E3, E4, EntityQueryConditionGroup4<E, E2, E3, E4, R>,
                EntityQueryConditionGroupLogic4<E, E2, E3, E4, R>>,
        Sortable<EntityQuerySortExpression4<E, E2, E3, E4, R>> {

    /**
     * Instantiates a new abstract entity sql query fetched.
     *
     * @param factory                the factory
     * @param sqlPageFactory         the sql page factory
     * @param entitySqlQueryRelation the entity sql query relation
     */
    protected AbstractEntitySqlQueryFetch4(JdbcMappingFactory factory, SqlPageFactory sqlPageFactory,
            EntitySqlQueryRelation entitySqlQueryRelation) {
        super(factory, sqlPageFactory, entitySqlQueryRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQueryConditionGroup4<E, E2, E3, E4, R> where() {
        return new EntitySqlQueryExpression4<>(factory, sqlPageFactory, queryRelation);
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
            FourArgusFunction<EntityConditionsGroupExpression<E, ?, ?>, EntityConditionsGroupExpression<E2, ?, ?>,
                    EntityConditionsGroupExpression<E3, ?, ?>, EntityConditionsGroupExpression<E4, ?, ?>,
                    LogicExpression<?, ?>> entityPropertyFuntion) {
        EntitySqlQueryExpression4<E, E2, E3, E4,
                R> exp = new EntitySqlQueryExpression4<>(factory, sqlPageFactory, queryRelation);
        if (entityPropertyFuntion != null) {
            exp.addCondition(entityPropertyFuntion.apply(
                    new EntitySqlQueryConditionsGroupExpression<>(0, factory, queryRelation),
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
        return new EntitySqlQueryExpression4<>(factory, sqlPageFactory, queryRelation);
    }

}
