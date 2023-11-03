
package cn.featherfly.hammer.sqldb.jdbc.dsl.repository.condition.nsw;

import java.util.function.Predicate;

import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.condition.nsw.MulitiNotStartWithExpression;
import cn.featherfly.hammer.expression.repository.condition.nsw.AbstractNotStartWithRepositoryExpression;
import cn.featherfly.hammer.expression.repository.condition.nsw.NotStartWithRepositoryExpression;

/**
 * The Class NotStartWithRepositoryExpressionImpl.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public class NotStartWithRepositoryExpressionImpl<C extends ConditionExpression, L extends LogicExpression<C, L>>
    extends AbstractNotStartWithRepositoryExpression<C, L> implements NotStartWithRepositoryExpression {

    /**
     * Instantiates a new not start with repository expression impl.
     *
     * @param index            the index
     * @param expression       the expression
     * @param ignorepPredicate the ignorep predicate
     */
    public NotStartWithRepositoryExpressionImpl(int index, MulitiNotStartWithExpression<C, L> expression,
        Predicate<Object> ignorepPredicate) {
        super(index, expression, ignorepPredicate);
    }

    /**
     * Instantiates a new not start with repository expression impl.
     *
     * @param index          the index
     * @param fieldName      the field name
     * @param expression     the expression
     * @param ignoreStrategy the ignore strategy
     */
    public NotStartWithRepositoryExpressionImpl(int index, String fieldName,
        MulitiNotStartWithExpression<C, L> expression, Predicate<Object> ignoreStrategy) {
        super(index, fieldName, expression, ignoreStrategy);
    }
}
