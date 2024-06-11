
package cn.featherfly.hammer.expression.repository.condition.isn;

import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.function.serializable.SerializableSupplier;
import cn.featherfly.common.lang.LambdaUtils;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.condition.isn.IsNullExpression;
import cn.featherfly.hammer.expression.condition.isn.IsNullSupplierExpression;

/**
 * RepositoryIsNullExpressionBase .
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface RepositoryIsNullExpressionBase<C extends ConditionExpression, L extends LogicExpression<C, L>>
    extends IsNullExpression<C, L>, IsNullSupplierExpression<C, L> {

    /**
     * is null.
     *
     * @param <T> the generic type
     * @param <R> the generic type
     * @param name the name
     * @return LogicExpression
     */
    default <T, R> L isn(SerializableFunction<T, R> name) {
        return isn(name, true);
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
    default <T, R> L isn(SerializableFunction<T, R> name, Boolean value) {
        return isn(LambdaUtils.getLambdaPropertyName(name), value);
    }

    @Override
    default <R> L isn(SerializableSupplier<R> name, Boolean value) {
        return isn(LambdaUtils.getLambdaPropertyName(name), value);
    }
}