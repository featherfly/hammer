
package cn.featherfly.hammer.expression.condition;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

/**
 * The Interface RepositoryLessThanExpression.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface RepositoryLessThanExpression<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends LessThanExpression<C, L> {

    /**
     * 小于.
     *
     * @param <N>        number type
     * @param repository repository
     * @param name       参数名称
     * @param value      参数值
     * @return LogicExpression
     */
    <N extends Number> L lt(String repository, String name, N value);

    /**
     * 小于.
     *
     * @param <D>        date type
     * @param repository repository
     * @param name       参数名称
     * @param value      参数值
     * @return LogicExpression
     */
    <D extends Date> L lt(String repository, String name, D value);

    /**
     * 小于.
     *
     * @param repository repository
     * @param name       参数名称
     * @param value      参数值
     * @return LogicExpression
     */
    L lt(String repository, String name, LocalTime value);

    /**
     * 小于.
     *
     * @param repository repository
     * @param name       参数名称
     * @param value      参数值
     * @return LogicExpression
     */
    L lt(String repository, String name, LocalDate value);

    /**
     * 小于.
     *
     * @param repository repository
     * @param name       参数名称
     * @param value      参数值
     * @return LogicExpression
     */
    L lt(String repository, String name, LocalDateTime value);

    /**
     * 小于.
     *
     * @param repository repository
     * @param name       参数名称
     * @param value      参数值
     * @return LogicExpression
     */
    L lt(String repository, String name, String value);

    /**
     * 小于.
     *
     * @param <N>        number type
     * @param <T>        the generic type
     * @param repository repository type
     * @param name       参数名称
     * @param value      参数值
     * @return LogicExpression
     */
    //    <N extends Number, T> L lt(Class<T> repository, String name, N value);

    /**
     * 小于.
     *
     * @param <D>        date type
     * @param <T>        the generic type
     * @param repository repository type
     * @param name       参数名称
     * @param value      参数值
     * @return LogicExpression
     */
    //    <D extends Date, T> L lt(Class<T> repository, String name, D value);

    /**
     * 小于.
     *
     * @param <T>        the generic type
     * @param repository repository type
     * @param name       参数名称
     * @param value      参数值
     * @return LogicExpression
     */
    //    <T> L lt(Class<T> repository, String name, LocalTime value);

    /**
     * 小于.
     *
     * @param <T>        the generic type
     * @param repository repository type
     * @param name       参数名称
     * @param value      参数值
     * @return LogicExpression
     */
    //    <T> L lt(Class<T> repository, String name, LocalDate value);

    /**
     * 小于.
     *
     * @param <T>        the generic type
     * @param repository repository type
     * @param name       参数名称
     * @param value      参数值
     * @return LogicExpression
     */
    //    <T> L lt(Class<T> repository, String name, LocalDateTime value);

    /**
     * 小于.
     *
     * @param <T>        the generic type
     * @param repository repository type
     * @param name       参数名称
     * @param value      参数值
     * @return LogicExpression
     */
    //    <T> L lt(Class<T> repository, String name, String value);

    /**
     * 小于.
     *
     * @param <N>             number type
     * @param repositoryIndex repository index
     * @param name            参数名称
     * @param value           参数值
     * @return LogicExpression
     */
    <N extends Number> L lt(int repositoryIndex, String name, N value);

    /**
     * 小于.
     *
     * @param <D>             date type
     * @param repositoryIndex repository index
     * @param name            参数名称
     * @param value           参数值
     * @return LogicExpression
     */
    <D extends Date> L lt(int repositoryIndex, String name, D value);

    /**
     * 小于.
     *
     * @param repositoryIndex repository index
     * @param name            参数名称
     * @param value           参数值
     * @return LogicExpression
     */
    L lt(int repositoryIndex, String name, LocalTime value);

    /**
     * 小于.
     *
     * @param repositoryIndex repository index
     * @param name            参数名称
     * @param value           参数值
     * @return LogicExpression
     */
    L lt(int repositoryIndex, String name, LocalDate value);

    /**
     * 小于.
     *
     * @param repositoryIndex repository index
     * @param name            参数名称
     * @param value           参数值
     * @return LogicExpression
     */
    L lt(int repositoryIndex, String name, LocalDateTime value);

    /**
     * 小于.
     *
     * @param repositoryIndex repository index
     * @param name            参数名称
     * @param value           参数值
     * @return LogicExpression
     */
    L lt(int repositoryIndex, String name, String value);
}