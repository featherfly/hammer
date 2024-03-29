
package cn.featherfly.hammer.tpl;

/**
 * <p>
 * TplExecuteIdExecutionImpl
 * </p>
 * .
 *
 * @author zhongj
 */
public class TplExecuteIdMapperImpl implements TplExecuteId {

    private String name;

    private String namespace;

    private Class<?> mapper;

    /**
     * Instantiates a new tpl execute id mapper impl.
     *
     * @param name      the name
     * @param namespace the namespace
     * @param mapper    the mapper
     */
    public TplExecuteIdMapperImpl(String name, String namespace, Class<?> mapper) {
        super();
        this.name = name;
        this.namespace = namespace;
        this.mapper = mapper;
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
     * 返回mapper.
     *
     * @return mapper
     */
    public Class<?> getMapper() {
        return mapper;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "TplExecuteIdMapperImpl [name=" + name + ", namespace=" + namespace + ", mapper=" + mapper + "]";
    }
}
