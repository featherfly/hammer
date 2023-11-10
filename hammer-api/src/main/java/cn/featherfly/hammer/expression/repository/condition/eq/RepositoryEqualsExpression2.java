
package cn.featherfly.hammer.expression.repository.condition.eq;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

import com.speedment.common.tuple.Tuple2;

import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * RepositoryEqualsExpression2.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface RepositoryEqualsExpression2<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends RepositoryEqualsExpressionBase2<C, L> {

    /**
     * equals. 等于.
     *
     * @param equalsRepositoryExpressions the equals repository expressions
     * @return the LogicExpression
     */
    L eq(Consumer<Tuple2<EqualsRepositoryExpression, EqualsRepositoryExpression>> equalsRepositoryExpressions);

    /**
     * equals. 等于.
     *
     * @param equalsRepositoryExpressions the equals repository expressions
     * @return the LogicExpression
     */
    L eq(BiConsumer<EqualsRepositoryExpression, EqualsRepositoryExpression> equalsRepositoryExpressions);
}