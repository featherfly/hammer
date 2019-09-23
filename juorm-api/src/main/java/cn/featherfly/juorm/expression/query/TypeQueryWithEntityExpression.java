
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
public interface TypeQueryWithEntityExpression<QW extends TypeQueryWithExpression<QW, QWE, C, L>,
        QWE extends TypeQueryWithEntityExpression<QW, QWE, C, L>, C extends ConditionGroupExpression<C, L>,
        L extends ConditionGroupLogicExpression<C, L>>
        extends WhereExpression<C, L>, TypeQueryWithExpression<QW, QWE, C, L> {

    /**
     * 添加查询出来的所有属性
     *
     * @return QueryWithExpression
     */
    QW fetch();
}
