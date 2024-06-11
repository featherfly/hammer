
package cn.featherfly.hammer.expression.condition.inn;

import cn.featherfly.common.function.serializable.SerializableSupplier;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * is not null expression2 .
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface IsNotNullSupplierExpression2<C extends ConditionExpression, L extends LogicExpression<C, L>>
    extends ConditionExpression {

    /**
     * is not null.
     *
     * @param <R> the generic type
     * @param property the property
     * @return LogicExpression
     */
    default <R> L inn2(SerializableSupplier<R> property) {
        return inn2(property, true);
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
    <R> L inn2(SerializableSupplier<R> property, Boolean value);
}