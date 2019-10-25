
package cn.featherfly.juorm.tpl;

import cn.featherfly.juorm.JuormException;

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
     * @param executeId executeId
     */
    public TplExecuteIdImpl(String executeId) {
        super();
        String[] args = executeId.split(TplConfigFactory.ID_SIGN);
        if (args.length != 2) {
            throw new JuormException("executeId[" + executeId + "] format error, format must be namespace"
                    + TplConfigFactory.ID_SIGN + "name");
        }
        namespace = args[0];
        name = args[1];
    }

    /**
     * @param name      name
     * @param namespace namespace
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
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "TplExecuteIdImpl [name=" + name + ", namespace=" + namespace + "]";
    }
}
