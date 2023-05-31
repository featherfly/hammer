
package cn.featherfly.hammer.sqldb.jdbc;

import static org.testng.Assert.assertNull;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import cn.featherfly.common.bean.BeanDescriptor;
import cn.featherfly.common.db.mapping.mappers.PlatformJavaSqlTypeMapper;
import cn.featherfly.common.lang.Randoms;
import cn.featherfly.hammer.sqldb.SqldbHammerException;
import cn.featherfly.hammer.sqldb.jdbc.operate.DeleteOperate;
import cn.featherfly.hammer.sqldb.jdbc.operate.GetOperate;
import cn.featherfly.hammer.sqldb.jdbc.operate.InsertOperate;
import cn.featherfly.hammer.sqldb.jdbc.operate.MergeOperate;
import cn.featherfly.hammer.sqldb.jdbc.operate.UpdateOperate;
import cn.featherfly.hammer.sqldb.jdbc.operate.UpsertOperate;
import cn.featherfly.hammer.sqldb.jdbc.vo.r.App;
import cn.featherfly.hammer.sqldb.jdbc.vo.r.AppVersion;
import cn.featherfly.hammer.sqldb.jdbc.vo.r.Role;
import cn.featherfly.hammer.sqldb.jdbc.vo.r.UserRole;

/**
 * OperatorTest.
 *
 * @author zhongj
 */
public class OperatorTest extends JdbcTestBase {

    @BeforeClass
    void before() {
        PlatformJavaSqlTypeMapper platformJavaSqlTypeMapper = new PlatformJavaSqlTypeMapper();

        mappingFactory.getSqlTypeMappingManager().regist(
                BeanDescriptor.getBeanDescriptor(App.class).getBeanProperty("platform"), platformJavaSqlTypeMapper);
        mappingFactory.getSqlTypeMappingManager().regist(
                BeanDescriptor.getBeanDescriptor(AppVersion.class).getBeanProperty("platform"),
                platformJavaSqlTypeMapper);
    }

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

    @Test
    public void testInsert2() {
        InsertOperate<UserRole> upsert = new InsertOperate<>(jdbc, mappingFactory.getClassMapping(UserRole.class),
                mappingFactory.getSqlTypeMappingManager(), mappingFactory.getMetadata());
        DeleteOperate<UserRole> delete = new DeleteOperate<>(jdbc, mappingFactory.getClassMapping(UserRole.class),
                mappingFactory.getSqlTypeMappingManager(), mappingFactory.getMetadata());
        GetOperate<UserRole> get = new GetOperate<>(jdbc, mappingFactory.getClassMapping(UserRole.class),
                mappingFactory.getSqlTypeMappingManager(), mappingFactory.getMetadata());

        UserRole ur = new UserRole();
        ur.setUserId(1);
        ur.setRoleId(1);
        ur.setDescp("user_role_1_1");
        int result = upsert.execute(ur);
        assertEquals(result, 1);

        UserRole load = get.get(ur);
        assertNotNull(load);
        assertEquals(load.getUserId(), ur.getUserId());
        assertEquals(load.getRoleId(), ur.getRoleId());
        assertEquals(load.getDescp(), ur.getDescp());

        delete.execute(ur);
        load = get.get(ur);
        assertNull(load);
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

        assertInsertBatch(insert, delete, get, null);
        assertInsertBatch(insert, delete, get, 3);

        int results[] = insert.executeBatch(new ArrayList<Role>());
        assertEquals(results.length, 0);
        results = insert.executeBatch(new Role[0]);
        assertEquals(results.length, 0);
    }

    private void assertInsertBatch(InsertOperate<Role> insert, DeleteOperate<Role> delete, GetOperate<Role> get,
            Integer batchSize) {
        List<Role> roles = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            roles.add(role());
        }
        int results[];
        if (batchSize == null) {
            results = insert.executeBatch(roles);
        } else {
            results = insert.executeBatch(roles, batchSize);
        }

        for (Role role : roles) {
            if (jdbc.getDialect().supportAutoGenerateKeyBatch()) {
                Role r = get.get(role);
                assertEquals(r.getId(), role.getId());
                assertEquals(r.getName(), role.getName());
                delete.delete(role.getId());
            }
        }
        int size = 0;
        for (int i : results) {
            size += i;
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
    public void testMerge() {
        MergeOperate<Role> merge = new MergeOperate<>(jdbc, mappingFactory.getClassMapping(Role.class),
                mappingFactory.getSqlTypeMappingManager(), mappingFactory.getMetadata());
        GetOperate<Role> get = new GetOperate<>(jdbc, mappingFactory.getClassMapping(Role.class),
                mappingFactory.getSqlTypeMappingManager(), mappingFactory.getMetadata());

        Integer id = 10;
        Role orginal = get.get(id);

        Role merged = new Role();
        merged.setId(id);
        merged.setName("name_update_" + Randoms.getInt(99));
        int result = merge.execute(merged);
        assertEquals(result, 1);

        Role role = get.get(merged);
        assertNotNull(role);
        assertEquals(role.getId(), merged.getId());
        assertEquals(role.getName(), merged.getName());
        assertEquals(role.getDescp(), orginal.getDescp());
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
        System.out.println(operate.getSql());
        Integer id = 1;
        Role role = operate.get(id);
        assertEquals(role.getId(), id);
        assertNotNull(role.getName());
        assertNotNull(role.getDescp());
        assertEquals(role.getName(), "n_init_1");
        assertEquals(role.getDescp(), "descp_1");

        List<Serializable> ids = operate.getIds(null);
        assertEquals(ids.size(), 0);

        Serializable rid = operate.getId(null);
        assertNull(rid);

        rid = operate.getId(role);
        assertEquals(rid, id);
    }

    @Test(expectedExceptions = SqldbHammerException.class)
    public void testGetException() {
        GetOperate<Role> operate = new GetOperate<>(jdbc, mappingFactory.getClassMapping(Role.class),
                mappingFactory.getSqlTypeMappingManager(), mappingFactory.getMetadata());
        operate.get((Serializable) null);
    }

    @Test(expectedExceptions = SqldbHammerException.class)
    public void testGetException2() {
        GetOperate<Role> operate = new GetOperate<>(jdbc, mappingFactory.getClassMapping(Role.class),
                mappingFactory.getSqlTypeMappingManager(), mappingFactory.getMetadata());
        Role userInfo = null;
        operate.get(userInfo);
    }

    @Test(expectedExceptions = SqldbHammerException.class)
    public void testGetException3() {
        GetOperate<UserRole> operate = new GetOperate<>(jdbc, mappingFactory.getClassMapping(UserRole.class),
                mappingFactory.getSqlTypeMappingManager(), mappingFactory.getMetadata());
        UserRole ur = new UserRole();
        operate.getId(ur);
    }

    //    @Test(expectedExceptions = SqldbHammerException.class)
    //    public void testGetException3() {
    //        GetOperate<UserNoPk> operate = new GetOperate<>(jdbc, mappingFactory.getClassMapping(UserNoPk.class),
    //                mappingFactory.getSqlTypeMappingManager(), mappingFactory.getMetadata());
    //        UserNoPk e = null;
    //        operate.get(e);
    //    }

    @Test
    public void testGetForUpdate() {
        GetOperate<Role> operate = new GetOperate<>(jdbc, mappingFactory.getClassMapping(Role.class),
                mappingFactory.getSqlTypeMappingManager(), mappingFactory.getMetadata());
        Integer id = 1;
        Role role = operate.get(id, true);
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

        Function<Integer, List<Role>> insertRoles = size -> {
            List<Role> roles = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Role r = new Role();
                insert.execute(r);
                assertNotNull(r.getId());
                roles.add(r);
            }
            return roles;
        };

        int size = 5;
        List<Role> roles = insertRoles.apply(size);
        assertEquals(roles.size(), size);
        delete.executeBatch(roles);
        roles.forEach(r -> {
            assertNull(get.get(r));
        });

        List<Serializable> ids = new ArrayList<>();
        roles = insertRoles.apply(size);
        for (int i = 0; i < size; i++) {
            ids.add(roles.get(i).getId());
        }
        assertEquals(roles.size(), size);
        assertEquals(ids.size(), size);
        int results[] = delete.deleteBatch(ids);
        assertEquals(results[0], ids.size());
        roles.forEach(r -> {
            assertNull(get.get(r));
        });

        roles = insertRoles.apply(size);
        assertEquals(roles.size(), size);
        assertEquals(ids.size(), size);
        results = delete.executeBatch(roles, 2);
        assertEquals(sum(results), roles.size());
        roles.forEach(r -> {
            assertNull(get.get(r));
        });

        results = delete.deleteBatch(new ArrayList<>());
        assertEquals(results.length, 0);

        results = delete.executeBatch(new ArrayList<>(), 10);
        assertEquals(results.length, 0);
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

    @Test
    public void testUpsert() {
        UpsertOperate<App> upsert = new UpsertOperate<>(jdbc, mappingFactory.getClassMapping(App.class),
                mappingFactory.getSqlTypeMappingManager(), mappingFactory.getMetadata());
        DeleteOperate<App> delete = new DeleteOperate<>(jdbc, mappingFactory.getClassMapping(App.class),
                mappingFactory.getSqlTypeMappingManager(), mappingFactory.getMetadata());
        GetOperate<App> get = new GetOperate<>(jdbc, mappingFactory.getClassMapping(App.class),
                mappingFactory.getSqlTypeMappingManager(), mappingFactory.getMetadata());

        App app = new App();
        app.setCode("code01");
        app.setName("name01");
        upsert.execute(app);
        assertNotNull(app.getId());

        Long id = app.getId();
        String name = "name02";

        app.setName(name);
        upsert.execute(app);
        assertEquals(app.getId(), id);

        App a = get.get(app);
        assertNotNull(a);
        assertEquals(a.getName(), name);

        delete.execute(a);
        a = get.get(a);
        assertNull(a);
    }

    @Test
    public void testUpsert2() {
        UpsertOperate<UserRole> upsert = new UpsertOperate<>(jdbc, mappingFactory.getClassMapping(UserRole.class),
                mappingFactory.getSqlTypeMappingManager(), mappingFactory.getMetadata());
        DeleteOperate<UserRole> delete = new DeleteOperate<>(jdbc, mappingFactory.getClassMapping(UserRole.class),
                mappingFactory.getSqlTypeMappingManager(), mappingFactory.getMetadata());
        GetOperate<UserRole> get = new GetOperate<>(jdbc, mappingFactory.getClassMapping(UserRole.class),
                mappingFactory.getSqlTypeMappingManager(), mappingFactory.getMetadata());

        UserRole ur = new UserRole();
        ur.setUserId(1);
        ur.setRoleId(1);
        ur.setDescp("user_role_1_1");
        int result = upsert.execute(ur);
        assertEquals(result, 1);

        ur.setDescp("user_role_1_1_changed");

        result = upsert.execute(ur);

        UserRole load = get.get(ur);
        assertNotNull(load);
        assertEquals(load.getUserId(), ur.getUserId());
        assertEquals(load.getRoleId(), ur.getRoleId());
        assertEquals(load.getDescp(), ur.getDescp());

        delete.execute(ur);
        load = get.get(ur);
        assertNull(load);
    }

    @Test
    public void testUpsertBatch() {
        UpsertOperate<App> upsert = new UpsertOperate<>(jdbc, mappingFactory.getClassMapping(App.class),
                mappingFactory.getSqlTypeMappingManager(), mappingFactory.getMetadata());
        DeleteOperate<App> delete = new DeleteOperate<>(jdbc, mappingFactory.getClassMapping(App.class),
                mappingFactory.getSqlTypeMappingManager(), mappingFactory.getMetadata());
        GetOperate<App> get = new GetOperate<>(jdbc, mappingFactory.getClassMapping(App.class),
                mappingFactory.getSqlTypeMappingManager(), mappingFactory.getMetadata());

        List<App> apps = new ArrayList<>();

        App app = new App();
        app.setCode("code01");
        app.setName("name01");
        apps.add(app);

        App app2 = new App();
        app2.setCode("code02");
        app2.setName("name02");
        apps.add(app2);

        upsert.executeBatch(apps);

        Long id = app.getId();
        Long id2 = app2.getId();
        String name = "name03";
        String name2 = "name04";

        app.setName(name);
        app2.setName(name2);

        upsert.executeBatch(apps);

        //        assertEquals(app.getId(), id);
        //        assertEquals(app2.getId(), id2);

        //        App a = get.get(app);
        //        assertNotNull(a);
        //        assertEquals(a.getName(), name);
        //
        //        delete.execute(a);
        //        a = get.get(a);
        //        assertNull(a);

        int results[] = upsert.executeBatch(new ArrayList<App>());
        assertEquals(results.length, 0);
        results = upsert.executeBatch(new App[0]);
        assertEquals(results.length, 0);
    }

}
