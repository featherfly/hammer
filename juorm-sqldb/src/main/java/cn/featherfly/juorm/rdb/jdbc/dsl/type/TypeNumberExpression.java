
package cn.featherfly.juorm.rdb.jdbc.dsl.type;

import cn.featherfly.juorm.dsl.query.QueryConditionGroupExpression;
import cn.featherfly.juorm.dsl.query.QueryConditionGroupLogicExpression;
import cn.featherfly.juorm.expression.condition.property.NumberExpression;

/**
 * <p>
 * SimpleObjectExpression
 * </p>
 *
 * @author zhongj
 */
public class TypeNumberExpression<E, Q extends TypeQueryConditionGroupExpression<E, Q>> {

    private NumberExpression<QueryConditionGroupExpression, QueryConditionGroupLogicExpression> expression;

    private Q typeExpression;

    /**
     * @param expression
     * @param typeExpression
     */
    public TypeNumberExpression(
            NumberExpression<QueryConditionGroupExpression, QueryConditionGroupLogicExpression> expression,
            Q typeExpression) {
        super();
        this.expression = expression;
        this.typeExpression = typeExpression;
    }

    public Q eq(Number value) {
        expression.eq(value);
        return typeExpression;
    }

    public Q ne(Number value) {
        expression.ne(value);
        return typeExpression;
    }

    public Q in(Number value) {
        expression.in(value);
        return typeExpression;
    }

    public Q nin(Number value) {
        expression.nin(value);
        return typeExpression;
    }

    public Q le(Number value) {
        expression.le(value);
        return typeExpression;
    }

    public Q lt(Number value) {
        expression.lt(value);
        return typeExpression;
    }

    public Q ge(Number value) {
        expression.ge(value);
        return typeExpression;
    }

    public Q gt(Number value) {
        expression.gt(value);
        return typeExpression;
    }

    public Q isn() {
        expression.isn();
        return typeExpression;
    }

    public Q inn() {
        expression.inn();
        return typeExpression;
    }
}
