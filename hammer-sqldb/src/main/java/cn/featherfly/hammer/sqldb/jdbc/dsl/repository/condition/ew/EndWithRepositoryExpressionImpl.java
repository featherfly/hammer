
package cn.featherfly.hammer.sqldb.jdbc.dsl.repository.condition.ew;

import java.util.function.Predicate;

import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.condition.ew.MulitiEndWithExpression;
import cn.featherfly.hammer.expression.repository.condition.ew.AbstractEndWithRepositoryExpression;
import cn.featherfly.hammer.expression.repository.condition.ew.EndWithRepositoryExpression;

/**
 * The Class EndWithRepositoryExpressionImpl.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public class EndWithRepositoryExpressionImpl<C extends ConditionExpression, L extends LogicExpression<C, L>>
    extends AbstractEndWithRepositoryExpression<C, L> implements EndWithRepositoryExpression {

    /**
     * Instantiates a new end with repository expression impl.
     *
     * @param index            the index
     * @param expression       the expression
     * @param ignorepPredicate the ignorep predicate
     */
    public EndWithRepositoryExpressionImpl(int index, MulitiEndWithExpression<C, L> expression,
        Predicate<Object> ignorepPredicate) {
        super(index, expression, ignorepPredicate);
    }

    /**
     * Instantiates a new end with repository expression impl.
     *
     * @param index          the index
     * @param fieldName      the field name
     * @param expression     the expression
     * @param ignoreStrategy the ignore strategy
     */
    public EndWithRepositoryExpressionImpl(int index, String fieldName, MulitiEndWithExpression<C, L> expression,
        Predicate<Object> ignoreStrategy) {
        super(index, fieldName, expression, ignoreStrategy);
    }
}
