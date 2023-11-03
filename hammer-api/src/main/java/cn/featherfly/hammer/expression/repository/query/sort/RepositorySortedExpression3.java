package cn.featherfly.hammer.expression.repository.query.sort;

import cn.featherfly.hammer.expression.query.sort.SortedExpression3;

/**
 * repository sorted expression3.
 *
 * @author zhongj
 * @param <S> the generic type
 */
public interface RepositorySortedExpression3<S extends RepositorySortedExpression3<S>>
        extends RepositorySortExpression3<S>, RepositorySortedExpression<S>, SortedExpression3<S> {

}