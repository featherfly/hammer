
package cn.featherfly.hammer.dsl.entity;

import java.util.function.BiFunction;

import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.entity.condition.property.EntityPropertyOnlyExpression;

/**
 * entity first time join on expression.
 *
 * @author zhongj
 * @param <E1> query type
 * @param <J>  join type
 * @param <R>  after on expression type
 */
public interface EntityOnExpression1<E1, J, R> extends EntityOnExpression<E1, J, R> {

    /**
     * on expression.
     *
     * @param onExpression the on expression. <br/>
     *                     <ol>
     *                     <li>query type property expresion
     *                     <li>current join type property expression
     *                     <li>return logic expression
     *                     </ol>
     * @return the RepositoryQueryRelateExpression
     */
    R on(BiFunction<EntityPropertyOnlyExpression<E1>, EntityPropertyOnlyExpression<J>,
        LogicExpression<?, ?>> onExpression);
}
