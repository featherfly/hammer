
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2023-07-28 19:23:28
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.condition;

import java.util.function.Predicate;

/**
 * abstract indexable condition expression.
 *
 * @author zhongj
 * @param <C> the element type
 */
public class AbstractIndexableConditionExpression<C extends ConditionExpression> implements IgnorableExpression {

    /** The index. */
    protected int index;

    /** The expression. */
    protected C expression;

    protected Predicate<Object> ignoreStrategy;

    /**
     * Instantiates a new abstract condition entity expression.
     *
     * @param index          the index
     * @param expression     the expression
     * @param ignoreStrategy the ignore strategy
     */
    protected AbstractIndexableConditionExpression(int index, C expression, Predicate<Object> ignoreStrategy) {
        super();
        this.index = index;
        this.expression = expression;
        this.ignoreStrategy = ignoreStrategy;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Predicate<Object> getIgnoreStrategy() {
        return ignoreStrategy;
    }
}
