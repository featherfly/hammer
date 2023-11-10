
package cn.featherfly.hammer.expression.repository.condition.ni;

import java.util.function.Consumer;

import com.speedment.common.tuple.Tuple5;

import cn.featherfly.common.function.FiveArgusConsumer;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * repository not in expression5 .
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface RepositoryNotInExpression5<C extends ConditionExpression, L extends LogicExpression<C, L>>
    extends RepositoryNotInExpressionBase5<C, L> {
    /**
     * not in.
     *
     * @param notInExpressions the not in expressions
     * @return the LogicExpression
     */
    L ni(Consumer<Tuple5<NotInRepositoryExpression, NotInRepositoryExpression, NotInRepositoryExpression,
        NotInRepositoryExpression, NotInRepositoryExpression>> notInExpressions);

    /**
     * not in.
     *
     * @param notInExpressions the not in expressions
     * @return the LogicExpression
     */
    L ni(FiveArgusConsumer<NotInRepositoryExpression, NotInRepositoryExpression, NotInRepositoryExpression,
        NotInRepositoryExpression, NotInRepositoryExpression> notInExpressions);
}