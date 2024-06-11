
package cn.featherfly.hammer.expression.entity.condition.isn;

import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.condition.isn.IsNullSupplierExpression2;

/**
 * The Interface EntityIsNullExpressionBase2.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <E2> the generic type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface EntityIsNullExpressionBase2<E, E2, C extends ConditionExpression, L extends LogicExpression<C, L>>
    extends EntityIsNullExpression<E, C, L>, IsNullSupplierExpression2<C, L> {

    /**
     * is null.
     *
     * @param <R> the generic type
     * @param name the name
     * @return LogicExpression
     */
    default <R> L isn2(SerializableFunction<E2, R> name) {
        return isn2(name, true);
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
    <R> L isn2(SerializableFunction<E2, R> name, Boolean value);

}