
package cn.featherfly.hammer.sqldb.tpl;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import cn.featherfly.common.structure.ChainMapImpl;
import cn.featherfly.common.structure.page.Page;
import cn.featherfly.common.structure.page.PaginationResults;
import cn.featherfly.common.structure.page.SimplePagination;
import cn.featherfly.hammer.Hammer;
import cn.featherfly.hammer.sqldb.SqldbHammerImpl;
import cn.featherfly.hammer.sqldb.TestConstants;
import cn.featherfly.hammer.sqldb.jdbc.JdbcTestBase;
import cn.featherfly.hammer.sqldb.jdbc.vo.r.User;
import cn.featherfly.hammer.tpl.mapper.TplDynamicExecutorFactory;

/**
 * <p>
 * SqlTplExecutorTest
 * </p>
 *
 * @author zhongj
 */
public class SqlTplDynamicExecutorTest2 extends JdbcTestBase {

    UserMapper2 userMapper;

    @BeforeClass
    void setup() {
        TplDynamicExecutorFactory mapperFactory = TplDynamicExecutorFactory.getInstance();
        Hammer hammer = new SqldbHammerImpl(jdbc, mappingFactory, configFactory, instantiatorFactory, hammerConfig);
        userMapper = mapperFactory.newInstance(UserMapper2.class, hammer, hammerConfig);
    }

    @Test
    void testMapperString() {
        String str = userMapper.selectString();

        System.out.println("selectString = " + str);
        assertEquals(str, "yufei");

        str = userMapper.selectString2(2);
        System.out.println("selectString = " + str);
        assertEquals(str, "featherfly");

        str = userMapper.template().string("selectString", new HashMap<>());
        System.out.println("selectString = " + str);
        assertEquals(str, "yufei");

        str = userMapper.template().string("selectString2", new ChainMapImpl<String, Object>().putChain("id", 2));
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
        User u = userMapper.selectByUsername(username);
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
        assertEquals(us.size(), TestConstants.USER_INFO_INIT_ROWS);

        us = userMapper.selectById2(1);
        System.out.println(us);
        assertEquals(us.size(), 1);
    }

    @Test
    void testMapperPage() {
        int limit = 1;
        Page page = new SimplePagination(0, limit);

        List<User> list = userMapper.selectByAge2(10, 0, limit);
        System.out.println(list.size());
        System.out.println(list);
        assertEquals(list.size(), limit);

        list = userMapper.selectByAge2(10, page);
        System.out.println(list.size());
        System.out.println(list);
        assertEquals(list.size(), limit);

        PaginationResults<User> us = userMapper.selectByAge2Page(10, 0, limit);
        System.out.println(us.getResultSize());
        System.out.println(us.getPageResults());
        assertEquals(us.getResultSize(), Integer.valueOf(limit));

        us = userMapper.selectByAge2Page(10, page);
        System.out.println(us.getResultSize());
        System.out.println(us.getPageResults());
        assertEquals(us.getResultSize(), Integer.valueOf(limit));
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

        assertEquals(us.getResultSize(), Integer.valueOf(limit));

        us = userMapper.select2Page(0, limit);
        System.out.println(us.getResultSize());
        System.out.println(us.getPageResults());

        assertEquals(us.getResultSize(), Integer.valueOf(limit));

    }
}
