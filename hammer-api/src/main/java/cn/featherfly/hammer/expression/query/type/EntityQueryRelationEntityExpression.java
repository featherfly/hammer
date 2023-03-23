
package cn.featherfly.hammer.expression.query.type;

import cn.featherfly.hammer.expression.EntityConditionGroupExpression;
import cn.featherfly.hammer.expression.EntityConditionGroupLogicExpression;
import cn.featherfly.hammer.expression.EntityWhereExpression;

/**
 * type query relation entity expression.
 *
 * @author zhongj
 */
public interface EntityQueryRelationEntityExpression<E, R1, Q extends EntityQueryEntityPropertiesExpression<E, Q, C, L>,
        QR extends EntityQueryRelationExpression<E, R1, Q, C, L>, C extends EntityConditionGroupExpression<E, C, L>,
        L extends EntityConditionGroupLogicExpression<E, C, L>>
        extends EntityWhereExpression<E, C, L>, EntityQueryRelationExpression<E, R1, Q, C, L>
/*, EntityQueryRelationEntitySimpleExpression<E, R1, T, QW, QWE>*/ {

    /**
     * 添加查询出来的所有属性
     *
     * @return QueryWithExpression
     */
    QR fetch();

    //    /**
    //     * 结束当前条件并进入排序器
    //     *
    //     * @return QuerySortExpression
    //     */
    //       IMPLSOON  后续实现EntityQuerySortExpression带多个实体
    //    EntityQuerySortExpression2<E, R1> sort();
    //    EntityQuerySortExpression2<E, R1, R2> sort();
}
