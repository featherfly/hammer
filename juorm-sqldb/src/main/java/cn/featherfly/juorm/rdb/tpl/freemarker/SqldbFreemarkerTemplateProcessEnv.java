
package cn.featherfly.juorm.rdb.tpl.freemarker;

import cn.featherfly.juorm.rdb.tpl.SqlDbTemplateProcessEnv;
import cn.featherfly.juorm.rdb.tpl.freemarker.directive.AndTemplateDirectiveModel;
import cn.featherfly.juorm.rdb.tpl.freemarker.directive.IncludeDirectiveModel;
import cn.featherfly.juorm.rdb.tpl.freemarker.directive.OrTemplateDirectiveModel;
import cn.featherfly.juorm.rdb.tpl.freemarker.directive.PropertiesMappingDirectiveModel;
import cn.featherfly.juorm.rdb.tpl.freemarker.directive.WhereTemplateDirectiveModel;
import cn.featherfly.juorm.rdb.tpl.freemarker.directive.WrapTemplateDirectiveModel;
import cn.featherfly.juorm.rdb.tpl.freemarker.method.WrapMethodModel;
import cn.featherfly.juorm.tpl.freemarker.FreemarkerDirective;
import cn.featherfly.juorm.tpl.freemarker.FreemarkerMethod;

/**
 * <p>
 * JdbcFreemarkerTemplateEnv
 * </p>
 *
 * @author zhongj
 */
public class SqldbFreemarkerTemplateProcessEnv extends SqlDbTemplateProcessEnv<FreemarkerDirective, FreemarkerMethod> {

    /**
     */
    public SqldbFreemarkerTemplateProcessEnv() {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected FreemarkerDirective createWhereDirective() {
        return new WhereTemplateDirectiveModel();

    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected FreemarkerDirective createAndDirective() {
        return new AndTemplateDirectiveModel(manager);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected FreemarkerDirective createOrDirective() {
        return new OrTemplateDirectiveModel(manager);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected FreemarkerDirective createPropertiesDirective() {
        return new PropertiesMappingDirectiveModel(mappingFactory, resultType);

    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected FreemarkerDirective createIncludeDirective() {
        return new IncludeDirectiveModel(configFactory);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected FreemarkerDirective createWrapDirective() {
        return new WrapTemplateDirectiveModel(dialect);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected FreemarkerMethod createWrapMethode() {
        return new WrapMethodModel(dialect);
    }
}
