
package cn.featherfly.hammer.sqldb.tpl;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import cn.featherfly.common.db.JdbcException;
import cn.featherfly.common.db.dialect.Dialects;
import cn.featherfly.common.lang.Randoms;
import cn.featherfly.common.structure.page.PaginationResults;
import cn.featherfly.common.structure.page.SimplePagination;
import cn.featherfly.hammer.Hammer;
import cn.featherfly.hammer.sqldb.SqldbHammerImpl;
import cn.featherfly.hammer.sqldb.jdbc.JdbcTestBase;
import cn.featherfly.hammer.sqldb.jdbc.vo.r.Role;
import cn.featherfly.hammer.tpl.TplConfigFactoryImpl;
import cn.featherfly.hammer.tpl.mapper.TplDynamicExecutorFactory;

/**
 * RoleMapperTest.
 *
 * @author zhongj
 */
public class RoleMapperTest extends JdbcTestBase {

    RoleMapper roleMapper;

    @BeforeClass
    void setup() {
        TplDynamicExecutorFactory mapperFactory = TplDynamicExecutorFactory.getInstance();
        Set<String> basePackages = new HashSet<>();
        basePackages.add("cn.featherfly.hammer.sqldb.tpl");
        configFactory = TplConfigFactoryImpl.builder() //
                .prefixes("tpl/").suffixes(".yaml.tpl").basePackages(basePackages).build();
        Hammer hammer = new SqldbHammerImpl(jdbc, mappingFactory, configFactory, hammerConfig);
        roleMapper = mapperFactory.newInstance(RoleMapper.class, hammer, hammerConfig);
    }

    @Test
    void testMapperSqlInAnnotation() {
        List<Role> list = roleMapper.list();
        System.out.println(list);
        assertTrue(list.size() > 0);

        list = roleMapper.list(new SimplePagination(2, 2));
        assertTrue(list.size() == 2);

        list = roleMapper.list(2, 3);
        assertTrue(list.size() == 3);

        list = roleMapper.selectByName("n_init_%");
        for (Role role : list) {
            assertTrue(role.getName().startsWith("n_init_"));
        }

        list = roleMapper.selectByName2("n_init_%");
        for (Role role : list) {
            assertTrue(role.getName().startsWith("n_init_"));
        }

        //        list = roleMapper.selectByName3("n_init_%");
        //        for (Role role : list) {
        //            assertTrue(role.getName().startsWith("n_init_"));
        //        }
    }

    @Test(expectedExceptions = JdbcException.class)
    void testMapperSqlInAnnotation2() {
        List<Role> list = null;

        // YUFEI_TODO 目前已经删除模板sql中使用?占位符，是否需要支持?号占位符后续再来考虑
        list = roleMapper.selectByName3("n_init_%");
        for (Role role : list) {
            assertTrue(role.getName().startsWith("n_init_"));
        }
    }

    @Test
    void testMapperSqlInAnnotationPage() {
        Integer ps = 3;
        PaginationResults<Role> page = roleMapper.page(new SimplePagination(5, ps));
        assertEquals(page.getSize(), ps);
        assertTrue(page.getNumber() == 2);
        assertTrue(page.getTotal() > 0);

        page = roleMapper.page2(1, ps);
        assertEquals(page.getSize(), ps);
        assertTrue(page.getNumber() == 1);
        assertTrue(page.getTotal() > 0);
    }

    @Test
    void testMapperSqlInAnnotationWithOtherTemplate() {
        List<Role> list = roleMapper.selectWithTemplate22("descp%");
        for (Role role : list) {
            assertTrue(role.getName().startsWith("descp"));
        }
    }

    @Test
    void testInsertUpdateDelete() {
        String name = "name_insert_" + Randoms.getString(6);
        String descp = "descp_" + Randoms.getString(6);
        int i = roleMapper.insertRole2(name, descp);
        assertTrue(i == 1);

        Role role = roleMapper.getByName2(name);
        assertEquals(role.getName(), name);
        assertEquals(role.getDescp(), descp);

        descp = "descp_" + Randoms.getString(6);
        i = roleMapper.updateRoleByName2(name, descp);
        assertTrue(i == 1);

        role = roleMapper.getByName2(name);
        assertEquals(role.getName(), name);
        assertEquals(role.getDescp(), descp);

        i = roleMapper.deleteRoleByName2(name);
        assertTrue(i == 1);

        role = roleMapper.getByName2(name);
        assertEquals(role, null);
    }

    @Test
    void testQueryValue() {
        int count = roleMapper.countRole1();
        assertTrue(count > 1);

        Integer count2 = roleMapper.countRole2();
        assertTrue(count2 > 1);

        long count3 = roleMapper.countRole3();
        assertTrue(count3 > 1);
    }

    @Test
    void testSelectByName() {
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
            list = roleMapper.selectByNameCo("n_init");
        }
        assertEquals(list.size(), 6);

        list = roleMapper.selectByNameEw("init\\_98");
        if (dialect == Dialects.SQLITE) {
            list = roleMapper.selectByNameCo("init_98");
        }
        assertEquals(list.size(), 1);
    }

    @Test
    void testIdList() {
        List<Long> idList = roleMapper.idList();
        System.out.println(idList);
        assertTrue(idList.size() > 0);
        Long pid = Long.MIN_VALUE;
        for (Long id : idList) {
            assertTrue(pid < id);
            pid = id;
        }
    }
}
