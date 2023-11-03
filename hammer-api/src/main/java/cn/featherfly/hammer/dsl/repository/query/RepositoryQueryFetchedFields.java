/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2023-11-17 16:04:17
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.dsl.repository.query;

import cn.featherfly.hammer.dsl.repository.query.relation.RepositoryQueryRelate0;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryFetchFieldExpression;

/**
 * repository query fetched fields expression.
 *
 * @author zhongj
 */
public interface RepositoryQueryFetchedFields extends RepositoryQuery, RepositoryQueryRelate0,
        RepositoryQueryFetchFieldExpression<RepositoryQueryFetchedFields, RepositoryQueryFetchedFields> {
}
