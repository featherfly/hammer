
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
 * query value one executor.
 *
 * @author zhongj
 */
public interface QueryValueOneExecutor {

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
     * @return LogicExpressionocal date
     */
    LocalDate localDate();

    /**
     * Local date time.
     *
     * @return LogicExpressionocal date time
     */
    LocalDateTime localDateTime();

    /**
     * Local time.
     *
     * @return LogicExpressionocal time
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
     * query for long number.
     *
     * @return long number
     */
    double doubleValue();

    /**
     * query for number.
     *
     * @return Integer number
     */
    default Byte byteNumber() {
        return number(Byte.class);
    }

    /**
     * query for number.
     *
     * @return Integer number
     */
    default Short shortNumber() {
        return number(Short.class);
    }

    /**
     * query for number.
     *
     * @return Integer number
     */
    default Integer intNumber() {
        return number(Integer.class);
    }

    /**
     * query for number.
     *
     * @return Long number
     */
    default Long longNumber() {
        return number(Long.class);
    }

    /**
     * query for number.
     *
     * @return Long number
     */
    default Double doubleNumber() {
        return number(Double.class);
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
     * query for value, return null when not found.
     *
     * @param <T>  the value type
     * @param type value type
     * @return value
     */
    default <T> T value(Class<T> type) {
        return single(type);
    }

    /**
     * query for value, return null when not found.
     *
     * @param <T> the value type
     * @return value
     */
    default <T> T value() {
        return single();
    }

    /**
     * query for single, return null when not found.
     *
     * @param <T> the generic type
     * @return value
     */
    <T> T single();

    /**
     * query for single, return null when not found.
     *
     * @param <T>  the generic type
     * @param type the type
     * @return value
     */
    <T> T single(Class<T> type);

    /**
     * query for unique, throw exception when not found.
     *
     * @param <T> the generic type
     * @return value
     */
    <T> T unique();

    /**
     * query for unique, throw exception when not found.
     *
     * @param <T>  the generic type
     * @param type the type
     * @return value
     */
    <T> T unique(Class<T> type);
}
