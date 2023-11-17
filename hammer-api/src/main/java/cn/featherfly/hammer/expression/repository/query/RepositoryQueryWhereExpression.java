
package cn.featherfly.hammer.expression.repository.query;

import cn.featherfly.hammer.expression.repository.RepositoryWhereExpression;

/**
 * repository query where expression.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 * @param <S> the generic type
 */
public interface RepositoryQueryWhereExpression<C extends RepositoryQueryConditionsGroupExpression<C, L, S>,
        L extends RepositoryQueryConditionsGroupLogicExpression<C, L, S>, S extends RepositoryQuerySortExpression>
        extends RepositoryWhereExpression<C, L> {

}
