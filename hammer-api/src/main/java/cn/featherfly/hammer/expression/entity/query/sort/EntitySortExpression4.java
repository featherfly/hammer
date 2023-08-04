package cn.featherfly.hammer.expression.entity.query.sort;

import java.util.function.Function;

import com.speedment.common.tuple.Tuple4;

import cn.featherfly.common.function.FourArgusConsumer;
import cn.featherfly.common.lang.function.SerializableFunction;
import cn.featherfly.common.lang.function.SerializableFunction1;
import cn.featherfly.common.lang.function.SerializableFunction2;
import cn.featherfly.common.lang.function.SerializableFunction3;
import cn.featherfly.hammer.dsl.QueryEntityRepository;

/**
 * 排序构建接口.
 *
 * @author zhongj
 * @param <E>  the entity type
 * @param <E2> the generic type
 * @param <E3> the generic type
 * @param <E4> the generic type
 * @param <S>  the EntitySortExpression type
 */
public interface EntitySortExpression4<E, E2, E3, E4, S extends EntitySortedExpression4<E, E2, E3, E4, S>>
        extends EntitySortExpressionBase4<E, E2, E3, E4, S> {

    /**
     * asc.
     *
     * @param sortEntityExpressions the sort entity expressions
     * @return the LogicExpression
     */
    S asc(FourArgusConsumer<SortEntityExpression<E>, SortEntityExpression<E2>, SortEntityExpression<E3>,
            SortEntityExpression<E4>> sortEntityExpressions);

    /**
     * desc.
     *
     * @param sortEntityExpressions the sort entity expressions
     * @return the LogicExpression
     */
    S desc(FourArgusConsumer<SortEntityExpression<E>, SortEntityExpression<E2>, SortEntityExpression<E3>,
            SortEntityExpression<E4>> sortEntityExpressions);

    /**
     * add ascending order value. 添加升序条件.
     *
     * @param <R>      the generic type
     * @param entities the entities
     * @param name     名称
     * @return this
     */
    <R> S asc(Function<Tuple4<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
            QueryEntityRepository<E4>>, QueryEntityRepository<E>> entities, SerializableFunction<E, R> name);

    /**
     * add ascending order value. 添加升序条件.
     *
     * @param entities the entities
     * @param names    名称
     * @return this
     */
    S asc(Function<Tuple4<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
            QueryEntityRepository<E4>>, QueryEntityRepository<E>> entities,
            @SuppressWarnings("unchecked") SerializableFunction<E, ?>... names);

    /**
     * add ascending order value. 添加升序条件.
     *
     * @param <R>      the generic type
     * @param entities the entities
     * @param name     名称
     * @return this
     */
    <R> S asc(Function<Tuple4<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
            QueryEntityRepository<E4>>, QueryEntityRepository<E2>> entities, SerializableFunction1<E2, R> name);

    /**
     * add ascending order value. 添加升序条件.
     *
     * @param entities the entities
     * @param names    名称
     * @return this
     */
    S asc(Function<Tuple4<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
            QueryEntityRepository<E4>>, QueryEntityRepository<E2>> entities,
            @SuppressWarnings("unchecked") SerializableFunction1<E2, ?>... names);

    /**
     * add ascending order value. 添加升序条件.
     *
     * @param <R>      the generic type
     * @param entities the entities
     * @param name     名称
     * @return this
     */
    <R> S asc(Function<Tuple4<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
            QueryEntityRepository<E4>>, QueryEntityRepository<E3>> entities, SerializableFunction2<E3, R> name);

    /**
     * add ascending order value. 添加升序条件.
     *
     * @param entities the entities
     * @param names    名称
     * @return this
     */
    S asc(Function<Tuple4<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
            QueryEntityRepository<E4>>, QueryEntityRepository<E3>> entities,
            @SuppressWarnings("unchecked") SerializableFunction2<E3, ?>... names);

    /**
     * add ascending order value. 添加升序条件.
     *
     * @param <R>      the generic type
     * @param entities the entities
     * @param name     名称
     * @return this
     */
    <R> S asc(Function<Tuple4<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
            QueryEntityRepository<E4>>, QueryEntityRepository<E4>> entities, SerializableFunction3<E4, R> name);

    /**
     * add ascending order value. 添加升序条件.
     *
     * @param entities the entities
     * @param names    名称
     * @return this
     */
    S asc(Function<Tuple4<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
            QueryEntityRepository<E4>>, QueryEntityRepository<E4>> entities,
            @SuppressWarnings("unchecked") SerializableFunction3<E4, ?>... names);

    /**
     * add descending order value. 添加降序条件.
     *
     * @param <R>      the generic type
     * @param entities the entities
     * @param name     名称
     * @return this
     */
    <R> S desc(Function<Tuple4<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
            QueryEntityRepository<E4>>, QueryEntityRepository<E>> entities, SerializableFunction<E, R> name);

    /**
     * add descending order value. 添加降序条件.
     *
     * @param entities the entities
     * @param names    名称
     * @return this
     */
    S desc(Function<Tuple4<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
            QueryEntityRepository<E4>>, QueryEntityRepository<E>> entities,
            @SuppressWarnings("unchecked") SerializableFunction<E, ?>... names);

    /**
     * add descending order value. 添加降序条件.
     *
     * @param <R>      the generic type
     * @param entities the entities
     * @param name     名称
     * @return this
     */
    <R> S desc(Function<Tuple4<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
            QueryEntityRepository<E4>>, QueryEntityRepository<E2>> entities, SerializableFunction1<E2, R> name);

    /**
     * add descending order value. 添加降序条件.
     *
     * @param entities the entities
     * @param names    名称
     * @return this
     */
    S desc(Function<Tuple4<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
            QueryEntityRepository<E4>>, QueryEntityRepository<E2>> entities,
            @SuppressWarnings("unchecked") SerializableFunction1<E2, ?>... names);

    /**
     * add descending order value. 添加降序条件.
     *
     * @param <R>      the generic type
     * @param entities the entities
     * @param name     名称
     * @return this
     */
    <R> S desc(Function<Tuple4<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
            QueryEntityRepository<E4>>, QueryEntityRepository<E3>> entities, SerializableFunction2<E3, R> name);

    /**
     * add descending order value. 添加降序条件.
     *
     * @param entities the entities
     * @param names    名称
     * @return this
     */
    S desc(Function<Tuple4<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
            QueryEntityRepository<E4>>, QueryEntityRepository<E3>> entities,
            @SuppressWarnings("unchecked") SerializableFunction2<E3, ?>... names);

    /**
     * add descending order value. 添加降序条件.
     *
     * @param <R>      the generic type
     * @param entities the entities
     * @param name     名称
     * @return this
     */
    <R> S desc(Function<Tuple4<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
            QueryEntityRepository<E4>>, QueryEntityRepository<E4>> entities, SerializableFunction3<E4, R> name);

    /**
     * add descending order value. 添加降序条件.
     *
     * @param entities the entities
     * @param names    名称
     * @return this
     */
    S desc(Function<Tuple4<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
            QueryEntityRepository<E4>>, QueryEntityRepository<E4>> entities,
            @SuppressWarnings("unchecked") SerializableFunction3<E4, ?>... names);
}