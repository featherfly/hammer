
package cn.featherfly.hammer.dsl.entity;

import cn.featherfly.common.function.SixArgusFunction;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.entity.condition.property.EntityPropertyOnlyExpression;

/**
 * The Interface EntityOnExpression5.
 *
 * @author zhongj
 * @param <E1> the query type
 * @param <E2> the join type
 * @param <E3> the generic type
 * @param <R>  the generic type
 */
public interface EntityOnExpression5<E1, E2, E3, E4, E5, E6, R> extends EntityOnExpression<E1, E6, R> {

    /**
     * On.
     *
     * @param onExpression the on expression. <br/>
     *                     <ol>
     *                     <li>query type property expresion
     *                     <li>query or joined type property expresion
     *                     <li>query or joined type property expresion
     *                     <li>query or joined type property expresion
     *                     <li>query or joined type property expresion
     *                     <li>current join type property expression
     *                     <li>return logic expression
     *                     </ol>
     * @return the RepositoryQueryRelateExpression
     */
    R on(SixArgusFunction<EntityPropertyOnlyExpression<E1>, EntityPropertyOnlyExpression<E2>,
        EntityPropertyOnlyExpression<E3>, EntityPropertyOnlyExpression<E4>, EntityPropertyOnlyExpression<E5>,
        EntityPropertyOnlyExpression<E6>, LogicExpression<?, ?>> onExpression);
}
