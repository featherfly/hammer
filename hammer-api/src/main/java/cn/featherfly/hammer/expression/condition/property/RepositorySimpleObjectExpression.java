
package cn.featherfly.hammer.expression.condition.property;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.function.Predicate;

import cn.featherfly.common.lang.Lang;
import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.common.repository.IgnoreStrategy;
import cn.featherfly.hammer.HammerException;
import cn.featherfly.hammer.expression.condition.ContainsExpression;
import cn.featherfly.hammer.expression.condition.EndWithExpression;
import cn.featherfly.hammer.expression.condition.EqualsExpression;
import cn.featherfly.hammer.expression.condition.LikeExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.condition.NotEqualsExpression;
import cn.featherfly.hammer.expression.condition.RepositoryConditionsExpression;
import cn.featherfly.hammer.expression.condition.StartWithExpression;

/**
 * The Class RepositorySimpleObjectExpression.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public class RepositorySimpleObjectExpression<C extends RepositoryConditionsExpression<C, L>,
        L extends LogicExpression<C, L>> implements ObjectPropertyExpression<C, L> {

    private String repository;

    private String name;

    private RepositoryConditionsExpression<C, L> expression;

    private int repositoryIndex = -1;

    /**
     * @param repositoryIndex repositoryIndex
     * @param name            name
     * @param expression      expression
     */
    public RepositorySimpleObjectExpression(int repositoryIndex, String name,
            RepositoryConditionsExpression<C, L> expression) {
        super();
        this.repositoryIndex = repositoryIndex;
        this.name = name;
        this.expression = expression;
    }

    /**
     * @param repository repository
     * @param name       name
     * @param expression expression
     */
    public RepositorySimpleObjectExpression(String repository, String name,
            RepositoryConditionsExpression<C, L> expression) {
        super();
        this.repository = repository;
        this.name = name;
        this.expression = expression;
    }

    /**
     * @param name       name
     * @param expression expression
     */
    public RepositorySimpleObjectExpression(String name, RepositoryConditionsExpression<C, L> expression) {
        this(null, name, expression);
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
        if (Lang.isNotEmpty(repository)) {
            return expression.in(repository, name, value);
        } else if (repositoryIndex > -1) {
            return expression.in(repositoryIndex, name, value);
        } else {
            return expression.in(name, value);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nin(Object value) {
        if (Lang.isNotEmpty(repository)) {
            return expression.nin(repository, name, value);
        } else if (repositoryIndex > -1) {
            return expression.nin(repositoryIndex, name, value);
        } else {
            return expression.nin(name, value);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(Object value) {
        if (Lang.isNotEmpty(repository)) {
            if (value == null) {
                Integer v = null;
                return expression.le(repository, name, v);
            }
            if (value instanceof Number) {
                return expression.le(repository, name, (Number) value);
            } else if (value instanceof Date) {
                return expression.le(repository, name, (Date) value);
            } else if (value instanceof String) {
                return expression.le(repository, name, (String) value);
            } else if (value instanceof LocalDate) {
                return expression.le(repository, name, (LocalDate) value);
            } else if (value instanceof LocalTime) {
                return expression.le(repository, name, (LocalTime) value);
            } else if (value instanceof LocalDateTime) {
                return expression.le(repository, name, (LocalDateTime) value);
            }
        } else if (repositoryIndex > -1) {
            if (value == null) {
                Integer v = null;
                return expression.le(repositoryIndex, name, v);
            }
            if (value instanceof Number) {
                return expression.le(repositoryIndex, name, (Number) value);
            } else if (value instanceof Date) {
                return expression.le(repositoryIndex, name, (Date) value);
            } else if (value instanceof String) {
                return expression.le(repositoryIndex, name, (String) value);
            } else if (value instanceof LocalDate) {
                return expression.le(repositoryIndex, name, (LocalDate) value);
            } else if (value instanceof LocalTime) {
                return expression.le(repositoryIndex, name, (LocalTime) value);
            } else if (value instanceof LocalDateTime) {
                return expression.le(repositoryIndex, name, (LocalDateTime) value);
            }
        } else {
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
        }
        throw new HammerException("le(value) method not support to type " + value.getClass().getName());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(Object value) {
        if (Lang.isNotEmpty(repository)) {
            if (value == null) {
                Integer v = null;
                return expression.lt(repository, name, v);
            }
            if (value instanceof Number) {
                return expression.lt(repository, name, (Number) value);
            } else if (value instanceof Date) {
                return expression.lt(repository, name, (Date) value);
            } else if (value instanceof String) {
                return expression.lt(repository, name, (String) value);
            } else if (value instanceof LocalDate) {
                return expression.lt(repository, name, (LocalDate) value);
            } else if (value instanceof LocalTime) {
                return expression.lt(repository, name, (LocalTime) value);
            } else if (value instanceof LocalDateTime) {
                return expression.lt(repository, name, (LocalDateTime) value);
            }
        } else if (repositoryIndex > -1) {
            if (value == null) {
                Integer v = null;
                return expression.lt(repositoryIndex, name, v);
            }
            if (value instanceof Number) {
                return expression.lt(repositoryIndex, name, (Number) value);
            } else if (value instanceof Date) {
                return expression.lt(repositoryIndex, name, (Date) value);
            } else if (value instanceof String) {
                return expression.lt(repositoryIndex, name, (String) value);
            } else if (value instanceof LocalDate) {
                return expression.lt(repositoryIndex, name, (LocalDate) value);
            } else if (value instanceof LocalTime) {
                return expression.lt(repositoryIndex, name, (LocalTime) value);
            } else if (value instanceof LocalDateTime) {
                return expression.lt(repositoryIndex, name, (LocalDateTime) value);
            }
        } else {
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
        }
        throw new HammerException("lt(value) method not support to type " + value.getClass().getName());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(Object value) {
        if (Lang.isNotEmpty(repository)) {
            if (value == null) {
                Integer v = null;
                return expression.ge(repository, name, v);
            }
            if (value instanceof Number) {
                return expression.ge(repository, name, (Number) value);
            } else if (value instanceof Date) {
                return expression.ge(repository, name, (Date) value);
            } else if (value instanceof String) {
                return expression.ge(repository, name, (String) value);
            } else if (value instanceof LocalDate) {
                return expression.ge(repository, name, (LocalDate) value);
            } else if (value instanceof LocalTime) {
                return expression.ge(repository, name, (LocalTime) value);
            } else if (value instanceof LocalDateTime) {
                return expression.ge(repository, name, (LocalDateTime) value);
            }
        } else if (repositoryIndex > -1) {
            if (value == null) {
                Integer v = null;
                return expression.ge(repositoryIndex, name, v);
            }
            if (value instanceof Number) {
                return expression.ge(repositoryIndex, name, (Number) value);
            } else if (value instanceof Date) {
                return expression.ge(repositoryIndex, name, (Date) value);
            } else if (value instanceof String) {
                return expression.ge(repositoryIndex, name, (String) value);
            } else if (value instanceof LocalDate) {
                return expression.ge(repositoryIndex, name, (LocalDate) value);
            } else if (value instanceof LocalTime) {
                return expression.ge(repositoryIndex, name, (LocalTime) value);
            } else if (value instanceof LocalDateTime) {
                return expression.ge(repositoryIndex, name, (LocalDateTime) value);
            }
        } else {
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
        }
        throw new HammerException("ge(value) method not support to type " + value.getClass().getName());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(Object value) {
        if (Lang.isNotEmpty(repository)) {
            if (value == null) {
                Integer v = null;
                return expression.gt(repository, name, v);
            }
            if (value instanceof Number) {
                return expression.gt(repository, name, (Number) value);
            } else if (value instanceof Date) {
                return expression.gt(repository, name, (Date) value);
            } else if (value instanceof String) {
                return expression.gt(repository, name, (String) value);
            } else if (value instanceof LocalDate) {
                return expression.gt(repository, name, (LocalDate) value);
            } else if (value instanceof LocalTime) {
                return expression.gt(repository, name, (LocalTime) value);
            } else if (value instanceof LocalDateTime) {
                return expression.gt(repository, name, (LocalDateTime) value);
            }
        } else if (repositoryIndex > -1) {
            if (value == null) {
                Integer v = null;
                return expression.gt(repositoryIndex, name, v);
            }
            if (value instanceof Number) {
                return expression.gt(repositoryIndex, name, (Number) value);
            } else if (value instanceof Date) {
                return expression.gt(repositoryIndex, name, (Date) value);
            } else if (value instanceof String) {
                return expression.gt(repositoryIndex, name, (String) value);
            } else if (value instanceof LocalDate) {
                return expression.gt(repositoryIndex, name, (LocalDate) value);
            } else if (value instanceof LocalTime) {
                return expression.gt(repositoryIndex, name, (LocalTime) value);
            } else if (value instanceof LocalDateTime) {
                return expression.gt(repositoryIndex, name, (LocalDateTime) value);
            }
        } else {
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
        }
        throw new HammerException("gt(value) method not support to type " + value.getClass().getName());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L isn() {
        if (Lang.isNotEmpty(repository)) {
            return expression.isn(repository, name);
        } else if (repositoryIndex > -1) {
            return expression.isn(repositoryIndex, name);
        } else {
            return expression.isn(name);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L inn() {
        if (Lang.isNotEmpty(repository)) {
            return expression.inn(repository, name);
        } else if (repositoryIndex > -1) {
            return expression.inn(repositoryIndex, name);
        } else {
            return expression.inn(name);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L isn(Boolean value) {
        if (Lang.isNotEmpty(repository)) {
            return expression.isn(repository, name, value);
        } else if (repositoryIndex > -1) {
            return expression.isn(repositoryIndex, name, value);
        } else {
            return expression.isn(name, value);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L inn(Boolean value) {
        if (Lang.isNotEmpty(repository)) {
            return expression.inn(repository, name, value);
        } else if (repositoryIndex > -1) {
            return expression.inn(repositoryIndex, name, value);
        } else {
            return expression.inn(name, value);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(Object value, MatchStrategy matchStrategy) {
        if (Lang.isNotEmpty(repository)) {
            return expression.eq(repository, name, value, matchStrategy);
        } else if (repositoryIndex > -1) {
            return expression.eq(repositoryIndex, name, value, matchStrategy);
        } else {
            return ((EqualsExpression<C, L>) expression).eq(name, value, matchStrategy);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(Object value, MatchStrategy matchStrategy) {
        if (Lang.isNotEmpty(repository)) {
            return expression.ne(repository, name, value, matchStrategy);
        } else if (repositoryIndex > -1) {
            return expression.ne(repositoryIndex, name, value, matchStrategy);
        } else {
            return ((NotEqualsExpression<C, L>) expression).ne(name, value, matchStrategy);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L sw(String value, MatchStrategy matchStrategy) {
        if (Lang.isNotEmpty(repository)) {
            return expression.sw(repository, name, value, matchStrategy);
        } else if (repositoryIndex > -1) {
            return expression.sw(repositoryIndex, name, value, matchStrategy);
        } else {
            return ((StartWithExpression<C, L>) expression).sw(name, value, matchStrategy);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L co(String value, MatchStrategy matchStrategy) {
        if (Lang.isNotEmpty(repository)) {
            return expression.co(repository, name, value, matchStrategy);
        } else if (repositoryIndex > -1) {
            return expression.co(repositoryIndex, name, value, matchStrategy);
        } else {
            return ((ContainsExpression<C, L>) expression).co(name, value, matchStrategy);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ew(String value, MatchStrategy matchStrategy) {
        if (Lang.isNotEmpty(repository)) {
            return expression.ew(repository, name, value, matchStrategy);
        } else if (repositoryIndex > -1) {
            return expression.ew(repositoryIndex, name, value, matchStrategy);
        } else {
            return ((EndWithExpression<C, L>) expression).ew(name, value, matchStrategy);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lk(String value, MatchStrategy matchStrategy) {
        if (Lang.isNotEmpty(repository)) {
            return expression.lk(repository, name, value, matchStrategy);
        } else if (repositoryIndex > -1) {
            return expression.lk(repositoryIndex, name, value, matchStrategy);
        } else {
            return ((LikeExpression<C, L>) expression).lk(name, value, matchStrategy);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(Object value, MatchStrategy matchStrategy, Predicate<Object> ignoreStrategy) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(Object value, MatchStrategy matchStrategy, Predicate<Object> ignoreStrategy) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(Object[] value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(Object value, Predicate<Object> ignoreStrategy) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(Object[] value, Predicate<Object[]> ignoreStrategy) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nin(Object[] value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nin(Object value, Predicate<Object> ignoreStrategy) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nin(Object[] value, Predicate<Object[]> ignoreStrategy) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L sw(String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L co(String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ew(String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lk(String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(Object value, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(Object value, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(Object value, IgnoreStrategy ignoreStrategy) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(Object[] value, IgnoreStrategy ignoreStrategy) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nin(Object value, IgnoreStrategy ignoreStrategy) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nin(Object[] value, IgnoreStrategy ignoreStrategy) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(Object value, IgnoreStrategy ignoreStrategy) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(Object value, Predicate<Object> ignoreStrategy) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(Object value, IgnoreStrategy ignoreStrategy) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(Object value, Predicate<Object> ignoreStrategy) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(Object value, IgnoreStrategy ignoreStrategy) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(Object value, Predicate<Object> ignoreStrategy) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(Object value, IgnoreStrategy ignoreStrategy) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(Object value, Predicate<Object> ignoreStrategy) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L sw(String value, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L co(String value, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ew(String value, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lk(String value, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }
}
