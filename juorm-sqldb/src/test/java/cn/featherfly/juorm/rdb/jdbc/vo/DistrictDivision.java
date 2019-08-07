
package cn.featherfly.juorm.rdb.jdbc.vo;

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
    public String toString() {
        return "DistrictDivision [city=" + city + ", province=" + province + ", district=" + district + "]";
    }
}
