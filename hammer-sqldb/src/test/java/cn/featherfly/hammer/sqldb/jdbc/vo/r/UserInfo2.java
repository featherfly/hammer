
package cn.featherfly.hammer.sqldb.jdbc.vo.r;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * <p>
 * User
 * </p>
 *
 * @author zhongj
 */
@Table(name = "user_info")
public class UserInfo2 {

    @Id
    private Long id;

    private String name;

    private String descp;

    @ManyToOne
    //@OneToOne
    @Column(name = "user_id")
    private User user;

    @Embedded
    private DistrictDivision division;

    /**
     * 返回id
     *
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置id
     *
     * @param id id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 返回name
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置name
     *
     * @param name name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 返回descp
     *
     * @return descp
     */
    public String getDescp() {
        return descp;
    }

    /**
     * 设置descp
     *
     * @param descp descp
     */
    public void setDescp(String descp) {
        this.descp = descp;
    }

    /**
     * 返回user
     *
     * @return user
     */
    public User getUser() {
        return user;
    }

    /**
     * 设置user
     *
     * @param user user
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * 返回division
     *
     * @return division
     */
    public DistrictDivision getDivision() {
        return division;
    }

    /**
     * 设置division
     *
     * @param division division
     */
    public void setDivision(DistrictDivision division) {
        this.division = division;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "UserInfo [id=" + id + ", name=" + name + ", descp=" + descp + ", user=" + user + ", division="
                + division + "]";
    }
}
