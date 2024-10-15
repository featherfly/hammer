
package cn.featherfly.hammer.expression.repository.condition.ne;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

import cn.featherfly.common.tuple.Tuple2;

import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * RepositoryNotEqualsExpression2.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface RepositoryNotEqualsExpression2<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends RepositoryNotEqualsExpressionBase2<C, L> {

    /**
     * not equals. 不等于.
     *
     * @param equalsRepositoryExpressions the equals repository expressions
     * @return the LogicExpression
     */
    L ne(Consumer<Tuple2<NotEqualsRepositoryExpression, NotEqualsRepositoryExpression>> equalsRepositoryExpressions);

    /**
     * not equals. 不等于.
     *
     * @param equalsRepositoryExpressions the equals repository expressions
     * @return the LogicExpression
     */
    L ne(BiConsumer<NotEqualsRepositoryExpression, NotEqualsRepositoryExpression> equalsRepositoryExpressions);
}