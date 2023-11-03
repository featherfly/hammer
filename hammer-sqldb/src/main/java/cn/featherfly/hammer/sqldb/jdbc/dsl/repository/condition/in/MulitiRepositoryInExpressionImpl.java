
package cn.featherfly.hammer.sqldb.jdbc.dsl.repository.condition.in;

import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.sqldb.jdbc.dsl.condition.InternalMulitiCondition;
import cn.featherfly.hammer.sqldb.jdbc.dsl.condition.in.AbstractMulitiInExpression;

/**
 * The Class MulitiRepositoryInExpressionImpl.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public class MulitiRepositoryInExpressionImpl<C extends ConditionExpression, L extends LogicExpression<C, L>>
    extends AbstractMulitiInExpression<InternalMulitiCondition<L>, C, L> {

    /**
     * Instantiates a new muliti repository in expression impl.
     *
     * @param proxy the proxy
     */
    public MulitiRepositoryInExpressionImpl(InternalMulitiCondition<L> proxy) {
        super(proxy);
    }

}
