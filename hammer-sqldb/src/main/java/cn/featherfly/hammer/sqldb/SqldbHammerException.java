
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
     * Instantiates a new hammer validate exception.
     *
     * @param message message
     * @param locale locale
     * @param ex ex
     */
    public SqldbHammerException(String message, Locale locale, Throwable ex) {
        super(message, locale, ex);
    }

    /**
     * Instantiates a new hammer validate exception.
     *
     * @param message message
     * @param locale locale
     */
    public SqldbHammerException(String message, Locale locale) {
        super(message, locale);
    }

    /**
     * Instantiates a new hammer validate exception.
     *
     * @param message message
     * @param locale locale
     * @param ex ex
     * @param args args
     */
    public SqldbHammerException(String message, Locale locale, Throwable ex, Object... args) {
        super(message, args, locale, ex);
    }

    /**
     * Instantiates a new hammer validate exception.
     *
     * @param message message
     * @param locale locale
     * @param args args
     */
    public SqldbHammerException(String message, Locale locale, Object... args) {
        super(message, args, locale);
    }

    /**
     * Instantiates a new hammer validate exception.
     *
     * @param message message
     * @param ex ex
     * @param args args
     */
    public SqldbHammerException(String message, Throwable ex, Object... args) {
        super(message, args, ex);
    }

    /**
     * Instantiates a new hammer validate exception.
     *
     * @param message message
     * @param args args
     */
    public SqldbHammerException(String message, Object... args) {
        super(message, args);
    }

    /**
     * Instantiates a new hammer validate exception.
     *
     * @param message message
     * @param ex ex
     */
    public SqldbHammerException(String message, Throwable ex) {
        super(message, ex);
    }

    /**
     * Instantiates a new hammer validate exception.
     *
     * @param message message
     */
    public SqldbHammerException(String message) {
        super(message);
    }

    /**
     * Instantiates a new hammer validate exception.
     *
     * @param ex ex
     */
    public SqldbHammerException(Throwable ex) {
        super(ex);
    }
}
