
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
     * Instantiates a new tpl exception.
     *
     * @param message the message
     * @param locale  the locale
     * @param ex      the ex
     */
    public TplException(String message, Locale locale, Throwable ex) {
        super(message, locale, ex);
    }

    /**
     * Instantiates a new tpl exception.
     *
     * @param message the message
     * @param locale  the locale
     */
    public TplException(String message, Locale locale) {
        super(message, locale);
    }

    /**
     * Instantiates a new tpl exception.
     *
     * @param message the message
     * @param args    the args
     * @param locale  the locale
     * @param ex      the ex
     */
    public TplException(String message, Object[] args, Locale locale, Throwable ex) {
        super(message, args, locale, ex);
    }

    /**
     * Instantiates a new tpl exception.
     *
     * @param message the message
     * @param args    the args
     * @param locale  the locale
     */
    public TplException(String message, Object[] args, Locale locale) {
        super(message, args, locale);
    }

    /**
     * Instantiates a new tpl exception.
     *
     * @param message the message
     * @param args    the args
     * @param ex      the ex
     */
    public TplException(String message, Object[] args, Throwable ex) {
        super(message, args, ex);
    }

    /**
     * Instantiates a new tpl exception.
     *
     * @param message the message
     * @param args    the args
     */
    public TplException(String message, Object[] args) {
        super(message, args);
    }

    /**
     * Instantiates a new tpl exception.
     *
     * @param message the message
     * @param ex      the ex
     */
    public TplException(String message, Throwable ex) {
        super(message, ex);
    }

    /**
     * Instantiates a new tpl exception.
     *
     * @param message the message
     */
    public TplException(String message) {
        super(message);
    }

    /**
     * Instantiates a new tpl exception.
     *
     * @param ex the ex
     */
    public TplException(Throwable ex) {
        super(ex);
    }
}
