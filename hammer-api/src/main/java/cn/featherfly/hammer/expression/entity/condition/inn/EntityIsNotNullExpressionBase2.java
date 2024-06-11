
package cn.featherfly.hammer.expression.entity.condition.inn;

import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.condition.inn.IsNotNullSupplierExpression2;

/**
 * The Interface EntityIsNotNullExpressionBase2.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <E2> the generic type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface EntityIsNotNullExpressionBase2<E, E2, C extends ConditionExpression, L extends LogicExpression<C, L>>
    extends EntityIsNotNullExpression<E, C, L>, IsNotNullSupplierExpression2<C, L> {

    /**
     * is not null.
     *
     * @param <R> the generic type
     * @param name the name
     * @return LogicExpression
     */
    default <R> L inn2(SerializableFunction<E2, R> name) {
        return inn2(name, true);
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
    <R> L inn2(SerializableFunction<E2, R> name, Boolean value);
}