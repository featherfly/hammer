
package cn.featherfly.hammer.expression.entity.condition.nl;

import java.util.function.Predicate;

import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.common.repository.IgnoreStrategy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.condition.nl.NotLikeSupplierExpression3;

/**
 * The Interface EntityNotLikeExpressionBase3.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <E2> the generic type
 * @param <E3> the generic type
 * @param <C>  the generic type
 * @param <L>  the generic type
 */
public interface EntityNotLikeExpressionBase3<E, E2, E3, C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends EntityNotLikeExpressionBase2<E, E2, C, L>, NotLikeSupplierExpression3<C, L> {

    /**
     * not like value.
     *
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    default L nl3(SerializableFunction<E3, String> name, String value) {
        return nl3(name, value, MatchStrategy.AUTO);
    }

    /**
     * not like value.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L nl3(SerializableFunction<E3, String> name, String value, IgnoreStrategy ignoreStrategy) {
        return nl3(name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * not like value.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L nl3(SerializableFunction<E3, String> name, String value, Predicate<String> ignoreStrategy) {
        return nl3(name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * not like value.
     *
     * @param name          the name
     * @param value         the value
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    L nl3(SerializableFunction<E3, String> name, String value, MatchStrategy matchStrategy);

    /**
     * not like value.
     *
     * @param name           the name 参数名称
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L nl3(SerializableFunction<E3, String> name, String value, MatchStrategy matchStrategy,
            IgnoreStrategy ignoreStrategy) {
        return nl3(name, value, matchStrategy, (Predicate<String>) ignoreStrategy::test);
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
    L nl3(SerializableFunction<E3, String> name, String value, MatchStrategy matchStrategy,
            Predicate<String> ignoreStrategy);

}