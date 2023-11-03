
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

import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroup4FFFF;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroupLogic4FFFF;
import cn.featherfly.hammer.expression.query.QueryLimitExecutor4;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryExpression4;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryRelateExpression;
import cn.featherfly.hammer.expression.repository.query.RepositoryQuerySortExpression4;

/**
 * The Interface RepositoryQueryRelatedFetched3FFF.
 *
 * @author zhongj
 */
public interface RepositoryQueryRelatedFetched3FFF
        extends RepositoryQueryRelateExpression<RepositoryQueryRelatedFetched3FFF>,
        RepositoryQueryExpression4<RepositoryQueryConditionsGroup4FFFF, RepositoryQueryConditionsGroupLogic4FFFF,
                RepositoryQuerySortExpression4<QueryLimitExecutor4>, QueryLimitExecutor4>,
        QueryLimitExecutor4,
        RepositoryQueryRelate<
                RepositoryQueryOnExpression4<RepositoryQueryRelate4FFFR, RepositoryQueryRelatedFetched4FFFF>,
                RepositoryQueryRelate4FFFR, RepositoryQueryRelatedFetched4FFFF> {

}
