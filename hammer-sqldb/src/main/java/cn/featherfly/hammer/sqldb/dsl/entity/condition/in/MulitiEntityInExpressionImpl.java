
package cn.featherfly.hammer.sqldb.dsl.entity.condition.in;

import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.sqldb.dsl.condition.in.AbstractMulitiInExpression;
import cn.featherfly.hammer.sqldb.dsl.entity.condition.InternalMulitiEntityCondition;

/**
 * The Class MulitiEntityIsNullExpressionImpl.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public class MulitiEntityInExpressionImpl<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends AbstractMulitiInExpression<InternalMulitiEntityCondition<L>, C, L> {

    /**
     * Instantiates a new muliti entity in expression impl.
     *
     * @param proxy the proxy
     */
    public MulitiEntityInExpressionImpl(InternalMulitiEntityCondition<L> proxy) {
        super(proxy);
    }

}
