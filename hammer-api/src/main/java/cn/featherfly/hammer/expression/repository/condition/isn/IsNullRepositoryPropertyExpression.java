
package cn.featherfly.hammer.expression.repository.condition.isn;

import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.hammer.expression.entity.condition.NullNotNullEntityPropertyValueExpression;
import cn.featherfly.hammer.expression.repository.condition.NullNotNullRepositoryExpression;

/**
 * The Interface IsNullEntityPropertyExpression.
 *
 * @author zhongj
 */
public interface IsNullRepositoryPropertyExpression
        extends NullNotNullEntityPropertyValueExpression, NullNotNullRepositoryExpression {

    /**
     * repository is null function property expression.
     *
     * @param name the name
     * @return entity is null function property expression
     */
    IsNullRepositoryPropertyExpression property(String name);

    /**
     * repository is null function property expression.
     *
     * @param <T>  the generic type
     * @param <R>  the generic type
     * @param name the name
     * @return entity is null function property expression
     */
    <T, R> IsNullRepositoryPropertyExpression property(SerializableFunction<T, R> name);
}
