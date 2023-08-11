
/*
 * All rights Reserved, Designed By zhongj
 * @Title: EntityQueryRelatedFetched.java
 * @Package cn.featherfly.hammer.dsl.query.type
 * @Description: EntityQueryRelatedFetched
 * @author: zhongj
 * @date: 2023-06-01 16:30:01
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.dsl.entity.query.relation;

import com.speedment.common.tuple.Tuple3;

import cn.featherfly.hammer.dsl.entity.query.EntityQueryConditionGroup4;
import cn.featherfly.hammer.dsl.entity.query.EntityQueryConditionGroupLogic4;
import cn.featherfly.hammer.expression.entity.query.EntityQuerySortExpression4;
import cn.featherfly.hammer.expression.entity.query.relation.EntityQueryRelatedFetchedExpression3RFF;

/**
 * The Interface EntityQueryRelatedFetched3RFF.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <R1> the generic type
 * @param <R2> the generic type
 * @param <R3> the generic type
 */
public interface EntityQueryRelatedFetched3RFF<E, R1, R2, R3> extends
        EntityQueryRelatedFetchedExpression3RFF<E, R1, R2, R3,
                EntityQueryConditionGroup4<E, R1, R2, R3, Tuple3<E, R2, R3>>,
                EntityQueryConditionGroupLogic4<E, R1, R2, R3, Tuple3<E, R2, R3>>,
                EntityQuerySortExpression4<E, R1, R2, R3, Tuple3<E, R2, R3>>> {

}
