
package cn.featherfly.hammer.expression.condition;

import cn.featherfly.hammer.expression.query.sort.SortExpression;

/**
 * <p>
 * 逻辑条件
 * </p>
 *
 * @author zhongj
 */
public interface LogicGroupSortExpression<C extends ConditionsGroupExpression<C, L>,
        L extends LogicGroupSortExpression<C, L, S>, S extends SortExpression<S>> extends LogicGroupExpression<C, L> {

    /**
     * 结束当前条件逻辑组并返回上一级逻辑组
     *
     * @return parent LogicBuilder
     */
    S sort();
}
