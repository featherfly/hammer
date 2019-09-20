
package cn.featherfly.juorm.expression.query;

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
public interface TypeQueryWithEntityExpression<
        QW extends TypeQueryWithExpression<QW, QWE, C, L>,
        QWE extends TypeQueryWithEntityExpression<QW, QWE, C, L>,
        C extends ConditionGroupExpression<C, L>,
        L extends ConditionGroupLogicExpression<C, L>>
        extends WhereExpression<C, L>, TypeQueryWithExpression<QW, QWE, C, L> {
    // /**
    // * with
    // *
    // * @param propertyName
    // * with type object property name
    // * @param annotherWithPropertyName
    // * with type object property name2
    // * @return TypeQueryWithOnExpression
    // */
    // <T, R> QWE with(SerializableFunction<T, R> propertyName, int index);

    /**
     * 添加查询出来的所有属性
     *
     * @return QueryWithExpression
     */
    QW fetch();
}
