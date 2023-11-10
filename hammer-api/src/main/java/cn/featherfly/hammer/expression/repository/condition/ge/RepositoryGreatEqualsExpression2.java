
package cn.featherfly.hammer.expression.repository.condition.ge;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

import com.speedment.common.tuple.Tuple2;

import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * repository great equals expression2 .
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface RepositoryGreatEqualsExpression2<C extends ConditionExpression, L extends LogicExpression<C, L>>
    extends RepositoryGreatEqualsExpressionBase2<C, L> {
    /**
     * great equals.
     *
     * @param greatEqualsExpressions the great equals expressions
     * @return the LogicExpression
     */
    L ge(Consumer<Tuple2<GreatEqualsRepositoryExpression, GreatEqualsRepositoryExpression>> greatEqualsExpressions);

    /**
     * great equals.
     *
     * @param greatEqualsExpressions the great equals expressions
     * @return the LogicExpression
     */
    L ge(BiConsumer<GreatEqualsRepositoryExpression, GreatEqualsRepositoryExpression> greatEqualsExpressions);
}