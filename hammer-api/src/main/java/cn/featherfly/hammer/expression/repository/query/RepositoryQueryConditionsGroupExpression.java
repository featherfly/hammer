/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2023-11-17 16:55:17
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.repository.query;

import cn.featherfly.hammer.expression.repository.condition.RepositoryConditionsGroupExpression;

/**
 * repository query conditions group expression.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 * @param <S> the generic type
 */
public interface RepositoryQueryConditionsGroupExpression<C extends RepositoryQueryConditionsGroupExpression<C, L, S>,
        L extends RepositoryQueryConditionsGroupLogicExpression<C, L, S>, S extends RepositoryQuerySortExpression>
        extends RepositoryQueryConditionsExpression<C, L, S>, RepositoryConditionsGroupExpression<C, L> {

}
