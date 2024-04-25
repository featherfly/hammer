
package cn.featherfly.hammer.expression.entity.condition.newv;

import java.util.function.Predicate;

import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.common.repository.IgnoreStrategy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.condition.newv.NotEndWithSupplierExpression;

/**
 * The Interface EntityNotEndWithExpression.
 *
 * @author zhongj
 * @param <E> query type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface EntityNotEndWithExpression<E, C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends NotEndWithSupplierExpression<C, L> {

    /**
     * not end with value. 不以value结尾.
     *
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    default L newv(SerializableFunction<E, String> name, String value) {
        return newv(name, value, MatchStrategy.AUTO);
    }

    /**
     * not end with value. 不以value结尾.
     *
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L newv(SerializableFunction<E, String> name, String value, IgnoreStrategy ignoreStrategy) {
        return newv(name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * not end with value. 不以value结尾.
     *
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L newv(SerializableFunction<E, String> name, String value, Predicate<String> ignoreStrategy) {
        return newv(name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * not end with value. 不以value结尾.
     *
     * @param name        the name
     * @param value       the value
     * @param queryPolicy the query policy
     * @return LogicExpression
     */
    L newv(SerializableFunction<E, String> name, String value, MatchStrategy matchStrategy);

    /**
     * not end with value. 不以value结尾.
     *
     * @param name           the name
     * @param value          the value
     * @param queryPolicy    the query policy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L newv(SerializableFunction<E, String> name, String value, MatchStrategy matchStrategy,
            IgnoreStrategy ignoreStrategy) {
        return newv(name, value, matchStrategy, (Predicate<String>) ignoreStrategy::test);
    }

    /**
     * not end with value. 不以value结尾.
     *
     * @param name           the name
     * @param value          the value
     * @param queryPolicy    the query policy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L newv(SerializableFunction<E, String> name, String value, MatchStrategy matchStrategy,
            Predicate<String> ignoreStrategy);
}