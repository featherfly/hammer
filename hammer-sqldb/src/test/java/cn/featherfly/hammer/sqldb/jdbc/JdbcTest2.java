
package cn.featherfly.hammer.sqldb.jdbc;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import cn.featherfly.common.bean.BeanDescriptor;
import cn.featherfly.common.db.JdbcException;
import cn.featherfly.common.db.NamedParamSql;
import cn.featherfly.common.db.mapping.mappers.PlatformJavaSqlTypeMapper;
import cn.featherfly.common.lang.ArrayUtils;
import cn.featherfly.common.lang.ClassLoaderUtils;
import cn.featherfly.common.lang.Lang;
import cn.featherfly.common.lang.Str;
import cn.featherfly.common.repository.mapper.RowMapper;
import cn.featherfly.common.structure.ChainMapImpl;
import cn.featherfly.common.tuple.Tuple2;
import cn.featherfly.common.tuple.Tuple3;
import cn.featherfly.common.tuple.Tuple4;
import cn.featherfly.common.tuple.Tuple5;
import cn.featherfly.hammer.sqldb.jdbc.vo.r.App;
import cn.featherfly.hammer.sqldb.jdbc.vo.r.AppVersion;
import cn.featherfly.hammer.sqldb.jdbc.vo.r.Order;
import cn.featherfly.hammer.sqldb.jdbc.vo.r.Role;
import cn.featherfly.hammer.sqldb.jdbc.vo.r.User;
import cn.featherfly.hammer.sqldb.jdbc.vo.r.UserInfo;
import cn.featherfly.hammer.sqldb.jdbc.vo.r.UserRole;

/**
 * JdbcTest.
 *
 * @author zhongj
 */
public class JdbcTest2 extends JdbcTestBase {

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
                file = new File(path + Str.format("../../../resources/test/sql/{0}.sql", fileName));
            } else {
                file = new File(path + Str.format("../test/sql/{0}.sql", fileName));
            }
            return org.apache.commons.io.FileUtils.readFileToString(file, StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @BeforeClass
    void before() {
        selectAvg = Str.format("select avg(age) from {0}", jdbc.getDialect().wrapName("user"));
        selectAvgNamedParam = Str.format("select avg(age) from {0} where age > :age",
            jdbc.getDialect().wrapName("user"));
        selectString = Str.format("select username from {0} where id = 1", jdbc.getDialect().wrapName("user"));
        selectStringNamedParam = Str.format("select username from {0} where id = :id",
            jdbc.getDialect().wrapName("user"));

        PlatformJavaSqlTypeMapper platformJavaSqlTypeMapper = new PlatformJavaSqlTypeMapper();

        mappingFactory.getSqlTypeMappingManager()
            .regist(BeanDescriptor.getBeanDescriptor(App.class).getBeanProperty("platform"), platformJavaSqlTypeMapper);
        mappingFactory.getSqlTypeMappingManager().regist(
            BeanDescriptor.getBeanDescriptor(AppVersion.class).getBeanProperty("platform"), platformJavaSqlTypeMapper);
    }

    @Test
    public void query() {
        List<Long> idList = jdbc.query("select id from role order by id").list(Long.class);
        System.out.println(idList);
        assertTrue(idList.size() > 0);
        Long pid = Long.MIN_VALUE;
        for (Long id : idList) {
            assertTrue(pid < id);
            pid = id;
        }

        idList = jdbc.query("").list(Long.class);
        assertEquals(idList.size(), 0);

        idList = jdbc.query("", new HashMap<>()).list(Long.class);
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
        List<UserInfo> idList = jdbc.query(sql).list(m);
        assertEquals(idList.size(), 1);
        assertEquals(idList.get(0).getId(), id);

        idList = jdbc.query("").list(m);
        assertEquals(idList.size(), 0);

        idList = jdbc.query("", new HashMap<>()).list(m);
        assertEquals(idList.size(), 0);

        List<Map<String, Serializable>> mapList = null;
        mapList = jdbc.query("", ArrayUtils.EMPTY_SERIALIZABLE_ARRAY).list();
        assertEquals(mapList.size(), 0);
    }

    @Test
    public void queryTuple2() {
        String sql = getSql().replaceAll("`", jdbc.getDialect().getWrapSymbol());
        List<Tuple2<User, UserInfo>> list = jdbc.query(sql, queryTupleListParamsArray)
            .mapper(f -> f.map("_user0.", User.class).map("ui.", UserInfo.class)).list();
        for (Tuple2<User, UserInfo> tuple : list) {
            assertEquals(tuple.get0().getId(), tuple.get1().getUser().getId());
            assertNotNull(tuple.get0().getUsername());
            assertNotNull(tuple.get1().getName());
        }

        sql = sql.replace("?", ":id");
        //        list = jdbc.queryList(sql, User.class, UserInfo.class, Tuples.of("_user0.", "ui."), queryTupleListParamsMap);
        list = jdbc.query(sql, queryTupleListParamsMap)
            .mapper(f -> f.map("_user0.", User.class).map("ui.", UserInfo.class)).list();
        for (Tuple2<User, UserInfo> tuple : list) {
            assertEquals(tuple.get0().getId(), tuple.get1().getUser().getId());
            assertNotNull(tuple.get0().getUsername());
            assertNotNull(tuple.get1().getName());
        }

        NamedParamSql namedParamSql = NamedParamSql.compile(sql);
        list = jdbc.query(namedParamSql, queryTupleListParamsMap)
            .mapper(f -> f.map("_user0.", User.class).map("ui.", UserInfo.class)).list();
        for (Tuple2<User, UserInfo> tuple : list) {
            assertEquals(tuple.get0().getId(), tuple.get1().getUser().getId());
            assertNotNull(tuple.get0().getUsername());
            assertNotNull(tuple.get1().getName());
        }
    }

    @Test
    public void queryTuple3() {
        String sql = getSql().replaceAll("`", jdbc.getDialect().getWrapSymbol());
        //        List<Tuple3<User, UserInfo, UserRole>> list = jdbc.queryList(sql, User.class, UserInfo.class, UserRole.class,
        //            Tuples.of("_user0.", "ui.", "ur."), queryTupleListParamsArray);
        List<Tuple3<User, UserInfo, UserRole>> list = jdbc.query(sql, queryTupleListParamsArray)
            .mapper(f -> f.map("_user0.", User.class).map("ui.", UserInfo.class).map("ur.", UserRole.class)).list();
        for (Tuple3<User, UserInfo, UserRole> r : list) {
            assertEquals(r.get1().getUser().getId(), r.get1().getUser().getId());
            assertEquals(r.get1().getUser().getId(), r.get2().getUserId());
            assertNotNull(r.get0().getUsername());
            assertNotNull(r.get1().getName());
            assertNotNull(r.get2().getRoleId());
        }

        sql = sql.replace("?", ":id");
        list = jdbc.query(sql, queryTupleListParamsMap)
            .mapper(f -> f.map("_user0.", User.class).map("ui.", UserInfo.class).map("ur.", UserRole.class)).list();
        for (Tuple3<User, UserInfo, UserRole> r : list) {
            assertEquals(r.get1().getUser().getId(), r.get1().getUser().getId());
            assertEquals(r.get1().getUser().getId(), r.get2().getUserId());
            assertNotNull(r.get0().getUsername());
            assertNotNull(r.get1().getName());
            assertNotNull(r.get2().getRoleId());
        }

        NamedParamSql namedParamSql = NamedParamSql.compile(sql);
        list = jdbc.query(namedParamSql, queryTupleListParamsMap)
            .mapper(f -> f.map("_user0.", User.class).map("ui.", UserInfo.class).map("ur.", UserRole.class)).list();
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
        //        List<Tuple4<User, UserInfo, UserRole, Role>> list = jdbc.queryList(sql, User.class, UserInfo.class,
        //            UserRole.class, Role.class, Tuples.of("_user0.", "ui.", "ur.", "r."), queryTupleListParamsArray);
        List<Tuple4<User, UserInfo, UserRole, Role>> list = jdbc.query(sql, queryTupleListParamsArray).mapper(f -> f
            .map("_user0.", User.class).map("ui.", UserInfo.class).map("ur.", UserRole.class).map("r.", Role.class))
            .list();
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
        list = jdbc.query(sql, queryTupleListParamsMap).mapper(f -> f.map("_user0.", User.class)
            .map("ui.", UserInfo.class).map("ur.", UserRole.class).map("r.", Role.class)).list();
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
        list = jdbc.query(namedParamSql, queryTupleListParamsMap).mapper(f -> f.map("_user0.", User.class)
            .map("ui.", UserInfo.class).map("ur.", UserRole.class).map("r.", Role.class)).list();
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
        //        List<Tuple5<User, UserInfo, UserRole, Role, Order>> list = jdbc.queryList(sql, User.class, UserInfo.class,
        //            UserRole.class, Role.class, Order.class, Tuples.of("_user0.", "ui.", "ur.", "r.", "o."),
        //            queryTupleListParamsArray);
        List<
            Tuple5<User, UserInfo, UserRole, Role, Order>> list = jdbc
                .query(sql, queryTupleListParamsArray).mapper(f -> f.map("_user0.", User.class)
                    .map("ui.", UserInfo.class).map("ur.", UserRole.class).map("r.", Role.class).map("o.", Order.class))
                .list();
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
        list = jdbc.query(sql, queryTupleListParamsMap).mapper(f -> f.map("_user0.", User.class)
            .map("ui.", UserInfo.class).map("ur.", UserRole.class).map("r.", Role.class).map("o.", Order.class)).list();
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
        list = jdbc
            .query(namedParamSql, queryTupleListParamsMap).mapper(f -> f.map("_user0.", User.class)
                .map("ui.", UserInfo.class).map("ur.", UserRole.class).map("r.", Role.class).map("o.", Order.class))
            .list();
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
        jdbc.query("select * from role where id = ?", ArrayUtils.EMPTY_SERIALIZABLE_ARRAY).list();
    }

    @Test
    public void querySingle() {
        Integer id = 1;
        String sql = "select * from user_info where id = ?";
        String sql2 = "select * from user_info where id = :id";
        NamedParamSql namedParamSql = NamedParamSql.compile(sql2);

        Map<String, Serializable> paramMap = new ChainMapImpl<String, Serializable>().putChain("id", id);
        Serializable[] paramArray = new Serializable[] { id };

        Map<String, Serializable> result = jdbc.query(sql, paramArray).single();
        assertEquals(result.get("id"), id);

        result = jdbc.query(sql2, paramMap).single();
        assertEquals(result.get("id"), id);

        result = jdbc.query(namedParamSql, paramMap).single();
        assertEquals(result.get("id"), id);

        RowMapper<UserInfo> m = (RowMapper<UserInfo>) (res, rowNum) -> {
            UserInfo ui = new UserInfo();
            ui.setId(res.getInt("id"));
            return ui;
        };

        UserInfo ui = jdbc.query(sql, paramArray).single(m);
        assertEquals(ui.getId(), id);

        ui = jdbc.query(sql2, paramMap).single(m);
        assertEquals(ui.getId(), id);

        ui = jdbc.query(namedParamSql, paramMap).single(m);
        assertEquals(ui.getId(), id);

        // sql, Class, params
        ui = jdbc.query(sql, paramArray).single(UserInfo.class);
        assertEquals(result.get("id"), id);

        ui = jdbc.query(sql2, paramMap).single(UserInfo.class);
        assertEquals(result.get("id"), id);

        ui = jdbc.query(namedParamSql, paramMap).single(UserInfo.class);
        assertEquals(result.get("id"), id);
    }

    @Test
    public void querySingleTuple2() {
        Integer id = 1;
        String sql = getSql("querySingleTuple2").replaceAll("`", jdbc.getDialect().getWrapSymbol());
        Tuple2<User, UserInfo> r = jdbc.query(sql, id)
            .mapper(f -> f.map("_user0.", User.class).map("ui.", UserInfo.class)).single();
        assertEquals(r.get0().getId(), id);
        assertEquals(r.get1().getUser().getId(), id);
        assertNotNull(r.get0().getUsername());
        assertNotNull(r.get1().getName());

        sql = sql.replace("?", ":id");
        r = jdbc.query(sql, new ChainMapImpl<String, Serializable>().putChain("id", id))
            .mapper(f -> f.map("_user0.", User.class).map("ui.", UserInfo.class)).single();
        assertEquals(r.get0().getId(), id);
        assertEquals(r.get1().getUser().getId(), id);
        assertNotNull(r.get0().getUsername());
        assertNotNull(r.get1().getName());

        NamedParamSql namedParamSql = NamedParamSql.compile(sql);
        r = jdbc.query(namedParamSql, new ChainMapImpl<String, Serializable>().putChain("id", id))
            .mapper(f -> f.map("_user0.", User.class).map("ui.", UserInfo.class)).single();
        assertEquals(r.get0().getId(), id);
        assertEquals(r.get1().getUser().getId(), id);
        assertNotNull(r.get0().getUsername());
        assertNotNull(r.get1().getName());
    }

    @Test
    public void querySingleTuple3() {
        Integer id = 1;
        String sql = getSql().replaceAll("`", jdbc.getDialect().getWrapSymbol());
        Tuple3<User, UserInfo, UserRole> r = jdbc.query(sql, id)
            .mapper(f -> f.map("_user0.", User.class).map("ui.", UserInfo.class).map("ur.", UserRole.class)).single();
        assertEquals(r.get0().getId(), id);
        assertEquals(r.get1().getUser().getId(), id);
        assertEquals(r.get2().getUserId(), id);
        assertNotNull(r.get0().getUsername());
        assertNotNull(r.get1().getName());
        assertNotNull(r.get2().getRoleId());

        sql = sql.replace("?", ":id");
        r = jdbc.query(sql, new ChainMapImpl<String, Serializable>().putChain("id", id))
            .mapper(f -> f.map("_user0.", User.class).map("ui.", UserInfo.class).map("ur.", UserRole.class)).single();
        assertEquals(r.get0().getId(), id);
        assertEquals(r.get1().getUser().getId(), id);
        assertEquals(r.get2().getUserId(), id);
        assertNotNull(r.get0().getUsername());
        assertNotNull(r.get1().getName());
        assertNotNull(r.get2().getRoleId());

        NamedParamSql namedParamSql = NamedParamSql.compile(sql);
        r = jdbc.query(namedParamSql, new ChainMapImpl<String, Serializable>().putChain("id", id))
            .mapper(f -> f.map("_user0.", User.class).map("ui.", UserInfo.class).map("ur.", UserRole.class)).single();
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
        //        Tuple4<User, UserInfo, UserRole, Role> r = jdbc.querySingle(sql, User.class, UserInfo.class, UserRole.class,
        //            Role.class, Tuples.of("_user0.", "ui.", "ur.", "r."), id);
        Tuple4<User, UserInfo, UserRole, Role> r = jdbc.query(sql, id).mapper(f -> f.map("_user0.", User.class)
            .map("ui.", UserInfo.class).map("ur.", UserRole.class).map("r.", Role.class)).single();
        assertEquals(r.get0().getId(), id);
        assertEquals(r.get1().getUser().getId(), id);
        assertEquals(r.get2().getUserId(), id);
        assertEquals(r.get2().getRoleId(), r.get3().getId());
        assertNotNull(r.get0().getUsername());
        assertNotNull(r.get1().getName());
        assertNotNull(r.get2().getRoleId());
        assertNotNull(r.get3().getName());

        sql = sql.replace("?", ":id");
        r = jdbc
            .query(sql, new ChainMapImpl<String, Serializable>().putChain("id", id)).mapper(f -> f
                .map("_user0.", User.class).map("ui.", UserInfo.class).map("ur.", UserRole.class).map("r.", Role.class))
            .single();
        assertEquals(r.get0().getId(), id);
        assertEquals(r.get1().getUser().getId(), id);
        assertEquals(r.get2().getUserId(), id);
        assertEquals(r.get2().getRoleId(), r.get3().getId());
        assertNotNull(r.get0().getUsername());
        assertNotNull(r.get1().getName());
        assertNotNull(r.get2().getRoleId());
        assertNotNull(r.get3().getName());

        NamedParamSql namedParamSql = NamedParamSql.compile(sql);
        r = jdbc
            .query(namedParamSql, new ChainMapImpl<String, Serializable>().putChain("id", id)).mapper(f -> f
                .map("_user0.", User.class).map("ui.", UserInfo.class).map("ur.", UserRole.class).map("r.", Role.class))
            .single();
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
        //        Tuple5<User, UserInfo, UserRole, Role, Order> r = jdbc.querySingle(sql, User.class, UserInfo.class,
        //            UserRole.class, Role.class, Order.class, Tuples.of("_user0.", "ui.", "ur.", "r.", "o."), id);
        Tuple5<User, UserInfo, UserRole, Role,
            Order> r = jdbc.query(sql, id).mapper(f -> f.map("_user0.", User.class).map("ui.", UserInfo.class)
                .map("ur.", UserRole.class).map("r.", Role.class).map("o.", Order.class)).single();
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
        r = jdbc.query(sql, new ChainMapImpl<String, Serializable>().putChain("id", id))
            .mapper(f -> f.map("_user0.", User.class).map("ui.", UserInfo.class).map("ur.", UserRole.class)
                .map("r.", Role.class).map("o.", Order.class))
            .single();
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
        r = jdbc.query(namedParamSql, new ChainMapImpl<String, Serializable>().putChain("id", id))
            .mapper(f -> f.map("_user0.", User.class).map("ui.", UserInfo.class).map("ur.", UserRole.class)
                .map("r.", Role.class).map("o.", Order.class))
            .single();
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
        jdbc.query("select * from role", ArrayUtils.EMPTY_SERIALIZABLE_ARRAY).single();
    }

    @Test
    public void queryUnique() {
        Integer id = 1;
        String sql = "select * from user_info where id = ?";
        String sql2 = "select * from user_info where id = :id";
        NamedParamSql namedParamSql = NamedParamSql.compile(sql2);

        Map<String, Serializable> paramMap = new ChainMapImpl<String, Serializable>().putChain("id", id);
        Serializable[] paramArray = new Serializable[] { id };

        Map<String, Serializable> result = jdbc.query(sql, paramArray).unique();
        assertEquals(result.get("id"), id);

        result = jdbc.query(sql2, paramMap).unique();
        assertEquals(result.get("id"), id);

        result = jdbc.query(namedParamSql, paramMap).unique();
        assertEquals(result.get("id"), id);

        RowMapper<UserInfo> m = (RowMapper<UserInfo>) (res, rowNum) -> {
            UserInfo ui = new UserInfo();
            ui.setId(res.getInt("id"));
            return ui;
        };

        UserInfo ui = jdbc.query(sql, paramArray).unique(m);
        assertEquals(ui.getId(), id);

        ui = jdbc.query(sql2, paramMap).unique(m);
        assertEquals(ui.getId(), id);

        ui = jdbc.query(namedParamSql, paramMap).unique(m);
        assertEquals(ui.getId(), id);

        // sql, Class, params
        ui = jdbc.query(sql, paramArray).unique(UserInfo.class);
        assertEquals(result.get("id"), id);

        ui = jdbc.query(sql2, paramMap).unique(UserInfo.class);
        assertEquals(result.get("id"), id);

        ui = jdbc.query(namedParamSql, paramMap).unique(UserInfo.class);
        assertEquals(result.get("id"), id);
    }

    @Test
    public void queryUniqueTuple2() {
        Integer id = 1;
        String sql = getSql("querySingleTuple2").replaceAll("`", jdbc.getDialect().getWrapSymbol());
        Tuple2<User, UserInfo> r = jdbc.query(sql, id)
            .mapper(f -> f.map("_user0.", User.class).map("ui.", UserInfo.class)).unique();
        assertEquals(r.get0().getId(), id);
        assertEquals(r.get1().getUser().getId(), id);
        assertNotNull(r.get0().getUsername());
        assertNotNull(r.get1().getName());

        sql = sql.replace("?", ":id");
        r = jdbc.query(sql, new ChainMapImpl<String, Serializable>().putChain("id", id))
            .mapper(f -> f.map("_user0.", User.class).map("ui.", UserInfo.class)).unique();
        assertEquals(r.get0().getId(), id);
        assertEquals(r.get1().getUser().getId(), id);
        assertNotNull(r.get0().getUsername());
        assertNotNull(r.get1().getName());

        NamedParamSql namedParamSql = NamedParamSql.compile(sql);
        r = jdbc.query(namedParamSql, new ChainMapImpl<String, Serializable>().putChain("id", id))
            .mapper(f -> f.map("_user0.", User.class).map("ui.", UserInfo.class)).unique();
        assertEquals(r.get0().getId(), id);
        assertEquals(r.get1().getUser().getId(), id);
        assertNotNull(r.get0().getUsername());
        assertNotNull(r.get1().getName());
    }

    @Test
    public void queryUniqueTuple3() {
        Integer id = 1;
        String sql = getSql("querySingleTuple3").replaceAll("`", jdbc.getDialect().getWrapSymbol());
        Tuple3<User, UserInfo, UserRole> r = jdbc.query(sql, id)
            .mapper(f -> f.map("_user0.", User.class).map("ui.", UserInfo.class).map("ur.", UserRole.class)).unique();
        assertEquals(r.get0().getId(), id);
        assertEquals(r.get1().getUser().getId(), id);
        assertEquals(r.get2().getUserId(), id);
        assertNotNull(r.get0().getUsername());
        assertNotNull(r.get1().getName());
        assertNotNull(r.get2().getRoleId());

        sql = sql.replace("?", ":id");
        r = jdbc.query(sql, new ChainMapImpl<String, Serializable>().putChain("id", id))
            .mapper(f -> f.map("_user0.", User.class).map("ui.", UserInfo.class).map("ur.", UserRole.class)).unique();
        assertEquals(r.get0().getId(), id);
        assertEquals(r.get1().getUser().getId(), id);
        assertEquals(r.get2().getUserId(), id);
        assertNotNull(r.get0().getUsername());
        assertNotNull(r.get1().getName());
        assertNotNull(r.get2().getRoleId());

        NamedParamSql namedParamSql = NamedParamSql.compile(sql);
        r = jdbc.query(namedParamSql, new ChainMapImpl<String, Serializable>().putChain("id", id))
            .mapper(f -> f.map("_user0.", User.class).map("ui.", UserInfo.class).map("ur.", UserRole.class)).unique();
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
        Tuple4<User, UserInfo, UserRole, Role> r = jdbc.query(sql, id).mapper(f -> f.map("_user0.", User.class)
            .map("ui.", UserInfo.class).map("ur.", UserRole.class).map("r.", Role.class)).unique();
        assertEquals(r.get0().getId(), id);
        assertEquals(r.get1().getUser().getId(), id);
        assertEquals(r.get2().getUserId(), id);
        assertEquals(r.get2().getRoleId(), r.get3().getId());
        assertNotNull(r.get0().getUsername());
        assertNotNull(r.get1().getName());
        assertNotNull(r.get2().getRoleId());
        assertNotNull(r.get3().getName());

        sql = sql.replace("?", ":id");
        r = jdbc
            .query(sql, new ChainMapImpl<String, Serializable>().putChain("id", id)).mapper(f -> f
                .map("_user0.", User.class).map("ui.", UserInfo.class).map("ur.", UserRole.class).map("r.", Role.class))
            .unique();
        assertEquals(r.get0().getId(), id);
        assertEquals(r.get1().getUser().getId(), id);
        assertEquals(r.get2().getUserId(), id);
        assertEquals(r.get2().getRoleId(), r.get3().getId());
        assertNotNull(r.get0().getUsername());
        assertNotNull(r.get1().getName());
        assertNotNull(r.get2().getRoleId());
        assertNotNull(r.get3().getName());

        NamedParamSql namedParamSql = NamedParamSql.compile(sql);
        r = jdbc
            .query(namedParamSql, new ChainMapImpl<String, Serializable>().putChain("id", id)).mapper(f -> f
                .map("_user0.", User.class).map("ui.", UserInfo.class).map("ur.", UserRole.class).map("r.", Role.class))
            .unique();
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
        Tuple5<User, UserInfo, UserRole, Role,
            Order> r = jdbc.query(sql, id).mapper(f -> f.map("_user0.", User.class).map("ui.", UserInfo.class)
                .map("ur.", UserRole.class).map("r.", Role.class).map("o.", Order.class)).unique();
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
        r = jdbc.query(sql, new ChainMapImpl<String, Serializable>().putChain("id", id))
            .mapper(f -> f.map("_user0.", User.class).map("ui.", UserInfo.class).map("ur.", UserRole.class)
                .map("r.", Role.class).map("o.", Order.class))
            .unique();
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
        r = jdbc.query(namedParamSql, new ChainMapImpl<String, Serializable>().putChain("id", id))
            .mapper(f -> f.map("_user0.", User.class).map("ui.", UserInfo.class).map("ur.", UserRole.class)
                .map("r.", Role.class).map("o.", Order.class))
            .unique();
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
        jdbc.query("select * from role", ArrayUtils.EMPTY_SERIALIZABLE_ARRAY).unique();
    }

    @Test(expectedExceptions = JdbcException.class)
    public void queryUniqueException2() {
        jdbc.query("select * from role where id = 0", ArrayUtils.EMPTY_SERIALIZABLE_ARRAY).unique();
    }

    @Test(expectedExceptions = JdbcException.class)
    public void queryValueException() {
        String sql = "select * from user_info where id = 1";
        jdbc.query(sql).value(String.class);
    }

    @Test(expectedExceptions = JdbcException.class)
    public void queryValueException2() {
        String sql = "select name from user_info_1111 where id = 1";
        jdbc.query(sql).value(String.class);
    }

    @Test
    public void queryLongValue() {
        long avg = jdbc.query(selectAvg, new ChainMapImpl<>()).longValue();
        assertTrue(avg > 20);

        avg = jdbc.query(selectAvg, ArrayUtils.EMPTY_SERIALIZABLE_ARRAY).longValue();
        assertTrue(avg > 20);

        avg = jdbc.query(selectAvg).longValue();
        assertTrue(avg > 20);

        avg = jdbc.query(selectAvgNamedParam, selectAvgParams).longValue();
        assertTrue(avg > 20);

        Long avg2 = jdbc.query(selectAvg, new ChainMapImpl<>()).numberLong();
        assertTrue(avg2 > 20);

        avg2 = jdbc.query(selectAvg, ArrayUtils.EMPTY_SERIALIZABLE_ARRAY).numberLong();
        assertTrue(avg2 > 20);

        avg2 = jdbc.query(selectAvg).numberLong();
        assertTrue(avg2 > 20);

        avg2 = jdbc.query(selectAvgNamedParam, selectAvgParams).numberLong();
        assertTrue(avg2 > 20);

        NamedParamSql selectAvg2 = NamedParamSql.compile(selectAvgNamedParam);

        avg = jdbc.query(selectAvg2, selectAvgParams).longValue();
        assertTrue(avg > 20);

        avg2 = jdbc.query(selectAvg2, selectAvgParams).numberLong();
        assertTrue(avg2 > 20);

    }

    @Test
    public void queryDoubleValue() {
        double avg = jdbc.query(selectAvg, new ChainMapImpl<>()).doubleValue();
        assertTrue(avg > 20);

        avg = jdbc.query(selectAvg, ArrayUtils.EMPTY_SERIALIZABLE_ARRAY).doubleValue();
        assertTrue(avg > 20);

        avg = jdbc.query(selectAvg).doubleValue();
        assertTrue(avg > 20);

        avg = jdbc.query(selectAvgNamedParam, selectAvgParams).doubleValue();
        assertTrue(avg > 20);

        Double avg2 = jdbc.query(selectAvg, new ChainMapImpl<>()).numberDouble();
        assertTrue(avg2 > 20);

        avg2 = jdbc.query(selectAvg, ArrayUtils.EMPTY_SERIALIZABLE_ARRAY).numberDouble();
        assertTrue(avg2 > 20);

        avg2 = jdbc.query(selectAvg).numberDouble();
        assertTrue(avg2 > 20);

        avg2 = jdbc.query(selectAvgNamedParam, selectAvgParams).numberDouble();
        assertTrue(avg2 > 20);

        NamedParamSql selectAvg2 = NamedParamSql.compile(selectAvgNamedParam);

        avg = jdbc.query(selectAvg2, selectAvgParams).doubleValue();
        assertTrue(avg > 20);

        avg2 = jdbc.query(selectAvg, selectAvgParams).numberDouble();
        assertTrue(avg2 > 20);
    }

    @Test
    public void queryBigDecimalValue() {
        BigDecimal avg = jdbc.query(selectAvg, new ChainMapImpl<>()).numberBigDecimal();
        assertTrue(avg.doubleValue() > 20);

        avg = jdbc.query(selectAvg, ArrayUtils.EMPTY_SERIALIZABLE_ARRAY).bigDecimal();
        assertTrue(avg.doubleValue() > 20);

        avg = jdbc.query(selectAvg).bigDecimal();
        assertTrue(avg.doubleValue() > 20);

        avg = jdbc.query(selectAvgNamedParam, selectAvgParams).bigDecimal();
        assertTrue(avg.doubleValue() > 20);

        NamedParamSql selectAvg2 = NamedParamSql.compile(selectAvgNamedParam);

        avg = jdbc.query(selectAvg2, selectAvgParams).bigDecimal();
        assertTrue(avg.doubleValue() > 20);

        selectAvg2 = NamedParamSql.compile(selectAvg);

        avg = jdbc.query(selectAvg2, new HashMap<>()).bigDecimal();
        assertTrue(avg.doubleValue() > 20);
    }

    @Test
    public void queryString() {
        String str = jdbc.query(selectString, new ChainMapImpl<>()).string();
        assertEquals(str, "yufei");

        str = jdbc.query(selectString, ArrayUtils.EMPTY_SERIALIZABLE_ARRAY).string();
        assertEquals(str, "yufei");

        str = jdbc.query(selectString).string();
        assertEquals(str, "yufei");

        str = jdbc.query(selectStringNamedParam, selectStringParams).string();
        assertEquals(str, "yufei");

        NamedParamSql selectAvg2 = NamedParamSql.compile(selectStringNamedParam);

        str = jdbc.query(selectAvg2, selectStringParams).string();
        assertEquals(str, "yufei");
    }
}
