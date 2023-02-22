
package cn.featherfly.hammer.expression.condition;

import cn.featherfly.common.lang.function.SerializableFunction;
import cn.featherfly.common.repository.Field;

/**
 * IsNotNullExpression .
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface IsNotNullExpression<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends ConditionExpression {

    /**
     * is not null.
     *
     * @param name 参数名称
     * @return LogicExpression
     */
    default L inn(Field name) {
        return inn(name, true);
    }

    /**
     * is not null.
     *
     * @param name  参数名称
     * @param value if true, is not null; if false, is null; if null, ignore
     *              this operate
     * @return LogicExpression
     */
    default L inn(Field name, Boolean value) {
        return inn(name.name(), value);
    }

    /**
     * is not null.
     *
     * @param name 参数名称
     * @return LogicExpression
     */
    default L inn(String name) {
        return inn(name, true);
    }

    /**
     * is not null.
     *
     * @param name  参数名称
     * @param value if true, is not null; if false, is null; if null, ignore
     *              this operate
     * @return LogicExpression
     */
    L inn(String name, Boolean value);

    /**
     * is not null.
     *
     * @param <T>  the generic type
     * @param <R>  the generic type
     * @param name 参数名称
     * @return LogicExpression
     */
    default <T, R> L inn(SerializableFunction<T, R> name) {
        return inn(name, true);
    }

    /**
     * is not null.
     *
     * @param <T>   the generic type
     * @param <R>   the generic type
     * @param name  参数名称
     * @param value if true, is not null; if false, is null; if null, ignore
     *              this operate
     * @return LogicExpression
     */
    <T, R> L inn(SerializableFunction<T, R> name, Boolean value);
}