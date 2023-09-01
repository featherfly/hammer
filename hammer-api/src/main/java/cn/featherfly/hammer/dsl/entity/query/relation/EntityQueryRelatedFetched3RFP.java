
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

import com.speedment.common.tuple.Tuple2;

import cn.featherfly.hammer.dsl.entity.query.EntityQueryConditionGroup4;
import cn.featherfly.hammer.dsl.entity.query.EntityQueryConditionGroupLogic4;
import cn.featherfly.hammer.expression.entity.query.EntityQuerySortExpression4;
import cn.featherfly.hammer.expression.entity.query.relation.EntityQueryRelatedFetchedExpression3RFP;

/**
 * The Interface EntityQueryRelatedFetched3RFP.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <R1> the generic type
 * @param <R2> the generic type
 * @param <R3> the generic type
 */
public interface EntityQueryRelatedFetched3RFP<E, R1, R2, R3> extends
        EntityQueryRelatedFetchedExpression3RFP<E, R1, R2, R3, EntityQueryConditionGroup4<E, R1, R2, R3, Tuple2<E, R2>>,
                EntityQueryConditionGroupLogic4<E, R1, R2, R3, Tuple2<E, R2>>,
                EntityQuerySortExpression4<E, R1, R2, R3, Tuple2<E, R2>>> {

}
