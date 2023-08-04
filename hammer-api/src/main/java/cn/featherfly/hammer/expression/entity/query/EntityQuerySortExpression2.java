
package cn.featherfly.hammer.expression.entity.query;

import cn.featherfly.hammer.expression.entity.query.sort.EntitySortExpression2;

/**
 * The Interface EntityQuerySortedExpression2.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <E2> the generic type
 * @param <R>  the generic type
 */
public interface EntityQuerySortExpression2<E, E2, R>
        extends EntitySortExpression2<E, E2, EntityQuerySortedExpression2<E, E2, R>> {

}
