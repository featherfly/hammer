
package cn.featherfly.hammer.expression.entity.condition.in;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

import com.speedment.common.tuple.Tuple2;

import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * The Interface EntityInExpression2.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <E2> the generic type
 * @param <C>  the generic type
 * @param <L>  the generic type
 */
public interface EntityInExpression2<E, E2, C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends EntityInExpressionBase2<E, E2, C, L> {

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param entitiesInFunction the entities in function
     * @return the LogicExpression
     */
    L in(Consumer<Tuple2<InEntityExpression<E>, InEntityExpression<E2>>> inEntityExpressions);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param entitiesInFunction the entities in function
     * @return the LogicExpression
     */
    L in(BiConsumer<InEntityExpression<E>, InEntityExpression<E2>> inEntityExpressions);

}