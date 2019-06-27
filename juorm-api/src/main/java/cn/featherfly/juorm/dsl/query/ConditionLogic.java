
package cn.featherfly.juorm.dsl.query;

import cn.featherfly.juorm.dml.builder.SortBuilder;
import cn.featherfly.juorm.expression.LogicExpression;

/**
 * <p>
 * 逻辑条件
 * </p>
 *
 * @author zhongj
 */
public interface ConditionLogic extends ConditionLimit, QueryExecutor, QueryValueExecutor,
        LogicExpression<ConditionExpression, ConditionLogic> {
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
    // * 结束当前条件逻辑组并返回上一级逻辑组
    // *
    // * @return parent LogicBuilder
    // */
    // @Override
    // ConditionLogic parent();

    /**
     * 结束当前条件并进入排序器
     *
     * @return SortBuilder
     */
    SortBuilder sort();
}
