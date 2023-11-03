
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

import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroup4FFF;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroupLogic4FFF;
import cn.featherfly.hammer.expression.query.QueryLimitExecutor3;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryExpression4;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryRelateExpression;
import cn.featherfly.hammer.expression.repository.query.RepositoryQuerySortExpression4;

/**
 * The Interface RepositoryQueryRelatedFetched3FRF.
 *
 * @author zhongj
 */
public interface RepositoryQueryRelatedFetched3FRF
        extends RepositoryQueryRelateExpression<RepositoryQueryRelatedFetched3FRF>,
        RepositoryQueryExpression4<RepositoryQueryConditionsGroup4FFF, RepositoryQueryConditionsGroupLogic4FFF,
                RepositoryQuerySortExpression4<QueryLimitExecutor3>, QueryLimitExecutor3>,
        QueryLimitExecutor3,
        RepositoryQueryRelate<
                RepositoryQueryOnExpression4<RepositoryQueryRelate4FRFR, RepositoryQueryRelatedFetched4FRFF>,
                RepositoryQueryRelate4FRFR, RepositoryQueryRelatedFetched4FRFF> {

}
