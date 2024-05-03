
package cn.featherfly.hammer.sqldb.dsl.repository.condition.inn;

import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.sqldb.dsl.condition.InternalMulitiCondition;
import cn.featherfly.hammer.sqldb.dsl.condition.inn.AbstractMulitiIsNotNullExpression;

/**
 * The Class MulitiRepositoryIsNotNullExpressionImpl.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public class MulitiRepositoryIsNotNullExpressionImpl<C extends ConditionExpression, L extends LogicExpression<C, L>>
    extends AbstractMulitiIsNotNullExpression<InternalMulitiCondition<L>, C, L> {

    /**
     * Instantiates a new muliti repository is not null expression impl.
     *
     * @param internalMulitiCondition the internal muliti condition
     */
    public MulitiRepositoryIsNotNullExpressionImpl(InternalMulitiCondition<L> internalMulitiCondition) {
        super(internalMulitiCondition);
    }
}
