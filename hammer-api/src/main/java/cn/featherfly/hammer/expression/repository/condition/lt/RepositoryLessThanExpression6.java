
package cn.featherfly.hammer.expression.repository.condition.lt;

import java.util.function.Consumer;

import com.speedment.common.tuple.Tuple6;

import cn.featherfly.common.function.SixArgusConsumer;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * repository less than expression6 .
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface RepositoryLessThanExpression6<C extends ConditionExpression, L extends LogicExpression<C, L>>
    extends RepositoryLessThanExpressionBase6<C, L> {
    /**
     * less than.
     *
     * @param lessThanExpressions the less than expressions
     * @return the LogicExpression
     */
    L lt(Consumer<Tuple6<LessThanRepositoryExpression, LessThanRepositoryExpression, LessThanRepositoryExpression,
        LessThanRepositoryExpression, LessThanRepositoryExpression, LessThanRepositoryExpression>> lessThanExpressions);

    /**
     * less than.
     *
     * @param lessThanExpressions the less than expressions
     * @return the LogicExpression
     */
    L lt(SixArgusConsumer<LessThanRepositoryExpression, LessThanRepositoryExpression, LessThanRepositoryExpression,
        LessThanRepositoryExpression, LessThanRepositoryExpression, LessThanRepositoryExpression> lessThanExpressions);
}