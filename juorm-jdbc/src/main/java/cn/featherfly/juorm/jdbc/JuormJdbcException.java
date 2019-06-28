
package cn.featherfly.juorm.jdbc;

import java.util.Locale;

import cn.featherfly.juorm.JuormException;

/**
 * <p>
 * JuormJdbcException
 * </p>
 *
 * @author zhongj
 */
public class JuormJdbcException extends JuormException {

    private static final long serialVersionUID = 6788081346324738442L;

    /**
     *
     */
    public JuormJdbcException() {
        super();
    }

    /**
     * @param message
     * @param locale
     * @param ex
     */
    public JuormJdbcException(String message, Locale locale, Throwable ex) {
        super(message, locale, ex);
    }

    /**
     * @param message
     * @param locale
     */
    public JuormJdbcException(String message, Locale locale) {
        super(message, locale);
    }

    /**
     * @param message
     * @param args
     * @param locale
     * @param ex
     */
    public JuormJdbcException(String message, Object[] args, Locale locale, Throwable ex) {
        super(message, args, locale, ex);
    }

    /**
     * @param message
     * @param args
     * @param locale
     */
    public JuormJdbcException(String message, Object[] args, Locale locale) {
        super(message, args, locale);
    }

    /**
     * @param message
     * @param args
     * @param ex
     */
    public JuormJdbcException(String message, Object[] args, Throwable ex) {
        super(message, args, ex);
    }

    /**
     * @param message
     * @param args
     */
    public JuormJdbcException(String message, Object[] args) {
        super(message, args);
    }

    /**
     * @param message
     * @param ex
     */
    public JuormJdbcException(String message, Throwable ex) {
        super(message, ex);
    }

    /**
     * @param message
     */
    public JuormJdbcException(String message) {
        super(message);
    }

    /**
     * @param ex
     */
    public JuormJdbcException(Throwable ex) {
        super(ex);
    }
}
