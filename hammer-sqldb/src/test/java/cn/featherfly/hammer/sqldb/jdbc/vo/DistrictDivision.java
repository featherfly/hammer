
package cn.featherfly.hammer.sqldb.jdbc.vo;

import javax.persistence.Column;

/**
 * <p>
 * DistrictDivision
 * </p>
 *
 * @author zhongj
 */
public class DistrictDivision {

    @Column
    private String city;

    private String province;

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
