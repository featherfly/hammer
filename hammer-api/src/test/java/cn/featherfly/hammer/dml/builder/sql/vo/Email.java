package cn.featherfly.hammer.dml.builder.sql.vo;

/**
 * Email.
 *
 * @author zhongj
 */
public class Email {

    private String name;

    private String host;

    /**
     */
    public Email() {
    }

    /**
     * @param name
     * @param host
     */
    public Email(String name, String host) {
        super();
        this.name = name;
        this.host = host;
    }

    /**
     * get name value
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * set name value
     *
     * @param name name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * get host value
     *
     * @return host
     */
    public String getHost() {
        return host;
    }

    /**
     * set host value
     *
     * @param host host
     */
    public void setHost(String host) {
        this.host = host;
    }
}
