
package cn.featherfly.hammer.tpl.directive;

import cn.featherfly.common.repository.mapping.MappingFactory;
import cn.featherfly.hammer.HammerException;
import cn.featherfly.hammer.tpl.supports.PropertiesMappingManager;

/**
 * <p>
 * PropertiesMappingDirective
 * </p>
 * .
 *
 * @author zhongj
 */
public abstract class PropertiesMappingDirective implements TemplateDirective {

    /** The Constant DEFAULT_PARAM_NAME_NAME. */
    protected static final String DEFAULT_PARAM_NAME_NAME = "repo";

    /** The Constant PARAM_NAME_ALIAS. */
    protected static final String PARAM_NAME_ALIAS = "alias";

    /** The Constant PARAM_NAME_MAPPING. */
    protected static final String PARAM_NAME_MAPPING = "mapping";

    /** The mapping factory. */
    protected MappingFactory<?> mappingFactory;

    /** The result types. */
    protected Class<?>[] resultTypes;

    /** The param name. */
    protected String paramName;

    /** The manager. */
    protected PropertiesMappingManager manager;

    /**
     * Instantiates a new properties mapping directive.
     *
     * @param mappingFactory mappingFactory
     * @param resultTypes    the result types
     */
    public PropertiesMappingDirective(MappingFactory<?> mappingFactory, PropertiesMappingManager manager,
            Class<?>... resultTypes) {
        this(DEFAULT_PARAM_NAME_NAME, mappingFactory, manager, resultTypes);
    }

    /**
     * Instantiates a new properties mapping directive.
     *
     * @param paramName      paramName
     * @param mappingFactory mappingFactory
     * @param manager        the manager
     * @param resultTypes    the result types
     */
    public PropertiesMappingDirective(String paramName, MappingFactory<?> mappingFactory,
            PropertiesMappingManager manager, Class<?>... resultTypes) {
        super();
        this.mappingFactory = mappingFactory;
        this.paramName = paramName;
        this.manager = manager;
        this.resultTypes = resultTypes;
    }

    /**
     * 返回paramName.
     *
     * @return paramName
     */
    public String getParamName() {
        return paramName;
    }

    /**
     * 设置paramName.
     *
     * @param paramName paramName
     */
    public void setParamName(String paramName) {
        this.paramName = paramName;
    }

    /**
     * Gets the result type.
     *
     * @param resultType the result type
     * @return the result type
     */
    public Class<?> getResultType(Class<?> resultType) {
        for (Class<?> rt : resultTypes) {
            if (resultType == rt) {
                return resultType;
            }
        }
        return null;
    }

    /**
     * Gets the result type.
     *
     * @param index the index
     * @return the result type
     */
    public Class<?> getResultType(int index) {
        if (resultTypes.length == 0) {
            return null;
        }
        if (index < 0 || index >= resultTypes.length) {
            throw new HammerException("index must between 0 and " + resultTypes.length);
        }
        return resultTypes[index];
    }
}
