
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

import cn.featherfly.common.tuple.Tuple2;

import cn.featherfly.hammer.dsl.entity.query.EntityQuery4;

/**
 * The Interface EntityQueryRelatedFetched3RFP.
 *
 * @author zhongj
 * @param <E>  query type
 * @param <R1> query or joined type
 * @param <R2> query or joined type
 * @param <R3> query or joined type
 */
public interface EntityQueryRelatedFetched3RFP<E, R1, R2, R3>
    extends EntityQueryRelate3RFXBase<E, R1, R2, R3>, EntityQuery4<E, R1, R2, R3, Tuple2<E, R2>> {

}
