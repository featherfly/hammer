
package cn.featherfly.hammer.expression.repository.condition.le;

import java.util.function.Consumer;

import cn.featherfly.common.tuple.Tuple6;

import cn.featherfly.common.function.SixArgusConsumer;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * repository less equals expression6 .
 *
 * @author zhongj
 * @param <C> the generic type ConditionExpression
 * @param <L> the generic type LogicExpression
 */
public interface RepositoryLessEqualsExpression6<C extends ConditionExpression, L extends LogicExpression<C, L>>
    extends RepositoryLessEqualsExpressionBase6<C, L> {
    /**
     * less equals.
     *
     * @param lessEqualsExpressions the less equals expressions
     * @return the LogicExpression
     */
    L le(Consumer<Tuple6<LessEqualsRepositoryExpression, LessEqualsRepositoryExpression, LessEqualsRepositoryExpression,
        LessEqualsRepositoryExpression, LessEqualsRepositoryExpression,
        LessEqualsRepositoryExpression>> lessEqualsExpressions);

    /**
     * less equals.
     *
     * @param lessEqualsExpressions the less equals expressions
     * @return the LogicExpression
     */
    L le(SixArgusConsumer<LessEqualsRepositoryExpression, LessEqualsRepositoryExpression,
        LessEqualsRepositoryExpression, LessEqualsRepositoryExpression, LessEqualsRepositoryExpression,
        LessEqualsRepositoryExpression> lessEqualsExpressions);
}