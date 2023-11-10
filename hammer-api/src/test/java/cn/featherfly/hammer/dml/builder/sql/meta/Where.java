
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2023-11-10 18:22:10
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.dml.builder.sql.meta;

import cn.featherfly.common.repository.Repository;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * Where.
 *
 * @author zhongj
 */
public interface Where<R extends Repository, C extends ConditionExpression, L extends LogicExpression<C, L>> {

    FilterableStringField<C, L> alias(String alias);
}
