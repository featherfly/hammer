
package cn.featherfly.hammer.expression.condition.property;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

import cn.featherfly.common.lang.Lang;
import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.common.repository.IgnoreStrategy;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.condition.RepositoryConditionsExpression;

/**
 * The Class RepositorySimpleNumberExpression.
 *
 * @author zhongj
 * @param <N> the number type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public class RepositorySimpleNumberExpression<N extends Number, C extends RepositoryConditionsExpression<C, L>,
        L extends LogicExpression<C, L>> implements NumberPropertyExpression<N, C, L> {

    private String repository;

    private String name;

    private RepositoryConditionsExpression<C, L> expression;

    private int repositoryIndex = -1;

    /**
     * Instantiates a new repository simple number expression.
     *
     * @param repositoryIndex repositoryIndex
     * @param name            name
     * @param expression      expression
     */
    public RepositorySimpleNumberExpression(int repositoryIndex, String name,
            RepositoryConditionsExpression<C, L> expression) {
        super();
        this.repositoryIndex = repositoryIndex;
        this.name = name;
        this.expression = expression;
    }

    /**
     * Instantiates a new repository simple number expression.
     *
     * @param repository repository
     * @param name       name
     * @param expression expression
     */
    public RepositorySimpleNumberExpression(String repository, String name,
            RepositoryConditionsExpression<C, L> expression) {
        super();
        this.repository = repository;
        this.name = name;
        this.expression = expression;
    }

    /**
     * Instantiates a new repository simple number expression.
     *
     * @param name       name
     * @param expression expression
     */
    public RepositorySimpleNumberExpression(String name, RepositoryConditionsExpression<C, L> expression) {
        this(null, name, expression);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(N value) {
        if (Lang.isNotEmpty(repository)) {
            return expression.eq(repository, name, value);
        } else if (repositoryIndex > -1) {
            return expression.eq(repositoryIndex, name, value);
        } else {
            return expression.eq(name, value);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(N value, MatchStrategy matchStrategy) {
        if (Lang.isNotEmpty(repository)) {
            return expression.eq(repository, name, value, matchStrategy);
        } else if (repositoryIndex > -1) {
            return expression.eq(repositoryIndex, name, value, matchStrategy);
        } else {
            return expression.eq(name, value, matchStrategy);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(N value) {
        if (Lang.isNotEmpty(repository)) {
            return expression.ne(repository, name, value);
        } else if (repositoryIndex > -1) {
            return expression.ne(repositoryIndex, name, value);
        } else {
            return expression.ne(name, value);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(N value, MatchStrategy matchStrategy) {
        if (Lang.isNotEmpty(repository)) {
            return expression.ne(repository, name, value, matchStrategy);
        } else if (repositoryIndex > -1) {
            return expression.ne(repositoryIndex, name, value, matchStrategy);
        } else {
            return expression.ne(name, value, matchStrategy);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(N value) {
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
    public L ni(N value) {
        if (Lang.isNotEmpty(repository)) {
            return expression.nin(repository, name, value);
        } else if (repositoryIndex > -1) {
            return expression.nin(repositoryIndex, name, value);
        } else {
            return expression.ni(name, value);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(N value) {
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
    public L lt(N value) {
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
    public L ge(N value) {
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
    public L gt(N value) {
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
    public String expression() {
        return expression.expression();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(N[] value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(N value, Predicate<N> ignoreStrategy) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(N[] value, Predicate<N[]> ignoreStrategy) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(N[] value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(N value, Predicate<N> ignoreStrategy) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(N[] value, Predicate<N[]> ignoreStrategy) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(N value, Predicate<N> ignoreStrategy) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(N value, Predicate<N> ignoreStrategy) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(N value, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(N value, IgnoreStrategy ignoreStrategy) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(N value, IgnoreStrategy ignoreStrategy) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(N value, IgnoreStrategy ignoreStrategy) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(N[] value, IgnoreStrategy ignoreStrategy) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(N value, IgnoreStrategy ignoreStrategy) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(N[] value, IgnoreStrategy ignoreStrategy) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(N value, IgnoreStrategy ignoreStrategy) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(N value, Predicate<N> ignoreStrategy) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(N value, IgnoreStrategy ignoreStrategy) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(N value, Predicate<N> ignoreStrategy) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(N value, IgnoreStrategy ignoreStrategy) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(N value, Predicate<N> ignoreStrategy) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(N value, IgnoreStrategy ignoreStrategy) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba(N min, N max) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba(N min, N max, IgnoreStrategy ignoreStrategy) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba(N min, N max, BiPredicate<N, N> ignoreStrategy) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba(N min, N max) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba(N min, N max, IgnoreStrategy ignoreStrategy) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba(N min, N max, BiPredicate<N, N> ignoreStrategy) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(N value, Predicate<N> ignoreStrategy) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

}
