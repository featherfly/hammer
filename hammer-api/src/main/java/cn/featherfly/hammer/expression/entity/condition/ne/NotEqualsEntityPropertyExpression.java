
package cn.featherfly.hammer.expression.entity.condition.ne;

import java.util.Collection;

import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.function.serializable.SerializableToCollectionFunction;
import cn.featherfly.hammer.expression.entity.condition.EqualsNotEqualsEntityExpression;
import cn.featherfly.hammer.expression.entity.condition.EqualsNotEqualsEntityPropertyValueExpression;

/**
 * The Interface NotEqualsEntityPropertyExpression.
 *
 * @author zhongj
 * @param <T> the value type
 */
public interface NotEqualsEntityPropertyExpression<T>
        extends EqualsNotEqualsEntityExpression<T>, EqualsNotEqualsEntityPropertyValueExpression<T> {

    /**
     * entity not equals function property expression.
     *
     * @param <R>  the generic type
     * @param name the name
     * @return entity not equals function property expression.
     */
    <R> NotEqualsEntityPropertyExpression<R> property(SerializableFunction<T, R> name);

    /**
     * entity not equals function property expression.
     *
     * @param <R>  the generic type
     * @param <RE> the generic type
     * @param name the name
     * @return entity not equals function property expression.
     */
    <R extends Collection<RE>,
            RE> NotEqualsEntityPropertyExpression<RE> property(SerializableToCollectionFunction<T, R, RE> name);

}
