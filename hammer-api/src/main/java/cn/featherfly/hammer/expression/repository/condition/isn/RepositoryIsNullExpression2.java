
package cn.featherfly.hammer.expression.repository.condition.isn;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

import com.speedment.common.tuple.Tuple2;

import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * RepositoryIsNullExpression2 .
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface RepositoryIsNullExpression2<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends RepositoryIsNullExpressionBase2<C, L> {

    /**
     * is null.
     *
     * @param isNullRepositoryExpressions the is null repository expressions
     * @return the LogicExpression
     */
    L isn(Consumer<Tuple2<IsNullRepositoryExpression, IsNullRepositoryExpression>> isNullRepositoryExpressions);

    /**
     * is null.
     *
     * @param isNullRepositoryExpressions the is null repository expressions
     * @return the LogicExpression
     */
    L isn(BiConsumer<IsNullRepositoryExpression, IsNullRepositoryExpression> isNullRepositoryExpressions);

}