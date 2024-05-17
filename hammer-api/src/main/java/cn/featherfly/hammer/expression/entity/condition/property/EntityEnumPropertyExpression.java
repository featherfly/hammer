
/*
 * All rights Reserved, Designed By zhongj
 * @Title: EntityEnumExpression.java
 * @Package cn.featherfly.hammer.expression.condition.type.property
 * @Description: EntityEnumExpression
 * @author: zhongj
 * @date: 2022-11-28 14:16:28
 * @Copyright: 2022 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.entity.condition.property;

import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.condition.field.EnumFieldExpression;

/**
 * EntityEnumExpression.
 *
 * @author zhongj
 * @param <E> the enum type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface EntityEnumPropertyExpression<E extends Enum<E>, C extends ConditionExpression,
    L extends LogicExpression<C, L>> extends EnumFieldExpression<E, C, L> {

}
