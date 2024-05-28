
package cn.featherfly.hammer.sqldb.dsl.entity.query;

import java.util.function.BiFunction;

import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.hammer.config.HammerConfig;
import cn.featherfly.hammer.dsl.entity.query.EntityQueryConditionGroup2;
import cn.featherfly.hammer.dsl.entity.query.EntityQueryConditionGroupLogic2;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.entity.EntityWhereExpression2;
import cn.featherfly.hammer.expression.entity.condition.EntityConditionsGroupExpression;
import cn.featherfly.hammer.expression.entity.query.EntityQuerySortExpression2;
import cn.featherfly.hammer.expression.query.Sortable;
import cn.featherfly.hammer.sqldb.dsl.entity.EntitySqlQueryRelation;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;

/**
 * The Class AbstractEntitySqlQueryFetch2.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <E2> the generic type
 * @param <R> the generic type
 */
public abstract class AbstractEntitySqlQueryFetch2<E, E2, R> extends AbstractEntitySqlQuery<R> implements
    EntityWhereExpression2<E, E2, EntityQueryConditionGroup2<E, E2, R>, EntityQueryConditionGroupLogic2<E, E2, R>>,
    Sortable<EntityQuerySortExpression2<E, E2, R>> {

    /**
     * Instantiates a new abstract entity sql query fetched.
     *
     * @param hammerConfig the hammer config
     * @param factory the factory
     * @param sqlPageFactory the sql page factory
     * @param entitySqlQueryRelation the entity sql query relation
     */
    protected AbstractEntitySqlQueryFetch2(HammerConfig hammerConfig, JdbcMappingFactory factory,
        SqlPageFactory sqlPageFactory, EntitySqlQueryRelation entitySqlQueryRelation) {
        super(hammerConfig, factory, sqlPageFactory, entitySqlQueryRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQueryConditionGroup2<E, E2, R> where() {
        return new EntitySqlQueryExpression2<>(hammerConfig, factory, sqlPageFactory, queryRelation);
    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public EntityQueryConditionGroup2<E, E2, R> where(Consumer<EntityQueryConditionGroup2<E, E2, R>> consumer) {
    //        EntitySqlQueryExpression2<E, E2,
    //                R> exp = new EntitySqlQueryExpression2<>(factory, sqlPageFactory, queryRelation);
    //        if (consumer != null) {
    //            consumer.accept(exp);
    //        }
    //        return exp;
    //    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQueryConditionGroupLogic2<E, E2, R> where(BiFunction<EntityConditionsGroupExpression<E, ?, ?>,
        EntityConditionsGroupExpression<E2, ?, ?>, LogicExpression<?, ?>> entityPropertyFuntion) {
        EntitySqlQueryExpression2<E, E2,
            R> exp = new EntitySqlQueryExpression2<>(hammerConfig, factory, sqlPageFactory, queryRelation);
        if (entityPropertyFuntion != null) {
            exp.addCondition(
                entityPropertyFuntion.apply(new EntitySqlQueryConditionsGroupExpression<>(0, factory, queryRelation),
                    new EntitySqlQueryConditionsGroupExpression<>(1, factory, queryRelation)));
        }
        return exp;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQuerySortExpression2<E, E2, R> sort() {
        return new EntitySqlQueryExpression2<>(hammerConfig, factory, sqlPageFactory, queryRelation);
    }

    // ****************************************************************************************************************
    //	protected method
    // ****************************************************************************************************************

    //    protected void prepareJoin(int index, BiFunction<QueryEntityRepository<E>, QueryEntityRepository<E2>, ?> entities) {
    //        @SuppressWarnings("unchecked")
    //        EntityRelationMapping<E> erm = (EntityRelationMapping<E>) queryRelation.getEntityRelationMapping(0);
    //        @SuppressWarnings("unchecked")
    //        EntityRelationMapping<E2> erm2 = (EntityRelationMapping<E2>) queryRelation.getEntityRelationMapping(1);
    //
    //        QueryEntityRepository<?> qer = (QueryEntityRepository<?>) entities.apply(
    //                new QueryEntityRepository<>(0, erm.getClassMapping().getType()),
    //                new QueryEntityRepository<>(1, erm2.getClassMapping().getType()));
    //
    //        if (qer.getType() != queryRelation.getEntityRelationMapping(index).getClassMapping().getType()) {
    //            throw new SqldbHammerException("编译出错");
    //        }
    //    }
    //
    //    protected void prepareJoin(int index,
    //            Function<Tuple2<QueryEntityRepository<E>, QueryEntityRepository<E2>>, ?> entities) {
    //        @SuppressWarnings("unchecked")
    //        EntityRelationMapping<E> erm = (EntityRelationMapping<E>) queryRelation.getEntityRelationMapping(0);
    //        @SuppressWarnings("unchecked")
    //        EntityRelationMapping<E2> erm2 = (EntityRelationMapping<E2>) queryRelation.getEntityRelationMapping(1);
    //
    //        QueryEntityRepository<?> qer = (QueryEntityRepository<?>) entities
    //                .apply(Tuples.of(new QueryEntityRepository<>(0, erm.getClassMapping().getType()),
    //                        new QueryEntityRepository<>(1, erm2.getClassMapping().getType())));
    //
    //        if (qer.getType() != queryRelation.getEntityRelationMapping(index).getClassMapping().getType()) {
    //            throw new SqldbHammerException("编译出错");
    //        }
    //    }
}
