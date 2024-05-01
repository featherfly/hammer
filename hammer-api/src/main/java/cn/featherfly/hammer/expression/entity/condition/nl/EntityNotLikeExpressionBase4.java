
package cn.featherfly.hammer.expression.entity.condition.nl;

import java.util.function.Predicate;

import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.common.repository.IgnoreStrategy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.condition.nl.NotLikeSupplierExpression4;

/**
 * The Interface EntityNotLikeExpressionBase4.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <E2> the generic type
 * @param <E3> the generic type
 * @param <E4> the generic type
 * @param <C>  the generic type
 * @param <L>  the generic type
 */
public interface EntityNotLikeExpressionBase4<E, E2, E3, E4, C extends ConditionExpression,
        L extends LogicExpression<C, L>>
        extends EntityNotLikeExpressionBase3<E, E2, E3, C, L>, NotLikeSupplierExpression4<C, L> {

    /**
     * not like value.
     *
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    default L nl4(SerializableFunction<E4, String> name, String value) {
        return nl4(name, value, MatchStrategy.AUTO);
    }

    /**
     * not like value.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L nl4(SerializableFunction<E4, String> name, String value, IgnoreStrategy ignoreStrategy) {
        return nl4(name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * not like value.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L nl4(SerializableFunction<E4, String> name, String value, Predicate<String> ignoreStrategy) {
        return nl4(name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * not like value.
     *
     * @param name          the name
     * @param value         the value
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    L nl4(SerializableFunction<E4, String> name, String value, MatchStrategy matchStrategy);

    /**
     * not like value.
     *
     * @param name           the name 参数名称
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L nl4(SerializableFunction<E4, String> name, String value, MatchStrategy matchStrategy,
            IgnoreStrategy ignoreStrategy) {
        return nl4(name, value, matchStrategy, (Predicate<String>) ignoreStrategy::test);
    }

    /**
     * not like value.
     *
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L nl4(SerializableFunction<E4, String> name, String value, MatchStrategy matchStrategy,
            Predicate<String> ignoreStrategy);

}