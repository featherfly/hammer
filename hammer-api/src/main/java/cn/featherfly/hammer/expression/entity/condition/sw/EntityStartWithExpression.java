
package cn.featherfly.hammer.expression.entity.condition.sw;

import java.util.function.Predicate;

import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.common.repository.IgnoreStrategy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.condition.sw.StartWithSupplierExpression;

/**
 * The Interface EntityStartWithExpression.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface EntityStartWithExpression<E, C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends StartWithSupplierExpression<C, L> {

    //    /**
    //     * start with value. 以value开始.
    //     *
    //     * @param consumer the consumer
    //     * @return LogicExpression
    //     */
    //    L sw(Consumer<EntityStartWithExpression<E, C, L>> consumer);

    /**
     * start with value. 以value开始.
     *
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    default L sw(SerializableFunction<E, String> name, String value) {
        return sw(name, value, MatchStrategy.AUTO);
    }

    /**
     * start with value. 以value开始.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L sw(SerializableFunction<E, String> name, String value, IgnoreStrategy ignoreStrategy) {
        return sw(name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * start with value. 以value开始.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L sw(SerializableFunction<E, String> name, String value, Predicate<String> ignoreStrategy) {
        return sw(name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * start with value. 以value开始.
     *
     * @param name        the name
     * @param value       the value
     * @param queryPolicy the query policy
     * @return LogicExpression
     */
    L sw(SerializableFunction<E, String> name, String value, MatchStrategy matchStrategy);

    /**
     * start with value. 以value开始.
     *
     * @param name           the name
     * @param value          the value
     * @param queryPolicy    the query policy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L sw(SerializableFunction<E, String> name, String value, MatchStrategy matchStrategy,
            IgnoreStrategy ignoreStrategy) {
        return sw(name, value, matchStrategy, (Predicate<String>) ignoreStrategy::test);
    }

    /**
     * start with value. 以value开始.
     *
     * @param name           the name
     * @param value          the value
     * @param queryPolicy    the query policy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L sw(SerializableFunction<E, String> name, String value, MatchStrategy matchStrategy,
            Predicate<String> ignoreStrategy);
}