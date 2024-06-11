
package cn.featherfly.hammer.expression.entity.condition.isn;

import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.condition.isn.IsNullSupplierExpression;

/**
 * The Interface EntityIsNullExpression.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface EntityIsNullExpression<E, C extends ConditionExpression, L extends LogicExpression<C, L>>
    extends ConditionExpression, IsNullSupplierExpression<C, L> {

    /**
     * is null.
     *
     * @param <R> the generic type
     * @param name the name
     * @return LogicExpression
     */
    default <R> L isn(SerializableFunction<E, R> name) {
        return isn(name, true);
    }

    /**
     * is null.
     *
     * @param <R> the generic type
     * @param name the name
     * @param value if true, is null; if false, is not null; if null, ignore
     *        this operate
     * @return LogicExpression
     */
    <R> L isn(SerializableFunction<E, R> name, Boolean value);

}