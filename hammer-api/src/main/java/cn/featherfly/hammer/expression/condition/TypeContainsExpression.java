
package cn.featherfly.hammer.expression.condition;

import cn.featherfly.common.lang.function.ReturnStringFunction;
import cn.featherfly.common.lang.function.SerializableFunction;
import cn.featherfly.common.lang.function.SerializableSupplier;

/**
 * <p>
 * TypeContainsExpression.
 * </p>
 * .
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface TypeContainsExpression<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends ContainsExpression<C, L> {

    /**
     * 包含value.
     *
     * @param <T>        the generic type
     * @param <R>        the generic type
     * @param repository the repository
     * @param property   the property
     * @param value      参数值
     * @return LogicExpression
     */
    <T, R> L co(SerializableFunction<T, R> repository, ReturnStringFunction<R> property, Object value);

    /**
     * 包含value.
     *
     * @param <T>        the generic type
     * @param <R>        the generic type
     * @param repository the repository
     * @param property   对象属性
     * @return LogicExpression
     */
    <T, R> L co(SerializableSupplier<T> repository, ReturnStringFunction<T> property);
}