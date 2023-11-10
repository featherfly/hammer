
package cn.featherfly.hammer.expression.repository.condition.lt;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

import com.speedment.common.tuple.Tuple2;

import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * repository less than expression2 .
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface RepositoryLessThanExpression2<C extends ConditionExpression, L extends LogicExpression<C, L>>
    extends RepositoryLessThanExpressionBase2<C, L> {
    /**
     * less than.
     *
     * @param lessThanExpressions the less than expressions
     * @return the LogicExpression
     */
    L lt(Consumer<Tuple2<LessThanRepositoryExpression, LessThanRepositoryExpression>> lessThanExpressions);

    /**
     * less than.
     *
     * @param lessThanExpressions the less than expressions
     * @return the LogicExpression
     */
    L lt(BiConsumer<LessThanRepositoryExpression, LessThanRepositoryExpression> lessThanExpressions);
}