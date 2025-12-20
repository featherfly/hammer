/*
 * All rights Reserved, Designed By zhongj
 * @Title: LikeEntityCompatibleExpression.java
 * @Package cn.featherfly.hammer.expression.entity.compatible.condition.lk
 * @author: zhongj
 * @date: 2025-12-11 01:25:11
 * @Copyright: 2025 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.entity.compatible.condition.lk;

import cn.featherfly.hammer.expression.entity.compatible.condition.MatchStringEntityPropertyCompatibleExpression;
import cn.featherfly.hammer.expression.entity.condition.lk.LikeEntityExpression;

/**
 * The Interface LikeEntityCompatibleExpression.
 *
 * @author zhongj
 * @param <E> the element type
 */
public interface LikeEntityCompatibleExpression<E>
    extends LikeEntityExpression<E>, MatchStringEntityPropertyCompatibleExpression<E> {

}
