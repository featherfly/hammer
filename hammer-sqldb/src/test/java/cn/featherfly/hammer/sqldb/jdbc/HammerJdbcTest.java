
package cn.featherfly.hammer.sqldb.jdbc;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertNull;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import cn.featherfly.common.lang.ArrayUtils;
import cn.featherfly.common.lang.Randoms;
import cn.featherfly.common.repository.operate.LogicOperator;
import cn.featherfly.common.structure.HashChainMap;
import cn.featherfly.common.structure.page.PaginationResults;
import cn.featherfly.hammer.Hammer;
import cn.featherfly.hammer.sqldb.SqldbHammerImpl;
import cn.featherfly.hammer.sqldb.jdbc.vo.Article;
import cn.featherfly.hammer.sqldb.jdbc.vo.DistrictDivision;
import cn.featherfly.hammer.sqldb.jdbc.vo.Role;
import cn.featherfly.hammer.sqldb.jdbc.vo.User;
import cn.featherfly.hammer.sqldb.jdbc.vo.UserInfo;
import cn.featherfly.hammer.sqldb.jdbc.vo.UserRole;
import cn.featherfly.hammer.sqldb.jdbc.vo.UserRole2;

/**
 * <p>
 * SqlOrmTest
 * </p>
 *
 * @author zhongj
 */
public class HammerJdbcTest extends JdbcTestBase {

    protected Hammer hammer;

    @BeforeClass
    void before() {
        hammer = new SqldbHammerImpl(jdbc, mappingFactory, configFactory);
    }

    @Test
    public void testGet() {
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
    public void testSave() {
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
        List<Role> roles = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            roles.add(role());
        }
        int size = hammer.save(roles);

        for (Role role : roles) {
            Role r = hammer.get(role);
            assertEquals(r.getId(), role.getId());
            assertEquals(r.getName(), role.getName());
            hammer.delete(role);
        }
        assertTrue(size == roles.size());
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
    public void testUpdate() {
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

        hammer.delete(r2);

        r3 = hammer.get(r2);
        assertNull(r3);
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
        Role r = role();
        Role r2 = role();
        Role r3 = role();
        Role r4 = role();
        hammer.save(r, r2, r3, r4);
        hammer.delete(Role.class).where().in(Role::getId, new Integer[] { r.getId(), r2.getId() }).or()
                .eq("id", r3.getId()).or().ge("id", r4.getId()).execute();

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
        String newName = "name_updater_" + Randoms.getInt(99);
        String newDescp = "descp_updater_" + Randoms.getInt(99);
        hammer.update(Role.class).set("name", newName).property("descp").set(newDescp).where().eq("id", id).execute();
        Role role = hammer.get(id, Role.class);
        assertEquals(role.getName(), newName);
        assertEquals(role.getDescp(), newDescp);

        id = 11;
        newName = "name_updater_" + Randoms.getInt(90);
        newDescp = "descp_updater_" + Randoms.getInt(99);
        hammer.update(Role.class).set(Role::getName, newName).property(Role::getDescp).set(newDescp).where()
                .eq("id", id).execute();
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
    public void testUpdater2() {
        int id = 10;
        String newName = "name_updater_" + Randoms.getInt(99);
        String newDescp = "descp_updater_" + Randoms.getInt(99);
        hammer.update(Role.class).set("name", newName).property("descp").set(newDescp).where().eq("id", id).execute();
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
        }).property("descp").set(oldRole.getDescp()).where().eq(Role::getId, id).execute();

        role = hammer.get(id, Role.class);
        assertEquals(role.getName(), oldRole.getName());

        final boolean set = true;

        hammer.update(Role.class).set(u -> {
            if (set) {
                u.set(Role::getName, setNewName);
            }
        }).property("descp").set(oldRole.getDescp()).where().eq(Role::getId, id).execute();

        role = hammer.get(id, Role.class);
        assertEquals(role.getName(), setNewName);

        final String setNewName2 = "name_updater_" + Randoms.getInt(90);
        oldRole = hammer.get(id, Role.class);
        hammer.update(Role.class).property(Role::getName).set(u -> {
            if (true) {
                u.set(setNewName2);
            }
        }).property("descp").set(oldRole.getDescp()).where().eq(Role::getId, id).execute();

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
    public void testUpdaterIncrease() {
        Integer id = 1;
        User user = hammer.get(new User(id));

        Integer age = user.getAge();
        hammer.update(User.class).increase("age", 1).where().eq("id", id).execute();
        age++;
        user = hammer.get(user);
        assertEquals(user.getAge(), age);

        hammer.update(User.class).propertyNumber("age").increase(1).where().eq("id", id).execute();
        age++;
        user = hammer.get(user);
        assertEquals(user.getAge(), age);

        hammer.update(User.class).increase(User::getAge, 1).where().eq(User::getId, id).execute();
        age++;
        user = hammer.get(user);
        assertEquals(user.getAge(), age);

        hammer.update(User.class).propertyNumber(User::getAge).increase(1).where().eq(User::getId, id).execute();
        age++;
        user = hammer.get(user);
        assertEquals(user.getAge(), age);

    }

    @Test
    public void testQuery() {
        List<Role> roles = hammer.query(Role.class).where().gt("id", 5).and().le("id", 10).list();
        for (Role role : roles) {
            assertTrue(role.getId() > 5 && role.getId() <= 10);
        }

        Integer id = 10;
        Role r = hammer.query(Role.class).where().eq("id", id).single();
        assertEquals(r.getId(), id);
    }

    @Test
    public void testQueryLimit() {
        List<Role> roles = hammer.query(Role.class).where().gt("id", 5).and().le("id", 10).limit(2).list();
        assertTrue(roles.size() == 2);
        for (Role role : roles) {
            System.out.println(role);
            assertTrue(role.getId() > 5 && role.getId() <= 10);
        }

        roles = hammer.query(Role.class).where().gt("id", 5).and().le("id", 10).limit(2, 3).list();
        assertTrue(roles.size() == 3);
        for (Role role : roles) {
            System.out.println(role);
            assertTrue(role.getId() > 5 && role.getId() <= 10);
        }

        roles = hammer.query(Role.class).where().eq("id", 4).or().group().gt("id", 5).and().le("id", 10).limit(2, 3)
                .list();
        assertTrue(roles.size() == 3);
        for (Role role : roles) {
            System.out.println(role);
        }
    }

    @Test
    public void testQueryLimit2() {
        List<Role> roles = hammer.query(Role.class).where().eq("id", 4).or().group().gt("id", 5).and().le("id", 10)
                .limit(2, 3).list();

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
        List<Role> roles = hammer.query(Role.class).where().eq("id", 4).or().group().gt("id", 5).and().le("id", 10)
                .sort().asc("id").desc("name").list();
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

        user = hammer.query(User.class).where().eq(User::getId, id).and()
                .expression("age - :age >= 0", new HashChainMap<String, Object>().putChain("age", 100)).single();
        assertNull(user);

        user = hammer.query(User.class).where().eq(User::getId, id).and().expression("age - ? >= 0", 100).single();
        assertNull(user);

        user = hammer.query(User.class).where().eq(User::getId, id).and().expression("username = password").single();
        assertNull(user);
    }
}
