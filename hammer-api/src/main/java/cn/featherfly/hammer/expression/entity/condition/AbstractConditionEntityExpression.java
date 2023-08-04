
/*
 * All rights Reserved, Designed By zhongj
 * @Title: AbstractConditionEntityExpression.java
 * @Package cn.featherfly.hammer.expression.entity.condition
 * @Description: AbstractConditionEntityExpression
 * @author: zhongj
 * @date: 2023-07-28 19:23:28
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.entity.condition;

/**
 * AbstractConditionEntityExpression.
 *
 * @author zhongj
 * @param <E> the element type
 */
public class AbstractConditionEntityExpression<E extends MulitiEntityConditionExpression> {

    /** The index. */
    protected int index;

    /** The expression. */
    protected E expression;

    /**
     * Instantiates a new abstract condition entity expression.
     *
     * @param index      the index
     * @param expression the expression
     */
    protected AbstractConditionEntityExpression(int index, E expression) {
        super();
        this.index = index;
        this.expression = expression;
    }
}
