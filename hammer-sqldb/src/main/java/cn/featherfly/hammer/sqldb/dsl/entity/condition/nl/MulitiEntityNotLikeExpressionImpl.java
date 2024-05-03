
/*
 * All rights Reserved, Designed By zhongj
 * @Title: MulitiEntityStartWithExpressionImpl.java
 * @Package cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition
 * @Description: MulitiEntityStartWithExpressionImpl
 * @author: zhongj
 * @date: 2023-07-28 16:58:28
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.dsl.entity.condition.nl;

import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.sqldb.dsl.condition.nl.AbstractMulitiNotLikeExpression;
import cn.featherfly.hammer.sqldb.dsl.entity.condition.InternalMulitiEntityCondition;

/**
 * MulitiEntityNotLikeExpressionImpl.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public class MulitiEntityNotLikeExpressionImpl<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends AbstractMulitiNotLikeExpression<InternalMulitiEntityCondition<L>, C, L> {

    /**
     * Instantiates a new muliti entity not like expression impl.
     *
     * @param proxy the proxy
     */
    public MulitiEntityNotLikeExpressionImpl(InternalMulitiEntityCondition<L> proxy) {
        super(proxy);
    }

}
