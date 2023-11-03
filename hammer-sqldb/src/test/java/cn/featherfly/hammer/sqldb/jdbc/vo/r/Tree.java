
package cn.featherfly.hammer.sqldb.jdbc.vo.r;

import java.io.Serializable;

import javax.persistence.Column;
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
@Table(name = "tree")
public class Tree implements Serializable {

    private static final long serialVersionUID = -6503051177156654302L;

    @Id
    private Integer id;

    private String name;

    /**
     */
    public Tree() {
    }

    /**
     * @param id
     */
    public Tree(Integer id) {
        super();
        this.id = id;
    }

    @Column(name = "parent_id")
    @ManyToOne
    private Tree parent;

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
     * 返回parent
     *
     * @return parent
     */
    public Tree getParent() {
        return parent;
    }

    /**
     * 设置parent
     *
     * @param parent parent
     */
    public void setParent(Tree parent) {
        this.parent = parent;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "Tree2 [id=" + id + ", name=" + name + ", parent=" + parent + "]";
    }

}
