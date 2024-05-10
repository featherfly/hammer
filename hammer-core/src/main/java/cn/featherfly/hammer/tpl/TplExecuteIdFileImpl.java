
package cn.featherfly.hammer.tpl;

/**
 * TplExecuteIdFileImpl.
 *
 * @author zhongj
 */
public class TplExecuteIdFileImpl extends TplExecuteIdImpl {

    /**
     * Instantiates a new tpl execute id file impl.
     *
     * @param name      name
     * @param namespace namespace
     * @param parser    the parser
     */
    public TplExecuteIdFileImpl(String name, String namespace, TplExecuteIdParser parser) {
        super(name, namespace, parser);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "TplExecuteIdFileImpl [name=" + name + ", namespace=" + namespace + ", parser=" + parser + "]";
    }
}
