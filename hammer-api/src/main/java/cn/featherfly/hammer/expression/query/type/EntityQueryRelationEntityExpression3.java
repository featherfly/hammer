
package cn.featherfly.hammer.expression.query.type;

import cn.featherfly.hammer.expression.EntityConditionGroupExpression;
import cn.featherfly.hammer.expression.EntityConditionGroupLogicExpression;
import cn.featherfly.hammer.expression.EntityWhereExpression;

/**
 * type query relation entity expression.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <R1> the generic type
 * @param <R2> the generic type
 * @param <R3> the generic type
 * @param <Q>  the generic type
 * @param <QR> the generic type
 * @param <C>  the generic type
 * @param <L>  the generic type
 */
public interface EntityQueryRelationEntityExpression3<E, R1, R2, R3,
        Q extends EntityQueryEntityPropertiesExpression<E, Q, C, L>,
        QR extends EntityQueryRelationExpression3<E, R1, R2, R3, Q, C, L>,
        C extends EntityConditionGroupExpression<E, C, L>, L extends EntityConditionGroupLogicExpression<E, C, L>>
        extends EntityWhereExpression<E, C, L>, EntityQueryRelationExpression3<E, R1, R2, R3, Q, C, L> {

    /**
     * 添加查询出来的所有属性.
     *
     * @return QueryWithExpression
     */
    QR fetch();
}
