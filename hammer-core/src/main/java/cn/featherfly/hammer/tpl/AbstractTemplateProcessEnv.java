
package cn.featherfly.hammer.tpl;

import cn.featherfly.hammer.config.tpl.TemplateConfig;
import cn.featherfly.hammer.tpl.directive.TemplateDirective;
import cn.featherfly.hammer.tpl.method.TemplateMethod;
import cn.featherfly.hammer.tpl.supports.PropertiesMappingManager;

/**
 * SqlDbTemplateEnv .
 *
 * @author zhongj
 * @param <D> the generic type
 * @param <M> the generic type
 */
public abstract class AbstractTemplateProcessEnv<D extends TemplateDirective, M extends TemplateMethod>
    implements TemplateProcessEnv<D, M> {

    /** The properties mapping manager. */
    protected PropertiesMappingManager propertiesMappingManager;

    /** The result types. */
    protected Class<?>[] resultTypes;

    /** The config factory. */
    protected TplConfigFactory configFactory;

    /** The template config. */
    protected TemplateConfig templateConfig;

    /**
     * Instantiates a new sql db template process env.
     */
    public AbstractTemplateProcessEnv() {
    }

    /**
     * Instantiates a new sql db template process env.
     *
     * @param configFactory the config factory
     * @param propertiesMappingManager the properties mapping manager
     * @param templateConfig the template config
     */
    public AbstractTemplateProcessEnv(TplConfigFactory configFactory, PropertiesMappingManager propertiesMappingManager,
        TemplateConfig templateConfig) {
        this.configFactory = configFactory;
        this.propertiesMappingManager = propertiesMappingManager;
        this.templateConfig = templateConfig;
    }

    /**
     * Sets the properties mapping manager.
     *
     * @param propertiesMappingManager the new properties mapping manager
     */
    public void setPropertiesMappingManager(PropertiesMappingManager propertiesMappingManager) {
        this.propertiesMappingManager = propertiesMappingManager;
    }

    /**
     * Sets the config factory.
     *
     * @param configFactory the new config factory
     */
    public void setConfigFactory(TplConfigFactory configFactory) {
        this.configFactory = configFactory;
    }

    /**
     * Sets the template config.
     *
     * @param templateConfig the new template config
     */
    public void setTemplateConfig(TemplateConfig templateConfig) {
        this.templateConfig = templateConfig;
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
     * get propertiesMappingManager value.
     *
     * @return propertiesMappingManager
     */
    public PropertiesMappingManager getPropertiesMappingManager() {
        return propertiesMappingManager;
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
     * Gets the template config.
     *
     * @return the template config
     */
    public TemplateConfig getTemplateConfig() {
        return templateConfig;
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
