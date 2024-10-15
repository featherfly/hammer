
package cn.featherfly.hammer.expression.repository.condition.eq;

import java.util.function.Consumer;

import cn.featherfly.common.tuple.Tuple3;

import cn.featherfly.common.function.ThreeArgusConsumer;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * RepositoryEqualsExpression3.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface RepositoryEqualsExpression3<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends RepositoryEqualsExpressionBase3<C, L> {
    /**
     * equals. 等于.
     *
     * @param equalsRepositoryExpressions the equals repository expressions
     * @return the LogicExpression
     */
    L eq(Consumer<Tuple3<EqualsRepositoryExpression, EqualsRepositoryExpression,
            EqualsRepositoryExpression>> equalsRepositoryExpressions);

    /**
     * equals. 等于.
     *
     * @param equalsRepositoryExpressions the equals repository expressions
     * @return the LogicExpression
     */
    L eq(ThreeArgusConsumer<EqualsRepositoryExpression, EqualsRepositoryExpression,
            EqualsRepositoryExpression> equalsRepositoryExpressions);
}