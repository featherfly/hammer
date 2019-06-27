
package cn.featherfly.juorm.dsl.query;

import cn.featherfly.juorm.dml.builder.SortBuilder;
import cn.featherfly.juorm.expression.LogicGroupExpression;

/**
 * <p>
 * 逻辑条件
 * </p>
 *
 * @author zhongj
 */
public interface ConditionGroupLogic extends ConditionLimit, QueryExecutor, QueryValueExecutor,
        LogicGroupExpression<ConditionGroupExpression, ConditionGroupLogic> {
    // /**
    // * <p>
    // * 逻辑与
    // * </p>
    // *
    // * @return ExpressionBuilder
    // */
    // @Override
    // ConditionExpression and();
    //
    // /**
    // * <p>
    // * 逻辑或
    // * </p>
    // *
    // * @return ExpressionBuilder
    // */
    // @Override
    // ConditionExpression or();

    // /**
    // * 结束当前条件逻辑组并返回上一级逻辑组 {@link ExpressionBuilder#group()}
    // *
    // * @return parent LogicBuilder
    // */
    // @Override
    // ConditionGroupLogic parent();

    /**
     * 结束当前条件并进入排序器
     *
     * @return SortBuilder
     */
    SortBuilder sort();
}
