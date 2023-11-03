
package cn.featherfly.hammer.expression.repository.condition.newv;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

import com.speedment.common.tuple.Tuple2;

import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * repository not end with expression2 .
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface RepositoryNotEndWithExpression2<C extends ConditionExpression, L extends LogicExpression<C, L>>
    extends RepositoryNotEndWithExpressionBase2<C, L> {
    /**
     * not end with.
     *
     * @param endWithRepositoryExpressions the end with repository expressions
     * @return the LogicExpression
     */
    L newv(Consumer<Tuple2<NotEndWithRepositoryExpression, NotEndWithRepositoryExpression>> notEndWithExpressions);

    /**
     * not end with.
     *
     * @param endWithRepositoryExpressions the end with repository expressions
     * @return the LogicExpression
     */
    L newv(BiConsumer<NotEndWithRepositoryExpression, NotEndWithRepositoryExpression> notEndWithExpressions);
}