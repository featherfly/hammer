
package cn.featherfly.juorm.sqldb.jdbc;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertNull;

import org.testng.annotations.Test;

import cn.featherfly.common.lang.RandomUtils;
import cn.featherfly.juorm.sqldb.jdbc.operate.DeleteOperate;
import cn.featherfly.juorm.sqldb.jdbc.operate.GetOperate;
import cn.featherfly.juorm.sqldb.jdbc.operate.InsertOperate;
import cn.featherfly.juorm.sqldb.jdbc.operate.UpdateOperate;
import cn.featherfly.juorm.sqldb.jdbc.vo.Role;
import cn.featherfly.juorm.sqldb.jdbc.vo.UserRole;

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
        InsertOperate<Role> insert = new InsertOperate<>(jdbc, mappingFactory.getClassMapping(Role.class),
                mappingFactory.getMetadata());
        DeleteOperate<Role> delete = new DeleteOperate<>(jdbc, mappingFactory.getClassMapping(Role.class),
                mappingFactory.getMetadata());
        GetOperate<Role> get = new GetOperate<>(jdbc, mappingFactory.getClassMapping(Role.class),
                mappingFactory.getMetadata());

        Role r = role();
        insert.execute(r);
        assertNotNull(r.getId());
        delete.execute(r);
        Role role = get.get(r);
        assertNull(role);

        r = role();
        insert.execute(r);
        assertNotNull(r.getId());
        delete.execute(r);
        role = get.get(r);
        assertNull(role);
    }

    @Test
    public void testInsertMultyKey() {
        InsertOperate<UserRole> insert = new InsertOperate<>(jdbc, mappingFactory.getClassMapping(UserRole.class),
                mappingFactory.getMetadata());
        DeleteOperate<UserRole> delete = new DeleteOperate<>(jdbc, mappingFactory.getClassMapping(UserRole.class),
                mappingFactory.getMetadata());
        GetOperate<UserRole> get = new GetOperate<>(jdbc, mappingFactory.getClassMapping(UserRole.class),
                mappingFactory.getMetadata());
        UserRole ur = new UserRole();
        ur.setUserId(123);
        ur.setRoleId(321);
        ur.setDescp("descp_123_321");
        insert.execute(ur);

        UserRole userRole = get.get(ur);
        assertNotNull(userRole);
        assertNull(userRole.getDescp2());
        assertEquals(userRole.getUserId(), ur.getUserId());
        assertEquals(userRole.getRoleId(), ur.getRoleId());
        assertEquals(userRole.getDescp(), ur.getDescp());

        delete.execute(userRole);

        userRole = get.get(ur);
        assertNull(userRole);
    }

    @Test
    public void testUpdate() {
        UpdateOperate<Role> update = new UpdateOperate<>(jdbc, mappingFactory.getClassMapping(Role.class),
                mappingFactory.getMetadata());
        GetOperate<Role> get = new GetOperate<>(jdbc, mappingFactory.getClassMapping(Role.class),
                mappingFactory.getMetadata());
        Role r = new Role();
        r.setId(10);
        r.setName("name_update_" + RandomUtils.getRandomInt(99));
        r.setDescp("descp_update_" + RandomUtils.getRandomInt(99));
        update.execute(r);

        Role role = get.get(r);
        assertNotNull(role);
        assertEquals(role.getId(), r.getId());
        assertEquals(role.getName(), r.getName());
        assertEquals(role.getDescp(), r.getDescp());
    }

    @Test
    public void testUpdateMulityPrimaryKey() {
        UpdateOperate<UserRole> update = new UpdateOperate<>(jdbc, mappingFactory.getClassMapping(UserRole.class),
                mappingFactory.getMetadata());
        GetOperate<UserRole> get = new GetOperate<>(jdbc, mappingFactory.getClassMapping(UserRole.class),
                mappingFactory.getMetadata());

        UserRole userRole = new UserRole();
        userRole.setRoleId(3);
        userRole.setUserId(3);
        userRole.setDescp("descp_update_" + RandomUtils.getRandomInt(99));
        userRole.setDescp2("descp2_update_" + RandomUtils.getRandomInt(99));
        update.execute(userRole);

        UserRole ur = get.get(userRole);

        assertEquals(ur.getUserId(), userRole.getUserId());
        assertEquals(ur.getRoleId(), userRole.getRoleId());
        assertEquals(ur.getDescp(), userRole.getDescp());
        assertEquals(ur.getDescp2(), userRole.getDescp2());
    }

    @Test
    public void testGet() {
        GetOperate<Role> operate = new GetOperate<>(jdbc, mappingFactory.getClassMapping(Role.class),
                mappingFactory.getMetadata());
        Integer id = 1;
        Role role = operate.get(id);
        assertEquals(role.getId(), id);
        assertNotNull(role.getName());
        assertNotNull(role.getDescp());
        assertEquals(role.getName(), "n_1");
        assertEquals(role.getDescp(), "descp_1");
    }

    @Test
    public void testGetMulityPrimaryKey() {
        GetOperate<UserRole> operate = new GetOperate<>(jdbc, mappingFactory.getClassMapping(UserRole.class),
                mappingFactory.getMetadata());
        UserRole userRole = new UserRole();
        Integer roleId = 2;
        Integer userId = 2;
        userRole.setRoleId(roleId);
        userRole.setUserId(userId);

        UserRole ur = operate.get(userRole);

        assertEquals(ur.getUserId(), userRole.getUserId());
        assertEquals(ur.getUserId(), userRole.getRoleId());
        assertNotNull(ur.getDescp());
    }

    @Test
    public void testDelete() {
        DeleteOperate<Role> delete = new DeleteOperate<>(jdbc, mappingFactory.getClassMapping(Role.class),
                mappingFactory.getMetadata());
        InsertOperate<Role> insert = new InsertOperate<>(jdbc, mappingFactory.getClassMapping(Role.class),
                mappingFactory.getMetadata());
        GetOperate<Role> get = new GetOperate<>(jdbc, mappingFactory.getClassMapping(Role.class),
                mappingFactory.getMetadata());
        Role r = new Role();
        insert.execute(r);
        assertNotNull(r.getId());
        delete.execute(r);

        Role role = get.get(r);
        assertNull(role);
    }

    @Test
    public void testDeleteMulityPrimaryKey() {
        DeleteOperate<UserRole> delete = new DeleteOperate<>(jdbc, mappingFactory.getClassMapping(UserRole.class),
                mappingFactory.getMetadata());
        InsertOperate<UserRole> insert = new InsertOperate<>(jdbc, mappingFactory.getClassMapping(UserRole.class),
                mappingFactory.getMetadata());
        GetOperate<UserRole> get = new GetOperate<>(jdbc, mappingFactory.getClassMapping(UserRole.class),
                mappingFactory.getMetadata());
        UserRole userRole = new UserRole();
        userRole.setRoleId(111);
        userRole.setUserId(111);

        UserRole ur = get.get(userRole);
        if (ur == null) {
            insert.execute(userRole);
        }
        delete.execute(userRole);

        ur = get.get(userRole);
        assertNull(ur);
    }

}
