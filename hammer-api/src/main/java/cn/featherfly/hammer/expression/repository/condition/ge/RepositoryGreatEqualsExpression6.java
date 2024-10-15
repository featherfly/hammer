
package cn.featherfly.hammer.expression.repository.condition.ge;

import java.util.function.Consumer;

import cn.featherfly.common.tuple.Tuple6;

import cn.featherfly.common.function.SixArgusConsumer;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * repository great equals expression6 .
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface RepositoryGreatEqualsExpression6<C extends ConditionExpression, L extends LogicExpression<C, L>>
    extends RepositoryGreatEqualsExpressionBase6<C, L> {

    /**
     * great equals.
     *
     * @param greatEqualsExpressions the great equals expressions
     * @return the LogicExpression
     */
    L ge(Consumer<Tuple6<GreatEqualsRepositoryExpression, GreatEqualsRepositoryExpression,
        GreatEqualsRepositoryExpression, GreatEqualsRepositoryExpression, GreatEqualsRepositoryExpression,
        GreatEqualsRepositoryExpression>> greatEqualsExpressions);

    /**
     * great equals.
     *
     * @param greatEqualsExpressions the great equals expressions
     * @return the LogicExpression
     */
    L ge(SixArgusConsumer<GreatEqualsRepositoryExpression, GreatEqualsRepositoryExpression,
        GreatEqualsRepositoryExpression, GreatEqualsRepositoryExpression, GreatEqualsRepositoryExpression,
        GreatEqualsRepositoryExpression> greatEqualsExpressions);
}