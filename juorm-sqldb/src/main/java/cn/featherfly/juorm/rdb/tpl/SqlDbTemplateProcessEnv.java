
package cn.featherfly.juorm.rdb.tpl;

import cn.featherfly.juorm.rdb.jdbc.mapping.JdbcMappingFactory;
import cn.featherfly.juorm.rdb.sql.dialect.Dialect;
import cn.featherfly.juorm.tpl.TemplateDirectives;
import cn.featherfly.juorm.tpl.TemplateProcessEnv;
import cn.featherfly.juorm.tpl.TemplateMethods;
import cn.featherfly.juorm.tpl.TplConfigFactory;
import cn.featherfly.juorm.tpl.directive.PropertiesMappingDirective;
import cn.featherfly.juorm.tpl.directive.TemplateDirective;
import cn.featherfly.juorm.tpl.method.TemplateMethod;
import cn.featherfly.juorm.tpl.supports.ConditionParamsManager;

/**
 * <p>
 * SqlDbTemplateEnv
 * </p>
 *
 * @author zhongj
 */
public abstract class SqlDbTemplateProcessEnv<D extends TemplateDirective, M extends TemplateMethod>
        implements TemplateProcessEnv<D, M> {

    protected ConditionParamsManager manager;

    protected Class<?> resultType;

    protected JdbcMappingFactory mappingFactory;

    protected TplConfigFactory configFactory;

    protected Dialect dialect;

    /**
     */
    public SqlDbTemplateProcessEnv() {
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
     * @param configFactory configFactory
     */
    public void setConfigFactory(TplConfigFactory configFactory) {
        this.configFactory = configFactory;
    }

    /**
     * set mappingFactory
     *
     * @param mappingFactory mappingFactory
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
     * @param manager manager
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
     * @param resultType resultType
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
     * @param dialect dialect
     */
    public void setDialect(Dialect dialect) {
        this.dialect = dialect;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TemplateDirectives<D> createDirectives() {
        TemplateDirectives<D> directives = new TemplateDirectives<>();
        directives.addWhereDirective(createWhereDirective());
        directives.addAndDirective(createAndDirective());
        directives.addOrDirective(createOrDirective());
        directives.addPropertiesDirective(createPropertiesDirective());
        directives.addTemplateIncludeDirective(createIncludeDirective());
        directives.addWrapDirective(createWrapDirective());

        directives.addDirective("sql", createIncludeDirective());
        D directive = createPropertiesDirective();
        if (directive instanceof PropertiesMappingDirective) {
            PropertiesMappingDirective p = (PropertiesMappingDirective) directive;
            p.setParamName("table");
            directives.addDirective("columns", directive);
        }
        return directives;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TemplateMethods<M> createMethods() {
        TemplateMethods<M> methods = new TemplateMethods<>();
        methods.addWrapMethode(createWrapMethode());
        return methods;
    }

    /**
     * createWhereDirective
     *
     * @return
     */
    protected abstract D createWhereDirective();

    /**
     * createAndDirective
     *
     * @return
     */
    protected abstract D createAndDirective();

    /**
     * createOrDirective
     *
     * @return
     */
    protected abstract D createOrDirective();

    /**
     * createPropertiesDirective
     *
     * @return
     */
    protected abstract D createPropertiesDirective();

    /**
     * createTemplateIncludeDirective
     *
     * @return
     */
    protected abstract D createIncludeDirective();

    /**
     * createWrapDirective
     *
     * @return
     */
    protected abstract D createWrapDirective();

    /**
     * createWrapMethode
     *
     * @return
     */
    protected abstract M createWrapMethode();
}
