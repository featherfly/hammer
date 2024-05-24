
package cn.featherfly.hammer.sqldb.jdbc.vo.r;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import cn.featherfly.common.repository.id.IdGeneratorManager;

/**
 * The Class UserRole.
 *
 * @author zhongj
 */
@Table
public class UserRole {

    @Id
    @GeneratedValue(generator = IdGeneratorManager.ASSIGN)
    private Integer userId;
    @Id
    @GeneratedValue(generator = IdGeneratorManager.ASSIGN)
    private Integer roleId;

    private String descp;

    private String descp2;

    /**
     * 返回userId.
     *
     * @return userId
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 设置userId.
     *
     * @param userId userId
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 返回roleId.
     *
     * @return roleId
     */
    public Integer getRoleId() {
        return roleId;
    }

    /**
     * 设置roleId.
     *
     * @param roleId roleId
     */
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    /**
     * 返回descp.
     *
     * @return descp
     */
    public String getDescp() {
        return descp;
    }

    /**
     * 设置descp.
     *
     * @param descp descp
     */
    public void setDescp(String descp) {
        this.descp = descp;
    }

    /**
     * 返回descp2.
     *
     * @return descp2
     */
    public String getDescp2() {
        return descp2;
    }

    /**
     * 设置descp2.
     *
     * @param descp2 descp2
     */
    public void setDescp2(String descp2) {
        this.descp2 = descp2;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "UserRole [userId=" + userId + ", roleId=" + roleId + ", descp=" + descp + ", descp2=" + descp2 + "]";
    }

}
