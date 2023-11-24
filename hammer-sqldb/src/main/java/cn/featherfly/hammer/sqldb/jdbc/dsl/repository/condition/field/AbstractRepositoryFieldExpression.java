
package cn.featherfly.hammer.sqldb.jdbc.dsl.repository.condition.field;

import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.sqldb.jdbc.dsl.condition.AbstractSqlConditionsExpression;

/**
 * The Class AbstractMulitiRepositoryFieldExpression.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public abstract class AbstractRepositoryFieldExpression<C extends ConditionExpression,
        L extends LogicExpression<C, L>> {

    /** The name. */
    protected String name;

    /** The expression. */
    protected AbstractSqlConditionsExpression<C, L, ?> expression;

    /**
     * Instantiates a new abstract muliti repository field expression.
     *
     * @param index      the index
     * @param name       the name
     * @param expression the expression
     */
    protected AbstractRepositoryFieldExpression(String name, AbstractSqlConditionsExpression<C, L, ?> expression) {
        this.name = name;
        this.expression = expression;
    }
}
