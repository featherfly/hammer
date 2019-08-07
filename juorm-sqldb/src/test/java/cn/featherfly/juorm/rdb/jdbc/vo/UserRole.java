
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
public class UserRole {

    @Id
    private Integer userId;
    @Id
    private Integer roleId;

    private String descp;

    /**
     * 返回userId
     *
     * @return userId
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 设置userId
     *
     * @param userId userId
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 返回roleId
     *
     * @return roleId
     */
    public Integer getRoleId() {
        return roleId;
    }

    /**
     * 设置roleId
     *
     * @param roleId roleId
     */
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
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
        return "UserRole [userId=" + userId + ", roleId=" + roleId + ", descp=" + descp + "]";
    }

}
