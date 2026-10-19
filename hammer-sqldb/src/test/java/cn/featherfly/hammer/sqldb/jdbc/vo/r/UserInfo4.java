
package cn.featherfly.hammer.sqldb.jdbc.vo.r;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * UserInfo.
 *
 * @author zhongj
 */
@Table(name = "user_info")
public class UserInfo4 {

    @Id
    private Integer id;

    private String name;

    private String descp;

    @ManyToOne
    //@OneToOne
    @Column(name = "user_id")
    private User user;

    @Embedded
    @Valid
    private DistrictDivision division;

    @Embedded
    private Address address;

    /**
     */
    public UserInfo4() {
    }

    /**
     * @param id
     */
    public UserInfo4(Integer id) {
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
     * get address value
     *
     * @return address
     */
    public Address getAddress() {
        return address;
    }

    /**
     * set address value
     *
     * @param address address
     */
    public void setAddress(Address address) {
        this.address = address;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "UserInfo [id=" + id + ", name=" + name + ", descp=" + descp + ", user=" + user + ", division="
            + division + ", address=" + address + "]";
    }

    public static class DistrictDivision implements Serializable {

        private static final long serialVersionUID = -7643332722392401960L;

        @Column
        @Size(max = 20)
        @NotNull
        private String city;

        @Size(max = 20)
        private String province;

        @Size(max = 20)
        private String district;

        /**
         */
        public DistrictDivision() {
        }

        /**
         * @param province
         * @param city
         * @param district
         */
        public DistrictDivision(String province, String city, String district) {
            super();
            this.city = city;
            this.province = province;
            this.district = district;
        }

        /**
         * 返回city
         *
         * @return city
         */
        public String getCity() {
            return city;
        }

        /**
         * 设置city
         *
         * @param city city
         */
        public void setCity(String city) {
            this.city = city;
        }

        /**
         * 返回province
         *
         * @return province
         */
        public String getProvince() {
            return province;
        }

        /**
         * 设置province
         *
         * @param province province
         */
        public void setProvince(String province) {
            this.province = province;
        }

        /**
         * 返回district
         *
         * @return district
         */
        public String getDistrict() {
            return district;
        }

        /**
         * 设置district
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
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + (city == null ? 0 : city.hashCode());
            result = prime * result + (district == null ? 0 : district.hashCode());
            result = prime * result + (province == null ? 0 : province.hashCode());
            return result;
        }

        /**
         * {@inheritDoc}
         */
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
            DistrictDivision other = (DistrictDivision) obj;
            if (city == null) {
                if (other.city != null) {
                    return false;
                }
            } else if (!city.equals(other.city)) {
                return false;
            }
            if (district == null) {
                if (other.district != null) {
                    return false;
                }
            } else if (!district.equals(other.district)) {
                return false;
            }
            if (province == null) {
                if (other.province != null) {
                    return false;
                }
            } else if (!province.equals(other.province)) {
                return false;
            }
            return true;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public String toString() {
            return "DistrictDivision [city=" + city + ", province=" + province + ", district=" + district + "]";
        }
    }

}
