package cn.featherfly.hammer.sqldb.jdbc.vo.s;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * UserInfo.
 *
 * @author zhongj
 */
@Table(name = "user_info")
public class UserInfo2 {

    @Id
    private Integer id;

    private String name;

    private String descp;

    @Column(name = "user_id")
    private Long userId;

    private String city;

    private String province;

    private String district;

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
     * get descp value
     *
     * @return descp
     */
    public String getDescp() {
        return descp;
    }

    /**
     * set descp value
     *
     * @param descp descp
     */
    public void setDescp(String descp) {
        this.descp = descp;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * get city value
     *
     * @return city
     */
    public String getCity() {
        return city;
    }

    /**
     * set city value
     *
     * @param city city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * get province value
     *
     * @return province
     */
    public String getProvince() {
        return province;
    }

    /**
     * set province value
     *
     * @param province province
     */
    public void setProvince(String province) {
        this.province = province;
    }

    /**
     * get district value
     *
     * @return district
     */
    public String getDistrict() {
        return district;
    }

    /**
     * set district value
     *
     * @param district district
     */
    public void setDistrict(String district) {
        this.district = district;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "UserInfo2 [id=" + id + ", name=" + name + ", descp=" + descp + ", userId=" + userId + ", city=" + city
                + ", province=" + province + ", district=" + district + "]";
    }

}
