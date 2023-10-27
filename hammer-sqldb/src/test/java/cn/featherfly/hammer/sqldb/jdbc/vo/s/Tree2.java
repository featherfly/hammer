
package cn.featherfly.hammer.sqldb.jdbc.vo.s;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The Class Tree.
 *
 * @author zhongj
 */
@Table(name = "tree")
public class Tree2 {

    @Id
    private Integer id;

    @Column
    private String name;

    private Integer parentId;

    /**
     * 返回id.
     *
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置id.
     *
     * @param id id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 返回name.
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置name.
     *
     * @param name name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 返回parentId.
     *
     * @return parentId
     */
    public Integer getParentId() {
        return parentId;
    }

    /**
     * 设置parentId.
     *
     * @param parentId parentId
     */
    public void setParentId(Integer parentId) {
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
