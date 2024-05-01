
package cn.featherfly.hammer.sqldb.jdbc.dsl.repository.condition.field;

import cn.featherfly.common.db.builder.model.ColumnElement;
import cn.featherfly.common.lang.Lang;
import cn.featherfly.common.repository.Field;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.Expression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.condition.field.FieldExpression;
import cn.featherfly.hammer.sqldb.jdbc.dsl.condition.AbstractSqlConditionsExpression;

/**
 * The Class AbstractMulitiRepositoryFieldExpression.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public abstract class AbstractRepositoryFieldExpression<C extends ConditionExpression, L extends LogicExpression<C, L>>
        implements Expression {

    /** The name. */
    protected final String name;

    /** The expression. */
    protected final AbstractSqlConditionsExpression<C, L, ?> expression;

    /**
     * Instantiates a new abstract muliti repository field expression.
     *
     * @param name       the name
     * @param expression the expression
     */
    protected AbstractRepositoryFieldExpression(String name, AbstractSqlConditionsExpression<C, L, ?> expression) {
        this.name = name;
        this.expression = expression;
    }

    /**
     * Eq.
     *
     * @param field the field
     * @return the l
     */
    public L eq(Field field) {
        return expression.eq(name, field);
    }

    /**
     * Eq.
     *
     * @param expression the expression
     * @return the l
     */
    public L eq(FieldExpression expression) {
        return this.expression.eq(name, expression);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String expression() {
        String expr = expression.expression();
        if (Lang.isEmpty(expr) && name != null) {
            return new ColumnElement(expression.getDialect(), name, expression.getRepositoryAlias()).toSql();
        }
        return expr;
    }
}
