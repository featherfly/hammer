
package cn.featherfly.hammer.expression.entity.condition;

import cn.featherfly.common.function.ThreeArgusFunction;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.entity.condition.property.EntityPropertyOnlyExpression;

/**
 * The Interface EntityPropertyExpression3.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <E2> the generic type
 * @param <E3> the generic type
 * @param <C>  the generic type
 * @param <L>  the generic type
 */
public interface EntityPropertyExpression3<E, E2, E3, C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends EntityPropertyExpression<E, C, L> {

    /**
     * property.
     *
     * @param entityPropertyFunction the entity property function
     * @return the LogicExpression
     */
    L property(ThreeArgusFunction<EntityPropertyOnlyExpression<E>, EntityPropertyOnlyExpression<E2>,
            EntityPropertyOnlyExpression<E3>, LogicExpression<?, ?>> entityPropertyFunction);

    //    /**
    //     * property.
    //     *
    //     * @param entitiesPropertyFunction the entities property function
    //     * @return the LogicExpression
    //     */
    //    L property(ThreeArgusFunction<EntityPropertyOnlyExpression<E, C, L>, EntityPropertyOnlyExpression<E2, C, L>,
    //            EntityPropertyOnlyExpression<E3, C, L>, L> entitiesPropertyFunction);

    // 此方法会和普通的property(SerializableXXXyyy)方法泛型冲突
    //    /**
    //     * property.
    //     *
    //     * @param entitiesPropertyFunction the entities property function
    //     * @return the LogicExpression
    //     */
    //    L property(Function<
    //            Tuple3<EntityPropertyFunction<E, C, L>, EntityPropertyFunction<E2, C, L>, EntityPropertyFunction<E3, C, L>>,
    //            L> entitiesPropertyFunction);

}
