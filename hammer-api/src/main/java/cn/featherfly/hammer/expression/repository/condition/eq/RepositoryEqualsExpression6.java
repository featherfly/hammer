
package cn.featherfly.hammer.expression.repository.condition.eq;

import java.util.function.Consumer;

import com.speedment.common.tuple.Tuple6;

import cn.featherfly.common.function.SixArgusConsumer;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * RepositoryEqualsExpression6.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface RepositoryEqualsExpression6<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends RepositoryEqualsExpressionBase6<C, L> {

    /**
     * equals. 等于.
     *
     * @param equalsRepositoryExpressions the equals repository expressions
     * @return the LogicExpression
     */
    L eq(Consumer<Tuple6<EqualsRepositoryExpression, EqualsRepositoryExpression, EqualsRepositoryExpression,
            EqualsRepositoryExpression, EqualsRepositoryExpression,
            EqualsRepositoryExpression>> equalsRepositoryExpressions);

    /**
     * equals. 等于.
     *
     * @param equalsRepositoryExpressions the equals repository expressions
     * @return the LogicExpression
     */
    L eq(SixArgusConsumer<EqualsRepositoryExpression, EqualsRepositoryExpression, EqualsRepositoryExpression,
            EqualsRepositoryExpression, EqualsRepositoryExpression,
            EqualsRepositoryExpression> equalsRepositoryExpressions);
}