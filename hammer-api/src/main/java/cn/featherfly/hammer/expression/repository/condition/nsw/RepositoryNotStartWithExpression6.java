
package cn.featherfly.hammer.expression.repository.condition.nsw;

import java.util.function.Consumer;

import com.speedment.common.tuple.Tuple6;

import cn.featherfly.common.function.SixArgusConsumer;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * repository not start with expression6 .
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface RepositoryNotStartWithExpression6<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends RepositoryNotStartWithExpressionBase6<C, L> {

    /**
     * not start with.
     *
     * @param notStartWithExpressions the not start with expressions
     * @return the LogicExpression
     */
    L nsw(Consumer<Tuple6<NotStartWithRepositoryExpression, NotStartWithRepositoryExpression, NotStartWithRepositoryExpression, NotStartWithRepositoryExpression, NotStartWithRepositoryExpression, NotStartWithRepositoryExpression>> notStartWithExpressions);

    /**
     * not start with.
     *
     * @param notStartWithExpressions the not start with expressions
     * @return the LogicExpression
     */
    L nsw(SixArgusConsumer<NotStartWithRepositoryExpression, NotStartWithRepositoryExpression, NotStartWithRepositoryExpression, NotStartWithRepositoryExpression, NotStartWithRepositoryExpression, NotStartWithRepositoryExpression> notStartWithExpressions);
}