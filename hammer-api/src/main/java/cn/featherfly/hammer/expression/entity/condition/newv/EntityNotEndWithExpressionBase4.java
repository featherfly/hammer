
package cn.featherfly.hammer.expression.entity.condition.newv;

import java.util.function.Predicate;

import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.common.repository.IgnoreStrategy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.condition.newv.NotEndWithSupplierExpression4;

/**
 * The Interface EntityNotEndWithExpressionBase4.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <E2> the generic type
 * @param <E3> the generic type
 * @param <E4> the generic type
 * @param <C>  the generic type
 * @param <L>  the generic type
 */
public interface EntityNotEndWithExpressionBase4<E, E2, E3, E4, C extends ConditionExpression,
        L extends LogicExpression<C, L>>
        extends EntityNotEndWithExpressionBase3<E, E2, E3, C, L>, NotEndWithSupplierExpression4<C, L> {

    /**
     * not end with value. 不以value结尾.
     *
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    default L new4(SerializableFunction<E4, String> name, String value) {
        return new4(name, value, MatchStrategy.AUTO);
    }

    /**
     * not end with value. 不以value结尾.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L new4(SerializableFunction<E4, String> name, String value, IgnoreStrategy ignoreStrategy) {
        return new4(name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * not end with value. 不以value结尾.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L new4(SerializableFunction<E4, String> name, String value, Predicate<String> ignoreStrategy) {
        return new4(name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * not end with value. 不以value结尾.
     *
     * @param name          the name
     * @param value         the value
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    L new4(SerializableFunction<E4, String> name, String value, MatchStrategy matchStrategy);

    /**
     * not end with value. 不以value结尾.
     *
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L new4(SerializableFunction<E4, String> name, String value, MatchStrategy matchStrategy,
            IgnoreStrategy ignoreStrategy) {
        return new4(name, value, matchStrategy, (Predicate<String>) ignoreStrategy::test);
    }

    /**
     * not end with value. 不以value结尾.
     *
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L new4(SerializableFunction<E4, String> name, String value, MatchStrategy matchStrategy,
            Predicate<String> ignoreStrategy);

}