
package cn.featherfly.hammer.sqldb.dsl.repository.condition.eq;

import java.util.function.Predicate;

import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.condition.eq.MulitiEqualsExpression;
import cn.featherfly.hammer.expression.repository.condition.eq.AbstractEqualsRepositoryExpression;
import cn.featherfly.hammer.expression.repository.condition.eq.EqualsRepositoryExpression;

/**
 * The Class EqualsEntityExpressionImpl.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public class EqualsRepositoryExpressionImpl<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends AbstractEqualsRepositoryExpression<C, L> implements EqualsRepositoryExpression {

    /**
     * Instantiates a new equals entity expression impl.
     *
     * @param index            the index
     * @param expression       the expression
     * @param ignorepPredicate the ignorep predicate
     */
    public EqualsRepositoryExpressionImpl(int index, MulitiEqualsExpression<C, L> expression,
            Predicate<Object> ignorepPredicate) {
        super(index, expression, ignorepPredicate);
    }
}
