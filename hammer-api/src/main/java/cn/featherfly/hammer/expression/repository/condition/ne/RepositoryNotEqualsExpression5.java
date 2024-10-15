
package cn.featherfly.hammer.expression.repository.condition.ne;

import java.util.function.Consumer;

import cn.featherfly.common.tuple.Tuple5;

import cn.featherfly.common.function.FiveArgusConsumer;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * RepositoryNotEqualsExpression5.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface RepositoryNotEqualsExpression5<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends RepositoryNotEqualsExpressionBase5<C, L> {
    /**
     * not equals. 不等于.
     *
     * @param equalsRepositoryExpressions the equals repository expressions
     * @return the LogicExpression
     */
    L ne(Consumer<Tuple5<NotEqualsRepositoryExpression, NotEqualsRepositoryExpression, NotEqualsRepositoryExpression,
            NotEqualsRepositoryExpression, NotEqualsRepositoryExpression>> equalsRepositoryExpressions);

    /**
     * not equals. 不等于.
     *
     * @param equalsRepositoryExpressions the equals repository expressions
     * @return the LogicExpression
     */
    L ne(FiveArgusConsumer<NotEqualsRepositoryExpression, NotEqualsRepositoryExpression, NotEqualsRepositoryExpression,
            NotEqualsRepositoryExpression, NotEqualsRepositoryExpression> equalsRepositoryExpressions);
}