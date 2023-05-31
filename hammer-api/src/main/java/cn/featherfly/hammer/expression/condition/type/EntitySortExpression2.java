package cn.featherfly.hammer.expression.condition.type;

import java.util.function.Function;

import com.speedment.common.tuple.Tuple2;

import cn.featherfly.common.lang.function.SerializableFunction;
import cn.featherfly.common.lang.function.SerializableFunction1;
import cn.featherfly.hammer.dsl.QueryEntityRepository;

/**
 * 排序构建接口.
 *
 * @author zhongj
 * @param <E>  the entity type
 * @param <E2> the generic type
 * @param <S>  the EntitySortExpression type
 */
public interface EntitySortExpression2<E, E2, S extends EntitySortExpression2<E, E2, S>>
        extends EntitySortExpression<E, EntitySortExpression2<E, E2, S>> {

    /**
     * 添加升序条件 .
     *
     * @param <R>      the generic type
     * @param entities the entities
     * @param name     名称
     * @return this
     */
    <R> S asc(Function<Tuple2<QueryEntityRepository<E>, QueryEntityRepository<E2>>, QueryEntityRepository<E2>> entities,
            SerializableFunction<E, R> name);

    /**
     * 添加升序条件 .
     *
     * @param <R>      the generic type
     * @param entities the entities
     * @param names    名称
     * @return this
     */
    <R> S asc(Function<Tuple2<QueryEntityRepository<E>, QueryEntityRepository<E2>>, QueryEntityRepository<E2>> entities,
            @SuppressWarnings("unchecked") SerializableFunction<E, R>... names);

    /**
     * 添加升序条件 .
     *
     * @param <R>      the generic type
     * @param entities the entities
     * @param name     名称
     * @return this
     */
    <R> S asc(Function<Tuple2<QueryEntityRepository<E>, QueryEntityRepository<E2>>, QueryEntityRepository<E2>> entities,
            SerializableFunction1<E2, R> name);

    /**
     * 添加升序条件 .
     *
     * @param <R>      the generic type
     * @param entities the entities
     * @param names    名称
     * @return this
     */
    <R> S asc(Function<Tuple2<QueryEntityRepository<E>, QueryEntityRepository<E2>>, QueryEntityRepository<E2>> entities,
            @SuppressWarnings("unchecked") SerializableFunction1<E2, R>... names);

    /**
     * 添加降序条件 .
     *
     * @param <R>      the generic type
     * @param entities the entities
     * @param name     名称
     * @return this
     */
    <R> S desc(Function<Tuple2<QueryEntityRepository<E>, QueryEntityRepository<E2>>, QueryEntityRepository<E>> entities,
            SerializableFunction<E, R> name);

    /**
     * 添加降序条件 .
     *
     * @param <R>      the generic type
     * @param entities the entities
     * @param names    名称
     * @return this
     */
    <R> S desc(Function<Tuple2<QueryEntityRepository<E>, QueryEntityRepository<E2>>, QueryEntityRepository<E>> entities,
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
            Function<Tuple2<QueryEntityRepository<E>, QueryEntityRepository<E2>>, QueryEntityRepository<E2>> entities,
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
            Function<Tuple2<QueryEntityRepository<E>, QueryEntityRepository<E2>>, QueryEntityRepository<E2>> entities,
            @SuppressWarnings("unchecked") SerializableFunction1<E2, R>... names);

}