
package cn.featherfly.hammer.expression.entity.condition.isn;

import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.condition.isn.IsNullSupplierExpression3;

/**
 * The Interface EntityIsNullExpressionBase3.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <E2> the generic type
 * @param <E3> the generic type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface EntityIsNullExpressionBase3<E, E2, E3, C extends ConditionExpression, L extends LogicExpression<C, L>>
    extends EntityIsNullExpressionBase2<E, E2, C, L>, IsNullSupplierExpression3<C, L> {

    /**
     * is null.
     *
     * @param <R> the generic type
     * @param name the name
     * @return LogicExpression
     */
    default <R> L isn3(SerializableFunction<E3, R> name) {
        return isn3(name, true);
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
    <R> L isn3(SerializableFunction<E3, R> name, Boolean value);

}