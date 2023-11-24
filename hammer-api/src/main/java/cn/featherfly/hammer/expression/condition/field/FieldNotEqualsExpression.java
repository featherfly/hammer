
package cn.featherfly.hammer.expression.condition.field;

import java.util.function.Predicate;

import cn.featherfly.common.repository.IgnoreStrategy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * field not equals expression.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 * @param <V> the value type
 */
public interface FieldNotEqualsExpression<C extends ConditionExpression, L extends LogicExpression<C, L>, V>
        extends ConditionExpression {

    /**
     * not equals. 不等于.
     *
     * @param value the value
     * @return LogicExpression
     */
    L ne(V value);

    /**
     * not equals. 不等于.
     *
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ne(V value, IgnoreStrategy ignoreStrategy) {
        return ne(value, (Predicate<V>) ignoreStrategy::test);
    }

    /**
     * not equals. 不等于.
     *
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ne(V value, Predicate<V> ignoreStrategy);
}