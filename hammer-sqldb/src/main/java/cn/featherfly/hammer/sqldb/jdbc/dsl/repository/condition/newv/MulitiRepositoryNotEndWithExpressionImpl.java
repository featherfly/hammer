
package cn.featherfly.hammer.sqldb.jdbc.dsl.repository.condition.newv;

import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.sqldb.jdbc.dsl.condition.InternalMulitiCondition;
import cn.featherfly.hammer.sqldb.jdbc.dsl.condition.newv.AbstractMulitiNotEndWithExpression;

/**
 * muliti repository not end with expression implements.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public class MulitiRepositoryNotEndWithExpressionImpl<C extends ConditionExpression, L extends LogicExpression<C, L>>
    extends AbstractMulitiNotEndWithExpression<InternalMulitiCondition<L>, C, L> {

    /**
     * Instantiates a new muliti repository equals expression impl.
     *
     * @param internalMulitiCondition the internal muliti condition
     */
    public MulitiRepositoryNotEndWithExpressionImpl(InternalMulitiCondition<L> internalMulitiCondition) {
        super(internalMulitiCondition);
    }
}
