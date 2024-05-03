
package cn.featherfly.hammer.sqldb.dsl.entity.condition.nba;

import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.sqldb.dsl.condition.nba.AbstractMulitiNotBetweenExpression;
import cn.featherfly.hammer.sqldb.dsl.entity.condition.InternalMulitiEntityCondition;

/**
 * The Class MulitiEntityNotBetweenExpressionImpl.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public class MulitiEntityNotBetweenExpressionImpl<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends AbstractMulitiNotBetweenExpression<InternalMulitiEntityCondition<L>, C, L> {

    /**
     * Instantiates a new muliti entity not between expression impl.
     *
     * @param proxy the proxy
     */
    public MulitiEntityNotBetweenExpressionImpl(InternalMulitiEntityCondition<L> proxy) {
        super(proxy);
    }

}
