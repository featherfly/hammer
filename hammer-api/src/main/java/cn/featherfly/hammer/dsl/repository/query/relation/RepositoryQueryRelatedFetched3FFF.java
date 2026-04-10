
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

import java.io.Serializable;
import java.util.Map;

import cn.featherfly.data.query.LimitAwareQuery4;
import cn.featherfly.data.query.QueryMapperSetter4;
import cn.featherfly.hammer.dsl.repository.RepositoryJoin;
import cn.featherfly.hammer.dsl.repository.RepositoryOnExpression4;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroup4FFFF;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroupLogic4FFFF;
import cn.featherfly.hammer.dsl.repository.query.sort.RepositoryQuerySortedExpression4FFFF;
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
        RepositoryQuerySortExpression4<RepositoryQuerySortedExpression4FFFF,
            LimitAwareQuery4<Map<String, Serializable>>>,
        RepositoryQuerySortedExpression4FFFF, LimitAwareQuery4<Map<String, Serializable>>>,
    //    QueryLimitExecutor4,
    RepositoryJoin<RepositoryOnExpression4<RepositoryQueryRelate4FFF>, RepositoryQueryRelate4FFF>, QueryMapperSetter4 {

}
