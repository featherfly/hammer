
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2023-09-21 17:46:21
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.condition.field.value;

import java.util.Date;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Predicate;

import cn.featherfly.common.function.ThreeArgusConsumer;
import cn.featherfly.common.repository.mapping.PropertyMapping;

/**
 * set Date expression implements.
 *
 * @author zhongj
 * @param <D> the generic type
 */
public class SetDateExpressionImpl<D extends Date> extends SetValueExpressionImpl<D> implements SetDateExpression<D> {

    /**
     * Instantiates a new sets the date expression impl.
     *
     * @param ignoreStrategy the ignore strategy
     * @param setValue       the set value
     */
    public SetDateExpressionImpl(Predicate<?> ignoreStrategy, BiConsumer<D, Predicate<D>> setValue) {
        super(ignoreStrategy, setValue);
    }

    /**
     * Instantiates a new condition entity expression date property expression impl.
     *
     * @param propertyMapping the property mapping
     * @param ignoreStrategy  the ignore strategy
     * @param setValue        the set value
     */
    public SetDateExpressionImpl(Function<D, PropertyMapping<?>> propertyMapping, Predicate<?> ignoreStrategy,
            ThreeArgusConsumer<D, Predicate<D>, PropertyMapping<?>> setValue) {
        super(propertyMapping, ignoreStrategy, setValue);
    }

}