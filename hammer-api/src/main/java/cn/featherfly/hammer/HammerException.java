
package cn.featherfly.hammer;

import java.util.Locale;

import cn.featherfly.common.exception.LocalizedException;

/**
 * <p>
 * Hammer base Exception
 * </p>
 *
 * @author zhongj
 */
public class HammerException extends LocalizedException {

    /**
     *
     */
    private static final long serialVersionUID = -9019711912180497707L;

    /**
     *
     */
    public HammerException() {
        super();
    }

    /**
     * @param message message
     * @param locale  locale
     * @param ex      ex
     */
    public HammerException(String message, Locale locale, Throwable ex) {
        super(message, locale, ex);
    }

    /**
     * @param message message
     * @param locale  locale
     */
    public HammerException(String message, Locale locale) {
        super(message, locale);
    }

    /**
     * @param message message
     * @param args    args
     * @param locale  locale
     * @param ex      ex
     */
    public HammerException(String message, Object[] args, Locale locale, Throwable ex) {
        super(message, args, locale, ex);
    }

    /**
     * @param message message
     * @param args    args
     * @param locale  locale
     */
    public HammerException(String message, Object[] args, Locale locale) {
        super(message, args, locale);
    }

    /**
     * @param message message
     * @param args    args
     * @param ex      ex
     */
    public HammerException(String message, Object[] args, Throwable ex) {
        super(message, args, ex);
    }

    /**
     * @param message message
     * @param args    args
     */
    public HammerException(String message, Object[] args) {
        super(message, args);
    }

    /**
     * @param message message
     * @param ex      ex
     */
    public HammerException(String message, Throwable ex) {
        super(message, ex);
    }

    /**
     * @param message message
     */
    public HammerException(String message) {
        super(message);
    }

    /**
     * @param ex ex
     */
    public HammerException(Throwable ex) {
        super(ex);
    }

}
