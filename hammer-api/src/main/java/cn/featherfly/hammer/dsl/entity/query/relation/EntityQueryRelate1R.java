
package cn.featherfly.hammer.dsl.entity.query.relation;

import cn.featherfly.hammer.dsl.entity.query.EntityQuery2;
import cn.featherfly.hammer.expression.api.entity.QueryRelate;

/**
 * The Interface EntityQueryRelate1R.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <R1> the generic type
 */
public interface EntityQueryRelate1R<E, R1> extends EntityQueryRelate1XBase<E, R1>,
        QueryRelate<EntityQueryRelatedFetched1F<E, R1>>, EntityQuery2<E, R1, E> {
}
