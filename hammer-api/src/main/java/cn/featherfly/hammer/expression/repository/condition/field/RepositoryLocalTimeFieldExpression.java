
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2024-03-29 15:06:29
 * @Copyright: 2024 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.repository.condition.field;

import cn.featherfly.common.repository.AliasRepository;
import cn.featherfly.common.repository.FieldAware;
import cn.featherfly.common.repository.RepositoryAwareField;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.condition.field.LocalTimeFieldExpression;

/**
 * RepositoryLocalTimeFieldExpression.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface RepositoryLocalTimeFieldExpression<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends LocalTimeFieldExpression<C, L>, FieldAware<RepositoryAwareField<AliasRepository>> {

}
