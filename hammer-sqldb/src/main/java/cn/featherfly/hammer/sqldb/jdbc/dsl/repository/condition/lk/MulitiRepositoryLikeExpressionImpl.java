
package cn.featherfly.hammer.sqldb.jdbc.dsl.repository.condition.lk;

import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.sqldb.jdbc.dsl.condition.InternalMulitiCondition;
import cn.featherfly.hammer.sqldb.jdbc.dsl.condition.lk.AbstractMulitiLikeExpression;

/**
 * muliti repository like expression implements.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public class MulitiRepositoryLikeExpressionImpl<C extends ConditionExpression, L extends LogicExpression<C, L>>
    extends AbstractMulitiLikeExpression<InternalMulitiCondition<L>, C, L> {

    /**
     * Instantiates a new muliti repository equals expression impl.
     *
     * @param internalMulitiCondition the internal muliti condition
     */
    public MulitiRepositoryLikeExpressionImpl(InternalMulitiCondition<L> internalMulitiCondition) {
        super(internalMulitiCondition);
    }
}
