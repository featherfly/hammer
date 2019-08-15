
package cn.featherfly.juorm.rdb.jdbc.dsl.type;

import cn.featherfly.juorm.dsl.query.QueryConditionGroupExpression;
import cn.featherfly.juorm.dsl.query.QueryConditionGroupLogicExpression;
import cn.featherfly.juorm.expression.condition.property.ObjectExpression;

/**
 * <p>
 * TypeObjectExpression
 * </p>
 *
 * @author zhongj
 */
public class TypeObjectExpression<E, Q extends TypeQueryConditionGroupExpression<E, Q>> {

    private ObjectExpression<QueryConditionGroupExpression, QueryConditionGroupLogicExpression> expression;

    private Q typeExpression;

    /**
     * @param expression
     * @param typeExpression
     */
    public TypeObjectExpression(
            ObjectExpression<QueryConditionGroupExpression, QueryConditionGroupLogicExpression> expression,
            Q typeExpression) {
        super();
        this.expression = expression;
        this.typeExpression = typeExpression;
    }

    public Q eq(Object value) {
        expression.eq(value);
        return typeExpression;
    }

    public Q ne(Object value) {
        expression.ne(value);
        return typeExpression;
    }

    public Q in(Object value) {
        expression.in(value);
        return typeExpression;
    }

    public Q nin(Object value) {
        expression.nin(value);
        return typeExpression;
    }

    public Q le(Object value) {
        expression.le(value);
        return typeExpression;
    }

    public Q lt(Object value) {
        expression.lt(value);
        return typeExpression;
    }

    public Q ge(Object value) {
        expression.ge(value);
        return typeExpression;
    }

    public Q gt(Object value) {
        expression.gt(value);
        return typeExpression;
    }

    public Q sw(String value) {
        expression.sw(value);
        return typeExpression;
    }

    public Q co(String value) {
        expression.co(value);
        return typeExpression;
    }

    public Q ew(String value) {
        expression.ew(value);
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
