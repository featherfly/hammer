
package cn.featherfly.juorm.expression.condition;

import cn.featherfly.juorm.expression.condition.property.DateExpression;
import cn.featherfly.juorm.expression.condition.property.EnumExpression;
import cn.featherfly.juorm.expression.condition.property.NumberExpression;
import cn.featherfly.juorm.expression.condition.property.ObjectExpression;
import cn.featherfly.juorm.expression.condition.property.StringExpression;

/**
 * <p>
 * PropertyConditionExpression
 * </p>
 *
 * @author zhongj
 */
public interface RepositoryPropertyConditionsExpression<C extends RepositoryConditionsExpression<C, L>,
        L extends LogicExpression<C, L>> extends PropertyExpression<C, L> {

    ObjectExpression<C, L> property(String repository, String name);

    StringExpression<C, L> propertyString(String repository, String name);

    NumberExpression<C, L> propertyNumber(String repository, String name);

    DateExpression<C, L> propertyDate(String repository, String name);

    EnumExpression<C, L> propertyEnum(String repository, String name);

    <T> ObjectExpression<C, L> property(Class<T> repository, String name);

    <T> StringExpression<C, L> propertyString(Class<T> repository, String name);

    <T> NumberExpression<C, L> propertyNumber(Class<T> repository, String name);

    <T> DateExpression<C, L> propertyDate(Class<T> repository, String name);

    <T> EnumExpression<C, L> propertyEnum(Class<T> repository, String name);

    ObjectExpression<C, L> property(int repositoryIndex, String name);

    StringExpression<C, L> propertyString(int repositoryIndex, String name);

    NumberExpression<C, L> propertyNumber(int repositoryIndex, String name);

    DateExpression<C, L> propertyDate(int repositoryIndex, String name);

    EnumExpression<C, L> propertyEnum(int repositoryIndex, String name);
}
