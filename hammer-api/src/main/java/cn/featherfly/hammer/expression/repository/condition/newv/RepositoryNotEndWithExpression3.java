
package cn.featherfly.hammer.expression.repository.condition.newv;

import java.util.function.Consumer;

import com.speedment.common.tuple.Tuple3;

import cn.featherfly.common.function.ThreeArgusConsumer;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * repository not end with expression3 .
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface RepositoryNotEndWithExpression3<C extends ConditionExpression, L extends LogicExpression<C, L>>
    extends RepositoryNotEndWithExpressionBase3<C, L> {
    /**
     * not end with.
     *
     * @param endWithRepositoryExpressions the end with repository expressions
     * @return the LogicExpression
     */
    L newv(Consumer<Tuple3<NotEndWithRepositoryExpression, NotEndWithRepositoryExpression,
        NotEndWithRepositoryExpression>> notEndWithExpressions);

    /**
     * not end with.
     *
     * @param endWithRepositoryExpressions the end with repository expressions
     * @return the LogicExpression
     */
    L newv(ThreeArgusConsumer<NotEndWithRepositoryExpression, NotEndWithRepositoryExpression,
        NotEndWithRepositoryExpression> notEndWithExpressions);
}