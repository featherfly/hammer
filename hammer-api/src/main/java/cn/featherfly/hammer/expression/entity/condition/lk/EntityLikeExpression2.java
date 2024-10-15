
package cn.featherfly.hammer.expression.entity.condition.lk;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

import cn.featherfly.common.tuple.Tuple2;

import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * The Interface EntityLikeExpression2.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <E2> the generic type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface EntityLikeExpression2<E, E2, C extends ConditionExpression, L extends LogicExpression<C, L>>
    extends EntityLikeExpressionBase2<E, E2, C, L> {

    /**
     * like value.
     *
     * @param likeEntityExpressions the like entity expressions
     * @return the LogicExpression
     */
    L lk(Consumer<Tuple2<LikeEntityExpression<E>, LikeEntityExpression<E2>>> likeEntityExpressions);

    /**
     * like value.
     *
     * @param likeEntityExpressions the like entity expressions
     * @return the LogicExpression
     */
    L lk(BiConsumer<LikeEntityExpression<E>, LikeEntityExpression<E2>> likeEntityExpressions);
}