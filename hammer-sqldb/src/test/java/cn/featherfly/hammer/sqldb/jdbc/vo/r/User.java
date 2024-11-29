
package cn.featherfly.hammer.sqldb.jdbc.vo.r;

import java.io.Serializable;

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
public class User implements Serializable {
    private static final long serialVersionUID = -9195202460437409669L;

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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (age == null ? 0 : age.hashCode());
        result = prime * result + (id == null ? 0 : id.hashCode());
        result = prime * result + (mobileNo == null ? 0 : mobileNo.hashCode());
        result = prime * result + (pwd == null ? 0 : pwd.hashCode());
        result = prime * result + (username == null ? 0 : username.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        User other = (User) obj;
        if (age == null) {
            if (other.age != null) {
                return false;
            }
        } else if (!age.equals(other.age)) {
            return false;
        }
        if (id == null) {
            if (other.id != null) {
                return false;
            }
        } else if (!id.equals(other.id)) {
            return false;
        }
        if (mobileNo == null) {
            if (other.mobileNo != null) {
                return false;
            }
        } else if (!mobileNo.equals(other.mobileNo)) {
            return false;
        }
        if (pwd == null) {
            if (other.pwd != null) {
                return false;
            }
        } else if (!pwd.equals(other.pwd)) {
            return false;
        }
        if (username == null) {
            if (other.username != null) {
                return false;
            }
        } else if (!username.equals(other.username)) {
            return false;
        }
        return true;
    }

}
