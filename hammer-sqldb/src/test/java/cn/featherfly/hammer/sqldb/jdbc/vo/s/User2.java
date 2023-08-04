package cn.featherfly.hammer.sqldb.jdbc.vo.s;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * User.
 *
 * @author zhongj
 */
@Table(name = "user")
public class User2 {

    @Id
    private Integer id;

    private String username;

    @Column(name = "password")
    private String pwd;

    private String mobileNo;

    private Integer age;

    /**
     * get id value
     *
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * set id value
     *
     * @param id id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * get username value
     *
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * set username value
     *
     * @param username username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * get pwd value
     *
     * @return pwd
     */
    public String getPwd() {
        return pwd;
    }

    /**
     * set pwd value
     *
     * @param pwd pwd
     */
    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    /**
     * get mobileNo value
     *
     * @return mobileNo
     */
    public String getMobileNo() {
        return mobileNo;
    }

    /**
     * set mobileNo value
     *
     * @param mobileNo mobileNo
     */
    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    /**
     * get age value
     *
     * @return age
     */
    public Integer getAge() {
        return age;
    }

    /**
     * set age value
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
        return "User2 [id=" + id + ", username=" + username + ", pwd=" + pwd + ", mobileNo=" + mobileNo + ", age=" + age
                + "]";
    }

}
