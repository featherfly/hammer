
package cn.featherfly.hammer.sqldb.dsl.repository.condition.lk;

import java.util.function.Predicate;

import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.condition.lk.MulitiLikeExpression;
import cn.featherfly.hammer.expression.repository.condition.lk.AbstractLikeRepositoryExpression;

/**
 * The Class LikeRepositoryExpressionImpl.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public class LikeRepositoryExpressionImpl<C extends ConditionExpression, L extends LogicExpression<C, L>>
    extends AbstractLikeRepositoryExpression<C, L> {

    /**
     * Instantiates a new like repository expression impl.
     *
     * @param index            the index
     * @param expression       the expression
     * @param ignorepPredicate the ignorep predicate
     */
    public LikeRepositoryExpressionImpl(int index, MulitiLikeExpression<C, L> expression,
        Predicate<Object> ignorepPredicate) {
        super(index, expression, ignorepPredicate);
    }

    /**
     * Instantiates a new like repository expression impl.
     *
     * @param index          the index
     * @param fieldName      the field name
     * @param expression     the expression
     * @param ignoreStrategy the ignore strategy
     */
    public LikeRepositoryExpressionImpl(int index, String fieldName, MulitiLikeExpression<C, L> expression,
        Predicate<Object> ignoreStrategy) {
        super(index, fieldName, expression, ignoreStrategy);
    }
}
