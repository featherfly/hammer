
package cn.featherfly.hammer.expression.repository.condition.ge;

import java.util.function.Consumer;

import cn.featherfly.common.tuple.Tuple4;

import cn.featherfly.common.function.FourArgusConsumer;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * repository great equals expression4 .
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface RepositoryGreatEqualsExpression4<C extends ConditionExpression, L extends LogicExpression<C, L>>
    extends RepositoryGreatEqualsExpressionBase4<C, L> {
    /**
     * great equals.
     *
     * @param greatEqualsExpressions the great equals expressions
     * @return the LogicExpression
     */
    L ge(Consumer<Tuple4<GreatEqualsRepositoryExpression, GreatEqualsRepositoryExpression,
        GreatEqualsRepositoryExpression, GreatEqualsRepositoryExpression>> greatEqualsExpressions);

    /**
     * great equals.
     *
     * @param greatEqualsExpressions the great equals expressions
     * @return the LogicExpression
     */
    L ge(FourArgusConsumer<GreatEqualsRepositoryExpression, GreatEqualsRepositoryExpression,
        GreatEqualsRepositoryExpression, GreatEqualsRepositoryExpression> greatEqualsExpressions);
}