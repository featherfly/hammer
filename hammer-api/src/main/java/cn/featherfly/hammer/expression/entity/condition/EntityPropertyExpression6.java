
package cn.featherfly.hammer.expression.entity.condition;

import cn.featherfly.common.function.SixArgusFunction;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.entity.condition.property.EntityPropertyOnlyExpression;

/**
 * The Interface EntityPropertyExpression6.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <E2> the generic type
 * @param <E3> the generic type
 * @param <E4> the generic type
 * @param <E5> the generic type
 * @param <E6> the generic type
 * @param <C>  the generic type
 * @param <L>  the generic type
 */
public interface EntityPropertyExpression6<E, E2, E3, E4, E5, E6, C extends ConditionExpression,
        L extends LogicExpression<C, L>> extends EntityPropertyExpression<E, C, L> {

    /**
     * property.
     *
     * @param entityPropertyFunction the entity property function
     * @return the LogicExpression
     */
    L property(SixArgusFunction<EntityPropertyOnlyExpression<E>, EntityPropertyOnlyExpression<E2>,
            EntityPropertyOnlyExpression<E3>, EntityPropertyOnlyExpression<E4>, EntityPropertyOnlyExpression<E5>,
            EntityPropertyOnlyExpression<E6>, LogicExpression<?, ?>> entityPropertyFunction);

    // 此方法在lambda里没法返回L
    //    /**
    //     * property.
    //     *
    //     * @param entitiesPropertyFunction the entities property function
    //     * @return the LogicExpression
    //     */
    //    L property(SixArgusFunction<EntityPropertyOnlyExpression<E, C, L>, EntityPropertyOnlyExpression<E2, C, L>,
    //            EntityPropertyOnlyExpression<E3, C, L>, EntityPropertyOnlyExpression<E4, C, L>, EntityPropertyOnlyExpression<E5, C, L>,
    //            EntityPropertyOnlyExpression<E6, C, L>, L> entitiesPropertyFunction);

    // 此方法会和普通的property(SerializableXXXyyy)方法泛型冲突
    //    /**
    //     * property.
    //     *
    //     * @param entitiesPropertyFunction the entities property function
    //     * @return the LogicExpression
    //     */
    //    L property(
    //            Function<
    //                    Tuple6<EntityPropertyFunction<E, C, L>, EntityPropertyFunction<E2, C, L>,
    //                            EntityPropertyFunction<E3, C, L>, EntityPropertyFunction<E4, C, L>,
    //                            EntityPropertyFunction<E5, C, L>, EntityPropertyFunction<E6, C, L>>,
    //                    L> entitiesPropertyFunction);

}
