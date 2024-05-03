
package cn.featherfly.hammer.sqldb.dsl.entity.condition.le;

import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.sqldb.dsl.condition.le.AbstractMulitiLessEqualsExpression;
import cn.featherfly.hammer.sqldb.dsl.entity.condition.InternalMulitiEntityCondition;

/**
 * The Class MulitiEntityLessEqualsExpressionImpl.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public class MulitiEntityLessEqualsExpressionImpl<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends AbstractMulitiLessEqualsExpression<InternalMulitiEntityCondition<L>, C, L> {

    /**
     * Instantiates a new muliti entity less equals expression impl.
     *
     * @param proxy the proxy
     */
    public MulitiEntityLessEqualsExpressionImpl(InternalMulitiEntityCondition<L> proxy) {
        super(proxy);
    }

}
