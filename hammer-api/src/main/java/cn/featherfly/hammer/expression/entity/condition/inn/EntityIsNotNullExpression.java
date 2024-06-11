
package cn.featherfly.hammer.expression.entity.condition.inn;

import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.condition.inn.IsNotNullSupplierExpression;

/**
 * The Interface EntityIsNotNullExpression.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface EntityIsNotNullExpression<E, C extends ConditionExpression, L extends LogicExpression<C, L>>
    extends ConditionExpression, IsNotNullSupplierExpression<C, L> {

    /**
     * is not null.
     *
     * @param <R> the generic type
     * @param name the name
     * @return LogicExpression
     */
    default <R> L inn(SerializableFunction<E, R> name) {
        return inn(name, true);
    }

    /**
     * is not null.
     *
     * @param <R> the generic type
     * @param name the name
     * @param value if true, is not null; if false, is null; if null, ignore
     *        this operate
     * @return LogicExpression
     */
    <R> L inn(SerializableFunction<E, R> name, Boolean value);

}