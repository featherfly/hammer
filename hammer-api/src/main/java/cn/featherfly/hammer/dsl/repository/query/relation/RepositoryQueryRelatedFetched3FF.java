
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

import cn.featherfly.data.query.LimitAwareQuery3;
import cn.featherfly.data.query.QueryMapperSetter3;
import cn.featherfly.hammer.dsl.repository.RepositoryJoin;
import cn.featherfly.hammer.dsl.repository.RepositoryOnExpression4;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroup4FFF;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroupLogic4FFF;
import cn.featherfly.hammer.dsl.repository.query.sort.RepositoryQuerySortedExpression4FFF;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryExpression4;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryRelateExpression;
import cn.featherfly.hammer.expression.repository.query.RepositoryQuerySortExpression4;

/**
 * The Interface RepositoryQueryRelatedFetched3RFF.
 *
 * @author zhongj
 */
public interface RepositoryQueryRelatedFetched3FF
    extends RepositoryQueryRelateExpression<RepositoryQueryRelatedFetched3FF>,
    RepositoryQueryExpression4<RepositoryQueryConditionsGroup4FFF, RepositoryQueryConditionsGroupLogic4FFF,
        RepositoryQuerySortExpression4<RepositoryQuerySortedExpression4FFF,
            LimitAwareQuery3<Map<String, Serializable>>>,
        RepositoryQuerySortedExpression4FFF, LimitAwareQuery3<Map<String, Serializable>>>,
    //    QueryLimitExecutor3,
    RepositoryJoin<RepositoryOnExpression4<RepositoryQueryRelate4FF>, RepositoryQueryRelate4FF>, QueryMapperSetter3 {

}
