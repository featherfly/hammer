
package cn.featherfly.hammer.sqldb.jdbc.dsl.type;

import java.util.Date;

import cn.featherfly.hammer.dsl.query.QueryConditionGroupExpression;
import cn.featherfly.hammer.dsl.query.QueryConditionGroupLogicExpression;
import cn.featherfly.hammer.expression.condition.property.DateExpression;

/**
 * <p>
 * TypeDateExpression
 * </p>
 * .
 *
 * @author zhongj
 * @param <E> the element type
 * @param <Q> the generic type
 */
public class StaticTypeDateExpression<E, Q extends StaticTypeQueryConditionGroupExpression<E, Q>> {

    /** The expression. */
    private DateExpression<QueryConditionGroupExpression, QueryConditionGroupLogicExpression> expression;

    /** The type expression. */
    private Q typeExpression;

    /**
     * Instantiates a new type date expression.
     *
     * @param expression     the expression
     * @param typeExpression the type expression
     */
    public StaticTypeDateExpression(
            DateExpression<QueryConditionGroupExpression, QueryConditionGroupLogicExpression> expression,
            Q typeExpression) {
        super();
        this.expression = expression;
        this.typeExpression = typeExpression;
    }

    /**
     * Eq.
     *
     * @param value the value
     * @return the q
     */
    public Q eq(Date value) {
        expression.eq(value);
        return typeExpression;
    }

    /**
     * Ne.
     *
     * @param value the value
     * @return the q
     */
    public Q ne(Date value) {
        expression.ne(value);
        return typeExpression;
    }

    /**
     * In.
     *
     * @param value the value
     * @return the q
     */
    public Q in(Date value) {
        expression.in(value);
        return typeExpression;
    }

    /**
     * Nin.
     *
     * @param value the value
     * @return the q
     */
    public Q nin(Date value) {
        expression.nin(value);
        return typeExpression;
    }

    /**
     * Le.
     *
     * @param value the value
     * @return the q
     */
    public Q le(Date value) {
        expression.le(value);
        return typeExpression;
    }

    /**
     * Lt.
     *
     * @param value the value
     * @return the q
     */
    public Q lt(Date value) {
        expression.lt(value);
        return typeExpression;
    }

    /**
     * Ge.
     *
     * @param value the value
     * @return the q
     */
    public Q ge(Date value) {
        expression.ge(value);
        return typeExpression;
    }

    /**
     * Gt.
     *
     * @param value the value
     * @return the q
     */
    public Q gt(Date value) {
        expression.gt(value);
        return typeExpression;
    }

    /**
     * Isn.
     *
     * @return the q
     */
    public Q isn() {
        expression.isn();
        return typeExpression;
    }

    /**
     * Inn.
     *
     * @return the q
     */
    public Q inn() {
        expression.inn();
        return typeExpression;
    }
}
