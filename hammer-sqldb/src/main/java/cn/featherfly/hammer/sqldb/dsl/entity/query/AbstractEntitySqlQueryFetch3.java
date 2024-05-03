
package cn.featherfly.hammer.sqldb.dsl.entity.query;

import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.common.function.ThreeArgusFunction;
import cn.featherfly.hammer.dsl.entity.query.EntityQueryConditionGroup3;
import cn.featherfly.hammer.dsl.entity.query.EntityQueryConditionGroupLogic3;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.entity.EntityWhereExpression3;
import cn.featherfly.hammer.expression.entity.condition.EntityConditionsGroupExpression;
import cn.featherfly.hammer.expression.entity.query.EntityQuerySortExpression3;
import cn.featherfly.hammer.expression.query.Sortable;
import cn.featherfly.hammer.sqldb.dsl.entity.EntitySqlQueryRelation;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;

/**
 * The Class AbstractEntitySqlQueryFetch3.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <E2> the generic type
 * @param <E3> the generic type
 * @param <R>  the generic type
 */
public abstract class AbstractEntitySqlQueryFetch3<E, E2, E3, R> extends AbstractEntitySqlQuery<R>
        implements EntityWhereExpression3<E, E2, E3, EntityQueryConditionGroup3<E, E2, E3, R>,
                EntityQueryConditionGroupLogic3<E, E2, E3, R>>,
        Sortable<EntityQuerySortExpression3<E, E2, E3, R>> {

    /**
     * Instantiates a new abstract entity sql query fetched.
     *
     * @param factory                the factory
     * @param sqlPageFactory         the sql page factory
     * @param entitySqlQueryRelation the entity sql query relation
     */
    protected AbstractEntitySqlQueryFetch3(JdbcMappingFactory factory, SqlPageFactory sqlPageFactory,
            EntitySqlQueryRelation entitySqlQueryRelation) {
        super(factory, sqlPageFactory, entitySqlQueryRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQueryConditionGroup3<E, E2, E3, R> where() {
        return new EntitySqlQueryExpression3<>(factory, sqlPageFactory, queryRelation);
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
            ThreeArgusFunction<EntityConditionsGroupExpression<E, ?, ?>, EntityConditionsGroupExpression<E2, ?, ?>,
                    EntityConditionsGroupExpression<E3, ?, ?>, LogicExpression<?, ?>> entityPropertyFuntion) {
        EntitySqlQueryExpression3<E, E2, E3,
                R> exp = new EntitySqlQueryExpression3<>(factory, sqlPageFactory, queryRelation);
        if (entityPropertyFuntion != null) {
            exp.addCondition(entityPropertyFuntion.apply(
                    new EntitySqlQueryConditionsGroupExpression<>(0, factory, queryRelation),
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
        return new EntitySqlQueryExpression3<>(factory, sqlPageFactory, queryRelation);
    }

}
