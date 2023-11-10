package cn.featherfly.hammer.expression.entity.query.sort;

import cn.featherfly.hammer.expression.query.sort.SortExpression;

/**
 * The Interface EntitySortExpression. 排序构建接口.
 *
 * @author zhongj
 * @param <E> the entity type
 * @param <S> the EntitySortedExpression type
 */
public interface EntityCompatibleSortExpression<E, S extends EntitySortedCompatibleExpression<E, S>>
        extends EntitySortExpression<E, S>, SortExpression<S> {

}