
package cn.featherfly.hammer.expression.condition.isn;

import cn.featherfly.common.function.serializable.SerializableSupplier;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * is null expression4 .
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface IsNullSupplierExpression4<C extends ConditionExpression, L extends LogicExpression<C, L>>
    extends ConditionExpression {

    /**
     * is null.
     *
     * @param <R> the generic type
     * @param property the property
     * @return LogicExpression
     */
    default <R> L isn4(SerializableSupplier<R> property) {
        return isn4(property, true);
    }

    /**
     * is null.
     *
     * @param <R> the generic type
     * @param property the property
     * @param value if true, is null; if false, is not null; if null, ignore
     *        this operate
     * @return LogicExpression
     */
    <R> L isn4(SerializableSupplier<R> property, Boolean value);
}