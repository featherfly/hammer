
package cn.featherfly.hammer.sqldb.tpl;

import static org.testng.Assert.assertTrue;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import cn.featherfly.hammer.Hammer;
import cn.featherfly.hammer.sqldb.SqldbHammerImpl;
import cn.featherfly.hammer.sqldb.jdbc.JdbcTestBase;
import cn.featherfly.hammer.sqldb.jdbc.vo.r.Role;
import cn.featherfly.hammer.tpl.TplConfigFactoryImpl;
import cn.featherfly.hammer.tpl.freemarker.FreemarkerTemplatePreProcessor;
import cn.featherfly.hammer.tpl.mapper.TplDynamicExecutorFactory;

/**
 * RoleMapperDefineTemplatesTest.
 *
 * @author zhongj
 */
public class RoleMapperDefineTemplatesTest extends JdbcTestBase {

    RoleMapperDefineTemplates roleMapper;

    @BeforeClass
    void setup() {
        TplDynamicExecutorFactory mapperFactory = TplDynamicExecutorFactory.getInstance();
        Set<String> basePackages = new HashSet<>();
        basePackages.add("cn.featherfly.hammer.sqldb.tpl");
        configFactory = new TplConfigFactoryImpl("tpl/", ".yaml.tpl", basePackages,
                new FreemarkerTemplatePreProcessor());
        Hammer hammer = new SqldbHammerImpl(jdbc, mappingFactory, configFactory, hammerConfig);
        roleMapper = mapperFactory.newInstance(RoleMapperDefineTemplates.class, hammer);
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

    @Test
    void testMapperSqlInAnnotation() {
        List<Role> list = roleMapper.list();
        System.out.println(list);
        assertTrue(list.size() > 0);
    }

    @Test
    void testMapperSqlInAnnotationWithOtherTemplate() {
        List<Role> list = null;
        list = roleMapper.selectWithTemplate("descp%");
        for (Role role : list) {
            assertTrue(role.getName().startsWith("descp"));
        }
        list = roleMapper.selectWithTemplate2("descp%");
        for (Role role : list) {
            assertTrue(role.getName().startsWith("descp"));
        }
        list = roleMapper.selectWithTemplate3("descp%");
        for (Role role : list) {
            assertTrue(role.getName().startsWith("descp"));
        }
        list = roleMapper.selectWithTemplate4("descp%");
        for (Role role : list) {
            assertTrue(role.getName().startsWith("descp"));
        }
        list = roleMapper.selectWithTemplate5("descp%");
        for (Role role : list) {
            assertTrue(role.getName().startsWith("descp"));
        }
        list = roleMapper.selectWithTemplate6("descp%");
        for (Role role : list) {
            assertTrue(role.getName().startsWith("descp"));
        }
        list = roleMapper.selectWithTemplate7("descp%");
        for (Role role : list) {
            assertTrue(role.getName().startsWith("descp"));
        }
        list = roleMapper.selectWithTemplate8("descp%");
        for (Role role : list) {
            assertTrue(role.getName().startsWith("descp"));
        }
        list = roleMapper.selectWithTemplate9("descp%");
        for (Role role : list) {
            assertTrue(role.getName().startsWith("descp"));
        }
        list = roleMapper.selectWithTemplate10("descp%");
        for (Role role : list) {
            assertTrue(role.getName().startsWith("descp"));
        }
    }
}
