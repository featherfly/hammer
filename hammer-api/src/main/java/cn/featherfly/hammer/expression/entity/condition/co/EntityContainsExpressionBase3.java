
package cn.featherfly.hammer.expression.entity.condition.co;

import java.util.function.Predicate;

import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.common.repository.IgnoreStrategy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.condition.co.ContainsSupplierExpression3;

/**
 * The Interface EntityContainsExpressionBase3.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <E2> the generic type
 * @param <E3> the generic type
 * @param <C>  the generic type
 * @param <L>  the generic type
 */
public interface EntityContainsExpressionBase3<E, E2, E3, C extends ConditionExpression,
        L extends LogicExpression<C, L>>
        extends EntityContainsExpressionBase2<E, E2, C, L>, ContainsSupplierExpression3<C, L> {

    /**
     * contains value. 包含value.
     *
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    default L co3(SerializableFunction<E3, String> name, String value) {
        return co3(name, value, MatchStrategy.AUTO);
    }

    /**
     * contains value. 包含value.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L co3(SerializableFunction<E3, String> name, String value, IgnoreStrategy ignoreStrategy) {
        return co3(name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * contains value. 包含value.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L co3(SerializableFunction<E3, String> name, String value, Predicate<String> ignoreStrategy) {
        return co3(name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * contains value. 包含value.
     *
     * @param name          the name
     * @param value         the value
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    L co3(SerializableFunction<E3, String> name, String value, MatchStrategy matchStrategy);

    /**
     * contains value. 包含value.
     *
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L co3(SerializableFunction<E3, String> name, String value, MatchStrategy matchStrategy,
            IgnoreStrategy ignoreStrategy) {
        return co3(name, value, matchStrategy, (Predicate<String>) ignoreStrategy::test);
    }

    /**
     * contains value. 包含value.
     *
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L co3(SerializableFunction<E3, String> name, String value, MatchStrategy matchStrategy,
            Predicate<String> ignoreStrategy);
}