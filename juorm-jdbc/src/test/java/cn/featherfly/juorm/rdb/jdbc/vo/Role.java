
package cn.featherfly.juorm.rdb.jdbc.vo;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * <p>
 * Role
 * </p>
 *
 * @author zhongj
 */
@Table
public class Role {

    @Id
    private Integer id;

    private String name;

    private String descp;

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
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "Role [id=" + id + ", name=" + name + ", descp=" + descp + "]";
    }

}
