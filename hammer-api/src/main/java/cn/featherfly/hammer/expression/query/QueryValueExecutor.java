
package cn.featherfly.hammer.expression.query;

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
     * query for int number
     *
     * @return int number
     */
    int intValue();

    /**
     * query for long number
     *
     * @return long number
     */
    long longValue();

    /**
     * query for number
     *
     * @return Integer number
     */
    default Integer integer() {
        return number(Integer.class);
    }

    /**
     * query for number
     *
     * @return Long number
     */
    default Long longInt() {
        return number(Long.class);
    }

    /**
     * query for number
     *
     * @return BigDecimal number
     */
    default BigDecimal decimal() {
        return number(BigDecimal.class);
    }

    /**
     * query for number
     *
     * @param <N>  number type
     * @param type number type
     * @return num
     */
    <N extends Number> N number(Class<N> type);
}
