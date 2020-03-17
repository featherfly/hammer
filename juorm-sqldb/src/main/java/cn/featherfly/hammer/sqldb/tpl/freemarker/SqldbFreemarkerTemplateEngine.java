
package cn.featherfly.hammer.sqldb.tpl.freemarker;

import cn.featherfly.hammer.sqldb.tpl.SqlDbTemplateEngine;
import cn.featherfly.hammer.sqldb.tpl.SqlDbTemplateProcessEnv;
import cn.featherfly.hammer.tpl.TplConfigFactory;
import cn.featherfly.hammer.tpl.freemarker.AbstractFreemarkerTemplateEngine;
import cn.featherfly.hammer.tpl.freemarker.FreemarkerDirective;
import cn.featherfly.hammer.tpl.freemarker.FreemarkerMethod;

/**
 * <p>
 * SqldbFreemarkerTemplateEngine
 * </p>
 *
 * @author zhongj
 */
public class SqldbFreemarkerTemplateEngine
        extends AbstractFreemarkerTemplateEngine<SqlDbTemplateProcessEnv<FreemarkerDirective, FreemarkerMethod>>
        implements SqlDbTemplateEngine<FreemarkerDirective, FreemarkerMethod> {

    /**
     * @param configFactory
     */
    public SqldbFreemarkerTemplateEngine(TplConfigFactory configFactory) {
        super(configFactory);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SqlDbTemplateProcessEnv<FreemarkerDirective, FreemarkerMethod> createTemplateProcessEnv() {
        return new SqldbFreemarkerTemplateProcessEnv();
    }
}
