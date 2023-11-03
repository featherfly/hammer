
package cn.featherfly.hammer.expression.repository.condition.ni;

import java.util.function.Consumer;

import com.speedment.common.tuple.Tuple6;

import cn.featherfly.common.function.SixArgusConsumer;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * repository not in expression6 .
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface RepositoryNotInExpression6<C extends ConditionExpression, L extends LogicExpression<C, L>>
    extends RepositoryNotInExpressionBase6<C, L> {

    /**
     * not in.
     *
     * @param notInExpressions the not in expressions
     * @return the LogicExpression
     */
    L ni(Consumer<Tuple6<NotInRepositoryExpression, NotInRepositoryExpression, NotInRepositoryExpression,
        NotInRepositoryExpression, NotInRepositoryExpression, NotInRepositoryExpression>> notInExpressions);

    /**
     * not in.
     *
     * @param notInExpressions the not in expressions
     * @return the LogicExpression
     */
    L ni(SixArgusConsumer<NotInRepositoryExpression, NotInRepositoryExpression, NotInRepositoryExpression,
        NotInRepositoryExpression, NotInRepositoryExpression, NotInRepositoryExpression> notInExpressions);
}