
package cn.featherfly.db.dsl;

import java.util.Locale;

import cn.featherfly.common.exception.LocalizedException;

/**
 * <p>
 * DSLException
 * </p>
 * 
 * @author zhongj
 */
public class DSLException extends LocalizedException {

    /**
     * 
     */
    private static final long serialVersionUID = -9019711912180497707L;

    /**
     * 
     */
    public DSLException() {
        super();
    }

    /**
     * @param message
     * @param locale
     * @param ex
     */
    public DSLException(String message, Locale locale, Throwable ex) {
        super(message, locale, ex);
    }

    /**
     * @param message
     * @param locale
     */
    public DSLException(String message, Locale locale) {
        super(message, locale);
    }

    /**
     * @param message
     * @param args
     * @param locale
     * @param ex
     */
    public DSLException(String message, Object[] args, Locale locale, Throwable ex) {
        super(message, args, locale, ex);
    }

    /**
     * @param message
     * @param args
     * @param locale
     */
    public DSLException(String message, Object[] args, Locale locale) {
        super(message, args, locale);
    }

    /**
     * @param message
     * @param args
     * @param ex
     */
    public DSLException(String message, Object[] args, Throwable ex) {
        super(message, args, ex);
    }

    /**
     * @param message
     * @param args
     */
    public DSLException(String message, Object[] args) {
        super(message, args);
    }

    /**
     * @param message
     * @param ex
     */
    public DSLException(String message, Throwable ex) {
        super(message, ex);
    }

    /**
     * @param message
     */
    public DSLException(String message) {
        super(message);
    }

    /**
     * @param ex
     */
    public DSLException(Throwable ex) {
        super(ex);
    }

}
