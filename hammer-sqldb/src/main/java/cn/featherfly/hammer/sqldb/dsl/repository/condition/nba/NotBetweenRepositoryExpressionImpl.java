
package cn.featherfly.hammer.sqldb.dsl.repository.condition.nba;

import java.util.function.Predicate;

import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.condition.nba.MulitiNotBetweenExpression;
import cn.featherfly.hammer.expression.repository.condition.nba.AbstractNotBetweenRepositoryExpression;

/**
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public class NotBetweenRepositoryExpressionImpl<C extends ConditionExpression, L extends LogicExpression<C, L>>
    extends AbstractNotBetweenRepositoryExpression<C, L> {

    /**
     * @param index          the index
     * @param expression     the expression
     * @param ignoreStrategy the ignore strategy
     */
    public NotBetweenRepositoryExpressionImpl(int index, MulitiNotBetweenExpression<C, L> expression,
        Predicate<Object> ignoreStrategy) {
        super(index, expression, ignoreStrategy);
    }
}
