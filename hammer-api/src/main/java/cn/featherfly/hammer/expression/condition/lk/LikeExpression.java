
package cn.featherfly.hammer.expression.condition.lk;

import java.util.function.Predicate;

import cn.featherfly.common.function.serializable.SerializableStringSupplier;
import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.common.repository.Field;
import cn.featherfly.common.repository.IgnoreStrategy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * like expression.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface LikeExpression<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends ConditionExpression {

    /**
     * like value.
     *
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    default L lk(Field name, String value) {
        return lk(name.name(), value);
    }

    /**
     * like value.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L lk(Field name, String value, IgnoreStrategy ignoreStrategy) {
        return lk(name.name(), value, ignoreStrategy);
    }

    /**
     * like value.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L lk(Field name, String value, Predicate<String> ignoreStrategy) {
        return lk(name.name(), value, ignoreStrategy);
    }

    /**
     * like value.
     *
     * @param name          参数名称
     * @param value         参数值
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    default L lk(Field name, String value, MatchStrategy matchStrategy) {
        return lk(name.name(), value, matchStrategy);
    }

    /**
     * like value.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L lk(Field name, String value, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {
        return lk(name.name(), value, matchStrategy, ignoreStrategy);
    }

    /**
     * like value.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L lk(Field name, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return lk(name.name(), value, matchStrategy, ignoreStrategy);
    }

    /**
     * like value.
     *
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    default L lk(String name, String value) {
        return lk(name, value, MatchStrategy.AUTO);
    }

    /**
     * like value.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L lk(String name, String value, IgnoreStrategy ignoreStrategy) {
        return lk(name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * like value.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L lk(String name, String value, Predicate<String> ignoreStrategy) {
        return lk(name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * like value.
     *
     * @param name          参数名称
     * @param value         参数值
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    L lk(String name, String value, MatchStrategy matchStrategy);

    /**
     * like value.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L lk(String name, String value, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {
        return lk(name, value, matchStrategy, (Predicate<String>) ignoreStrategy::test);
    }

    /**
     * like value.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L lk(String name, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy);

    /**
     * like value.
     *
     * @param property bean property
     * @return LogicExpression
     */
    default L lk(SerializableStringSupplier property) {
        return lk(property, MatchStrategy.AUTO);
    }

    /**
     * like value.
     *
     * @param property       bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L lk(SerializableStringSupplier property, IgnoreStrategy ignoreStrategy) {
        return lk(property, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * like value.
     *
     * @param property       bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L lk(SerializableStringSupplier property, Predicate<String> ignoreStrategy) {
        return lk(property, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * Lk.
     *
     * @param property      bean property
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    L lk(SerializableStringSupplier property, MatchStrategy matchStrategy);

    /**
     * Lk.
     *
     * @param property       bean property
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L lk(SerializableStringSupplier property, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {
        return lk(property, matchStrategy, (Predicate<String>) ignoreStrategy::test);
    }

    /**
     * Lk.
     *
     * @param property       bean property
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L lk(SerializableStringSupplier property, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy);
}