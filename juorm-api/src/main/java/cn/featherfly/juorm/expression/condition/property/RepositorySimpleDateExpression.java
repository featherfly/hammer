
package cn.featherfly.juorm.expression.condition.property;

import java.util.Date;

import cn.featherfly.common.lang.LangUtils;
import cn.featherfly.juorm.expression.condition.LogicExpression;
import cn.featherfly.juorm.expression.condition.RepositoryConditionsExpression;

/**
 * <p>
 * SimpleObjectExpression
 * </p>
 *
 * @author zhongj
 */
public class RepositorySimpleDateExpression<C extends RepositoryConditionsExpression<C, L>,
        L extends LogicExpression<C, L>> implements DateExpression<C, L> {

    private String name;

    private String repository;

    private int repositoryIndex = -1;

    private RepositoryConditionsExpression<C, L> expression;

    /**
     * @param repositoryIndex repository index
     * @param name            name
     * @param expression      expression
     */
    public RepositorySimpleDateExpression(int repositoryIndex, String name,
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
    public RepositorySimpleDateExpression(String repository, String name,
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
    public RepositorySimpleDateExpression(String name, RepositoryConditionsExpression<C, L> expression) {
        this(null, name, expression);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(Date value) {
        if (LangUtils.isNotEmpty(repository)) {
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
    public String expression() {
        return expression.expression();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(Date value) {
        if (LangUtils.isNotEmpty(repository)) {
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
    public L in(Date value) {
        if (LangUtils.isNotEmpty(repository)) {
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
    public L nin(Date value) {
        if (LangUtils.isNotEmpty(repository)) {
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
    public L le(Date value) {
        if (LangUtils.isNotEmpty(repository)) {
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
    public L lt(Date value) {
        if (LangUtils.isNotEmpty(repository)) {
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
    public L ge(Date value) {
        if (LangUtils.isNotEmpty(repository)) {
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
    public L gt(Date value) {
        if (LangUtils.isNotEmpty(repository)) {
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
        if (LangUtils.isNotEmpty(repository)) {
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
        if (LangUtils.isNotEmpty(repository)) {
            return expression.inn(repository, name);
        } else if (repositoryIndex > -1) {
            return expression.inn(repositoryIndex, name);
        } else {
            return expression.inn(name);
        }
    }
}
