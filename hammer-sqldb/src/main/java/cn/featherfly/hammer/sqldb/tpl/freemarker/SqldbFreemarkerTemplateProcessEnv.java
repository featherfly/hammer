
package cn.featherfly.hammer.sqldb.tpl.freemarker;

import cn.featherfly.hammer.sqldb.tpl.SqlDbTemplateProcessEnv;
import cn.featherfly.hammer.sqldb.tpl.freemarker.directive.AndDirectiveModel;
import cn.featherfly.hammer.sqldb.tpl.freemarker.directive.IncludeDirectiveModel;
import cn.featherfly.hammer.sqldb.tpl.freemarker.directive.OrDirectiveModel;
import cn.featherfly.hammer.sqldb.tpl.freemarker.directive.PropertiesMappingDirectiveModel;
import cn.featherfly.hammer.sqldb.tpl.freemarker.directive.StringReplaceDirectiveModel;
import cn.featherfly.hammer.sqldb.tpl.freemarker.directive.WhereDirectiveModel;
import cn.featherfly.hammer.sqldb.tpl.freemarker.directive.WrapDirectiveModel;
import cn.featherfly.hammer.sqldb.tpl.freemarker.method.StringReplaceMethodModel;
import cn.featherfly.hammer.sqldb.tpl.freemarker.method.WrapMethodModel;
import cn.featherfly.hammer.tpl.freemarker.FreemarkerDirective;
import cn.featherfly.hammer.tpl.freemarker.FreemarkerMethod;

/**
 * SqldbFreemarkerTemplateProcessEnv.
 *
 * @author zhongj
 */
public class SqldbFreemarkerTemplateProcessEnv extends SqlDbTemplateProcessEnv<FreemarkerDirective, FreemarkerMethod> {

    /**
     * Instantiates a new sqldb freemarker template process env.
     *
     * @param shared shared
     */
    public SqldbFreemarkerTemplateProcessEnv(boolean shared) {
        super(shared);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected FreemarkerDirective createWhereDirective() {
        return new WhereDirectiveModel(templateConfig);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected FreemarkerDirective createAndDirective() {
        return new AndDirectiveModel();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected FreemarkerDirective createOrDirective() {
        return new OrDirectiveModel();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected FreemarkerDirective createPropertiesDirective() {
        return new PropertiesMappingDirectiveModel(mappingFactory, propertiesMappingManager, resultTypes);
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
        return new WrapDirectiveModel(dialect);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected FreemarkerMethod createWrapMethode() {
        return new WrapMethodModel(dialect);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected FreemarkerDirective createStringReplaceDirective() {
        return new StringReplaceDirectiveModel();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected FreemarkerMethod createStringReplaceMethode() {
        return new StringReplaceMethodModel();
    }
}
