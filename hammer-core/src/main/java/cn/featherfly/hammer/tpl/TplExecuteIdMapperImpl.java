
package cn.featherfly.hammer.tpl;

/**
 * TplExecuteIdExecutionImpl .
 *
 * @author zhongj
 */
public class TplExecuteIdMapperImpl extends TplExecuteIdImpl {

    private Class<?> mapper;

    /**
     * Instantiates a new tpl execute id mapper impl.
     *
     * @param name      the name
     * @param namespace the namespace
     * @param mapper    the mapper
     * @param parser    the parser
     */
    public TplExecuteIdMapperImpl(String name, String namespace, Class<?> mapper, TplExecuteIdParser parser) {
        super(name, namespace, parser);
        this.mapper = mapper;
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
        return "TplExecuteIdMapperImpl [name=" + name + ", namespace=" + namespace + ", mapper=" + mapper + ", parser="
                + parser + "]";
    }

}
