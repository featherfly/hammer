
package cn.featherfly.juorm.rdb.jdbc;

import java.util.Locale;

import cn.featherfly.juorm.JuormException;

/**
 * <p>
 * JuormJdbcException
 * </p>
 * .
 *
 * @author zhongj
 */
public class JuormJdbcException extends JuormException {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 6788081346324738442L;

    /**
     * Instantiates a new juorm jdbc exception.
     */
    public JuormJdbcException() {
        super();
    }

    /**
     * Instantiates a new juorm jdbc exception.
     *
     * @param message the message
     * @param locale  the locale
     * @param ex      the ex
     */
    public JuormJdbcException(String message, Locale locale, Throwable ex) {
        super(message, locale, ex);
    }

    /**
     * Instantiates a new juorm jdbc exception.
     *
     * @param message the message
     * @param locale  the locale
     */
    public JuormJdbcException(String message, Locale locale) {
        super(message, locale);
    }

    /**
     * Instantiates a new juorm jdbc exception.
     *
     * @param message the message
     * @param args    the args
     * @param locale  the locale
     * @param ex      the ex
     */
    public JuormJdbcException(String message, Object[] args, Locale locale, Throwable ex) {
        super(message, args, locale, ex);
    }

    /**
     * Instantiates a new juorm jdbc exception.
     *
     * @param message the message
     * @param args    the args
     * @param locale  the locale
     */
    public JuormJdbcException(String message, Object[] args, Locale locale) {
        super(message, args, locale);
    }

    /**
     * Instantiates a new juorm jdbc exception.
     *
     * @param message the message
     * @param args    the args
     * @param ex      the ex
     */
    public JuormJdbcException(String message, Object[] args, Throwable ex) {
        super(message, args, ex);
    }

    /**
     * Instantiates a new juorm jdbc exception.
     *
     * @param message the message
     * @param args    the args
     */
    public JuormJdbcException(String message, Object[] args) {
        super(message, args);
    }

    /**
     * Instantiates a new juorm jdbc exception.
     *
     * @param message the message
     * @param ex      the ex
     */
    public JuormJdbcException(String message, Throwable ex) {
        super(message, ex);
    }

    /**
     * Instantiates a new juorm jdbc exception.
     *
     * @param message the message
     */
    public JuormJdbcException(String message) {
        super(message);
    }

    /**
     * Instantiates a new juorm jdbc exception.
     *
     * @param ex the ex
     */
    public JuormJdbcException(Throwable ex) {
        super(ex);
    }
}
