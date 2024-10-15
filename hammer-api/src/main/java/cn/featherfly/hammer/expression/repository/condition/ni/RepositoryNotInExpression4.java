
package cn.featherfly.hammer.expression.repository.condition.ni;

import java.util.function.Consumer;

import cn.featherfly.common.tuple.Tuple4;

import cn.featherfly.common.function.FourArgusConsumer;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * repository not in expression4 .
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface RepositoryNotInExpression4<C extends ConditionExpression, L extends LogicExpression<C, L>>
    extends RepositoryNotInExpressionBase4<C, L> {
    /**
     * not in.
     *
     * @param notInExpressions the not in expressions
     * @return the LogicExpression
     */
    L ni(Consumer<Tuple4<NotInRepositoryExpression, NotInRepositoryExpression, NotInRepositoryExpression,
        NotInRepositoryExpression>> notInExpressions);

    /**
     * not in.
     *
     * @param notInExpressions the not in expressions
     * @return the LogicExpression
     */
    L ni(FourArgusConsumer<NotInRepositoryExpression, NotInRepositoryExpression, NotInRepositoryExpression,
        NotInRepositoryExpression> notInExpressions);
}