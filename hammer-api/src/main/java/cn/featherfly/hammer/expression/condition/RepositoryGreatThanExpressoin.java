
package cn.featherfly.hammer.expression.condition;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

/**
 * <p>
 * RepositoryGreatThanExpressoin
 * </p>
 * .
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface RepositoryGreatThanExpressoin<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends GreatThanExpressoin<C, L> {

    /**
     * 大于.
     *
     * @param <N>        number type
     * @param repository repository
     * @param name       参数名称
     * @param value      参数值
     * @return LogicExpression
     */

    <N extends Number> L gt(String repository, String name, N value);

    /**
     * 大于.
     *
     * @param <D>        date type
     * @param repository repository
     * @param name       参数名称
     * @param value      参数值
     * @return LogicExpression
     */

    <D extends Date> L gt(String repository, String name, D value);

    /**
     * 大于.
     *
     * @param repository repository
     * @param name       参数名称
     * @param value      参数值
     * @return LogicExpression
     */

    L gt(String repository, String name, LocalTime value);

    /**
     * 大于.
     *
     * @param repository repository
     * @param name       参数名称
     * @param value      参数值
     * @return LogicExpression
     */

    L gt(String repository, String name, LocalDate value);

    /**
     * 大于.
     *
     * @param repository repository
     * @param name       参数名称
     * @param value      参数值
     * @return LogicExpression
     */

    L gt(String repository, String name, LocalDateTime value);

    /**
     * 大于.
     *
     * @param repository repository
     * @param name       参数名称
     * @param value      参数值
     * @return LogicExpression
     */
    L gt(String repository, String name, String value);

    /**
     * 大于.
     *
     * @param <N>        number type
     * @param <T>        the generic type
     * @param repository repository type
     * @param name       参数名称
     * @param value      参数值
     * @return LogicExpression
     */
    //    <N extends Number, T> L gt(Class<T> repository, String name, N value);

    /**
     * 大于.
     *
     * @param <D>        date type
     * @param <T>        the generic type
     * @param repository repository type
     * @param name       参数名称
     * @param value      参数值
     * @return LogicExpression
     */
    //    <D extends Date, T> L gt(Class<T> repository, String name, D value);

    /**
     * 大于.
     *
     * @param <T>        the generic type
     * @param repository repository type
     * @param name       参数名称
     * @param value      参数值
     * @return LogicExpression
     */
    //    <T> L gt(Class<T> repository, String name, LocalTime value);

    /**
     * 大于.
     *
     * @param <T>        the generic type
     * @param repository repository type
     * @param name       参数名称
     * @param value      参数值
     * @return LogicExpression
     */
    //    <T> L gt(Class<T> repository, String name, LocalDate value);

    /**
     * 大于.
     *
     * @param <T>        the generic type
     * @param repository repository type
     * @param name       参数名称
     * @param value      参数值
     * @return LogicExpression
     */
    //    <T> L gt(Class<T> repository, String name, LocalDateTime value);

    /**
     * 大于.
     *
     * @param <T>        the generic type
     * @param repository repository type
     * @param name       参数名称
     * @param value      参数值
     * @return LogicExpression
     */
    //    <T> L gt(Class<T> repository, String name, String value);

    /**
     * 大于.
     *
     * @param <N>             number type
     * @param repositoryIndex repository index
     * @param name            参数名称
     * @param value           参数值
     * @return LogicExpression
     */

    <N extends Number> L gt(int repositoryIndex, String name, N value);

    /**
     * 大于.
     *
     * @param <D>             date type
     * @param repositoryIndex repository index
     * @param name            参数名称
     * @param value           参数值
     * @return LogicExpression
     */

    <D extends Date> L gt(int repositoryIndex, String name, D value);

    /**
     * 大于.
     *
     * @param repositoryIndex repository index
     * @param name            参数名称
     * @param value           参数值
     * @return LogicExpression
     */

    L gt(int repositoryIndex, String name, LocalTime value);

    /**
     * 大于.
     *
     * @param repositoryIndex repository index
     * @param name            参数名称
     * @param value           参数值
     * @return LogicExpression
     */

    L gt(int repositoryIndex, String name, LocalDate value);

    /**
     * 大于.
     *
     * @param repositoryIndex repository index
     * @param name            参数名称
     * @param value           参数值
     * @return LogicExpression
     */

    L gt(int repositoryIndex, String name, LocalDateTime value);

    /**
     * 大于.
     *
     * @param repositoryIndex repository index
     * @param name            参数名称
     * @param value           参数值
     * @return LogicExpression
     */

    L gt(int repositoryIndex, String name, String value);

}