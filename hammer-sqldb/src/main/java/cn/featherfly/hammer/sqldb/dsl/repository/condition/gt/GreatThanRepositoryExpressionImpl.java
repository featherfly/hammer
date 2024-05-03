
package cn.featherfly.hammer.sqldb.dsl.repository.condition.gt;

import java.util.function.Predicate;

import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.condition.gt.MulitiGreatThanExpression;
import cn.featherfly.hammer.expression.repository.condition.gt.AbstractGreatThanRepositoryExpression;
import cn.featherfly.hammer.expression.repository.condition.gt.GreatThanRepositoryExpression;

/**
 * The Class GreatThanRepositoryExpressionImpl.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public class GreatThanRepositoryExpressionImpl<C extends ConditionExpression, L extends LogicExpression<C, L>>
    extends AbstractGreatThanRepositoryExpression<C, L> implements GreatThanRepositoryExpression {

    /**
     * Instantiates a new great than repository expression impl.
     *
     * @param index            the index
     * @param expression       the expression
     * @param ignorepPredicate the ignorep predicate
     */
    public GreatThanRepositoryExpressionImpl(int index, MulitiGreatThanExpression<C, L> expression,
        Predicate<Object> ignorepPredicate) {
        super(index, expression, ignorepPredicate);
    }
}
