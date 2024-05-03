
package cn.featherfly.hammer.sqldb.dsl.repository.condition.sw;

import java.util.function.Predicate;

import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.condition.sw.MulitiStartWithExpression;
import cn.featherfly.hammer.expression.repository.condition.sw.AbstractStartWithRepositoryExpression;
import cn.featherfly.hammer.expression.repository.condition.sw.StartWithRepositoryExpression;

/**
 * The Class StartWithRepositoryExpressionImpl.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public class StartWithRepositoryExpressionImpl<C extends ConditionExpression, L extends LogicExpression<C, L>>
    extends AbstractStartWithRepositoryExpression<C, L> implements StartWithRepositoryExpression {

    /**
     * Instantiates a new start with repository expression impl.
     *
     * @param index            the index
     * @param expression       the expression
     * @param ignorepPredicate the ignorep predicate
     */
    public StartWithRepositoryExpressionImpl(int index, MulitiStartWithExpression<C, L> expression,
        Predicate<Object> ignorepPredicate) {
        super(index, expression, ignorepPredicate);
    }

    /**
     * Instantiates a new start with repository expression impl.
     *
     * @param index          the index
     * @param fieldName      the field name
     * @param expression     the expression
     * @param ignoreStrategy the ignore strategy
     */
    public StartWithRepositoryExpressionImpl(int index, String fieldName, MulitiStartWithExpression<C, L> expression,
        Predicate<Object> ignoreStrategy) {
        super(index, fieldName, expression, ignoreStrategy);
    }
}
