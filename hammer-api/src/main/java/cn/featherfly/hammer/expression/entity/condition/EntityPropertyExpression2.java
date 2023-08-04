
package cn.featherfly.hammer.expression.entity.condition;

import java.util.function.BiFunction;

import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.entity.condition.property.EntityPropertyFunction;

/**
 * The Interface EntityPropertyExpression2.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <E2> the generic type
 * @param <C>  the generic type
 * @param <L>  the generic type
 */
public interface EntityPropertyExpression2<E, E2, C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends EntityPropertyExpression<E, C, L> {
    // 此方法会和普通的property(SerializableXXXyyy)方法泛型冲突
    //    /**
    //     * property.
    //     *
    //     * @param entitiesPropertyFunction the entities property function
    //     * @return the LogicExpression
    //     */
    //    L property(Function<Tuple2<EntityPropertyFunction<E, C, L>, EntityPropertyFunction<E2, C, L>>,
    //            L> entitiesPropertyFunction);

    // YUFEI_TODO 再考虑是否加入property2(SerializableXXXyyy)一些列方法

    /**
     * property.
     *
     * @param entitiesPropertyFunction the entities property function
     * @return the LogicExpression
     */
    L property(
            BiFunction<EntityPropertyFunction<E, C, L>, EntityPropertyFunction<E2, C, L>, L> entitiesPropertyFunction);

}
