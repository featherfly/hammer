
package cn.featherfly.juorm.expression.query;

import cn.featherfly.common.lang.function.SerializableFunction;
import cn.featherfly.juorm.expression.ConditionGroupExpression;
import cn.featherfly.juorm.expression.ConditionGroupLogicExpression;
import cn.featherfly.juorm.expression.WhereExpression;

/**
 * <p>
 * dsl for query data
 * </p>
 *
 * @author zhongj
 */
public interface TypeQueryWithExpression<QW extends TypeQueryWithExpression<QW, QWE, C, L>,
        QWE extends TypeQueryWithEntityExpression<QW, QWE, C, L>, C extends ConditionGroupExpression<C, L>,
        L extends ConditionGroupLogicExpression<C, L>>
        extends WhereExpression<C, L>, TypeQueryListExecutor, TypeQueryConditionLimit {
    /**
     * with
     *
     * @param propertyName find type object property name
     * @return TypeQueryWithOnExpression
     */
    <T, R> QWE with(SerializableFunction<T, R> propertyName);

    /**
     * with
     *
     * @param propertyName with type object property name
     * @param index        with index
     * @return TypeQueryWithOnExpression
     */
    <T, R> QWE with(SerializableFunction<T, R> propertyName, int index);

}
