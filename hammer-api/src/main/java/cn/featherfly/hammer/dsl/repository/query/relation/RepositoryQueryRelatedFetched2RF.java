
/*
 * All rights Reserved, Designed By zhongj
 * @Title: EntityQueryRelatedFetched.java
 * @Package cn.featherfly.hammer.dsl.query.type
 * @Description: EntityQueryRelatedFetched
 * @author: zhongj
 * @date: 2023-06-01 16:30:01
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.dsl.repository.query.relation;

import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroup3FF;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroupLogic3FF;
import cn.featherfly.hammer.expression.query.QueryLimitExecutor2;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryExpression3;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryRelateExpression;
import cn.featherfly.hammer.expression.repository.query.RepositoryQuerySortExpression3;

/**
 * The Interface RepositoryQueryRelatedFetched2RF.
 *
 * @author zhongj
 */
public interface RepositoryQueryRelatedFetched2RF
        extends RepositoryQueryRelateExpression<RepositoryQueryRelatedFetched2RF>,
        RepositoryQueryExpression3<RepositoryQueryConditionsGroup3FF, RepositoryQueryConditionsGroupLogic3FF,
                RepositoryQuerySortExpression3<QueryLimitExecutor2>, QueryLimitExecutor2>,
        QueryLimitExecutor2,
        RepositoryQueryRelate<
                RepositoryQueryOnExpression3<RepositoryQueryRelate3RFR, RepositoryQueryRelatedFetched3RFF>,
                RepositoryQueryRelate3RFR, RepositoryQueryRelatedFetched3RFF> {

}
