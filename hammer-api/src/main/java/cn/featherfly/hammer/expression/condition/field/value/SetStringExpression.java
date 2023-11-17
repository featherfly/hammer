
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2023-11-10 15:17:10
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.condition.field.value;

import java.util.function.Predicate;

import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;

/**
 * set string value expression.
 *
 * @author zhongj
 */
public interface SetStringExpression extends SetValueMatchStrategyExpression<String> {

    /**
     * {@inheritDoc}
     */
    @Override
    default void value(String value) {
        value(value, MatchStrategy.AUTO);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default void value(String value, Predicate<String> ignoreStrategy) {
        value(value, MatchStrategy.AUTO, ignoreStrategy);
    }
}
