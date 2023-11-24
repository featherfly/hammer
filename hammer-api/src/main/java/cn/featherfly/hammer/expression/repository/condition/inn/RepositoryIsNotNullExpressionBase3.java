
package cn.featherfly.hammer.expression.repository.condition.inn;

import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.lang.LambdaUtils;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.condition.inn.IsNotNullExpression3;

/**
 * repository is not null expression3 .
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface RepositoryIsNotNullExpressionBase3<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends RepositoryIsNotNullExpressionBase2<C, L>, IsNotNullExpression3<C, L> {

    /**
     * is not null.
     *
     * @param <T>  the generic type
     * @param <R>  the generic type
     * @param name the name
     * @return LogicExpression
     */
    default <T, R> L inn3(SerializableFunction<T, R> name) {
        return inn3(name, true);
    }

    /**
     * is not null.
     *
     * @param <T>   the generic type
     * @param <R>   the generic type
     * @param name  the name
     * @param value if true, is not null; if false, is null; if null, ignore
     *              this operate
     * @return LogicExpression
     */
    default <T, R> L inn3(SerializableFunction<T, R> name, Boolean value) {
        return inn3(LambdaUtils.getLambdaPropertyName(name), value);
    }
}