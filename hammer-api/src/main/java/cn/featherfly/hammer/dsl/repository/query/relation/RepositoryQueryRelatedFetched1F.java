
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2023-11-27 18:36:27
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.dsl.repository.query.relation;

import cn.featherfly.hammer.dsl.repository.query.RepositoryQuery2;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroup2FF;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroupLogic2FF;
import cn.featherfly.hammer.expression.query.QueryLimitExecutor2;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryRelateExpression;
import cn.featherfly.hammer.expression.repository.query.RepositoryQuerySortExpression2;

/**
 * repository query relate fetched one.
 *
 * @author zhongj
 */
public interface RepositoryQueryRelatedFetched1F extends RepositoryQueryRelateExpression<RepositoryQueryRelatedFetched1F>,
        RepositoryQuery2<RepositoryQueryConditionsGroup2FF, RepositoryQueryConditionsGroupLogic2FF,
                RepositoryQuerySortExpression2<QueryLimitExecutor2>, QueryLimitExecutor2>,
        QueryLimitExecutor2,
        RepositoryQueryRelate<RepositoryQueryOnExpression2<RepositoryQueryRelate2FR, RepositoryQueryRelatedFetched2FF>,
                RepositoryQueryRelate2FR, RepositoryQueryRelatedFetched2FF> {
}
