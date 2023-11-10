/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2023-11-27 17:06:27
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.repository.query;

import cn.featherfly.hammer.expression.query.QueryLimitExecutor;
import cn.featherfly.hammer.expression.repository.query.sort.RepositorySortExpression6;

/**
 * repository query sort expression6.
 *
 * @author zhongj
 * @param <Q> the generic type
 */
public interface RepositoryQuerySortExpression6<Q extends QueryLimitExecutor>
        extends RepositorySortExpression6<RepositoryQuerySortedExpression6<Q>> {

}
