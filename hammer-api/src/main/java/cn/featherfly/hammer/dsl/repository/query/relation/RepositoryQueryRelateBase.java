
package cn.featherfly.hammer.dsl.repository.query.relation;

import cn.featherfly.common.repository.Field;

/**
 * repository query relate base.
 *
 * @author zhongj
 * @param <E> the element type
 */
public interface RepositoryQueryRelateBase {
    // TODO 后续来加入其他方式
    /**
     * Join.
     *
     * @param <R>      the generic type
     * @param joinType the join type
     * @return the entity query related expression
     */
    <R> RepositoryQueryRelatedExpression<?, ?> join(String repository); // FIXME 后续来处理泛型

    /**
     * Join.
     *
     * @param <R>      the generic type
     * @param joinType the join type
     * @return the entity query related expression
     */
    <R> RepositoryQueryRelatedExpression<?, ?> join(Field repository); // FIXME 后续来处理泛型
}
