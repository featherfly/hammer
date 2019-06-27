
package cn.featherfly.juorm.dsl.query;

import java.math.BigDecimal;

/**
 * <p>
 * dsl for query number executor
 * </p>
 *
 * @author zhongj
 */
public interface QueryValueExecutor {

    /**
     * query for String
     *
     * @return String
     */
    String string();

    /**
     * query for number
     *
     * @return Integer number
     */
    Integer integer();

    /**
     * query for number
     *
     * @return Long number
     */
    Long longInt();

    /**
     * query for number
     *
     * @return BigDecimal number
     */
    BigDecimal decimal();

    /**
     * query for number
     *
     * @param type
     *            numberType
     * @return num
     */
    <N extends Number> N number(Class<N> type);
}
