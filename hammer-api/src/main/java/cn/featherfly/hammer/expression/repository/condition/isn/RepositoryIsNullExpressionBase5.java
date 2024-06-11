
package cn.featherfly.hammer.expression.repository.condition.isn;

import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.function.serializable.SerializableSupplier;
import cn.featherfly.common.lang.LambdaUtils;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.condition.isn.IsNullExpression5;
import cn.featherfly.hammer.expression.condition.isn.IsNullSupplierExpression5;

/**
 * RepositoryIsNullExpressionBase5 .
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface RepositoryIsNullExpressionBase5<C extends ConditionExpression, L extends LogicExpression<C, L>>
    extends IsNullExpression5<C, L>, IsNullSupplierExpression5<C, L> {

    /**
     * is null.
     *
     * @param <T> the generic type
     * @param <R> the generic type
     * @param name the name
     * @return LogicExpression
     */
    default <T, R> L isn5(SerializableFunction<T, R> name) {
        return isn5(name, true);
    }

    /**
     * is null.
     *
     * @param <T> the generic type
     * @param <R> the generic type
     * @param name the name
     * @param value if true, is null; if false, is not null; if null, ignore
     *        this operate
     * @return LogicExpression
     */
    default <T, R> L isn5(SerializableFunction<T, R> name, Boolean value) {
        return isn5(LambdaUtils.getLambdaPropertyName(name), value);
    }

    @Override
    default <R> L isn5(SerializableSupplier<R> name, Boolean value) {
        return isn5(LambdaUtils.getLambdaPropertyName(name), value);
    }
}