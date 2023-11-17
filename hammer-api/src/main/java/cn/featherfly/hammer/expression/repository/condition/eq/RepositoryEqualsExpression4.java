
package cn.featherfly.hammer.expression.repository.condition.eq;

import java.util.function.Consumer;

import com.speedment.common.tuple.Tuple4;

import cn.featherfly.common.function.FourArgusConsumer;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * RepositoryEqualsExpression4.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface RepositoryEqualsExpression4<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends RepositoryEqualsExpressionBase4<C, L> {
    /**
     * equals. 等于.
     *
     * @param equalsRepositoryExpressions the equals repository expressions
     * @return the LogicExpression
     */
    L eq(Consumer<Tuple4<EqualsRepositoryExpression, EqualsRepositoryExpression, EqualsRepositoryExpression,
            EqualsRepositoryExpression>> equalsRepositoryExpressions);

    /**
     * equals. 等于.
     *
     * @param equalsRepositoryExpressions the equals repository expressions
     * @return the LogicExpression
     */
    L eq(FourArgusConsumer<EqualsRepositoryExpression, EqualsRepositoryExpression, EqualsRepositoryExpression,
            EqualsRepositoryExpression> equalsRepositoryExpressions);
}