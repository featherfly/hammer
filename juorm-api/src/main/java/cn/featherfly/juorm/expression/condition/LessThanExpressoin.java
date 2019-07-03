
package cn.featherfly.juorm.expression.condition;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

/**
 * <p>
 * LessThanExpressoin
 * </p>
 *
 * @author zhongj
 */
public interface LessThanExpressoin<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends ConditionExpression {

    /**
     * 小于
     *
     * @param name
     *            参数名称
     * @param value
     *            参数值
     * @return LogicExpression
     */
    <N extends Number> L lt(String name, Number value);

    /**
     * 小于
     *
     * @param name
     *            参数名称
     * @param value
     *            参数值
     * @return LogicExpression
     */
    <D extends Date> L lt(String name, D value);

    /**
     * 小于
     *
     * @param name
     *            参数名称
     * @param value
     *            参数值
     * @return LogicExpression
     */
    L lt(String name, LocalTime value);

    /**
     * 小于
     *
     * @param name
     *            参数名称
     * @param value
     *            参数值
     * @return LogicExpression
     */
    L lt(String name, LocalDate value);

    /**
     * 小于
     *
     * @param name
     *            参数名称
     * @param value
     *            参数值
     * @return LogicExpression
     */
    L lt(String name, LocalDateTime value);

    /**
     * 小于
     *
     * @param name
     *            参数名称
     * @param value
     *            参数值
     * @return LogicExpression
     */
    L lt(String name, String value);
}