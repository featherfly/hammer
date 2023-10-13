
package cn.featherfly.hammer.expression.condition.property;

import java.util.function.BiPredicate;

import cn.featherfly.common.repository.IgnoreStrategy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * The Interface PropertyBetweenExpression.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 * @param <V> the value type
 */
public interface PropertyBetweenExpression<C extends ConditionExpression, L extends LogicExpression<C, L>, V>
        extends ConditionExpression {

    /**
     * between {min} and {max}.
     *
     * @param min the min
     * @param max the max
     * @return LogicExpression
     */
    L ba(V min, V max);

    /**
     * between {min} and {max}.
     *
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ba(V min, V max, IgnoreStrategy ignoreStrategy);

    /**
     * between {min} and {max}.
     *
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ba(V min, V max, BiPredicate<V, V> ignoreStrategy);
}