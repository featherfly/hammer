
package cn.featherfly.hammer.expression.condition.nl;

import java.util.function.Predicate;

import cn.featherfly.common.function.serializable.SerializableStringSupplier;
import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.common.repository.IgnoreStrategy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * not like supplier expression2.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface NotLikeSupplierExpression2<C extends ConditionExpression, L extends LogicExpression<C, L>> {

    /**
     * not like value.
     *
     * @param property bean property
     * @return LogicExpression
     */
    default L nl2(SerializableStringSupplier property) {
        return nl2(property, MatchStrategy.AUTO);
    }

    /**
     * not like value.
     *
     * @param property       bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L nl2(SerializableStringSupplier property, IgnoreStrategy ignoreStrategy) {
        return nl2(property, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * not like value.
     *
     * @param property       bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L nl2(SerializableStringSupplier property, Predicate<String> ignoreStrategy) {
        return nl2(property, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * Lk.
     *
     * @param property      bean property
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    L nl2(SerializableStringSupplier property, MatchStrategy matchStrategy);

    /**
     * Lk.
     *
     * @param property       bean property
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L nl2(SerializableStringSupplier property, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {
        return nl2(property, matchStrategy, (Predicate<String>) ignoreStrategy::test);
    }

    /**
     * Lk.
     *
     * @param property       bean property
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L nl2(SerializableStringSupplier property, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy);
}