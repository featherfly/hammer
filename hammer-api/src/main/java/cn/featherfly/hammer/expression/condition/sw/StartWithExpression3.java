/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.condition.sw;

import java.util.function.Predicate;

import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.common.repository.AliasField;
import cn.featherfly.common.repository.Field;
import cn.featherfly.common.repository.IgnoreStrategy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * start with expression3.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface StartWithExpression3<C extends ConditionExpression, L extends LogicExpression<C, L>> {

    /**
     * start with value. 以value开始.
     *
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default L sw3(Field field, String value) {
        return sw3(field.name(), value);
    }

    /**
     * start with value. 以value开始.
     *
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L sw3(Field field, String value, IgnoreStrategy ignoreStrategy) {
        return sw3(field.name(), value, ignoreStrategy);
    }

    /**
     * start with value. 以value开始.
     *
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L sw3(Field field, String value, Predicate<String> ignoreStrategy) {
        return sw3(field.name(), value, ignoreStrategy);
    }

    /**
     * start with value. 以value开始.
     *
     * @param field         the field
     * @param value         the value
     * @param matchStrategy the query strategy
     * @return LogicExpression
     */
    default L sw3(Field field, String value, MatchStrategy matchStrategy) {
        return sw3(field.name(), value, matchStrategy);
    }

    /**
     * start with value. 以value开始.
     *
     * @param field          the field
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L sw3(Field field, String value, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {
        return sw3(field.name(), value, matchStrategy, ignoreStrategy);
    }

    /**
     * start with value. 以value开始.
     *
     * @param field          the field
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L sw3(Field field, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return sw3(field.name(), value, matchStrategy, ignoreStrategy);
    }

    /**
     * start with value. 以value开始.
     *
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default L sw3(AliasField field, String value) {
        return sw3(field.getAliasOrName(), value);
    }

    /**
     * start with value. 以value开始.
     *
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L sw3(AliasField field, String value, IgnoreStrategy ignoreStrategy) {
        return sw3(field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * start with value. 以value开始.
     *
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L sw3(AliasField field, String value, Predicate<String> ignoreStrategy) {
        return sw3(field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * start with value. 以value开始.
     *
     * @param field         the field
     * @param value         the value
     * @param matchStrategy the query strategy
     * @return LogicExpression
     */
    default L sw3(AliasField field, String value, MatchStrategy matchStrategy) {
        return sw3(field.getAliasOrName(), value, matchStrategy);
    }

    /**
     * start with value. 以value开始.
     *
     * @param field          the field
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L sw3(AliasField field, String value, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {
        return sw3(field.getAliasOrName(), value, matchStrategy, ignoreStrategy);
    }

    /**
     * start with value. 以value开始.
     *
     * @param field          the field
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L sw3(AliasField field, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return sw3(field.getAliasOrName(), value, matchStrategy, ignoreStrategy);
    }

    /**
     * start with value. 以value开始.
     *
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    default L sw3(String name, String value) {
        return sw3(name, value, MatchStrategy.AUTO);
    }

    /**
     * start with value. 以value开始.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L sw3(String name, String value, IgnoreStrategy ignoreStrategy) {
        return sw3(name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * start with value. 以value开始.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L sw3(String name, String value, Predicate<String> ignoreStrategy) {
        return sw3(name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * start with value. 以value开始.
     *
     * @param name          the name
     * @param value         the value
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    L sw3(String name, String value, MatchStrategy matchStrategy);

    /**
     * start with value. 以value开始.
     *
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L sw3(String name, String value, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {
        return sw3(name, value, matchStrategy, (Predicate<String>) ignoreStrategy::test);
    }

    /**
     * start with value. 以value开始.
     *
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L sw3(String name, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy);
}