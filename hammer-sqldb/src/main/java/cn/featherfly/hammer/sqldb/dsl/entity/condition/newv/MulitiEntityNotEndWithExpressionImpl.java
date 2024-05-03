
/*
 * All rights Reserved, Designed By zhongj
 * @Title: MulitiEntityEndWithExpressionImpl.java
 * @Package cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition
 * @Description: MulitiEntityEndWithExpressionImpl
 * @author: zhongj
 * @date: 2023-07-28 16:58:28
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.dsl.entity.condition.newv;

import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.sqldb.dsl.condition.newv.AbstractMulitiNotEndWithExpression;
import cn.featherfly.hammer.sqldb.dsl.entity.condition.InternalMulitiEntityCondition;

/**
 * The Class MulitiEntityNotEndWithExpressionImpl.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public class MulitiEntityNotEndWithExpressionImpl<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends AbstractMulitiNotEndWithExpression<InternalMulitiEntityCondition<L>, C, L> {

    /**
     * Instantiates a new muliti entity not end with expression impl.
     *
     * @param proxy the proxy
     */
    public MulitiEntityNotEndWithExpressionImpl(InternalMulitiEntityCondition<L> proxy) {
        super(proxy);
    }

}
