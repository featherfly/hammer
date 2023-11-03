
package cn.featherfly.hammer.expression.condition.field;

import java.util.function.BiPredicate;

import cn.featherfly.common.lang.Lang;
import cn.featherfly.common.repository.IgnoreStrategy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * field between and expression.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 * @param <V> the value type
 */
public interface FieldBetweenExpression<C extends ConditionExpression, L extends LogicExpression<C, L>, V>
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
    @SuppressWarnings("unchecked")
    default L ba(V min, V max, IgnoreStrategy ignoreStrategy) {
        return ba(min, max, (m1, m2) -> ignoreStrategy.test(Lang.array(m1, m2)));
    }

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