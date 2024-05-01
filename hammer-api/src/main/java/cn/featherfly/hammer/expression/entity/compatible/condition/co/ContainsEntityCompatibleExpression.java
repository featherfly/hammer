
/*
 * All rights Reserved, Designed By zhongj
 * @Title: Entities.java
 * @Package cn.featherfly.hammer.expression.entity.condition.eq
 * @Description: Entities
 * @author: zhongj
 * @date: 2023-07-18 14:44:18
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.entity.compatible.condition.co;

import java.util.function.Predicate;

import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.hammer.expression.entity.condition.co.ContainsEntityExpression;

/**
 * The Interface ContainsEntityCompatibleExpression.
 *
 * @author zhongj
 * @param <E> the element type
 */
public interface ContainsEntityCompatibleExpression<E> extends ContainsEntityExpression<E> {

    /**
     * contains value. 包含value.
     *
     * @param property the property
     * @param value    the value
     */
    void accept(String property, String value);

    /**
     * contains value. 包含value.
     *
     * @param property      the property
     * @param value         the value
     * @param matchStrategy the match strategy
     */
    void accept(String property, String value, MatchStrategy matchStrategy);

    /**
     * contains value. 包含value.
     *
     * @param property       the property
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     */
    void accept(String property, String value, Predicate<String> ignoreStrategy);

    /**
     * contains value. 包含value.
     *
     * @param property       the property
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     */
    void accept(String property, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy);
}
