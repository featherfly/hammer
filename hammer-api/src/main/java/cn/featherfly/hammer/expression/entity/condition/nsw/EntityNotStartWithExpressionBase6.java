
package cn.featherfly.hammer.expression.entity.condition.nsw;

import java.util.function.Predicate;

import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.function.serializable.SerializableStringSupplier;
import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * The Interface EntityNotStartWithExpressionBase6.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <E2> the generic type
 * @param <E3> the generic type
 * @param <E4> the generic type
 * @param <E5> the generic type
 * @param <E6> the generic type
 * @param <C>  the generic type
 * @param <L>  the generic type
 */
public interface EntityNotStartWithExpressionBase6<E, E2, E3, E4, E5, E6, C extends ConditionExpression,
        L extends LogicExpression<C, L>> extends EntityNotStartWithExpressionBase5<E, E2, E3, E4, E5, C, L> {

    /**
     * not start with value. 不以value开始.
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    default L nsw6(SerializableFunction<E6, String> name, String value) {
        return nsw6(name, value, MatchStrategy.AUTO);
    }

    /**
     * not start with value. 不以value开始.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L nsw6(SerializableFunction<E6, String> name, String value, Predicate<String> ignoreStrategy) {
        return nsw6(name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * not start with value. 不以value开始.
     *
     * @param name        the name
     * @param value       the value
     * @param queryPolicy the query policy
     * @return LogicExpression
     */
    L nsw6(SerializableFunction<E6, String> name, String value, MatchStrategy matchStrategy);

    /**
     * not start with value. 不以value开始.
     *
     * @param name           the name
     * @param value          the value
     * @param queryPolicy    the query policy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L nsw6(SerializableFunction<E6, String> name, String value, MatchStrategy matchStrategy,
            Predicate<String> ignoreStrategy);

    /**
     * not start with value. 不以value开始.
     *
     * @param property 对象属性
     * @return LogicExpression
     */
    default L nsw6(SerializableStringSupplier property) {
        return nsw6(property, MatchStrategy.AUTO);
    }

    /**
     * not start with value. 不以value开始.
     *
     * @param property       对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L nsw6(SerializableStringSupplier property, Predicate<String> ignoreStrategy) {
        return nsw6(property, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * not start with value. 不以value开始.
     *
     * @param property    the property
     * @param queryPolicy the query policy
     * @return LogicExpression
     */
    L nsw6(SerializableStringSupplier property, MatchStrategy matchStrategy);

    /**
     * not start with value. 不以value开始.
     *
     * @param property       the property
     * @param queryPolicy    the query policy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L nsw6(SerializableStringSupplier property, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy);

}