
package cn.featherfly.hammer.expression.repository.condition.ge;

import java.util.function.Consumer;

import com.speedment.common.tuple.Tuple3;

import cn.featherfly.common.function.ThreeArgusConsumer;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * repository great equals expression3 .
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface RepositoryGreatEqualsExpression3<C extends ConditionExpression, L extends LogicExpression<C, L>>
    extends RepositoryGreatEqualsExpressionBase3<C, L> {
    /**
     * great equals.
     *
     * @param greatEqualsExpressions the great equals expressions
     * @return the LogicExpression
     */
    L ge(Consumer<Tuple3<GreatEqualsRepositoryExpression, GreatEqualsRepositoryExpression,
        GreatEqualsRepositoryExpression>> greatEqualsExpressions);

    /**
     * great equals.
     *
     * @param greatEqualsExpressions the great equals expressions
     * @return the LogicExpression
     */
    L ge(ThreeArgusConsumer<GreatEqualsRepositoryExpression, GreatEqualsRepositoryExpression,
        GreatEqualsRepositoryExpression> greatEqualsExpressions);
}