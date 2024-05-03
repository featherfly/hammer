
package cn.featherfly.hammer.sqldb.dsl.entity.condition.lt;

import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.sqldb.dsl.condition.lt.AbstractMulitiLessThanExpression;
import cn.featherfly.hammer.sqldb.dsl.entity.condition.InternalMulitiEntityCondition;

/**
 * The Class MulitiEntityLessThanExpressionImpl.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public class MulitiEntityLessThanExpressionImpl<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends AbstractMulitiLessThanExpression<InternalMulitiEntityCondition<L>, C, L> {

    /**
     * Instantiates a new muliti entity less than expression impl.
     *
     * @param proxy the proxy
     */
    public MulitiEntityLessThanExpressionImpl(InternalMulitiEntityCondition<L> proxy) {
        super(proxy);
    }
}
