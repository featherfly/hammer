
package cn.featherfly.hammer.sqldb.dsl.repository.condition.lt;

import java.util.function.Predicate;

import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.condition.lt.MulitiLessThanExpression;
import cn.featherfly.hammer.expression.repository.condition.lt.AbstractLessThanRepositoryExpression;
import cn.featherfly.hammer.expression.repository.condition.lt.LessThanRepositoryExpression;

/**
 * The Class LessThanRepositoryExpressionImpl.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public class LessThanRepositoryExpressionImpl<C extends ConditionExpression, L extends LogicExpression<C, L>>
    extends AbstractLessThanRepositoryExpression<C, L> implements LessThanRepositoryExpression {

    /**
     * Instantiates a new less than repository expression impl.
     *
     * @param index            the index
     * @param expression       the expression
     * @param ignorepPredicate the ignorep predicate
     */
    public LessThanRepositoryExpressionImpl(int index, MulitiLessThanExpression<C, L> expression,
        Predicate<Object> ignorepPredicate) {
        super(index, expression, ignorepPredicate);
    }
}
