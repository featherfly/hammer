
package cn.featherfly.juorm.rdb.jdbc;

import org.testng.annotations.Test;

import cn.featherfly.juorm.rdb.jdbc.operate.DeleteOperate;
import cn.featherfly.juorm.rdb.jdbc.vo.Role;
import cn.featherfly.juorm.rdb.jdbc.vo.UserRole;

/**
 * <p>
 * OperatorTest
 * </p>
 *
 * @author zhongj
 */
public class OperatorTest extends JdbcTestBase {

    @Test
    public void testDelete() {
        DeleteOperate<Role> delete = new DeleteOperate<>(jdbc, factory.getClassMapping(Role.class));
        Role r = new Role();
        r.setId(1);
        delete.execute(r);
    }

    @Test
    public void testMulityPrimaryKeyDelete() {
        DeleteOperate<UserRole> delete = new DeleteOperate<>(jdbc, factory.getClassMapping(UserRole.class));
        UserRole userRole = new UserRole();
        userRole.setRoleId(1);
        userRole.setUserId(1);
        delete.execute(userRole);
    }

}
