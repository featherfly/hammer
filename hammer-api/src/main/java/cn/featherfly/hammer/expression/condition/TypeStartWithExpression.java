
package cn.featherfly.hammer.expression.condition;

import cn.featherfly.common.lang.function.ReturnStringFunction;
import cn.featherfly.common.lang.function.SerializableFunction;
import cn.featherfly.common.lang.function.SerializableSupplier;

/**
 * <p>
 * StartWithExpression
 * </p>
 * .
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface TypeStartWithExpression<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends StartWithExpression<C, L> {

    /**
     * 以value开始.
     *
     * @param <T>        the generic type
     * @param <R>        the generic type
     * @param repository the repository
     * @param property   the property
     * @param value      参数值
     * @return LogicExpression
     */
    <T, R> L sw(SerializableFunction<T, R> repository, ReturnStringFunction<R> property, Object value);

    /**
     * 以value开始.
     *
     * @param <T>        the generic type
     * @param <R>        the generic type
     * @param repository the repository
     * @param property   对象属性
     * @return LogicExpression
     */
    <T, R> L sw(SerializableSupplier<T> repository, ReturnStringFunction<T> property);
}