
package cn.featherfly.hammer.sqldb.jdbc.vo.r;

import javax.persistence.Column;

/**
 * Address.
 *
 * @author zhongj
 */
public class Address {

    @Column
    private String street;

    @Column
    private Integer streetNo;

    /**
     */
    public Address() {
    }

    /**
     * @param street
     * @param streetNo
     */
    public Address(String street, Integer streetNo) {
        super();
        this.street = street;
        this.streetNo = streetNo;
    }

    /**
     * get street value
     *
     * @return street
     */
    public String getStreet() {
        return street;
    }

    /**
     * set street value
     *
     * @param street street
     */
    public void setStreet(String street) {
        this.street = street;
    }

    /**
     * get streetNo value
     *
     * @return streetNo
     */
    public Integer getStreetNo() {
        return streetNo;
    }

    /**
     * set streetNo value
     *
     * @param streetNo streetNo
     */
    public void setStreetNo(Integer streetNo) {
        this.streetNo = streetNo;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "Address [street=" + street + ", streetNo=" + streetNo + "]";
    }
}
