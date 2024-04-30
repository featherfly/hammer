
package cn.featherfly.hammer.expression.repository.execute;

import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.execute.UpdateNumberValueExpression;
import cn.featherfly.hammer.expression.execute.UpdateValueExpression;

/**
 * The Interface RepositoryFieldUpdateExpression.
 *
 * @author zhongj
 * @param <U> the generic type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface RepositoryFieldUpdateExpression<U, C extends ConditionExpression, L extends LogicExpression<C, L>> {

    /**
     * field.
     *
     * @param name the name
     * @return the v
     */
    UpdateValueExpression<Object, U, C, L> field(String name);

    /**
     * field as number.
     *
     * @param name the name
     * @return the vn
     */
    UpdateNumberValueExpression<Number, U, C, L> fieldAsNumber(String name);

    /**
     * field.
     *
     * @param <T>  the generic type
     * @param <R>  the generic type
     * @param name the name
     * @return the UpdateValueExpression
     */
    <T, R> UpdateValueExpression<R, U, C, L> field(SerializableFunction<T, R> name);

    /**
     * field as number.
     *
     * @param <T>  the generic type
     * @param <R>  the generic type
     * @param name the name
     * @return the UpdateNumberValueExpression
     */
    <T, R extends Number> UpdateNumberValueExpression<R, U, C, L> fieldAsNumber(SerializableFunction<T, R> name);
}
