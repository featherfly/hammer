
package cn.featherfly.hammer.expression.repository.condition.nsw;

import java.util.function.Consumer;

import com.speedment.common.tuple.Tuple5;

import cn.featherfly.common.function.FiveArgusConsumer;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * repository not start with expression5 .
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface RepositoryNotStartWithExpression5<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends RepositoryNotStartWithExpressionBase5<C, L> {

    /**
     * not start with.
     *
     * @param notStartWithExpressions the not start with expressions
     * @return the LogicExpression
     */
    L nsw(Consumer<Tuple5<NotStartWithRepositoryExpression, NotStartWithRepositoryExpression, NotStartWithRepositoryExpression, NotStartWithRepositoryExpression, NotStartWithRepositoryExpression>> notStartWithExpressions);

    /**
     * not start with.
     *
     * @param notStartWithExpressions the not start with expressions
     * @return the LogicExpression
     */
    L nsw(FiveArgusConsumer<NotStartWithRepositoryExpression, NotStartWithRepositoryExpression, NotStartWithRepositoryExpression, NotStartWithRepositoryExpression, NotStartWithRepositoryExpression> notStartWithExpressions);
}