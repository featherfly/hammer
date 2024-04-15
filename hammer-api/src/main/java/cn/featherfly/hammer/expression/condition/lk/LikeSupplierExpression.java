
package cn.featherfly.hammer.expression.condition.lk;

import java.util.function.Predicate;

import cn.featherfly.common.function.serializable.SerializableStringSupplier;
import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.common.repository.IgnoreStrategy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * like supplier expression.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface LikeSupplierExpression<C extends ConditionExpression, L extends LogicExpression<C, L>> {

    /**
     * like value.
     *
     * @param property bean property
     * @return LogicExpression
     */
    default L lk(SerializableStringSupplier property) {
        return lk(property, MatchStrategy.AUTO);
    }

    /**
     * like value.
     *
     * @param property       bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L lk(SerializableStringSupplier property, IgnoreStrategy ignoreStrategy) {
        return lk(property, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * like value.
     *
     * @param property       bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L lk(SerializableStringSupplier property, Predicate<String> ignoreStrategy) {
        return lk(property, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * Lk.
     *
     * @param property      bean property
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    L lk(SerializableStringSupplier property, MatchStrategy matchStrategy);

    /**
     * Lk.
     *
     * @param property       bean property
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L lk(SerializableStringSupplier property, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {
        return lk(property, matchStrategy, (Predicate<String>) ignoreStrategy::test);
    }

    /**
     * Lk.
     *
     * @param property       bean property
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L lk(SerializableStringSupplier property, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy);
}