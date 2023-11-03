
package cn.featherfly.hammer.expression.repository.condition.le;

import java.util.function.Consumer;

import com.speedment.common.tuple.Tuple4;

import cn.featherfly.common.function.FourArgusConsumer;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * repository less equals expression4 .
 *
 * @author zhongj
 * @param <C> the generic type ConditionExpression
 * @param <L> the generic type LogicExpression
 */
public interface RepositoryLessEqualsExpression4<C extends ConditionExpression, L extends LogicExpression<C, L>>
    extends RepositoryLessEqualsExpressionBase4<C, L> {
    /**
     * less equals.
     *
     * @param lessEqualsExpressions the less equals expressions
     * @return the LogicExpression
     */
    L le(Consumer<Tuple4<LessEqualsRepositoryExpression, LessEqualsRepositoryExpression, LessEqualsRepositoryExpression,
        LessEqualsRepositoryExpression>> lessEqualsExpressions);

    /**
     * less equals.
     *
     * @param lessEqualsExpressions the less equals expressions
     * @return the LogicExpression
     */
    L le(FourArgusConsumer<LessEqualsRepositoryExpression, LessEqualsRepositoryExpression,
        LessEqualsRepositoryExpression, LessEqualsRepositoryExpression> lessEqualsExpressions);
}