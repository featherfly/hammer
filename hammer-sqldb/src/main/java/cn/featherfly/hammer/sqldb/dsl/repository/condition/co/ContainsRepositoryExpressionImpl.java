
package cn.featherfly.hammer.sqldb.dsl.repository.condition.co;

import java.util.function.Predicate;

import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.condition.co.MulitiContainsExpression;
import cn.featherfly.hammer.expression.repository.condition.co.AbstractContainsRepositoryExpression;
import cn.featherfly.hammer.expression.repository.condition.co.ContainsRepositoryExpression;

/**
 * The Class ContainsRepositoryExpressionImpl.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public class ContainsRepositoryExpressionImpl<C extends ConditionExpression, L extends LogicExpression<C, L>>
    extends AbstractContainsRepositoryExpression<C, L> implements ContainsRepositoryExpression {

    /**
     * Instantiates a new contains repository expression impl.
     *
     * @param index            the index
     * @param expression       the expression
     * @param ignorepPredicate the ignorep predicate
     */
    public ContainsRepositoryExpressionImpl(int index, MulitiContainsExpression<C, L> expression,
        Predicate<Object> ignorepPredicate) {
        super(index, expression, ignorepPredicate);
    }

    /**
     * Instantiates a new contains repository expression impl.
     *
     * @param index          the index
     * @param fieldName      the field name
     * @param expression     the expression
     * @param ignoreStrategy the ignore strategy
     */
    public ContainsRepositoryExpressionImpl(int index, String fieldName, MulitiContainsExpression<C, L> expression,
        Predicate<Object> ignoreStrategy) {
        super(index, fieldName, expression, ignoreStrategy);
    }
}
