
package cn.featherfly.hammer.sqldb.dsl.repository.condition.ge;

import java.util.function.Predicate;

import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.condition.ge.MulitiGreatEqualsExpression;
import cn.featherfly.hammer.expression.repository.condition.ge.AbstractGreatEqualsRepositoryExpression;
import cn.featherfly.hammer.expression.repository.condition.ge.GreatEqualsRepositoryExpression;

/**
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public class GreatEqualsRepositoryExpressionImpl<C extends ConditionExpression, L extends LogicExpression<C, L>>
    extends AbstractGreatEqualsRepositoryExpression<C, L> implements GreatEqualsRepositoryExpression {

    /**
     * @param index            the index
     * @param expression       the expression
     * @param ignorepPredicate the ignorep predicate
     */
    public GreatEqualsRepositoryExpressionImpl(int index, MulitiGreatEqualsExpression<C, L> expression,
        Predicate<Object> ignorepPredicate) {
        super(index, expression, ignorepPredicate);
    }
}
