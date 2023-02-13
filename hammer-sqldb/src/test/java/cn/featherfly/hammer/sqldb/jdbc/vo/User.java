
package cn.featherfly.hammer.sqldb.jdbc.vo;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * <p>
 * User
 * </p>
 *
 * @author zhongj
 */
@Table
public class User {

    @Id
    private Integer id;

    @NotNull
    private String username;

    @Column(name = "password")
    private String pwd;

    private String mobileNo;

    private Integer age;

    /**
     */
    public User() {
    }

    /**
     * @param id
     */
    public User(Integer id) {
        super();
        this.id = id;
    }

    /**
     * 返回id
     *
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置id
     *
     * @param id id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 返回username
     *
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置username
     *
     * @param username username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 返回pwd
     *
     * @return pwd
     */
    public String getPwd() {
        return pwd;
    }

    /**
     * 设置pwd
     *
     * @param pwd pwd
     */
    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    /**
     * 返回mobileNo
     *
     * @return mobileNo
     */
    public String getMobileNo() {
        return mobileNo;
    }

    /**
     * 设置mobileNo
     *
     * @param mobileNo mobileNo
     */
    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    /**
     * 返回age
     *
     * @return age
     */
    public Integer getAge() {
        return age;
    }

    /**
     * 设置age
     *
     * @param age age
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "User [id=" + id + ", username=" + username + ", pwd=" + pwd + ", mobileNo=" + mobileNo + ", age=" + age
                + "]";
    }
}
