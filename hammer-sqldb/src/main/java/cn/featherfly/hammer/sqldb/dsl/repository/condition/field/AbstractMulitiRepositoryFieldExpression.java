
package cn.featherfly.hammer.sqldb.dsl.repository.condition.field;

import java.util.concurrent.atomic.AtomicInteger;

import cn.featherfly.common.db.builder.model.ArithmeticColumnElement;
import cn.featherfly.common.db.builder.model.ColumnElement;
import cn.featherfly.common.repository.Field;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.Expression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.condition.field.FieldExpression;
import cn.featherfly.hammer.sqldb.dsl.condition.InternalMulitiCondition;

/**
 * The Class AbstractMulitiRepositoryFieldExpression.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public abstract class AbstractMulitiRepositoryFieldExpression<C extends ConditionExpression,
    L extends LogicExpression<C, L>> implements Expression {

    /** The index. */
    protected AtomicInteger index;

    /** The name. */
    protected String name;

    /** The expression. */
    protected InternalMulitiCondition<L> expression;

    protected final ArithmeticColumnElement column;
    //    /** The repository relation. */
    //    protected RepositorySqlRelation<?, ?> repositoryRelation;

    /**
     * Instantiates a new abstract muliti repository field expression.
     *
     * @param index the index
     * @param name the name
     * @param expression the expression
     */
    protected AbstractMulitiRepositoryFieldExpression(int index, String name, InternalMulitiCondition<L> expression) {
        this(new AtomicInteger(index), name, expression);
    }

    /**
     * Instantiates a new abstract muliti repository field expression.
     *
     * @param index the index
     * @param name the name
     * @param expression the expression
     */
    protected AbstractMulitiRepositoryFieldExpression(AtomicInteger index, String name,
        InternalMulitiCondition<L> expression) {
        this.index = index;
        this.name = name;
        this.expression = expression;
        column = new ArithmeticColumnElement(expression.getJdbc().getDialect(), name, expression.getAlias(index.get()));
    }

    protected Object getField() {
        if (column.getCalculationOperator().length == 0) {
            return name;
        } else {
            return column;
        }
    }

    public String name() {
        return getField().toString();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String expression() {
        return new ColumnElement(expression.getJdbc().getDialect(), name, expression.getAlias(index.intValue()))
            .toSql();
        //        String expr = expression.expression();
        //        if (Lang.isEmpty(expr) && name != null) {
        //            return new ColumnElement(expression.getJdbc().getDialect(), name, expression.getAlias(index.intValue()))
        //                .toSql();
        //        }
        //        return expr;
    }

    /**
     * Eq.
     *
     * @param field the field
     * @return the l
     */
    public L eq(Field field) {
        return expression.eq(index, name, field, expression.getIgnoreStrategy());
    }

    /**
     * Eq.
     *
     * @param fieldExpression the field expression
     * @return the l
     */
    public L eq(FieldExpression fieldExpression) {
        return expression.eq(index, name, fieldExpression, expression.getIgnoreStrategy());
    }
}
