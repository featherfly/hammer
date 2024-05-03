
/*
 * All rights Reserved, Designed By zhongj
 * @Title: MulitiEntityEqualsExpressionImpl.java
 * @Description: MulitiEntityEqualsExpressionImpl
 * @author: zhongj
 * @date: 2023-08-07 17:52:07
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.dsl.entity.condition.eq;

import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.sqldb.dsl.condition.eq.AbstractMulitiEqualsExpression;
import cn.featherfly.hammer.sqldb.dsl.entity.condition.InternalMulitiEntityCondition;

/**
 * muliti entity equals expression implements.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public class MulitiEntityEqualsExpressionImpl<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends AbstractMulitiEqualsExpression<InternalMulitiEntityCondition<L>, C, L> {

    /**
     * Instantiates a new muliti entity equals expression impl.
     *
     * @param internalMulitiEntityCondition the internal muliti entity condition
     */
    public MulitiEntityEqualsExpressionImpl(InternalMulitiEntityCondition<L> internalMulitiEntityCondition) {
        super(internalMulitiEntityCondition);
    }
}
