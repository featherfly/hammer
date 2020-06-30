
package cn.featherfly.hammer.expression.condition;

import cn.featherfly.common.lang.function.ReturnStringFunction;
import cn.featherfly.common.lang.function.StringSupplier;

/**
 * <p>
 * ContainsExpression
 * </p>
 * .
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface ContainsExpression<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends ConditionExpression {

    /**
     * 包含value.
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    L co(String name, String value);

    /**
     * 包含value.
     *
     * @param <T>   the generic type
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    <T> L co(ReturnStringFunction<T> name, String value);

    /**
     * 包含value.
     *
     * @param property 对象属性
     * @return LogicExpression
     */
    L co(StringSupplier property);
}