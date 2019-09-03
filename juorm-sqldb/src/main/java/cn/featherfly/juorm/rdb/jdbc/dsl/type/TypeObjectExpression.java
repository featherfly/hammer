
package cn.featherfly.juorm.rdb.jdbc.dsl.type;

import cn.featherfly.juorm.dsl.query.QueryConditionGroupExpression;
import cn.featherfly.juorm.dsl.query.QueryConditionGroupLogicExpression;
import cn.featherfly.juorm.expression.condition.property.ObjectExpression;

/**
 * <p>
 * TypeObjectExpression
 * </p>
 * .
 *
 * @author zhongj
 * @param <E> the element type
 * @param <Q> the generic type
 */
public class TypeObjectExpression<E, Q extends TypeQueryConditionGroupExpression<E, Q>> {

    /** The expression. */
    private ObjectExpression<QueryConditionGroupExpression, QueryConditionGroupLogicExpression> expression;

    /** The type expression. */
    private Q typeExpression;

    /**
     * Instantiates a new type object expression.
     *
     * @param expression     the expression
     * @param typeExpression the type expression
     */
    public TypeObjectExpression(
            ObjectExpression<QueryConditionGroupExpression, QueryConditionGroupLogicExpression> expression,
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
    public Q eq(Object value) {
        expression.eq(value);
        return typeExpression;
    }

    /**
     * Ne.
     *
     * @param value the value
     * @return the q
     */
    public Q ne(Object value) {
        expression.ne(value);
        return typeExpression;
    }

    /**
     * In.
     *
     * @param value the value
     * @return the q
     */
    public Q in(Object value) {
        expression.in(value);
        return typeExpression;
    }

    /**
     * Nin.
     *
     * @param value the value
     * @return the q
     */
    public Q nin(Object value) {
        expression.nin(value);
        return typeExpression;
    }

    /**
     * Le.
     *
     * @param value the value
     * @return the q
     */
    public Q le(Object value) {
        expression.le(value);
        return typeExpression;
    }

    /**
     * Lt.
     *
     * @param value the value
     * @return the q
     */
    public Q lt(Object value) {
        expression.lt(value);
        return typeExpression;
    }

    /**
     * Ge.
     *
     * @param value the value
     * @return the q
     */
    public Q ge(Object value) {
        expression.ge(value);
        return typeExpression;
    }

    /**
     * Gt.
     *
     * @param value the value
     * @return the q
     */
    public Q gt(Object value) {
        expression.gt(value);
        return typeExpression;
    }

    /**
     * Sw.
     *
     * @param value the value
     * @return the q
     */
    public Q sw(String value) {
        expression.sw(value);
        return typeExpression;
    }

    /**
     * Co.
     *
     * @param value the value
     * @return the q
     */
    public Q co(String value) {
        expression.co(value);
        return typeExpression;
    }

    /**
     * Ew.
     *
     * @param value the value
     * @return the q
     */
    public Q ew(String value) {
        expression.ew(value);
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
