
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

    private Integer roleId;

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
}
