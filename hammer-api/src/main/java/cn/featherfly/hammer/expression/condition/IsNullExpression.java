
package cn.featherfly.hammer.expression.condition;

import cn.featherfly.common.lang.function.SerializableFunction;

/**
 * <p>
 * IsNullExpression
 * </p>
 * .
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface IsNullExpression<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends ConditionExpression {

    /**
     * is null.
     *
     * @param name 参数名称
     * @return LogicExpression
     */
    L isn(String name);

    /**
     * is null.
     *
     * @param <T>  the generic type
     * @param <R>  the generic type
     * @param name 参数名称
     * @return LogicExpression
     */
    <T, R> L isn(SerializableFunction<T, R> name);

    /**
     * is null.
     *
     * @param name  参数名称
     * @param value if true, is null; if false, is not null; if null, ignore
     *              this operate
     * @return LogicExpression
     */
    L isn(String name, Boolean value);

    /**
     * is null.
     *
     * @param <T>   the generic type
     * @param <R>   the generic type
     * @param name  参数名称
     * @param value if true, is null; if false, is not null; if null, ignore
     *              this operate
     * @return LogicExpression
     */
    <T, R> L isn(SerializableFunction<T, R> name, Boolean value);
}