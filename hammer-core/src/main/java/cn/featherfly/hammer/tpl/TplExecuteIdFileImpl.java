
package cn.featherfly.hammer.tpl;

import cn.featherfly.common.lang.Lang;

/**
 * <p>
 * TplExecuteIdFileImpl
 * </p>
 *
 * @author zhongj
 */
public class TplExecuteIdFileImpl implements TplExecuteId {

    private String name;

    private String namespace;

    /**
     * @param executeId executeId
     */
    public TplExecuteIdFileImpl(String executeId) {
        super();
        String[] args = executeId.split(TplConfigFactory.ID_SIGN);
        if (args.length == 2) {
            namespace = args[0];
            name = args[1];
            //            throw new HammerException("executeId[" + executeId + "] format error, format must be namespace"
            //                    + TplConfigFactory.ID_SIGN + "name");
        } else {
            name = executeId;
        }
    }

    /**
     * @param name      name
     * @param namespace namespace
     */
    public TplExecuteIdFileImpl(String name, String namespace) {
        super();
        this.name = name;
        this.namespace = namespace;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getId() {
        return Lang.isEmpty(namespace) ? name : namespace + TplConfigFactory.ID_SIGN + name;
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
