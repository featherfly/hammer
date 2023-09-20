
package cn.featherfly.hammer.expression.condition;

import java.util.function.Predicate;

import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.function.serializable.SerializableSupplier;
import cn.featherfly.common.repository.Field;

/**
 * NotInExpression .
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface NotInExpression<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends StringNotInExpression<C, L> {

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    default L ni(Field name, Object value) {
        return ni(name.name(), value);
    }

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ni(Field name, Object value, Predicate<Object> ignoreStrategy) {
        return ni(name.name(), value, ignoreStrategy);
    }

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param <T>   the generic type
     * @param <R>   the generic type
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    <T, R> L ni(SerializableFunction<T, R> name, Object value);

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param <T>            the generic type
     * @param <R>            the generic type
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <T, R> L ni(SerializableFunction<T, R> name, Object value, Predicate<Object> ignoreStrategy);

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param <R>      the generic type
     * @param property 对象属性
     * @return LogicExpression
     */
    <R> L ni(SerializableSupplier<R> property);

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param <R>            the generic type
     * @param property       对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R> L ni(SerializableSupplier<R> property, Predicate<R> ignoreStrategy);

}