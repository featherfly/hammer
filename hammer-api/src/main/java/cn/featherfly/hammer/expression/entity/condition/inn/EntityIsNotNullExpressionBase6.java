
package cn.featherfly.hammer.expression.entity.condition.inn;

import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.condition.inn.IsNotNullSupplierExpression6;

/**
 * The Interface EntityIsNotNullExpressionBase5.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <E2> the generic type
 * @param <E3> the generic type
 * @param <E4> the generic type
 * @param <E5> the generic type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface EntityIsNotNullExpressionBase6<E, E2, E3, E4, E5, E6, C extends ConditionExpression,
    L extends LogicExpression<C, L>>
    extends EntityIsNotNullExpressionBase5<E, E2, E3, E4, E5, C, L>, IsNotNullSupplierExpression6<C, L> {

    /**
     * is not null.
     *
     * @param <R> the generic type
     * @param name the name
     * @return LogicExpression
     */
    default <R> L inn6(SerializableFunction<E6, R> name) {
        return inn6(name, true);
    }

    /**
     * is not null.
     *
     * @param <R> the generic type
     * @param name the name
     * @param value if true, is null; if false, is not null; if null, ignore
     *        this operate
     * @return LogicExpression
     */
    <R> L inn6(SerializableFunction<E6, R> name, Boolean value);
}