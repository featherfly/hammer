
package cn.featherfly.juorm.expression.condition.property;

import java.util.Date;

import cn.featherfly.juorm.expression.condition.ConditionsExpression;
import cn.featherfly.juorm.expression.condition.LogicExpression;

/**
 * <p>
 * SimpleObjectExpression
 * </p>
 *
 * @author zhongj
 */
public class SimpleDateExpression<C extends ConditionsExpression<C, L>, L extends LogicExpression<C, L>>
        implements DateExpression<C, L> {

    private String name;

    private ConditionsExpression<C, L> expression;

    /**
     * @param name
     * @param expression
     */
    public SimpleDateExpression(String name, ConditionsExpression<C, L> expression) {
        super();
        this.name = name;
        this.expression = expression;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(Date value) {
        return expression.eq(name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String expression() {
        return expression.expression();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(Date value) {
        return expression.ne(name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(Date value) {
        return expression.in(name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nin(Date value) {
        return expression.nin(name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(Date value) {
        return expression.le(name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(Date value) {
        return expression.lt(name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(Date value) {
        return expression.ge(name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(Date value) {
        return expression.gt(name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L isn() {
        return expression.isn(name);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L inn() {
        return expression.inn(name);
    }
}
