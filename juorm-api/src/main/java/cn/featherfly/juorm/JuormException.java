
package cn.featherfly.juorm;

import java.util.Locale;

import cn.featherfly.common.exception.LocalizedException;

/**
 * <p>
 * Juorm base Exception
 * </p>
 * 
 * @author zhongj
 */
public abstract class JuormException extends LocalizedException {

    /**
     * 
     */
    private static final long serialVersionUID = -9019711912180497707L;

    /**
     * 
     */
    public JuormException() {
        super();
    }

    /**
     * @param message
     * @param locale
     * @param ex
     */
    public JuormException(String message, Locale locale, Throwable ex) {
        super(message, locale, ex);
    }

    /**
     * @param message
     * @param locale
     */
    public JuormException(String message, Locale locale) {
        super(message, locale);
    }

    /**
     * @param message
     * @param args
     * @param locale
     * @param ex
     */
    public JuormException(String message, Object[] args, Locale locale, Throwable ex) {
        super(message, args, locale, ex);
    }

    /**
     * @param message
     * @param args
     * @param locale
     */
    public JuormException(String message, Object[] args, Locale locale) {
        super(message, args, locale);
    }

    /**
     * @param message
     * @param args
     * @param ex
     */
    public JuormException(String message, Object[] args, Throwable ex) {
        super(message, args, ex);
    }

    /**
     * @param message
     * @param args
     */
    public JuormException(String message, Object[] args) {
        super(message, args);
    }

    /**
     * @param message
     * @param ex
     */
    public JuormException(String message, Throwable ex) {
        super(message, ex);
    }

    /**
     * @param message
     */
    public JuormException(String message) {
        super(message);
    }

    /**
     * @param ex
     */
    public JuormException(Throwable ex) {
        super(ex);
    }

}
