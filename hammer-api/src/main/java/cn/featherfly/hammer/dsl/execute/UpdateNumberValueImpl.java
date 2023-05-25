
package cn.featherfly.hammer.dsl.execute;

import java.util.function.Supplier;

/**
 * UpdateNumberValueImpl.
 *
 * @author zhongj
 */
public class UpdateNumberValueImpl implements UpdateNumberValue {

    private String name;

    private ExecutableUpdate update;

    /**
     * @param update update
     * @param name   name
     */
    public UpdateNumberValueImpl(String name, ExecutableUpdate update) {
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
    public ExecutableUpdate increase(Supplier<Boolean> whether, Number value) {
        return update.increase(whether, name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ExecutableUpdate set(Number value) {
        return update.set(name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ExecutableUpdate set(Supplier<Boolean> whether, Number value) {
        return update.set(whether, name, value);
    }
}
