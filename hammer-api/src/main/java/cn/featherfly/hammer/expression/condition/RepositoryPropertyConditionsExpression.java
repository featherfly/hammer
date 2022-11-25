
package cn.featherfly.hammer.expression.condition;

import java.util.Date;

import cn.featherfly.hammer.expression.condition.property.DateExpression;
import cn.featherfly.hammer.expression.condition.property.EnumExpression;
import cn.featherfly.hammer.expression.condition.property.NumberExpression;
import cn.featherfly.hammer.expression.condition.property.ObjectExpression;
import cn.featherfly.hammer.expression.condition.property.StringExpression;

/**
 * RepositoryPropertyConditionsExpression.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface RepositoryPropertyConditionsExpression<C extends RepositoryConditionsExpression<C, L>,
        L extends LogicExpression<C, L>> extends PropertyExpression<C, L> {

    /**
     * Property.
     *
     * @param repository the repository
     * @param name       the name
     * @return the object expression
     */
    ObjectExpression<C, L> property(String repository, String name);

    /**
     * Property string.
     *
     * @param repository the repository
     * @param name       the name
     * @return the string expression
     */
    StringExpression<C, L> propertyString(String repository, String name);

    /**
     * Property number.
     *
     * @param <N>        the number type
     * @param repository the repository
     * @param name       the name
     * @return the number expression
     */
    <N extends Number> NumberExpression<N, C, L> propertyNumber(String repository, String name);

    /**
     * Property date.
     *
     * @param <D>        the generic type
     * @param repository the repository
     * @param name       the name
     * @return the date expression
     */
    <D extends Date> DateExpression<D, C, L> propertyDate(String repository, String name);

    /**
     * Property enum.
     *
     * @param repository the repository
     * @param name       the name
     * @return the enum expression
     */
    <E extends Enum<E>> EnumExpression<E, C, L> propertyEnum(String repository, String name);

    /**
     * Property.
     *
     * @param <T>        the generic type
     * @param repository the repository
     * @param name       the name
     * @return the object expression
     */
    <T> ObjectExpression<C, L> property(Class<T> repository, String name);

    /**
     * Property string.
     *
     * @param <T>        the generic type
     * @param repository the repository
     * @param name       the name
     * @return the string expression
     */
    <T> StringExpression<C, L> propertyString(Class<T> repository, String name);

    /**
     * Property number.
     *
     * @param <N>        the number type
     * @param <T>        the generic type
     * @param repository the repository
     * @param name       the name
     * @return the number expression
     */
    <N extends Number, T> NumberExpression<N, C, L> propertyNumber(Class<T> repository, String name);

    /**
     * Property date.
     *
     * @param <D>        the generic type
     * @param <T>        the generic type
     * @param repository the repository
     * @param name       the name
     * @return the date expression
     */
    <D extends Date, T> DateExpression<D, C, L> propertyDate(Class<T> repository, String name);

    /**
     * Property enum.
     *
     * @param <T>        the generic type
     * @param repository the repository
     * @param name       the name
     * @return the enum expression
     */
    <T, E extends Enum<E>> EnumExpression<E, C, L> propertyEnum(Class<T> repository, String name);

    /**
     * Property.
     *
     * @param repositoryIndex the repository index
     * @param name            the name
     * @return the object expression
     */
    ObjectExpression<C, L> property(int repositoryIndex, String name);

    /**
     * Property string.
     *
     * @param repositoryIndex the repository index
     * @param name            the name
     * @return the string expression
     */
    StringExpression<C, L> propertyString(int repositoryIndex, String name);

    /**
     * Property number.
     *
     * @param <N>             the number type
     * @param repositoryIndex the repository index
     * @param name            the name
     * @return the number expression
     */
    <N extends Number> NumberExpression<N, C, L> propertyNumber(int repositoryIndex, String name);

    /**
     * Property date.
     *
     * @param <D>             the generic type
     * @param repositoryIndex the repository index
     * @param name            the name
     * @return the date expression
     */
    <D extends Date> DateExpression<D, C, L> propertyDate(int repositoryIndex, String name);

    /**
     * Property enum.
     *
     * @param repositoryIndex the repository index
     * @param name            the name
     * @return the enum expression
     */
    <E extends Enum<E>> EnumExpression<E, C, L> propertyEnum(int repositoryIndex, String name);
}
