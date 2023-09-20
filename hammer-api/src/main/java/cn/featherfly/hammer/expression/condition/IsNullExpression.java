
package cn.featherfly.hammer.expression.condition;

import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.repository.Field;

/**
 * IsNullExpression .
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface IsNullExpression<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends StringIsNullExpression<C, L> {

    /**
     * is null.
     *
     * @param name 参数名称
     * @return LogicExpression
     */
    default L isn(Field name) {
        return isn(name.name());
    }

    /**
     * is null.
     *
     * @param name  参数名称
     * @param value if true, is null; if false, is not null; if null, ignore
     *              this operate
     * @return LogicExpression
     */
    default L isn(Field name, Boolean value) {
        return isn(name.name(), value);
    }

    /**
     * is null.
     *
     * @param <T>  the generic type
     * @param <R>  the generic type
     * @param name 参数名称
     * @return LogicExpression
     */
    default <T, R> L isn(SerializableFunction<T, R> name) {
        return isn(name, true);
    }

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