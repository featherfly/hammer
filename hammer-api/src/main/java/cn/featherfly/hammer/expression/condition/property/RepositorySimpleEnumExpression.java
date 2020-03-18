
package cn.featherfly.hammer.expression.condition.property;

import cn.featherfly.common.lang.LangUtils;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.condition.RepositoryConditionsExpression;

/**
 * <p>
 * SimpleObjectExpression
 * </p>
 *
 * @author zhongj
 */
public class RepositorySimpleEnumExpression<C extends RepositoryConditionsExpression<C, L>,
        L extends LogicExpression<C, L>> implements EnumExpression<C, L> {

    private String repository;

    private String name;

    private RepositoryConditionsExpression<C, L> expression;

    private int repositoryIndex = -1;

    /**
     * @param repositoryIndex repositoryIndex
     * @param name            name
     * @param expression      expression
     */
    public RepositorySimpleEnumExpression(int repositoryIndex, String name,
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
    public RepositorySimpleEnumExpression(String repository, String name,
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
    public RepositorySimpleEnumExpression(String name, RepositoryConditionsExpression<C, L> expression) {
        this(null, name, expression);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(Enum<?> value) {
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
    public L ne(Enum<?> value) {
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
    public L in(Enum<?> value) {
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
    public L nin(Enum<?> value) {
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
