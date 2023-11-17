/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2023-11-17 18:27:17
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.dsl.repository.query.relation;

import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.hammer.dsl.query.relation.QueryRelatedExpression;
import cn.featherfly.hammer.expression.api.entity.QueryRelate;

/**
 * repository query related expression.
 *
 * @author zhongj
 * @param <J1> the first join type
 * @param <J2> the second join type
 * @param <Q>  the generic type
 * @param <F>  the generic type
 */
public interface RepositoryQueryRelatedExpression<Q extends QueryRelate<F>, F> extends QueryRelatedExpression<Q, F> {
    // TODO 后续来加入其他方式
    /**
     * On.
     *
     * @param <P>                 the generic type
     * @param field               the field
     * @param joinRepositoryField the join repository field
     * @return the re
     */
    <T, T2, R> Q on(SerializableFunction<T, R> field, SerializableFunction<T2, R> joinRepositoryField);
}
