
package cn.featherfly.juorm.expression.query;

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
public interface TypeQueryWithEntityExpression<QW extends TypeQueryWithExpression<QW, QWE, C, L>,
        QWE extends TypeQueryWithEntityExpression<QW, QWE, C, L>, C extends RepositoryConditionsGroupExpression<C, L>,
        L extends RepositoryConditionGroupLogicExpression<C, L>>
        extends RepositoryWhereExpression<C, L>, TypeQueryWithExpression<QW, QWE, C, L> {

    /**
     * 添加查询出来的所有属性
     *
     * @return QueryWithExpression
     */
    QW fetch();
}
