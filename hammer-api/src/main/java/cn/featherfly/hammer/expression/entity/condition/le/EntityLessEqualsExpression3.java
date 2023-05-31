
package cn.featherfly.hammer.expression.entity.condition.le;

import java.util.function.Consumer;

import com.speedment.common.tuple.Tuple3;

import cn.featherfly.common.function.ThreeArgusConsumer;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * The Interface EntityLessEqualsExpression3.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <E2> the generic type
 * @param <E3> the generic type
 * @param <C>  the generic type
 * @param <L>  the generic type
 */
public interface EntityLessEqualsExpression3<E, E2, E3, C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends EntityLessEqualsExpressionBase3<E, E2, E3, C, L> {

    /**
     * less and equals. 小于等于.
     *
     * @param lessEqualsEntityExpressions the less equals entity expressions
     * @return the LogicExpression
     */
    L le(Consumer<Tuple3<LessEqualsEntityExpression<E>, LessEqualsEntityExpression<E2>,
            LessEqualsEntityExpression<E3>>> lessEqualsEntityExpressions);

    /**
     * less and equals. 小于等于.
     *
     * @param lessEqualsEntityExpressions the less equals entity expressions
     * @return the LogicExpression
     */
    L le(ThreeArgusConsumer<LessEqualsEntityExpression<E>, LessEqualsEntityExpression<E2>,
            LessEqualsEntityExpression<E3>> lessEqualsEntityExpressions);
}