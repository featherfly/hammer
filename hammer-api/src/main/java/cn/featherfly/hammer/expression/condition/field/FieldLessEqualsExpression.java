
package cn.featherfly.hammer.expression.condition.field;

import java.util.function.Predicate;

import cn.featherfly.common.repository.IgnoreStrategy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * The Interface PropertyLessEqualsExpression.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 * @param <V> the value type
 */
public interface FieldLessEqualsExpression<C extends ConditionExpression, L extends LogicExpression<C, L>, V>
        extends ConditionExpression {

    /**
     * less equals. 小于等于.
     *
     * @param value the value
     * @return LogicExpression
     */
    L le(V value);

    /**
     * less equals. 小于等于.
     *
     * @param value the value
     * @return LogicExpression
     */
    default L le(V value, IgnoreStrategy ignoreStrategy) {
        return le(value, (Predicate<V>) ignoreStrategy::test);
    }

    /**
     * less equals. 小于等于.
     *
     * @param value the value
     * @return LogicExpression
     */
    L le(V value, Predicate<V> ignoreStrategy);
}