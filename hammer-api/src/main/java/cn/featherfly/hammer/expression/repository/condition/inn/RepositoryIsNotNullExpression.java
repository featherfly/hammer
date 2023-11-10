
package cn.featherfly.hammer.expression.repository.condition.inn;

import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.condition.inn.IsNotNullExpression;

/**
 * repository is not null expression .
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface RepositoryIsNotNullExpression<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends IsNotNullExpression<C, L> {

    /**
     * is not null.
     *
     * @param <T>  the generic type
     * @param <R>  the generic type
     * @param name 参数名称
     * @return LogicExpression
     */
    default <T, R> L inn(SerializableFunction<T, R> name) {
        return inn(name, true);
    }

    /**
     * is not null.
     *
     * @param <T>   the generic type
     * @param <R>   the generic type
     * @param name  参数名称
     * @param value if true, is not null; if false, is null; if null, ignore
     *              this operate
     * @return LogicExpression
     */
    <T, R> L inn(SerializableFunction<T, R> name, Boolean value);
}