
package cn.featherfly.hammer.expression.repository.condition.inn;

import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.function.serializable.SerializableSupplier;
import cn.featherfly.common.lang.LambdaUtils;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.condition.inn.IsNotNullExpression5;
import cn.featherfly.hammer.expression.condition.inn.IsNotNullSupplierExpression5;

/**
 * repository is not null expression5 .
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface RepositoryIsNotNullExpressionBase5<C extends ConditionExpression, L extends LogicExpression<C, L>>
    extends RepositoryIsNotNullExpressionBase4<C, L>, IsNotNullExpression5<C, L>, IsNotNullSupplierExpression5<C, L> {

    /**
     * is not null.
     *
     * @param <T> the generic type
     * @param <R> the generic type
     * @param name the name
     * @return LogicExpression
     */
    default <T, R> L inn5(SerializableFunction<T, R> name) {
        return inn5(name, true);
    }

    /**
     * is not null.
     *
     * @param <T> the generic type
     * @param <R> the generic type
     * @param name the name
     * @param value if true, is not null; if false, is null; if null, ignore
     *        this operate
     * @return LogicExpression
     */
    default <T, R> L inn5(SerializableFunction<T, R> name, Boolean value) {
        return inn5(LambdaUtils.getLambdaPropertyName(name), value);
    }

    @Override
    default <R> L inn5(SerializableSupplier<R> name, Boolean value) {
        return inn5(LambdaUtils.getLambdaPropertyName(name), value);
    }
}