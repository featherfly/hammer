/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2023-11-17 18:27:17
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.dsl.repository;

import cn.featherfly.hammer.dsl.OnExpression;

/**
 * repository on expression.
 *
 * @author zhongj
 * @param <O> on result type
 */
public interface RepositoryOnExpression<O> extends OnExpression<O> {
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

    //    /**
    //     * On.
    //     *
    //     * @param <T>                 the generic type
    //     * @param <T2>                the generic type
    //     * @param <R>                 the generic type
    //     * @param joinRepositoryField the join repository field
    //     * @param field               the field
    //     * @return the re
    //     */
    //    default <T, T2, R> Q on(SerializableFunction<T2, R> joinRepositoryField,
    //            SerializableFunction<T, R> sourceRepositoryField) {
    //        return on(LambdaUtils.getLambdaPropertyName(joinRepositoryField),
    //                LambdaUtils.getLambdaPropertyName(sourceRepositoryField));
    //    }
}
