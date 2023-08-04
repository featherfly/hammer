
package cn.featherfly.hammer.expression.entity.condition.isn;

import cn.featherfly.common.lang.function.SerializableFunction;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * The Interface EntityIsNullExpressionBase2.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <E2> the generic type
 * @param <C>  the generic type
 * @param <L>  the generic type
 */
public interface EntityIsNullExpressionBase2<E, E2, C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends EntityIsNullExpression<E, C, L> {

    //    /**
    //     * is null.
    //     *
    //     * @param consumer the consumer
    //     * @return LogicExpression
    //     */
    //    L isn2(Consumer<EntityIsNullExpressionBase2<E, C, L>> consumer);

    /**
     * is null.
     *
     * @param <R>  the generic type
     * @param name 参数名称
     * @return LogicExpression
     */
    default <R> L isn2(SerializableFunction<E2, R> name) {
        return isn2(name, true);
    }

    /**
     * is null.
     *
     * @param <R>   the generic type
     * @param name  参数名称
     * @param value if true, is null; if false, is not null; if null, ignore
     *              this operate
     * @return LogicExpression
     */
    <R> L isn2(SerializableFunction<E2, R> name, Boolean value);

    // 嵌套属性使用property(U1::getU2).property(U2:getV).isn(v)来设置
    //    /**
    //     * is null.
    //     *
    //     * @param <R>                 the generic type
    //     * @param <V>                 the value type
    //     * @param fetchEntity         the fetch entity
    //     * @param fetchEntityProperty the fetch entity property
    //     * @return LogicExpression
    //     */
    //    default <R, V> L isn2(SerializableFunction<E2, R> fetchEntity, SerializableFunction<R, V> fetchEntityProperty) {
    //        return isn2(fetchEntity, fetchEntityProperty, true);
    //    }
    //
    //    /**
    //     * is null.
    //     *
    //     * @param <R>                 the generic type
    //     * @param <V>                 the value type
    //     * @param fetchEntityValue    the fetch entity value
    //     * @param fetchEntityProperty the fetch entity property
    //     * @param value               if true, is null; if false, is not null; if
    //     *                            null, ignore this operate
    //     * @return LogicExpression
    //     */
    //    <R, V> L isn2(SerializableFunction<E2, R> fetchEntityValue, SerializableFunction<R, V> fetchEntityProperty,
    //            Boolean value);
}