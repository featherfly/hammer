
/*
 * All rights Reserved, Designed By zhongj
 * @Title: CoverageTest.java
 * @Package cn.featherfly.hammer.sqldb.jdbc
 * @Description: CoverageTest
 * @author: zhongj
 * @date: 2023-02-09 15:34:09
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.jdbc.base;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import cn.featherfly.common.structure.ChainMapImpl;
import cn.featherfly.common.structure.page.SimplePage;
import cn.featherfly.hammer.sqldb.jdbc.JdbcTestBase;
import cn.featherfly.hammer.sqldb.jdbc.SimpleSqlPageFactory;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory.SqlPageQuery;
import cn.featherfly.hammer.sqldb.jdbc.vo.r.Role;

/**
 * ClassMapperObjectFactoryTest.
 *
 * @author zhongj
 */
public class SimpleSqlPageFactoryTest extends JdbcTestBase {

    @Test
    public void testPage() {
        SimpleSqlPageFactory f = new SimpleSqlPageFactory();
        int id = 1;
        final String sql = "select * from role where id > ?";
        final Serializable[] params = new Serializable[] { id };

        int size = 2;

        SimplePage page = new SimplePage(size, 1);
        SqlPageQuery<Serializable[]> pageQuery = f.toPage(jdbc.getDialect(), sql, page, params);
        List<Role> list = jdbc.queryList(pageQuery.getSql(), Role.class, pageQuery.getParams());
        for (Role role : list) {
            assertTrue(role.getId() > 1);
        }
        assertEquals(list.size(), size);

        final String sql2 = "select * from role where id > :id";
        final Map<String, Serializable> params2 = new ChainMapImpl<String, Serializable>().putChain("id", id);

        SqlPageQuery<Map<String, Serializable>> pageQuery2 = f.toPage(jdbc.getDialect(), sql2, page, params2);
        list = jdbc.queryList(pageQuery2.getSql(), Role.class, pageQuery2.getParams());
        for (Role role : list) {
            assertTrue(role.getId() > 1);
        }
        assertEquals(list.size(), size);
    }
}
