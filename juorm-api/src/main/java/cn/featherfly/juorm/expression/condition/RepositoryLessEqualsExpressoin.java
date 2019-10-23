
package cn.featherfly.juorm.expression.condition;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

/**
 * <p>
 * LessEqualsExpressoin
 * </p>
 *
 * @author zhongj
 */
public interface RepositoryLessEqualsExpressoin<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends LessEqualsExpressoin<C, L> {

    /**
     * 小于等于
     *
     * @param <N>        number type
     * @param repository 存储库
     * @param name       参数名称
     * @param value      参数值
     * @return LogicExpression
     */
    <N extends Number> L le(String repository, String name, Number value);

    /**
     * 小于等于
     *
     * @param <D>        date type
     * @param repository 存储库
     * @param name       参数名称
     * @param value      参数值
     * @return LogicExpression
     */
    <D extends Date> L le(String repository, String name, D value);

    /**
     * 小于等于
     *
     * @param repository 存储库
     * @param name       参数名称
     * @param value      参数值
     * @return LogicExpression
     */
    L le(String repository, String name, LocalTime value);

    /**
     * 小于等于
     *
     * @param repository repository
     * @param name       参数名称
     * @param value      参数值
     * @return LogicExpression
     */
    L le(String repository, String name, LocalDate value);

    /**
     * 小于等于
     *
     * @param repository repository
     * @param name       参数名称
     * @param value      参数值
     * @return LogicExpression
     */
    L le(String repository, String name, LocalDateTime value);

    /**
     * 小于等于
     *
     * @param repository repository
     * @param name       参数名称
     * @param value      参数值
     * @return LogicExpression
     */
    L le(String repository, String name, String value);

    /**
     * 小于等于
     *
     * @param <N>        number type
     * @param repository 存储库
     * @param name       参数名称
     * @param value      参数值
     * @return LogicExpression
     */
    <N extends Number> L le(int repositoryIndex, String name, Number value);

    /**
     * 小于等于
     *
     * @param <D>        date type
     * @param repository 存储库
     * @param name       参数名称
     * @param value      参数值
     * @return LogicExpression
     */
    <D extends Date> L le(int repositoryIndex, String name, D value);

    /**
     * 小于等于
     *
     * @param repository 存储库
     * @param name       参数名称
     * @param value      参数值
     * @return LogicExpression
     */
    L le(int repositoryIndex, String name, LocalTime value);

    /**
     * 小于等于
     *
     * @param repositoryIndex repository index
     * @param name            参数名称
     * @param value           参数值
     * @return LogicExpression
     */
    L le(int repositoryIndex, String name, LocalDate value);

    /**
     * 小于等于
     *
     * @param repositoryIndex repository index
     * @param name            参数名称
     * @param value           参数值
     * @return LogicExpression
     */
    L le(int repositoryIndex, String name, LocalDateTime value);

    /**
     * 小于等于
     *
     * @param repositoryIndex repository index
     * @param name            参数名称
     * @param value           参数值
     * @return LogicExpression
     */
    L le(int repositoryIndex, String name, String value);
}