
package cn.featherfly.hammer.expression.query;

import cn.featherfly.hammer.expression.EntityConditionGroupExpression;
import cn.featherfly.hammer.expression.EntityConditionGroupLogicExpression;
import cn.featherfly.hammer.expression.EntityWhereExpression;

/**
 * dsl for query data.
 *
 * @author zhongj
 */
public interface EntityQueryWithEntityExpression<E, QW extends EntityQueryWithExpression<E, QW, QWE, C, L>,
        QWE extends EntityQueryWithEntityExpression<E, QW, QWE, C, L>,
        C extends EntityConditionGroupExpression<E, C, L>, L extends EntityConditionGroupLogicExpression<E, C, L>>
        extends EntityWhereExpression<E, C, L>, EntityQueryWithExpression<E, QW, QWE, C, L> {

    /**
     * 添加查询出来的所有属性
     *
     * @return QueryWithExpression
     */
    QW fetch();
}
