
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2023-11-13 17:53:13
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.condition.field.value;

import java.util.function.Predicate;

import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;

/**
 * set String array expression.
 *
 * @author zhongj
 */
public interface SetStringArrayExpression extends SetStringExpression, SetArrayExpression<String> {

    /**
     * {@inheritDoc}
     */
    @Override
    default void value(String... value) {
        value(value, MatchStrategy.AUTO);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default void value(String[] value, Predicate<String[]> ignoreStrategy) {
        value(value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * Value.
     *
     * @param value         the value
     * @param matchStrategy the match strategy
     */
    void value(String[] value, MatchStrategy matchStrategy);

    /**
     * Value.
     *
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     */
    void value(String[] value, MatchStrategy matchStrategy, Predicate<String[]> ignoreStrategy);
}
