
package cn.featherfly.hammer.sqldb.dsl.repository.condition.nco;

import java.util.function.Predicate;

import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.condition.nco.MulitiNotContainsExpression;
import cn.featherfly.hammer.expression.repository.condition.nco.AbstractNotContainsRepositoryExpression;
import cn.featherfly.hammer.expression.repository.condition.nco.NotContainsRepositoryExpression;

/**
 * The Class NotContainsRepositoryExpressionImpl.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public class NotContainsRepositoryExpressionImpl<C extends ConditionExpression, L extends LogicExpression<C, L>>
    extends AbstractNotContainsRepositoryExpression<C, L> implements NotContainsRepositoryExpression {

    /**
     * Instantiates a new not contains repository expression impl.
     *
     * @param index            the index
     * @param expression       the expression
     * @param ignorepPredicate the ignorep predicate
     */
    public NotContainsRepositoryExpressionImpl(int index, MulitiNotContainsExpression<C, L> expression,
        Predicate<Object> ignorepPredicate) {
        super(index, expression, ignorepPredicate);
    }

    /**
     * Instantiates a new not contains repository expression impl.
     *
     * @param index          the index
     * @param fieldName      the field name
     * @param expression     the expression
     * @param ignoreStrategy the ignore strategy
     */
    public NotContainsRepositoryExpressionImpl(int index, String fieldName,
        MulitiNotContainsExpression<C, L> expression, Predicate<Object> ignoreStrategy) {
        super(index, fieldName, expression, ignoreStrategy);
    }
}
