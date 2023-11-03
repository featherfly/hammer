
package cn.featherfly.hammer.sqldb.jdbc.dsl.repository.condition.nl;

import java.util.function.Predicate;

import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.condition.nl.MulitiNotLikeExpression;
import cn.featherfly.hammer.expression.repository.condition.nl.AbstractNotLikeRepositoryExpression;
import cn.featherfly.hammer.expression.repository.condition.nl.NotLikeRepositoryExpression;

/**
 * The Class NotLikeRepositoryExpressionImpl.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public class NotLikeRepositoryExpressionImpl<C extends ConditionExpression, L extends LogicExpression<C, L>>
    extends AbstractNotLikeRepositoryExpression<C, L> implements NotLikeRepositoryExpression {

    /**
     * Instantiates a new not contains repository expression impl.
     *
     * @param index            the index
     * @param expression       the expression
     * @param ignorepPredicate the ignorep predicate
     */
    public NotLikeRepositoryExpressionImpl(int index, MulitiNotLikeExpression<C, L> expression,
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
    public NotLikeRepositoryExpressionImpl(int index, String fieldName, MulitiNotLikeExpression<C, L> expression,
        Predicate<Object> ignoreStrategy) {
        super(index, fieldName, expression, ignoreStrategy);
    }
}
