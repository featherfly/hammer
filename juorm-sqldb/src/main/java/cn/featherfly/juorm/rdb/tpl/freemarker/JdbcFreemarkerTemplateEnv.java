
package cn.featherfly.juorm.rdb.tpl.freemarker;

import cn.featherfly.juorm.rdb.jdbc.mapping.JdbcMappingFactory;
import cn.featherfly.juorm.rdb.sql.dialect.Dialect;
import cn.featherfly.juorm.rdb.tpl.freemarker.directive.AndTemplateDirectiveModel;
import cn.featherfly.juorm.rdb.tpl.freemarker.directive.IncludeDirectiveModel;
import cn.featherfly.juorm.rdb.tpl.freemarker.directive.OrTemplateDirectiveModel;
import cn.featherfly.juorm.rdb.tpl.freemarker.directive.PropertiesMappingDirectiveModel;
import cn.featherfly.juorm.rdb.tpl.freemarker.directive.WhereTemplateDirectiveModel;
import cn.featherfly.juorm.rdb.tpl.freemarker.directive.WrapTemplateDirectiveModel;
import cn.featherfly.juorm.rdb.tpl.freemarker.method.WrapMethodModel;
import cn.featherfly.juorm.tpl.FreemarkerTemplateEnv;
import cn.featherfly.juorm.tpl.TemplateDirectives;
import cn.featherfly.juorm.tpl.TemplateMethods;
import cn.featherfly.juorm.tpl.TplConfigFactory;
import cn.featherfly.juorm.tpl.supports.ConditionParamsManager;
import freemarker.template.TemplateDirectiveModel;
import freemarker.template.TemplateMethodModelEx;

/**
 * <p>
 * JdbcFreemarkerTemplateEnv
 * </p>
 * 
 * @author zhongj
 */
public class JdbcFreemarkerTemplateEnv extends FreemarkerTemplateEnv {

    private ConditionParamsManager manager;

    private Class<?> resultType;

    private JdbcMappingFactory mappingFactory;

    private TplConfigFactory configFactory;

    private Dialect dialect;

    /**
     */
    public JdbcFreemarkerTemplateEnv() {
    }

    /**
     * get configFactory
     * 
     * @return configFactory
     */
    public TplConfigFactory getConfigFactory() {
        return configFactory;
    }

    /**
     * set configFactory
     * 
     * @param configFactory
     *            configFactory
     */
    public void setConfigFactory(TplConfigFactory configFactory) {
        this.configFactory = configFactory;
    }

    /**
     * set mappingFactory
     * 
     * @param mappingFactory
     *            mappingFactory
     */
    public void setMappingFactory(JdbcMappingFactory mappingFactory) {
        this.mappingFactory = mappingFactory;
    }

    /**
     * get manager
     * 
     * @return manager
     */
    public ConditionParamsManager getManager() {
        return manager;
    }

    /**
     * set manager
     * 
     * @param manager
     *            manager
     */
    public void setManager(ConditionParamsManager manager) {
        this.manager = manager;
    }

    /**
     * get resultType
     * 
     * @return resultType
     */
    public Class<?> getResultType() {
        return resultType;
    }

    /**
     * set resultType
     * 
     * @param resultType
     *            resultType
     */
    public void setResultType(Class<?> resultType) {
        this.resultType = resultType;
    }

    /**
     * get mappingFactory
     * 
     * @return mappingFactory
     */
    public JdbcMappingFactory getMappingFactory() {
        return mappingFactory;
    }

    /**
     * get dialect
     * 
     * @return dialect
     */
    public Dialect getDialect() {
        return dialect;
    }

    /**
     * set dialect
     * 
     * @param dialect
     *            dialect
     */
    public void setDialect(Dialect dialect) {
        this.dialect = dialect;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TemplateDirectives<TemplateDirectiveModel> createDirectives() {
        TemplateDirectives<TemplateDirectiveModel> directives = new TemplateDirectives<>();
        directives.addWhereDirective(new WhereTemplateDirectiveModel());
        directives.addAndDirective(new AndTemplateDirectiveModel(manager));
        directives.addOrDirective(new OrTemplateDirectiveModel(manager));
        directives.addPropertiesDirective(new PropertiesMappingDirectiveModel(
                "repo", mappingFactory, resultType));
        directives.addTemplateIncludeDirective(
                new IncludeDirectiveModel(configFactory));
        directives.addWrapDirective(new WrapTemplateDirectiveModel(dialect));

        directives.addDirective("sql",
                new IncludeDirectiveModel(configFactory));
        directives.addDirective("columns", new PropertiesMappingDirectiveModel(
                "table", mappingFactory, resultType));
        return directives;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TemplateMethods<TemplateMethodModelEx> createMethods() {
        TemplateMethods<TemplateMethodModelEx> methods = new TemplateMethods<>();
        methods.addWrapMethode(new WrapMethodModel(dialect));
        return methods;
    }

}
