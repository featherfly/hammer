
package cn.featherfly.hammer.sqldb.tpl.pre;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;
import java.util.Map;

import javax.validation.Validation;

import org.hibernate.validator.HibernateValidator;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import cn.featherfly.common.db.dialect.Dialects;
import cn.featherfly.common.structure.page.Page;
import cn.featherfly.common.structure.page.PaginationResults;
import cn.featherfly.common.structure.page.SimplePagination;
import cn.featherfly.hammer.Hammer;
import cn.featherfly.hammer.config.HammerConfigImpl;
import cn.featherfly.hammer.sqldb.SqldbHammerImpl;
import cn.featherfly.hammer.sqldb.jdbc.DataSourceTestBase;
import cn.featherfly.hammer.sqldb.jdbc.vo.r.Role;
import cn.featherfly.hammer.sqldb.jdbc.vo.r.User;
import cn.featherfly.hammer.sqldb.tpl.RoleMapper;
import cn.featherfly.hammer.sqldb.tpl.UserMapper;
import cn.featherfly.hammer.tpl.TplConfigFactoryImpl;
import cn.featherfly.hammer.tpl.freemarker.FreemarkerTemplatePreProcessor;
import cn.featherfly.hammer.tpl.mapper.TplDynamicExecutorFactory;

/**
 * <p>
 * SqlTplExecutorTest
 * </p>
 *
 * @author zhongj
 */
public class SqlTplDynamicExecutorTest extends DataSourceTestBase {

    UserMapper userMapper;

    RoleMapper roleMapper;

    Integer minAge = 5;
    Integer maxAge = 40;
    String username1 = "yufei";
    String username2 = "featherfly";
    String password = "123";

    @BeforeClass
    void setup() {
        TplConfigFactoryImpl configFactory = new TplConfigFactoryImpl("tpl_pre/", new FreemarkerTemplatePreProcessor());
        TplDynamicExecutorFactory mapperFactory = TplDynamicExecutorFactory.getInstance();
        //        TransverterManager transverterManager = new TransverterManager();
        //        transverterManager.register(new FuzzyQueryTransverter());
        //        Hammer hammer = new SqldbHammerImpl(jdbc, mappingFactory, configFactory, transverterManager);

        HammerConfigImpl hammerConfig = new HammerConfigImpl();
        hammerConfig.setValidator(Validation.byProvider(HibernateValidator.class).configure().failFast(false)
                .buildValidatorFactory().getValidator());

        Hammer hammer = new SqldbHammerImpl(jdbc, mappingFactory, configFactory, hammerConfig);
        userMapper = mapperFactory.newInstance(UserMapper.class, hammer);
        roleMapper = mapperFactory.newInstance(RoleMapper.class, hammer);
    }

    @Test
    void testUserList2() {
        List<User> users = userMapper.selectConditions(null, null, null, null, null);
        assertTrue(users.size() > 0);

        users = userMapper.selectConditions(username1 + "%", null, null, minAge, maxAge);
        users.forEach(u -> {
            assertTrue(u.getAge() >= minAge);
            assertTrue(u.getAge() <= maxAge);
            assertTrue(u.getUsername().startsWith(username1));
        });

        users = userMapper.selectConditions(username2 + "%", null, null, minAge, maxAge);
        users.forEach(u -> {
            assertTrue(u.getAge() >= minAge);
            assertTrue(u.getAge() <= maxAge);
            assertTrue(u.getUsername().startsWith(username2));
        });

        users = userMapper.selectConditions(null, password + "%", null, minAge, maxAge);
        users.forEach(u -> {
            assertTrue(u.getAge() >= minAge);
            assertTrue(u.getAge() <= maxAge);
            assertTrue(u.getPwd().startsWith(password));
        });

        users = userMapper.selectConditions(null, "%" + password, null, minAge, maxAge);
        users.forEach(u -> {
            assertTrue(u.getAge() >= minAge);
            assertTrue(u.getAge() <= maxAge);
            assertTrue(u.getPwd().endsWith(password));
        });
    }

    @Test
    void testMapperString() {
        String str = userMapper.selectString();
        System.out.println("selectString = " + str);
        assertEquals(str, "yufei");

        str = userMapper.selectString2(2);
        System.out.println("selectString = " + str);
        assertEquals(str, "featherfly");
    }

    @Test
    void testMapperNumber() {
        Integer avg = userMapper.selectAvg();
        System.out.println("avg(age) = " + avg);
        assertTrue(avg > 20);

        avg = userMapper.selectAvg2(40);
        System.out.println("avg(age) = " + avg);
        assertTrue(avg > 40);

    }

    @Test
    void testMapperSingle() {
        String username = "yufei";
        cn.featherfly.hammer.sqldb.jdbc.vo.r.User u = userMapper.selectByUsername(username);
        System.out.println(u);
        assertEquals(u.getUsername(), username);

        String password = "123456";
        u = userMapper.selectByUsernameAndPassword(username, password);
        System.out.println(u);
        assertEquals(u.getUsername(), username);
        assertEquals(u.getPwd(), password);
    }

    @Test
    void testMapperSingleMap() {
        String username = "yufei";
        Map<String, Object> u = userMapper.selectByUsername2(username);
        System.out.println(u);
        assertEquals(u.get("username"), username);
    }

    @Test
    void testMapperList() {
        List<User> us = userMapper.selectByAge2(10);
        System.out.println(us);
        assertEquals(us.size(), 2);
    }

    @Test
    void testMapperListMap() {
        List<Map<String, Object>> us = userMapper.select2();
        System.out.println(us);
        assertEquals(us.size(), 5);

        us = userMapper.selectById2(1);
        System.out.println(us);
        assertEquals(us.size(), 1);
    }

    @Test
    void testMapperPage() {
        int limit = 1;
        int age = 10;
        Page page = new SimplePagination(0, limit);

        List<User> list = userMapper.selectByAge2(age, 0, limit);
        System.out.println(list.size());
        System.out.println(list);
        assertEquals(list.size(), limit);

        list = userMapper.selectByAge2(age, page);
        System.out.println(list.size());
        System.out.println(list);
        assertEquals(list.size(), limit);

        PaginationResults<User> us = userMapper.selectByAge2Page(age, 0, limit);
        System.out.println(us.getResultSize());
        System.out.println(us.getPageResults());
        assertEquals(us.getResultSize(), new Integer(limit));

        us = userMapper.selectByAge2Page(age, page);
        System.out.println(us.getResultSize());
        System.out.println(us.getPageResults());
        assertEquals(us.getResultSize(), new Integer(limit));
    }

    @Test
    void testMapperPageMap() {
        int limit = 1;
        Page page = new SimplePagination(0, limit);

        List<Map<String, Object>> list = userMapper.select2(page);
        System.out.println(list.size());
        System.out.println(list);
        assertEquals(list.size(), limit);

        list = userMapper.select2(0, limit);
        System.out.println(list.size());
        System.out.println(list);
        assertEquals(list.size(), limit);

        PaginationResults<Map<String, Object>> us = userMapper.select2Page(page);
        System.out.println(us.getResultSize());
        System.out.println(us.getPageResults());

        assertEquals(us.getResultSize(), new Integer(limit));

        us = userMapper.select2Page(0, limit);
        System.out.println(us.getResultSize());
        System.out.println(us.getPageResults());

        assertEquals(us.getResultSize(), new Integer(limit));

    }

    @Test
    void testFuzzpQuery() {
        List<Role> list = null;
        list = roleMapper.selectByName("me");
        assertEquals(list.size(), 0);

        list = roleMapper.selectByNameCo("\\_init\\_");
        if (dialect == Dialects.SQLITE) {
            list = roleMapper.selectByNameCo("_init_");
        }
        assertEquals(list.size(), 9);

        list = roleMapper.selectByNameSw("n\\_init");
        if (dialect == Dialects.SQLITE) {
            list = roleMapper.selectByNameSw("n_init");
        }
        assertEquals(list.size(), 6);

        list = roleMapper.selectByNameEw("init\\_98");
        if (dialect == Dialects.SQLITE) {
            list = roleMapper.selectByNameEw("init_98");
        }
        assertEquals(list.size(), 1);

        list = roleMapper.selectByNameCo2("\\_init\\_");
        if (dialect == Dialects.SQLITE) {
            list = roleMapper.selectByNameCo2("_init_");
        }
        assertEquals(list.size(), 9);

        list = roleMapper.selectByNameSw2("n\\_init");
        if (dialect == Dialects.SQLITE) {
            list = roleMapper.selectByNameSw2("n_init");
        }
        assertEquals(list.size(), 6);

        list = roleMapper.selectByNameEw2("init\\_98");
        if (dialect == Dialects.SQLITE) {
            list = roleMapper.selectByNameEw2("init_98");
        }
        assertEquals(list.size(), 1);

        list = roleMapper.selectByNameCo3("\\_init\\_");
        if (dialect == Dialects.SQLITE) {
            list = roleMapper.selectByNameCo3("_init_");
        }
        assertEquals(list.size(), 9);

        list = roleMapper.selectByNameSw3("n\\_init");
        if (dialect == Dialects.SQLITE) {
            list = roleMapper.selectByNameSw3("n_init");
        }
        assertEquals(list.size(), 6);

        list = roleMapper.selectByNameEw3("init\\_98");
        if (dialect == Dialects.SQLITE) {
            list = roleMapper.selectByNameEw3("init_98");
        }
        assertEquals(list.size(), 1);
    }

    @Test
    void testFuzzpQuery2() {
        List<Role> list = null;

        list = roleMapper.selectByNameCo4("\\_init\\_");
        if (dialect == Dialects.SQLITE) {
            list = roleMapper.selectByNameCo4("_init_");
        }
        assertEquals(list.size(), 9);
    }

}
