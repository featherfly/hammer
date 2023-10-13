package cn.featherfly.hammer.expression.entity.query.sort;

import java.util.function.BiConsumer;

/**
 * 排序构建接口.
 *
 * @author zhongj
 * @param <E>  the entity type
 * @param <E2> the generic type
 * @param <S>  the EntitySortExpression type
 */
public interface EntitySortExpression2<E, E2, S extends EntitySortedExpression2<E, E2, S>>
        extends EntitySortExpressionBase2<E, E2, S> {

    /**
     * asc.
     *
     * @param sortEntityExpressions the sort entity expressions
     * @return the LogicExpression
     */
    S asc(BiConsumer<SortEntityExpression<E>, SortEntityExpression<E2>> sortEntityExpressions);

    /**
     * desc.
     *
     * @param sortEntityExpressions the sort entity expressions
     * @return the LogicExpression
     */
    S desc(BiConsumer<SortEntityExpression<E>, SortEntityExpression<E2>> sortEntityExpressions);

    //    /**
    //     * add ascending order value. 添加升序条件.
    //     *
    //     * @param <R>      the generic type
    //     * @param entities the entities
    //     * @param name     名称
    //     * @return this
    //     */
    //    <R> S asc(Function<Tuple2<QueryEntityRepository<E>, QueryEntityRepository<E2>>, QueryEntityRepository<E>> entities,
    //            SerializableFunction1<E, R> name);
    //
    //    /**
    //     * add ascending order value. 添加升序条件.
    //     *
    //     * @param entities the entities
    //     * @param names    名称
    //     * @return this
    //     */
    //    S asc(Function<Tuple2<QueryEntityRepository<E>, QueryEntityRepository<E2>>, QueryEntityRepository<E>> entities,
    //            @SuppressWarnings("unchecked") SerializableFunction1<E, ?>... names);
    //
    //    /**
    //     * add ascending order value. 添加升序条件.
    //     *
    //     * @param <R>      the generic type
    //     * @param entities the entities
    //     * @param name     名称
    //     * @return this
    //     */
    //    <R> S asc(Function<Tuple2<QueryEntityRepository<E>, QueryEntityRepository<E2>>, QueryEntityRepository<E2>> entities,
    //            SerializableFunction2<E2, R> name);
    //
    //    /**
    //     * add ascending order value. 添加升序条件.
    //     *
    //     * @param entities the entities
    //     * @param names    名称
    //     * @return this
    //     */
    //    S asc(Function<Tuple2<QueryEntityRepository<E>, QueryEntityRepository<E2>>, QueryEntityRepository<E2>> entities,
    //            @SuppressWarnings("unchecked") SerializableFunction2<E2, ?>... names);
    //
    //    /**
    //     * add descending order value.添加降序条件 .
    //     *
    //     * @param <R>      the generic type
    //     * @param entities the entities
    //     * @param name     名称
    //     * @return this
    //     */
    //    <R> S desc(Function<Tuple2<QueryEntityRepository<E>, QueryEntityRepository<E2>>, QueryEntityRepository<E>> entities,
    //            SerializableFunction1<E, R> name);
    //
    //    /**
    //     * add descending order value.添加降序条件 .
    //     *
    //     * @param entities the entities
    //     * @param names    名称
    //     * @return this
    //     */
    //    S desc(Function<Tuple2<QueryEntityRepository<E>, QueryEntityRepository<E2>>, QueryEntityRepository<E>> entities,
    //            @SuppressWarnings("unchecked") SerializableFunction1<E, ?>... names);
    //
    //    /**
    //     * add descending order value.添加降序条件 .
    //     *
    //     * @param <R>      the generic type
    //     * @param entities the entities
    //     * @param name     名称
    //     * @return this
    //     */
    //    <R> S desc(
    //            Function<Tuple2<QueryEntityRepository<E>, QueryEntityRepository<E2>>, QueryEntityRepository<E2>> entities,
    //            SerializableFunction2<E2, R> name);
    //
    //    /**
    //     * add descending order value.添加降序条件 .
    //     *
    //     * @param entities the entities
    //     * @param names    名称
    //     * @return this
    //     */
    //    S desc(Function<Tuple2<QueryEntityRepository<E>, QueryEntityRepository<E2>>, QueryEntityRepository<E2>> entities,
    //            @SuppressWarnings("unchecked") SerializableFunction2<E2, ?>... names);

}