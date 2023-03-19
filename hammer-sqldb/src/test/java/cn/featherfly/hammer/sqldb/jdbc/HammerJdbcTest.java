
package cn.featherfly.hammer.sqldb.jdbc;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertTrue;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import cn.featherfly.common.db.mapping.JdbcMappingException;
import cn.featherfly.common.lang.ArrayUtils;
import cn.featherfly.common.lang.CollectionUtils;
import cn.featherfly.common.lang.Randoms;
import cn.featherfly.common.operator.LogicOperator;
import cn.featherfly.common.repository.IgnorePolicy;
import cn.featherfly.common.structure.page.PaginationResults;
import cn.featherfly.hammer.Hammer;
import cn.featherfly.hammer.sqldb.SqldbHammer;
import cn.featherfly.hammer.sqldb.SqldbHammerException;
import cn.featherfly.hammer.sqldb.SqldbHammerImpl;
import cn.featherfly.hammer.sqldb.jdbc.vo.Article;
import cn.featherfly.hammer.sqldb.jdbc.vo.DistrictDivision;
import cn.featherfly.hammer.sqldb.jdbc.vo.Role;
import cn.featherfly.hammer.sqldb.jdbc.vo.User;
import cn.featherfly.hammer.sqldb.jdbc.vo.UserInfo;
import cn.featherfly.hammer.sqldb.jdbc.vo.UserRole;
import cn.featherfly.hammer.sqldb.jdbc.vo.UserRole2;

/**
 * HammerJdbcTest.
 *
 * @author zhongj
 */
public class HammerJdbcTest extends JdbcTestBase {

    protected Hammer hammer;

    Serializable nullObject;
    List<Serializable> emptyList = new ArrayList<>();
    Serializable[] emptyArray = new Serializable[0];

    @BeforeClass
    void before() {
        hammer = new SqldbHammerImpl(jdbc, mappingFactory, configFactory);
    }

    @Test
    public void testGet() {
        assertNull(hammer.get(null, Role.class));
        assertNull(hammer.get(0, null));

        Integer id = 1;
        Role role = hammer.get(id, Role.class);
        assertEquals(role.getId(), id);
        assertNotNull(role.getName());
        assertNotNull(role.getDescp());
        assertEquals(role.getName(), "n_init_1");
        assertEquals(role.getDescp(), "descp_1");
        System.out.println(role);

        role = hammer.get(new Role(id));
        assertEquals(role.getId(), id);
        assertNotNull(role.getName());
        assertNotNull(role.getDescp());
        assertEquals(role.getName(), "n_init_1");
        assertEquals(role.getDescp(), "descp_1");
        System.out.println(role);
    }

    @Test
    public void testGet2() {
        Integer id = 1;
        UserInfo ui = hammer.get(id, UserInfo.class);
        assertEquals(ui.getId(), id);
        assertEquals(ui.getUser().getId(), new Integer(1));
        assertEquals(ui.getName(), "羽飞");
        assertEquals(ui.getDescp(), "羽飞描述");
        assertEquals(ui.getDivision().getProvince(), "四川");
        assertEquals(ui.getDivision().getCity(), "成都");
        assertEquals(ui.getDivision().getDistrict(), "金牛");
        System.out.println(ui);
    }

    @Test
    public void testGet3() {
        assertTrue(hammer.get(Role.class, emptyList).isEmpty());
        assertTrue(hammer.get(Role.class, emptyArray).isEmpty());

        Integer id1 = 1;
        Integer id2 = 2;
        int size = 2;

        UserInfo ui = null;

        List<UserInfo> uis = hammer.get(UserInfo.class, id1, id2);

        assertEquals(uis.size(), size);

        ui = uis.get(0);
        assertEquals(ui.getId(), id1);
        assertEquals(ui.getUser().getId(), new Integer(1));
        assertEquals(ui.getName(), "羽飞");
        assertEquals(ui.getDescp(), "羽飞描述");
        assertEquals(ui.getDivision().getProvince(), "四川");
        assertEquals(ui.getDivision().getCity(), "成都");
        assertEquals(ui.getDivision().getDistrict(), "金牛");
        System.out.println(ui);

        ui = uis.get(1);
        assertEquals(ui.getId(), id2);
        assertEquals(ui.getUser().getId(), new Integer(2));
        assertEquals(ui.getName(), "翼");
        System.out.println(ui);

        //

        uis = hammer.get(UserInfo.class, ArrayUtils.toList(id1, id2));

        assertEquals(uis.size(), size);

        ui = uis.get(0);
        assertEquals(ui.getId(), id1);
        assertEquals(ui.getUser().getId(), new Integer(1));
        assertEquals(ui.getName(), "羽飞");
        assertEquals(ui.getDescp(), "羽飞描述");
        assertEquals(ui.getDivision().getProvince(), "四川");
        assertEquals(ui.getDivision().getCity(), "成都");
        assertEquals(ui.getDivision().getDistrict(), "金牛");
        System.out.println(ui);

        ui = uis.get(1);
        assertEquals(ui.getId(), id2);
        assertEquals(ui.getUser().getId(), new Integer(2));
        assertEquals(ui.getName(), "翼");
        System.out.println(ui);
    }

    @Test
    public void testGetMulityPrimaryKey() {
        UserRole userRole = new UserRole();
        Integer roleId = 2;
        Integer userId = 2;
        userRole.setRoleId(roleId);
        userRole.setUserId(userId);

        UserRole ur = hammer.get(userRole);
        assertEquals(ur.getUserId(), userRole.getUserId());
        assertEquals(ur.getUserId(), userRole.getRoleId());
        assertEquals(ur.getDescp(), "descp");
        assertEquals(ur.getDescp2(), "descp2");
        System.out.println(ur);
    }

    @Test
    public void testGetMulityPrimaryKey2() {
        UserRole2 userRole = new UserRole2();
        Integer roleId = 2;
        Integer userId = 2;
        userRole.setRole(new Role(roleId));
        userRole.setUser(new User(userId));

        UserRole2 ur = hammer.get(userRole);

        assertEquals(ur.getUser().getId(), userRole.getUser().getId());
        assertEquals(ur.getUser().getId(), userRole.getRole().getId());
        assertEquals(ur.getDescp(), "descp");
        assertEquals(ur.getDescp2(), "descp2");
        System.out.println(ur);
    }

    @Test
    public void testGetAndFetch() {
        assertNull(hammer.get(null, UserInfo.class, UserInfo::getUser));

        Integer id = 1;
        UserInfo userInfo;

        userInfo = hammer.get(id, UserInfo.class);

        assertEquals(userInfo.getId(), id);
        assertNotNull(userInfo.getUser().getId());

        userInfo = hammer.get(id, UserInfo.class, UserInfo::getUser);

        assertEquals(userInfo.getId(), id);
        assertNotNull(userInfo.getUser().getId());
        assertNotNull(userInfo.getUser().getUsername());
    }

    @Test
    public void testGetLockUpdate() {
        assertNull(hammer.getLockUpdate(null, t -> t));
        assertNull(hammer.getLockUpdate(null, Role.class, t -> t));
    }

    @Test(expectedExceptions = JdbcMappingException.class)
    public void testGetAndFetchException() {
        Integer id = 1;
        hammer.get(id, UserInfo.class, UserInfo::getDescp);
    }

    @Test
    public void testSave() {
        assertTrue(hammer.save(nullObject) == 0);

        Role r = role();
        hammer.save(r);
        assertNotNull(r.getId());

        hammer.delete(r);

        Role role = hammer.get(r);
        assertNull(role);

        r = role();
        r.setName("name_" + Randoms.getInt(100));
        hammer.save(r);
        assertNotNull(r.getId());

        role = hammer.get(r);
        assertEquals(role.getId(), r.getId());
        assertEquals(role.getName(), r.getName());

        hammer.delete(r);

        role = hammer.get(r);
        assertNull(role);
    }

    @Test
    public void testSaveUser() {
        User user = new User();
        user.setAge(100);
        user.setUsername("username_" + Randoms.getString(5));
        user.setPwd("password_" + Randoms.getString(5));
        hammer.save(user);
    }

    @Test(expectedExceptions = SqldbHammerException.class)
    public void testSaveValidationException() {
        User user = new User();
        hammer.save(user);
    }

    @Test
    public void testSave2() {
        Article a = new Article();
        a.setTitle("title_" + Randoms.getInt(100));
        a.setContent("content_" + Randoms.getInt(1000));
        hammer.save(a);
        assertNotNull(a.getId());

        Article article = hammer.get(a);
        assertEquals(article.getId(), a.getId());
        assertEquals(article.getTitle(), a.getTitle());
        assertEquals(article.getContent(), a.getContent());
    }

    @Test
    public void testSave3() {
        UserInfo ui = new UserInfo();
        ui.setUser(new User(1));
        ui.setDescp("descp_" + Randoms.getInt(100));
        ui.setName("name_" + Randoms.getInt(100));
        ui.setDivision(new DistrictDivision("四川", "成都", "高新"));
        hammer.save(ui);

        assertNotNull(ui.getId());

        UserInfo userInfo = hammer.get(ui);
        assertEquals(userInfo.getId(), ui.getId());
        assertEquals(userInfo.getName(), ui.getName());
        assertEquals(userInfo.getDescp(), ui.getDescp());
        assertEquals(userInfo.getUser().getId(), ui.getUser().getId());
        assertEquals(userInfo.getDivision().getProvince(), ui.getDivision().getProvince());
        assertEquals(userInfo.getDivision().getCity(), ui.getDivision().getCity());
        assertEquals(userInfo.getDivision().getDistrict(), ui.getDivision().getDistrict());

        hammer.delete(userInfo);

        userInfo = hammer.get(userInfo);
        assertNull(userInfo);

    }

    @Test
    public void testSaveBatch() {
        assertTrue(hammer.save(emptyList).length == 0);
        assertTrue(hammer.save(emptyArray).length == 0);

        List<Role> roles = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            roles.add(role());
        }
        int results[] = hammer.save(roles);

        for (Role role : roles) {
            Role r = hammer.get(role);
            assertEquals(r.getId(), role.getId());
            assertEquals(r.getName(), role.getName());
            hammer.delete(role);
        }
        assertTrue(results[0] == roles.size());
    }

    @Test
    public void testSaveMultyKey() {
        UserRole ur = new UserRole();
        ur.setUserId(Randoms.getInt(1000));
        ur.setRoleId(Randoms.getInt(1000));
        ur.setDescp("descp_" + Randoms.getInt(1000));
        ur.setDescp2("descp2_" + Randoms.getInt(1000));
        hammer.save(ur);

        UserRole userRole = hammer.get(ur);
        assertEquals(userRole.getUserId(), ur.getUserId());
        assertEquals(userRole.getRoleId(), ur.getRoleId());
        assertEquals(userRole.getDescp(), ur.getDescp());
        assertEquals(userRole.getDescp2(), ur.getDescp2());

        hammer.delete(userRole);

        userRole = hammer.get(ur);
        assertNull(userRole);
    }

    @Test
    public void testSaveMultyKey2() {
        UserRole2 ur = new UserRole2();
        ur.setUser(new User(Randoms.getInt(1000)));
        ur.setRole(new Role(Randoms.getInt(1000)));
        ur.setDescp("descp" + Randoms.getInt(1000));
        ur.setDescp2("descp2" + Randoms.getInt(1000));
        hammer.save(ur);

        UserRole2 userRole = hammer.get(ur);
        assertEquals(userRole.getUser().getId(), ur.getUser().getId());
        assertEquals(userRole.getRole().getId(), ur.getRole().getId());
        assertEquals(userRole.getDescp(), ur.getDescp());
        assertEquals(userRole.getDescp2(), ur.getDescp2());

        hammer.delete(userRole);

        userRole = hammer.get(ur);
        assertNull(userRole);
    }

    @Test
    public void testSaveOrUpdate() {
        assertTrue(hammer.saveOrUpdate(nullObject) == 0);

        Role r = role();
        assertNull(r.getId());
        int result = hammer.saveOrUpdate(r);
        assertNotNull(r.getId());
        assertEquals(result, 1);

        Role role = hammer.get(r);
        assertNotNull(role);
        assertEquals(role.getId(), r.getId());

        String newName = "name_updated";
        r.setName(newName);
        hammer.saveOrUpdate(r);
        assertEquals(role.getId(), r.getId());
        role = hammer.get(r);
        assertNotNull(role);
        assertEquals(role.getId(), r.getId());
        assertEquals(role.getName(), newName);
    }

    @Test
    public void testUpdate() {
        assertTrue(hammer.update(nullObject) == 0);
        assertTrue(hammer.update(emptyList).length == 0);
        assertTrue(hammer.update(emptyArray).length == 0);

        Role r = new Role();
        r.setName("name");
        r.setDescp("descp");
        hammer.save(r);

        Role r3 = hammer.get(r);
        assertNotNull(r3.getDescp());
        assertEquals(r3.getName(), r.getName());

        Role r2 = new Role();
        r2.setId(r.getId());
        r2.setName("update_" + Randoms.getInt(100));
        hammer.update(r2);

        r3 = hammer.get(r2);

        assertEquals(r3.getName(), r2.getName());
        assertNull(r3.getDescp());

        //
        String name2 = "update_" + Randoms.getInt(100);
        r2.setName(name2);
        hammer.update(r2, IgnorePolicy.NONE);
        r3 = hammer.get(r2);
        assertEquals(r3.getName(), r2.getName());
        assertNull(r3.getDescp());

        r2.setName("");
        hammer.update(r2, IgnorePolicy.EMPTY);
        r3 = hammer.get(r2);
        assertEquals(r3.getName(), name2);
        assertNotEquals(r3.getName(), r2.getName());
        assertNull(r3.getDescp());

        r2.setName("");
        hammer.update(r2, IgnorePolicy.NULL);
        r3 = hammer.get(r2);
        assertEquals(r3.getName(), r2.getName());
        assertNull(r3.getDescp());

        r2.setName(null);
        hammer.update(r2, IgnorePolicy.NULL);
        r3 = hammer.get(r2);
        assertEquals(r3.getName(), "");
        assertNotEquals(r3.getName(), r2.getName());
        assertNull(r3.getDescp());

        hammer.delete(r2);
        r3 = hammer.get(r2);
        assertNull(r3);

        List<Role> roles = new ArrayList<>();
        String descp = "descp";
        String descpUpdate = "descp_updated";
        String descpUpdate2 = "descp_updated2";
        for (int i = 0; i < 3; i++) {
            Role role = new Role();
            role.setName("name");
            role.setDescp(descp);
            hammer.save(role);
            roles.add(role);
        }
        for (int i = 0; i < 3; i++) {
            Role role = roles.get(i);
            Role load = hammer.get(role.getId(), Role.class);
            assertEquals(load.getId(), role.getId());
            assertEquals(load.getName(), role.getName());
            assertEquals(load.getDescp(), descp);
            role.setDescp(descpUpdate);
        }
        hammer.update(roles);
        for (int i = 0; i < 3; i++) {
            Role role = roles.get(i);
            Role load = hammer.get(role.getId(), Role.class);
            assertEquals(load.getId(), role.getId());
            assertEquals(load.getName(), role.getName());
            assertEquals(load.getDescp(), descpUpdate);
            role.setDescp(descpUpdate2);
        }
        hammer.merge(roles.toArray(new Role[roles.size()]));
        for (int i = 0; i < 3; i++) {
            Role role = roles.get(i);
            Role load = hammer.get(role.getId(), Role.class);
            assertEquals(load.getId(), role.getId());
            assertEquals(load.getName(), role.getName());
            assertEquals(load.getDescp(), descpUpdate2);
        }
        hammer.delete(roles);
    }

    @Test
    public void testUpdate2() {
        UserInfo ui = new UserInfo();
        ui.setUser(new User(1));
        ui.setDescp("descp_" + Randoms.getInt(100));
        ui.setName("name_" + Randoms.getInt(100));
        ui.setDivision(new DistrictDivision("四川", "成都", "高新"));
        hammer.save(ui);

        UserInfo userInfo = hammer.get(ui);
        userInfo.setDescp("descp_" + Randoms.getInt(100));
        userInfo.getDivision().setDistrict("青羊");
        hammer.update(userInfo);

        UserInfo userInfo2 = hammer.get(ui);

        assertEquals(userInfo2.getDescp(), userInfo.getDescp());
        assertEquals(userInfo2.getId(), userInfo.getId());
        assertEquals(userInfo2.getName(), userInfo.getName());
        assertEquals(userInfo2.getDescp(), userInfo.getDescp());
        assertEquals(userInfo2.getUser().getId(), userInfo.getUser().getId());
        assertEquals(userInfo2.getDivision().getProvince(), userInfo.getDivision().getProvince());
        assertEquals(userInfo2.getDivision().getCity(), userInfo.getDivision().getCity());
        assertEquals(userInfo2.getDivision().getDistrict(), userInfo.getDivision().getDistrict());
        assertEquals(userInfo2.getDivision().getDistrict(), "青羊");

        hammer.delete(userInfo);

        userInfo2 = hammer.get(userInfo);
        assertNull(userInfo2);
    }

    @Test
    public void testUpdate3() {
        Role r = new Role();
        r.setName("name");
        r.setDescp("descp");
        hammer.save(r);

        final String updateName1 = "update_" + Randoms.getInt(100);
        Role updatedRole = hammer.getLockUpdate(r.getId(), Role.class, role -> {
            assertNotNull(role.getDescp());
            assertEquals(role.getName(), r.getName());

            role.setName(updateName1);
            return role;
        });
        assertEquals(updatedRole.getId(), r.getId());
        assertEquals(updatedRole.getName(), updateName1);

        final String updateName2 = "update_" + Randoms.getInt(100);
        updatedRole = hammer.loadLockUpdate(r, role -> {
            assertNotNull(role.getDescp());
            assertEquals(role.getName(), updateName1);

            role.setName(updateName2);
            return role;
        });

        assertEquals(updatedRole.getId(), r.getId());
        assertEquals(updatedRole.getName(), updateName2);

        hammer.delete(updatedRole);

        updatedRole = hammer.get(updatedRole);
        assertNull(updatedRole);
    }

    @Test
    public void testUpdate4() {
        List<Role> roles = hammer.query(Role.class).list();
        for (Role role : roles) {
            role.setDescp(null);
        }
        int results[] = hammer.update(roles, IgnorePolicy.NONE);
        assertEquals(results.length, roles.size());

        roles = hammer.query(Role.class).list();
        for (Role role : roles) {
            assertNull(role.getDescp());
            role.setDescp("descp_" + role.getId());
        }

        results = hammer.update(roles);
        assertEquals(results.length, roles.size());

        roles = hammer.query(Role.class).list();
        for (Role role : roles) {
            assertEquals(role.getDescp(), "descp_" + role.getId());
        }
    }

    @Test
    public void testUpdateMulityPrimaryKey() {
        UserRole userRole = new UserRole();
        userRole.setRoleId(3);
        userRole.setUserId(3);
        userRole.setDescp("descp_update_" + Randoms.getInt(99));
        userRole.setDescp2("descp2_update_" + Randoms.getInt(99));
        hammer.update(userRole);

        UserRole ur = hammer.get(userRole);

        assertEquals(ur.getUserId(), userRole.getUserId());
        assertEquals(ur.getRoleId(), userRole.getRoleId());
        assertEquals(ur.getDescp(), userRole.getDescp());
        assertEquals(ur.getDescp2(), userRole.getDescp2());
    }

    @Test
    public void testUpdateMulityPrimaryKey2() {
        UserRole2 userRole = new UserRole2();
        userRole.setRole(new Role(3));
        userRole.setUser(new User(3));
        userRole.setDescp("descp_update_" + Randoms.getInt(99));
        userRole.setDescp2("descp2_update_" + Randoms.getInt(99));
        hammer.update(userRole);

        UserRole2 ur = hammer.get(userRole);

        assertEquals(ur.getUser().getId(), userRole.getUser().getId());
        assertEquals(ur.getRole().getId(), userRole.getRole().getId());
        assertEquals(ur.getDescp(), userRole.getDescp());
        assertEquals(ur.getDescp2(), userRole.getDescp2());
    }

    @Test
    public void testMerge() {
        assertTrue(hammer.merge(nullObject) == 0);
        assertTrue(hammer.merge(emptyList).length == 0);
        assertTrue(hammer.merge(emptyArray).length == 0);

        Role r = new Role();
        r.setName("name");
        r.setDescp("descp");
        hammer.save(r);

        Role r3 = hammer.get(r);
        assertNotNull(r3.getDescp());
        assertEquals(r3.getName(), r.getName());

        Role r2 = new Role();
        r2.setId(r.getId());
        r2.setName("merge_name" + Randoms.getInt(100));
        hammer.merge(r2);

        r3 = hammer.get(r2);

        assertEquals(r3.getName(), r2.getName());

        assertEquals(r3.getDescp(), r.getDescp());

        assertNotNull(r3.getDescp());

        hammer.delete(r2);

        r3 = hammer.get(r2);

        assertNull(r3);

        List<Role> roles = new ArrayList<>();
        String descp = "descp";
        String descpUpdate = "descp_merged";
        String descpUpdate2 = "descp_merged2";
        for (int i = 0; i < 3; i++) {
            Role role = new Role();
            role.setName("name");
            role.setDescp(descp);
            hammer.save(role);
            roles.add(role);
        }
        for (int i = 0; i < 3; i++) {
            Role role = roles.get(i);
            Role load = hammer.get(role.getId(), Role.class);
            assertEquals(load.getId(), role.getId());
            assertEquals(load.getName(), role.getName());
            assertEquals(load.getDescp(), descp);
            role.setDescp(descpUpdate);
        }
        hammer.merge(roles);
        for (int i = 0; i < 3; i++) {
            Role role = roles.get(i);
            Role load = hammer.get(role.getId(), Role.class);
            assertEquals(load.getId(), role.getId());
            assertEquals(load.getName(), role.getName());
            assertEquals(load.getDescp(), descpUpdate);
            role.setDescp(descpUpdate2);
        }
        hammer.merge(roles.toArray(new Role[roles.size()]));
        for (int i = 0; i < 3; i++) {
            Role role = roles.get(i);
            Role load = hammer.get(role.getId(), Role.class);
            assertEquals(load.getId(), role.getId());
            assertEquals(load.getName(), role.getName());
            assertEquals(load.getDescp(), descpUpdate2);
        }
        hammer.delete(roles);

    }

    @Test
    public void testMergeNotChange() {
        Role r = new Role();
        r.setName("name");
        r.setDescp("descp");
        hammer.save(r);

        Role r3 = hammer.get(r);
        assertNotNull(r3.getDescp());
        assertEquals(r3.getName(), r.getName());

        Role r2 = new Role();
        r2.setId(r.getId());
        hammer.merge(r2);

        r3 = hammer.get(r2);

        assertEquals(r3.getName(), r.getName());

        assertEquals(r3.getDescp(), r.getDescp());

        assertNotNull(r3.getDescp());

        hammer.delete(r2);

        r3 = hammer.get(r2);

        assertNull(r3);

    }

    @Test
    public void testMerge2() {
        UserInfo ui = new UserInfo();
        ui.setId(2);
        ui.setDescp("descp_" + Randoms.getInt(100));
        hammer.merge(ui);

        UserInfo ui2 = hammer.get(ui);
        assertNotNull(ui2.getName());
        assertEquals(ui2.getName(), "翼");

        String d = "罗湖1";
        ui = new UserInfo();
        ui.setId(2);
        ui.setDivision(new DistrictDivision());
        ui.getDivision().setDistrict(d);
        hammer.merge(ui);

        ui2 = hammer.get(ui);
        assertNotNull(ui2.getName());
        assertEquals(ui2.getDivision().getDistrict(), d);

    }

    @Test
    public void testMergeMulityPrimaryKey() {
        UserRole ur = new UserRole();
        ur.setRoleId(4);
        ur.setUserId(4);
        ur.setDescp("descp_update_" + Randoms.getInt(99));
        hammer.merge(ur);

        UserRole userRole = hammer.get(ur);

        assertEquals(userRole.getUserId(), ur.getUserId());
        assertEquals(userRole.getRoleId(), ur.getRoleId());
        assertEquals(userRole.getDescp(), ur.getDescp());
        assertNull(ur.getDescp2());
        assertNotNull(userRole.getDescp2());
    }

    @Test
    public void testDelete() {
        assertTrue(hammer.delete(nullObject) == 0);
        assertTrue(hammer.delete(emptyList).length == 0);
        assertTrue(hammer.delete(emptyArray).length == 0);
        assertTrue(hammer.delete(0, (Class<Object>) null) == 0);
        assertTrue(hammer.delete(nullObject, User.class) == 0);

        Role r = role();
        hammer.save(r);
        assertNotNull(r.getId());

        hammer.delete(r);

        Role role = hammer.get(r);
        assertNull(role);

        Role r2 = role();
        hammer.save(r2);
        assertNotNull(r2.getId());

        hammer.delete(r2.getId(), r2.getClass());

        Role role2 = hammer.get(r2);
        assertNull(role2);
    }

    @Test
    public void testDeleteBatch() {
        assertTrue(hammer.delete(emptyList).length == 0);
        assertTrue(hammer.delete(emptyArray).length == 0);
        assertTrue(hammer.delete(emptyList, Role.class).length == 0);
        assertTrue(hammer.delete(emptyArray, Role.class).length == 0);

        List<Role> roles = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            roles.add(role());
        }
        int results[] = hammer.save(roles);
        assertEquals(hammer.delete(roles), results);

        results = hammer.save(roles);
        assertEquals(hammer.delete(CollectionUtils.toArray(roles)), results);

        results = hammer.save(roles);
        assertEquals(hammer.delete(roles.stream().map(r -> r.getId()).collect(Collectors.toList()), Role.class),
                results);

        results = hammer.save(roles);
        assertEquals(
                hammer.delete(CollectionUtils.toArray(roles.stream().map(r -> r.getId()).collect(Collectors.toList())),
                        Role.class),
                results);
    }

    @Test
    public void testDeleteMulityPrimaryKey() {

        UserRole userRole = new UserRole();
        userRole.setRoleId(111);
        userRole.setUserId(111);

        UserRole ur = hammer.get(userRole);
        //        UserRole ur = hammerJdbc.query(UserRole.class).where().eq("role_id", 11).and().eq("user_id", 11).single();
        if (ur == null) {
            hammer.save(userRole);
        }

        hammer.delete(userRole);
    }

    @Test
    public void testDeleteMulityPrimaryKey2() {
        UserRole2 userRole = new UserRole2();
        userRole.setRole(new Role(111));
        userRole.setUser(new User(111));

        UserRole2 ur = hammer.get(userRole);
        if (ur == null) {
            hammer.save(userRole);
        }

        hammer.delete(userRole);
    }

    @Test
    public void testDeleter() {
        Role role = role();

        hammer.save(role);

        Role load = hammer.get(role);

        assertEquals(load.getId(), role.getId());
        assertEquals(load.getName(), role.getName());

        int result = hammer.delete("role").where().eq("id", role.getId()).execute();
        assertEquals(result, 1);

        load = hammer.get(role);
        assertNull(load);
    }

    @Test
    public void testDeleterEntity() {
        Role r = role();
        Role r2 = role();
        Role r3 = role();
        Role r4 = role();
        hammer.save(r, r2, r3, r4);

        hammer.delete(Role.class).where().in(Role::getId, r2.getId()).or().eq(Role::getId, r3.getId()).or()
                .ge(Role::getId, r4.getId()).execute();

        r = hammer.get(r);
        r2 = hammer.get(r2);
        r3 = hammer.get(r3);
        r4 = hammer.get(r4);
        assertNotNull(r);
        assertNull(r2);
        assertNull(r3);
        assertNull(r4);

    }

    @Test
    public void testDeleterEntity1() {
        Role r = role();
        Role r2 = role();
        Role r3 = role();
        Role r4 = role();
        hammer.save(r, r2, r3, r4);
        Collection<Integer> ids = ArrayUtils.toList(r.getId(), r2.getId());
        hammer.delete(Role.class).where()
                //                .in(Role::getId, (Collection<Integer>) ArrayUtils.toList(r.getId(), r2.getId())).or()
                .in(Role::getId, ids).or().eq(Role::getId, r3.getId()).or().ge(Role::getId, r4.getId()).execute();

        r = hammer.get(r);
        r2 = hammer.get(r2);
        r3 = hammer.get(r3);
        r4 = hammer.get(r4);
        assertNull(r);
        assertNull(r2);
        assertNull(r3);
        assertNull(r4);

    }

    @Test
    public void testDeleterEntity2() {
        Role r = role();
        Role r2 = role();
        Role r3 = role();
        Role r4 = role();
        hammer.save(r, r2, r3, r4);

        hammer.delete(Role.class).where().in(Role::getId, new Integer[] { r.getId(), r2.getId() }).or()
                .eq(Role::getId, r3.getId()).or().ge(Role::getId, r4.getId()).execute();

        r = hammer.get(r);
        r2 = hammer.get(r2);
        r3 = hammer.get(r3);
        r4 = hammer.get(r4);
        assertNull(r);
        assertNull(r2);
        assertNull(r3);
        assertNull(r4);

    }

    @Test
    public void testUpdater() {
        int id = 10;
        String updated = "descp_1122";
        int result = hammer.update("role").set("descp", updated).where().eq("id", id).execute();
        assertEquals(result, 1);

        String descp = ((SqldbHammer) hammer).getJdbc().queryString("select descp from role where  id = ?", id);
        assertEquals(descp, updated);
    }

    @Test
    public void testUpdaterEntity() {
        int id = 10;
        String newName = "name_updater_" + Randoms.getInt(99);
        String newDescp = "descp_updater_" + Randoms.getInt(99);
        hammer.update(Role.class).set(Role::getName, newName).property(Role::getDescp).set(newDescp).where()
                .eq(Role::getId, id).execute();
        Role role = hammer.get(id, Role.class);
        assertEquals(role.getName(), newName);
        assertEquals(role.getDescp(), newDescp);

        id = 11;
        newName = "name_updater_" + Randoms.getInt(90);
        newDescp = "descp_updater_" + Randoms.getInt(99);
        hammer.update(Role.class).set(Role::getName, newName).property(Role::getDescp).set(newDescp).where()
                .eq(Role::getId, id).execute();
        role = hammer.get(id, Role.class);
        assertEquals(role.getName(), newName);
        assertEquals(role.getDescp(), newDescp);

        id = 12;
        newName = "name_updater_" + Randoms.getInt(90);
        newDescp = "descp_updater_" + Randoms.getInt(99);
        hammer.update(Role.class).set(Role::getName, newName).property(Role::getDescp).set(newDescp).where()
                .eq(Role::getId, id).execute();
        role = hammer.get(id, Role.class);
        assertEquals(role.getName(), newName);
        assertEquals(role.getDescp(), newDescp);

        id = 12;
        boolean set = Randoms.getBoolean();
        final String setNewName = "name_updater_" + Randoms.getInt(90);

        Role oldRole = hammer.get(id, Role.class);
        hammer.update(Role.class).set(u -> {
            if (set) {
                u.set(Role::getName, setNewName);
            } else {
                u.set(Role::getName, oldRole.getName());
            }
        }).where().eq(Role::getId, id).execute();

        role = hammer.get(id, Role.class);

        if (set) {
            assertEquals(role.getName(), setNewName);
        } else {
            assertEquals(role.getName(), oldRole.getName());
        }

    }

    @Test
    public void testUpdaterEntity2() {
        int id = 10;
        String newName = "name_updater_" + Randoms.getInt(99);
        String newDescp = "descp_updater_" + Randoms.getInt(99);
        hammer.update(Role.class).set(Role::getName, newName).property(Role::getDescp).set(newDescp).where()
                .eq(Role::getId, id).execute();
        Role role = hammer.get(id, Role.class);
        assertEquals(role.getName(), newName);
        assertEquals(role.getDescp(), newDescp);

        id = 10;
        final String setNewName = "name_updater_" + Randoms.getInt(90);
        Role oldRole = hammer.get(id, Role.class);
        final boolean unset = false;

        hammer.update(Role.class).set(u -> {
            if (unset) {
                u.set(Role::getName, setNewName);
            }
        }).property(Role::getDescp).set(oldRole.getDescp()).where().eq(Role::getId, id).execute();

        role = hammer.get(id, Role.class);
        assertEquals(role.getName(), oldRole.getName());

        final boolean set = true;

        hammer.update(Role.class).set(u -> {
            if (set) {
                u.set(Role::getName, setNewName);
            }
        }).property(Role::getDescp).set(oldRole.getDescp()).where().eq(Role::getId, id).execute();

        role = hammer.get(id, Role.class);
        assertEquals(role.getName(), setNewName);

        final String setNewName2 = "name_updater_" + Randoms.getInt(90);
        oldRole = hammer.get(id, Role.class);
        hammer.update(Role.class).property(Role::getName).set(u -> {
            if (true) {
                u.set(setNewName2);
            }
        }).property(Role::getDescp).set(oldRole.getDescp()).where().eq(Role::getId, id).execute();

        role = hammer.get(id, Role.class);
        assertEquals(role.getName(), setNewName2);

    }

    //    @Test
    //    public void testUpdater2() {
    //        User user = new User();
    //        user.setAge(10);
    //        user.setUsername(Randoms.getString(10));
    //        user.setPwd(Randoms.getString(6));
    //        user.setMobileNo(Randoms.getString(11, CharType.NUMBER_CASE));
    //        hammer.save(user);
    //        hammer.update(User.class).propertyNumber(User::getAge).increase(2).where().eq(User::getId, user.getId()).and()
    //                .ge("age - 1", 10).execute();
    //    }

    @Test
    public void testUpdaterEntityIncrease() {
        Integer id = 1;
        User user = hammer.get(new User(id));

        Integer age = user.getAge();
        hammer.update(User.class).increase(User::getAge, 1).where().eq(User::getId, id).execute();
        age++;
        user = hammer.get(user);
        assertEquals(user.getAge(), age);

        hammer.update(User.class).property(User::getAge).increase(1).where().eq(User::getId, id).execute();
        age++;
        user = hammer.get(user);
        assertEquals(user.getAge(), age);

        hammer.update(User.class).increase(User::getAge, 1).where().eq(User::getId, id).execute();
        age++;
        user = hammer.get(user);
        assertEquals(user.getAge(), age);

        hammer.update(User.class).property(User::getAge).increase(1).where().eq(User::getId, id).execute();
        age++;
        user = hammer.get(user);
        assertEquals(user.getAge(), age);

    }

    @Test
    public void testQuery() {
        List<Map<String, Object>> list = hammer.query("user").property("username", "password", "age").sort().asc("age")
                .list();
        int age = Integer.MIN_VALUE;
        for (Map<String, Object> map : list) {
            Integer a = (Integer) map.get("age");
            System.err.println(age + "    " + a);
            assertTrue(age <= a);
            age = a;
        }
    }

    @Test
    public void testQueryEntity() {
        List<Role> roles = hammer.query(Role.class).where().gt(Role::getId, 5).and().le(Role::getId, 10).list();
        for (Role role : roles) {
            assertTrue(role.getId() > 5 && role.getId() <= 10);
        }

        Integer id = 10;
        Role r = hammer.query(Role.class).where().eq(Role::getId, id).single();
        assertEquals(r.getId(), id);
    }

    @Test
    public void testQueryLimit() {
        List<Role> roles = hammer.query(Role.class).where().gt(Role::getId, 5).and().le(Role::getId, 10).limit(2)
                .list();
        assertTrue(roles.size() == 2);
        for (Role role : roles) {
            System.out.println(role);
            assertTrue(role.getId() > 5 && role.getId() <= 10);
        }

        roles = hammer.query(Role.class).where().gt(Role::getId, 5).and().le(Role::getId, 10).limit(2, 3).list();
        assertTrue(roles.size() == 3);
        for (Role role : roles) {
            System.out.println(role);
            assertTrue(role.getId() > 5 && role.getId() <= 10);
        }

        roles = hammer.query(Role.class).where().eq(Role::getId, 4).or().group().gt(Role::getId, 5).and()
                .le(Role::getId, 10).limit(2, 3).list();
        assertTrue(roles.size() == 3);
        for (Role role : roles) {
            System.out.println(role);
        }
    }

    @Test
    public void testQueryLimit2() {
        List<Role> roles = hammer.query(Role.class).where().eq(Role::getId, 4).or().group().gt(Role::getId, 5).and()
                .le(Role::getId, 10).limit(2, 3).list();

        assertTrue(roles.size() == 3);
        for (Role role : roles) {
            System.out.println(role);
        }

        PaginationResults<Role> rolePage = hammer.query(Role.class).where().le(Role::getId, 10).limit(2, 3)
                .pagination();
        assertTrue(rolePage.getTotal() == 10);
        assertTrue(rolePage.getPageResults().size() == 3);
    }

    @Test
    public void testQuerySort() {
        List<Role> roles = hammer.query(Role.class).where().eq(Role::getId, 4).or().group().gt(Role::getId, 5).and()
                .le(Role::getId, 10).sort().asc(Role::getId).desc(Role::getName).list();
        for (Role role : roles) {
            System.out.println(role);
        }
    }

    @Test
    public void testQuerySingle() {
        Role role = new Role();
        role.setId(4);
        Role r = hammer.querySingle(Role.class, role::getId);
        assertEquals(r.getId(), role.getId());
    }

    @Test
    public void testQueryList() {
        Role role = new Role();
        role.setId(4);
        Role role2 = new Role();
        role2.setId(5);
        List<Role> list = hammer.queryList(Role.class, LogicOperator.OR, role::getId, role2::getId);
        assertEquals(list.size(), 2);
        assertEquals(list.get(0).getId(), role.getId());
        assertEquals(list.get(1).getId(), role2.getId());

        list = hammer.queryList(Role.class, LogicOperator.AND, role::getId, role2::getId);
        assertEquals(list.size(), 0);

        Role _role = hammer.get(role);
        list = hammer.queryList(Role.class, LogicOperator.AND, role::getId, _role::getName);
        assertEquals(list.size(), 1);
        assertEquals(list.get(0).getId(), _role.getId());
        assertEquals(list.get(0).getName(), _role.getName());
    }

    @Test
    void testQueryExpresstion() {
        Integer id = 1;
        User user = hammer.query(User.class).where().eq(User::getId, id).single();
        assertEquals(user.getId(), id);

        // IMPLSOON 后续看如何实现expression
        //        user = hammer.query(User.class).where().eq(User::getId, id).and()
        //                .expression("age - :age >= 0", new ChainMapImpl<String, Object>().putChain("age", 100)).single();
        //                assertNull(user);
        //
        //        user = hammer.query(User.class).where().eq(User::getId, id).and().expression("age - ? >= 0", 100).single();
        //        assertNull(user);
        //
        //        user = hammer.query(User.class).where().eq(User::getId, id).and().expression("username = password").single();
        //        assertNull(user);
    }

    @Test
    void testCodeComplete() {
        assertNotNull(((SqldbHammer) hammer).getJdbc());
        assertNotNull(((SqldbHammer) hammer).getMappingFactory());
    }
}
