
package cn.featherfly.hammer.sqldb.jdbc.dsl.entity.query;

import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.common.function.FiveArgusFunction;
import cn.featherfly.hammer.dsl.entity.query.EntityQueryConditionGroup5;
import cn.featherfly.hammer.dsl.entity.query.EntityQueryConditionGroupLogic5;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.entity.EntityWhereExpression5;
import cn.featherfly.hammer.expression.entity.condition.EntityConditionsGroupExpression;
import cn.featherfly.hammer.expression.entity.query.EntityQuerySortExpression5;
import cn.featherfly.hammer.expression.query.Sortable;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.EntitySqlQueryRelation;

/**
 * The Class AbstractEntitySqlQueryFetch5.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <E2> the generic type
 * @param <E3> the generic type
 * @param <E4> the generic type
 * @param <E5> the generic type
 * @param <R>  the generic type
 */
public abstract class AbstractEntitySqlQueryFetch5<E, E2, E3, E4, E5, R> extends AbstractEntitySqlQuery<R> implements
        EntityWhereExpression5<E, E2, E3, E4, E5, EntityQueryConditionGroup5<E, E2, E3, E4, E5, R>,
                EntityQueryConditionGroupLogic5<E, E2, E3, E4, E5, R>>,
        Sortable<EntityQuerySortExpression5<E, E2, E3, E4, E5, R>> {

    /**
     * Instantiates a new abstract entity sql query fetched.
     *
     * @param factory                the factory
     * @param sqlPageFactory         the sql page factory
     * @param entitySqlQueryRelation the entity sql query relation
     */
    protected AbstractEntitySqlQueryFetch5(JdbcMappingFactory factory, SqlPageFactory sqlPageFactory,
            EntitySqlQueryRelation entitySqlQueryRelation) {
        super(factory, sqlPageFactory, entitySqlQueryRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQueryConditionGroup5<E, E2, E3, E4, E5, R> where() {
        return new EntitySqlQueryExpression5<>(factory, sqlPageFactory, queryRelation);
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
                R> exp = new EntitySqlQueryExpression5<>(factory, sqlPageFactory, queryRelation);
        if (entityPropertyFuntion != null) {
            exp.addCondition(entityPropertyFuntion.apply(
                    new EntitySqlQueryConditionsGroupExpression<>(0, factory, queryRelation),
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
        return new EntitySqlQueryExpression5<>(factory, sqlPageFactory, queryRelation);
    }

}
