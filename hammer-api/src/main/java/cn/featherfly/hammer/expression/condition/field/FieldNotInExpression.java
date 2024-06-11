
package cn.featherfly.hammer.expression.condition.field;

import java.util.Collection;
import java.util.function.Predicate;

import cn.featherfly.common.lang.Lang;
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
     * not in.
     * 不包含指定，sql中的not in.
     *
     * @param value the value
     * @return LogicExpression
     */
    L ni(V value);

    /**
     * not in.
     * 不包含指定，sql中的not in.
     *
     * @param value the value
     * @return LogicExpression
     */
    L ni(V[] value);

    /**
     * not in.
     * 不包含指定，sql中的not in.
     *
     * @param value the value
     * @return LogicExpression
     */
    default L ni(Collection<V> value) {
        if (value == null) {
            return ni((V[]) null);
        }
        return ni(Lang.toArray(value));
    }

    /**
     * not in.
     * 不包含指定，sql中的not in.
     *
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ni(V value, IgnoreStrategy ignoreStrategy) {
        return ni(value, (Predicate<V>) ignoreStrategy::test);
    }

    /**
     * not in.
     * 不包含指定，sql中的not in.
     *
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ni(V value, Predicate<V> ignoreStrategy);

    /**
     * not in.
     * 不包含指定，sql中的not in.
     *
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ni(V[] value, IgnoreStrategy ignoreStrategy) {
        return ni(value, (Predicate<V[]>) ignoreStrategy::test);
    }

    /**
     * not in.
     * 不包含指定，sql中的not in.
     *
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ni(V[] value, Predicate<V[]> ignoreStrategy);

    /**
     * not in.
     * 不包含指定，sql中的not in.
     *
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ni(Collection<V> value, IgnoreStrategy ignoreStrategy) {
        return ni(value, (Predicate<Collection<V>>) ignoreStrategy::test);
    }

    /**
     * not in.
     * 不包含指定，sql中的not in.
     *
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ni(Collection<V> value, Predicate<Collection<V>> ignoreStrategy);
}