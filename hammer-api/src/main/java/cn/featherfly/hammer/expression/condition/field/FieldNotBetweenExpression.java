
package cn.featherfly.hammer.expression.condition.field;

import java.util.function.BiPredicate;

import cn.featherfly.common.lang.Lang;
import cn.featherfly.common.repository.IgnoreStrategy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * field not between and expression..
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 * @param <V> the value type
 */
public interface FieldNotBetweenExpression<C extends ConditionExpression, L extends LogicExpression<C, L>, V>
        extends ConditionExpression {

    /**
     * not between {min} and {max}.
     *
     * @param min the min
     * @param max the max
     * @return LogicExpression
     */
    L nba(V min, V max);

    /**
     * not between {min} and {max}.
     *
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    @SuppressWarnings("unchecked")
    default L nba(V min, V max, IgnoreStrategy ignoreStrategy) {
        return nba(min, max, (m1, m2) -> ignoreStrategy.test(Lang.array(m1, m2)));
    }

    /**
     * not between {min} and {max}.
     *
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L nba(V min, V max, BiPredicate<V, V> ignoreStrategy);
}