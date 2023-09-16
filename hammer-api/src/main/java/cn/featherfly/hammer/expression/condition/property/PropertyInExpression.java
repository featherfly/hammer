
package cn.featherfly.hammer.expression.condition.property;

import java.util.function.Predicate;

import cn.featherfly.common.repository.IgnoreStrategy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * property in expression.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 * @param <V> the value type
 */
public interface PropertyInExpression<C extends ConditionExpression, L extends LogicExpression<C, L>, V>
        extends ConditionExpression {

    /**
     * 包含指定，sql中的in.
     *
     * @param value 参数值
     * @return LogicExpression
     */
    L in(V value);

    /**
     * 包含指定，sql中的in.
     *
     * @param value 参数值
     * @return LogicExpression
     */
    L in(V[] value);

    /**
     * 包含指定，sql中的in.
     *
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L in(V value, IgnoreStrategy ignoreStrategy);

    /**
     * 包含指定，sql中的in.
     *
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L in(V value, Predicate<V> ignoreStrategy);

    /**
     * 包含指定，sql中的in.
     *
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L in(V[] value, IgnoreStrategy ignoreStrategy);

    /**
     * 包含指定，sql中的in.
     *
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L in(V[] value, Predicate<V[]> ignoreStrategy);
}