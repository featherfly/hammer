
package cn.featherfly.hammer.expression.entity.condition.isn;

import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.condition.isn.IsNullSupplierExpression4;

/**
 * The Interface EntityIsNullExpressionBase4.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <E2> the generic type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface EntityIsNullExpressionBase4<E, E2, E3, E4, C extends ConditionExpression,
    L extends LogicExpression<C, L>>
    extends EntityIsNullExpressionBase3<E, E2, E3, C, L>, IsNullSupplierExpression4<C, L> {

    /**
     * is null.
     *
     * @param <R> the generic type
     * @param name the name
     * @return LogicExpression
     */
    default <R> L isn4(SerializableFunction<E4, R> name) {
        return isn4(name, true);
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
    <R> L isn4(SerializableFunction<E4, R> name, Boolean value);

}