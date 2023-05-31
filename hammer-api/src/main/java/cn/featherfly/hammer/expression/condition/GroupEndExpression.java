
package cn.featherfly.hammer.expression.condition;

/**
 * condition expression.
 *
 * @author zhongj
 */
public interface GroupEndExpression<L> {

    /**
     * 结束当前条件逻辑组并返回上一级逻辑组
     *
     * @return parent LogicBuilder
     */
    L endGroup();
}
