
/*
 * All rights Reserved, Designed By zhongj
 * @Title: EntityConditionFunctionIntPropertyExpression.java
 * @Package cn.featherfly.hammer.expression.entity.condition
 * @Description: EntityConditionFunctionIntPropertyExpression
 * @author: zhongj
 * @date: 2023-07-18 19:17:18
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.entity.condition;

/**
 * The Interface ConditionEntityExpressionEnumAndArrayPropertyExpression.
 *
 * @author zhongj
 * @param <V> the enum value type
 */
public interface ConditionEntityExpressionEnumAndArrayPropertyExpression<V extends Enum<V>> extends
        ConditionEntityExpressionEnumPropertyExpression<V>, ConditionEntityExpressionArrayPropertyExpression<V> {

}
