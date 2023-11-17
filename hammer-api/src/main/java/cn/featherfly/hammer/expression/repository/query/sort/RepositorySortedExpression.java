package cn.featherfly.hammer.expression.repository.query.sort;

import cn.featherfly.hammer.expression.query.sort.SortedExpression;

/**
 * repository sorted expression.
 *
 * @author zhongj
 * @param <S> the generic type
 */
public interface RepositorySortedExpression<S extends RepositorySortedExpression<S>>
        extends RepositorySortExpression<S>, SortedExpression<S> {

}