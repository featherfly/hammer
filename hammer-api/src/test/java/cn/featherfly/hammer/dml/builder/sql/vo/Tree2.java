
package cn.featherfly.hammer.dml.builder.sql.vo;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author zhongj
 */
@Table(name = "tree")
public class Tree2 {

    @Id
    private Integer id;

    private String name;

    private Integer parentId;

    private Integer userId;

    /**
     */
    public Tree2() {
    }

    /**
     * @param id
     */
    public Tree2(Integer id) {
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
     * get parentId value
     *
     * @return parentId
     */
    public Integer getParentId() {
        return parentId;
    }

    /**
     * set parentId value
     *
     * @param parentId parentId
     */
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    /**
     * get userId value
     *
     * @return userId
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * set userId value
     *
     * @param userId userId
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "Tree [id=" + id + ", name=" + name + ", parentId=" + parentId + ", userId=" + userId + "]";
    }
}
