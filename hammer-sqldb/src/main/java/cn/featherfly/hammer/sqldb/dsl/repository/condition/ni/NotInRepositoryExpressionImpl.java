
package cn.featherfly.hammer.sqldb.dsl.repository.condition.ni;

import java.util.function.Predicate;

import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.condition.ni.MulitiNotInExpression;
import cn.featherfly.hammer.expression.repository.condition.ni.AbstractNotInRepositoryExpression;

/**
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public class NotInRepositoryExpressionImpl<C extends ConditionExpression, L extends LogicExpression<C, L>>
    extends AbstractNotInRepositoryExpression<C, L> {

    /**
     * @param index            the index
     * @param expression       the expression
     * @param ignorepPredicate the ignorep predicate
     */
    public NotInRepositoryExpressionImpl(int index, MulitiNotInExpression<C, L> expression,
        Predicate<Object> ignorepPredicate) {
        super(index, expression, ignorepPredicate);
    }
}
