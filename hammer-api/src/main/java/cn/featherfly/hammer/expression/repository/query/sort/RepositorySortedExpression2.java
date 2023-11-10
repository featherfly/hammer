package cn.featherfly.hammer.expression.repository.query.sort;

import cn.featherfly.hammer.expression.query.sort.SortedExpression2;

/**
 * repository sorted expression2.
 *
 * @author zhongj
 * @param <S> the generic type
 */
public interface RepositorySortedExpression2<S extends RepositorySortedExpression2<S>>
        extends RepositorySortExpression2<S>, RepositorySortedExpression<S>, SortedExpression2<S> {

}