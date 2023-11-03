
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2024-04-08 18:36:08
 * @Copyright: 2024 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.condition.field.value;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;

import cn.featherfly.common.repository.mapping.PropertyMapping;

/**
 * SetValueIsNullOrIsNotNullExpressionImpl.
 *
 * @author zhongj
 */
public class SetValueIsNullOrIsNotNullExpressionImpl implements SetValueIsNullOrIsNotNullExpression {

    private Function<Boolean, PropertyMapping<?>> getPropertyMapping;

    private BiConsumer<Boolean, PropertyMapping<?>> setValue;

    private Consumer<Boolean> setValue0;

    /**
     * Instantiates a new sets the value is null or is not null expression impl.
     *
     * @param setValue the set value
     */
    public SetValueIsNullOrIsNotNullExpressionImpl(Consumer<Boolean> setValue) {
        super();
        setValue0 = setValue;
    }

    /**
     * Instantiates a new sets the value is null or is not null expression impl.
     *
     * @param getPropertyMapping the get property mapping
     * @param setValue           the set value
     */
    public SetValueIsNullOrIsNotNullExpressionImpl(Function<Boolean, PropertyMapping<?>> getPropertyMapping,
        BiConsumer<Boolean, PropertyMapping<?>> setValue) {
        super();
        this.getPropertyMapping = getPropertyMapping;
        this.setValue = setValue;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void value(Boolean value) {
        if (setValue0 != null) {
            setValue0.accept(value);
        } else {
            setValue.accept(value, getPropertyMapping.apply(value));
        }
    }
}
