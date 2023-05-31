package cn.featherfly.hammer.expression.condition.type;

import java.util.function.Function;

import com.speedment.common.tuple.Tuple5;

import cn.featherfly.common.lang.function.SerializableFunction;
import cn.featherfly.common.lang.function.SerializableFunction1;
import cn.featherfly.common.lang.function.SerializableFunction2;
import cn.featherfly.common.lang.function.SerializableFunction3;
import cn.featherfly.common.lang.function.SerializableFunction4;
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
 * @param <S>  the EntitySortExpression type
 */
public interface EntitySortExpression5<E, E2, E3, E4, E5, S extends EntitySortExpression5<E, E2, E3, E4, E5, S>>
        extends EntitySortExpression<E, EntitySortExpression5<E, E2, E3, E4, E5, S>> {

    /**
     * 添加升序条件 .
     *
     * @param <R>      the generic type
     * @param entities the entities
     * @param name     名称
     * @return this
     */
    <R> S asc(
            Function<Tuple5<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
                    QueryEntityRepository<E4>, QueryEntityRepository<E5>>, QueryEntityRepository<E>> entities,
            SerializableFunction<E, R> name);

    /**
     * 添加升序条件 .
     *
     * @param <R>      the generic type
     * @param entities the entities
     * @param names    名称
     * @return this
     */
    <R> S asc(
            Function<Tuple5<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
                    QueryEntityRepository<E4>, QueryEntityRepository<E5>>, QueryEntityRepository<E>> entities,
            @SuppressWarnings("unchecked") SerializableFunction<E, R>... names);

    /**
     * 添加升序条件 .
     *
     * @param <R>      the generic type
     * @param entities the entities
     * @param name     名称
     * @return this
     */
    <R> S asc(
            Function<Tuple5<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
                    QueryEntityRepository<E4>, QueryEntityRepository<E5>>, QueryEntityRepository<E2>> entities,
            SerializableFunction1<E2, R> name);

    /**
     * 添加升序条件 .
     *
     * @param <R>      the generic type
     * @param entities the entities
     * @param names    名称
     * @return this
     */
    <R> S asc(
            Function<Tuple5<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
                    QueryEntityRepository<E4>, QueryEntityRepository<E5>>, QueryEntityRepository<E2>> entities,
            @SuppressWarnings("unchecked") SerializableFunction1<E2, R>... names);

    /**
     * 添加升序条件 .
     *
     * @param <R>      the generic type
     * @param entities the entities
     * @param name     名称
     * @return this
     */
    <R> S asc(
            Function<Tuple5<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
                    QueryEntityRepository<E4>, QueryEntityRepository<E5>>, QueryEntityRepository<E3>> entities,
            SerializableFunction2<E3, R> name);

    /**
     * 添加升序条件 .
     *
     * @param <R>      the generic type
     * @param entities the entities
     * @param names    名称
     * @return this
     */
    <R> S asc(
            Function<Tuple5<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
                    QueryEntityRepository<E4>, QueryEntityRepository<E5>>, QueryEntityRepository<E3>> entities,
            @SuppressWarnings("unchecked") SerializableFunction2<E3, R>... names);

    /**
     * 添加降序条件 .
     *
     * @param <R>      the generic type
     * @param entities the entities
     * @param name     名称
     * @return this
     */
    <R> S desc(
            Function<Tuple5<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
                    QueryEntityRepository<E4>, QueryEntityRepository<E5>>, QueryEntityRepository<E>> entities,
            SerializableFunction<E, R> name);

    /**
     * 添加降序条件 .
     *
     * @param <R>      the generic type
     * @param entities the entities
     * @param names    名称
     * @return this
     */
    <R> S desc(
            Function<Tuple5<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
                    QueryEntityRepository<E4>, QueryEntityRepository<E5>>, QueryEntityRepository<E>> entities,
            @SuppressWarnings("unchecked") SerializableFunction<E, R>... names);

    /**
     * 添加降序条件 .
     *
     * @param <R>      the generic type
     * @param entities the entities
     * @param name     名称
     * @return this
     */
    <R> S desc(
            Function<Tuple5<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
                    QueryEntityRepository<E4>, QueryEntityRepository<E5>>, QueryEntityRepository<E2>> entities,
            SerializableFunction1<E2, R> name);

    /**
     * 添加降序条件 .
     *
     * @param <R>      the generic type
     * @param entities the entities
     * @param names    名称
     * @return this
     */
    <R> S desc(
            Function<Tuple5<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
                    QueryEntityRepository<E4>, QueryEntityRepository<E5>>, QueryEntityRepository<E2>> entities,
            @SuppressWarnings("unchecked") SerializableFunction1<E2, R>... names);

    /**
     * 添加降序条件 .
     *
     * @param <R>      the generic type
     * @param entities the entities
     * @param name     名称
     * @return this
     */
    <R> S desc(
            Function<Tuple5<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
                    QueryEntityRepository<E4>, QueryEntityRepository<E5>>, QueryEntityRepository<E3>> entities,
            SerializableFunction2<E3, R> name);

    /**
     * 添加降序条件 .
     *
     * @param <R>      the generic type
     * @param entities the entities
     * @param names    名称
     * @return this
     */
    <R> S desc(
            Function<Tuple5<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
                    QueryEntityRepository<E4>, QueryEntityRepository<E5>>, QueryEntityRepository<E3>> entities,
            @SuppressWarnings("unchecked") SerializableFunction2<E3, R>... names);

    /**
     * 添加降序条件 .
     *
     * @param <R>      the generic type
     * @param entities the entities
     * @param name     名称
     * @return this
     */
    <R> S desc(
            Function<Tuple5<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
                    QueryEntityRepository<E4>, QueryEntityRepository<E5>>, QueryEntityRepository<E4>> entities,
            SerializableFunction3<E4, R> name);

    /**
     * 添加降序条件 .
     *
     * @param <R>      the generic type
     * @param entities the entities
     * @param names    名称
     * @return this
     */
    <R> S desc(
            Function<Tuple5<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
                    QueryEntityRepository<E4>, QueryEntityRepository<E5>>, QueryEntityRepository<E4>> entities,
            @SuppressWarnings("unchecked") SerializableFunction3<E4, R>... names);

    /**
     * 添加降序条件 .
     *
     * @param <R>      the generic type
     * @param entities the entities
     * @param name     名称
     * @return this
     */
    <R> S desc(
            Function<Tuple5<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
                    QueryEntityRepository<E4>, QueryEntityRepository<E5>>, QueryEntityRepository<E5>> entities,
            SerializableFunction4<E5, R> name);

    /**
     * 添加降序条件 .
     *
     * @param <R>      the generic type
     * @param entities the entities
     * @param names    名称
     * @return this
     */
    <R> S desc(
            Function<Tuple5<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
                    QueryEntityRepository<E4>, QueryEntityRepository<E5>>, QueryEntityRepository<E5>> entities,
            @SuppressWarnings("unchecked") SerializableFunction4<E5, R>... names);
}