
package cn.featherfly.hammer.expression.repository.condition.ni;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

import com.speedment.common.tuple.Tuple2;

import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * repository not in expression2 .
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface RepositoryNotInExpression2<C extends ConditionExpression, L extends LogicExpression<C, L>>
    extends RepositoryNotInExpressionBase2<C, L> {
    /**
     * not in.
     *
     * @param notInExpressions the not in expressions
     * @return the LogicExpression
     */
    L ni(Consumer<Tuple2<NotInRepositoryExpression, NotInRepositoryExpression>> notInExpressions);

    /**
     * not in.
     *
     * @param notInExpressions the not in expressions
     * @return the LogicExpression
     */
    L ni(BiConsumer<NotInRepositoryExpression, NotInRepositoryExpression> notInExpressions);
}