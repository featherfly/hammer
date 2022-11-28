
package cn.featherfly.hammer.sqldb.jdbc.dsl.type;

import cn.featherfly.hammer.dsl.query.QueryConditionGroupExpression;
import cn.featherfly.hammer.dsl.query.QueryConditionGroupLogicExpression;
import cn.featherfly.hammer.expression.condition.property.EnumExpression;

/**
 * <p>
 * TypeEnumExpression
 * </p>
 * .
 *
 * @author zhongj
 * @param <T> the element type
 * @param <Q> the generic type
 */
public class StaticTypeEnumExpression<T, E extends Enum<E>, Q extends StaticTypeQueryConditionGroupExpression<T, Q>> {

    /** The expression. */
    private EnumExpression<E, QueryConditionGroupExpression, QueryConditionGroupLogicExpression> expression;

    /** The type expression. */
    private Q typeExpression;

    /**
     * Instantiates a new type enum expression.
     *
     * @param expression     the expression
     * @param typeExpression the type expression
     */
    public StaticTypeEnumExpression(
            EnumExpression<E, QueryConditionGroupExpression, QueryConditionGroupLogicExpression> expression,
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
    public Q eq(E value) {
        expression.eq(value);
        return typeExpression;
    }

    /**
     * Ne.
     *
     * @param value the value
     * @return the q
     */
    public Q ne(E value) {
        expression.ne(value);
        return typeExpression;
    }

    /**
     * In.
     *
     * @param value the value
     * @return the q
     */
    public Q in(E value) {
        expression.in(value);
        return typeExpression;
    }

    /**
     * Nin.
     *
     * @param value the value
     * @return the q
     */
    public Q nin(E value) {
        expression.nin(value);
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
