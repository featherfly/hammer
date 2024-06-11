
package cn.featherfly.hammer.sqldb.dsl.repository.condition.ne;

import java.util.function.Predicate;

import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.condition.ne.MulitiNotEqualsExpression;
import cn.featherfly.hammer.expression.repository.condition.ne.AbstractNotEqualsRepositoryExpression;

/**
 * The Class EqualsEntityExpressionImpl.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public class NotEqualsRepositoryExpressionImpl<C extends ConditionExpression, L extends LogicExpression<C, L>>
    extends AbstractNotEqualsRepositoryExpression<C, L> {

    /**
     * Instantiates a new equals entity expression impl.
     *
     * @param index the index
     * @param expression the expression
     * @param ignorepPredicate the ignorep predicate
     */
    public NotEqualsRepositoryExpressionImpl(int index, MulitiNotEqualsExpression<C, L> expression,
        Predicate<Object> ignorepPredicate) {
        super(index, expression, ignorepPredicate);
    }
}
