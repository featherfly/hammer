
package cn.featherfly.hammer.sqldb;

import java.util.Locale;

import cn.featherfly.hammer.HammerException;

/**
 * <p>
 * SqldbHammerException
 * </p>
 * .
 *
 * @author zhongj
 */
public class SqldbHammerException extends HammerException {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 6788081346324738442L;

    /**
     * Instantiates a new hammer jdbc exception.
     *
     * @param message the message
     * @param locale  the locale
     * @param ex      the ex
     */
    public SqldbHammerException(String message, Locale locale, Throwable ex) {
        super(message, locale, ex);
    }

    /**
     * Instantiates a new hammer jdbc exception.
     *
     * @param message the message
     * @param locale  the locale
     */
    public SqldbHammerException(String message, Locale locale) {
        super(message, locale);
    }

    /**
     * Instantiates a new hammer jdbc exception.
     *
     * @param message the message
     * @param args    the args
     * @param locale  the locale
     * @param ex      the ex
     */
    public SqldbHammerException(String message, Object[] args, Locale locale, Throwable ex) {
        super(message, args, locale, ex);
    }

    /**
     * Instantiates a new hammer jdbc exception.
     *
     * @param message the message
     * @param args    the args
     * @param locale  the locale
     */
    public SqldbHammerException(String message, Object[] args, Locale locale) {
        super(message, args, locale);
    }

    /**
     * Instantiates a new hammer jdbc exception.
     *
     * @param message the message
     * @param args    the args
     * @param ex      the ex
     */
    public SqldbHammerException(String message, Object[] args, Throwable ex) {
        super(message, args, ex);
    }

    /**
     * Instantiates a new hammer jdbc exception.
     *
     * @param message the message
     * @param args    the args
     */
    public SqldbHammerException(String message, Object[] args) {
        super(message, args);
    }

    /**
     * Instantiates a new hammer jdbc exception.
     *
     * @param message the message
     * @param ex      the ex
     */
    public SqldbHammerException(String message, Throwable ex) {
        super(message, ex);
    }

    /**
     * Instantiates a new hammer jdbc exception.
     *
     * @param message the message
     */
    public SqldbHammerException(String message) {
        super(message);
    }

    /**
     * Instantiates a new hammer jdbc exception.
     *
     * @param ex the ex
     */
    public SqldbHammerException(Throwable ex) {
        super(ex);
    }
}
