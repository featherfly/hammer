
package cn.featherfly.hammer.expression.condition;

import java.util.function.Predicate;

import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.function.serializable.SerializableSupplier;
import cn.featherfly.common.repository.Field;

/**
 * InExpression .
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface InExpression<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends StringInExpression<C, L> {

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
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L in(Field name, Object value, Predicate<Object> ignoreStrategy) {
        return in(name.name(), value, ignoreStrategy);
    }

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
     * @param <T>            the generic type
     * @param <R>            the generic type
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <T, R> L in(SerializableFunction<T, R> name, Object value, Predicate<Object> ignoreStrategy);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param <R>      the generic type
     * @param property 对象属性
     * @return LogicExpression
     */
    <R> L in(SerializableSupplier<R> property);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param <R>            the generic type
     * @param property       对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R> L in(SerializableSupplier<R> property, Predicate<R> ignoreStrategy);
}