
/*
 * All rights Reserved, Designed By zhongj
 * @Title: EntityDateExpression.java
 * @Package cn.featherfly.hammer.expression.condition.type.property
 * @Description: EntityDateExpression
 * @author: zhongj
 * @date: 2022-11-28 14:16:28
 * @Copyright: 2022 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.entity.condition.property;

import java.util.Date;

import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.condition.field.DateFieldExpression;

/**
 * EntityDateExpression.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <D> the generic type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface EntityDatePropertyExpression<E, D extends Date, C extends ConditionExpression,
        L extends LogicExpression<C, L>> extends DateFieldExpression<D, C, L> {

}
