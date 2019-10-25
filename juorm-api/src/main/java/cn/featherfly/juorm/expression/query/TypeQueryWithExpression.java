
package cn.featherfly.juorm.expression.query;

import cn.featherfly.common.lang.function.SerializableFunction;
import cn.featherfly.juorm.expression.RepositoryConditionGroupLogicExpression;
import cn.featherfly.juorm.expression.RepositoryWhereExpression;
import cn.featherfly.juorm.expression.condition.RepositoryConditionsGroupExpression;

/**
 * <p>
 * dsl for query data
 * </p>
 *
 * @author zhongj
 */
public interface TypeQueryWithExpression<QW extends TypeQueryWithExpression<QW, QWE, C, L>,
        QWE extends TypeQueryWithEntityExpression<QW, QWE, C, L>, C extends RepositoryConditionsGroupExpression<C, L>,
        L extends RepositoryConditionGroupLogicExpression<C, L>>
        extends RepositoryWhereExpression<C, L>, TypeQueryListExecutor, TypeQueryConditionLimit {
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
