
package cn.featherfly.juorm.tpl.directive;

import cn.featherfly.juorm.mapping.MappingFactory;

/**
 * <p>
 * PropertiesMappingDirective
 * </p>
 *
 * @author zhongj
 */
public abstract class PropertiesMappingDirective implements TemplateDirective {

    protected static final String DEFAULT_PARAM_NAME_NAME = "repo";

    protected static final String PARAM_NAME_ALIAS = "alias";

    protected static final String PARAM_NAME_MAPPING = "mapping";

    protected MappingFactory mappingFactory;

    protected Class<?> resultType;

    protected String paramName;

    /**
     * @param mappingFactory mappingFactory
     * @param resultType     resultType
     */
    public PropertiesMappingDirective(MappingFactory mappingFactory, Class<?> resultType) {
        this(DEFAULT_PARAM_NAME_NAME, mappingFactory, resultType);
    }

    /**
     * @param paramName      paramName
     * @param mappingFactory mappingFactory
     * @param resultType     resultType
     */
    public PropertiesMappingDirective(String paramName, MappingFactory mappingFactory, Class<?> resultType) {
        super();
        this.mappingFactory = mappingFactory;
        this.paramName = paramName;
        this.resultType = resultType;
    }

    /**
     * 返回paramName
     * 
     * @return paramName
     */
    public String getParamName() {
        return paramName;
    }

    /**
     * 设置paramName
     * 
     * @param paramName paramName
     */
    public void setParamName(String paramName) {
        this.paramName = paramName;
    }
}
