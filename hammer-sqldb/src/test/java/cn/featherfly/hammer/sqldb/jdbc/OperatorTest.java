
package cn.featherfly.hammer.sqldb.jdbc;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertNull;
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
import cn.featherfly.hammer.sqldb.jdbc.operate.UpdateFetchOperate;
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

    InsertOperate<Role> roleInsert;
    GetOperate<Role> roleGet;
    DeleteOperate<Role> roleDelete;
    UpdateOperate<Role> roleUpdate;
    MergeOperate<Role> roleMerge;

    GetOperate<UserRole> userRoleGet;
    InsertOperate<UserRole> userRoleInsert;
    DeleteOperate<UserRole> userRoleDelete;
    UpdateOperate<UserRole> userRoleUpdate;
    UpsertOperate<UserRole> userRoleUpsert;

    GetOperate<App> appGet;
    UpsertOperate<App> appUpsert;
    DeleteOperate<App> appDelete;

    @BeforeClass
    void before() {
        PlatformJavaSqlTypeMapper platformJavaSqlTypeMapper = new PlatformJavaSqlTypeMapper();

        mappingFactory.getSqlTypeMappingManager()
            .regist(BeanDescriptor.getBeanDescriptor(App.class).getBeanProperty("platform"), platformJavaSqlTypeMapper);
        mappingFactory.getSqlTypeMappingManager().regist(
            BeanDescriptor.getBeanDescriptor(AppVersion.class).getBeanProperty("platform"), platformJavaSqlTypeMapper);

        roleGet = new GetOperate<>(jdbc, mappingFactory.getClassMapping(Role.class),
            mappingFactory.getSqlTypeMappingManager(), mappingFactory.getMetadata(),
            propertyAccessorFactory.create(Role.class));
        roleInsert = new InsertOperate<>(jdbc, mappingFactory.getClassMapping(Role.class),
            mappingFactory.getSqlTypeMappingManager(), mappingFactory.getMetadata());
        roleDelete = new DeleteOperate<>(jdbc, mappingFactory.getClassMapping(Role.class),
            mappingFactory.getSqlTypeMappingManager(), mappingFactory.getMetadata());
        roleUpdate = new UpdateOperate<>(jdbc, mappingFactory.getClassMapping(Role.class),
            mappingFactory.getSqlTypeMappingManager(), mappingFactory.getMetadata());
        roleMerge = new MergeOperate<>(jdbc, mappingFactory.getClassMapping(Role.class),
            mappingFactory.getSqlTypeMappingManager(), mappingFactory.getMetadata());

        userRoleGet = new GetOperate<>(jdbc, mappingFactory.getClassMapping(UserRole.class),
            mappingFactory.getSqlTypeMappingManager(), mappingFactory.getMetadata(),
            propertyAccessorFactory.create(UserRole.class));
        userRoleInsert = new InsertOperate<>(jdbc, mappingFactory.getClassMapping(UserRole.class),
            mappingFactory.getSqlTypeMappingManager(), mappingFactory.getMetadata());
        userRoleDelete = new DeleteOperate<>(jdbc, mappingFactory.getClassMapping(UserRole.class),
            mappingFactory.getSqlTypeMappingManager(), mappingFactory.getMetadata());
        userRoleUpdate = new UpdateOperate<>(jdbc, mappingFactory.getClassMapping(UserRole.class),
            mappingFactory.getSqlTypeMappingManager(), mappingFactory.getMetadata());
        userRoleUpsert = new UpsertOperate<>(jdbc, mappingFactory.getClassMapping(UserRole.class),
            mappingFactory.getSqlTypeMappingManager(), mappingFactory.getMetadata());

        // 手动创建依赖
        propertyAccessorFactory.create(AppVersion.class);
        // 新版本支持创建时自动级联创建
        //        propertyAccessorFactory.create(App.class);
        //        // 创建完成后再来进行依赖管理，可以解决互相依赖的问题，就像上面这两个
        //        ((AsmPropertyAccessorFactory) propertyAccessorFactory).createPropertyAccessorCascade();

        appGet = new GetOperate<>(jdbc, mappingFactory.getClassMapping(App.class),
            mappingFactory.getSqlTypeMappingManager(), mappingFactory.getMetadata(),
            propertyAccessorFactory.create(App.class));
        appUpsert = new UpsertOperate<>(jdbc, mappingFactory.getClassMapping(App.class),
            mappingFactory.getSqlTypeMappingManager(), mappingFactory.getMetadata());
        appDelete = new DeleteOperate<>(jdbc, mappingFactory.getClassMapping(App.class),
            mappingFactory.getSqlTypeMappingManager(), mappingFactory.getMetadata());

    }

    @Test
    public void testInsert() {
        Role r = role();
        roleInsert.execute(r);
        assertNotNull(r.getId());
        roleDelete.execute(r);
        Role role = roleGet.get(r);
        assertNull(role);

        r = role();
        roleInsert.execute(r);
        assertNotNull(r.getId());
        roleDelete.execute(r);
        role = roleGet.get(r);
        assertNull(role);
    }

    @Test
    public void testInsert2() {
        UserRole ur = new UserRole();
        ur.setUserId(1);
        ur.setRoleId(1);
        ur.setDescp("user_role_1_1");
        int result = userRoleInsert.execute(ur);
        assertEquals(result, 1);

        UserRole load = userRoleGet.get(ur);
        assertNotNull(load);
        assertEquals(load.getUserId(), ur.getUserId());
        assertEquals(load.getRoleId(), ur.getRoleId());
        assertEquals(load.getDescp(), ur.getDescp());

        userRoleDelete.execute(ur);
        load = userRoleGet.get(ur);
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
        assertInsertBatch(roleInsert, roleDelete, roleGet, null);
        assertInsertBatch(roleInsert, roleDelete, roleGet, 3);

        int results[] = roleInsert.executeBatch(new ArrayList<>());
        assertEquals(results.length, 0);
        results = roleInsert.executeBatch(new Role[0]);
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
        UserRole ur = new UserRole();
        ur.setUserId(123);
        ur.setRoleId(321);
        ur.setDescp("descp_123_321");
        userRoleInsert.execute(ur);

        UserRole userRole = userRoleGet.get(ur);
        assertNotNull(userRole);
        assertNull(userRole.getDescp2());
        assertEquals(userRole.getUserId(), ur.getUserId());
        assertEquals(userRole.getRoleId(), ur.getRoleId());
        assertEquals(userRole.getDescp(), ur.getDescp());

        userRoleDelete.execute(userRole);

        userRole = userRoleGet.get(ur);
        assertNull(userRole);
    }

    @Test
    public void testUpdate() {
        Role r = new Role();
        r.setId(10);
        r.setName("name_update_" + Randoms.getInt(99));
        r.setDescp("descp_update_" + Randoms.getInt(99));
        roleUpdate.execute(r);

        Role role = roleGet.get(r);
        assertNotNull(role);
        assertEquals(role.getId(), r.getId());
        assertEquals(role.getName(), r.getName());
        assertEquals(role.getDescp(), r.getDescp());
    }

    @Test
    public void testMerge() {
        Integer id = 10;
        Role orginal = roleGet.get(id);

        Role merged = new Role();
        merged.setId(id);
        merged.setName("name_update_" + Randoms.getInt(99));
        int result = roleMerge.execute(merged);
        assertEquals(result, 1);

        Role role = roleGet.get(merged);
        assertNotNull(role);
        assertEquals(role.getId(), merged.getId());
        assertEquals(role.getName(), merged.getName());
        assertEquals(role.getDescp(), orginal.getDescp());
    }

    @Test
    public void testUpdateMulityPrimaryKey() {
        UserRole userRole = new UserRole();
        userRole.setRoleId(3);
        userRole.setUserId(3);
        userRole.setDescp("descp_update_" + Randoms.getInt(99));
        userRole.setDescp2("descp2_update_" + Randoms.getInt(99));
        userRoleUpdate.execute(userRole);

        UserRole ur = userRoleGet.get(userRole);

        assertEquals(ur.getUserId(), userRole.getUserId());
        assertEquals(ur.getRoleId(), userRole.getRoleId());
        assertEquals(ur.getDescp(), userRole.getDescp());
        assertEquals(ur.getDescp2(), userRole.getDescp2());
    }

    @Test
    public void get() {
        System.out.println(roleGet.getSql());
        Integer id = 1;
        Role role = roleGet.get(id);
        assertEquals(role.getId(), id);
        assertNotNull(role.getName());
        assertNotNull(role.getDescp());
        assertEquals(role.getName(), "n_init_1");
        assertEquals(role.getDescp(), "descp_1");

        List<Serializable> ids = roleGet.getIds(null);
        assertEquals(ids.size(), 0);

        Serializable rid = roleGet.getId(null);
        assertNull(rid);

        rid = roleGet.getId(role);
        assertEquals(rid, id);
    }

    @Test(expectedExceptions = SqldbHammerException.class)
    public void getException() {
        roleGet.get((Serializable) null);
    }

    @Test(expectedExceptions = SqldbHammerException.class)
    public void getException2() {
        Role role = null;
        roleGet.get(role);
    }

    @Test(expectedExceptions = SqldbHammerException.class)
    public void getException3() {
        UserRole ur = new UserRole();
        userRoleGet.getId(ur);
    }

    //    @Test(expectedExceptions = SqldbHammerException.class)
    //    public void getException3() {
    //        GetOperate<UserNoPk> operate = new GetOperate<>(jdbc, mappingFactory.getClassMapping(UserNoPk.class),
    //                mappingFactory.getSqlTypeMappingManager(), mappingFactory.getMetadata(), propertyAccessorFactory);
    //        UserNoPk e = null;
    //        operate.get(e);
    //    }

    @Test
    public void getForUpdate() {
        GetOperate<Role> operate = roleGet;
        Integer id = 1;
        Role role = operate.get(id, true);
        assertEquals(role.getId(), id);
        assertNotNull(role.getName());
        assertNotNull(role.getDescp());
        assertEquals(role.getName(), "n_init_1");
        assertEquals(role.getDescp(), "descp_1");
    }

    @Test
    public void getMulityPrimaryKey() {
        GetOperate<UserRole> operate = userRoleGet;
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
        Role r = new Role();
        roleInsert.execute(r);
        assertNotNull(r.getId());
        roleDelete.execute(r);

        Role role = roleGet.get(r);
        assertNull(role);
    }

    @Test
    public void testDeleteMulityPrimaryKey() {
        GetOperate<UserRole> get = userRoleGet;
        UserRole userRole = new UserRole();
        userRole.setRoleId(111);
        userRole.setUserId(111);

        UserRole ur = get.get(userRole);
        if (ur == null) {
            userRoleInsert.execute(userRole);
        }
        userRoleDelete.execute(userRole);

        ur = get.get(userRole);
        assertNull(ur);
    }

    @Test
    public void testDeleteBatch() {
        GetOperate<Role> get = roleGet;

        Function<Integer, List<Role>> insertRoles = size -> {
            List<Role> roles = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Role r = new Role();
                roleInsert.execute(r);
                assertNotNull(r.getId());
                roles.add(r);
            }
            return roles;
        };

        int size = 5;
        List<Role> roles = insertRoles.apply(size);
        assertEquals(roles.size(), size);
        roleDelete.executeBatch(roles);
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
        int results[] = roleDelete.deleteBatch(ids);
        assertEquals(results[0], ids.size());
        roles.forEach(r -> {
            assertNull(get.get(r));
        });

        roles = insertRoles.apply(size);
        assertEquals(roles.size(), size);
        assertEquals(ids.size(), size);
        results = roleDelete.executeBatch(roles, 2);
        assertEquals(sum(results), roles.size());
        roles.forEach(r -> {
            assertNull(get.get(r));
        });

        results = roleDelete.deleteBatch(new ArrayList<>());
        assertEquals(results.length, 0);

        results = roleDelete.executeBatch(new ArrayList<>(), 10);
        assertEquals(results.length, 0);
    }

    @Test
    public void testDeleteBatchMulityPrimaryKey() {
        GetOperate<UserRole> get = userRoleGet;

        List<UserRole> userRoles = new ArrayList<>();
        int size = 5;
        for (int i = 0; i < size; i++) {
            UserRole userRole = new UserRole();
            userRole.setRoleId(33333 + i);
            userRole.setUserId(22222 + i);

            assertNull(get.get(userRole));

            userRoleInsert.execute(userRole);

            assertNotNull(get.get(userRole));

            userRoles.add(userRole);
        }
        assertEquals(userRoles.size(), size);

        userRoleDelete.executeBatch(userRoles);

        userRoles.forEach(ur -> {
            assertNull(get.get(ur));
        });
    }

    @Test
    public void testUpsert() {
        App app = new App();
        app.setCode("code01");
        app.setName("name01");
        appUpsert.execute(app);
        assertNotNull(app.getId());

        Long id = app.getId();
        String name = "name02";

        app.setName(name);
        appUpsert.execute(app);
        assertEquals(app.getId(), id);

        App a = appGet.get(app);
        assertNotNull(a);
        assertEquals(a.getName(), name);

        appDelete.execute(a);
        a = appGet.get(a);
        assertNull(a);
    }

    @Test
    public void testUpsert2() {

        UserRole ur = new UserRole();
        ur.setUserId(1);
        ur.setRoleId(1);
        ur.setDescp("user_role_1_1");
        int result = userRoleUpsert.execute(ur);
        assertEquals(result, 1);

        ur.setDescp("user_role_1_1_changed");

        result = userRoleUpsert.execute(ur);

        UserRole load = userRoleGet.get(ur);
        assertNotNull(load);
        assertEquals(load.getUserId(), ur.getUserId());
        assertEquals(load.getRoleId(), ur.getRoleId());
        assertEquals(load.getDescp(), ur.getDescp());

        userRoleDelete.execute(ur);
        load = userRoleGet.get(ur);
        assertNull(load);
    }

    @Test
    public void testUpsertBatch() {
        List<App> apps = new ArrayList<>();

        App app = new App();
        app.setCode("code01");
        app.setName("name01");
        apps.add(app);

        App app2 = new App();
        app2.setCode("code02");
        app2.setName("name02");
        apps.add(app2);

        appUpsert.executeBatch(apps);

        //        Long id = app.getId();
        //        Long id2 = app2.getId();
        String name = "name03";
        String name2 = "name04";

        app.setName(name);
        app2.setName(name2);

        appUpsert.executeBatch(apps);

        //        assertEquals(app.getId(), id);
        //        assertEquals(app2.getId(), id2);

        //        App a = get.get(app);
        //        assertNotNull(a);
        //        assertEquals(a.getName(), name);
        //
        //        delete.execute(a);
        //        a = get.get(a);
        //        assertNull(a);

        int results[] = appUpsert.executeBatch(new ArrayList<>());
        assertEquals(results.length, 0);
        results = appUpsert.executeBatch(new App[0]);
        assertEquals(results.length, 0);
    }

    @Test
    public void testUpdateFetch() {
        UpdateFetchOperate<
            Role> updateFetch = new UpdateFetchOperate<>(jdbc, mappingFactory.getClassMapping(Role.class),
                mappingFactory.getSqlTypeMappingManager(), mappingFactory.getMetadata(), roleGet, roleUpdate, key -> {
                }, key -> {
                });

        int id = 10;
        Role role = new Role();
        role.setId(10);
        role.setName("name_update_" + Randoms.getInt(99));
        role.setDescp("descp_update_" + Randoms.getInt(99));
        Role changedRole = updateFetch.execute(id, r -> {
            r.setName(role.getName());
            r.setDescp(role.getDescp());
            return r;
        });
        assertNotNull(changedRole);
        assertEquals(changedRole.getId(), role.getId());
        assertEquals(changedRole.getName(), role.getName());
        assertEquals(changedRole.getDescp(), role.getDescp());

        Role loadRole = roleGet.get(role);
        assertNotNull(loadRole);
        assertEquals(loadRole.getId(), role.getId());
        assertEquals(loadRole.getName(), role.getName());
        assertEquals(loadRole.getDescp(), role.getDescp());

        assertEquals(loadRole.getId(), changedRole.getId());
        assertEquals(loadRole.getName(), changedRole.getName());
        assertEquals(loadRole.getDescp(), changedRole.getDescp());
    }

    @Test
    public void testUpdateFetchMulitiPk() {
        UpdateFetchOperate<UserRole> updateFetch = new UpdateFetchOperate<>(jdbc,
            mappingFactory.getClassMapping(UserRole.class), mappingFactory.getSqlTypeMappingManager(),
            mappingFactory.getMetadata(), userRoleGet, userRoleUpdate, key -> {
            }, key -> {
            });

        int rid = 8;
        int uid = 8;
        UserRole ur = new UserRole();
        ur.setRoleId(rid);
        ur.setUserId(uid);
        ur.setDescp("descp_update_" + Randoms.getInt(99));
        ur.setDescp2("descp2_update_" + Randoms.getInt(99));
        UserRole changed = updateFetch.execute(ur, r -> {
            r.setDescp(ur.getDescp());
            r.setDescp2(ur.getDescp2());
            return r;
        });
        assertNotNull(changed);
        assertEquals(changed.getUserId(), ur.getUserId());
        assertEquals(changed.getRoleId(), ur.getRoleId());
        assertEquals(changed.getDescp(), ur.getDescp());
        assertEquals(changed.getDescp2(), ur.getDescp2());

        UserRole loaded = userRoleGet.get(ur);
        assertNotNull(loaded);
        assertEquals(loaded.getUserId(), ur.getUserId());
        assertEquals(loaded.getRoleId(), ur.getRoleId());
        assertEquals(loaded.getDescp(), ur.getDescp());
        assertEquals(loaded.getDescp2(), ur.getDescp2());

        assertEquals(loaded.getUserId(), changed.getUserId());
        assertEquals(loaded.getRoleId(), changed.getRoleId());
        assertEquals(loaded.getDescp(), changed.getDescp());
        assertEquals(loaded.getDescp2(), changed.getDescp2());

    }

}
