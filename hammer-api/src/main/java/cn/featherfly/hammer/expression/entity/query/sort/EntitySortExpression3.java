package cn.featherfly.hammer.expression.entity.query.sort;

import cn.featherfly.common.function.ThreeArgusConsumer;

/**
 * 排序构建接口.
 *
 * @author zhongj
 * @param <E>  the entity type
 * @param <E2> the generic type
 * @param <E3> the generic type
 * @param <S>  the EntitySortExpression type
 */
public interface EntitySortExpression3<E, E2, E3, S extends EntitySortedExpression3<E, E2, E3, S>>
        extends EntitySortExpressionBase3<E, E2, E3, S> {

    /**
     * asc.
     *
     * @param sortEntityExpressions the sort entity expressions
     * @return the LogicExpression
     */
    S asc(ThreeArgusConsumer<EntitySetSortPropertyExpression<E>, EntitySetSortPropertyExpression<E2>,
            EntitySetSortPropertyExpression<E3>> sortEntityExpressions);

    /**
     * desc.
     *
     * @param sortEntityExpressions the sort entity expressions
     * @return the LogicExpression
     */
    S desc(ThreeArgusConsumer<EntitySetSortPropertyExpression<E>, EntitySetSortPropertyExpression<E2>,
            EntitySetSortPropertyExpression<E3>> sortEntityExpressions);

    //    /**
    //     * add ascending order value. 添加升序条件.
    //     *
    //     * @param <R>      the generic type
    //     * @param entities the entities
    //     * @param name     名称
    //     * @return this
    //     */
    //    <R> S asc(Function<Tuple3<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>>,
    //            QueryEntityRepository<E>> entities, SerializableFunction<E, R> name);
    //
    //    /**
    //     * add ascending order value. 添加升序条件.
    //     *
    //     * @param entities the entities
    //     * @param names    名称
    //     * @return this
    //     */
    //    S asc(Function<Tuple3<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>>,
    //            QueryEntityRepository<E>> entities, @SuppressWarnings("unchecked") SerializableFunction<E, ?>... names);
    //
    //    /**
    //     * add ascending order value. 添加升序条件.
    //     *
    //     * @param <R>      the generic type
    //     * @param entities the entities
    //     * @param name     名称
    //     * @return this
    //     */
    //    <R> S asc(Function<Tuple3<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>>,
    //            QueryEntityRepository<E2>> entities, SerializableFunction1<E2, R> name);
    //
    //    /**
    //     * add ascending order value. 添加升序条件.
    //     *
    //     * @param entities the entities
    //     * @param names    名称
    //     * @return this
    //     */
    //    S asc(Function<Tuple3<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>>,
    //            QueryEntityRepository<E2>> entities, @SuppressWarnings("unchecked") SerializableFunction1<E2, ?>... names);
    //
    //    /**
    //     * add ascending order value. 添加升序条件.
    //     *
    //     * @param <R>      the generic type
    //     * @param entities the entities
    //     * @param name     名称
    //     * @return this
    //     */
    //    <R> S asc(Function<Tuple3<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>>,
    //            QueryEntityRepository<E3>> entities, SerializableFunction2<E3, R> name);
    //
    //    /**
    //     * add ascending order value. 添加升序条件.
    //     *
    //     * @param entities the entities
    //     * @param names    名称
    //     * @return this
    //     */
    //    S asc(Function<Tuple3<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>>,
    //            QueryEntityRepository<E3>> entities, @SuppressWarnings("unchecked") SerializableFunction2<E3, ?>... names);
    //
    //    /**
    //     * add descending order value. 添加降序条件.
    //     *
    //     * @param <R>      the generic type
    //     * @param entities the entities
    //     * @param name     名称
    //     * @return this
    //     */
    //    <R> S desc(Function<Tuple3<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>>,
    //            QueryEntityRepository<E>> entities, SerializableFunction<E, R> name);
    //
    //    /**
    //     * add descending order value. 添加降序条件.
    //     *
    //     * @param entities the entities
    //     * @param names    名称
    //     * @return this
    //     */
    //    S desc(Function<Tuple3<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>>,
    //            QueryEntityRepository<E>> entities, @SuppressWarnings("unchecked") SerializableFunction<E, ?>... names);
    //
    //    /**
    //     * add descending order value. 添加降序条件.
    //     *
    //     * @param <R>      the generic type
    //     * @param entities the entities
    //     * @param name     名称
    //     * @return this
    //     */
    //    <R> S desc(Function<Tuple3<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>>,
    //            QueryEntityRepository<E2>> entities, SerializableFunction1<E2, R> name);
    //
    //    /**
    //     * add descending order value. 添加降序条件.
    //     *
    //     * @param entities the entities
    //     * @param names    名称
    //     * @return this
    //     */
    //    S desc(Function<Tuple3<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>>,
    //            QueryEntityRepository<E2>> entities, @SuppressWarnings("unchecked") SerializableFunction1<E2, ?>... names);
    //
    //    /**
    //     * add descending order value. 添加降序条件.
    //     *
    //     * @param <R>      the generic type
    //     * @param entities the entities
    //     * @param name     名称
    //     * @return this
    //     */
    //    <R> S desc(Function<Tuple3<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>>,
    //            QueryEntityRepository<E3>> entities, SerializableFunction2<E3, R> name);
    //
    //    /**
    //     * add descending order value. 添加降序条件.
    //     *
    //     * @param entities the entities
    //     * @param names    名称
    //     * @return this
    //     */
    //    S desc(Function<Tuple3<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>>,
    //            QueryEntityRepository<E3>> entities, @SuppressWarnings("unchecked") SerializableFunction2<E3, ?>... names);

}