
package cn.featherfly.hammer.expression.condition.property;

import cn.featherfly.common.lang.Lang;
import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.hammer.expression.condition.ContainsExpression;
import cn.featherfly.hammer.expression.condition.EndWithExpression;
import cn.featherfly.hammer.expression.condition.EqualsExpression;
import cn.featherfly.hammer.expression.condition.LikeExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.condition.NotEqualsExpression;
import cn.featherfly.hammer.expression.condition.RepositoryConditionsExpression;
import cn.featherfly.hammer.expression.condition.StartWithExpression;

/**
 * The Class RepositorySimpleStringExpression.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public class RepositorySimpleStringExpression<C extends RepositoryConditionsExpression<C, L>,
        L extends LogicExpression<C, L>> implements StringExpression<C, L> {

    private String repository;

    private String name;

    private RepositoryConditionsExpression<C, L> expression;

    private int repositoryIndex = -1;

    /**
     * Instantiates a new repository simple string expression.
     *
     * @param repositoryIndex repositoryIndex
     * @param name            name
     * @param expression      expression
     */
    public RepositorySimpleStringExpression(int repositoryIndex, String name,
            RepositoryConditionsExpression<C, L> expression) {
        super();
        this.repositoryIndex = repositoryIndex;
        this.name = name;
        this.expression = expression;
    }

    /**
     * Instantiates a new repository simple string expression.
     *
     * @param repository repository
     * @param name       name
     * @param expression expression
     */
    public RepositorySimpleStringExpression(String repository, String name,
            RepositoryConditionsExpression<C, L> expression) {
        super();
        this.repository = repository;
        this.name = name;
        this.expression = expression;
    }

    /**
     * Instantiates a new repository simple string expression.
     *
     * @param name       name
     * @param expression expression
     */
    public RepositorySimpleStringExpression(String name, RepositoryConditionsExpression<C, L> expression) {
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
    public L in(String value) {
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
    public L nin(String value) {
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
    public L le(String value) {
        if (Lang.isNotEmpty(repository)) {
            return expression.le(repository, name, value);
        } else if (repositoryIndex > -1) {
            return expression.le(repositoryIndex, name, value);
        } else {
            return expression.le(name, value);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(String value) {
        if (Lang.isNotEmpty(repository)) {
            return expression.lt(repository, name, value);
        } else if (repositoryIndex > -1) {
            return expression.lt(repositoryIndex, name, value);
        } else {
            return expression.lt(name, value);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(String value) {
        if (Lang.isNotEmpty(repository)) {
            return expression.ge(repository, name, value);
        } else if (repositoryIndex > -1) {
            return expression.ge(repositoryIndex, name, value);
        } else {
            return expression.ge(name, value);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(String value) {
        if (Lang.isNotEmpty(repository)) {
            return expression.gt(repository, name, value);
        } else if (repositoryIndex > -1) {
            return expression.gt(repositoryIndex, name, value);
        } else {
            return expression.gt(name, value);
        }
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
    public L eq(String value, MatchStrategy queryPolicy) {
        if (Lang.isNotEmpty(repository)) {
            return expression.eq(repository, name, value, queryPolicy);
        } else if (repositoryIndex > -1) {
            return expression.eq(repositoryIndex, name, value, queryPolicy);
        } else {
            return ((EqualsExpression<C, L>) expression).eq(name, value, queryPolicy);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(String value, MatchStrategy queryPolicy) {
        if (Lang.isNotEmpty(repository)) {
            return expression.ne(repository, name, value, queryPolicy);
        } else if (repositoryIndex > -1) {
            return expression.ne(repositoryIndex, name, value, queryPolicy);
        } else {
            return ((NotEqualsExpression<C, L>) expression).ne(name, value, queryPolicy);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L sw(String value, MatchStrategy queryPolicy) {
        if (Lang.isNotEmpty(repository)) {
            return expression.sw(repository, name, value, queryPolicy);
        } else if (repositoryIndex > -1) {
            return expression.sw(repositoryIndex, name, value, queryPolicy);
        } else {
            return ((StartWithExpression<C, L>) expression).sw(name, value, queryPolicy);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L co(String value, MatchStrategy queryPolicy) {
        if (Lang.isNotEmpty(repository)) {
            return expression.co(repository, name, value, queryPolicy);
        } else if (repositoryIndex > -1) {
            return expression.co(repositoryIndex, name, value, queryPolicy);
        } else {
            return ((ContainsExpression<C, L>) expression).co(name, value, queryPolicy);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ew(String value, MatchStrategy queryPolicy) {
        if (Lang.isNotEmpty(repository)) {
            return expression.ew(repository, name, value, queryPolicy);
        } else if (repositoryIndex > -1) {
            return expression.ew(repositoryIndex, name, value, queryPolicy);
        } else {
            return ((EndWithExpression<C, L>) expression).ew(name, value, queryPolicy);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lk(String value, MatchStrategy queryPolicy) {
        if (Lang.isNotEmpty(repository)) {
            return expression.lk(repository, name, value, queryPolicy);
        } else if (repositoryIndex > -1) {
            return expression.lk(repositoryIndex, name, value, queryPolicy);
        } else {
            return ((LikeExpression<C, L>) expression).lk(name, value, queryPolicy);
        }
    }
}
