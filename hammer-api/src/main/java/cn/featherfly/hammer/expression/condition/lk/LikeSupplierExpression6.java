
package cn.featherfly.hammer.expression.condition.lk;

import java.util.function.Predicate;

import cn.featherfly.common.function.serializable.SerializableStringSupplier;
import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.common.repository.IgnoreStrategy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * like supplier expression6.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface LikeSupplierExpression6<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends LikeSupplierExpression5<C, L> {

    /**
     * like value.
     *
     * @param property bean property
     * @return LogicExpression
     */
    default L lk6(SerializableStringSupplier property) {
        return lk6(property, MatchStrategy.AUTO);
    }

    /**
     * like value.
     *
     * @param property       bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L lk6(SerializableStringSupplier property, IgnoreStrategy ignoreStrategy) {
        return lk6(property, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * like value.
     *
     * @param property       bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L lk6(SerializableStringSupplier property, Predicate<String> ignoreStrategy) {
        return lk6(property, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * Lk.
     *
     * @param property      bean property
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    L lk6(SerializableStringSupplier property, MatchStrategy matchStrategy);

    /**
     * Lk.
     *
     * @param property       bean property
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L lk6(SerializableStringSupplier property, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {
        return lk6(property, matchStrategy, (Predicate<String>) ignoreStrategy::test);
    }

    /**
     * Lk.
     *
     * @param property       bean property
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L lk6(SerializableStringSupplier property, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy);
}