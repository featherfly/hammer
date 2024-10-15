
package cn.featherfly.hammer.sqldb.jdbc;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertNull;
import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.BiConsumer;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import cn.featherfly.common.tuple.MutableTuples;
import cn.featherfly.common.tuple.Tuple2;
import cn.featherfly.common.tuple.Tuple3;
import cn.featherfly.common.tuple.Tuple4;
import cn.featherfly.common.tuple.Tuple5;
import cn.featherfly.common.tuple.Tuple6;
import cn.featherfly.common.tuple.Tuples;
import cn.featherfly.common.tuple.mutable.MutableTuple3;

import cn.featherfly.common.bean.BeanDescriptor;
import cn.featherfly.common.db.JdbcException;
import cn.featherfly.common.db.NamedParamSql;
import cn.featherfly.common.db.mapping.mappers.PlatformJavaSqlTypeMapper;
import cn.featherfly.common.lang.ArrayUtils;
import cn.featherfly.common.lang.AutoCloseableIterable;
import cn.featherfly.common.lang.ClassLoaderUtils;
import cn.featherfly.common.lang.Lang;
import cn.featherfly.common.lang.Randoms;
import cn.featherfly.common.lang.Strings;
import cn.featherfly.common.lang.reflect.ClassType;
import cn.featherfly.common.lang.reflect.Type;
import cn.featherfly.common.model.app.Platforms;
import cn.featherfly.common.repository.MulitiQuery;
import cn.featherfly.common.repository.mapper.RowMapper;
import cn.featherfly.common.structure.ChainMapImpl;
import cn.featherfly.hammer.sqldb.jdbc.vo.r.App;
import cn.featherfly.hammer.sqldb.jdbc.vo.r.AppVersion;
import cn.featherfly.hammer.sqldb.jdbc.vo.r.Article;
import cn.featherfly.hammer.sqldb.jdbc.vo.r.Order;
import cn.featherfly.hammer.sqldb.jdbc.vo.r.Role;
import cn.featherfly.hammer.sqldb.jdbc.vo.r.User;
import cn.featherfly.hammer.sqldb.jdbc.vo.r.UserInfo;
import cn.featherfly.hammer.sqldb.jdbc.vo.r.UserRole;
import cn.featherfly.hammer.sqldb.jdbc.vo.s.Order2;
import cn.featherfly.hammer.sqldb.jdbc.vo.s.UserInfo2;

/**
 * JdbcTest.
 *
 * @author zhongj
 */
public class JdbcTest extends JdbcTestBase {

    private String selectAvg;

    private String selectAvgNamedParam;

    private Map<String, Serializable> selectAvgParams = new ChainMapImpl<String, Serializable>().putChain("age", 0);

    private String selectString;

    private String selectStringNamedParam;

    private Map<String, Serializable> selectStringParams = new ChainMapImpl<String, Serializable>().putChain("id", 1);

    private Map<String,
        Serializable> queryTupleListParamsMap = new ChainMapImpl<String, Serializable>().putChain("id", 0);
    private Serializable[] queryTupleListParamsArray = new Serializable[] { 0 };

    final String tableName = "cms_article";
    final String id = "id";
    final String title = "title";
    final String content = "content";
    final String[] columnNames = new String[] { id, title, content };

    String getSql() {
        return getSql(Lang.getInvoker(2).getMethodName());
    }

    String getSql(String fileName) {
        String path = ClassLoaderUtils.getResource(".").getPath();
        System.out.println(path);
        try {
            File file = null;
            if (path.endsWith("test/")) {
                file = new File(path + Strings.format("../../../resources/test/sql/{0}.sql", fileName));
            } else {
                file = new File(path + Strings.format("../test/sql/{0}.sql", fileName));
            }
            return org.apache.commons.io.FileUtils.readFileToString(file, StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @BeforeClass
    void before() {
        selectAvg = Strings.format("select avg(age) from {0}", jdbc.getDialect().wrapName("user"));
        selectAvgNamedParam = Strings.format("select avg(age) from {0} where age > :age",
            jdbc.getDialect().wrapName("user"));
        selectString = Strings.format("select username from {0} where id = 1", jdbc.getDialect().wrapName("user"));
        selectStringNamedParam = Strings.format("select username from {0} where id = :id",
            jdbc.getDialect().wrapName("user"));

        PlatformJavaSqlTypeMapper platformJavaSqlTypeMapper = new PlatformJavaSqlTypeMapper();

        mappingFactory.getSqlTypeMappingManager()
            .regist(BeanDescriptor.getBeanDescriptor(App.class).getBeanProperty("platform"), platformJavaSqlTypeMapper);
        mappingFactory.getSqlTypeMappingManager().regist(
            BeanDescriptor.getBeanDescriptor(AppVersion.class).getBeanProperty("platform"), platformJavaSqlTypeMapper);
    }

    @Test
    public void query() {
        List<Long> idList = jdbc.queryList("select id from role order by id", Long.class);
        System.out.println(idList);
        assertTrue(idList.size() > 0);
        Long pid = Long.MIN_VALUE;
        for (Long id : idList) {
            assertTrue(pid < id);
            pid = id;
        }

        idList = jdbc.queryList("", Long.class);
        assertEquals(idList.size(), 0);

        idList = jdbc.queryList("", Long.class, new HashMap<>());
        assertEquals(idList.size(), 0);
    }

    @Test
    public void query2() {
        Integer id = 1;
        String sql = "select * from user_info where id = " + id;
        RowMapper<UserInfo> m = (RowMapper<UserInfo>) (res, rowNum) -> {
            UserInfo ui = new UserInfo();
            ui.setId(res.getInt("id"));
            return ui;
        };
        List<UserInfo> idList = jdbc.queryList(sql, m);
        assertEquals(idList.size(), 1);
        assertEquals(idList.get(0).getId(), id);

        idList = jdbc.queryList("", m);
        assertEquals(idList.size(), 0);

        idList = jdbc.queryList("", m, new HashMap<>());
        assertEquals(idList.size(), 0);

        List<Map<String, Serializable>> mapList = null;
        mapList = jdbc.queryList("", ArrayUtils.EMPTY_SERIALIZABLE_ARRAY);
        assertEquals(mapList.size(), 0);
    }

    @Test
    public void queryEach() throws Exception {
        AutoCloseableIterable<Map<String, Serializable>> ids = jdbc.queryEach("select * from role where id = ?", 1);
        Iterator<Map<String, Serializable>> iter = ids.iterator();
        int size = 0;
        while (iter.hasNext()) {
            size++;
            iter.next();
        }
        assertTrue(size == 1);
        ids.close();
    }

    @Test
    public void queryEach2() {
        try (AutoCloseableIterable<
            Map<String, Serializable>> ids = jdbc.queryEach("select * from role where id = ?", 1)) {
            int size = 0;
            for (Map<String, Serializable> id : ids) {
                System.out.println(id);
                size++;
            }
            assertTrue(size == 1);
        } catch (Exception e) {
            throw new JdbcException(e);
        }
    }

    @Test
    public void queryTuple2() {
        String sql = getSql().replaceAll("`", jdbc.getDialect().getWrapSymbol());
        List<Tuple2<User, UserInfo>> list = jdbc.queryList(sql, User.class, UserInfo.class, Tuples.of("_user0.", "ui."),
            queryTupleListParamsArray);
        for (Tuple2<User, UserInfo> tuple : list) {
            assertEquals(tuple.get0().getId(), tuple.get1().getUser().getId());
            assertNotNull(tuple.get0().getUsername());
            assertNotNull(tuple.get1().getName());
        }

        sql = sql.replace("?", ":id");
        list = jdbc.queryList(sql, User.class, UserInfo.class, Tuples.of("_user0.", "ui."), queryTupleListParamsMap);
        for (Tuple2<User, UserInfo> tuple : list) {
            assertEquals(tuple.get0().getId(), tuple.get1().getUser().getId());
            assertNotNull(tuple.get0().getUsername());
            assertNotNull(tuple.get1().getName());
        }

        NamedParamSql namedParamSql = NamedParamSql.compile(sql);
        list = jdbc.queryList(namedParamSql, User.class, UserInfo.class, Tuples.of("_user0.", "ui."),
            queryTupleListParamsMap);
        for (Tuple2<User, UserInfo> tuple : list) {
            assertEquals(tuple.get0().getId(), tuple.get1().getUser().getId());
            assertNotNull(tuple.get0().getUsername());
            assertNotNull(tuple.get1().getName());
        }
    }

    @Test
    public void queryTuple3() {
        String sql = getSql().replaceAll("`", jdbc.getDialect().getWrapSymbol());
        List<Tuple3<User, UserInfo, UserRole>> list = jdbc.queryList(sql, User.class, UserInfo.class, UserRole.class,
            Tuples.of("_user0.", "ui.", "ur."), queryTupleListParamsArray);
        for (Tuple3<User, UserInfo, UserRole> r : list) {
            assertEquals(r.get1().getUser().getId(), r.get1().getUser().getId());
            assertEquals(r.get1().getUser().getId(), r.get2().getUserId());
            assertNotNull(r.get0().getUsername());
            assertNotNull(r.get1().getName());
            assertNotNull(r.get2().getRoleId());
        }

        sql = sql.replace("?", ":id");
        list = jdbc.queryList(sql, User.class, UserInfo.class, UserRole.class, Tuples.of("_user0.", "ui.", "ur."),
            queryTupleListParamsMap);
        for (Tuple3<User, UserInfo, UserRole> r : list) {
            assertEquals(r.get1().getUser().getId(), r.get1().getUser().getId());
            assertEquals(r.get1().getUser().getId(), r.get2().getUserId());
            assertNotNull(r.get0().getUsername());
            assertNotNull(r.get1().getName());
            assertNotNull(r.get2().getRoleId());
        }

        NamedParamSql namedParamSql = NamedParamSql.compile(sql);
        list = jdbc.queryList(namedParamSql, User.class, UserInfo.class, UserRole.class,
            Tuples.of("_user0.", "ui.", "ur."), queryTupleListParamsMap);
        for (Tuple3<User, UserInfo, UserRole> r : list) {
            assertEquals(r.get1().getUser().getId(), r.get1().getUser().getId());
            assertEquals(r.get1().getUser().getId(), r.get2().getUserId());
            assertNotNull(r.get0().getUsername());
            assertNotNull(r.get1().getName());
            assertNotNull(r.get2().getRoleId());
        }
    }

    @Test
    public void queryTuple4() {
        String sql = getSql().replaceAll("`", jdbc.getDialect().getWrapSymbol());
        List<Tuple4<User, UserInfo, UserRole, Role>> list = jdbc.queryList(sql, User.class, UserInfo.class,
            UserRole.class, Role.class, Tuples.of("_user0.", "ui.", "ur.", "r."), queryTupleListParamsArray);
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
        list = jdbc.queryList(sql, User.class, UserInfo.class, UserRole.class, Role.class,
            Tuples.of("_user0.", "ui.", "ur.", "r."), queryTupleListParamsMap);
        for (Tuple4<User, UserInfo, UserRole, Role> r : list) {
            assertEquals(r.get1().getUser().getId(), r.get1().getUser().getId());
            assertEquals(r.get1().getUser().getId(), r.get2().getUserId());
            assertEquals(r.get2().getRoleId(), r.get3().getId());
            assertNotNull(r.get0().getUsername());
            assertNotNull(r.get1().getName());
            assertNotNull(r.get2().getRoleId());
            assertNotNull(r.get3().getName());
        }

        NamedParamSql namedParamSql = NamedParamSql.compile(sql);
        list = jdbc.queryList(namedParamSql, User.class, UserInfo.class, UserRole.class, Role.class,
            Tuples.of("_user0.", "ui.", "ur.", "r."), queryTupleListParamsMap);
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
    public void queryTuple5() {
        String sql = getSql().replaceAll("`", jdbc.getDialect().getWrapSymbol());
        List<Tuple5<User, UserInfo, UserRole, Role, Order>> list = jdbc.queryList(sql, User.class, UserInfo.class,
            UserRole.class, Role.class, Order.class, Tuples.of("_user0.", "ui.", "ur.", "r.", "o."),
            queryTupleListParamsArray);
        for (Tuple5<User, UserInfo, UserRole, Role, Order> r : list) {
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
        list = jdbc.queryList(sql, User.class, UserInfo.class, UserRole.class, Role.class, Order.class,
            Tuples.of("_user0.", "ui.", "ur.", "r.", "o."), queryTupleListParamsMap);
        for (Tuple5<User, UserInfo, UserRole, Role, Order> r : list) {
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

        NamedParamSql namedParamSql = NamedParamSql.compile(sql);
        list = jdbc.queryList(namedParamSql, User.class, UserInfo.class, UserRole.class, Role.class, Order.class,
            Tuples.of("_user0.", "ui.", "ur.", "r.", "o."), queryTupleListParamsMap);
        for (Tuple5<User, UserInfo, UserRole, Role, Order> r : list) {
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
    public void queryException() {
        jdbc.queryList("select * from role where id = ?", ArrayUtils.EMPTY_SERIALIZABLE_ARRAY);
    }

    @Test
    public void querySingle() {
        Integer id = 1;
        String sql = "select * from user_info where id = ?";
        String sql2 = "select * from user_info where id = :id";
        NamedParamSql namedParamSql = NamedParamSql.compile(sql2);

        Map<String, Serializable> paramMap = new ChainMapImpl<String, Serializable>().putChain("id", id);
        Serializable[] paramArray = new Serializable[] { id };

        Map<String, Serializable> result = jdbc.querySingle(sql, paramArray);
        assertEquals(result.get("id"), id);

        result = jdbc.querySingle(sql2, paramMap);
        assertEquals(result.get("id"), id);

        result = jdbc.querySingle(namedParamSql, paramMap);
        assertEquals(result.get("id"), id);

        RowMapper<UserInfo> m = (RowMapper<UserInfo>) (res, rowNum) -> {
            UserInfo ui = new UserInfo();
            ui.setId(res.getInt("id"));
            return ui;
        };

        UserInfo ui = jdbc.querySingle(sql, m, paramArray);
        assertEquals(ui.getId(), id);

        ui = jdbc.querySingle(sql2, m, paramMap);
        assertEquals(ui.getId(), id);

        ui = jdbc.querySingle(namedParamSql, m, paramMap);
        assertEquals(ui.getId(), id);

        // sql, Class, params
        ui = jdbc.querySingle(sql, UserInfo.class, paramArray);
        assertEquals(result.get("id"), id);

        ui = jdbc.querySingle(sql2, UserInfo.class, paramMap);
        assertEquals(result.get("id"), id);

        ui = jdbc.querySingle(namedParamSql, UserInfo.class, paramMap);
        assertEquals(result.get("id"), id);
    }

    @Test
    public void querySingleTuple2() {
        Integer id = 1;
        String sql = getSql("querySingleTuple2").replaceAll("`", jdbc.getDialect().getWrapSymbol());
        Tuple2<User, UserInfo> r = jdbc.querySingle(sql, User.class, UserInfo.class, Tuples.of("_user0.", "ui."), id);
        assertEquals(r.get0().getId(), id);
        assertEquals(r.get1().getUser().getId(), id);
        assertNotNull(r.get0().getUsername());
        assertNotNull(r.get1().getName());

        sql = sql.replace("?", ":id");
        r = jdbc.querySingle(sql, User.class, UserInfo.class, Tuples.of("_user0.", "ui."),
            new ChainMapImpl<String, Serializable>().putChain("id", id));
        assertEquals(r.get0().getId(), id);
        assertEquals(r.get1().getUser().getId(), id);
        assertNotNull(r.get0().getUsername());
        assertNotNull(r.get1().getName());

        NamedParamSql namedParamSql = NamedParamSql.compile(sql);
        r = jdbc.querySingle(namedParamSql, User.class, UserInfo.class, Tuples.of("_user0.", "ui."),
            new ChainMapImpl<String, Serializable>().putChain("id", id));
        assertEquals(r.get0().getId(), id);
        assertEquals(r.get1().getUser().getId(), id);
        assertNotNull(r.get0().getUsername());
        assertNotNull(r.get1().getName());
    }

    @Test
    public void querySingleTuple3() {
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
            new ChainMapImpl<String, Serializable>().putChain("id", id));
        assertEquals(r.get0().getId(), id);
        assertEquals(r.get1().getUser().getId(), id);
        assertEquals(r.get2().getUserId(), id);
        assertNotNull(r.get0().getUsername());
        assertNotNull(r.get1().getName());
        assertNotNull(r.get2().getRoleId());

        NamedParamSql namedParamSql = NamedParamSql.compile(sql);
        r = jdbc.querySingle(namedParamSql, User.class, UserInfo.class, UserRole.class,
            Tuples.of("_user0.", "ui.", "ur."), new ChainMapImpl<String, Serializable>().putChain("id", id));
        assertEquals(r.get0().getId(), id);
        assertEquals(r.get1().getUser().getId(), id);
        assertEquals(r.get2().getUserId(), id);
        assertNotNull(r.get0().getUsername());
        assertNotNull(r.get1().getName());
        assertNotNull(r.get2().getRoleId());
    }

    @Test
    public void querySingleTuple4() {
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
            Tuples.of("_user0.", "ui.", "ur.", "r."), new ChainMapImpl<String, Serializable>().putChain("id", id));
        assertEquals(r.get0().getId(), id);
        assertEquals(r.get1().getUser().getId(), id);
        assertEquals(r.get2().getUserId(), id);
        assertEquals(r.get2().getRoleId(), r.get3().getId());
        assertNotNull(r.get0().getUsername());
        assertNotNull(r.get1().getName());
        assertNotNull(r.get2().getRoleId());
        assertNotNull(r.get3().getName());

        NamedParamSql namedParamSql = NamedParamSql.compile(sql);
        r = jdbc.querySingle(namedParamSql, User.class, UserInfo.class, UserRole.class, Role.class,
            Tuples.of("_user0.", "ui.", "ur.", "r."), new ChainMapImpl<String, Serializable>().putChain("id", id));
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
    public void querySingleTuple5() {
        Integer id = 1;
        String sql = getSql().replaceAll("`", jdbc.getDialect().getWrapSymbol());
        Tuple5<User, UserInfo, UserRole, Role, Order> r = jdbc.querySingle(sql, User.class, UserInfo.class,
            UserRole.class, Role.class, Order.class, Tuples.of("_user0.", "ui.", "ur.", "r.", "o."), id);
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
        r = jdbc.querySingle(sql, User.class, UserInfo.class, UserRole.class, Role.class, Order.class,
            Tuples.of("_user0.", "ui.", "ur.", "r.", "o."),
            new ChainMapImpl<String, Serializable>().putChain("id", id));
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

        NamedParamSql namedParamSql = NamedParamSql.compile(sql);
        r = jdbc.querySingle(namedParamSql, User.class, UserInfo.class, UserRole.class, Role.class, Order.class,
            Tuples.of("_user0.", "ui.", "ur.", "r.", "o."),
            new ChainMapImpl<String, Serializable>().putChain("id", id));
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
    public void querySingleException() {
        jdbc.querySingle("select * from role", ArrayUtils.EMPTY_SERIALIZABLE_ARRAY);
    }

    @Test
    public void queryUnique() {
        Integer id = 1;
        String sql = "select * from user_info where id = ?";
        String sql2 = "select * from user_info where id = :id";
        NamedParamSql namedParamSql = NamedParamSql.compile(sql2);

        Map<String, Serializable> paramMap = new ChainMapImpl<String, Serializable>().putChain("id", id);
        Serializable[] paramArray = new Serializable[] { id };

        Map<String, Serializable> result = jdbc.queryUnique(sql, paramArray);
        assertEquals(result.get("id"), id);

        result = jdbc.queryUnique(sql2, paramMap);
        assertEquals(result.get("id"), id);

        result = jdbc.queryUnique(namedParamSql, paramMap);
        assertEquals(result.get("id"), id);

        RowMapper<UserInfo> m = (RowMapper<UserInfo>) (res, rowNum) -> {
            UserInfo ui = new UserInfo();
            ui.setId(res.getInt("id"));
            return ui;
        };

        UserInfo ui = jdbc.queryUnique(sql, m, paramArray);
        assertEquals(ui.getId(), id);

        ui = jdbc.queryUnique(sql2, m, paramMap);
        assertEquals(ui.getId(), id);

        ui = jdbc.queryUnique(namedParamSql, m, paramMap);
        assertEquals(ui.getId(), id);

        // sql, Class, params
        ui = jdbc.queryUnique(sql, UserInfo.class, paramArray);
        assertEquals(result.get("id"), id);

        ui = jdbc.queryUnique(sql2, UserInfo.class, paramMap);
        assertEquals(result.get("id"), id);

        ui = jdbc.queryUnique(namedParamSql, UserInfo.class, paramMap);
        assertEquals(result.get("id"), id);
    }

    @Test
    public void queryUniqueTuple2() {
        Integer id = 1;
        String sql = getSql("querySingleTuple2").replaceAll("`", jdbc.getDialect().getWrapSymbol());
        Tuple2<User, UserInfo> r = jdbc.queryUnique(sql, User.class, UserInfo.class, Tuples.of("_user0.", "ui."), id);
        assertEquals(r.get0().getId(), id);
        assertEquals(r.get1().getUser().getId(), id);
        assertNotNull(r.get0().getUsername());
        assertNotNull(r.get1().getName());

        sql = sql.replace("?", ":id");
        r = jdbc.queryUnique(sql, User.class, UserInfo.class, Tuples.of("_user0.", "ui."),
            new ChainMapImpl<String, Serializable>().putChain("id", id));
        assertEquals(r.get0().getId(), id);
        assertEquals(r.get1().getUser().getId(), id);
        assertNotNull(r.get0().getUsername());
        assertNotNull(r.get1().getName());

        NamedParamSql namedParamSql = NamedParamSql.compile(sql);
        r = jdbc.queryUnique(namedParamSql, User.class, UserInfo.class, Tuples.of("_user0.", "ui."),
            new ChainMapImpl<String, Serializable>().putChain("id", id));
        assertEquals(r.get0().getId(), id);
        assertEquals(r.get1().getUser().getId(), id);
        assertNotNull(r.get0().getUsername());
        assertNotNull(r.get1().getName());
    }

    @Test
    public void queryUniqueTuple3() {
        Integer id = 1;
        String sql = getSql("querySingleTuple3").replaceAll("`", jdbc.getDialect().getWrapSymbol());
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
            new ChainMapImpl<String, Serializable>().putChain("id", id));
        assertEquals(r.get0().getId(), id);
        assertEquals(r.get1().getUser().getId(), id);
        assertEquals(r.get2().getUserId(), id);
        assertNotNull(r.get0().getUsername());
        assertNotNull(r.get1().getName());
        assertNotNull(r.get2().getRoleId());

        NamedParamSql namedParamSql = NamedParamSql.compile(sql);
        r = jdbc.queryUnique(namedParamSql, User.class, UserInfo.class, UserRole.class,
            Tuples.of("_user0.", "ui.", "ur."), new ChainMapImpl<String, Serializable>().putChain("id", id));
        assertEquals(r.get0().getId(), id);
        assertEquals(r.get1().getUser().getId(), id);
        assertEquals(r.get2().getUserId(), id);
        assertNotNull(r.get0().getUsername());
        assertNotNull(r.get1().getName());
        assertNotNull(r.get2().getRoleId());
    }

    @Test
    public void queryUniqueTuple4() {
        Integer id = 1;
        String sql = getSql("querySingleTuple4").replaceAll("`", jdbc.getDialect().getWrapSymbol());
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
            Tuples.of("_user0.", "ui.", "ur.", "r."), new ChainMapImpl<String, Serializable>().putChain("id", id));
        assertEquals(r.get0().getId(), id);
        assertEquals(r.get1().getUser().getId(), id);
        assertEquals(r.get2().getUserId(), id);
        assertEquals(r.get2().getRoleId(), r.get3().getId());
        assertNotNull(r.get0().getUsername());
        assertNotNull(r.get1().getName());
        assertNotNull(r.get2().getRoleId());
        assertNotNull(r.get3().getName());

        NamedParamSql namedParamSql = NamedParamSql.compile(sql);
        r = jdbc.queryUnique(namedParamSql, User.class, UserInfo.class, UserRole.class, Role.class,
            Tuples.of("_user0.", "ui.", "ur.", "r."), new ChainMapImpl<String, Serializable>().putChain("id", id));
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
    public void queryUniqueTuple5() {
        Integer id = 1;
        String sql = getSql("querySingleTuple5").replaceAll("`", jdbc.getDialect().getWrapSymbol());
        Tuple5<User, UserInfo, UserRole, Role, Order> r = jdbc.queryUnique(sql, User.class, UserInfo.class,
            UserRole.class, Role.class, Order.class, Tuples.of("_user0.", "ui.", "ur.", "r.", "o."), id);
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
        r = jdbc.queryUnique(sql, User.class, UserInfo.class, UserRole.class, Role.class, Order.class,
            Tuples.of("_user0.", "ui.", "ur.", "r.", "o."),
            new ChainMapImpl<String, Serializable>().putChain("id", id));
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

        NamedParamSql namedParamSql = NamedParamSql.compile(sql);
        r = jdbc.queryUnique(namedParamSql, User.class, UserInfo.class, UserRole.class, Role.class, Order.class,
            Tuples.of("_user0.", "ui.", "ur.", "r.", "o."),
            new ChainMapImpl<String, Serializable>().putChain("id", id));
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
    public void queryUniqueException() {
        jdbc.queryUnique("select * from role", ArrayUtils.EMPTY_SERIALIZABLE_ARRAY);
    }

    @Test(expectedExceptions = JdbcException.class)
    public void queryUniqueException2() {
        jdbc.queryUnique("select * from role where id = 0", ArrayUtils.EMPTY_SERIALIZABLE_ARRAY);
    }

    @Test(expectedExceptions = JdbcException.class)
    public void queryValueException() {
        String sql = "select * from user_info where id = 1";
        jdbc.queryValue(sql, String.class);
    }

    @Test(expectedExceptions = JdbcException.class)
    public void queryValueException2() {
        String sql = "select name from user_info_1111 where id = 1";
        jdbc.queryValue(sql, String.class);
    }

    @Test
    public void testNestedPropertyMapper() {
        List<App> appList = jdbc.queryList(
            "select a.id, a.code, a.name, a.platform, a.last_version as \"lastVersion.id\", v.version as \"lastVersion.version\", v.version_code as \"lastVersion.versionCode\" from app a join app_version v on a.last_version = v.id",
            App.class, ArrayUtils.EMPTY_SERIALIZABLE_ARRAY);
        for (App app : appList) {
            System.out.println(app);
        }
    }

    @Test
    public void testIntercepor() {
        JdbcSpringImpl jdbc = new JdbcSpringImpl(dataSource, dialect, metadata, sqlTypeMappingManager,
            propertyAccessorFactory);

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

        List<App> appList = jdbc.queryList(
            "select a.id, a.code, a.name, a.platform, a.last_version as \"lastVersion.id\", v.version as \"lastVersion.version\", v.version_code as \"lastVersion.versionCode\" from app a join app_version v on a.last_version = v.id",
            App.class, ArrayUtils.EMPTY_SERIALIZABLE_ARRAY);
        assertNull(appList);

    }

    @Test
    public void testIntercepor2() {
        JdbcSpringImpl jdbc = new JdbcSpringImpl(dataSource, dialect, metadata, sqlTypeMappingManager,
            propertyAccessorFactory);

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

        List<App> appList = jdbc.queryList(
            "select a.id, a.code, a.name, a.platform, a.last_version as \"lastVersion.id\", v.version as \"lastVersion.version\", v.version_code as \"lastVersion.versionCode\" from app a join app_version v on a.last_version = v.id",
            App.class, ArrayUtils.EMPTY_SERIALIZABLE_ARRAY);
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
            public void acceptKey(Long key) {
                System.err.println("generated id -> " + key);
                id.set(key);
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
        final Serializable[] params = new Serializable[] { null, "title_01", "content_01" };

        result = jdbc.update("delete from cms_article");

        result = jdbc.insert(tableName, columnNames, params);
        assertEquals(result, 1);

        result = jdbc.update("delete from cms_article");
        assertEquals(result, 1);

        final AtomicLong l = new AtomicLong();

        result = jdbc.insert(tableName, columnNames, new GeneratedKeyHolder<Long>() {
            @Override
            public void acceptKey(Long key) {
                l.set(key);
            }

            @Override
            public Type<Long> getType() {
                return new ClassType<>(Long.class);
            }

        }, params);

        article = jdbc.querySingle("select * from cms_article where id = ?", Article.class, l.longValue());
        assertEquals(article.getTitle(), "title_01");
        assertEquals(article.getContent(), "content_01");

        result = jdbc.insert(tableName, new ChainMapImpl<String, Serializable>().putChain(id, null)
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

        List<Map<String, Serializable>> params = new ArrayList<>();
        params.add(new ChainMapImpl<String, Serializable>().putChain(id, null).putChain(title, "title_batch_03")
            .putChain(content, "content_batch_03"));
        params.add(new ChainMapImpl<String, Serializable>().putChain(id, null).putChain(title, "title_batch_04")
            .putChain(content, "content_batch_04"));
        params.add(new ChainMapImpl<String, Serializable>().putChain(id, null).putChain(title, "title_batch_05")
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

        List<Serializable> params = new ArrayList<>();
        BiConsumer<List<Serializable>, Integer> f = (l, index) -> {
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

        result = jdbc.insertBatch(tableName, columnNames, 2, params.toArray(new Serializable[params.size()]));
        assertEquals(result, size);
    }

    @Test(expectedExceptions = JdbcException.class)
    public void testInsertBatchException() {
        int result = 0;

        result = jdbc.update("delete from cms_article");

        List<Serializable> params = new ArrayList<>();
        BiConsumer<List<Serializable>, Integer> f = (l, index) -> {
            l.add("title_batch_" + index);
            l.add("content_batch_" + index);
        };
        int size = 0;
        f.accept(params, ++size);

        result = jdbc.insertBatch(tableName, columnNames, 2, params.toArray(new Serializable[params.size()]));
        assertEquals(result, size);
    }

    @Test
    public void testUpdate() {
        int result = jdbc.update("", new GeneratedKeyHolder<Long>() {

            @Override
            public void acceptKey(Long key) {
            }

            @Override
            public Type<Long> getType() {
                return null;
            }
        });
        assertEquals(result, 0);

        result = jdbc.update("", new GeneratedKeyHolder<Long>() {

            @Override
            public void acceptKey(Long key) {
            }

            @Override
            public Type<Long> getType() {
                return null;
            }
        }, new HashMap<>());
        assertEquals(result, 0);

        result = jdbc.update("", ArrayUtils.EMPTY_SERIALIZABLE_ARRAY);
        assertEquals(result, 0);

        //        result = jdbc.update("", new Serializable[] {
        //            new BeanPropertyValue<>(BeanDescriptor.getBeanDescriptor(User.class).getBeanProperty(User::getId), 1) });
        //        assertEquals(result, 0);
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

        BiConsumer<Map<String, Serializable>, Integer> f = (t, index) -> {
            t.put("id" + index, null);
            t.put("title" + index, "title_batch_" + index);
            t.put("content" + index, "content_batch_" + index);
        };

        int size = 0;
        Map<String, Serializable> params = new ChainMapImpl<>();
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
        List<Serializable[]> argsList = new ArrayList<>();
        int batchSize = 5;

        final AtomicInteger id = new AtomicInteger(0);
        final List<Integer> ids = new ArrayList<>();

        int result = jdbc.update(insertSql, new GeneratedKeyHolder<Integer>() {

            @Override
            public void acceptKey(Integer key) {
                id.set(key);
            }

            @Override
            public Type<Integer> getType() {
                return new ClassType<>(Integer.class);
            }
        }, new Serializable[] { null, "title_batch_start", "content_batch_start" });

        assertEquals(result, 1);

        for (int i = 0; i < batchSize; i++) {
            argsList.add(new Serializable[] { null, "title_batch_" + i, "content_batch_" + i });
        }
        int results[] = jdbc.updateBatch(insertSql, new GeneratedKeysHolder<Integer>() {

            @Override
            public void acceptKey(List<Integer> keys) {
                ids.addAll(keys);
            }

            @Override
            public Type<Integer> getType() {
                return new ClassType<>(Integer.class);
            }
        }, argsList);
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
        Map<String, Serializable>[] argsArray = new Map[batchSize];

        final AtomicInteger id = new AtomicInteger(0);
        final List<Integer> ids = new ArrayList<>();

        GeneratedKeyHolder<Integer> keyHolder = new GeneratedKeyHolder<Integer>() {

            @Override
            public void acceptKey(Integer key) {
                id.set(key);
            }

            @Override
            public Type<Integer> getType() {
                return new ClassType<>(Integer.class);
            }
        };

        int result = jdbc.update(insertSql, keyHolder, new ChainMapImpl<String, Serializable>().putChain("id", null)
            .putChain("title", "title_batch_start").putChain("content", "content_batch_start"));

        assertEquals(result, 1);

        for (int i = 0; i < batchSize; i++) {
            argsArray[i] = new ChainMapImpl<String, Serializable>().putChain("id", null)
                .putChain("title", "title_batch_" + i).putChain("content", "content_batch_" + i);
        }
        int results[] = jdbc.updateBatch(insertSql, new GeneratedKeysHolder<Integer>() {

            @Override
            public void acceptKey(List<Integer> keys) {
                ids.addAll(keys);
            }

            @Override
            public Type<Integer> getType() {
                return new ClassType<>(Integer.class);
            }
        }, argsArray);
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

        final Serializable[] params = new Serializable[] { null, "code_01", "name_01", Platforms.ANDROID };
        result = jdbc.upsert(tableName, columnNames, ukNames, params);
        assertEquals(result, 1);

        final Serializable[] params2 = new Serializable[] { null, "code_01", "name_02", Platforms.ANDROID };
        result = jdbc.upsert(tableName, columnNames, ukNames, params2);
        assertEquals(result, 2);

        result = jdbc.upsert(tableName, ukNames, new ChainMapImpl<String, Serializable>().putChain(id, null)
            .putChain(code, "code_03").putChain(name, "name_03").putChain(platform, Platforms.IOS));
        assertEquals(result, 1);

        result = jdbc.upsert(tableName, ukNames, new ChainMapImpl<String, Serializable>().putChain(id, null)
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

        final Serializable[] params = new Serializable[] { null, "code_01", "name_01", Platforms.ANDROID };
        result = jdbc.upsert(tableName, columnNames, code, params);
        assertEquals(result, 1);

        final Serializable[] params2 = new Serializable[] { null, "code_01", "name_02", Platforms.ANDROID };
        result = jdbc.upsert(tableName, columnNames, code, params2);
        assertEquals(result, 2);

        result = jdbc.upsert(tableName, code, new ChainMapImpl<String, Serializable>().putChain(id, null)
            .putChain(code, "code_03").putChain(name, "name_03").putChain(platform, Platforms.IOS));
        assertEquals(result, 1);

        result = jdbc.upsert(tableName, code, new ChainMapImpl<String, Serializable>().putChain(id, null)
            .putChain(code, "code_03").putChain(name, "name_04").putChain(platform, Platforms.IOS));
        assertEquals(result, 2);

        result = jdbc.update("delete from app where code like ?", "code_%");
        assertEquals(result, 2);
    }

    @Test
    public void queryLongValue() {
        long avg = jdbc.queryLong(selectAvg, new ChainMapImpl<>());
        assertTrue(avg > 20);

        avg = jdbc.queryLong(selectAvg, ArrayUtils.EMPTY_SERIALIZABLE_ARRAY);
        assertTrue(avg > 20);

        avg = jdbc.queryLong(selectAvg);
        assertTrue(avg > 20);

        avg = jdbc.queryLong(selectAvgNamedParam, selectAvgParams);
        assertTrue(avg > 20);

        Long avg2 = jdbc.queryLongWrapper(selectAvg, new ChainMapImpl<>());
        assertTrue(avg2 > 20);

        avg2 = jdbc.queryLongWrapper(selectAvg, ArrayUtils.EMPTY_SERIALIZABLE_ARRAY);
        assertTrue(avg2 > 20);

        avg2 = jdbc.queryLongWrapper(selectAvg);
        assertTrue(avg2 > 20);

        avg2 = jdbc.queryLongWrapper(selectAvgNamedParam, selectAvgParams);
        assertTrue(avg2 > 20);

        NamedParamSql selectAvg2 = NamedParamSql.compile(selectAvgNamedParam);

        avg = jdbc.queryLong(selectAvg2, selectAvgParams);
        assertTrue(avg > 20);

        avg2 = jdbc.queryLongWrapper(selectAvg2, selectAvgParams);
        assertTrue(avg2 > 20);

    }

    @Test
    public void queryDoubleValue() {
        double avg = jdbc.queryDouble(selectAvg, new ChainMapImpl<>());
        assertTrue(avg > 20);

        avg = jdbc.queryDouble(selectAvg, ArrayUtils.EMPTY_SERIALIZABLE_ARRAY);
        assertTrue(avg > 20);

        avg = jdbc.queryDouble(selectAvg);
        assertTrue(avg > 20);

        avg = jdbc.queryDouble(selectAvgNamedParam, selectAvgParams);
        assertTrue(avg > 20);

        Double avg2 = jdbc.queryDoubleWrapper(selectAvg, new ChainMapImpl<>());
        assertTrue(avg2 > 20);

        avg2 = jdbc.queryDoubleWrapper(selectAvg, ArrayUtils.EMPTY_SERIALIZABLE_ARRAY);
        assertTrue(avg2 > 20);

        avg2 = jdbc.queryDoubleWrapper(selectAvg);
        assertTrue(avg2 > 20);

        avg2 = jdbc.queryDoubleWrapper(selectAvgNamedParam, selectAvgParams);
        assertTrue(avg2 > 20);

        NamedParamSql selectAvg2 = NamedParamSql.compile(selectAvgNamedParam);

        avg = jdbc.queryDouble(selectAvg2, selectAvgParams);
        assertTrue(avg > 20);

        avg2 = jdbc.queryDoubleWrapper(selectAvg, selectAvgParams);
        assertTrue(avg2 > 20);
    }

    @Test
    public void queryBigDecimalValue() {
        BigDecimal avg = jdbc.queryBigDecimal(selectAvg, new ChainMapImpl<>());
        assertTrue(avg.doubleValue() > 20);

        avg = jdbc.queryBigDecimal(selectAvg, ArrayUtils.EMPTY_SERIALIZABLE_ARRAY);
        assertTrue(avg.doubleValue() > 20);

        avg = jdbc.queryBigDecimal(selectAvg);
        assertTrue(avg.doubleValue() > 20);

        avg = jdbc.queryBigDecimal(selectAvgNamedParam, selectAvgParams);
        assertTrue(avg.doubleValue() > 20);

        NamedParamSql selectAvg2 = NamedParamSql.compile(selectAvgNamedParam);

        avg = jdbc.queryBigDecimal(selectAvg2, selectAvgParams);
        assertTrue(avg.doubleValue() > 20);

        selectAvg2 = NamedParamSql.compile(selectAvg);

        avg = jdbc.queryBigDecimal(selectAvg2, new HashMap<>());
        assertTrue(avg.doubleValue() > 20);
    }

    @Test
    public void queryString() {
        String str = jdbc.queryString(selectString, new ChainMapImpl<>());
        assertEquals(str, "yufei");

        str = jdbc.queryString(selectString, ArrayUtils.EMPTY_SERIALIZABLE_ARRAY);
        assertEquals(str, "yufei");

        str = jdbc.queryString(selectString);
        assertEquals(str, "yufei");

        str = jdbc.queryString(selectStringNamedParam, selectStringParams);
        assertEquals(str, "yufei");

        NamedParamSql selectAvg2 = NamedParamSql.compile(selectStringNamedParam);

        str = jdbc.queryString(selectAvg2, selectStringParams);
        assertEquals(str, "yufei");
    }

    @Test
    public void callQuery() throws SQLException {
        List<Map<String, Serializable>> list = jdbc.callQuery("call_query_user", "yufei%");
        for (Map<String, Serializable> map : list) {
            System.out.println(map);
            assertTrue(map.get("username").toString().startsWith("yufei"));
        }
    }

    @Test
    public void callQueryFullName() throws SQLException {
        List<Map<String, Serializable>> list = jdbc.callQuery("{call call_query_user(?)}", "yufei%");
        for (Map<String, Serializable> map : list) {
            System.out.println(map);
            assertTrue(map.get("username").toString().startsWith("yufei"));
        }
    }

    @Test
    public void callQuery1() throws SQLException {
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
    public void callQuery2() throws SQLException {
        List<User> list = jdbc.callQuery("call_query_user", User.class, "yufei%");
        for (User user : list) {
            System.out.println(user);
            assertTrue(user.getUsername().startsWith("yufei"));
        }
    }

    @Test
    public void callMulitiQueryIter() {
        Integer uid = 1;
        Serializable[] params = new Serializable[] { uid };
        try (MulitiQuery query = jdbc.callMultiQuery("call_query_user_by_id2", params)) {
            assertEquals(params[0], uid + 1);
            int queryNum = 3;
            int i = 0;
            while (query.hasNext()) {
                i++;
                query.next();
            }
            assertEquals(i, queryNum); // 三个查询
        } catch (Exception e) {
            throw new JdbcException(e);
        }

        params = new Serializable[] { uid };
        try (MulitiQuery query = jdbc.callMultiQuery("call_query_user_by_id2", params)) {
            assertEquals(params[0], uid + 1);
            for (User user : query.next(User.class)) {
                assertEquals(user.getId(), uid);
            }
            for (UserInfo2 ui : query.next(UserInfo2.class)) {
                assertEquals(ui.getUserId(), uid);
            }
            for (Map<String, Serializable> order : query.next()) {
                assertEquals(order.get("create_user"), uid);
            }
        } catch (Exception e) {
            throw new JdbcException(e);
        }
    }

    @Test
    public void callMulitiQueryIter6() {
        final String name = "call_query_user_by_id6";
        Integer uid = 1;
        Serializable[] params = new Serializable[] { uid };
        try (MulitiQuery query = jdbc.callMultiQuery(name, params)) {
            assertEquals(params[0], uid + 1);
            int i = 0;
            while (query.hasNext()) {
                i++;
                query.next();
            }
            assertEquals(i, 6); // 六个查询
        } catch (Exception e) {
            throw new JdbcException(e);
        }

        params = new Serializable[] { uid };
        try (MulitiQuery query = jdbc.callMultiQuery(name, params)) {
            assertEquals(params[0], uid + 1);
            for (User user : query.next(User.class)) {
                assertEquals(user.getId(), uid);
            }
            for (UserInfo2 ui : query.next(UserInfo2.class)) {
                assertEquals(ui.getUserId(), uid);
            }
            for (Order2 order : query.next(Order2.class)) {
                assertEquals(order.getCreateUser(), uid);
            }
            for (Map<String, Serializable> orderInfo : query.next()) {
                assertEquals(orderInfo.get("create_user"), uid);
            }
            for (UserRole userRole : query.next(UserRole.class)) {
                assertEquals(userRole.getUserId(), uid);
            }
            for (Map<String, Serializable> user : query.next()) {
                assertEquals(user.get("id"), uid);
            }
        } catch (Exception e) {
            throw new JdbcException(e);
        }
    }

    @Test
    public void callMulitiQueryList() {
        final String name = "call_query_user_by_id6";
        Integer uid = 1;
        Serializable[] params = new Serializable[] { uid };
        Tuple6<List<User>, List<UserInfo2>, List<Order2>, List<Map<String, Serializable>>, List<UserRole>,
            List<Map<String, Serializable>>> mulitiList = jdbc.callMultiQuery(name,
                b -> b.map(User.class).map(UserInfo2.class).map(Order2.class).map().map(UserRole.class).map(), params);
        assertEquals(params[0], uid + 1);
        assertEquals(mulitiList.degree(), 6); // 三个查询

        for (User user : mulitiList.get0()) {
            assertEquals(user.getId(), uid);
        }
        for (UserInfo2 ui : mulitiList.get1()) {
            assertEquals(ui.getUserId(), uid);
        }
        for (Order2 order : mulitiList.get2()) {
            assertEquals(order.getCreateUser(), uid);
        }
        for (Map<String, Serializable> orderInfo : mulitiList.get3()) {
            assertEquals(orderInfo.get("create_user"), uid);
        }
        for (UserRole userRole : mulitiList.get4()) {
            assertEquals(userRole.getUserId(), uid);
        }
        for (Map<String, Serializable> user : mulitiList.get5()) {
            assertEquals(user.get("id"), uid);
        }
    }

    @Test
    public void callQueryInOutParam() throws SQLException {
        Integer id = 1;
        Serializable[] params = new Serializable[] { id };

        assertEquals(params[0], id);

        User user = jdbc.callQuerySingle("call_query_user_by_id", User.class, params);

        assertEquals(user.getId(), id);

        assertEquals(params[0], id + 1);
    }

    @Test
    public void call() throws SQLException {
        String newname = "featherfly_call" + Randoms.getInt(1000);
        Serializable[] params = new Serializable[] { 13, newname, 0 };
        int outparam = (Integer) params[2];
        assertTrue(outparam == 0);

        int result = jdbc.call("call_update_user_one", params);
        System.out.println("result = " + result);
        outparam = (Integer) params[2];
        assertTrue(outparam == 1);
    }

    @Test
    public void call_array_args() throws SQLException {
        String qname = "name_init%";
        String newdescp = "call_update_batch_" + Randoms.getInt(1000);
        Serializable[] params = new Serializable[] { qname, newdescp, null }; // out参数传递null
        assertNull(params[2]);

        int result = jdbc.call("call_update_role_more", params);
        System.out.println("result = " + result);
        int outparam = (Integer) params[2];
        assertTrue(outparam == 3);
    }

    //    @Test
    //    public void call_map_args() throws SQLException {
    //        String qname = "name_init%";
    //        String newdescp = "call_update_batch_" + Randoms.getInt(1000);
    //        SequencedMap<String, Serializable> params = new LinkedHashMap<>();
    //        params.put("q_name", qname);
    //        params.put("u_descp", newdescp + Randoms.getInt(1000));
    //        params.put("out_row_count", null); // out参数传递null
    //        assertNull(params.get("out_row_count"));
    //
    //        int result = jdbc.call("call_update_role_more", params);
    //        System.out.println("result = " + result);
    //        int outparam = (Integer) params.get("out_row_count");
    //        assertTrue(outparam == 3);
    //    }

    @Test
    public void call_tuple_args() throws SQLException {
        String qname = "name_init%";
        String newdescp = "call_update_batch_" + Randoms.getInt(1000);
        MutableTuple3<String, String, Integer> params = MutableTuples.create3();
        params.set0(qname);
        params.set1(newdescp);
        params.set2(null); // out参数传递null

        assertNull(params.getOrNull2());

        int result = jdbc.call("call_update_role_more", params);
        System.out.println("result = " + result);
        int outparam = params.getOrNull2();
        assertTrue(outparam == 3);
    }
}
