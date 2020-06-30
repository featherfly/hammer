
package cn.featherfly.hammer.expression.condition;

import cn.featherfly.common.lang.function.ReturnStringFunction;
import cn.featherfly.common.lang.function.StringSupplier;

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
public interface StartWithExpression<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends ConditionExpression {

    /**
     * 以value开始.
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    L sw(String name, String value);

    /**
     * 以value开始.
     *
     * @param <T>   the generic type
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    <T> L sw(ReturnStringFunction<T> name, String value);

    /**
     * 以value开始.
     *
     * @param property 对象属性
     * @return LogicExpression
     */
    L sw(StringSupplier property);
}