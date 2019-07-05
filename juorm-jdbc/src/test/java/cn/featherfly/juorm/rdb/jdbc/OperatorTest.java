
package cn.featherfly.juorm.rdb.jdbc;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import org.testng.annotations.Test;

import cn.featherfly.common.lang.RandomUtils;
import cn.featherfly.juorm.rdb.jdbc.operate.DeleteOperate;
import cn.featherfly.juorm.rdb.jdbc.operate.GetOperate;
import cn.featherfly.juorm.rdb.jdbc.operate.InsertOperate;
import cn.featherfly.juorm.rdb.jdbc.operate.UpdateOperate;
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
    public void testInsert() {
        InsertOperate<Role> operate = new InsertOperate<>(jdbc, factory.getClassMapping(Role.class));
        Role r = role();
        operate.execute(r);
        assertNotNull(r.getId());

        r = role();
        operate.execute(r);
        assertNotNull(r.getId());
    }

    @Test
    public void testInsertMultyKey() {
        InsertOperate<UserRole> operate = new InsertOperate<>(jdbc, factory.getClassMapping(UserRole.class));
        UserRole ur = new UserRole();
        ur.setUserId(11);
        ur.setRoleId(11);
        ur.setDescp("descp1111");
        operate.execute(ur);
    }

    @Test
    public void testUpdate() {
        UpdateOperate<Role> operate = new UpdateOperate<>(jdbc, factory.getClassMapping(Role.class));
        Role r = new Role();
        r.setId(2);
        r.setName("n_c" + RandomUtils.getRandomInt(100));
        r.setDescp("d_c" + RandomUtils.getRandomInt(100));
        operate.execute(r);
    }

    @Test
    public void testUpdateMulityPrimaryKey() {
        UpdateOperate<UserRole> operate = new UpdateOperate<>(jdbc, factory.getClassMapping(UserRole.class));
        UserRole userRole = new UserRole();
        userRole.setRoleId(2);
        userRole.setUserId(2);
        userRole.setDescp("descp_c" + RandomUtils.getRandomInt(99));
        operate.execute(userRole);
    }

    @Test
    public void testGet() {
        GetOperate<Role> operate = new GetOperate<>(jdbc, factory.getClassMapping(Role.class));
        Integer id = 2;
        Role role = operate.get(id);
        assertEquals(role.getId(), id);
        assertNotNull(role.getName());
        System.out.println(role);
    }

    @Test
    public void testGetMulityPrimaryKey() {
        GetOperate<UserRole> operate = new GetOperate<>(jdbc, factory.getClassMapping(UserRole.class));
        UserRole userRole = new UserRole();
        Integer roleId = 2;
        Integer userId = 2;
        userRole.setRoleId(roleId);
        userRole.setUserId(userId);

        UserRole ur = operate.get(userRole);

        assertEquals(ur.getUserId(), userRole.getUserId());
        assertEquals(ur.getUserId(), userRole.getRoleId());
        assertNotNull(ur.getDescp());
        System.out.println(ur);
    }

    @Test
    public void testDelete() {
        DeleteOperate<Role> operate = new DeleteOperate<>(jdbc, factory.getClassMapping(Role.class));
        Role r = new Role();
        r.setId(1);
        operate.execute(r);
    }

    @Test
    public void testDeleteMulityPrimaryKey() {
        DeleteOperate<UserRole> operate = new DeleteOperate<>(jdbc, factory.getClassMapping(UserRole.class));
        UserRole userRole = new UserRole();
        userRole.setRoleId(11);
        userRole.setUserId(11);
        operate.execute(userRole);
    }

}
