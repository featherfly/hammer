
package cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.gt;

import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.sqldb.jdbc.dsl.condition.gt.AbstractMulitiGreatThanExpression;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.InternalMulitiEntityCondition;

/**
 * The Class MulitiEntityGreatThanExpressionImpl.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public class MulitiEntityGreatThanExpressionImpl<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends AbstractMulitiGreatThanExpression<InternalMulitiEntityCondition<L>, C, L> {

    /**
     * Instantiates a new muliti entity great than expression impl.
     *
     * @param proxy the proxy
     */
    public MulitiEntityGreatThanExpressionImpl(InternalMulitiEntityCondition<L> proxy) {
        super(proxy);
    }
}
