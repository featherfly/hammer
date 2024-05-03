
package cn.featherfly.hammer.sqldb.dsl.repository.condition.newv;

import java.util.function.Predicate;

import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.condition.newv.MulitiNotEndWithExpression;
import cn.featherfly.hammer.expression.repository.condition.newv.AbstractNotEndWithRepositoryExpression;

/**
 * The Class EndWithRepositoryExpressionImpl.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public class NotEndWithRepositoryExpressionImpl<C extends ConditionExpression, L extends LogicExpression<C, L>>
    extends AbstractNotEndWithRepositoryExpression<C, L> {

    /**
     * Instantiates a new not end with repository expression impl.
     *
     * @param index            the index
     * @param expression       the expression
     * @param ignorepPredicate the ignorep predicate
     */
    public NotEndWithRepositoryExpressionImpl(int index, MulitiNotEndWithExpression<C, L> expression,
        Predicate<Object> ignorepPredicate) {
        super(index, expression, ignorepPredicate);
    }

    /**
     * Instantiates a new not end with repository expression impl.
     *
     * @param index          the index
     * @param fieldName      the field name
     * @param expression     the expression
     * @param ignoreStrategy the ignore strategy
     */
    public NotEndWithRepositoryExpressionImpl(int index, String fieldName, MulitiNotEndWithExpression<C, L> expression,
        Predicate<Object> ignoreStrategy) {
        super(index, fieldName, expression, ignoreStrategy);
    }
}
