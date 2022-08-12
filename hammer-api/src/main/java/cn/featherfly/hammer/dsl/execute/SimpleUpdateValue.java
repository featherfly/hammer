
package cn.featherfly.hammer.dsl.execute;

import java.util.function.Consumer;

import cn.featherfly.hammer.expression.execute.UpdateValueExpression;

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

    /**
     * {@inheritDoc}
     */
    @Override
    public ExecutableUpdate set(
            Consumer<UpdateValueExpression<ExecutableUpdate, ExecutableConditionGroupExpression, ExecutableConditionGroupLogicExpression, Object, UpdateValue, UpdateNumberValue>> consumer) {
        consumer.accept(this);
        return update;
    }

}
