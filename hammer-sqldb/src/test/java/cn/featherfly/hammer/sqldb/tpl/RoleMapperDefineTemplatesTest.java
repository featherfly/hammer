
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
        configFactory = TplConfigFactoryImpl.builder() //
            .prefixes("tpl/").suffixes(".yaml.tpl").basePackages(basePackages).config(hammerConfig.getTemplateConfig())
            .preCompile(new FreemarkerTemplatePreProcessor(
                hammerConfig.getTemplateConfig().setPrecompileNamedParamPlaceholder(true)
            // 先使用命名参数(setPrecompileNamedParamPlaceholder(true))，
            // 即执行模板时不认为模板为jdbc sql模板占位符(select * from user where id = ?)
            // 而是使用命名占位符(select * from user where id = :id)
            // YUFEI_TEST 后续单独测试setPrecompileNamedParamPlaceholder(false)的情况，主要测试不是include机制
            )).build();

        Hammer hammer = SqldbHammerImpl
            .builder(jdbc, mappingFactory, configFactory, propertyAccessorFactory, hammerConfig).build();
        roleMapper = mapperFactory.newInstance(RoleMapperDefineTemplates.class, hammer, hammerConfig);
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
