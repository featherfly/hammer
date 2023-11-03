
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2023-11-13 18:44:13
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.condition.field.value;

import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Predicate;

import cn.featherfly.common.function.ThreeArgusConsumer;
import cn.featherfly.common.repository.mapping.PropertyMapping;

/**
 * set number expression implements.
 *
 * @author zhongj
 * @param <N> the generic type
 */
public class SetNumberExpressionImpl<N extends Number> extends SetValueExpressionImpl<N>
        implements SetNumberExpression<N> {

    /**
     * Instantiates a new sets the number expression impl.
     *
     * @param ignoreStrategy the ignore strategy
     * @param setValue       the set value
     */
    public SetNumberExpressionImpl(Predicate<?> ignoreStrategy, BiConsumer<N, Predicate<N>> setValue) {
        super(ignoreStrategy, setValue);
    }

    /**
     * Instantiates a new sets the number expression impl.
     *
     * @param propertyMapping the property mapping
     * @param ignoreStrategy  the ignore strategy
     * @param setValue        the set value
     */
    public SetNumberExpressionImpl(Function<N, PropertyMapping<?>> propertyMapping, Predicate<?> ignoreStrategy,
            ThreeArgusConsumer<N, Predicate<N>, PropertyMapping<?>> setValue) {
        super(propertyMapping, ignoreStrategy, setValue);
    }

}