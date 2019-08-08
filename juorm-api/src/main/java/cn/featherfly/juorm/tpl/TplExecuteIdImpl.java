
package cn.featherfly.juorm.tpl;

/**
 * <p>
 * TplExecuteIdImpl
 * </p>
 * <p>
 * 2019-08-12
 * </p>
 *
 * @author zhongj
 */
public class TplExecuteIdImpl implements TplExecuteId {

    private String name;

    private String namespace;

    /**
     * @param name
     * @param namespace
     */
    public TplExecuteIdImpl(String name, String namespace) {
        super();
        this.name = name;
        this.namespace = namespace;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getId() {
        return namespace + TplConfigFactory.IdSign + name;
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

}
