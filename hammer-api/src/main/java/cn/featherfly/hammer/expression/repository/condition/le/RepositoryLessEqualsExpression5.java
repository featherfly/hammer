
package cn.featherfly.hammer.expression.repository.condition.le;

import java.util.function.Consumer;

import com.speedment.common.tuple.Tuple5;

import cn.featherfly.common.function.FiveArgusConsumer;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * repository less equals expression5 .
 *
 * @author zhongj
 * @param <C> the generic type ConditionExpression
 * @param <L> the generic type LogicExpression
 */
public interface RepositoryLessEqualsExpression5<C extends ConditionExpression, L extends LogicExpression<C, L>>
    extends RepositoryLessEqualsExpressionBase5<C, L> {
    /**
     * less equals.
     *
     * @param lessEqualsExpressions the less equals expressions
     * @return the LogicExpression
     */
    L le(Consumer<Tuple5<LessEqualsRepositoryExpression, LessEqualsRepositoryExpression, LessEqualsRepositoryExpression,
        LessEqualsRepositoryExpression, LessEqualsRepositoryExpression>> lessEqualsExpressions);

    /**
     * less equals.
     *
     * @param lessEqualsExpressions the less equals expressions
     * @return the LogicExpression
     */
    L le(FiveArgusConsumer<LessEqualsRepositoryExpression, LessEqualsRepositoryExpression,
        LessEqualsRepositoryExpression, LessEqualsRepositoryExpression,
        LessEqualsRepositoryExpression> lessEqualsExpressions);
}