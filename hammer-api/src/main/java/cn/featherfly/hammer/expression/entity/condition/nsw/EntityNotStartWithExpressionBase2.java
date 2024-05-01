
package cn.featherfly.hammer.expression.entity.condition.nsw;

import java.util.function.Predicate;

import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.common.repository.IgnoreStrategy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.condition.nsw.NotStartWithSupplierExpression2;

/**
 * The Interface EntityNotStartWithExpressionBase2.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <E2> the generic type
 * @param <C>  the generic type
 * @param <L>  the generic type
 */
public interface EntityNotStartWithExpressionBase2<E, E2, C extends ConditionExpression,
        L extends LogicExpression<C, L>>
        extends EntityNotStartWithExpression<E, C, L>, NotStartWithSupplierExpression2<C, L> {

    /**
     * not start with value. 不以value开始.
     *
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    default L nsw2(SerializableFunction<E2, String> name, String value) {
        return nsw2(name, value, MatchStrategy.AUTO);
    }

    /**
     * not start with value. 不以value开始.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L nsw2(SerializableFunction<E2, String> name, String value, IgnoreStrategy ignoreStrategy) {
        return nsw2(name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * not start with value. 不以value开始.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L nsw2(SerializableFunction<E2, String> name, String value, Predicate<String> ignoreStrategy) {
        return nsw2(name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * not start with value. 不以value开始.
     *
     * @param name          the name
     * @param value         the value
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    L nsw2(SerializableFunction<E2, String> name, String value, MatchStrategy matchStrategy);

    /**
     * not start with value. 不以value开始.
     *
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L nsw2(SerializableFunction<E2, String> name, String value, MatchStrategy matchStrategy,
            IgnoreStrategy ignoreStrategy) {
        return nsw2(name, value, matchStrategy, (Predicate<String>) ignoreStrategy::test);
    }

    /**
     * not start with value. 不以value开始.
     *
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L nsw2(SerializableFunction<E2, String> name, String value, MatchStrategy matchStrategy,
            Predicate<String> ignoreStrategy);
}