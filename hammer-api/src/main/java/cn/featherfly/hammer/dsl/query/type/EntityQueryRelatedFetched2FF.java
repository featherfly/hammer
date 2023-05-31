
/*
 * All rights Reserved, Designed By zhongj
 * @Title: EntityQueryRelatedFetched.java
 * @Package cn.featherfly.hammer.dsl.query.type
 * @Description: EntityQueryRelatedFetched
 * @author: zhongj
 * @date: 2023-06-01 16:30:01
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.dsl.query.type;

import com.speedment.common.tuple.Tuple3;

import cn.featherfly.hammer.expression.entity.query.EntityQuerySortExpression3;
import cn.featherfly.hammer.expression.query.type.EntityQueryRelatedFetchedExpression2FF;

/**
 * The Interface EntityQueryRelatedFetched2FF.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <R1> the generic type
 * @param <R2> the generic type
 */
public interface EntityQueryRelatedFetched2FF<E, R1, R2> extends
        EntityQueryRelatedFetchedExpression2FF<E, R1, R2, EntityQueryConditionGroup3<E, R1, R2, Tuple3<E, R1, R2>>,
                EntityQueryConditionGroupLogic3<E, R1, R2, Tuple3<E, R1, R2>>,
                EntityQuerySortExpression3<E, R1, R2, Tuple3<E, R1, R2>>> {

}
