
package cn.featherfly.hammer.expression.entity.condition.eq;

import java.util.Collection;

import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.function.serializable.SerializableToCollectionFunction;
import cn.featherfly.hammer.expression.entity.condition.EqualsNotEqualsEntityExpression;
import cn.featherfly.hammer.expression.entity.condition.EqualsNotEqualsEntityPropertyValueExpression;

/**
 * The Interface EqualsEntityPropertyExpression.
 *
 * @author zhongj
 * @param <T> the value type
 */
public interface EqualsEntityPropertyExpression<T>
        extends EqualsNotEqualsEntityExpression<T>, EqualsNotEqualsEntityPropertyValueExpression<T> {

    /**
     * entity equals function property expression.
     *
     * @param <R>  the generic type
     * @param name the name
     * @return entity equals function property expression.
     */
    <R> EqualsEntityPropertyExpression<R> property(SerializableFunction<T, R> name);

    /**
     * entity equals function property expression.
     *
     * @param <R>  the generic type
     * @param <RE> the generic type
     * @param name the name
     * @return entity equals function property expression.
     */
    <R extends Collection<RE>,
            RE> EqualsEntityPropertyExpression<RE> property(SerializableToCollectionFunction<T, R, RE> name);
}
