
package cn.featherfly.hammer.expression;

/**
 * <p>
 * Repository
 * </p>
 *
 * @author zhongj
 */
public class SimpleRepository implements Repository {

    private String name;

    private String alias;

    /**
     */
    public SimpleRepository() {

    }

    /**
     * @param name name
     */
    public SimpleRepository(String name) {
        super();
        this.name = name;
    }

    /**
     * @param name  name
     * @param alias alias
     */
    public SimpleRepository(String name, String alias) {
        super();
        this.name = name;
        this.alias = alias;
    }

    /**
     * 返回name
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置name
     *
     * @param name name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String name() {
        return getName();
    }

    /**
     * 返回alias
     *
     * @return alias
     */
    public String getAlias() {
        return alias;
    }

    /**
     * 设置alias
     *
     * @param alias alias
     */
    public void setAlias(String alias) {
        this.alias = alias;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String alias() {
        return getAlias();
    }
}
