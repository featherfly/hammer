
package cn.featherfly.hammer.dsl.entity;

import java.util.function.BiFunction;

import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.entity.condition.property.EntityPropertyOnlyExpression;

/**
 * The Interface EntityOnExpression.
 *
 * @author zhongj
 * @param <E1> the query entity type
 * @param <E2> the join entity type
 * @param <R>  the generic type
 */
public interface EntityOnExpression1<E1, E2, R> extends EntityOnExpression<E1, E2, R> {

    /**
     * On.
     *
     * @param onExpression the on expression. <br/>
     *                     <ol>
     *                     <li>query type property expresion
     *                     <li>current join type property expression
     *                     <li>return logic expression
     *                     </ol>
     * @return the RepositoryQueryRelateExpression
     */
    R on(BiFunction<EntityPropertyOnlyExpression<E1>, EntityPropertyOnlyExpression<E2>,
        LogicExpression<?, ?>> onExpression);
}
