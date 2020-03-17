
package cn.featherfly.juorm.rdb.tpl.freemarker;

import cn.featherfly.juorm.rdb.tpl.SqlDbTemplateEngine;
import cn.featherfly.juorm.rdb.tpl.SqlDbTemplateProcessEnv;
import cn.featherfly.juorm.tpl.TplConfigFactory;
import cn.featherfly.juorm.tpl.freemarker.AbstractFreemarkerTemplateEngine;
import cn.featherfly.juorm.tpl.freemarker.FreemarkerDirective;
import cn.featherfly.juorm.tpl.freemarker.FreemarkerMethod;

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
