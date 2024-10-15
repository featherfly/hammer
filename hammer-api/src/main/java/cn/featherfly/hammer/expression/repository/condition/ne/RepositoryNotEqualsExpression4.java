
package cn.featherfly.hammer.expression.repository.condition.ne;

import java.util.function.Consumer;

import cn.featherfly.common.tuple.Tuple4;

import cn.featherfly.common.function.FourArgusConsumer;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * RepositoryNotEqualsExpression4.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface RepositoryNotEqualsExpression4<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends RepositoryNotEqualsExpressionBase4<C, L> {
    /**
     * not equals. 不等于.
     *
     * @param equalsRepositoryExpressions the equals repository expressions
     * @return the LogicExpression
     */
    L ne(Consumer<Tuple4<NotEqualsRepositoryExpression, NotEqualsRepositoryExpression, NotEqualsRepositoryExpression,
            NotEqualsRepositoryExpression>> equalsRepositoryExpressions);

    /**
     * not equals. 不等于.
     *
     * @param equalsRepositoryExpressions the equals repository expressions
     * @return the LogicExpression
     */
    L ne(FourArgusConsumer<NotEqualsRepositoryExpression, NotEqualsRepositoryExpression, NotEqualsRepositoryExpression,
            NotEqualsRepositoryExpression> equalsRepositoryExpressions);
}