
package cn.featherfly.hammer.sqldb.dsl.repository.condition.le;

import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.sqldb.dsl.condition.InternalMulitiCondition;
import cn.featherfly.hammer.sqldb.dsl.condition.le.AbstractMulitiLessEqualsExpression;

/**
 * The Class MulitiRepositoryLessThanExpressionImpl.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public class MulitiRepositoryLessEqualsExpressionImpl<C extends ConditionExpression, L extends LogicExpression<C, L>>
    extends AbstractMulitiLessEqualsExpression<InternalMulitiCondition<L>, C, L> {

    /**
     * Instantiates a new muliti repository less than expression impl.
     *
     * @param internalMulitiCondition the internal muliti condition
     */
    public MulitiRepositoryLessEqualsExpressionImpl(InternalMulitiCondition<L> internalMulitiCondition) {
        super(internalMulitiCondition);
    }
}
