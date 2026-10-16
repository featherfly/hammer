
package cn.featherfly.hammer.sqldb.jdbc.vo.s;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Role2.
 *
 * @author zhongj
 */
@Table(name = "role")
public class Role2 implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1855485992632760028L;

    @Id
    private Integer id;

    @NotBlank
    @Size(max = 20)
    private String name;

    private String descp;

    @NotNull
    @Column(name = "create_time", updatable = false)
    private LocalDateTime createTime;

    @NotNull
    @Column(name = "update_time", insertable = false)
    private LocalDateTime updateTime;

    /**
     */
    public Role2() {
    }

    /**
     * @param id
     */
    public Role2(Integer id) {
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
     * get createTime value
     *
     * @return createTime
     */
    public LocalDateTime getCreateTime() {
        return createTime;
    }

    /**
     * set createTime value
     *
     * @param createTime createTime
     */
    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "Role2 [id=" + id + ", name=" + name + ", descp=" + descp + ", createTime=" + createTime
            + ", updateTime=" + updateTime + "]";
    }
}
