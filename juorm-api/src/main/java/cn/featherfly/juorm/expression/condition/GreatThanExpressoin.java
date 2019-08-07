
package cn.featherfly.juorm.expression.condition;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

/**
 * <p>
 * GreatThanExpressoin
 * </p>
 *
 * @author zhongj
 */
public interface GreatThanExpressoin<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends ConditionExpression {

    /**
     * 大于
     * 
     * @param <N>   number type
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    <N extends Number> L gt(String name, Number value);

    /**
     * 大于
     *
     * @param <D>   date type
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    <D extends Date> L gt(String name, D value);

    /**
     * 大于
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    L gt(String name, LocalTime value);

    /**
     * 大于
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    L gt(String name, LocalDate value);

    /**
     * 大于
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    L gt(String name, LocalDateTime value);

    /**
     * 大于
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    L gt(String name, String value);
}