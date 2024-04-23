
package cn.featherfly.hammer.expression.repository.execute;

import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.hammer.config.dsl.UpdateConditionConfig;
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
public interface RepositoryFieldUpdateExpression<U extends FieldExecutableUpdateExpression<U, C, L>,
    C extends ExecutableConditionGroupExpression<C, L, UpdateConditionConfig>,
    L extends ExecutableConditionGroupLogicExpression<C, L, UpdateConditionConfig>> {

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