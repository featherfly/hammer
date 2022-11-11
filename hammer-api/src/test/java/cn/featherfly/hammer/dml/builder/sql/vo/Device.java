package cn.featherfly.hammer.dml.builder.sql.vo;

import javax.persistence.ManyToOne;

/**
 * @author zhongj
 */
public class Device {

    private int id;

    private String code;

    @ManyToOne
    private User user;

    /**
     * get id value
     *
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * set id value
     *
     * @param id id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * get code value
     *
     * @return code
     */
    public String getCode() {
        return code;
    }

    /**
     * set code value
     *
     * @param code code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * get user value
     *
     * @return user
     */
    public User getUser() {
        return user;
    }

    /**
     * set user value
     *
     * @param user user
     */
    public void setUser(User user) {
        this.user = user;
    }
}
