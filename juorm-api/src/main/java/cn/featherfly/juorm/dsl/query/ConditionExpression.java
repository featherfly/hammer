
package cn.featherfly.juorm.dsl.query;

import cn.featherfly.juorm.expression.ConditionsExpression;

/**
 * <p>
 * Expression Builder 表达式建造者
 * </p>
 *
 * @author zhongj
 */
public interface ConditionExpression extends ConditionsExpression<ConditionExpression, ConditionLogic> {
    // /**
    // * 小于
    // *
    // * @param name
    // * 参数名称
    // * @param value
    // * 参数值
    // * @return ConditionLogic
    // */
    // ConditionLogic lt(String name, Object value);
    //
    // /**
    // * 小于等于
    // *
    // * @param name
    // * 参数名称
    // * @param value
    // * 参数值
    // * @return ConditionLogic
    // */
    // ConditionLogic le(String name, Object value);
    //
    // /**
    // * 等于
    // *
    // * @param name
    // * 参数名称
    // * @param value
    // * 参数值
    // * @return ConditionLogic
    // */
    // @Override
    // ConditionLogic eq(String name, Object value);
    //
    // /**
    // * 不等于
    // *
    // * @param name
    // * 参数名称
    // * @param value
    // * 参数值
    // * @return ConditionLogic
    // */
    // @Override
    // ConditionLogic ne(String name, Object value);
    //
    // /**
    // * 大于等于
    // *
    // * @param name
    // * 参数名称
    // * @param value
    // * 参数值
    // * @return ConditionLogic
    // */
    // ConditionLogic ge(String name, Object value);
    //
    // /**
    // * 大于
    // *
    // * @param name
    // * 参数名称
    // * @param value
    // * 参数值
    // * @return ConditionLogic
    // */
    // ConditionLogic gt(String name, Object value);
    //
    // /**
    // * 以XX开始
    // *
    // * @param name
    // * 参数名称
    // * @param value
    // * 参数值
    // * @return ConditionLogic
    // */
    // ConditionLogic sw(String name, Object value);
    //
    // /**
    // * 包含
    // *
    // * @param name
    // * 参数名称
    // * @param value
    // * 参数值
    // * @return ConditionLogic
    // */
    // ConditionLogic co(String name, Object value);
    //
    // /**
    // * 以XX结尾
    // *
    // * @param name
    // * 参数名称
    // * @param value
    // * 参数值
    // * @return ConditionLogic
    // */
    // ConditionLogic ew(String name, Object value);
    //
    // /**
    // * 包含指定，sql中的in
    // *
    // * @param name
    // * 参数名称
    // * @param value
    // * 参数值
    // * @return ConditionLogic
    // */
    // @Override
    // ConditionLogic in(String name, Object value);
    //
    // /**
    // * 不包含指定，sql中的not in
    // *
    // * @param name
    // * 参数名称
    // * @param value
    // * 参数值
    // * @return ConditionLogic
    // */
    // @Override
    // ConditionLogic nin(String name, Object value);
    //
    // /**
    // * 为null的
    // *
    // * @param name
    // * 参数名称
    // * @return ConditionLogic
    // */
    // @Override
    // ConditionLogic isn(String name);
    //
    // /**
    // * 不为null的
    // *
    // * @param name
    // * 参数名称
    // * @return ConditionLogic
    // */
    // @Override
    // ConditionLogic inn(String name);

    // /**
    // * <p>
    // * 在当前内部开启一个新的条件逻辑组
    // * </p>
    // *
    // * @return 新条件逻辑组
    // */
    // ConditionExpression group();
}
