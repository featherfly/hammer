
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2023-11-21 11:03:21
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.repository.query;

import cn.featherfly.hammer.expression.query.QueryRelateFetchFieldExpression;

/**
 * repository query relate expression.
 *
 * @author zhongj
 * @param <Q> the generic type
 */
public interface RepositoryQueryRelateExpression<Q>
        extends QueryRelateFetchFieldExpression<Q>, RepositoryQueryFetchFieldExpression<Q, Q> {
    //    /**
    //     * 添加查询出来的属性.
    //     *
    //     * @param <T>          the generic type
    //     * @param <R>          the generic type
    //     * @param propertyName propertyName
    //     * @return RepositoryQueryRelateExpression
    //     */
    //    @Override
    //    <T, R> Q fetch(SerializableFunction<T, R> propertyName);
    //
    //    /**
    //     * 添加查询出来的属性.
    //     *
    //     * @param <T>           the generic type
    //     * @param <R>           the generic type
    //     * @param propertyNames propertyNames
    //     * @return RepositoryQueryRelateExpression
    //     */
    //    @Override
    //    <T, R> Q fetch(@SuppressWarnings("unchecked") SerializableFunction<T, R>... propertyNames);
}
