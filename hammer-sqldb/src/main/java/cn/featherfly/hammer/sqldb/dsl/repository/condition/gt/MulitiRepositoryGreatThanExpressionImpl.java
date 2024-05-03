
package cn.featherfly.hammer.sqldb.dsl.repository.condition.gt;

import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.sqldb.dsl.condition.InternalMulitiCondition;
import cn.featherfly.hammer.sqldb.dsl.condition.gt.AbstractMulitiGreatThanExpression;

/**
 * The Class MulitiRepositoryGreatThanExpressionImpl.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public class MulitiRepositoryGreatThanExpressionImpl<C extends ConditionExpression, L extends LogicExpression<C, L>>
    extends AbstractMulitiGreatThanExpression<InternalMulitiCondition<L>, C, L> {

    /**
     * Instantiates a new muliti repository great than expression impl.
     *
     * @param internalMulitiCondition the internal muliti condition
     */
    public MulitiRepositoryGreatThanExpressionImpl(InternalMulitiCondition<L> internalMulitiCondition) {
        super(internalMulitiCondition);
    }
}
