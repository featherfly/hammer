
package cn.featherfly.hammer.expression.repository.condition.le;

import java.util.function.Consumer;

import com.speedment.common.tuple.Tuple3;

import cn.featherfly.common.function.ThreeArgusConsumer;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * repository less equals expression3 .
 *
 * @author zhongj
 * @param <C> the generic type ConditionExpression
 * @param <L> the generic type LogicExpression
 */
public interface RepositoryLessEqualsExpression3<C extends ConditionExpression, L extends LogicExpression<C, L>>
    extends RepositoryLessEqualsExpressionBase3<C, L> {
    /**
     * less equals.
     *
     * @param lessEqualsExpressions the less equals expressions
     * @return the LogicExpression
     */
    L le(Consumer<Tuple3<LessEqualsRepositoryExpression, LessEqualsRepositoryExpression,
        LessEqualsRepositoryExpression>> lessEqualsExpressions);

    /**
     * less equals.
     *
     * @param lessEqualsExpressions the less equals expressions
     * @return the LogicExpression
     */
    L le(ThreeArgusConsumer<LessEqualsRepositoryExpression, LessEqualsRepositoryExpression,
        LessEqualsRepositoryExpression> lessEqualsExpressions);
}