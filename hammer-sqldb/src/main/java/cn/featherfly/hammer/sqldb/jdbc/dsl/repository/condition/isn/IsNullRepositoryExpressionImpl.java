
package cn.featherfly.hammer.sqldb.jdbc.dsl.repository.condition.isn;

import java.util.function.Predicate;

import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.condition.isn.MulitiIsNullExpression;
import cn.featherfly.hammer.expression.repository.condition.isn.AbstractIsNullRepositoryExpression;
import cn.featherfly.hammer.expression.repository.condition.isn.IsNullRepositoryExpression;

/**
 * The Class IsNullRepositoryExpressionImpl.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public class IsNullRepositoryExpressionImpl<C extends ConditionExpression, L extends LogicExpression<C, L>>
    extends AbstractIsNullRepositoryExpression<C, L> implements IsNullRepositoryExpression {

    /**
     * Instantiates a new contains repository expression impl.
     *
     * @param index            the index
     * @param expression       the expression
     * @param ignorepPredicate the ignorep predicate
     */
    public IsNullRepositoryExpressionImpl(int index, MulitiIsNullExpression<C, L> expression,
        Predicate<Object> ignorepPredicate) {
        super(index, expression, ignorepPredicate);
    }
}
