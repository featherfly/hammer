
package cn.featherfly.juorm.rdb.jdbc.vo;

import javax.persistence.Id;
import javax.persistence.Table;

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

    private String username;

    private String password;

    private String mobileNo;

    private Integer age;

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
     * 返回password
     * 
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置password
     * 
     * @param password password
     */
    public void setPassword(String password) {
        this.password = password;
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
}
