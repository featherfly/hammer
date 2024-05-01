
package cn.featherfly.hammer.expression.entity.condition.lk;

import java.util.function.Predicate;

import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.common.repository.IgnoreStrategy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.condition.lk.LikeSupplierExpression;

/**
 * The Interface EntityLikeExpression.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface EntityLikeExpression<E, C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends LikeSupplierExpression<C, L> {

    /**
     * like value.
     *
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    default L lk(SerializableFunction<E, String> name, String value) {
        return lk(name, value, MatchStrategy.AUTO);
    }

    /**
     * like value.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L lk(SerializableFunction<E, String> name, String value, IgnoreStrategy ignoreStrategy) {
        return lk(name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * like value.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L lk(SerializableFunction<E, String> name, String value, Predicate<String> ignoreStrategy) {
        return lk(name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * like value.
     *
     * @param name          the name 参数名称
     * @param value         the value
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    L lk(SerializableFunction<E, String> name, String value, MatchStrategy matchStrategy);

    /**
     * like value.
     *
     * @param name           the name 参数名称
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L lk(SerializableFunction<E, String> name, String value, MatchStrategy matchStrategy,
            IgnoreStrategy ignoreStrategy) {
        return lk(name, value, matchStrategy, (Predicate<String>) ignoreStrategy::test);
    }

    /**
     * like value.
     *
     * @param name           the name 参数名称
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L lk(SerializableFunction<E, String> name, String value, MatchStrategy matchStrategy,
            Predicate<String> ignoreStrategy);
}