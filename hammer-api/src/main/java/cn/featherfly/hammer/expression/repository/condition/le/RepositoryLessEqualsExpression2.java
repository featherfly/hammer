
package cn.featherfly.hammer.expression.repository.condition.le;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

import cn.featherfly.common.tuple.Tuple2;

import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * repository less equals expression2 .
 *
 * @author zhongj
 * @param <C> the generic type ConditionExpression
 * @param <L> the generic type LogicExpression
 */
public interface RepositoryLessEqualsExpression2<C extends ConditionExpression, L extends LogicExpression<C, L>>
    extends RepositoryLessEqualsExpressionBase2<C, L> {
    /**
     * less equals.
     *
     * @param lessEqualsExpressions the less equals expressions
     * @return the LogicExpression
     */
    L le(Consumer<Tuple2<LessEqualsRepositoryExpression, LessEqualsRepositoryExpression>> lessEqualsExpressions);

    /**
     * less equals.
     *
     * @param lessEqualsExpressions the less equals expressions
     * @return the LogicExpression
     */
    L le(BiConsumer<LessEqualsRepositoryExpression, LessEqualsRepositoryExpression> lessEqualsExpressions);
}