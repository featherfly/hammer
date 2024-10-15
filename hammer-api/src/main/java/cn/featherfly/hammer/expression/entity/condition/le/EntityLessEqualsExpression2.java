
package cn.featherfly.hammer.expression.entity.condition.le;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

import cn.featherfly.common.tuple.Tuple2;

import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * The Interface EntityLessEqualsExpression2.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <E2> the generic type
 * @param <C>  the generic type
 * @param <L>  the generic type
 */
public interface EntityLessEqualsExpression2<E, E2, C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends EntityLessEqualsExpressionBase2<E, E2, C, L> {

    /**
     * less and equals. 小于等于.
     *
     * @param lessEqualsEntityExpressions the less equals entity expressions
     * @return the LogicExpression
     */
    L le(Consumer<Tuple2<LessEqualsEntityExpression<E>, LessEqualsEntityExpression<E2>>> lessEqualsEntityExpressions);

    /**
     * less and equals. 小于等于.
     *
     * @param lessEqualsEntityExpressions the less equals entity expressions
     * @return the LogicExpression
     */
    L le(BiConsumer<LessEqualsEntityExpression<E>, LessEqualsEntityExpression<E2>> lessEqualsEntityExpressions);
}