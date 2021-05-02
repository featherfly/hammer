
package cn.featherfly.hammer.sqldb.jdbc;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertNull;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import cn.featherfly.common.lang.Randoms;
import cn.featherfly.hammer.sqldb.jdbc.operate.DeleteOperate;
import cn.featherfly.hammer.sqldb.jdbc.operate.GetOperate;
import cn.featherfly.hammer.sqldb.jdbc.operate.InsertOperate;
import cn.featherfly.hammer.sqldb.jdbc.operate.UpdateOperate;
import cn.featherfly.hammer.sqldb.jdbc.vo.Role;
import cn.featherfly.hammer.sqldb.jdbc.vo.UserRole;

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
                mappingFactory.getSqlTypeMappingManager(), mappingFactory.getMetadata());
        DeleteOperate<Role> delete = new DeleteOperate<>(jdbc, mappingFactory.getClassMapping(Role.class),
                mappingFactory.getSqlTypeMappingManager(), mappingFactory.getMetadata());
        GetOperate<Role> get = new GetOperate<>(jdbc, mappingFactory.getClassMapping(Role.class),
                mappingFactory.getSqlTypeMappingManager(), mappingFactory.getMetadata());

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

    //    @Test
    //    public void t() {
    //        SqlExecutor executor = new SqlExecutor(jdbc.getDataSource());
    //        String sql = null;
    //        sql = "INSERT INTO `tree` SELECT null `id`, 'aba' `name`, 1 `parent_id` UNION SELECT null, 'abc1', 1";
    //        executor.execute(sql);
    //
    //        sql = "INSERT INTO `tree` SELECT ? `id`, ? `name`, ? `parent_id` UNION SELECT ?, ?, ?";
    //        executor.execute(sql, null, "name1", 1, null, "name2", 1);
    //
    //        sql = "INSERT INTO `role` SELECT ? AS `name`, ? AS `id`, ? AS `descp` UNION SELECT ?, ?, ?";
    //        executor.execute(sql, "yufei", null, "descp", "yi", null, "descp2");
    //    }

    @Test
    public void testInsertBatch() {
        InsertOperate<Role> insert = new InsertOperate<>(jdbc, mappingFactory.getClassMapping(Role.class),
                mappingFactory.getSqlTypeMappingManager(), mappingFactory.getMetadata());
        DeleteOperate<Role> delete = new DeleteOperate<>(jdbc, mappingFactory.getClassMapping(Role.class),
                mappingFactory.getSqlTypeMappingManager(), mappingFactory.getMetadata());
        GetOperate<Role> get = new GetOperate<>(jdbc, mappingFactory.getClassMapping(Role.class),
                mappingFactory.getSqlTypeMappingManager(), mappingFactory.getMetadata());

        List<Role> roles = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            roles.add(role());
        }
        int size = insert.executeBatch(roles);

        for (Role role : roles) {
            if (jdbc.getDialect().isAutoGenerateKeyBatch()) {
                Role r = get.get(role);
                assertEquals(r.getId(), role.getId());
                assertEquals(r.getName(), role.getName());
                delete.delete(role.getId());
            }
        }
        assertTrue(size == roles.size());

    }

    @Test
    public void testInsertMultyKey() {
        InsertOperate<UserRole> insert = new InsertOperate<>(jdbc, mappingFactory.getClassMapping(UserRole.class),
                mappingFactory.getSqlTypeMappingManager(), mappingFactory.getMetadata());
        DeleteOperate<UserRole> delete = new DeleteOperate<>(jdbc, mappingFactory.getClassMapping(UserRole.class),
                mappingFactory.getSqlTypeMappingManager(), mappingFactory.getMetadata());
        GetOperate<UserRole> get = new GetOperate<>(jdbc, mappingFactory.getClassMapping(UserRole.class),
                mappingFactory.getSqlTypeMappingManager(), mappingFactory.getMetadata());
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
                mappingFactory.getSqlTypeMappingManager(), mappingFactory.getMetadata());
        GetOperate<Role> get = new GetOperate<>(jdbc, mappingFactory.getClassMapping(Role.class),
                mappingFactory.getSqlTypeMappingManager(), mappingFactory.getMetadata());
        Role r = new Role();
        r.setId(10);
        r.setName("name_update_" + Randoms.getInt(99));
        r.setDescp("descp_update_" + Randoms.getInt(99));
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
                mappingFactory.getSqlTypeMappingManager(), mappingFactory.getMetadata());
        GetOperate<UserRole> get = new GetOperate<>(jdbc, mappingFactory.getClassMapping(UserRole.class),
                mappingFactory.getSqlTypeMappingManager(), mappingFactory.getMetadata());

        UserRole userRole = new UserRole();
        userRole.setRoleId(3);
        userRole.setUserId(3);
        userRole.setDescp("descp_update_" + Randoms.getInt(99));
        userRole.setDescp2("descp2_update_" + Randoms.getInt(99));
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
                mappingFactory.getSqlTypeMappingManager(), mappingFactory.getMetadata());
        Integer id = 1;
        Role role = operate.get(id);
        assertEquals(role.getId(), id);
        assertNotNull(role.getName());
        assertNotNull(role.getDescp());
        assertEquals(role.getName(), "n_init_1");
        assertEquals(role.getDescp(), "descp_1");
    }

    @Test
    public void testGetMulityPrimaryKey() {
        GetOperate<UserRole> operate = new GetOperate<>(jdbc, mappingFactory.getClassMapping(UserRole.class),
                mappingFactory.getSqlTypeMappingManager(), mappingFactory.getMetadata());
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
                mappingFactory.getSqlTypeMappingManager(), mappingFactory.getMetadata());
        InsertOperate<Role> insert = new InsertOperate<>(jdbc, mappingFactory.getClassMapping(Role.class),
                mappingFactory.getSqlTypeMappingManager(), mappingFactory.getMetadata());
        GetOperate<Role> get = new GetOperate<>(jdbc, mappingFactory.getClassMapping(Role.class),
                mappingFactory.getSqlTypeMappingManager(), mappingFactory.getMetadata());
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
                mappingFactory.getSqlTypeMappingManager(), mappingFactory.getMetadata());
        InsertOperate<UserRole> insert = new InsertOperate<>(jdbc, mappingFactory.getClassMapping(UserRole.class),
                mappingFactory.getSqlTypeMappingManager(), mappingFactory.getMetadata());
        GetOperate<UserRole> get = new GetOperate<>(jdbc, mappingFactory.getClassMapping(UserRole.class),
                mappingFactory.getSqlTypeMappingManager(), mappingFactory.getMetadata());
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

    @Test
    public void testDeleteBatch() {
        DeleteOperate<Role> delete = new DeleteOperate<>(jdbc, mappingFactory.getClassMapping(Role.class),
                mappingFactory.getSqlTypeMappingManager(), mappingFactory.getMetadata());
        InsertOperate<Role> insert = new InsertOperate<>(jdbc, mappingFactory.getClassMapping(Role.class),
                mappingFactory.getSqlTypeMappingManager(), mappingFactory.getMetadata());
        GetOperate<Role> get = new GetOperate<>(jdbc, mappingFactory.getClassMapping(Role.class),
                mappingFactory.getSqlTypeMappingManager(), mappingFactory.getMetadata());

        List<Role> roles = new ArrayList<>();
        int size = 5;
        for (int i = 0; i < size; i++) {
            Role r = new Role();
            insert.execute(r);
            assertNotNull(r.getId());
            roles.add(r);
        }
        assertEquals(roles.size(), size);

        delete.executeBatch(roles);

        roles.forEach(r -> {
            assertNull(get.get(r));
        });
    }

    @Test
    public void testDeleteBatchMulityPrimaryKey() {
        DeleteOperate<UserRole> delete = new DeleteOperate<>(jdbc, mappingFactory.getClassMapping(UserRole.class),
                mappingFactory.getSqlTypeMappingManager(), mappingFactory.getMetadata());
        InsertOperate<UserRole> insert = new InsertOperate<>(jdbc, mappingFactory.getClassMapping(UserRole.class),
                mappingFactory.getSqlTypeMappingManager(), mappingFactory.getMetadata());
        GetOperate<UserRole> get = new GetOperate<>(jdbc, mappingFactory.getClassMapping(UserRole.class),
                mappingFactory.getSqlTypeMappingManager(), mappingFactory.getMetadata());

        List<UserRole> userRoles = new ArrayList<>();
        int size = 5;
        for (int i = 0; i < size; i++) {
            UserRole userRole = new UserRole();
            userRole.setRoleId(33333 + i);
            userRole.setUserId(22222 + i);

            assertNull(get.get(userRole));

            insert.execute(userRole);

            assertNotNull(get.get(userRole));

            userRoles.add(userRole);
        }
        assertEquals(userRoles.size(), size);

        delete.executeBatch(userRoles);

        userRoles.forEach(ur -> {
            assertNull(get.get(ur));
        });
    }

}
