
package cn.featherfly.hammer.sqldb.jdbc.dsl.repository.condition.isn;

import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.sqldb.jdbc.dsl.condition.InternalMulitiCondition;
import cn.featherfly.hammer.sqldb.jdbc.dsl.condition.isn.AbstractMulitiIsNullExpression;

/**
 * The Class MulitiRepositoryIsNullExpressionImpl.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public class MulitiRepositoryIsNullExpressionImpl<C extends ConditionExpression, L extends LogicExpression<C, L>>
    extends AbstractMulitiIsNullExpression<InternalMulitiCondition<L>, C, L> {

    /**
     * Instantiates a new muliti repository is null expression impl.
     *
     * @param internalMulitiCondition the internal muliti condition
     */
    public MulitiRepositoryIsNullExpressionImpl(InternalMulitiCondition<L> internalMulitiCondition) {
        super(internalMulitiCondition);
    }
}
