
package cn.featherfly.hammer.sqldb.tpl.freemarker;

import cn.featherfly.hammer.config.tpl.TemplateConfig;
import cn.featherfly.hammer.sqldb.tpl.SqlDbTemplateEngine;
import cn.featherfly.hammer.sqldb.tpl.SqlDbTemplateProcessEnv;
import cn.featherfly.hammer.tpl.TemplateDirectives;
import cn.featherfly.hammer.tpl.TemplateMethods;
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
     * @param configFactory configFactory
     * @param templateConfig the template config
     * @param sharedTemplateDirectives the shared template directives
     * @param sharedTemplateMethods the shared template methods
     */
    public SqldbFreemarkerTemplateEngine(TplConfigFactory configFactory, TemplateConfig templateConfig,
        TemplateDirectives<FreemarkerDirective> sharedTemplateDirectives,
        TemplateMethods<FreemarkerMethod> sharedTemplateMethods) {
        super(configFactory, templateConfig, sharedTemplateDirectives, sharedTemplateMethods);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SqlDbTemplateProcessEnv<FreemarkerDirective, FreemarkerMethod> createTemplateProcessEnv() {
        return new SqldbFreemarkerTemplateProcessEnv(false);
    }
}
