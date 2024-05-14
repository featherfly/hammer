
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2024-05-15 03:44:15
 * @Copyright: 2024 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.tpl;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import cn.featherfly.common.db.SqlUtils;
import cn.featherfly.hammer.config.TemplateConfigImpl;
import cn.featherfly.hammer.tpl.freemarker.FreemarkerTemplatePreProcessor;

/**
 * TplConfigFactoryTest.
 *
 * @author zhongj
 */
public class TplConfigFactoryTest {

    TplConfigFactory configFactory;

    TplExecuteConfig config = new TplExecuteConfig();

    private FreemarkerTemplatePreProcessor processor;

    @BeforeClass
    void bc() {
        TemplateConfigImpl templateConfig = new TemplateConfigImpl();
        templateConfig.setIncludeDirectiveTagNames(new String[] { "include", "tpl", "sql" })
                .setPrecompileNamedParamPlaceholder(false).setPrecompileMinimize(false)
                .setCountSqlConvertor((sql, namedParamPlaceholder) -> SqlUtils.convertSelectToCount(sql));

        processor = new FreemarkerTemplatePreProcessor(templateConfig);

        configFactory = TplConfigFactoryImpl.builder().prefixes("tpl/sql").suffixes(".yaml.sql").config(templateConfig)
                .preCompile(processor).build();
    }

    @Test
    void testInclude() {
        TplExecuteConfig config = configFactory.getConfig("selectWithTemplate@role");
        System.err.println(config.getContent());
        System.err.println(config.getCount());

        config = configFactory.getConfig("selectWithTemplate2@role");
        System.err.println(config.getContent());
        System.err.println(config.getCount());

        config = configFactory.getConfig("selectConditions@preprocess");
        System.err.println(config.getContent());
        System.err.println(config.getCount());

        config = configFactory.getConfig("selectConditions2@preprocess");
        System.err.println(config.getContent());
        System.err.println(config.getCount());

        config = configFactory.getConfig("selectWithTemplate@user");
        System.err.println(config.getContent());
        System.err.println(config.getCount());

        System.out.println(SqlUtils.convertSelectToCount(config.getContent()));

    }

}
