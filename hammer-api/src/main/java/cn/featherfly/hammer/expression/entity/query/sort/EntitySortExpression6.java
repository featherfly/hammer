package cn.featherfly.hammer.expression.entity.query.sort;

import java.util.function.Function;

import com.speedment.common.tuple.Tuple6;

import cn.featherfly.common.function.SixArgusConsumer;
import cn.featherfly.common.lang.function.SerializableFunction;
import cn.featherfly.common.lang.function.SerializableFunction1;
import cn.featherfly.common.lang.function.SerializableFunction2;
import cn.featherfly.common.lang.function.SerializableFunction3;
import cn.featherfly.common.lang.function.SerializableFunction4;
import cn.featherfly.common.lang.function.SerializableFunction5;
import cn.featherfly.hammer.dsl.QueryEntityRepository;

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
 * @param <S>  the EntitySortExpression type
 */
public interface EntitySortExpression6<E, E2, E3, E4, E5, E6,
        S extends EntitySortedExpression6<E, E2, E3, E4, E5, E6, S>>
        extends EntitySortExpressionBase6<E, E2, E3, E4, E5, E6, S> {

    /**
     * asc.
     *
     * @param sortEntityExpressions the sort entity expressions
     * @return the LogicExpression
     */
    S asc(SixArgusConsumer<SortEntityExpression<E>, SortEntityExpression<E2>, SortEntityExpression<E3>,
            SortEntityExpression<E4>, SortEntityExpression<E5>, SortEntityExpression<E6>> sortEntityExpressions);

    /**
     * desc.
     *
     * @param sortEntityExpressions the sort entity expressions
     * @return the LogicExpression
     */
    S desc(SixArgusConsumer<SortEntityExpression<E>, SortEntityExpression<E2>, SortEntityExpression<E3>,
            SortEntityExpression<E4>, SortEntityExpression<E5>, SortEntityExpression<E6>> sortEntityExpressions);

    /**
     * add ascending order value. 添加升序条件.
     *
     * @param <R>      the generic type
     * @param entities the entities
     * @param name     名称
     * @return this
     */
    <R> S asc(Function<
            Tuple6<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
                    QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>>,
            QueryEntityRepository<E>> entities, SerializableFunction<E, R> name);

    /**
     * add ascending order value. 添加升序条件.
     *
     * @param entities the entities
     * @param names    名称
     * @return this
     */
    S asc(Function<
            Tuple6<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
                    QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>>,
            QueryEntityRepository<E>> entities, @SuppressWarnings("unchecked") SerializableFunction<E, ?>... names);

    /**
     * add ascending order value. 添加升序条件.
     *
     * @param <R>      the generic type
     * @param entities the entities
     * @param name     名称
     * @return this
     */
    <R> S asc(Function<
            Tuple6<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
                    QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>>,
            QueryEntityRepository<E2>> entities, SerializableFunction1<E2, R> name);

    /**
     * add ascending order value. 添加升序条件.
     *
     * @param entities the entities
     * @param names    名称
     * @return this
     */
    S asc(Function<
            Tuple6<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
                    QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>>,
            QueryEntityRepository<E2>> entities, @SuppressWarnings("unchecked") SerializableFunction1<E2, ?>... names);

    /**
     * add ascending order value. 添加升序条件.
     *
     * @param <R>      the generic type
     * @param entities the entities
     * @param name     名称
     * @return this
     */
    <R> S asc(Function<
            Tuple6<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
                    QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>>,
            QueryEntityRepository<E3>> entities, SerializableFunction2<E3, R> name);

    /**
     * add ascending order value. 添加升序条件.
     *
     * @param entities the entities
     * @param names    名称
     * @return this
     */
    S asc(Function<
            Tuple6<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
                    QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>>,
            QueryEntityRepository<E3>> entities, @SuppressWarnings("unchecked") SerializableFunction2<E3, ?>... names);

    /**
     * add ascending order value. 添加升序条件.
     *
     * @param <R>      the generic type
     * @param entities the entities
     * @param name     名称
     * @return this
     */
    <R> S asc(Function<
            Tuple6<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
                    QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>>,
            QueryEntityRepository<E4>> entities, SerializableFunction3<E4, R> name);

    /**
     * add ascending order value. 添加升序条件.
     *
     * @param entities the entities
     * @param names    名称
     * @return this
     */
    S asc(Function<
            Tuple6<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
                    QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>>,
            QueryEntityRepository<E4>> entities, @SuppressWarnings("unchecked") SerializableFunction3<E4, ?>... names);

    /**
     * add ascending order value. 添加升序条件.
     *
     * @param <R>      the generic type
     * @param entities the entities
     * @param name     名称
     * @return this
     */
    <R> S asc(Function<
            Tuple6<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
                    QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>>,
            QueryEntityRepository<E5>> entities, SerializableFunction4<E5, R> name);

    /**
     * add ascending order value. 添加升序条件.
     *
     * @param entities the entities
     * @param names    名称
     * @return this
     */
    S asc(Function<
            Tuple6<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
                    QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>>,
            QueryEntityRepository<E5>> entities, @SuppressWarnings("unchecked") SerializableFunction4<E5, ?>... names);

    /**
     * add ascending order value. 添加升序条件.
     *
     * @param <R>      the generic type
     * @param entities the entities
     * @param name     名称
     * @return this
     */
    <R> S asc(Function<
            Tuple6<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
                    QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>>,
            QueryEntityRepository<E6>> entities, SerializableFunction5<E6, R> name);

    /**
     * add ascending order value. 添加升序条件.
     *
     * @param entities the entities
     * @param names    名称
     * @return this
     */
    S asc(Function<
            Tuple6<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
                    QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>>,
            QueryEntityRepository<E6>> entities, @SuppressWarnings("unchecked") SerializableFunction5<E6, ?>... names);

    /**
     * add descending order value. 添加降序条件.
     *
     * @param <R>      the generic type
     * @param entities the entities
     * @param name     名称
     * @return this
     */
    <R> S desc(Function<
            Tuple6<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
                    QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>>,
            QueryEntityRepository<E>> entities, SerializableFunction<E, R> name);

    /**
     * add descending order value. 添加降序条件.
     *
     * @param entities the entities
     * @param names    名称
     * @return this
     */
    S desc(Function<
            Tuple6<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
                    QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>>,
            QueryEntityRepository<E>> entities, @SuppressWarnings("unchecked") SerializableFunction<E, ?>... names);

    /**
     * add descending order value. 添加降序条件.
     *
     * @param <R>      the generic type
     * @param entities the entities
     * @param name     名称
     * @return this
     */
    <R> S desc(Function<
            Tuple6<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
                    QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>>,
            QueryEntityRepository<E2>> entities, SerializableFunction1<E2, R> name);

    /**
     * add descending order value. 添加降序条件.
     *
     * @param entities the entities
     * @param names    名称
     * @return this
     */
    S desc(Function<
            Tuple6<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
                    QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>>,
            QueryEntityRepository<E2>> entities, @SuppressWarnings("unchecked") SerializableFunction1<E2, ?>... names);

    /**
     * add descending order value. 添加降序条件.
     *
     * @param <R>      the generic type
     * @param entities the entities
     * @param name     名称
     * @return this
     */
    <R> S desc(Function<
            Tuple6<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
                    QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>>,
            QueryEntityRepository<E3>> entities, SerializableFunction2<E3, R> name);

    /**
     * add descending order value. 添加降序条件.
     *
     * @param entities the entities
     * @param names    名称
     * @return this
     */
    S desc(Function<
            Tuple6<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
                    QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>>,
            QueryEntityRepository<E3>> entities, @SuppressWarnings("unchecked") SerializableFunction2<E3, ?>... names);

    /**
     * add descending order value. 添加降序条件.
     *
     * @param <R>      the generic type
     * @param entities the entities
     * @param name     名称
     * @return this
     */
    <R> S desc(Function<
            Tuple6<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
                    QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>>,
            QueryEntityRepository<E4>> entities, SerializableFunction3<E4, R> name);

    /**
     * add descending order value. 添加降序条件.
     *
     * @param entities the entities
     * @param names    名称
     * @return this
     */
    S desc(Function<
            Tuple6<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
                    QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>>,
            QueryEntityRepository<E4>> entities, @SuppressWarnings("unchecked") SerializableFunction3<E4, ?>... names);

    /**
     * add descending order value. 添加降序条件.
     *
     * @param <R>      the generic type
     * @param entities the entities
     * @param name     名称
     * @return this
     */
    <R> S desc(Function<
            Tuple6<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
                    QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>>,
            QueryEntityRepository<E5>> entities, SerializableFunction4<E5, R> name);

    /**
     * add descending order value. 添加降序条件.
     *
     * @param entities the entities
     * @param names    名称
     * @return this
     */
    S desc(Function<
            Tuple6<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
                    QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>>,
            QueryEntityRepository<E5>> entities, @SuppressWarnings("unchecked") SerializableFunction4<E5, ?>... names);

    /**
     * add descending order value. 添加降序条件.
     *
     * @param <R>      the generic type
     * @param entities the entities
     * @param name     名称
     * @return this
     */
    <R> S desc(Function<
            Tuple6<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
                    QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>>,
            QueryEntityRepository<E6>> entities, SerializableFunction5<E6, R> name);

    /**
     * add descending order value. 添加降序条件.
     *
     * @param entities the entities
     * @param names    名称
     * @return this
     */
    S desc(Function<
            Tuple6<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
                    QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>>,
            QueryEntityRepository<E6>> entities, @SuppressWarnings("unchecked") SerializableFunction5<E6, ?>... names);
}