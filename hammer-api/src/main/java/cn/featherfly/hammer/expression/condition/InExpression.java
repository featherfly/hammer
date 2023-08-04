
package cn.featherfly.hammer.expression.condition;

import cn.featherfly.common.lang.function.SerializableFunction;
import cn.featherfly.common.lang.function.SerializableSupplier;
import cn.featherfly.common.repository.Field;

/**
 * InExpression .
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface InExpression<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends ConditionExpression {

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    default L in(Field name, Object value) {
        return in(name.name(), value);
    }

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    L in(String name, Object value);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param <T>   the generic type
     * @param <R>   the generic type
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    <T, R> L in(SerializableFunction<T, R> name, Object value);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param <R>      the generic type
     * @param property 对象属性
     * @return LogicExpression
     */
    <R> L in(SerializableSupplier<R> property);
}