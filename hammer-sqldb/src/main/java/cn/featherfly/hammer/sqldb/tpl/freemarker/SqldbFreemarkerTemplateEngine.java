
package cn.featherfly.hammer.sqldb.tpl.freemarker;

import cn.featherfly.hammer.config.tpl.TemplateConfig;
import cn.featherfly.hammer.sqldb.tpl.SqlDbTemplateEngine;
import cn.featherfly.hammer.sqldb.tpl.SqlDbTemplateProcessEnv;
import cn.featherfly.hammer.tpl.TplConfigFactory;
import cn.featherfly.hammer.tpl.freemarker.AbstractFreemarkerTemplateEngine;
import cn.featherfly.hammer.tpl.freemarker.FreemarkerDirective;
import cn.featherfly.hammer.tpl.freemarker.FreemarkerMethod;

/**
 * SqldbFreemarkerTemplateEngine.
 *
 * @author zhongj
 */
public class SqldbFreemarkerTemplateEngine
    extends AbstractFreemarkerTemplateEngine<SqlDbTemplateProcessEnv<FreemarkerDirective, FreemarkerMethod>>
    implements SqlDbTemplateEngine<FreemarkerDirective, FreemarkerMethod> {

    /**
     * Instantiates a new sqldb freemarker template engine.
     *
     * @param configFactory  configFactory
     * @param templateConfig the template config
     */
    public SqldbFreemarkerTemplateEngine(TplConfigFactory configFactory, TemplateConfig templateConfig) {
        super(configFactory, templateConfig);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SqlDbTemplateProcessEnv<FreemarkerDirective, FreemarkerMethod> createTemplateProcessEnv() {
        return new SqldbFreemarkerTemplateProcessEnv();
    }
}
