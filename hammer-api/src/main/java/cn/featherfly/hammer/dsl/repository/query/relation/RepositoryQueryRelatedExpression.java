/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2023-11-17 18:27:17
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.dsl.repository.query.relation;

import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.lang.LambdaUtils;
import cn.featherfly.hammer.dsl.query.relation.QueryRelatedExpression;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryRelateExpression;

/**
 * repository query related expression.
 *
 * @author zhongj
 * @param <Q> the generic type
 * @param <F> the generic type
 */
public interface RepositoryQueryRelatedExpression<Q extends RepositoryQueryRelateExpression<F>, F>
        extends QueryRelatedExpression<Q, F> {
    // TODO 后续来加入其他方式
    //    /**
    //     * On.
    //     *
    //     * @param <T2>                the generic type
    //     * @param <R>                 the generic type
    //     * @param joinRepositoryField the join repository field
    //     * @return the re
    //     */
    //    default <T2, R> Q on(SerializableFunction<T2, R> joinRepositoryField) {
    //        return on(LambdaUtils.getLambdaPropertyName(joinRepositoryField));
    //    }

    /**
     * On.
     *
     * @param <T>                 the generic type
     * @param <T2>                the generic type
     * @param <R>                 the generic type
     * @param joinRepositoryField the join repository field
     * @param field               the field
     * @return the re
     */
    default <T, T2, R> Q on(SerializableFunction<T2, R> joinRepositoryField,
            SerializableFunction<T, R> sourceRepositoryField) {
        return on(LambdaUtils.getLambdaPropertyName(joinRepositoryField),
                LambdaUtils.getLambdaPropertyName(sourceRepositoryField));
    }
}
