
package cn.featherfly.hammer.sqldb.dsl.repository.condition.ba;

import java.util.function.Predicate;

import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.condition.ba.MulitiBetweenExpression;
import cn.featherfly.hammer.expression.repository.condition.ba.AbstractBetweenRepositoryExpression;

/**
 * The Class BetweenRepositoryExpressionImpl.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public class BetweenRepositoryExpressionImpl<C extends ConditionExpression, L extends LogicExpression<C, L>>
    extends AbstractBetweenRepositoryExpression<C, L> {

    /**
     * Instantiates a new between repository expression impl.
     *
     * @param index          the index
     * @param expression     the expression
     * @param ignoreStrategy the ignore strategy
     */
    public BetweenRepositoryExpressionImpl(int index, MulitiBetweenExpression<C, L> expression,
        Predicate<Object> ignoreStrategy) {
        super(index, expression, ignoreStrategy);
    }
}
