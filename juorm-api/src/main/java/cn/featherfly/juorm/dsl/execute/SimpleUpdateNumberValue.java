
package cn.featherfly.juorm.dsl.execute;

/**
 * <p>
 * SimpleUpdateValue
 * </p>
 *
 * @author zhongj
 */
public class SimpleUpdateNumberValue implements UpdateNumberValue {

    private String name;

    private ExecutableUpdate update;

    /**
     * @param update update
     * @param name   name
     */
    public SimpleUpdateNumberValue(String name, ExecutableUpdate update) {
        super();
        this.update = update;
        this.name = name;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ExecutableUpdate increase(Number value) {
        return update.increase(name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ExecutableUpdate set(Number value) {
        return update.set(name, value);
    }

}
