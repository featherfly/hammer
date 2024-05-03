
package cn.featherfly.hammer.sqldb.dsl.repository.condition.sw;

import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.sqldb.dsl.condition.InternalMulitiCondition;
import cn.featherfly.hammer.sqldb.dsl.condition.sw.AbstractMulitiStartWithExpression;

/**
 * muliti repository start with expression implements.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public class MulitiRepositoryStartWithExpressionImpl<C extends ConditionExpression, L extends LogicExpression<C, L>>
    extends AbstractMulitiStartWithExpression<InternalMulitiCondition<L>, C, L> {

    /**
     * Instantiates a new muliti repository equals expression impl.
     *
     * @param internalMulitiCondition the internal muliti condition
     */
    public MulitiRepositoryStartWithExpressionImpl(InternalMulitiCondition<L> internalMulitiCondition) {
        super(internalMulitiCondition);
    }
}
