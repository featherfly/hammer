
package cn.featherfly.hammer;

import java.util.Locale;

import cn.featherfly.common.exception.LocalizedException;

/**
 * Hammer base Exception.
 *
 * @author zhongj
 */
public class HammerException extends LocalizedException {

    /**
     *
     */
    private static final long serialVersionUID = -9019711912180497707L;

    /**
     * Instantiates a new hammer exception.
     *
     * @param message message
     * @param locale locale
     * @param ex ex
     */
    public HammerException(String message, Locale locale, Throwable ex) {
        super(message, locale, ex);
    }

    /**
     * Instantiates a new hammer exception.
     *
     * @param message message
     * @param locale locale
     */
    public HammerException(String message, Locale locale) {
        super(message, locale);
    }

    /**
     * Instantiates a new hammer exception.
     *
     * @param message message
     * @param locale locale
     * @param ex ex
     * @param args args
     */
    public HammerException(String message, Locale locale, Throwable ex, Object... args) {
        super(message, args, locale, ex);
    }

    /**
     * Instantiates a new hammer exception.
     *
     * @param message message
     * @param locale locale
     * @param args args
     */
    public HammerException(String message, Locale locale, Object... args) {
        super(message, args, locale);
    }

    /**
     * Instantiates a new hammer exception.
     *
     * @param message message
     * @param ex ex
     * @param args args
     */
    public HammerException(String message, Throwable ex, Object... args) {
        super(message, args, ex);
    }

    /**
     * Instantiates a new hammer exception.
     *
     * @param message message
     * @param args args
     */
    public HammerException(String message, Object... args) {
        super(message, args);
    }

    /**
     * Instantiates a new hammer exception.
     *
     * @param message message
     * @param ex ex
     */
    public HammerException(String message, Throwable ex) {
        super(message, ex);
    }

    /**
     * Instantiates a new hammer exception.
     *
     * @param message message
     */
    public HammerException(String message) {
        super(message);
    }

    /**
     * Instantiates a new hammer exception.
     *
     * @param ex ex
     */
    public HammerException(Throwable ex) {
        super(ex);
    }

}
