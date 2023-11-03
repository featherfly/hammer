
package cn.featherfly.hammer.expression.repository.condition.eq;

import java.util.function.Consumer;

import com.speedment.common.tuple.Tuple5;

import cn.featherfly.common.function.FiveArgusConsumer;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * RepositoryEqualsExpression5.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface RepositoryEqualsExpression5<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends RepositoryEqualsExpressionBase5<C, L> {
    /**
     * equals. 等于.
     *
     * @param equalsRepositoryExpressions the equals repository expressions
     * @return the LogicExpression
     */
    L eq(Consumer<Tuple5<EqualsRepositoryExpression, EqualsRepositoryExpression, EqualsRepositoryExpression,
            EqualsRepositoryExpression, EqualsRepositoryExpression>> equalsRepositoryExpressions);

    /**
     * equals. 等于.
     *
     * @param equalsRepositoryExpressions the equals repository expressions
     * @return the LogicExpression
     */
    L eq(FiveArgusConsumer<EqualsRepositoryExpression, EqualsRepositoryExpression, EqualsRepositoryExpression,
            EqualsRepositoryExpression, EqualsRepositoryExpression> equalsRepositoryExpressions);
}