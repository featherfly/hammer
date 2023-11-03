
package cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.ge;

import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.sqldb.jdbc.dsl.condition.ge.AbstractMulitiGreatEqualsExpression;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.InternalMulitiEntityCondition;

/**
 * The Class MulitiEntityGreatEqualsExpressionImpl.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public class MulitiEntityGreatEqualsExpressionImpl<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends AbstractMulitiGreatEqualsExpression<InternalMulitiEntityCondition<L>, C, L> {

    /**
     * Instantiates a new muliti entity equals expression impl.
     *
     * @param proxy the proxy
     */
    public MulitiEntityGreatEqualsExpressionImpl(InternalMulitiEntityCondition<L> proxy) {
        super(proxy);
    }
}
