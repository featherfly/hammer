
package cn.featherfly.juorm.expression.condition;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

/**
 * <p>
 * GreatEqualsExpressoin
 * </p>
 *
 * @author zhongj
 */
public interface RepositoryGreatEqualsExpressoin<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends GreatEqualsExpressoin<C, L> {

    /**
     * 大于等于
     *
     * @param <N>             number type
     * @param repositoryIndex repository index
     * @param name            参数名称
     * @param value           参数值
     * @return LogicExpression
     */
    <N extends Number> L ge(String repository, String name, Number value);

    /**
     * 大于等于
     *
     * @param <D>             date type
     * @param repositoryIndex repository index
     * @param name            参数名称
     * @param value           参数值
     * @return LogicExpression
     */
    <D extends Date> L ge(String repository, String name, D value);

    /**
     * 大于等于
     *
     * @param repositoryIndex repository index
     * @param name            参数名称
     * @param value           参数值
     * @return LogicExpression
     */
    L ge(String repository, String name, LocalTime value);

    /**
     * 大于等于
     *
     * @param repositoryIndex repository index
     * @param name            参数名称
     * @param value           参数值
     * @return LogicExpression
     */
    L ge(String repository, String name, LocalDate value);

    /**
     * 大于等于
     *
     * @param repositoryIndex repository index
     * @param name            参数名称
     * @param value           参数值
     * @return LogicExpression
     */
    L ge(String repository, String name, LocalDateTime value);

    /**
     * 大于等于
     *
     * @param repositoryIndex repository index
     * @param name            参数名称
     * @param value           参数值
     * @return LogicExpression
     */
    L ge(String repository, String name, String value);

    /**
     * 大于等于
     *
     * @param <N>             number type
     * @param repositoryIndex repository index
     * @param name            参数名称
     * @param value           参数值
     * @return LogicExpression
     */
    <N extends Number> L ge(int repositoryIndex, String name, Number value);

    /**
     * 大于等于
     *
     * @param <D>             date type
     * @param repositoryIndex repository index
     * @param name            参数名称
     * @param value           参数值
     * @return LogicExpression
     */
    <D extends Date> L ge(int repositoryIndex, String name, D value);

    /**
     * 大于等于
     *
     * @param repositoryIndex repository index
     * @param name            参数名称
     * @param value           参数值
     * @return LogicExpression
     */
    L ge(int repositoryIndex, String name, LocalTime value);

    /**
     * 大于等于
     *
     * @param repositoryIndex repository index
     * @param name            参数名称
     * @param value           参数值
     * @return LogicExpression
     */
    L ge(int repositoryIndex, String name, LocalDate value);

    /**
     * 大于等于
     *
     * @param repositoryIndex repository index
     * @param name            参数名称
     * @param value           参数值
     * @return LogicExpression
     */
    L ge(int repositoryIndex, String name, LocalDateTime value);

    /**
     * 大于等于
     *
     * @param repositoryIndex repository index
     * @param name            参数名称
     * @param value           参数值
     * @return LogicExpression
     */
    L ge(int repositoryIndex, String name, String value);
}