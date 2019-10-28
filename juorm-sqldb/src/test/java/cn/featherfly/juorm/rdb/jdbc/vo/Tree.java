
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
public class Tree {

    @Id
    private Integer id;

    private String name;

    private String parentId;

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
     * 返回parentId
     *
     * @return parentId
     */
    public String getParentId() {
        return parentId;
    }

    /**
     * 设置parentId
     *
     * @param parentId parentId
     */
    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "Tree [id=" + id + ", name=" + name + ", parentId=" + parentId + "]";
    }
}
