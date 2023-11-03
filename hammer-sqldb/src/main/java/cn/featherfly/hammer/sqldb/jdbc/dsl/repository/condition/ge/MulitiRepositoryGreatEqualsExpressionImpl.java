
package cn.featherfly.hammer.sqldb.jdbc.dsl.repository.condition.ge;

import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.sqldb.jdbc.dsl.condition.InternalMulitiCondition;
import cn.featherfly.hammer.sqldb.jdbc.dsl.condition.ge.AbstractMulitiGreatEqualsExpression;

/**
 * The Class MulitiRepositoryGreatEqualsExpressionImpl.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public class MulitiRepositoryGreatEqualsExpressionImpl<C extends ConditionExpression, L extends LogicExpression<C, L>>
    extends AbstractMulitiGreatEqualsExpression<InternalMulitiCondition<L>, C, L> {

    /**
     * Instantiates a new muliti repository great equals expression impl.
     *
     * @param internalMulitiCondition the internal muliti condition
     */
    public MulitiRepositoryGreatEqualsExpressionImpl(InternalMulitiCondition<L> internalMulitiCondition) {
        super(internalMulitiCondition);
    }
}
