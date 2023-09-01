
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

import cn.featherfly.hammer.dsl.entity.query.EntityQueryConditionGroup4;
import cn.featherfly.hammer.dsl.entity.query.EntityQueryConditionGroupLogic4;
import cn.featherfly.hammer.expression.entity.query.EntityQuerySortExpression4;
import cn.featherfly.hammer.expression.entity.query.relation.EntityQueryRelatedFetchedExpression3RRP;

/**
 * The Interface EntityQueryRelatedFetched3RRP.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <R1> the generic type
 * @param <R2> the generic type
 * @param <R3> the generic type
 */
public interface EntityQueryRelatedFetched3RRP<E, R1, R2, R3>
        extends EntityQueryRelatedFetchedExpression3RRP<E, R1, R2, R3, EntityQueryConditionGroup4<E, R1, R2, R3, E>,
                EntityQueryConditionGroupLogic4<E, R1, R2, R3, E>, EntityQuerySortExpression4<E, R1, R2, R3, E>> {

}
