
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2024-03-29 15:06:29
 * @Copyright: 2024 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.repository.condition.field;

import java.util.Date;

import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.condition.field.DateFieldExpression;

/**
 * RepositoryDateFieldExpression.
 *
 * @author zhongj
 * @param <D> the generic type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface RepositoryDateFieldExpression<D extends Date, C extends ConditionExpression,
    L extends LogicExpression<C, L>> extends DateFieldExpression<D, C, L> {

}
