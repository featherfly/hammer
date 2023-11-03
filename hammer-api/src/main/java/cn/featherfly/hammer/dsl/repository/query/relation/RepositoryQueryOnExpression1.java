/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2023-11-17 18:27:17
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.dsl.repository.query.relation;

import java.util.function.BiFunction;

import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.repository.condition.field.RepositoryFieldOnlyExpression;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryRelateExpression;

/**
 * repository query related expression1.
 *
 * @author zhongj
 * @param <Q> the generic type
 * @param <F> the generic type
 */
public interface RepositoryQueryOnExpression1<Q extends RepositoryQueryRelateExpression<F>, F>
        extends RepositoryQueryOnExpression<Q, F> {

    /**
     * On.
     *
     * @param onExpression the on expression. <br/>
     *                     <ol>
     *                     <li>query repository field expresion
     *                     <li>current join repository field expression
     *                     <li>return logic expression
     *                     </ol>
     * @return the RepositoryQueryRelateExpression
     */
    Q on(BiFunction<RepositoryFieldOnlyExpression, RepositoryFieldOnlyExpression, LogicExpression<?, ?>> onExpression);

}
