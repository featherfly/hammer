
/*
 * All rights Reserved, Designed By zhongj
 * @Title: EntityLocalDateExpression.java
 * @Package cn.featherfly.hammer.expression.condition.type.property
 * @Description: EntityLocalDateExpression
 * @author: zhongj
 * @date: 2022-11-28 14:16:28
 * @Copyright: 2022 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.entity.condition.property;

import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.condition.field.LocalDateFieldExpression;

/**
 * EntityLocalDateExpression.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface EntityLocalDatePropertyExpression<C extends ConditionExpression, L extends LogicExpression<C, L>>
    extends LocalDateFieldExpression<C, L> {

}
