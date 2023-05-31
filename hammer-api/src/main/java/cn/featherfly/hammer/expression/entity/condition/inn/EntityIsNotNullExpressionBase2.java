
package cn.featherfly.hammer.expression.entity.condition.inn;

import cn.featherfly.common.lang.function.SerializableFunction;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * The Interface EntityIsNotNullExpressionBase2.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <E2> the generic type
 * @param <C>  the generic type
 * @param <L>  the generic type
 */
public interface EntityIsNotNullExpressionBase2<E, E2, C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends EntityIsNotNullExpression<E, C, L> {

    //    /**
    //     * is not null.
    //     *
    //     * @param consumer the consumer
    //     * @return LogicExpression
    //     */
    //    L inn2(Consumer<EntityIsNotNullExpression.Base2<E, C, L>> consumer);

    /**
     * is not null.
     *
     * @param <R>  the generic type
     * @param name 参数名称
     * @return LogicExpression
     */
    default <R> L inn2(SerializableFunction<E2, R> name) {
        return inn2(name, true);
    }

    /**
     * is not null.
     *
     * @param <R>   the generic type
     * @param name  参数名称
     * @param value if true, is null; if false, is not null; if null, ignore
     *              this operate
     * @return LogicExpression
     */
    <R> L inn2(SerializableFunction<E2, R> name, Boolean value);

    // 嵌套属性使用property(U1::getU2).property(U2:getV).inn(v)来设置
    //    /**
    //     * is not null.
    //     *
    //     * @param <R>                 the generic type
    //     * @param <V>                 the value type
    //     * @param fetchEntity         the fetch entity
    //     * @param fetchEntityProperty the fetch entity property
    //     * @return LogicExpression
    //     */
    //    default <R, V> L inn2(SerializableFunction<E2, R> fetchEntity, SerializableFunction<R, V> fetchEntityProperty) {
    //        return inn2(fetchEntity, fetchEntityProperty, true);
    //    }
    //
    //    /**
    //     * is not null.
    //     *
    //     * @param <R>                 the generic type
    //     * @param <V>                 the value type
    //     * @param fetchEntityValue    the fetch entity value
    //     * @param fetchEntityProperty the fetch entity property
    //     * @param value               if true, is null; if false, is not null; if
    //     *                            null, ignore this operate
    //     * @return LogicExpression
    //     */
    //    <R, V> L inn2(SerializableFunction<E2, R> fetchEntityValue, SerializableFunction<R, V> fetchEntityProperty,
    //            Boolean value);
}