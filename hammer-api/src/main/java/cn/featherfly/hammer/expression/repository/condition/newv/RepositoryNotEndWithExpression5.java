
package cn.featherfly.hammer.expression.repository.condition.newv;

import java.util.function.Consumer;

import cn.featherfly.common.tuple.Tuple5;

import cn.featherfly.common.function.FiveArgusConsumer;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * repository not end with expression5 .
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface RepositoryNotEndWithExpression5<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends RepositoryNotEndWithExpressionBase5<C, L> {

    /**
     * not end with.
     *
     * @param notEndWithExpressions the not end with expressions
     * @return the LogicExpression
     */
    L newv(Consumer<Tuple5<NotEndWithRepositoryExpression, NotEndWithRepositoryExpression, NotEndWithRepositoryExpression, NotEndWithRepositoryExpression, NotEndWithRepositoryExpression>> notEndWithExpressions);

    /**
     * not end with.
     *
     * @param notEndWithExpressions the not end with expressions
     * @return the LogicExpression
     */
    L newv(FiveArgusConsumer<NotEndWithRepositoryExpression, NotEndWithRepositoryExpression, NotEndWithRepositoryExpression, NotEndWithRepositoryExpression, NotEndWithRepositoryExpression> notEndWithExpressions);
}