
package cn.featherfly.hammer.sqldb.jdbc.dsl.repository.condition.inn;

import java.util.function.Predicate;

import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.condition.inn.MulitiIsNotNullExpression;
import cn.featherfly.hammer.expression.repository.condition.inn.AbstractIsNotNullRepositoryExpression;
import cn.featherfly.hammer.expression.repository.condition.inn.IsNotNullRepositoryExpression;

/**
 * The Class IsNotNullRepositoryExpressionImpl.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public class IsNotNullRepositoryExpressionImpl<C extends ConditionExpression, L extends LogicExpression<C, L>>
    extends AbstractIsNotNullRepositoryExpression<C, L> implements IsNotNullRepositoryExpression {

    /**
     * Instantiates a new checks if is not null repository expression impl.
     *
     * @param index            the index
     * @param expression       the expression
     * @param ignorepPredicate the ignorep predicate
     */
    public IsNotNullRepositoryExpressionImpl(int index, MulitiIsNotNullExpression<C, L> expression,
        Predicate<Object> ignorepPredicate) {
        super(index, expression, ignorepPredicate);
    }
}
