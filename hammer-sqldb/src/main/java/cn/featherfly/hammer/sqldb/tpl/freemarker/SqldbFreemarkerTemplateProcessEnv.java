
package cn.featherfly.hammer.sqldb.tpl.freemarker;

import cn.featherfly.hammer.sqldb.tpl.SqlDbTemplateProcessEnv;
import cn.featherfly.hammer.sqldb.tpl.freemarker.directive.AndTemplateDirectiveModel;
import cn.featherfly.hammer.sqldb.tpl.freemarker.directive.IncludeDirectiveModel;
import cn.featherfly.hammer.sqldb.tpl.freemarker.directive.OrTemplateDirectiveModel;
import cn.featherfly.hammer.sqldb.tpl.freemarker.directive.PropertiesMappingDirectiveModel;
import cn.featherfly.hammer.sqldb.tpl.freemarker.directive.WhereTemplateDirectiveModel;
import cn.featherfly.hammer.sqldb.tpl.freemarker.directive.WrapTemplateDirectiveModel;
import cn.featherfly.hammer.sqldb.tpl.freemarker.method.WrapMethodModel;
import cn.featherfly.hammer.tpl.freemarker.FreemarkerDirective;
import cn.featherfly.hammer.tpl.freemarker.FreemarkerMethod;

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
