
package cn.featherfly.hammer.sqldb.jdbc;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.BiConsumer;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.speedment.common.tuple.Tuple2;
import com.speedment.common.tuple.Tuple3;
import com.speedment.common.tuple.Tuple4;
import com.speedment.common.tuple.Tuple5;
import com.speedment.common.tuple.Tuples;

import cn.featherfly.common.bean.BeanDescriptor;
import cn.featherfly.common.bean.BeanPropertyValue;
import cn.featherfly.common.db.JdbcException;
import cn.featherfly.common.db.mapping.mappers.PlatformJavaSqlTypeMapper;
import cn.featherfly.common.lang.ArrayUtils;
import cn.featherfly.common.lang.ClassLoaderUtils;
import cn.featherfly.common.lang.Lang;
import cn.featherfly.common.lang.Randoms;
import cn.featherfly.common.lang.Strings;
import cn.featherfly.common.lang.reflect.ClassType;
import cn.featherfly.common.lang.reflect.Type;
import cn.featherfly.common.model.app.Platforms;
import cn.featherfly.common.repository.mapping.RowMapper;
import cn.featherfly.common.structure.ChainMapImpl;
import cn.featherfly.hammer.sqldb.jdbc.vo.App;
import cn.featherfly.hammer.sqldb.jdbc.vo.AppVersion;
import cn.featherfly.hammer.sqldb.jdbc.vo.Article;
import cn.featherfly.hammer.sqldb.jdbc.vo.Role;
import cn.featherfly.hammer.sqldb.jdbc.vo.User;
import cn.featherfly.hammer.sqldb.jdbc.vo.UserInfo;
import cn.featherfly.hammer.sqldb.jdbc.vo.UserRole;
import cn.featherfly.hammer.sqldb.jdbc.vo.order.Order2;

/**
 * JdbcTest.
 *
 * @author zhongj
 */
public class JdbcTest extends JdbcTestBase {

    private String selectAvg;

    private String selectString;

    final String tableName = "cms_article";
    final String id = "id";
    final String title = "title";
    final String content = "content";
    final String[] columnNames = new String[] { id, title, content };

    String getSql() {
        return getSql(Lang.getInvoker(2).getMethodName());
    }

    String getSql(String fileName) {
        try {
            File file = new File(
                    ClassLoaderUtils.getResource(".").getPath() + Strings.format("../test/sql/{0}.sql", fileName));
            return org.apache.commons.io.FileUtils.readFileToString(file, StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @BeforeClass
    void before() {
        selectAvg = Strings.format("select avg(age) from {0}", jdbc.getDialect().wrapName("user"));
        selectString = Strings.format("select username from {0} where id = 1", jdbc.getDialect().wrapName("user"));

        PlatformJavaSqlTypeMapper platformJavaSqlTypeMapper = new PlatformJavaSqlTypeMapper();

        mappingFactory.getSqlTypeMappingManager().regist(
                BeanDescriptor.getBeanDescriptor(App.class).getBeanProperty("platform"), platformJavaSqlTypeMapper);
        mappingFactory.getSqlTypeMappingManager().regist(
                BeanDescriptor.getBeanDescriptor(AppVersion.class).getBeanProperty("platform"),
                platformJavaSqlTypeMapper);
    }

    @Test
    public void testQuery() {
        List<Long> idList = jdbc.query("select id from role order by id", Long.class);
        System.out.println(idList);
        assertTrue(idList.size() > 0);
        Long pid = Long.MIN_VALUE;
        for (Long id : idList) {
            assertTrue(pid < id);
            pid = id;
        }

        idList = jdbc.query("", Long.class);
        assertEquals(idList.size(), 0);

        idList = jdbc.query("", Long.class, new HashMap<String, Object>());
        assertEquals(idList.size(), 0);
    }

    @Test
    public void testQuery2() {
        Integer id = 1;
        String sql = "select * from user_info where id = " + id;
        RowMapper<UserInfo> m = (RowMapper<UserInfo>) (res, rowNum) -> {
            UserInfo ui = new UserInfo();
            ui.setId(res.getInt("id"));
            return ui;
        };
        List<UserInfo> idList = jdbc.query(sql, m);
        assertEquals(idList.size(), 1);
        assertEquals(idList.get(0).getId(), id);

        idList = jdbc.query("", m);
        assertEquals(idList.size(), 0);

        idList = jdbc.query("", m, new HashMap<String, Object>());
        assertEquals(idList.size(), 0);

        List<Map<String, Object>> mapList = null;
        mapList = jdbc.query("", new Object[0]);
        assertEquals(mapList.size(), 0);
    }

    @Test
    public void testQueryTuple2() {
        String sql = getSql().replaceAll("`", jdbc.getDialect().getWrapSymbol());
        List<Tuple2<User, UserInfo>> list = jdbc.query(sql, User.class, UserInfo.class, Tuples.of("_user0.", "ui."),
                new Object[0]);
        for (Tuple2<User, UserInfo> tuple : list) {
            assertEquals(tuple.get0().getId(), tuple.get1().getUser().getId());
            assertNotNull(tuple.get0().getUsername());
            assertNotNull(tuple.get1().getName());
        }

        sql = sql.replace("?", ":id");
        list = jdbc.query(sql, User.class, UserInfo.class, Tuples.of("_user0.", "ui."),
                new ChainMapImpl<String, Object>());
        for (Tuple2<User, UserInfo> tuple : list) {
            assertEquals(tuple.get0().getId(), tuple.get1().getUser().getId());
            assertNotNull(tuple.get0().getUsername());
            assertNotNull(tuple.get1().getName());
        }
    }

    @Test
    public void testQueryTuple3() {
        String sql = getSql().replaceAll("`", jdbc.getDialect().getWrapSymbol());
        List<Tuple3<User, UserInfo, UserRole>> list = jdbc.query(sql, User.class, UserInfo.class, UserRole.class,
                Tuples.of("_user0.", "ui.", "ur."));
        for (Tuple3<User, UserInfo, UserRole> r : list) {
            assertEquals(r.get1().getUser().getId(), r.get1().getUser().getId());
            assertEquals(r.get1().getUser().getId(), r.get2().getUserId());
            assertNotNull(r.get0().getUsername());
            assertNotNull(r.get1().getName());
            assertNotNull(r.get2().getRoleId());
        }

        sql = sql.replace("?", ":id");
        list = jdbc.query(sql, User.class, UserInfo.class, UserRole.class, Tuples.of("_user0.", "ui.", "ur."),
                new ChainMapImpl<String, Object>());
        for (Tuple3<User, UserInfo, UserRole> r : list) {
            assertEquals(r.get1().getUser().getId(), r.get1().getUser().getId());
            assertEquals(r.get1().getUser().getId(), r.get2().getUserId());
            assertNotNull(r.get0().getUsername());
            assertNotNull(r.get1().getName());
            assertNotNull(r.get2().getRoleId());
        }
    }

    @Test
    public void testQueryTuple4() {
        String sql = getSql().replaceAll("`", jdbc.getDialect().getWrapSymbol());
        List<Tuple4<User, UserInfo, UserRole, Role>> list = jdbc.query(sql, User.class, UserInfo.class, UserRole.class,
                Role.class, Tuples.of("_user0.", "ui.", "ur.", "r."));
        for (Tuple4<User, UserInfo, UserRole, Role> r : list) {
            assertEquals(r.get1().getUser().getId(), r.get1().getUser().getId());
            assertEquals(r.get1().getUser().getId(), r.get2().getUserId());
            assertEquals(r.get2().getRoleId(), r.get3().getId());
            assertNotNull(r.get0().getUsername());
            assertNotNull(r.get1().getName());
            assertNotNull(r.get2().getRoleId());
            assertNotNull(r.get3().getName());
        }

        sql = sql.replace("?", ":id");
        list = jdbc.query(sql, User.class, UserInfo.class, UserRole.class, Role.class,
                Tuples.of("_user0.", "ui.", "ur.", "r."), new ChainMapImpl<String, Object>());
        for (Tuple4<User, UserInfo, UserRole, Role> r : list) {
            assertEquals(r.get1().getUser().getId(), r.get1().getUser().getId());
            assertEquals(r.get1().getUser().getId(), r.get2().getUserId());
            assertEquals(r.get2().getRoleId(), r.get3().getId());
            assertNotNull(r.get0().getUsername());
            assertNotNull(r.get1().getName());
            assertNotNull(r.get2().getRoleId());
            assertNotNull(r.get3().getName());
        }
    }

    @Test
    public void testQueryTuple5() {
        String sql = getSql().replaceAll("`", jdbc.getDialect().getWrapSymbol());
        List<Tuple5<User, UserInfo, UserRole, Role, Order2>> list = jdbc.query(sql, User.class, UserInfo.class,
                UserRole.class, Role.class, Order2.class, Tuples.of("_user0.", "ui.", "ur.", "r.", "o."));
        for (Tuple5<User, UserInfo, UserRole, Role, Order2> r : list) {
            assertEquals(r.get1().getUser().getId(), r.get1().getUser().getId());
            assertEquals(r.get1().getUser().getId(), r.get2().getUserId());
            assertEquals(r.get2().getRoleId(), r.get3().getId());
            assertEquals(r.get4().getCreateUser().getId(), r.get0().getId());
            assertNotNull(r.get0().getUsername());
            assertNotNull(r.get1().getName());
            assertNotNull(r.get2().getRoleId());
            assertNotNull(r.get3().getName());
            assertNotNull(r.get4().getAppId());
        }

        sql = sql.replace("?", ":id");
        list = jdbc.query(sql, User.class, UserInfo.class, UserRole.class, Role.class, Order2.class,
                Tuples.of("_user0.", "ui.", "ur.", "r.", "o."), new ChainMapImpl<String, Object>());
        for (Tuple5<User, UserInfo, UserRole, Role, Order2> r : list) {
            assertEquals(r.get1().getUser().getId(), r.get1().getUser().getId());
            assertEquals(r.get1().getUser().getId(), r.get2().getUserId());
            assertEquals(r.get2().getRoleId(), r.get3().getId());
            assertEquals(r.get4().getCreateUser().getId(), r.get0().getId());
            assertNotNull(r.get0().getUsername());
            assertNotNull(r.get1().getName());
            assertNotNull(r.get2().getRoleId());
            assertNotNull(r.get3().getName());
            assertNotNull(r.get4().getAppId());
        }
    }

    @Test(expectedExceptions = JdbcException.class)
    public void testQueryException() {
        jdbc.query("select * from role where id = ?", new Object[0]);
    }

    @Test
    public void testQuerySingle() {
        Integer id = 1;
        String sql = "select * from user_info where id = ?";
        String sql2 = "select * from user_info where id = :id";
        Map<String, Object> result = jdbc.querySingle(sql, new Object[] { id });
        assertEquals(result.get("id"), id);

        RowMapper<UserInfo> m = (RowMapper<UserInfo>) (res, rowNum) -> {
            UserInfo ui = new UserInfo();
            ui.setId(res.getInt("id"));
            return ui;
        };

        UserInfo ui = jdbc.querySingle(sql2, m, new ChainMapImpl<String, Object>().putChain("id", id));
        assertEquals(ui.getId(), id);
    }

    @Test
    public void testQuerySingleTuple2() {
        Integer id = 1;
        String sql = getSql().replaceAll("`", jdbc.getDialect().getWrapSymbol());
        Tuple2<User, UserInfo> r = jdbc.querySingle(sql, User.class, UserInfo.class, Tuples.of("_user0.", "ui."), id);
        assertEquals(r.get0().getId(), id);
        assertEquals(r.get1().getUser().getId(), id);
        assertNotNull(r.get0().getUsername());
        assertNotNull(r.get1().getName());

        sql = sql.replace("?", ":id");
        r = jdbc.querySingle(sql, User.class, UserInfo.class, Tuples.of("_user0.", "ui."),
                new ChainMapImpl<String, Object>().putChain("id", id));
        assertEquals(r.get0().getId(), id);
        assertEquals(r.get1().getUser().getId(), id);
        assertNotNull(r.get0().getUsername());
        assertNotNull(r.get1().getName());
    }

    @Test
    public void testQuerySingleTuple3() {
        Integer id = 1;
        String sql = getSql().replaceAll("`", jdbc.getDialect().getWrapSymbol());
        Tuple3<User, UserInfo, UserRole> r = jdbc.querySingle(sql, User.class, UserInfo.class, UserRole.class,
                Tuples.of("_user0.", "ui.", "ur."), id);
        assertEquals(r.get0().getId(), id);
        assertEquals(r.get1().getUser().getId(), id);
        assertEquals(r.get2().getUserId(), id);
        assertNotNull(r.get0().getUsername());
        assertNotNull(r.get1().getName());
        assertNotNull(r.get2().getRoleId());

        sql = sql.replace("?", ":id");
        r = jdbc.querySingle(sql, User.class, UserInfo.class, UserRole.class, Tuples.of("_user0.", "ui.", "ur."),
                new ChainMapImpl<String, Object>().putChain("id", id));
        assertEquals(r.get0().getId(), id);
        assertEquals(r.get1().getUser().getId(), id);
        assertEquals(r.get2().getUserId(), id);
        assertNotNull(r.get0().getUsername());
        assertNotNull(r.get1().getName());
        assertNotNull(r.get2().getRoleId());
    }

    @Test
    public void testQuerySingleTuple4() {
        Integer id = 1;
        String sql = getSql().replaceAll("`", jdbc.getDialect().getWrapSymbol());
        Tuple4<User, UserInfo, UserRole, Role> r = jdbc.querySingle(sql, User.class, UserInfo.class, UserRole.class,
                Role.class, Tuples.of("_user0.", "ui.", "ur.", "r."), id);
        assertEquals(r.get0().getId(), id);
        assertEquals(r.get1().getUser().getId(), id);
        assertEquals(r.get2().getUserId(), id);
        assertEquals(r.get2().getRoleId(), r.get3().getId());
        assertNotNull(r.get0().getUsername());
        assertNotNull(r.get1().getName());
        assertNotNull(r.get2().getRoleId());
        assertNotNull(r.get3().getName());

        sql = sql.replace("?", ":id");
        r = jdbc.querySingle(sql, User.class, UserInfo.class, UserRole.class, Role.class,
                Tuples.of("_user0.", "ui.", "ur.", "r."), new ChainMapImpl<String, Object>().putChain("id", id));
        assertEquals(r.get0().getId(), id);
        assertEquals(r.get1().getUser().getId(), id);
        assertEquals(r.get2().getUserId(), id);
        assertEquals(r.get2().getRoleId(), r.get3().getId());
        assertNotNull(r.get0().getUsername());
        assertNotNull(r.get1().getName());
        assertNotNull(r.get2().getRoleId());
        assertNotNull(r.get3().getName());
    }

    @Test
    public void testQuerySingleTuple5() {
        Integer id = 1;
        String sql = getSql().replaceAll("`", jdbc.getDialect().getWrapSymbol());
        Tuple5<User, UserInfo, UserRole, Role, Order2> r = jdbc.querySingle(sql, User.class, UserInfo.class,
                UserRole.class, Role.class, Order2.class, Tuples.of("_user0.", "ui.", "ur.", "r.", "o."), id);
        assertEquals(r.get0().getId(), id);
        assertEquals(r.get1().getUser().getId(), id);
        assertEquals(r.get2().getUserId(), id);
        assertEquals(r.get2().getRoleId(), r.get3().getId());
        assertEquals(r.get4().getCreateUser().getId(), id);
        assertNotNull(r.get0().getUsername());
        assertNotNull(r.get1().getName());
        assertNotNull(r.get2().getRoleId());
        assertNotNull(r.get3().getName());
        assertNotNull(r.get4().getAppId());

        sql = sql.replace("?", ":id");
        r = jdbc.querySingle(sql, User.class, UserInfo.class, UserRole.class, Role.class, Order2.class,
                Tuples.of("_user0.", "ui.", "ur.", "r.", "o."), new ChainMapImpl<String, Object>().putChain("id", id));
        assertEquals(r.get0().getId(), id);
        assertEquals(r.get1().getUser().getId(), id);
        assertEquals(r.get2().getUserId(), id);
        assertEquals(r.get2().getRoleId(), r.get3().getId());
        assertEquals(r.get4().getCreateUser().getId(), id);
        assertNotNull(r.get0().getUsername());
        assertNotNull(r.get1().getName());
        assertNotNull(r.get2().getRoleId());
        assertNotNull(r.get3().getName());
        assertNotNull(r.get4().getAppId());
    }

    @Test(expectedExceptions = JdbcException.class)
    public void testQuerySingleException() {
        jdbc.querySingle("select * from role", new Object[0]);
    }

    @Test
    public void testQueryUnique() {
        Integer id = 1;
        String sql = "select * from user_info where id = ?";
        String sql2 = "select * from user_info where id = :id";
        Map<String, Object> result = jdbc.queryUnique(sql, new Object[] { id });
        assertEquals(result.get("id"), id);

        result = jdbc.queryUnique(sql2, new ChainMapImpl<String, Object>().putChain("id", id));
        assertEquals(result.get("id"), id);

        RowMapper<UserInfo> m = (RowMapper<UserInfo>) (res, rowNum) -> {
            UserInfo ui = new UserInfo();
            ui.setId(res.getInt("id"));
            return ui;
        };

        UserInfo ui = jdbc.queryUnique(sql, m, new Object[] { id });
        assertEquals(ui.getId(), id);

        ui = jdbc.queryUnique(sql2, m, new ChainMapImpl<String, Object>().putChain("id", id));
        assertEquals(ui.getId(), id);

        // sql, Class, params
        ui = jdbc.queryUnique(sql, UserInfo.class, new Object[] { id });
        assertEquals(result.get("id"), id);

        ui = jdbc.queryUnique(sql2, UserInfo.class, new ChainMapImpl<String, Object>().putChain("id", id));
        assertEquals(result.get("id"), id);
    }

    @Test
    public void testQueryUniqueTuple2() {
        Integer id = 1;
        String sql = getSql("testQuerySingleTuple2").replaceAll("`", jdbc.getDialect().getWrapSymbol());
        Tuple2<User, UserInfo> r = jdbc.queryUnique(sql, User.class, UserInfo.class, Tuples.of("_user0.", "ui."), id);
        assertEquals(r.get0().getId(), id);
        assertEquals(r.get1().getUser().getId(), id);
        assertNotNull(r.get0().getUsername());
        assertNotNull(r.get1().getName());

        sql = sql.replace("?", ":id");
        r = jdbc.queryUnique(sql, User.class, UserInfo.class, Tuples.of("_user0.", "ui."),
                new ChainMapImpl<String, Object>().putChain("id", id));
        assertEquals(r.get0().getId(), id);
        assertEquals(r.get1().getUser().getId(), id);
        assertNotNull(r.get0().getUsername());
        assertNotNull(r.get1().getName());
    }

    @Test
    public void testQueryUniqueTuple3() {
        Integer id = 1;
        String sql = getSql("testQuerySingleTuple3").replaceAll("`", jdbc.getDialect().getWrapSymbol());
        Tuple3<User, UserInfo, UserRole> r = jdbc.queryUnique(sql, User.class, UserInfo.class, UserRole.class,
                Tuples.of("_user0.", "ui.", "ur."), id);
        assertEquals(r.get0().getId(), id);
        assertEquals(r.get1().getUser().getId(), id);
        assertEquals(r.get2().getUserId(), id);
        assertNotNull(r.get0().getUsername());
        assertNotNull(r.get1().getName());
        assertNotNull(r.get2().getRoleId());

        sql = sql.replace("?", ":id");
        r = jdbc.queryUnique(sql, User.class, UserInfo.class, UserRole.class, Tuples.of("_user0.", "ui.", "ur."),
                new ChainMapImpl<String, Object>().putChain("id", id));
        assertEquals(r.get0().getId(), id);
        assertEquals(r.get1().getUser().getId(), id);
        assertEquals(r.get2().getUserId(), id);
        assertNotNull(r.get0().getUsername());
        assertNotNull(r.get1().getName());
        assertNotNull(r.get2().getRoleId());
    }

    @Test
    public void testQueryUniqueTuple4() {
        Integer id = 1;
        String sql = getSql("testQuerySingleTuple4").replaceAll("`", jdbc.getDialect().getWrapSymbol());
        Tuple4<User, UserInfo, UserRole, Role> r = jdbc.queryUnique(sql, User.class, UserInfo.class, UserRole.class,
                Role.class, Tuples.of("_user0.", "ui.", "ur.", "r."), id);
        assertEquals(r.get0().getId(), id);
        assertEquals(r.get1().getUser().getId(), id);
        assertEquals(r.get2().getUserId(), id);
        assertEquals(r.get2().getRoleId(), r.get3().getId());
        assertNotNull(r.get0().getUsername());
        assertNotNull(r.get1().getName());
        assertNotNull(r.get2().getRoleId());
        assertNotNull(r.get3().getName());

        sql = sql.replace("?", ":id");
        r = jdbc.queryUnique(sql, User.class, UserInfo.class, UserRole.class, Role.class,
                Tuples.of("_user0.", "ui.", "ur.", "r."), new ChainMapImpl<String, Object>().putChain("id", id));
        assertEquals(r.get0().getId(), id);
        assertEquals(r.get1().getUser().getId(), id);
        assertEquals(r.get2().getUserId(), id);
        assertEquals(r.get2().getRoleId(), r.get3().getId());
        assertNotNull(r.get0().getUsername());
        assertNotNull(r.get1().getName());
        assertNotNull(r.get2().getRoleId());
        assertNotNull(r.get3().getName());
    }

    @Test
    public void testQueryUniqueTuple5() {
        Integer id = 1;
        String sql = getSql("testQuerySingleTuple5").replaceAll("`", jdbc.getDialect().getWrapSymbol());
        Tuple5<User, UserInfo, UserRole, Role, Order2> r = jdbc.queryUnique(sql, User.class, UserInfo.class,
                UserRole.class, Role.class, Order2.class, Tuples.of("_user0.", "ui.", "ur.", "r.", "o."), id);
        assertEquals(r.get0().getId(), id);
        assertEquals(r.get1().getUser().getId(), id);
        assertEquals(r.get2().getUserId(), id);
        assertEquals(r.get2().getRoleId(), r.get3().getId());
        assertEquals(r.get4().getCreateUser().getId(), id);
        assertNotNull(r.get0().getUsername());
        assertNotNull(r.get1().getName());
        assertNotNull(r.get2().getRoleId());
        assertNotNull(r.get3().getName());
        assertNotNull(r.get4().getAppId());

        sql = sql.replace("?", ":id");
        r = jdbc.queryUnique(sql, User.class, UserInfo.class, UserRole.class, Role.class, Order2.class,
                Tuples.of("_user0.", "ui.", "ur.", "r.", "o."), new ChainMapImpl<String, Object>().putChain("id", id));
        assertEquals(r.get0().getId(), id);
        assertEquals(r.get1().getUser().getId(), id);
        assertEquals(r.get2().getUserId(), id);
        assertEquals(r.get2().getRoleId(), r.get3().getId());
        assertEquals(r.get4().getCreateUser().getId(), id);
        assertNotNull(r.get0().getUsername());
        assertNotNull(r.get1().getName());
        assertNotNull(r.get2().getRoleId());
        assertNotNull(r.get3().getName());
        assertNotNull(r.get4().getAppId());
    }

    @Test(expectedExceptions = JdbcException.class)
    public void testQueryUniqueException() {
        jdbc.queryUnique("select * from role", new Object[0]);
    }

    @Test(expectedExceptions = JdbcException.class)
    public void testQueryUniqueException2() {
        jdbc.queryUnique("select * from role where id = 0", new Object[0]);
    }

    @Test(expectedExceptions = JdbcException.class)
    public void testQueryValueException() {
        String sql = "select * from user_info where id = 1";
        jdbc.queryValue(sql, String.class);
    }

    @Test(expectedExceptions = JdbcException.class)
    public void testQueryValueException2() {
        String sql = "select name from user_info_1111 where id = 1";
        jdbc.queryValue(sql, String.class);
    }

    @Test
    public void testNestedPropertyMapper() {
        List<App> appList = jdbc.query(
                "select a.id, a.code, a.name, a.platform, a.last_version as \"lastVersion.id\", v.version as \"lastVersion.version\", v.version_code as \"lastVersion.versionCode\" from app a join app_version v on a.last_version = v.id",
                App.class, ArrayUtils.EMPTY_OBJECT_ARRAY);
        for (App app : appList) {
            System.out.println(app);
        }
    }

    @Test
    public void testIntercepor() {
        JdbcImpl jdbc = new JdbcImpl(dataSource, dialect, sqlTypeMappingManager);

        jdbc.addInterceptor(new JdbcExecutionInterceptor() {
            @Override
            public void preHandle(JdbcExecution execution) throws JdbcException {
                execution.setExecution("/*+ 加入sql hit 测试*/" + execution.getExecution());
            }

            @Override
            public void postHandle(JdbcExecution execution) throws JdbcException {
                execution.setResult(null);
            }
        }, new JdbcExecutionInterceptor() {
            @Override
            public void preHandle(JdbcExecution execution) throws JdbcException {
                System.err.println(Strings.format("jdbc -> {0}\n", execution.getJdbc()));
                System.err.println(Strings.format("original sql -> {0}\n", execution.getOriginalExecution()));
                System.err.println(Strings.format("execute sql -> {0}\n", execution.getExecution()));
                System.err.println(Strings.format("original params -> {0}\n", execution.getOriginalParams()));
                execution.setParams(execution.getOriginalParams());
                System.err.println(Strings.format("execute params -> {0}\n", execution.getParams()));
            }

            @Override
            public void postHandle(JdbcExecution execution) throws JdbcException {
                System.err.println(Strings.format("original result -> {0}\n", execution.getOriginalResult()));
                System.err.println(Strings.format("execute result -> {0}\n", execution.getResult()));
            }
        });

        List<App> appList = jdbc.query(
                "select a.id, a.code, a.name, a.platform, a.last_version as \"lastVersion.id\", v.version as \"lastVersion.version\", v.version_code as \"lastVersion.versionCode\" from app a join app_version v on a.last_version = v.id",
                App.class, ArrayUtils.EMPTY_OBJECT_ARRAY);
        assertNull(appList);

    }

    @Test
    public void testIntercepor2() {
        JdbcImpl jdbc = new JdbcImpl(dataSource, dialect, sqlTypeMappingManager);

        List<JdbcExecutionInterceptor> interceptors = new ArrayList<>();

        interceptors.add(new JdbcExecutionInterceptor() {
            @Override
            public void preHandle(JdbcExecution execution) throws JdbcException {
                execution.setExecution("/*+ 加入sql hit 测试*/" + execution.getExecution());
            }

            @Override
            public void postHandle(JdbcExecution execution) throws JdbcException {
                execution.setResult(null);
            }
        });
        interceptors.add(new JdbcExecutionInterceptor() {
            @Override
            public void preHandle(JdbcExecution execution) throws JdbcException {
                System.err.println(Strings.format("jdbc -> {0}\n", execution.getJdbc()));
                System.err.println(Strings.format("original sql -> {0}\n", execution.getOriginalExecution()));
                System.err.println(Strings.format("execute sql -> {0}\n", execution.getExecution()));
                System.err.println(Strings.format("original params -> {0}\n", execution.getOriginalParams()));
                execution.setParams(execution.getOriginalParams());
                System.err.println(Strings.format("execute params -> {0}\n", execution.getParams()));
            }

            @Override
            public void postHandle(JdbcExecution execution) throws JdbcException {
                System.err.println(Strings.format("original result -> {0}\n", execution.getOriginalResult()));
                System.err.println(Strings.format("execute result -> {0}\n", execution.getResult()));
            }
        });

        jdbc.addInterceptor(interceptors);

        List<App> appList = jdbc.query(
                "select a.id, a.code, a.name, a.platform, a.last_version as \"lastVersion.id\", v.version as \"lastVersion.version\", v.version_code as \"lastVersion.versionCode\" from app a join app_version v on a.last_version = v.id",
                App.class, ArrayUtils.EMPTY_OBJECT_ARRAY);
        assertNull(appList);

    }

    @Test
    public void testGeneratedKeyHolder() {
        AtomicLong id = new AtomicLong(-1);
        int i = jdbc.update("insert into cms_article values(?,?,?)", new GeneratedKeyHolder<Long>() {
            @Override
            public Type<Long> getType() {
                return new ClassType<>(Long.class);
            }

            @Override
            public void acceptKey(Long key, int row) {
                System.err.println("generated id -> " + key);
                id.set(key);
            }

            @Override
            public void acceptKey(List<Long> keys) {
                id.set(keys.get(0));
            }

        }, null, "title", "content");

        assertEquals(i, 1);

        Long l = jdbc.queryLong("select id from cms_article where id = ?", id);

        assertTrue(l == id.longValue());

    }

    @Test
    public void testInsert() {
        Article article;
        int result = 0;
        final String tableName = "cms_article";
        final String id = "id";
        final String title = "title";
        final String content = "content";
        final String[] columnNames = new String[] { id, title, content };
        final Object[] params = new Object[] { null, "title_01", "content_01" };

        result = jdbc.update("delete from cms_article");

        result = jdbc.insert(tableName, columnNames, params);
        assertEquals(result, 1);

        result = jdbc.update("delete from cms_article");
        assertEquals(result, 1);

        final AtomicLong l = new AtomicLong();

        result = jdbc.insert(tableName, columnNames, new GeneratedKeyHolder<Long>() {
            @Override
            public void acceptKey(Long key, int row) {
                l.set(key);
            }

            @Override
            public Type<Long> getType() {
                return new ClassType<>(Long.class);
            }

            @Override
            public void acceptKey(List<Long> keys) {
                l.set(keys.get(0));
            }
        }, params);

        article = jdbc.querySingle("select * from cms_article where id = ?", Article.class, l.longValue());
        assertEquals(article.getTitle(), "title_01");
        assertEquals(article.getContent(), "content_01");

        result = jdbc.insert(tableName, new ChainMapImpl<String, Object>().putChain(id, null)
                .putChain(title, "title_02").putChain(content, "content_02"));
        assertEquals(result, 1);

        result = jdbc.update("delete from cms_article");
        assertEquals(result, 2);
    }

    @Test
    public void testInsertBatch() {
        int result = 0;

        result = jdbc.update("delete from cms_article");

        result = jdbc.insertBatch(tableName, columnNames, null, "title_batch_01", "content_batch_01", null,
                "title_batch_02", "content_batch_02");
        assertEquals(result, 2);

        List<Map<String, Object>> params = new ArrayList<>();
        params.add(new ChainMapImpl<String, Object>().putChain(id, null).putChain(title, "title_batch_03")
                .putChain(content, "content_batch_03"));
        params.add(new ChainMapImpl<String, Object>().putChain(id, null).putChain(title, "title_batch_04")
                .putChain(content, "content_batch_04"));
        params.add(new ChainMapImpl<String, Object>().putChain(id, null).putChain(title, "title_batch_05")
                .putChain(content, "content_batch_05"));
        result = jdbc.insertBatch(tableName, params);
        assertEquals(result, params.size());

        result = jdbc.insertBatch(tableName, new ArrayList<>());
        assertEquals(result, 0);
    }

    @Test
    public void testInsertBatch2() {
        int result = 0;

        result = jdbc.update("delete from cms_article");

        List<Object> params = new ArrayList<>();
        BiConsumer<List<Object>, Integer> f = (l, index) -> {
            l.add(null);
            l.add("title_batch_" + index);
            l.add("content_batch_" + index);
        };
        int size = 0;
        f.accept(params, ++size);
        f.accept(params, ++size);
        f.accept(params, ++size);
        f.accept(params, ++size);
        f.accept(params, ++size);

        result = jdbc.insertBatch(tableName, columnNames, 2, params.toArray());
        assertEquals(result, size);
    }

    @Test(expectedExceptions = JdbcException.class)
    public void testInsertBatchException() {
        int result = 0;

        result = jdbc.update("delete from cms_article");

        List<Object> params = new ArrayList<>();
        BiConsumer<List<Object>, Integer> f = (l, index) -> {
            l.add("title_batch_" + index);
            l.add("content_batch_" + index);
        };
        int size = 0;
        f.accept(params, ++size);

        result = jdbc.insertBatch(tableName, columnNames, 2, params.toArray());
        assertEquals(result, size);
    }

    @Test
    public void testUpdate() {
        int result = jdbc.update("", new GeneratedKeyHolder<Long>() {

            @Override
            public void acceptKey(Long key, int row) {
                // YUFEI_TODO Auto-generated method stub

            }

            @Override
            public void acceptKey(List<Long> keys) {
                // YUFEI_TODO Auto-generated method stub

            }

            @Override
            public Type<Long> getType() {
                // YUFEI_TODO Auto-generated method stub
                return null;
            }
        });
        assertEquals(result, 0);

        result = jdbc.update("", new GeneratedKeyHolder<Long>() {

            @Override
            public void acceptKey(Long key, int row) {
                // YUFEI_TODO Auto-generated method stub

            }

            @Override
            public void acceptKey(List<Long> keys) {
                // YUFEI_TODO Auto-generated method stub

            }

            @Override
            public Type<Long> getType() {
                // YUFEI_TODO Auto-generated method stub
                return null;
            }
        }, new HashMap<String, Object>());
        assertEquals(result, 0);

        result = jdbc.update("", new Object[0]);
        assertEquals(result, 0);

        result = jdbc.update("", new BeanPropertyValue[0]);
        assertEquals(result, 0);
    }

    @Test(expectedExceptions = JdbcException.class)
    public void testUpdateException() {
        jdbc.update("delete from unkonw_table_1111 where id =1");
    }

    @Test
    public void testUpdateBatch() { // 一条sql影响多条数据
        int batchSize = 2;
        //        String batchInsertSql = jdbc.getDialect().buildInsertBatchSql(tableName, columnNames, batchSize);

        String batchInsertSql = Strings.format(
                "INSERT INTO {0}cms_article{0} ({0}id{0}, {0}title{0}, {0}content{0}) VALUES (:id1, :title1, :content1),(:id2, :title2, :content2)",
                jdbc.getDialect().getWrapSymbol());
        String batchInsertSql2 = Strings.format(
                "INSERT INTO {0}cms_article{0} ({0}id{0}, {0}title{0}, {0}content{0}) VALUES (:id1, :title1, :content1),(:id2, :title2, :content2),(:id3, :title3, :content3)",
                jdbc.getDialect().getWrapSymbol());

        BiConsumer<Map<String, Object>, Integer> f = (t, index) -> {
            t.put("id" + index, null);
            t.put("title" + index, "title_batch_" + index);
            t.put("content" + index, "content_batch_" + index);
        };

        int size = 0;
        Map<String, Object> params = new ChainMapImpl<>();
        f.accept(params, ++size);
        f.accept(params, ++size);
        int result = jdbc.updateBatch(batchInsertSql, batchSize, params);
        assertEquals(result, batchSize);

        f.accept(params, ++size);
        result = jdbc.updateBatch(batchInsertSql2, size, params);
        assertEquals(result, size);

        //        result = jdbc.updateBatch(batchInsertSql2, size - 1, params);
        //        assertEquals(result, size);

        result = jdbc.updateBatch("", size);
        assertEquals(result, 0);

        result = jdbc.updateBatch("", size, params);
        assertEquals(result, 0);
    }

    @Test
    public void testUpdateBatchMulitiSql() { // 一条sql影响一条数据，批量执行
        String insertSql = Strings.format(
                "INSERT INTO {0}cms_article{0} ({0}id{0}, {0}title{0}, {0}content{0}) VALUES (?, ?, ?)",
                jdbc.getDialect().getWrapSymbol());
        List<Object[]> argsList = new ArrayList<>();
        int batchSize = 5;

        final AtomicInteger id = new AtomicInteger(0);
        final List<Integer> ids = new ArrayList<>();

        GeneratedKeyHolder<Integer> keyHolder = new GeneratedKeyHolder<Integer>() {

            @Override
            public void acceptKey(Integer key, int row) {
                id.set(key);
            }

            @Override
            public void acceptKey(List<Integer> keys) {
                ids.addAll(keys);
            }

            @Override
            public Type<Integer> getType() {
                return new ClassType<>(Integer.class);
            }
        };

        int result = jdbc.update(insertSql, keyHolder,
                new Object[] { null, "title_batch_start", "content_batch_start" });

        assertEquals(result, 1);

        for (int i = 0; i < batchSize; i++) {
            argsList.add(new Object[] { null, "title_batch_" + i, "content_batch_" + i });
        }
        int results[] = jdbc.updateBatch(insertSql, keyHolder, argsList);
        assertEquals(results.length, batchSize);
        for (int r : results) {
            assertEquals(r, 1);
        }
        for (int i = 0; i < ids.size(); i++) {
            assertTrue(ids.get(i) == id.intValue() + i + 1);
        }
    }

    @Test
    public void testUpdateBatchMulitiSql2() { // 一条sql影响一条数据，批量执行
        String insertSql = Strings.format(
                "INSERT INTO {0}cms_article{0} ({0}id{0}, {0}title{0}, {0}content{0}) VALUES (:id, :title, :content)",
                jdbc.getDialect().getWrapSymbol());
        int batchSize = 5;
        @SuppressWarnings("unchecked")
        Map<String, Object>[] argsArray = new Map[batchSize];

        final AtomicInteger id = new AtomicInteger(0);
        final List<Integer> ids = new ArrayList<>();

        GeneratedKeyHolder<Integer> keyHolder = new GeneratedKeyHolder<Integer>() {

            @Override
            public void acceptKey(Integer key, int row) {
                id.set(key);
            }

            @Override
            public void acceptKey(List<Integer> keys) {
                ids.addAll(keys);
            }

            @Override
            public Type<Integer> getType() {
                return new ClassType<>(Integer.class);
            }
        };

        int result = jdbc.update(insertSql, keyHolder, new ChainMapImpl<String, Object>().putChain("id", null)
                .putChain("title", "title_batch_start").putChain("content", "content_batch_start"));

        assertEquals(result, 1);

        for (int i = 0; i < batchSize; i++) {
            argsArray[i] = new ChainMapImpl<String, Object>().putChain("id", null).putChain("title", "title_batch_" + i)
                    .putChain("content", "content_batch_" + i);
        }
        int results[] = jdbc.updateBatch(insertSql, keyHolder, argsArray);
        assertEquals(results.length, batchSize);
        for (int r : results) {
            assertEquals(r, 1);
        }
        for (int i = 0; i < ids.size(); i++) {
            assertTrue(ids.get(i) == id.intValue() + i + 1);
        }
    }

    @Test(expectedExceptions = JdbcException.class)
    public void testInsertBatchError() {
        jdbc.insertBatch("tableName", new String[] { "column1", "column2", "column3" }, "value1", "value2");
    }

    @Test
    public void testUpsert() {
        int result = 0;
        final String tableName = "app";
        final String id = "id";
        final String code = "code";
        final String name = "name";
        final String platform = "platform";
        final String[] columnNames = new String[] { id, code, name, platform };
        final String[] ukNames = new String[] { code };

        result = jdbc.update("delete from app");

        final Object[] params = new Object[] { null, "code_01", "name_01", Platforms.ANDROID };
        result = jdbc.upsert(tableName, columnNames, ukNames, params);
        assertEquals(result, 1);

        final Object[] params2 = new Object[] { null, "code_01", "name_02", Platforms.ANDROID };
        result = jdbc.upsert(tableName, columnNames, ukNames, params2);
        assertEquals(result, 2);

        result = jdbc.upsert(tableName, ukNames, new ChainMapImpl<String, Object>().putChain(id, null)
                .putChain(code, "code_03").putChain(name, "name_03").putChain(platform, Platforms.IOS));
        assertEquals(result, 1);

        result = jdbc.upsert(tableName, ukNames, new ChainMapImpl<String, Object>().putChain(id, null)
                .putChain(code, "code_03").putChain(name, "name_04").putChain(platform, Platforms.IOS));
        assertEquals(result, 2);
        //
        result = jdbc.update("delete from app where code like ?", "code_%");
        assertEquals(result, 2);
    }

    @Test
    public void testUpsert2() {
        int result = 0;
        final String tableName = "app";
        final String id = "id";
        final String code = "code";
        final String name = "name";
        final String platform = "platform";
        final String[] columnNames = new String[] { id, code, name, platform };

        result = jdbc.update("delete from app");

        final Object[] params = new Object[] { null, "code_01", "name_01", Platforms.ANDROID };
        result = jdbc.upsert(tableName, columnNames, code, params);
        assertEquals(result, 1);

        final Object[] params2 = new Object[] { null, "code_01", "name_02", Platforms.ANDROID };
        result = jdbc.upsert(tableName, columnNames, code, params2);
        assertEquals(result, 2);

        result = jdbc.upsert(tableName, code, new ChainMapImpl<String, Object>().putChain(id, null)
                .putChain(code, "code_03").putChain(name, "name_03").putChain(platform, Platforms.IOS));
        assertEquals(result, 1);

        result = jdbc.upsert(tableName, code, new ChainMapImpl<String, Object>().putChain(id, null)
                .putChain(code, "code_03").putChain(name, "name_04").putChain(platform, Platforms.IOS));
        assertEquals(result, 2);

        result = jdbc.update("delete from app where code like ?", "code_%");
        assertEquals(result, 2);
    }

    @Test
    void testLongValue() {
        Long avg = jdbc.queryLong(selectAvg, new ChainMapImpl<String, Object>());
        assertTrue(avg > 20);

        avg = jdbc.queryLong(selectAvg);
        assertTrue(avg > 20);
    }

    @Test
    void testDoubleValue() {
        Double avg = jdbc.queryDouble(selectAvg, new ChainMapImpl<String, Object>());
        assertTrue(avg > 20);

        avg = jdbc.queryDouble(selectAvg);
        assertTrue(avg > 20);
    }

    @Test
    void testBigDecimalValue() {
        BigDecimal avg = jdbc.queryBigDecimal(selectAvg, new ChainMapImpl<String, Object>());
        assertTrue(avg.doubleValue() > 20);

        avg = jdbc.queryBigDecimal(selectAvg);
        assertTrue(avg.doubleValue() > 20);
    }

    @Test
    void testStringValue() {
        String str = jdbc.queryString(selectString, new ChainMapImpl<String, Object>());
        assertEquals(str, "yufei");

        str = jdbc.queryString(selectString);
        assertEquals(str, "yufei");
    }

    @Test
    void testCallQuery() throws SQLException {
        List<Map<String, Object>> list = jdbc.callQuery("call_query_user", "yufei%");
        for (Map<String, Object> map : list) {
            System.out.println(map);
            assertTrue(map.get("username").toString().startsWith("yufei"));
        }
    }

    @Test
    void testCallQuery1() throws SQLException {
        List<User> list = jdbc.callQuery("call_query_user", (res, rowNum) -> {
            User user = new User();
            user.setId(res.getInt("id"));
            user.setUsername(res.getString("username"));
            user.setPwd(res.getString("password"));
            user.setMobileNo(res.getString("mobile_no"));
            user.setAge(res.getInt("age"));
            return user;
        }, "yufei%");
        for (User user : list) {
            System.out.println(user);
            assertTrue(user.getUsername().startsWith("yufei"));
        }
    }

    @Test
    void testCallQuery2() throws SQLException {
        List<User> list = jdbc.callQuery("call_query_user", User.class, "yufei%");
        for (User user : list) {
            System.out.println(user);
            assertTrue(user.getUsername().startsWith("yufei"));
        }
    }

    @Test
    void testCallQueryInOutParam() throws SQLException {
        Integer id = 1;
        Object[] params = new Object[] { id };

        assertEquals(params[0], id);

        User user = jdbc.callQuerySingle("call_query_user_by_id", User.class, params);

        assertEquals(user.getId(), id);

        assertEquals(params[0], id + 1);
    }

    @Test
    void testCall() throws SQLException {
        String newname = "featherfly_call" + Randoms.getInt(1000);
        Object[] params = new Object[] { 13, newname, 0 };
        int outparam = (Integer) params[2];
        assertTrue(outparam == 0);

        int result = jdbc.call("call_update_user_one", params);
        System.out.println("result = " + result);
        outparam = (Integer) params[2];
        assertTrue(outparam == 1);
    }

    @Test
    void testCall2() throws SQLException {
        String qname = "name_init%";
        String newdescp = "call_update_batch_" + Randoms.getInt(1000);
        Object[] params = new Object[] { qname, newdescp, null };
        assertNull(params[2]);

        int result = jdbc.call("call_update_role_more", params);
        System.out.println("result = " + result);
        int outparam = (Integer) params[2];
        assertTrue(outparam == 3);
    }
}
