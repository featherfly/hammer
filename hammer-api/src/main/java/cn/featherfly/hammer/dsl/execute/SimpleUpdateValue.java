
package cn.featherfly.hammer.dsl.execute;

/**
 * <p>
 * SimpleUpdateValue
 * </p>
 *
 * @author zhongj
 */
public class SimpleUpdateValue implements UpdateValue {

    private String name;

    private ExecutableUpdate update;

    /**
     * @param name   name
     * @param update update
     */
    public SimpleUpdateValue(String name, ExecutableUpdate update) {
        super();
        this.update = update;
        this.name = name;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ExecutableUpdate set(Object value) {
        return update.set(name, value);
    }

}
