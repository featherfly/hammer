
package cn.featherfly.hammer.expression.repository.condition.lt;

import java.util.function.Consumer;

import com.speedment.common.tuple.Tuple5;

import cn.featherfly.common.function.FiveArgusConsumer;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * repository less than expression5 .
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface RepositoryLessThanExpression5<C extends ConditionExpression, L extends LogicExpression<C, L>>
    extends RepositoryLessThanExpressionBase5<C, L> {
    /**
     * less than.
     *
     * @param lessThanExpressions the less than expressions
     * @return the LogicExpression
     */
    L lt(Consumer<Tuple5<LessThanRepositoryExpression, LessThanRepositoryExpression, LessThanRepositoryExpression,
        LessThanRepositoryExpression, LessThanRepositoryExpression>> lessThanExpressions);

    /**
     * less than.
     *
     * @param lessThanExpressions the less than expressions
     * @return the LogicExpression
     */
    L lt(FiveArgusConsumer<LessThanRepositoryExpression, LessThanRepositoryExpression, LessThanRepositoryExpression,
        LessThanRepositoryExpression, LessThanRepositoryExpression> lessThanExpressions);
}