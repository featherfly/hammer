
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2023-09-21 17:46:21
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.condition.field.value;

import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Predicate;

import cn.featherfly.common.function.ThreeArgusConsumer;
import cn.featherfly.common.repository.mapping.PropertyMapping;

/**
 * set enum expression implements.
 *
 * @author zhongj
 * @param <E> the generic type
 */
public class SetEnumExpressionImpl<E extends Enum<E>> extends SetValueExpressionImpl<E>
        implements SetEnumExpression<E> {

    /**
     * Instantiates a new sets the enum expression impl.
     *
     * @param ignoreStrategy the ignore strategy
     * @param setValue       the set value
     */
    public SetEnumExpressionImpl(Predicate<?> ignoreStrategy, BiConsumer<E, Predicate<E>> setValue) {
        super(ignoreStrategy, setValue);
    }

    /**
     * Instantiates a new condition entity expression enum property expression
     * impl.
     *
     * @param propertyMapping the property mapping
     * @param ignoreStrategy  the ignore strategy
     * @param setValue        the set value
     */
    public SetEnumExpressionImpl(Function<E, PropertyMapping<?>> propertyMapping, Predicate<?> ignoreStrategy,
            ThreeArgusConsumer<E, Predicate<E>, PropertyMapping<?>> setValue) {
        super(propertyMapping, ignoreStrategy, setValue);
    }

}