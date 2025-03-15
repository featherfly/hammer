
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2025-03-15 21:35:15
 * @Copyright: 2025 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.repository.query;

import cn.featherfly.common.function.FourArgusConsumer;
import cn.featherfly.hammer.expression.query.Sortable;
import cn.featherfly.hammer.expression.repository.query.sort.RepositorySortExpression;
import cn.featherfly.hammer.expression.repository.query.sort.RepositorySortedExpression;

/**
 * RepositorySortable4.
 *
 * @author zhongj
 * @param <S> sort expression
 * @param <Q> sorted expression
 */
public interface RepositorySortable4<S, Q> extends Sortable<S> {

    /**
     * Sort.
     *
     * @param <S1> the generic type
     * @param <S2> the generic type
     * @param <S3> the generic type
     * @param <S4> the generic type
     * @param repositorySortExpresions the repository sort expresions
     * @return the s
     */
    <S1 extends RepositorySortedExpression<S1>, S2 extends RepositorySortedExpression<S2>,
        S3 extends RepositorySortedExpression<S3>, S4 extends RepositorySortedExpression<S4>> Q sort(
            FourArgusConsumer<RepositorySortExpression<S1>, RepositorySortExpression<S2>, RepositorySortExpression<S3>,
                RepositorySortExpression<S4>> repositorySortExpresions);
}
