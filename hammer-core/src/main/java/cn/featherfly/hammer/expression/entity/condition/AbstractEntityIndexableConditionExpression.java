
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2023-07-28 19:23:28
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.entity.condition;

import java.util.function.Predicate;

import cn.featherfly.hammer.expression.condition.AbstractIndexableConditionExpression;
import cn.featherfly.hammer.expression.condition.ConditionExpression;

/**
 * abstract entity indexable condition expression.
 *
 * @author zhongj
 * @param <C> the generic type
 */
public class AbstractEntityIndexableConditionExpression<C extends ConditionExpression>
        extends AbstractIndexableConditionExpression<C> {

    /**
     * Instantiates a new abstract condition entity expression.
     *
     * @param index          the index
     * @param expression     the expression
     * @param ignoreStrategy the ignore strategy
     */
    protected AbstractEntityIndexableConditionExpression(int index, C expression, Predicate<Object> ignoreStrategy) {
        super(index, expression, ignoreStrategy);
    }
}
