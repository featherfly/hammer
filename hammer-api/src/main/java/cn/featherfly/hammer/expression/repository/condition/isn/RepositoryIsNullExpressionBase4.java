
package cn.featherfly.hammer.expression.repository.condition.isn;

import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.lang.LambdaUtils;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.condition.isn.IsNullExpression4;

/**
 * RepositoryIsNullExpressionBase4 .
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface RepositoryIsNullExpressionBase4<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends IsNullExpression4<C, L> {

    /**
     * is null.
     *
     * @param <T>  the generic type
     * @param <R>  the generic type
     * @param name the name
     * @return LogicExpression
     */
    default <T, R> L isn4(SerializableFunction<T, R> name) {
        return isn4(name, true);
    }

    /**
     * is null.
     *
     * @param <T>   the generic type
     * @param <R>   the generic type
     * @param name  the name
     * @param value if true, is null; if false, is not null; if null, ignore
     *              this operate
     * @return LogicExpression
     */
    default <T, R> L isn4(SerializableFunction<T, R> name, Boolean value) {
        return isn4(LambdaUtils.getLambdaPropertyName(name), value);
    }
}