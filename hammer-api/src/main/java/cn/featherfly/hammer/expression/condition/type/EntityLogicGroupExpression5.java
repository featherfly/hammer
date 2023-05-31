
package cn.featherfly.hammer.expression.condition.type;

import cn.featherfly.hammer.expression.condition.GroupEndExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * The Interface EntityLogicGroupExpression5.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <E2> the generic type
 * @param <E3> the generic type
 * @param <E4> the generic type
 * @param <E5> the generic type
 * @param <C>  the generic type
 * @param <L>  the generic type
 */
public interface EntityLogicGroupExpression5<E, E2, E3, E4, E5,
        C extends EntityConditionsGroupExpression5<E, E2, E3, E4, E5, C, L>,
        L extends EntityLogicGroupExpression5<E, E2, E3, E4, E5, C, L>>
        extends LogicExpression<C, L>, GroupEndExpression<L> {

}
