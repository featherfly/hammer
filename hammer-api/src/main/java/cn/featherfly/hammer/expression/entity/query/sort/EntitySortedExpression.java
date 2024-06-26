package cn.featherfly.hammer.expression.entity.query.sort;

/**
 * 已排序排序构建接口，代表已经调用过至少一次asc（desc）方法.
 *
 * @author zhongj
 * @param <E> the entity type
 * @param <S> the EntitySortExpression type
 */
public interface EntitySortedExpression<E, S extends EntitySortedExpression<E, S>> extends EntitySortExpression<E, S> {

}