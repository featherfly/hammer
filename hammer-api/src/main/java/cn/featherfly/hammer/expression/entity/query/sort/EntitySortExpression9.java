package cn.featherfly.hammer.expression.entity.query.sort;

/**
 * 排序构建接口.
 *
 * @author zhongj
 * @param <E>  the entity type
 * @param <E2> the generic type
 * @param <E3> the generic type
 * @param <E4> the generic type
 * @param <E5> the generic type
 * @param <E6> the generic type
 * @param <E7> the generic type
 * @param <E8> the generic type
 * @param <E9> the generic type
 * @param <S>  the EntitySortExpression type
 */
public interface EntitySortExpression9<E, E2, E3, E4, E5, E6, E7, E8, E9,
        S extends EntitySortedExpression9<E, E2, E3, E4, E5, E6, E7, E8, E9, S>> extends EntitySortExpression<E, S> {

    //    /**
    //     * add ascending order value. 添加升序条件.
    //     *
    //     * @param <R>      the generic type
    //     * @param entities the entities
    //     * @param name     名称
    //     * @return this
    //     */
    //    <R> S asc(Function<
    //            Tuple9<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                    QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>,
    //                    QueryEntityRepository<E7>, QueryEntityRepository<E8>, QueryEntityRepository<E9>>,
    //            QueryEntityRepository<E>> entities, SerializableFunction<E, R> name);
    //
    //    /**
    //     * add ascending order value. 添加升序条件.
    //     *
    //     * @param <R>      the generic type
    //     * @param entities the entities
    //     * @param names    名称
    //     * @return this
    //     */
    //    <R> S asc(
    //            Function<
    //                    Tuple9<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                            QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>,
    //                            QueryEntityRepository<E7>, QueryEntityRepository<E8>, QueryEntityRepository<E9>>,
    //                    QueryEntityRepository<E>> entities,
    //            @SuppressWarnings("unchecked") SerializableFunction<E, R>... names);
    //
    //    /**
    //     * add ascending order value. 添加升序条件.
    //     *
    //     * @param <R>      the generic type
    //     * @param entities the entities
    //     * @param name     名称
    //     * @return this
    //     */
    //    <R> S asc(Function<
    //            Tuple9<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                    QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>,
    //                    QueryEntityRepository<E7>, QueryEntityRepository<E8>, QueryEntityRepository<E9>>,
    //            QueryEntityRepository<E2>> entities, SerializableFunction1<E2, R> name);
    //
    //    /**
    //     * add ascending order value. 添加升序条件.
    //     *
    //     * @param <R>      the generic type
    //     * @param entities the entities
    //     * @param names    名称
    //     * @return this
    //     */
    //    <R> S asc(
    //            Function<
    //                    Tuple9<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                            QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>,
    //                            QueryEntityRepository<E7>, QueryEntityRepository<E8>, QueryEntityRepository<E9>>,
    //                    QueryEntityRepository<E2>> entities,
    //            @SuppressWarnings("unchecked") SerializableFunction1<E2, R>... names);
    //
    //    /**
    //     * add ascending order value. 添加升序条件.
    //     *
    //     * @param <R>      the generic type
    //     * @param entities the entities
    //     * @param name     名称
    //     * @return this
    //     */
    //    <R> S asc(Function<
    //            Tuple9<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                    QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>,
    //                    QueryEntityRepository<E7>, QueryEntityRepository<E8>, QueryEntityRepository<E9>>,
    //            QueryEntityRepository<E3>> entities, SerializableFunction2<E3, R> name);
    //
    //    /**
    //     * add ascending order value. 添加升序条件.
    //     *
    //     * @param <R>      the generic type
    //     * @param entities the entities
    //     * @param names    名称
    //     * @return this
    //     */
    //    <R> S asc(
    //            Function<
    //                    Tuple9<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                            QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>,
    //                            QueryEntityRepository<E7>, QueryEntityRepository<E8>, QueryEntityRepository<E9>>,
    //                    QueryEntityRepository<E3>> entities,
    //            @SuppressWarnings("unchecked") SerializableFunction2<E3, R>... names);
    //
    //    /**
    //     * add ascending order value. 添加升序条件.
    //     *
    //     * @param <R>      the generic type
    //     * @param entities the entities
    //     * @param name     名称
    //     * @return this
    //     */
    //    <R> S asc(Function<
    //            Tuple9<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                    QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>,
    //                    QueryEntityRepository<E7>, QueryEntityRepository<E8>, QueryEntityRepository<E9>>,
    //            QueryEntityRepository<E4>> entities, SerializableFunction3<E4, R> name);
    //
    //    /**
    //     * add ascending order value. 添加升序条件.
    //     *
    //     * @param <R>      the generic type
    //     * @param entities the entities
    //     * @param names    名称
    //     * @return this
    //     */
    //    <R> S asc(
    //            Function<
    //                    Tuple9<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                            QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>,
    //                            QueryEntityRepository<E7>, QueryEntityRepository<E8>, QueryEntityRepository<E9>>,
    //                    QueryEntityRepository<E4>> entities,
    //            @SuppressWarnings("unchecked") SerializableFunction3<E4, R>... names);
    //
    //    /**
    //     * add ascending order value. 添加升序条件.
    //     *
    //     * @param <R>      the generic type
    //     * @param entities the entities
    //     * @param name     名称
    //     * @return this
    //     */
    //    <R> S asc(Function<
    //            Tuple9<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                    QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>,
    //                    QueryEntityRepository<E7>, QueryEntityRepository<E8>, QueryEntityRepository<E9>>,
    //            QueryEntityRepository<E5>> entities, SerializableFunction4<E5, R> name);
    //
    //    /**
    //     * add ascending order value. 添加升序条件.
    //     *
    //     * @param <R>      the generic type
    //     * @param entities the entities
    //     * @param names    名称
    //     * @return this
    //     */
    //    <R> S asc(
    //            Function<
    //                    Tuple9<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                            QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>,
    //                            QueryEntityRepository<E7>, QueryEntityRepository<E8>, QueryEntityRepository<E9>>,
    //                    QueryEntityRepository<E5>> entities,
    //            @SuppressWarnings("unchecked") SerializableFunction4<E5, R>... names);
    //
    //    /**
    //     * add ascending order value. 添加升序条件.
    //     *
    //     * @param <R>      the generic type
    //     * @param entities the entities
    //     * @param name     名称
    //     * @return this
    //     */
    //    <R> S asc(Function<
    //            Tuple9<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                    QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>,
    //                    QueryEntityRepository<E7>, QueryEntityRepository<E8>, QueryEntityRepository<E9>>,
    //            QueryEntityRepository<E6>> entities, SerializableFunction5<E6, R> name);
    //
    //    /**
    //     * add ascending order value. 添加升序条件.
    //     *
    //     * @param <R>      the generic type
    //     * @param entities the entities
    //     * @param names    名称
    //     * @return this
    //     */
    //    <R> S asc(
    //            Function<
    //                    Tuple9<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                            QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>,
    //                            QueryEntityRepository<E7>, QueryEntityRepository<E8>, QueryEntityRepository<E9>>,
    //                    QueryEntityRepository<E6>> entities,
    //            @SuppressWarnings("unchecked") SerializableFunction5<E6, R>... names);
    //
    //    /**
    //     * add ascending order value. 添加升序条件.
    //     *
    //     * @param <R>      the generic type
    //     * @param entities the entities
    //     * @param name     名称
    //     * @return this
    //     */
    //    <R> S asc(Function<
    //            Tuple9<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                    QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>,
    //                    QueryEntityRepository<E7>, QueryEntityRepository<E8>, QueryEntityRepository<E9>>,
    //            QueryEntityRepository<E7>> entities, SerializableFunction6<E7, R> name);
    //
    //    /**
    //     * add ascending order value. 添加升序条件.
    //     *
    //     * @param <R>      the generic type
    //     * @param entities the entities
    //     * @param names    名称
    //     * @return this
    //     */
    //    <R> S asc(
    //            Function<
    //                    Tuple9<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                            QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>,
    //                            QueryEntityRepository<E7>, QueryEntityRepository<E8>, QueryEntityRepository<E9>>,
    //                    QueryEntityRepository<E7>> entities,
    //            @SuppressWarnings("unchecked") SerializableFunction6<E7, R>... names);
    //
    //    /**
    //     * add ascending order value. 添加升序条件.
    //     *
    //     * @param <R>      the generic type
    //     * @param entities the entities
    //     * @param name     名称
    //     * @return this
    //     */
    //    <R> S asc(Function<
    //            Tuple9<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                    QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>,
    //                    QueryEntityRepository<E7>, QueryEntityRepository<E8>, QueryEntityRepository<E9>>,
    //            QueryEntityRepository<E8>> entities, SerializableFunction7<E8, R> name);
    //
    //    /**
    //     * add ascending order value. 添加升序条件.
    //     *
    //     * @param <R>      the generic type
    //     * @param entities the entities
    //     * @param names    名称
    //     * @return this
    //     */
    //    <R> S asc(
    //            Function<
    //                    Tuple9<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                            QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>,
    //                            QueryEntityRepository<E7>, QueryEntityRepository<E8>, QueryEntityRepository<E9>>,
    //                    QueryEntityRepository<E8>> entities,
    //            @SuppressWarnings("unchecked") SerializableFunction7<E8, R>... names);
    //
    //    /**
    //     * add ascending order value. 添加升序条件.
    //     *
    //     * @param <R>      the generic type
    //     * @param entities the entities
    //     * @param name     名称
    //     * @return this
    //     */
    //    <R> S asc(Function<
    //            Tuple9<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                    QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>,
    //                    QueryEntityRepository<E7>, QueryEntityRepository<E8>, QueryEntityRepository<E9>>,
    //            QueryEntityRepository<E9>> entities, SerializableFunction8<E9, R> name);
    //
    //    /**
    //     * add ascending order value. 添加升序条件.
    //     *
    //     * @param <R>      the generic type
    //     * @param entities the entities
    //     * @param names    名称
    //     * @return this
    //     */
    //    <R> S asc(
    //            Function<
    //                    Tuple9<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                            QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>,
    //                            QueryEntityRepository<E7>, QueryEntityRepository<E8>, QueryEntityRepository<E9>>,
    //                    QueryEntityRepository<E9>> entities,
    //            @SuppressWarnings("unchecked") SerializableFunction8<E9, R>... names);
    //
    //    /**
    //     * add descending order value. 添加降序条件.
    //     *
    //     * @param <R>      the generic type
    //     * @param entities the entities
    //     * @param name     名称
    //     * @return this
    //     */
    //    <R> S desc(Function<
    //            Tuple9<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                    QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>,
    //                    QueryEntityRepository<E7>, QueryEntityRepository<E8>, QueryEntityRepository<E9>>,
    //            QueryEntityRepository<E>> entities, SerializableFunction<E, R> name);
    //
    //    /**
    //     * add descending order value. 添加降序条件.
    //     *
    //     * @param <R>      the generic type
    //     * @param entities the entities
    //     * @param names    名称
    //     * @return this
    //     */
    //    <R> S desc(
    //            Function<
    //                    Tuple9<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                            QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>,
    //                            QueryEntityRepository<E7>, QueryEntityRepository<E8>, QueryEntityRepository<E9>>,
    //                    QueryEntityRepository<E>> entities,
    //            @SuppressWarnings("unchecked") SerializableFunction<E, R>... names);
    //
    //    /**
    //     * add descending order value. 添加降序条件.
    //     *
    //     * @param <R>      the generic type
    //     * @param entities the entities
    //     * @param name     名称
    //     * @return this
    //     */
    //    <R> S desc(Function<
    //            Tuple9<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                    QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>,
    //                    QueryEntityRepository<E7>, QueryEntityRepository<E8>, QueryEntityRepository<E9>>,
    //            QueryEntityRepository<E2>> entities, SerializableFunction1<E2, R> name);
    //
    //    /**
    //     * add descending order value. 添加降序条件.
    //     *
    //     * @param <R>      the generic type
    //     * @param entities the entities
    //     * @param names    名称
    //     * @return this
    //     */
    //    <R> S desc(
    //            Function<
    //                    Tuple9<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                            QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>,
    //                            QueryEntityRepository<E7>, QueryEntityRepository<E8>, QueryEntityRepository<E9>>,
    //                    QueryEntityRepository<E2>> entities,
    //            @SuppressWarnings("unchecked") SerializableFunction1<E2, R>... names);
    //
    //    /**
    //     * add descending order value. 添加降序条件.
    //     *
    //     * @param <R>      the generic type
    //     * @param entities the entities
    //     * @param name     名称
    //     * @return this
    //     */
    //    <R> S desc(Function<
    //            Tuple9<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                    QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>,
    //                    QueryEntityRepository<E7>, QueryEntityRepository<E8>, QueryEntityRepository<E9>>,
    //            QueryEntityRepository<E3>> entities, SerializableFunction2<E3, R> name);
    //
    //    /**
    //     * add descending order value. 添加降序条件.
    //     *
    //     * @param <R>      the generic type
    //     * @param entities the entities
    //     * @param names    名称
    //     * @return this
    //     */
    //    <R> S desc(
    //            Function<
    //                    Tuple9<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                            QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>,
    //                            QueryEntityRepository<E7>, QueryEntityRepository<E8>, QueryEntityRepository<E9>>,
    //                    QueryEntityRepository<E3>> entities,
    //            @SuppressWarnings("unchecked") SerializableFunction2<E3, R>... names);
    //
    //    /**
    //     * add descending order value. 添加降序条件.
    //     *
    //     * @param <R>      the generic type
    //     * @param entities the entities
    //     * @param name     名称
    //     * @return this
    //     */
    //    <R> S desc(Function<
    //            Tuple9<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                    QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>,
    //                    QueryEntityRepository<E7>, QueryEntityRepository<E8>, QueryEntityRepository<E9>>,
    //            QueryEntityRepository<E4>> entities, SerializableFunction3<E4, R> name);
    //
    //    /**
    //     * add descending order value. 添加降序条件.
    //     *
    //     * @param <R>      the generic type
    //     * @param entities the entities
    //     * @param names    名称
    //     * @return this
    //     */
    //    <R> S desc(
    //            Function<
    //                    Tuple9<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                            QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>,
    //                            QueryEntityRepository<E7>, QueryEntityRepository<E8>, QueryEntityRepository<E9>>,
    //                    QueryEntityRepository<E4>> entities,
    //            @SuppressWarnings("unchecked") SerializableFunction3<E4, R>... names);
    //
    //    /**
    //     * add descending order value. 添加降序条件.
    //     *
    //     * @param <R>      the generic type
    //     * @param entities the entities
    //     * @param name     名称
    //     * @return this
    //     */
    //    <R> S desc(Function<
    //            Tuple9<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                    QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>,
    //                    QueryEntityRepository<E7>, QueryEntityRepository<E8>, QueryEntityRepository<E9>>,
    //            QueryEntityRepository<E5>> entities, SerializableFunction4<E5, R> name);
    //
    //    /**
    //     * add descending order value. 添加降序条件.
    //     *
    //     * @param <R>      the generic type
    //     * @param entities the entities
    //     * @param names    名称
    //     * @return this
    //     */
    //    <R> S desc(
    //            Function<
    //                    Tuple9<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                            QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>,
    //                            QueryEntityRepository<E7>, QueryEntityRepository<E8>, QueryEntityRepository<E9>>,
    //                    QueryEntityRepository<E5>> entities,
    //            @SuppressWarnings("unchecked") SerializableFunction4<E5, R>... names);
    //
    //    /**
    //     * add descending order value. 添加降序条件.
    //     *
    //     * @param <R>      the generic type
    //     * @param entities the entities
    //     * @param name     名称
    //     * @return this
    //     */
    //    <R> S desc(Function<
    //            Tuple9<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                    QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>,
    //                    QueryEntityRepository<E7>, QueryEntityRepository<E8>, QueryEntityRepository<E9>>,
    //            QueryEntityRepository<E6>> entities, SerializableFunction5<E6, R> name);
    //
    //    /**
    //     * add descending order value. 添加降序条件.
    //     *
    //     * @param <R>      the generic type
    //     * @param entities the entities
    //     * @param names    名称
    //     * @return this
    //     */
    //    <R> S desc(
    //            Function<
    //                    Tuple9<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                            QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>,
    //                            QueryEntityRepository<E7>, QueryEntityRepository<E8>, QueryEntityRepository<E9>>,
    //                    QueryEntityRepository<E6>> entities,
    //            @SuppressWarnings("unchecked") SerializableFunction5<E6, R>... names);
    //
    //    /**
    //     * add descending order value. 添加降序条件.
    //     *
    //     * @param <R>      the generic type
    //     * @param entities the entities
    //     * @param name     名称
    //     * @return this
    //     */
    //    <R> S desc(Function<
    //            Tuple9<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                    QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>,
    //                    QueryEntityRepository<E7>, QueryEntityRepository<E8>, QueryEntityRepository<E9>>,
    //            QueryEntityRepository<E7>> entities, SerializableFunction6<E7, R> name);
    //
    //    /**
    //     * add descending order value. 添加降序条件.
    //     *
    //     * @param <R>      the generic type
    //     * @param entities the entities
    //     * @param names    名称
    //     * @return this
    //     */
    //    <R> S desc(
    //            Function<
    //                    Tuple9<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                            QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>,
    //                            QueryEntityRepository<E7>, QueryEntityRepository<E8>, QueryEntityRepository<E9>>,
    //                    QueryEntityRepository<E7>> entities,
    //            @SuppressWarnings("unchecked") SerializableFunction6<E7, R>... names);
    //
    //    /**
    //     * add descending order value. 添加降序条件.
    //     *
    //     * @param <R>      the generic type
    //     * @param entities the entities
    //     * @param name     名称
    //     * @return this
    //     */
    //    <R> S desc(Function<
    //            Tuple9<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                    QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>,
    //                    QueryEntityRepository<E7>, QueryEntityRepository<E8>, QueryEntityRepository<E9>>,
    //            QueryEntityRepository<E8>> entities, SerializableFunction7<E8, R> name);
    //
    //    /**
    //     * add descending order value. 添加降序条件.
    //     *
    //     * @param <R>      the generic type
    //     * @param entities the entities
    //     * @param names    名称
    //     * @return this
    //     */
    //    <R> S desc(
    //            Function<
    //                    Tuple9<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                            QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>,
    //                            QueryEntityRepository<E7>, QueryEntityRepository<E8>, QueryEntityRepository<E9>>,
    //                    QueryEntityRepository<E8>> entities,
    //            @SuppressWarnings("unchecked") SerializableFunction7<E8, R>... names);
    //
    //    /**
    //     * add descending order value. 添加降序条件.
    //     *
    //     * @param <R>      the generic type
    //     * @param entities the entities
    //     * @param name     名称
    //     * @return this
    //     */
    //    <R> S desc(Function<
    //            Tuple9<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                    QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>,
    //                    QueryEntityRepository<E7>, QueryEntityRepository<E8>, QueryEntityRepository<E9>>,
    //            QueryEntityRepository<E9>> entities, SerializableFunction8<E9, R> name);
    //
    //    /**
    //     * add descending order value. 添加降序条件.
    //     *
    //     * @param <R>      the generic type
    //     * @param entities the entities
    //     * @param names    名称
    //     * @return this
    //     */
    //    <R> S desc(
    //            Function<
    //                    Tuple9<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                            QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>,
    //                            QueryEntityRepository<E7>, QueryEntityRepository<E8>, QueryEntityRepository<E9>>,
    //                    QueryEntityRepository<E9>> entities,
    //            @SuppressWarnings("unchecked") SerializableFunction8<E9, R>... names);
}