
package cn.featherfly.hammer.expression.repository.condition.ni;

import java.util.function.Consumer;

import cn.featherfly.common.tuple.Tuple3;

import cn.featherfly.common.function.ThreeArgusConsumer;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * repository not in expression3 .
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface RepositoryNotInExpression3<C extends ConditionExpression, L extends LogicExpression<C, L>>
    extends RepositoryNotInExpressionBase3<C, L> {
    /**
     * not in.
     *
     * @param notInExpressions the not in expressions
     * @return the LogicExpression
     */
    L ni(Consumer<
        Tuple3<NotInRepositoryExpression, NotInRepositoryExpression, NotInRepositoryExpression>> notInExpressions);

    /**
     * not in.
     *
     * @param notInExpressions the not in expressions
     * @return the LogicExpression
     */
    L ni(ThreeArgusConsumer<NotInRepositoryExpression, NotInRepositoryExpression,
        NotInRepositoryExpression> notInExpressions);
}