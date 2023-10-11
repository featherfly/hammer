
package cn.featherfly.hammer.expression.query;

import java.math.BigDecimal;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

/**
 * dsl for query number executor.
 *
 * @author zhongj
 */
public interface QueryValueExecutor {

    /**
     * query for String.
     *
     * @return String
     */
    String string();

    /**
     * Date.
     *
     * @return the date
     */
    Date date();

    /**
     * Local date.
     *
     * @return the local date
     */
    LocalDate localDate();

    /**
     * Local date time.
     *
     * @return the local date time
     */
    LocalDateTime localDateTime();

    /**
     * Local time.
     *
     * @return the local time
     */
    LocalTime localTime();

    /**
     * Timestamp.
     *
     * @return the timestamp
     */
    Timestamp timestamp();

    /**
     * Bytes.
     *
     * @return the byte[]
     */
    byte[] bytes();

    /**
     * Clob.
     *
     * @return the clob
     */
    Clob clob();

    /**
     * Blob.
     *
     * @return the blob
     */
    Blob blob();

    /**
     * Bool.
     *
     * @return true, if successful
     */
    boolean bool();

    /**
     * Byte value.
     *
     * @return the byte
     */
    byte byteValue();

    /**
     * Short value.
     *
     * @return the short
     */
    short shortValue();

    /**
     * query for int number.
     *
     * @return int number
     */
    int intValue();

    /**
     * query for long number.
     *
     * @return long number
     */
    long longValue();

    /**
     * query for number.
     *
     * @return Integer number
     */
    default Byte byteInt() {
        return number(Byte.class);
    }

    /**
     * query for number.
     *
     * @return Integer number
     */
    default Short shortInt() {
        return number(Short.class);
    }

    /**
     * query for number.
     *
     * @return Integer number
     */
    default Integer integer() {
        return number(Integer.class);
    }

    /**
     * query for number.
     *
     * @return Long number
     */
    default Long longInt() {
        return number(Long.class);
    }

    /**
     * query for number.
     *
     * @return BigDecimal number
     */
    default BigDecimal decimal() {
        return number(BigDecimal.class);
    }

    /**
     * query for number.
     *
     * @param <N>  number type
     * @param type number type
     * @return number
     */
    default <N extends Number> N number(Class<N> type) {
        return value(type);
    }

    /**
     * query for value.
     *
     * @param <T>  the value type
     * @param type value type
     * @return value
     */
    <T> T value(Class<T> type);
}
