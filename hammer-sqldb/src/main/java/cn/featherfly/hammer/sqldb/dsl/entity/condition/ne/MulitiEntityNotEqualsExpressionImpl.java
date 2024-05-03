
/*
 * All rights Reserved, Designed By zhongj
 * @Title: MulitiEntityNotEqualsExpressionImpl.java
 * @Description: MulitiEntityNotEqualsExpressionImpl
 * @author: zhongj
 * @date: 2023-08-07 17:52:07
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.dsl.entity.condition.ne;

import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.sqldb.dsl.condition.ne.AbstractMulitiNotEqualsExpression;
import cn.featherfly.hammer.sqldb.dsl.entity.condition.InternalMulitiEntityCondition;

/**
 * The Class MulitiEntityNotEqualsExpressionImpl.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public class MulitiEntityNotEqualsExpressionImpl<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends AbstractMulitiNotEqualsExpression<InternalMulitiEntityCondition<L>, C, L> {

    /**
     * Instantiates a new muliti entity neuals expression impl.
     *
     * @param proxy the proxy
     */
    public MulitiEntityNotEqualsExpressionImpl(InternalMulitiEntityCondition<L> proxy) {
        super(proxy);
    }

}
