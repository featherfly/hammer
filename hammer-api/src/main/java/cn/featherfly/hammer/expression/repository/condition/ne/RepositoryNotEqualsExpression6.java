
package cn.featherfly.hammer.expression.repository.condition.ne;

import java.util.function.Consumer;

import cn.featherfly.common.tuple.Tuple6;

import cn.featherfly.common.function.SixArgusConsumer;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * RepositoryNotEqualsExpression6.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface RepositoryNotEqualsExpression6<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends RepositoryNotEqualsExpressionBase6<C, L> {

    /**
     * not equals. 不等于.
     *
     * @param equalsRepositoryExpressions the equals repository expressions
     * @return the LogicExpression
     */
    L ne(Consumer<Tuple6<NotEqualsRepositoryExpression, NotEqualsRepositoryExpression, NotEqualsRepositoryExpression,
            NotEqualsRepositoryExpression, NotEqualsRepositoryExpression,
            NotEqualsRepositoryExpression>> equalsRepositoryExpressions);

    /**
     * not equals. 不等于.
     *
     * @param equalsRepositoryExpressions the equals repository expressions
     * @return the LogicExpression
     */
    L ne(SixArgusConsumer<NotEqualsRepositoryExpression, NotEqualsRepositoryExpression, NotEqualsRepositoryExpression,
            NotEqualsRepositoryExpression, NotEqualsRepositoryExpression,
            NotEqualsRepositoryExpression> equalsRepositoryExpressions);
}