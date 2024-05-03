
package cn.featherfly.hammer.sqldb.dsl.repository.condition.ni;

import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.sqldb.dsl.condition.InternalMulitiCondition;
import cn.featherfly.hammer.sqldb.dsl.condition.ni.AbstractMulitiNotInExpression;

/**
 * The Class MulitiRepositoryInExpressionImpl.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public class MulitiRepositoryNotInExpressionImpl<C extends ConditionExpression, L extends LogicExpression<C, L>>
    extends AbstractMulitiNotInExpression<InternalMulitiCondition<L>, C, L> {

    /**
     * Instantiates a new muliti repository in expression impl.
     *
     * @param proxy the proxy
     */
    public MulitiRepositoryNotInExpressionImpl(InternalMulitiCondition<L> proxy) {
        super(proxy);
    }

}
