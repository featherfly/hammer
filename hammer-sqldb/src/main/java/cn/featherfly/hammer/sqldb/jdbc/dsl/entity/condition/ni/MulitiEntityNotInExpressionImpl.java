
package cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.ni;

import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.sqldb.jdbc.dsl.condition.ni.AbstractMulitiNotInExpression;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.InternalMulitiEntityCondition;

/**
 * The Class MulitiEntityNotInExpressionImpl.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public class MulitiEntityNotInExpressionImpl<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends AbstractMulitiNotInExpression<InternalMulitiEntityCondition<L>, C, L> {

    /**
     * Instantiates a new muliti entity not in expression impl.
     *
     * @param proxy the proxy
     */
    public MulitiEntityNotInExpressionImpl(InternalMulitiEntityCondition<L> proxy) {
        super(proxy);
    }

}
