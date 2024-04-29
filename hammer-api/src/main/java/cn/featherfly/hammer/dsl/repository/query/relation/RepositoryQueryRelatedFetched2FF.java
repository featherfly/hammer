
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

import cn.featherfly.hammer.dsl.repository.RepositoryJoin;
import cn.featherfly.hammer.dsl.repository.RepositoryOnExpression3;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroup3FFF;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroupLogic3FFF;
import cn.featherfly.hammer.expression.query.QueryLimitExecutor3;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryExpression3;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryRelateExpression;
import cn.featherfly.hammer.expression.repository.query.RepositoryQuerySortExpression3;

/**
 * The Interface RepositoryQueryRelatedFetched2FF.
 *
 * @author zhongj
 */
public interface RepositoryQueryRelatedFetched2FF
    extends RepositoryQueryRelateExpression<RepositoryQueryRelatedFetched2FF>,
    RepositoryQueryExpression3<RepositoryQueryConditionsGroup3FFF, RepositoryQueryConditionsGroupLogic3FFF,
        RepositoryQuerySortExpression3<QueryLimitExecutor3>, QueryLimitExecutor3>,
    QueryLimitExecutor3,
    RepositoryJoin<RepositoryOnExpression3<RepositoryQueryRelate3FFR>,
        RepositoryQueryRelate3FFR> {

}
