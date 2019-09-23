
package cn.featherfly.juorm.rdb.jdbc;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertNull;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import cn.featherfly.common.lang.RandomUtils;
import cn.featherfly.juorm.Juorm;
import cn.featherfly.juorm.rdb.jdbc.vo.Article;
import cn.featherfly.juorm.rdb.jdbc.vo.DistrictDivision;
import cn.featherfly.juorm.rdb.jdbc.vo.Role;
import cn.featherfly.juorm.rdb.jdbc.vo.User;
import cn.featherfly.juorm.rdb.jdbc.vo.UserInfo;
import cn.featherfly.juorm.rdb.jdbc.vo.UserRole;
import cn.featherfly.juorm.rdb.jdbc.vo.UserRole2;

/**
 * <p>
 * SqlOrmTest
 * </p>
 *
 * @author zhongj
 */
public class JuormJdbcTest extends JdbcTestBase {

    protected Juorm juorm;

    @BeforeClass
    void before() {
        juorm = new JuormJdbcImpl(jdbc, mappingFactory, configFactory);
    }

    @Test
    public void testGet() {
        Integer id = 1;
        Role role = juorm.get(id, Role.class);
        assertEquals(role.getId(), id);
        assertNotNull(role.getName());
        assertNotNull(role.getDescp());
        assertEquals(role.getName(), "n_1");
        assertEquals(role.getDescp(), "descp_1");
        System.out.println(role);
    }

    @Test
    public void testGet2() {
        Integer id = 1;
        UserInfo ui = juorm.get(id, UserInfo.class);
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
    public void testGetMulityPrimaryKey() {
        UserRole userRole = new UserRole();
        Integer roleId = 2;
        Integer userId = 2;
        userRole.setRoleId(roleId);
        userRole.setUserId(userId);

        UserRole ur = juorm.get(userRole);
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

        UserRole2 ur = juorm.get(userRole);

        assertEquals(ur.getUser().getId(), userRole.getUser().getId());
        assertEquals(ur.getUser().getId(), userRole.getRole().getId());
        assertEquals(ur.getDescp(), "descp");
        assertEquals(ur.getDescp2(), "descp2");
        System.out.println(ur);
    }

    @Test
    public void testSave() {
        Role r = role();
        juorm.save(r);
        assertNotNull(r.getId());

        juorm.delete(r);

        Role role = juorm.get(r);
        assertNull(role);

        r = role();
        r.setName("name_" + RandomUtils.getRandomInt(100));
        juorm.save(r);
        assertNotNull(r.getId());

        role = juorm.get(r);
        assertEquals(role.getId(), r.getId());
        assertEquals(role.getName(), r.getName());

        juorm.delete(r);

        role = juorm.get(r);
        assertNull(role);
    }

    @Test
    public void testSave2() {
        Article a = new Article();
        a.setTitle("title_" + RandomUtils.getRandomInt(100));
        a.setContent("content_" + RandomUtils.getRandomInt(1000));
        juorm.save(a);
        assertNotNull(a.getId());

        Article article = juorm.get(a);
        assertEquals(article.getId(), a.getId());
        assertEquals(article.getTitle(), a.getTitle());
        assertEquals(article.getContent(), a.getContent());
    }

    @Test
    public void testSave3() {
        UserInfo ui = new UserInfo();
        ui.setUser(new User(1));
        ui.setDescp("descp_" + RandomUtils.getRandomInt(100));
        ui.setName("name_" + RandomUtils.getRandomInt(100));
        ui.setDivision(new DistrictDivision("四川", "成都", "高新"));
        juorm.save(ui);

        assertNotNull(ui.getId());

        UserInfo userInfo = juorm.get(ui);
        assertEquals(userInfo.getId(), ui.getId());
        assertEquals(userInfo.getName(), ui.getName());
        assertEquals(userInfo.getDescp(), ui.getDescp());
        assertEquals(userInfo.getUser().getId(), ui.getUser().getId());
        assertEquals(userInfo.getDivision().getProvince(), ui.getDivision().getProvince());
        assertEquals(userInfo.getDivision().getCity(), ui.getDivision().getCity());
        assertEquals(userInfo.getDivision().getDistrict(), ui.getDivision().getDistrict());

        juorm.delete(userInfo);

        userInfo = juorm.get(userInfo);
        assertNull(userInfo);

    }

    @Test
    public void testSaveMultyKey() {
        UserRole ur = new UserRole();
        ur.setUserId(RandomUtils.getRandomInt(1000));
        ur.setRoleId(RandomUtils.getRandomInt(1000));
        ur.setDescp("descp_" + RandomUtils.getRandomInt(1000));
        ur.setDescp2("descp2_" + RandomUtils.getRandomInt(1000));
        juorm.save(ur);

        UserRole userRole = juorm.get(ur);
        assertEquals(userRole.getUserId(), ur.getUserId());
        assertEquals(userRole.getRoleId(), ur.getRoleId());
        assertEquals(userRole.getDescp(), ur.getDescp());
        assertEquals(userRole.getDescp2(), ur.getDescp2());

        juorm.delete(userRole);

        userRole = juorm.get(ur);
        assertNull(userRole);
    }

    @Test
    public void testSaveMultyKey2() {
        UserRole2 ur = new UserRole2();
        ur.setUser(new User(RandomUtils.getRandomInt(1000)));
        ur.setRole(new Role(RandomUtils.getRandomInt(1000)));
        ur.setDescp("descp" + RandomUtils.getRandomInt(1000));
        ur.setDescp2("descp2" + RandomUtils.getRandomInt(1000));
        juorm.save(ur);

        UserRole2 userRole = juorm.get(ur);
        assertEquals(userRole.getUser().getId(), ur.getUser().getId());
        assertEquals(userRole.getRole().getId(), ur.getRole().getId());
        assertEquals(userRole.getDescp(), ur.getDescp());
        assertEquals(userRole.getDescp2(), ur.getDescp2());

        juorm.delete(userRole);

        userRole = juorm.get(ur);
        assertNull(userRole);
    }

    @Test
    public void testUpdate() {
        Role r = new Role();
        r.setName("name");
        r.setDescp("descp");
        juorm.save(r);

        Role r3 = juorm.get(r);
        assertNotNull(r3.getDescp());
        assertEquals(r3.getName(), r.getName());

        Role r2 = new Role();
        r2.setId(r.getId());
        r2.setName("update_" + RandomUtils.getRandomInt(100));
        juorm.update(r2);

        r3 = juorm.get(r2);

        assertEquals(r3.getName(), r2.getName());

        assertNull(r3.getDescp());

        juorm.delete(r2);

        r3 = juorm.get(r2);
        assertNull(r3);
    }

    @Test
    public void testUpdate2() {
        UserInfo ui = new UserInfo();
        ui.setUser(new User(1));
        ui.setDescp("descp_" + RandomUtils.getRandomInt(100));
        ui.setName("name_" + RandomUtils.getRandomInt(100));
        ui.setDivision(new DistrictDivision("四川", "成都", "高新"));
        juorm.save(ui);

        UserInfo userInfo = juorm.get(ui);
        userInfo.setDescp("descp_" + RandomUtils.getRandomInt(100));
        userInfo.getDivision().setDistrict("青羊");
        juorm.update(userInfo);

        UserInfo userInfo2 = juorm.get(ui);

        assertEquals(userInfo2.getDescp(), userInfo.getDescp());
        assertEquals(userInfo2.getId(), userInfo.getId());
        assertEquals(userInfo2.getName(), userInfo.getName());
        assertEquals(userInfo2.getDescp(), userInfo.getDescp());
        assertEquals(userInfo2.getUser().getId(), userInfo.getUser().getId());
        assertEquals(userInfo2.getDivision().getProvince(), userInfo.getDivision().getProvince());
        assertEquals(userInfo2.getDivision().getCity(), userInfo.getDivision().getCity());
        assertEquals(userInfo2.getDivision().getDistrict(), userInfo.getDivision().getDistrict());
        assertEquals(userInfo2.getDivision().getDistrict(), "青羊");

        juorm.delete(userInfo);

        userInfo2 = juorm.get(userInfo);
        assertNull(userInfo2);
    }

    @Test
    public void testUpdateMulityPrimaryKey() {
        UserRole userRole = new UserRole();
        userRole.setRoleId(3);
        userRole.setUserId(3);
        userRole.setDescp("descp_update_" + RandomUtils.getRandomInt(99));
        userRole.setDescp2("descp2_update_" + RandomUtils.getRandomInt(99));
        juorm.update(userRole);

        UserRole ur = juorm.get(userRole);

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
        userRole.setDescp("descp_update_" + RandomUtils.getRandomInt(99));
        userRole.setDescp2("descp2_update_" + RandomUtils.getRandomInt(99));
        juorm.update(userRole);

        UserRole2 ur = juorm.get(userRole);

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
        juorm.save(r);

        Role r3 = juorm.get(r);
        assertNotNull(r3.getDescp());
        assertEquals(r3.getName(), r.getName());

        Role r2 = new Role();
        r2.setId(r.getId());
        r2.setName("merge_name" + RandomUtils.getRandomInt(100));
        juorm.merge(r2);

        r3 = juorm.get(r2);

        assertEquals(r3.getName(), r2.getName());

        assertEquals(r3.getDescp(), r.getDescp());

        assertNotNull(r3.getDescp());

        juorm.delete(r2);

        r3 = juorm.get(r2);

        assertNull(r3);

    }

    @Test
    public void testMerge2() {
        UserInfo ui = new UserInfo();
        ui.setId(2);
        ui.setDescp("descp_" + RandomUtils.getRandomInt(100));
        juorm.merge(ui);

        UserInfo ui2 = juorm.get(ui);
        assertNotNull(ui2.getName());
        assertEquals(ui2.getName(), "翼");

        String d = "罗湖1";
        ui = new UserInfo();
        ui.setId(2);
        ui.setDivision(new DistrictDivision());
        ui.getDivision().setDistrict(d);
        juorm.merge(ui);

        ui2 = juorm.get(ui);
        assertNotNull(ui2.getName());
        assertEquals(ui2.getDivision().getDistrict(), d);

    }

    @Test
    public void testMergeMulityPrimaryKey() {
        UserRole ur = new UserRole();
        ur.setRoleId(4);
        ur.setUserId(4);
        ur.setDescp("descp_update_" + RandomUtils.getRandomInt(99));
        juorm.merge(ur);

        UserRole userRole = juorm.get(ur);

        assertEquals(userRole.getUserId(), ur.getUserId());
        assertEquals(userRole.getRoleId(), ur.getRoleId());
        assertEquals(userRole.getDescp(), ur.getDescp());
        assertNull(ur.getDescp2());
        assertNotNull(userRole.getDescp2());
    }

    @Test
    public void testDelete() {
        Role r = role();
        juorm.save(r);
        assertNotNull(r.getId());

        juorm.delete(r);

        Role role = juorm.get(r);
        assertNull(role);
    }

    @Test
    public void testDeleteMulityPrimaryKey() {

        UserRole userRole = new UserRole();
        userRole.setRoleId(111);
        userRole.setUserId(111);

        UserRole ur = juorm.get(userRole);
        //        UserRole ur = juormJdbc.query(UserRole.class).where().eq("role_id", 11).and().eq("user_id", 11).single();
        if (ur == null) {
            juorm.save(userRole);
        }

        juorm.delete(userRole);
    }

    @Test
    public void testDeleteMulityPrimaryKey2() {
        UserRole2 userRole = new UserRole2();
        userRole.setRole(new Role(111));
        userRole.setUser(new User(111));

        UserRole2 ur = juorm.get(userRole);
        if (ur == null) {
            juorm.save(userRole);
        }

        juorm.delete(userRole);
    }

    @Test
    public void testDeleter() {
        Role r = role();
        Role r2 = role();
        Role r3 = role();
        Role r4 = role();
        juorm.save(r, r2, r3, r4);
        juorm.delete(Role.class).where().in("id", new Integer[] { r.getId(), r2.getId() }).or().eq("id", r3.getId())
                .or().ge("id", r4.getId()).execute();

        r = juorm.get(r);
        r2 = juorm.get(r2);
        r3 = juorm.get(r3);
        r4 = juorm.get(r4);
        assertNull(r);
        assertNull(r2);
        assertNull(r3);
        assertNull(r4);
    }

    @Test
    public void testUpdater() {
        int id = 10;
        String newName = "name_updater_" + RandomUtils.getRandomInt(99);
        String newDescp = "descp_updater_" + RandomUtils.getRandomInt(99);
        juorm.update(Role.class).set("name", newName).property("descp").set(newDescp).where().eq("id", id).execute();
        Role role = juorm.get(id, Role.class);
        assertEquals(role.getName(), newName);
        assertEquals(role.getDescp(), newDescp);

        id = 11;
        newName = "name_updater_" + RandomUtils.getRandomInt(90);
        newDescp = "descp_updater_" + RandomUtils.getRandomInt(99);
        juorm.update(Role.class).set(Role::getName, newName).property(Role::getDescp).set(newDescp).where().eq("id", id)
                .execute();
        role = juorm.get(id, Role.class);
        assertEquals(role.getName(), newName);
        assertEquals(role.getDescp(), newDescp);

        id = 12;
        newName = "name_updater_" + RandomUtils.getRandomInt(90);
        newDescp = "descp_updater_" + RandomUtils.getRandomInt(99);
        juorm.update(Role.class).set(Role::getName, newName).property(Role::getDescp).set(newDescp).where()
                .eq(Role::getId, id).execute();
        role = juorm.get(id, Role.class);
        assertEquals(role.getName(), newName);
        assertEquals(role.getDescp(), newDescp);
    }

    @Test
    public void testUpdaterIncrease() {
        Integer id = 1;
        User user = juorm.get(new User(id));

        Integer age = user.getAge();
        juorm.update(User.class).increase("age", 1).where().eq("id", id).execute();
        age++;
        user = juorm.get(user);
        assertEquals(user.getAge(), age);

        juorm.update(User.class).propertyNumber("age").increase(1).where().eq("id", id).execute();
        age++;
        user = juorm.get(user);
        assertEquals(user.getAge(), age);

        juorm.update(User.class).increase(User::getAge, 1).where().eq(User::getId, id).execute();
        age++;
        user = juorm.get(user);
        assertEquals(user.getAge(), age);

        juorm.update(User.class).propertyNumber(User::getAge).increase(1).where().eq(User::getId, id).execute();
        age++;
        user = juorm.get(user);
        assertEquals(user.getAge(), age);

    }

    @Test
    public void testQuery() {
        List<Role> roles = juorm.query(Role.class).where().gt("id", 5).and().le("id", 10).list();
        for (Role role : roles) {
            assertTrue(role.getId() > 5 && role.getId() <= 10);
        }

        Integer id = 10;
        Role r = juorm.query(Role.class).where().eq("id", id).single();
        assertEquals(r.getId(), id);
    }

    @Test
    public void testQueryLimit() {
        List<Role> roles = juorm.query(Role.class).where().gt("id", 5).and().le("id", 10).limit(2).list();
        assertTrue(roles.size() == 2);
        for (Role role : roles) {
            System.out.println(role);
            assertTrue(role.getId() > 5 && role.getId() <= 10);
        }

        roles = juorm.query(Role.class).where().gt("id", 5).and().le("id", 10).limit(2, 3).list();
        assertTrue(roles.size() == 3);
        for (Role role : roles) {
            System.out.println(role);
            assertTrue(role.getId() > 5 && role.getId() <= 10);
        }

        roles = juorm.query(Role.class).where().eq("id", 4).or().group().gt("id", 5).and().le("id", 10).limit(2, 3)
                .list();
        assertTrue(roles.size() == 3);
        for (Role role : roles) {
            System.out.println(role);
        }
    }

    @Test
    public void testQueryLimit2() {
        List<Role> roles = juorm.query(Role.class).where().eq("id", 4).or().group().gt("id", 5).and().le("id", 10)
                .limit(2, 3).list();
        assertTrue(roles.size() == 3);
        for (Role role : roles) {
            System.out.println(role);
        }
    }

    @Test
    public void testQuerySort() {
        List<Role> roles = juorm.query(Role.class).where().eq("id", 4).or().group().gt("id", 5).and().le("id", 10)
                .sort().asc("id").desc("name").list();
        for (Role role : roles) {
            System.out.println(role);
        }
    }
}
