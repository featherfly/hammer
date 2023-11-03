
package cn.featherfly.hammer.expression.entity.condition.ew;

import java.util.function.Predicate;

import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.condition.ew.EndWithSupplierExpression4;

/**
 * The Interface EntityEndWithExpressionBase4.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <E2> the generic type
 * @param <E3> the generic type
 * @param <E4> the generic type
 * @param <C>  the generic type
 * @param <L>  the generic type
 */
public interface EntityEndWithExpressionBase4<E, E2, E3, E4, C extends ConditionExpression,
        L extends LogicExpression<C, L>>
        extends EntityEndWithExpressionBase3<E, E2, E3, C, L>, EndWithSupplierExpression4<C, L> {

    /**
     * end with value. 以value结尾.
     *
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    default L ew4(SerializableFunction<E4, String> name, String value) {
        return ew4(name, value, MatchStrategy.AUTO);
    }

    /**
     * end with value. 以value结尾.
     *
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ew4(SerializableFunction<E4, String> name, String value, Predicate<String> ignoreStrategy) {
        return ew4(name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * end with value. 以value结尾.
     *
     * @param name        the name
     * @param value       the value
     * @param queryPolicy the query policy
     * @return LogicExpression
     */
    L ew4(SerializableFunction<E4, String> name, String value, MatchStrategy matchStrategy);

    /**
     * end with value. 以value结尾.
     *
     * @param name           the name
     * @param value          the value
     * @param queryPolicy    the query policy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ew4(SerializableFunction<E4, String> name, String value, MatchStrategy matchStrategy,
            Predicate<String> ignoreStrategy);

}