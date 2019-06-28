
package cn.featherfly.juorm.expression;

/**
 * <p>
 * 逻辑条件
 * </p>
 *
 * @author zhongj
 */
public interface LogicGroupSortExpression<C extends ConditionGroupExpression<C, L>, L extends LogicGroupSortExpression<C, L, S>, S extends SortExpression>
        extends LogicGroupExpression<C, L> {

    /**
     * 结束当前条件逻辑组并返回上一级逻辑组
     *
     * @return parent LogicBuilder
     */
    S sort();
}
