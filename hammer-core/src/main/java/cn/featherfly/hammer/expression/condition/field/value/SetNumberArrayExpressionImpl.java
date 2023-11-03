
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2023-11-13 18:44:13
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.condition.field.value;

import java.util.function.Function;
import java.util.function.Predicate;

import cn.featherfly.common.function.ThreeArgusConsumer;
import cn.featherfly.common.repository.mapping.PropertyMapping;

/**
 * set number array expression implements.
 *
 * @author zhongj
 * @param <N> the number type
 */
public class SetNumberArrayExpressionImpl<N extends Number> extends SetArrayExpressionImpl<N>
        implements SetNumberArrayExpression<N> {

    /**
     * Instantiates a new condition entity expression number and array property
     * expression impl.
     *
     * @param getPropertyMapping      the get property mapping
     * @param ignoreStrategy          the ignore strategy
     * @param setValue                the set value
     * @param getArrayPropertyMapping the get array property mapping
     * @param ignoreArrayStrategy     the ignore array strategy
     * @param setArrayValue           the set array value
     */
    public SetNumberArrayExpressionImpl(Function<N, PropertyMapping<?>> getPropertyMapping, Predicate<?> ignoreStrategy,
            ThreeArgusConsumer<N, Predicate<N>, PropertyMapping<?>> setValue,
            Function<N[], PropertyMapping<?>> getArrayPropertyMapping, Predicate<N[]> ignoreArrayStrategy,
            ThreeArgusConsumer<N[], Predicate<N[]>, PropertyMapping<?>> setArrayValue) {
        super(getPropertyMapping, ignoreStrategy, setValue, getArrayPropertyMapping, ignoreArrayStrategy,
                setArrayValue);
    }

}
