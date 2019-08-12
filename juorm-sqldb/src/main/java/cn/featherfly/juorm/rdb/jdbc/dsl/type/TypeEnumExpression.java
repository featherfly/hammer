
package cn.featherfly.juorm.rdb.jdbc.dsl.type;

import cn.featherfly.juorm.dsl.query.QueryConditionGroupExpression;
import cn.featherfly.juorm.dsl.query.QueryConditionGroupLogicExpression;
import cn.featherfly.juorm.expression.condition.property.EnumExpression;

/**
 * <p>
 * SimpleObjectExpression
 * </p>
 *
 * @author zhongj
 */
public class TypeEnumExpression<E,
        Q extends TypeQueryConditionGroupExpression<E, Q>> {

    private EnumExpression<QueryConditionGroupExpression, QueryConditionGroupLogicExpression> expression;

    private Q typeExpression;

    /**
     * @param name
     * @param expression
     */
    public TypeEnumExpression(
            EnumExpression<QueryConditionGroupExpression, QueryConditionGroupLogicExpression> expression,
            Q typeExpression) {
        super();
        this.expression = expression;
        this.typeExpression = typeExpression;
    }

    /**
     * {@inheritDoc}
     */

    public Q eq(Enum<?> value) {
        expression.eq(value);
        return typeExpression;
    }

    /**
     * {@inheritDoc}
     */

    public Q ne(Enum<?> value) {
        expression.ne(value);
        return typeExpression;
    }

    /**
     * {@inheritDoc}
     */

    public Q in(Enum<?> value) {
        expression.in(value);
        return typeExpression;
    }

    /**
     * {@inheritDoc}
     */

    public Q nin(Enum<?> value) {
        expression.nin(value);
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
