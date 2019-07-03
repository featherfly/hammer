
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
public interface GreatEqualsExpressoin<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends ConditionExpression {

    /**
     * 大于等于
     *
     * @param name
     *            参数名称
     * @param value
     *            参数值
     * @return LogicExpression
     */
    <N extends Number> L ge(String name, Number value);

    /**
     * 大于等于
     *
     * @param name
     *            参数名称
     * @param value
     *            参数值
     * @return LogicExpression
     */
    <D extends Date> L ge(String name, D value);

    /**
     * 大于等于
     *
     * @param name
     *            参数名称
     * @param value
     *            参数值
     * @return LogicExpression
     */
    L ge(String name, LocalTime value);

    /**
     * 大于等于
     *
     * @param name
     *            参数名称
     * @param value
     *            参数值
     * @return LogicExpression
     */
    L ge(String name, LocalDate value);

    /**
     * 大于等于
     *
     * @param name
     *            参数名称
     * @param value
     *            参数值
     * @return LogicExpression
     */
    L ge(String name, LocalDateTime value);

    /**
     * 大于等于
     *
     * @param name
     *            参数名称
     * @param value
     *            参数值
     * @return LogicExpression
     */
    L ge(String name, String value);
}