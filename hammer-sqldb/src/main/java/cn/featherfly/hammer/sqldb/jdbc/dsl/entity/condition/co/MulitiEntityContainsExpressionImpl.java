
/*
 * All rights Reserved, Designed By zhongj
 * @Title: MulitiEntityContainsExpressionImpl.java
 * @Package cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition
 * @Description: MulitiEntityContainsExpressionImpl
 * @author: zhongj
 * @date: 2023-07-28 16:58:28
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.co;

import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.sqldb.jdbc.dsl.condition.co.AbstractMulitiContainsExpression;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.InternalMulitiEntityCondition;

/**
 * muliti entity contains expression implements.
 *
 * @author zhongj
 * @param <E>
 */
public class MulitiEntityContainsExpressionImpl<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends AbstractMulitiContainsExpression<InternalMulitiEntityCondition<L>, C, L> {

    /**
     * Instantiates a new muliti entity contains expression impl.
     *
     * @param internalMulitiEntityCondition the internal muliti entity condition
     */
    public MulitiEntityContainsExpressionImpl(InternalMulitiEntityCondition<L> internalMulitiEntityCondition) {
        super(internalMulitiEntityCondition);
    }
}
