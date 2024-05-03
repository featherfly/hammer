
package cn.featherfly.hammer.sqldb.dsl.repository.condition.co;

import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.sqldb.dsl.condition.InternalMulitiCondition;
import cn.featherfly.hammer.sqldb.dsl.condition.co.AbstractMulitiContainsExpression;

/**
 * muliti repository contains expression implements.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public class MulitiRepositoryContainsExpressionImpl<C extends ConditionExpression, L extends LogicExpression<C, L>>
    extends AbstractMulitiContainsExpression<InternalMulitiCondition<L>, C, L> {

    /**
     * Instantiates a new muliti repository equals expression impl.
     *
     * @param internalMulitiCondition the internal muliti condition
     */
    public MulitiRepositoryContainsExpressionImpl(InternalMulitiCondition<L> internalMulitiCondition) {
        super(internalMulitiCondition);
    }
}
