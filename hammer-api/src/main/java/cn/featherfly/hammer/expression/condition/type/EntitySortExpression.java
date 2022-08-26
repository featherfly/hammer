package cn.featherfly.hammer.expression.condition.type;

import cn.featherfly.common.lang.function.SerializableFunction;
import cn.featherfly.hammer.expression.condition.Expression;

/**
 * 排序构建接口.
 *
 * @author zhongj
 * @param <E> the entity type
 * @param <S> the EntitySortExpression type
 */
public interface EntitySortExpression<E, S extends EntitySortExpression<E, S>> extends Expression {

    /**
     * 添加升序条件 .
     *
     * @param <R>  the generic type
     * @param name 名称
     * @return this
     */
    <R> S asc(SerializableFunction<E, R> name);

    /**
     * 添加升序条件 .
     *
     * @param <R>   the generic type
     * @param names 名称
     * @return this
     */
    <R> S asc(@SuppressWarnings("unchecked") SerializableFunction<E, R>... names);

    /**
     * 添加降序条件 .
     *
     * @param <R>  the generic type
     * @param name 名称
     * @return this
     */
    <R> S desc(SerializableFunction<E, R> name);

    /**
     * 添加降序条件 .
     *
     * @param <R>   the generic type
     * @param names 名称
     * @return this
     */
    <R> S desc(@SuppressWarnings("unchecked") SerializableFunction<E, R>... names);

}