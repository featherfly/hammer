
package cn.featherfly.hammer.expression.condition;

import cn.featherfly.common.lang.function.SerializableFunction;
import cn.featherfly.common.lang.function.SerializableSupplier;

/**
 * <p>
 * NotInExpression
 * </p>
 * .
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface NotInExpression<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends ConditionExpression {

    /**
     * 不包含指定，sql中的not in.
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    L nin(String name, Object value);

    /**
     * 不包含指定，sql中的not in.
     *
     * @param <T>   the generic type
     * @param <R>   the generic type
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    <T, R> L nin(SerializableFunction<T, R> name, Object value);

    /**
     * 不包含指定，sql中的not in.
     *
     * @param <R>      the generic type
     * @param property 对象属性
     * @return LogicExpression
     */
    <R> L nin(SerializableSupplier<R> property);

}