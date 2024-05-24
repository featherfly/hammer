
package cn.featherfly.hammer.expression.entity.condition;

import java.util.function.BiFunction;

import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * The Interface EntityPropertyExpression2.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <E2> the generic type
 * @param <C> the generic type
 * @param <L> the generic type
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
    L property(BiFunction<EntityPropertyExpression<E, ?, ?>, EntityPropertyExpression<E2, ?, ?>,
        LogicExpression<?, ?>> entitiesPropertyFunction);
    // FIXME 这里不用BiFunction<EntityPropertyOnlyExpression<E>, EntityPropertyOnlyExpression<E2>>
    // 是因为这个才openjdk oraclejdk下运行会把类型转换错误，eclipse的编译类型检测是不严谨的，确实类型转换不了
    // 改成这样后，问题就是property()只能有一次的条件了，property(Xx).eq(yy).and()后面就不知道类型了
    // 先这样吧，让其能正常工作，后续再来考虑如何实现and()后还能进行条件判断
}
