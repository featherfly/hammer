
package cn.featherfly.hammer.expression.repository.query;

import cn.featherfly.hammer.expression.repository.RepositoryWhereExpression;

/**
 * repository query value where expression.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 * @param <S> the generic type
 */
public interface RepositoryQueryValueWhereExpression<C extends RepositoryQueryValueConditionsGroupExpression<C, L, S>,
        L extends RepositoryQueryValueConditionsGroupLogicExpression<C, L, S>,
        S extends RepositoryQueryValueSortExpression> extends RepositoryWhereExpression<C, L> {

}
