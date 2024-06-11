
package cn.featherfly.hammer.expression.condition.inn;

import cn.featherfly.common.function.serializable.SerializableSupplier;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * is not null expression6 .
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface IsNotNullSupplierExpression6<C extends ConditionExpression, L extends LogicExpression<C, L>>
    extends ConditionExpression {

    /**
     * is not null.
     *
     * @param <R> the generic type
     * @param property the property
     * @return LogicExpression
     */
    default <R> L inn6(SerializableSupplier<R> property) {
        return inn6(property, true);
    }

    /**
     * is not null.
     *
     * @param <R> the generic type
     * @param property the property
     * @param value if true, is null; if false, is not null; if null, ignore
     *        this operate
     * @return LogicExpression
     */
    <R> L inn6(SerializableSupplier<R> property, Boolean value);
}