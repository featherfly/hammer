
package cn.featherfly.hammer.expression.entity.condition.nco;

import java.util.function.Predicate;

import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.common.repository.IgnoreStrategy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.condition.nco.NotContainsSupplierExpression;

/**
 * The Interface EntityNotContainsExpression.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface EntityNotContainsExpression<E, C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends NotContainsSupplierExpression<C, L> {

    /**
     * not contains value. 不包含value.
     *
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    default L nco(SerializableFunction<E, String> name, String value) {
        return nco(name, value, MatchStrategy.AUTO);
    }

    /**
     * not contains value. 不包含value.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L nco(SerializableFunction<E, String> name, String value, IgnoreStrategy ignoreStrategy) {
        return nco(name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * not contains value. 不包含value.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L nco(SerializableFunction<E, String> name, String value, Predicate<String> ignoreStrategy) {
        return nco(name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * not contains value. 不包含value.
     *
     * @param name          the name
     * @param value         the value
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    L nco(SerializableFunction<E, String> name, String value, MatchStrategy matchStrategy);

    /**
     * not contains value. 不包含value.
     *
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L nco(SerializableFunction<E, String> name, String value, MatchStrategy matchStrategy,
            IgnoreStrategy ignoreStrategy) {
        return nco(name, value, matchStrategy, (Predicate<String>) ignoreStrategy::test);
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
    L nco(SerializableFunction<E, String> name, String value, MatchStrategy matchStrategy,
            Predicate<String> ignoreStrategy);

}