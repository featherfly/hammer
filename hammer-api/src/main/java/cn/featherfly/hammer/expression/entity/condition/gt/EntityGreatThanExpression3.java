
package cn.featherfly.hammer.expression.entity.condition.gt;

import java.util.function.Consumer;

import com.speedment.common.tuple.Tuple3;

import cn.featherfly.common.function.ThreeArgusConsumer;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * The Interface EntityGreatThanExpression3.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <E2> the generic type
 * @param <E3> the generic type
 * @param <C>  the generic type
 * @param <L>  the generic type
 */
public interface EntityGreatThanExpression3<E, E2, E3, C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends EntityGreatThanExpressionBase3<E, E2, E3, C, L> {

    /**
     * great than. 大于.
     *
     * @param greatThanEntityExpressions the great than entity expressions
     * @return the LogicExpression
     */
    L gt(Consumer<Tuple3<GreatThanEntityExpression<E>, GreatThanEntityExpression<E2>,
            GreatThanEntityExpression<E3>>> greatThanEntityExpressions);

    /**
     * great than. 大于.
     *
     * @param greatThanEntityExpressions the great than entity expressions
     * @return the LogicExpression
     */
    L gt(ThreeArgusConsumer<GreatThanEntityExpression<E>, GreatThanEntityExpression<E2>,
            GreatThanEntityExpression<E3>> greatThanEntityExpressions);
}