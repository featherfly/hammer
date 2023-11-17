/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2023-11-17 16:04:17
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.dsl.repository.query;

import cn.featherfly.hammer.dsl.repository.query.relation.RepositoryQueryRelateBase;
import cn.featherfly.hammer.expression.query.QueryFetchFieldExpression;
import cn.featherfly.hammer.expression.query.QueryValueOneExecutor;

/**
 * repository query fetched 1 fields expression.
 *
 * @author zhongj
 */
public interface RepositoryQueryFetched1Fields extends QueryFetchFieldExpression<RepositoryQueryFetchedFields>,
        RepositoryQueryValue, RepositoryQueryRelateBase, QueryValueOneExecutor {

}
