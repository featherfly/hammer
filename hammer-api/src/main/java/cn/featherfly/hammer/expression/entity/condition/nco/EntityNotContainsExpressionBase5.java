
package cn.featherfly.hammer.expression.entity.condition.nco;

import java.util.function.Predicate;

import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.common.repository.IgnoreStrategy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.condition.nco.NotContainsSupplierExpression5;

/**
 * The Interface EntityNotContainsExpressionBase5.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <E2> the generic type
 * @param <E3> the generic type
 * @param <E4> the generic type
 * @param <E5> the generic type
 * @param <C>  the generic type
 * @param <L>  the generic type
 */
public interface EntityNotContainsExpressionBase5<E, E2, E3, E4, E5, C extends ConditionExpression,
        L extends LogicExpression<C, L>>
        extends EntityNotContainsExpressionBase4<E, E2, E3, E4, C, L>, NotContainsSupplierExpression5<C, L> {

    /**
     * not contains value. 不包含value.
     *
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    default L nco5(SerializableFunction<E5, String> name, String value) {
        return nco5(name, value, MatchStrategy.AUTO);
    }

    /**
     * not contains value. 不包含value.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L nco5(SerializableFunction<E5, String> name, String value, IgnoreStrategy ignoreStrategy) {
        return nco5(name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * not contains value. 不包含value.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L nco5(SerializableFunction<E5, String> name, String value, Predicate<String> ignoreStrategy) {
        return nco5(name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * not contains value. 不包含value.
     *
     * @param name          the name
     * @param value         the value
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    L nco5(SerializableFunction<E5, String> name, String value, MatchStrategy matchStrategy);

    /**
     * not contains value. 不包含value.
     *
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L nco5(SerializableFunction<E5, String> name, String value, MatchStrategy matchStrategy,
            IgnoreStrategy ignoreStrategy) {
        return nco5(name, value, matchStrategy, (Predicate<String>) ignoreStrategy::test);
    }

    /**
     * not contains value. 不包含value.
     *
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L nco5(SerializableFunction<E5, String> name, String value, MatchStrategy matchStrategy,
            Predicate<String> ignoreStrategy);

}