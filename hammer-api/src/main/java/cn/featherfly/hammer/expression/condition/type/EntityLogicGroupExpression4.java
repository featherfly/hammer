
package cn.featherfly.hammer.expression.condition.type;

import cn.featherfly.hammer.expression.condition.GroupEndExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * The Interface EntityLogicGroupExpression4.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <E2> the generic type
 * @param <E3> the generic type
 * @param <E4> the generic type
 * @param <C>  the generic type
 * @param <L>  the generic type
 */
public interface EntityLogicGroupExpression4<E, E2, E3, E4,
        C extends EntityConditionsGroupExpression4<E, E2, E3, E4, C, L>,
        L extends EntityLogicGroupExpression4<E, E2, E3, E4, C, L>>
        extends LogicExpression<C, L>, GroupEndExpression<L> {

}
