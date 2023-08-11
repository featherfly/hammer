
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

import cn.featherfly.hammer.dsl.entity.query.EntityQueryConditionGroup2;
import cn.featherfly.hammer.dsl.entity.query.EntityQueryConditionGroupLogic2;
import cn.featherfly.hammer.expression.entity.query.EntityQuerySortExpression2;
import cn.featherfly.hammer.expression.entity.query.relation.EntityQueryRelatedFetchedExpression;

/**
 * EntityQueryRelatedFetched.
 *
 * @author zhongj
 */
public interface EntityQueryRelatedFetched<E, R1> extends
        EntityQueryRelatedFetchedExpression<E, R1, EntityQueryConditionGroup2<E, R1, Tuple2<E, R1>>,
                EntityQueryConditionGroupLogic2<E, R1, Tuple2<E, R1>>,
                EntityQuerySortExpression2<E, R1, Tuple2<E, R1>>> {

}
