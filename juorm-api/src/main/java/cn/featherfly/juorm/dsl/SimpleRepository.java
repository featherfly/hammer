
package cn.featherfly.juorm.dsl;

/**
 * <p>
 * Repository
 * </p>
 *
 * @author zhongj
 */
public class SimpleRepository implements Repository {

    private String name;

    /**
     */
    public SimpleRepository() {

    }

    /**
     * @param name
     */
    public SimpleRepository(String name) {
        super();
        this.name = name;
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
}
