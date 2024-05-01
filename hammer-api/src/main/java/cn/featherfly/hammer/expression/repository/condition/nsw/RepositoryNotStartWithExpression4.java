
package cn.featherfly.hammer.expression.repository.condition.nsw;

import java.util.function.Consumer;

import com.speedment.common.tuple.Tuple4;

import cn.featherfly.common.function.FourArgusConsumer;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * repository not start with expression4 .
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface RepositoryNotStartWithExpression4<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends RepositoryNotStartWithExpressionBase4<C, L> {

    /**
     * not start with.
     *
     * @param notStartWithExpressions the not start with expressions
     * @return the LogicExpression
     */
    L nsw(Consumer<Tuple4<NotStartWithRepositoryExpression, NotStartWithRepositoryExpression, NotStartWithRepositoryExpression, NotStartWithRepositoryExpression>> notStartWithExpressions);

    /**
     * not start with.
     *
     * @param notStartWithExpressions the not start with expressions
     * @return the LogicExpression
     */
    L nsw(FourArgusConsumer<NotStartWithRepositoryExpression, NotStartWithRepositoryExpression, NotStartWithRepositoryExpression, NotStartWithRepositoryExpression> notStartWithExpressions);
}