
package cn.featherfly.hammer.tpl;

/**
 * <p>
 * TplExecuteIdExecutionImpl
 * </p>
 *
 * @author zhongj
 */
public class TplExecuteIdMapperImpl implements TplExecuteId {

    private String name;

    private String namespace;

    private Class<?> mapper;

    private boolean isTemplate;

    /**
     * @param name       name
     * @param namespace  namespace
     * @param mapper     mapper
     * @param isTemplate isTemplate
     */
    public TplExecuteIdMapperImpl(String name, String namespace, Class<?> mapper, boolean isTemplate) {
        super();
        this.name = name;
        this.namespace = namespace;
        this.mapper = mapper;
        this.isTemplate = isTemplate;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getId() {
        return namespace + TplConfigFactory.ID_SIGN + name;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getNamespace() {
        return namespace;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * 返回mapper
     *
     * @return mapper
     */
    public Class<?> getMapper() {
        return mapper;
    }

    /**
     * 返回isTemplate
     *
     * @return isTemplate
     */
    public boolean isTemplate() {
        return isTemplate;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "TplExecuteIdMapperImpl [name=" + name + ", namespace=" + namespace + ", mapper=" + mapper
                + ", isTemplate=" + isTemplate + "]";
    }
}
