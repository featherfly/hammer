
package cn.featherfly.hammer.expression.repository.condition.ne;

import java.util.function.Consumer;

import com.speedment.common.tuple.Tuple3;

import cn.featherfly.common.function.ThreeArgusConsumer;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * RepositoryNotEqualsExpression3.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface RepositoryNotEqualsExpression3<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends RepositoryNotEqualsExpressionBase3<C, L> {
    /**
     * not equals. 不等于.
     *
     * @param equalsRepositoryExpressions the equals repository expressions
     * @return the LogicExpression
     */
    L ne(Consumer<Tuple3<NotEqualsRepositoryExpression, NotEqualsRepositoryExpression,
            NotEqualsRepositoryExpression>> equalsRepositoryExpressions);

    /**
     * not equals. 不等于.
     *
     * @param equalsRepositoryExpressions the equals repository expressions
     * @return the LogicExpression
     */
    L ne(ThreeArgusConsumer<NotEqualsRepositoryExpression, NotEqualsRepositoryExpression,
            NotEqualsRepositoryExpression> equalsRepositoryExpressions);
}