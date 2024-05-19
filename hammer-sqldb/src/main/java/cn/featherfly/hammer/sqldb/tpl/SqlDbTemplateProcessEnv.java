
package cn.featherfly.hammer.sqldb.tpl;

import cn.featherfly.common.db.dialect.Dialect;
import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.hammer.tpl.TemplateDirectives;
import cn.featherfly.hammer.tpl.TemplateMethods;
import cn.featherfly.hammer.tpl.TemplateProcessEnv;
import cn.featherfly.hammer.tpl.TplConfigFactory;
import cn.featherfly.hammer.tpl.directive.PropertiesMappingDirective;
import cn.featherfly.hammer.tpl.directive.TemplateDirective;
import cn.featherfly.hammer.tpl.method.TemplateMethod;
import cn.featherfly.hammer.tpl.supports.ConditionParamsManager;
import cn.featherfly.hammer.tpl.supports.PropertiesMappingManager;

/**
 * SqlDbTemplateEnv .
 *
 * @author zhongj
 * @param <D> the generic type
 * @param <M> the generic type
 */
public abstract class SqlDbTemplateProcessEnv<D extends TemplateDirective, M extends TemplateMethod>
    implements TemplateProcessEnv<D, M> {

    /** The condition params manager. */
    protected ConditionParamsManager conditionParamsManager;

    /** The properties mapping manager. */
    protected PropertiesMappingManager propertiesMappingManager;

    /** The result types. */
    protected Class<?>[] resultTypes;

    /** The mapping factory. */
    protected JdbcMappingFactory mappingFactory;

    /** The config factory. */
    protected TplConfigFactory configFactory;

    /** The dialect. */
    protected Dialect dialect;

    /**
     * Instantiates a new sql db template process env.
     */
    public SqlDbTemplateProcessEnv() {
    }

    /**
     * get configFactory.
     *
     * @return configFactory
     */
    public TplConfigFactory getConfigFactory() {
        return configFactory;
    }

    /**
     * set configFactory.
     *
     * @param configFactory configFactory
     */
    public void setConfigFactory(TplConfigFactory configFactory) {
        this.configFactory = configFactory;
    }

    /**
     * set mappingFactory.
     *
     * @param mappingFactory mappingFactory
     */
    public void setMappingFactory(JdbcMappingFactory mappingFactory) {
        this.mappingFactory = mappingFactory;
    }

    /**
     * get manager.
     *
     * @return manager
     */
    public ConditionParamsManager getConditionParamsManager() {
        return conditionParamsManager;
    }

    /**
     * set manager.
     *
     * @param conditionParamsManager the new condition params manager
     */
    public void setConditionParamsManager(ConditionParamsManager conditionParamsManager) {
        this.conditionParamsManager = conditionParamsManager;
    }

    /**
     * get propertiesMappingManager value.
     *
     * @return propertiesMappingManager
     */
    public PropertiesMappingManager getPropertiesMappingManager() {
        return propertiesMappingManager;
    }

    /**
     * set propertiesMappingManager value.
     *
     * @param propertiesMappingManager propertiesMappingManager
     */
    public void setPropertiesMappingManager(PropertiesMappingManager propertiesMappingManager) {
        this.propertiesMappingManager = propertiesMappingManager;
    }

    /**
     * Gets the result types.
     *
     * @return resultType
     */
    public Class<?>[] getResultTypes() {
        return resultTypes;
    }

    /**
     * Sets the result type.
     *
     * @param resultTypes the new result type
     */
    public void setResultTypes(Class<?>... resultTypes) {
        this.resultTypes = resultTypes;
    }

    /**
     * get mappingFactory.
     *
     * @return mappingFactory
     */
    public JdbcMappingFactory getMappingFactory() {
        return mappingFactory;
    }

    /**
     * get dialect.
     *
     * @return dialect
     */
    public Dialect getDialect() {
        return dialect;
    }

    /**
     * set dialect.
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
        directives.addWrapDirective(createWrapDirective());
        directives.addStringReplaceDirective(createStringReplaceDirective());

        // include
        directives.addTemplateIncludeDirective(createIncludeDirective());
        directives.addDirective("sql", createIncludeDirective());
        D directive = createPropertiesDirective();
        if (directive instanceof PropertiesMappingDirective) {
            PropertiesMappingDirective p = (PropertiesMappingDirective) directive;
            p.setParamName("table");
            directives.addDirective("columns", directive);
        }
        // include
        return directives;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TemplateMethods<M> createMethods() {
        TemplateMethods<M> methods = new TemplateMethods<>();
        methods.addWrapMethode(createWrapMethode());
        methods.addStringReplaceMethode(createStringReplaceMethode());
        return methods;
    }

    /**
     * createWhereDirective.
     *
     * @return WhereDirective
     */
    protected abstract D createWhereDirective();

    /**
     * createAndDirective.
     *
     * @return AndDirective
     */
    protected abstract D createAndDirective();

    /**
     * createOrDirective.
     *
     * @return OrDirective
     */
    protected abstract D createOrDirective();

    /**
     * createPropertiesDirective.
     *
     * @return PropertiesDirective
     */
    protected abstract D createPropertiesDirective();

    /**
     * createTemplateIncludeDirective.
     *
     * @return IncludeDirective
     */
    protected abstract D createIncludeDirective();

    /**
     * createWrapDirective.
     *
     * @return WrapDirective
     */
    protected abstract D createWrapDirective();

    /**
     * createWrapMethode.
     *
     * @return WrapMethode
     */
    protected abstract M createWrapMethode();

    /**
     * Creates the string replace directive.
     *
     * @return StringReplaceDirective
     */
    protected abstract D createStringReplaceDirective();

    /**
     * Creates the string replace methode.
     *
     * @return StringReplaceMethode
     */
    protected abstract M createStringReplaceMethode();
}
