
package cn.featherfly.hammer.expression.repository.condition.isn;

import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.function.serializable.SerializableSupplier;
import cn.featherfly.common.lang.LambdaUtils;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.condition.isn.IsNullExpression2;
import cn.featherfly.hammer.expression.condition.isn.IsNullSupplierExpression2;

/**
 * RepositoryIsNullExpressionBase2 .
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface RepositoryIsNullExpressionBase2<C extends ConditionExpression, L extends LogicExpression<C, L>>
    extends IsNullExpression2<C, L>, IsNullSupplierExpression2<C, L> {

    /**
     * is null.
     *
     * @param <T> the generic type
     * @param <R> the generic type
     * @param name the name
     * @return LogicExpression
     */
    default <T, R> L isn2(SerializableFunction<T, R> name) {
        return isn2(name, true);
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
    default <T, R> L isn2(SerializableFunction<T, R> name, Boolean value) {
        return isn2(LambdaUtils.getLambdaPropertyName(name), value);
    }

    @Override
    default <R> L isn2(SerializableSupplier<R> name, Boolean value) {
        return isn2(LambdaUtils.getLambdaPropertyName(name), value);
    }
}