
package cn.featherfly.hammer.expression.repository.condition.nsw;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

import com.speedment.common.tuple.Tuple2;

import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * repository not start with expression2 .
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface RepositoryNotStartWithExpression2<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends RepositoryNotStartWithExpressionBase2<C, L> {

    /**
     * not start with.
     *
     * @param notStartWithExpressions the not start with expressions
     * @return the LogicExpression
     */
    L nsw(Consumer<Tuple2<NotStartWithRepositoryExpression, NotStartWithRepositoryExpression>> notStartWithExpressions);

    /**
     * not start with.
     *
     * @param notStartWithExpressions the not start with expressions
     * @return the LogicExpression
     */
    L nsw(BiConsumer<NotStartWithRepositoryExpression, NotStartWithRepositoryExpression> notStartWithExpressions);
}