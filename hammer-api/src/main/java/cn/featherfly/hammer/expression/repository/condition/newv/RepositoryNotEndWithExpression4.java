
package cn.featherfly.hammer.expression.repository.condition.newv;

import java.util.function.Consumer;

import cn.featherfly.common.tuple.Tuple4;

import cn.featherfly.common.function.FourArgusConsumer;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * repository not end with expression4 .
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface RepositoryNotEndWithExpression4<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends RepositoryNotEndWithExpressionBase4<C, L> {

    /**
     * not end with.
     *
     * @param notEndWithExpressions the not end with expressions
     * @return the LogicExpression
     */
    L newv(Consumer<Tuple4<NotEndWithRepositoryExpression, NotEndWithRepositoryExpression, NotEndWithRepositoryExpression, NotEndWithRepositoryExpression>> notEndWithExpressions);

    /**
     * not end with.
     *
     * @param notEndWithExpressions the not end with expressions
     * @return the LogicExpression
     */
    L newv(FourArgusConsumer<NotEndWithRepositoryExpression, NotEndWithRepositoryExpression, NotEndWithRepositoryExpression, NotEndWithRepositoryExpression> notEndWithExpressions);
}