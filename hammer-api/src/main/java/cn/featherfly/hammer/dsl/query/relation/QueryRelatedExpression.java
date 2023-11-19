/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2023-11-17 18:27:17
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.dsl.query.relation;

import cn.featherfly.hammer.expression.api.entity.QueryRelate;

/**
 * query related expression.
 *
 * @author zhongj
 * @param <R> the generic type
 * @param <Q> the generic type
 */
public interface QueryRelatedExpression<R extends QueryRelate<Q>, Q> {
    // TODO 后续来加入其他方式

    /**
     * on.
     *
     * @param joinRepositoryField the join repository field name (use repository
     *                            name with method argu join(repository))
     * @return QueryRelate
     */
    R on(String joinRepositoryField);

    /**
     * on.
     *
     * @param joinRepositoryField   the join repository field name (use
     *                              repository name with method argu
     *                              join(repository))
     * @param sourceRepositoryField the join from repository field name
     * @return QueryRelate
     */
    R on(String sourceRepositoryField, String joinRepositoryField);
}
