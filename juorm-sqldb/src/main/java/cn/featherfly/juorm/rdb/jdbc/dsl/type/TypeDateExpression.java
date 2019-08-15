
package cn.featherfly.juorm.rdb.jdbc.dsl.type;

import java.util.Date;

import cn.featherfly.juorm.dsl.query.QueryConditionGroupExpression;
import cn.featherfly.juorm.dsl.query.QueryConditionGroupLogicExpression;
import cn.featherfly.juorm.expression.condition.property.DateExpression;

/**
 * <p>
 * SimpleObjectExpression
 * </p>
 *
 * @author zhongj
 */
public class TypeDateExpression<E, Q extends TypeQueryConditionGroupExpression<E, Q>> {

    private DateExpression<QueryConditionGroupExpression, QueryConditionGroupLogicExpression> expression;

    private Q typeExpression;

    /**
     * @param expression
     * @param typeExpression
     */
    public TypeDateExpression(
            DateExpression<QueryConditionGroupExpression, QueryConditionGroupLogicExpression> expression,
            Q typeExpression) {
        super();
        this.expression = expression;
        this.typeExpression = typeExpression;
    }

    /**
     * {@inheritDoc}
     */

    public Q eq(Date value) {
        expression.eq(value);
        return typeExpression;
    }

    /**
     * {@inheritDoc}
     */

    public Q ne(Date value) {
        expression.ne(value);
        return typeExpression;
    }

    /**
     * {@inheritDoc}
     */

    public Q in(Date value) {
        expression.in(value);
        return typeExpression;
    }

    /**
     * {@inheritDoc}
     */

    public Q nin(Date value) {
        expression.nin(value);
        return typeExpression;
    }

    /**
     * {@inheritDoc}
     */

    public Q le(Date value) {
        expression.le(value);
        return typeExpression;
    }

    /**
     * {@inheritDoc}
     */

    public Q lt(Date value) {
        expression.lt(value);
        return typeExpression;
    }

    /**
     * {@inheritDoc}
     */

    public Q ge(Date value) {
        expression.ge(value);
        return typeExpression;
    }

    /**
     * {@inheritDoc}
     */

    public Q gt(Date value) {
        expression.gt(value);
        return typeExpression;
    }

    /**
     * {@inheritDoc}
     */

    public Q isn() {
        expression.isn();
        return typeExpression;
    }

    /**
     * {@inheritDoc}
     */

    public Q inn() {
        expression.inn();
        return typeExpression;
    }
}
