
package cn.featherfly.hammer.sqldb.tpl;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import cn.featherfly.common.db.dialect.Dialects;
import cn.featherfly.common.lang.Randoms;
import cn.featherfly.common.structure.page.PaginationResults;
import cn.featherfly.common.structure.page.SimplePagination;
import cn.featherfly.hammer.Hammer;
import cn.featherfly.hammer.sqldb.SqldbHammerImpl;
import cn.featherfly.hammer.sqldb.jdbc.JdbcTestBase;
import cn.featherfly.hammer.sqldb.jdbc.vo.Role;
import cn.featherfly.hammer.tpl.TplConfigFactoryImpl;
import cn.featherfly.hammer.tpl.mapper.TplDynamicExecutorFactory;

/**
 * <p>
 * SqlTplExecutorTest
 * </p>
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
        configFactory = new TplConfigFactoryImpl("tpl/", ".yaml.tpl", basePackages);
        Hammer hammer = new SqldbHammerImpl(jdbc, mappingFactory, configFactory);
        roleMapper = mapperFactory.newInstance(RoleMapper.class, hammer);
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

        list = roleMapper.selectByName("descp%");
        for (Role role : list) {
            assertTrue(role.getName().startsWith("descp"));
        }

        list = roleMapper.selectByName2("descp%");
        for (Role role : list) {
            assertTrue(role.getName().startsWith("descp"));
        }

        list = roleMapper.selectByName3("descp%");
        for (Role role : list) {
            assertTrue(role.getName().startsWith("descp"));
        }
    }

    @Test
    void testMapperSqlInAnnotationPage() {
        Integer ps = 3;
        PaginationResults<Role> page = roleMapper.page(new SimplePagination(5, ps));
        assertEquals(page.getSize(), ps);
        assertTrue(page.getNumber() == 2);
        assertTrue(page.getTotal() > 0);

        page = roleMapper.page(1, ps);
        assertEquals(page.getSize(), ps);
        assertTrue(page.getNumber() == 1);
        assertTrue(page.getTotal() > 0);
    }

    @Test
    void testMapperSqlInAnnotationWithOtherTemplate() {
        List<Role> list = roleMapper.selectWithTemplate("descp%");
        for (Role role : list) {
            assertTrue(role.getName().startsWith("descp"));
        }
    }

    @Test
    void testInsertUpdateDelete() {
        String name = "name_insert_" + Randoms.getString(6);
        String descp = "descp_" + Randoms.getString(6);
        int i = roleMapper.insertRole(name, descp);
        assertTrue(i == 1);

        Role role = roleMapper.getByName(name);
        assertEquals(role.getName(), name);
        assertEquals(role.getDescp(), descp);

        descp = "descp_" + Randoms.getString(6);
        i = roleMapper.updateRoleByName(name, descp);
        assertTrue(i == 1);

        role = roleMapper.getByName(name);
        assertEquals(role.getName(), name);
        assertEquals(role.getDescp(), descp);

        i = roleMapper.deleteRoleByName(name);
        assertTrue(i == 1);

        role = roleMapper.getByName(name);
        assertEquals(role, null);
    }

    @Test
    void testQueryValue() {
        int count = roleMapper.countRole();
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
}
