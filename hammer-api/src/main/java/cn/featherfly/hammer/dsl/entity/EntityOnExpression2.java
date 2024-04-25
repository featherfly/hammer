
package cn.featherfly.hammer.dsl.entity;

import cn.featherfly.common.function.ThreeArgusFunction;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.entity.condition.property.EntityPropertyOnlyExpression;

/**
 * entity second time join on expression.
 *
 * @author zhongj
 * @param <E1> query type
 * @param <E2> query or joined type
 * @param <J>  join type
 * @param <R>  after on expression type
 */
public interface EntityOnExpression2<E1, E2, J, R> extends EntityOnExpression<E1, J, R> {

    /**
     * on expression.
     *
     * @param onExpression the on expression. <br/>
     *                     <ol>
     *                     <li>query type property expresion
     *                     <li>query or joined type property expresion
     *                     <li>current join type property expression
     *                     <li>return logic expression
     *                     </ol>
     * @return the RepositoryQueryRelateExpression
     */
    R on(ThreeArgusFunction<EntityPropertyOnlyExpression<E1>, EntityPropertyOnlyExpression<E2>,
        EntityPropertyOnlyExpression<J>, LogicExpression<?, ?>> onExpression);
}
