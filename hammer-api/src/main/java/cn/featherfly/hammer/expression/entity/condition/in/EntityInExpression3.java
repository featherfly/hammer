
package cn.featherfly.hammer.expression.entity.condition.in;

import java.util.function.Consumer;

import com.speedment.common.tuple.Tuple3;

import cn.featherfly.common.function.ThreeArgusConsumer;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * The Interface EntityInExpression3.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <E2> the generic type
 * @param <E3> the generic type
 * @param <C>  the generic type
 * @param <L>  the generic type
 */
public interface EntityInExpression3<E, E2, E3, C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends EntityInExpressionBase3<E, E2, E3, C, L> {

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param inEntityExpressions the in entity expressions
     * @return the LogicExpression
     */
    L in(Consumer<Tuple3<InEntityExpression<E>, InEntityExpression<E2>, InEntityExpression<E3>>> inEntityExpressions);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param inEntityExpressions the in entity expressions
     * @return the LogicExpression
     */
    L in(ThreeArgusConsumer<InEntityExpression<E>, InEntityExpression<E2>, InEntityExpression<E3>> inEntityExpressions);
}