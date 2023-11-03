
/*
 * All rights Reserved, Designed By zhongj
 * @Title: Entities.java
 * @Package cn.featherfly.hammer.expression.entity.condition.eq
 * @Description: Entities
 * @author: zhongj
 * @date: 2023-07-18 14:44:18
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.repository.condition.field;

import cn.featherfly.hammer.expression.condition.GroupExpression;
import cn.featherfly.hammer.expression.repository.condition.RepositoryFieldExpression;

/**
 * repository field only expression.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface RepositoryFieldOnlyExpression
    extends RepositoryFieldExpression<RepositoryFieldOnlyExpression, RepositoryFieldOnlyLogicExpression>,
    GroupExpression<RepositoryFieldOnlyExpression, RepositoryFieldOnlyLogicExpression> {

}
