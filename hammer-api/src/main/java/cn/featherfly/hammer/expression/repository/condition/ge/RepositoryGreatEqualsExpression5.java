
package cn.featherfly.hammer.expression.repository.condition.ge;

import java.util.function.Consumer;

import com.speedment.common.tuple.Tuple5;

import cn.featherfly.common.function.FiveArgusConsumer;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * repository great equals expression5 .
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface RepositoryGreatEqualsExpression5<C extends ConditionExpression, L extends LogicExpression<C, L>>
    extends RepositoryGreatEqualsExpressionBase5<C, L> {
    /**
     * great equals.
     *
     * @param greatEqualsExpressions the great equals expressions
     * @return the LogicExpression
     */
    L ge(Consumer<
        Tuple5<GreatEqualsRepositoryExpression, GreatEqualsRepositoryExpression, GreatEqualsRepositoryExpression,
            GreatEqualsRepositoryExpression, GreatEqualsRepositoryExpression>> greatEqualsExpressions);

    /**
     * great equals.
     *
     * @param greatEqualsExpressions the great equals expressions
     * @return the LogicExpression
     */
    L ge(FiveArgusConsumer<GreatEqualsRepositoryExpression, GreatEqualsRepositoryExpression,
        GreatEqualsRepositoryExpression, GreatEqualsRepositoryExpression,
        GreatEqualsRepositoryExpression> greatEqualsExpressions);
}