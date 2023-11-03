
package cn.featherfly.hammer.expression.entity.condition.lk;

import java.util.function.Predicate;

import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.common.repository.IgnoreStrategy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.condition.lk.LikeSupplierExpression5;

/**
 * The Interface EntityLikeExpressionBase5.
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
public interface EntityLikeExpressionBase5<E, E2, E3, E4, E5, C extends ConditionExpression,
        L extends LogicExpression<C, L>>
        extends EntityLikeExpressionBase4<E, E2, E3, E4, C, L>, LikeSupplierExpression5<C, L> {

    /**
     * like value.
     *
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    default L lk5(SerializableFunction<E5, String> name, String value) {
        return lk5(name, value, MatchStrategy.AUTO);
    }

    /**
     * like value.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L lk5(SerializableFunction<E5, String> name, String value, IgnoreStrategy ignoreStrategy) {
        return lk5(name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * like value.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L lk5(SerializableFunction<E5, String> name, String value, Predicate<String> ignoreStrategy) {
        return lk5(name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * like value.
     *
     * @param name        the name
     * @param value       the value
     * @param queryPolicy the query policy
     * @return LogicExpression
     */
    L lk5(SerializableFunction<E5, String> name, String value, MatchStrategy matchStrategy);

    /**
     * like value.
     *
     * @param name           the name 参数名称
     * @param value          the value
     * @param queryPolicy    the query policy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L lk5(SerializableFunction<E5, String> name, String value, MatchStrategy matchStrategy,
            IgnoreStrategy ignoreStrategy) {
        return lk5(name, value, matchStrategy, (Predicate<String>) ignoreStrategy::test);
    }

    /**
     * like value.
     *
     * @param name           the name
     * @param value          the value
     * @param queryPolicy    the query policy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L lk5(SerializableFunction<E5, String> name, String value, MatchStrategy matchStrategy,
            Predicate<String> ignoreStrategy);
}