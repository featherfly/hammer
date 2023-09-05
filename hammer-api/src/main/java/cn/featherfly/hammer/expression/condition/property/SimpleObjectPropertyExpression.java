
package cn.featherfly.hammer.expression.condition.property;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.function.Predicate;

import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.hammer.HammerException;
import cn.featherfly.hammer.expression.condition.ConditionsExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * simple object property expression.
 *
 * @author zhongj
 */
public class SimpleObjectPropertyExpression<C extends ConditionsExpression<C, L>, L extends LogicExpression<C, L>>
        implements ObjectPropertyExpression<C, L> {

    private String name;

    private ConditionsExpression<C, L> expression;

    /**
     * @param name       name
     * @param expression expression
     */
    public SimpleObjectPropertyExpression(String name, ConditionsExpression<C, L> expression) {
        super();
        this.name = name;
        this.expression = expression;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(Object value, MatchStrategy matchStrategy) {
        return expression.eq(name, value, matchStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(Object value, MatchStrategy matchStrategy, Predicate<Object> ignoreStrategy) {
        return expression.eq(name, value, matchStrategy, ignoreStrategy);
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
    public L in(Object value) {
        return expression.in(name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(Object[] value) {
        return expression.in(name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(Object value, Predicate<Object> ignoreStrategy) {
        return expression.in(name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(Object[] value, Predicate<Object[]> ignoreStrategy) {
        return expression.in(name, value, (v) -> ignoreStrategy.test((Object[]) v));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(Object value, MatchStrategy matchStrategy) {
        return expression.ne(name, value, matchStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(Object value, MatchStrategy matchStrategy, Predicate<Object> ignoreStrategy) {
        return expression.ne(name, value, matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nin(Object value) {
        return expression.nin(name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nin(Object[] value) {
        return expression.nin(name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nin(Object value, Predicate<Object> ignoreStrategy) {
        return expression.nin(name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nin(Object[] value, Predicate<Object[]> ignoreStrategy) {
        return expression.nin(name, value, (v) -> ignoreStrategy.test((Object[]) v));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(Object value) {
        if (value == null) {
            Integer v = null;
            return expression.le(name, v);
        }
        if (value instanceof Number) {
            return expression.le(name, (Number) value);
        } else if (value instanceof Date) {
            return expression.le(name, (Date) value);
        } else if (value instanceof String) {
            return expression.le(name, (String) value);
        } else if (value instanceof LocalDate) {
            return expression.le(name, (LocalDate) value);
        } else if (value instanceof LocalTime) {
            return expression.le(name, (LocalTime) value);
        } else if (value instanceof LocalDateTime) {
            return expression.le(name, (LocalDateTime) value);
        }
        throw new HammerException("le(value) method not support to type " + value.getClass().getName());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(Object value) {
        if (value == null) {
            Integer v = null;
            return expression.lt(name, v);
        }
        if (value instanceof Number) {
            return expression.lt(name, (Number) value);
        } else if (value instanceof Date) {
            return expression.lt(name, (Date) value);
        } else if (value instanceof String) {
            return expression.lt(name, (String) value);
        } else if (value instanceof LocalDate) {
            return expression.lt(name, (LocalDate) value);
        } else if (value instanceof LocalTime) {
            return expression.lt(name, (LocalTime) value);
        } else if (value instanceof LocalDateTime) {
            return expression.lt(name, (LocalDateTime) value);
        }
        throw new HammerException("lt(value) method not support to type " + value.getClass().getName());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(Object value) {
        if (value == null) {
            Integer v = null;
            return expression.ge(name, v);
        }
        if (value instanceof Number) {
            return expression.ge(name, (Number) value);
        } else if (value instanceof Date) {
            return expression.ge(name, (Date) value);
        } else if (value instanceof String) {
            return expression.ge(name, (String) value);
        } else if (value instanceof LocalDate) {
            return expression.ge(name, (LocalDate) value);
        } else if (value instanceof LocalTime) {
            return expression.ge(name, (LocalTime) value);
        } else if (value instanceof LocalDateTime) {
            return expression.ge(name, (LocalDateTime) value);
        }
        throw new HammerException("ge(value) method not support to type " + value.getClass().getName());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(Object value) {
        if (value == null) {
            Integer v = null;
            return expression.gt(name, v);
        }
        if (value instanceof Number) {
            return expression.gt(name, (Number) value);
        } else if (value instanceof Date) {
            return expression.gt(name, (Date) value);
        } else if (value instanceof String) {
            return expression.gt(name, (String) value);
        } else if (value instanceof LocalDate) {
            return expression.gt(name, (LocalDate) value);
        } else if (value instanceof LocalTime) {
            return expression.gt(name, (LocalTime) value);
        } else if (value instanceof LocalDateTime) {
            return expression.gt(name, (LocalDateTime) value);
        }
        throw new HammerException("gt(value) method not support to type " + value.getClass().getName());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L co(String value, MatchStrategy matchStrategy) {
        return expression.co(name, value, matchStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L co(String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return expression.co(name, value, matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ew(String value) {
        return expression.ew(name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ew(String value, MatchStrategy matchStrategy) {
        return expression.ew(name, value, matchStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ew(String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return expression.ew(name, value, matchStrategy, ignoreStrategy);
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

    /**
     * {@inheritDoc}
     */
    @Override
    public L isn(Boolean value) {
        return expression.isn(name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L inn(Boolean value) {
        return expression.inn(name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L sw(String value, MatchStrategy matchStrategy) {
        return expression.sw(name, value, matchStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L sw(String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return expression.sw(name, value, matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lk(String value, MatchStrategy matchStrategy) {
        return expression.lk(name, value, matchStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lk(String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return expression.lk(name, value, matchStrategy, ignoreStrategy);
    }
}
