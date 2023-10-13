
package cn.featherfly.hammer.dsl.execute;

import java.util.function.Predicate;

/**
 * UpdateValueImpl.
 *
 * @author zhongj
 */
public class UpdateValueImpl implements UpdateValue {

    private String name;

    private ExecutableUpdate update;

    /**
     * @param name   name
     * @param update update
     */
    public UpdateValueImpl(String name, ExecutableUpdate update) {
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

    /**
     * {@inheritDoc}
     */
    @Override
    public ExecutableUpdate set(Object value, Predicate<Object> ignoreStrategy) {
        return update.set(name, value, ignoreStrategy);
    }
}
