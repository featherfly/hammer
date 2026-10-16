
package cn.featherfly.hammer.tpl;

import java.util.Locale;

import cn.featherfly.hammer.HammerException;

/**
 * TplException .
 *
 * @author zhongj
 */
public class TplException extends HammerException {

    private static final long serialVersionUID = -7355845081437713114L;

    /**
     * Instantiates a new hammer validate exception.
     *
     * @param message message
     * @param locale locale
     * @param ex ex
     */
    public TplException(String message, Locale locale, Throwable ex) {
        super(message, locale, ex);
    }

    /**
     * Instantiates a new hammer validate exception.
     *
     * @param message message
     * @param locale locale
     */
    public TplException(String message, Locale locale) {
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
    public TplException(String message, Locale locale, Throwable ex, Object... args) {
        super(message, args, locale, ex);
    }

    /**
     * Instantiates a new hammer validate exception.
     *
     * @param message message
     * @param locale locale
     * @param args args
     */
    public TplException(String message, Locale locale, Object... args) {
        super(message, args, locale);
    }

    /**
     * Instantiates a new hammer validate exception.
     *
     * @param message message
     * @param ex ex
     * @param args args
     */
    public TplException(String message, Throwable ex, Object... args) {
        super(message, args, ex);
    }

    /**
     * Instantiates a new hammer validate exception.
     *
     * @param message message
     * @param args args
     */
    public TplException(String message, Object... args) {
        super(message, args);
    }

    /**
     * Instantiates a new hammer validate exception.
     *
     * @param message message
     * @param ex ex
     */
    public TplException(String message, Throwable ex) {
        super(message, ex);
    }

    /**
     * Instantiates a new hammer validate exception.
     *
     * @param message message
     */
    public TplException(String message) {
        super(message);
    }

    /**
     * Instantiates a new hammer validate exception.
     *
     * @param ex ex
     */
    public TplException(Throwable ex) {
        super(ex);
    }
}
