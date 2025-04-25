
package cn.featherfly.hammer;

import java.util.Locale;

/**
 * hammer validate exception.
 *
 * @author zhongj
 */
public class HammerValidateException extends HammerException {

    private static final long serialVersionUID = 5804112221375517754L;

    /**
     * @param message message
     * @param locale locale
     * @param ex ex
     */
    public HammerValidateException(String message, Locale locale, Throwable ex) {
        super(message, locale, ex);
    }

    /**
     * @param message message
     * @param locale locale
     */
    public HammerValidateException(String message, Locale locale) {
        super(message, locale);
    }

    /**
     * @param message message
     * @param args args
     * @param locale locale
     * @param ex ex
     */
    public HammerValidateException(String message, Object[] args, Locale locale, Throwable ex) {
        super(message, args, locale, ex);
    }

    /**
     * @param message message
     * @param args args
     * @param locale locale
     */
    public HammerValidateException(String message, Object[] args, Locale locale) {
        super(message, args, locale);
    }

    /**
     * @param message message
     * @param args args
     * @param ex ex
     */
    public HammerValidateException(String message, Object[] args, Throwable ex) {
        super(message, args, ex);
    }

    /**
     * @param message message
     * @param args args
     */
    public HammerValidateException(String message, Object[] args) {
        super(message, args);
    }

    /**
     * @param message message
     * @param ex ex
     */
    public HammerValidateException(String message, Throwable ex) {
        super(message, ex);
    }

    /**
     * @param message message
     */
    public HammerValidateException(String message) {
        super(message);
    }

    /**
     * @param ex ex
     */
    public HammerValidateException(Throwable ex) {
        super(ex);
    }

}
