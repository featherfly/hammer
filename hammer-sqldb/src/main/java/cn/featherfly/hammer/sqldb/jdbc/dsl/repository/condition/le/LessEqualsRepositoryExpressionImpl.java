
package cn.featherfly.hammer.sqldb.jdbc.dsl.repository.condition.le;

import java.util.function.Predicate;

import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.condition.le.MulitiLessEqualsExpression;
import cn.featherfly.hammer.expression.repository.condition.le.AbstractLessEqualsRepositoryExpression;
import cn.featherfly.hammer.expression.repository.condition.le.LessEqualsRepositoryExpression;

/**
 * The Class LessEqualsRepositoryExpressionImpl.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public class LessEqualsRepositoryExpressionImpl<C extends ConditionExpression, L extends LogicExpression<C, L>>
    extends AbstractLessEqualsRepositoryExpression<C, L> implements LessEqualsRepositoryExpression {

    /**
     * Instantiates a new less than repository expression impl.
     *
     * @param index            the index
     * @param expression       the expression
     * @param ignorepPredicate the ignorep predicate
     */
    public LessEqualsRepositoryExpressionImpl(int index, MulitiLessEqualsExpression<C, L> expression,
        Predicate<Object> ignorepPredicate) {
        super(index, expression, ignorepPredicate);
    }
}
