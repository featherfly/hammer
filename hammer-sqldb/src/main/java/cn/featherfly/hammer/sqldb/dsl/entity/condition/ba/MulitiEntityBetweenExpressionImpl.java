
package cn.featherfly.hammer.sqldb.dsl.entity.condition.ba;

import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.sqldb.dsl.condition.ba.AbstractMulitiBetweenExpression;
import cn.featherfly.hammer.sqldb.dsl.entity.condition.InternalMulitiEntityCondition;

/**
 * muliti entity between and expression implements.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public class MulitiEntityBetweenExpressionImpl<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends AbstractMulitiBetweenExpression<InternalMulitiEntityCondition<L>, C, L> {

    /**
     * Instantiates a new muliti entity between expression impl.
     *
     * @param internalMulitiEntityCondition the internal muliti entity condition
     */
    public MulitiEntityBetweenExpressionImpl(InternalMulitiEntityCondition<L> internalMulitiEntityCondition) {
        super(internalMulitiEntityCondition);
    }
}
