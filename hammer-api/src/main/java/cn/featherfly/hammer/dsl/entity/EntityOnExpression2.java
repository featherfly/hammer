
package cn.featherfly.hammer.dsl.entity;

import cn.featherfly.common.function.ThreeArgusFunction;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.entity.condition.property.EntityPropertyOnlyExpression;

/**
 * The Interface EntityOnExpression.
 *
 * @author zhongj
 * @param <E1> the query type
 * @param <E2> the join type
 * @param <E3> the generic type
 * @param <R>  the generic type
 */
public interface EntityOnExpression2<E1, E2, E3, R> extends EntityOnExpression<E1, E3, R> {

    /**
     * On.
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
        EntityPropertyOnlyExpression<E3>, LogicExpression<?, ?>> onExpression);
}
