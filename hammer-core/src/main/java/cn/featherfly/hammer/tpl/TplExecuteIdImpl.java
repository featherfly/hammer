
package cn.featherfly.hammer.tpl;

/**
 * TplExecuteIdImpl.
 *
 * @author zhongj
 */
public class TplExecuteIdImpl implements TplExecuteId {

    protected final String name;

    protected String namespace;

    protected final TplExecuteIdParser parser;

    /**
     * Instantiates a new tpl execute id impl.
     *
     * @param name   the name
     * @param parser the parser
     */
    protected TplExecuteIdImpl(String name, TplExecuteIdParser parser) {
        this(name, null, parser);
    }

    /**
     * Instantiates a new tpl execute id impl.
     *
     * @param name      the name
     * @param namespace the namespace
     * @param parser    the parser
     */
    protected TplExecuteIdImpl(String name, String namespace, TplExecuteIdParser parser) {
        super();
        this.name = name;
        this.namespace = namespace;
        this.parser = parser;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getId() {
        return parser.format(this);
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
        return "TplExecuteIdImpl [name=" + name + ", namespace=" + namespace + ", parser=" + parser + "]";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (name == null ? 0 : name.hashCode());
        result = prime * result + (namespace == null ? 0 : namespace.hashCode());
        return result;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        TplExecuteIdImpl other = (TplExecuteIdImpl) obj;
        if (name == null) {
            if (other.name != null) {
                return false;
            }
        } else if (!name.equals(other.name)) {
            return false;
        }
        if (namespace == null) {
            if (other.namespace != null) {
                return false;
            }
        } else if (!namespace.equals(other.namespace)) {
            return false;
        }
        return true;
    }
}
