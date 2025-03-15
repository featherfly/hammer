
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2025-03-15 19:12:15
 * @Copyright: 2025 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.entity.query;

import cn.featherfly.hammer.expression.query.Queryable;

/**
 * The Interface EntityQueryable.
 *
 * @author zhongj
 * @param <E1> the generic type
 * @param <E2> the generic type
 * @param <S> the generic type
 * @param <S2> the generic type
 */
public interface EntityQueryable2<E1, E2, S, S2> extends Queryable<S>, EntitySortable2<E1, E2, S, S2> {

}
