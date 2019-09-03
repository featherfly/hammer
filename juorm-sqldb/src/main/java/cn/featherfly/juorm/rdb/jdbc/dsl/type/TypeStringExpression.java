
package cn.featherfly.juorm.rdb.jdbc.dsl.type;

import cn.featherfly.juorm.dsl.query.QueryConditionGroupExpression;
import cn.featherfly.juorm.dsl.query.QueryConditionGroupLogicExpression;
import cn.featherfly.juorm.expression.condition.property.StringExpression;

/**
 * <p>
 * SimpleObjectExpression
 * </p>
 *
 * @author zhongj
 */
public class TypeStringExpression<E, Q extends TypeQueryConditionGroupExpression<E, Q>> {

    private StringExpression<QueryConditionGroupExpression, QueryConditionGroupLogicExpression> expression;

    private Q typeExpression;

    /**
     * @param expression
     * @param typeExpression
     */
    public TypeStringExpression(
            StringExpression<QueryConditionGroupExpression, QueryConditionGroupLogicExpression> expression,
            Q typeExpression) {
        super();
        this.expression = expression;
        this.typeExpression = typeExpression;
    }

    public Q eq(String value) {
        expression.eq(value);
        return typeExpression;
    }

    public Q ne(String value) {
        expression.ne(value);
        return typeExpression;
    }

    public Q in(String value) {
        expression.in(value);
        return typeExpression;
    }

    public Q nin(String value) {
        expression.nin(value);
        return typeExpression;
    }

    public Q le(String value) {
        expression.le(value);
        return typeExpression;
    }

    public Q lt(String value) {
        expression.lt(value);
        return typeExpression;
    }

    public Q ge(String value) {
        expression.ge(value);
        return typeExpression;
    }

    public Q gt(String value) {
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
