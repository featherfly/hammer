/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2023-11-17 18:27:17
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.dsl.repository;

import java.util.function.BiFunction;

import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.repository.condition.field.RepositoryFieldOnlyExpression;

/**
 * repository on expression1.
 *
 * @author zhongj
 * @param <O> on result type
 */
public interface RepositoryOnExpression1<O> extends RepositoryOnExpression<O> {
    /**
     * On.
     *
     * @param onExpression the on expression. <br/>
     *                     <ol>
     *                     <li>filterable repository field expresion
     *                     <li>current join repository field expression
     *                     <li>return logic expression
     *                     </ol>
     * @return the RepositoryQueryRelateExpression
     */
    O on(BiFunction<RepositoryFieldOnlyExpression, RepositoryFieldOnlyExpression, LogicExpression<?, ?>> onExpression);

}
