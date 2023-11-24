
package cn.featherfly.hammer.expression.condition.field;

import java.util.function.Predicate;

import cn.featherfly.common.repository.IgnoreStrategy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * field not in expression.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 * @param <V> the value type
 */
public interface FieldNotInExpression<C extends ConditionExpression, L extends LogicExpression<C, L>, V>
        extends ConditionExpression {

    /**
     * 不包含指定，sql中的not in.
     *
     * @param value the value
     * @return LogicExpression
     */
    L ni(V value);

    /**
     * 不包含指定，sql中的not in.
     *
     * @param value the value
     * @return LogicExpression
     */
    L ni(V[] value);

    /**
     * 不包含指定，sql中的not in.
     *
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ni(V value, IgnoreStrategy ignoreStrategy) {
        return ni(value, (Predicate<V>) ignoreStrategy::test);
    }

    /**
     * 不包含指定，sql中的not in.
     *
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ni(V value, Predicate<V> ignoreStrategy);

    /**
     * 不包含指定，sql中的not in.
     *
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ni(V[] value, IgnoreStrategy ignoreStrategy) {
        return ni(value, (Predicate<V[]>) ignoreStrategy::test);
    }

    /**
     * 不包含指定，sql中的not in.
     *
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ni(V[] value, Predicate<V[]> ignoreStrategy);
}