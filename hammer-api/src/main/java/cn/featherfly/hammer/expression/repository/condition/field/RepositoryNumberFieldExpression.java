
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2024-03-29 15:06:29
 * @Copyright: 2024 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.repository.condition.field;

import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.condition.field.NumberFieldExpression;

/**
 * RepositoryNumberFieldExpression.
 *
 * @author zhongj
 * @param <N> the number type
 * @param <C> condition expression
 * @param <L> logic expression
 */
public interface RepositoryNumberFieldExpression<N extends Number, C extends ConditionExpression,
        L extends LogicExpression<C, L>> extends NumberFieldExpression<N, C, L> {

}
