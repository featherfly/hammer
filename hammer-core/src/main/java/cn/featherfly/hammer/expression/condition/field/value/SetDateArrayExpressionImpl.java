
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2023-09-21 17:46:21
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.condition.field.value;

import java.util.Date;
import java.util.function.Function;
import java.util.function.Predicate;

import cn.featherfly.common.function.ThreeArgusConsumer;
import cn.featherfly.common.repository.mapping.PropertyMapping;

/**
 * set Date array expression implements.
 *
 * @author zhongj
 * @param <D> the date type
 */
public class SetDateArrayExpressionImpl<D extends Date> extends SetArrayExpressionImpl<D>
        implements SetDateArrayExpression<D> {

    /**
     * Instantiates a new condition entity expression date and array property
     * expression impl.
     *
     * @param getPropertyMapping      the get property mapping
     * @param ignoreStrategy          the ignore strategy
     * @param setValue                the set value
     * @param getArrayPropertyMapping the get array property mapping
     * @param ignoreArrayStrategy     the ignore array strategy
     * @param setArrayValue           the set array value
     */
    public SetDateArrayExpressionImpl(Function<D, PropertyMapping<?>> getPropertyMapping, Predicate<?> ignoreStrategy,
            ThreeArgusConsumer<D, Predicate<D>, PropertyMapping<?>> setValue,
            Function<D[], PropertyMapping<?>> getArrayPropertyMapping, Predicate<D[]> ignoreArrayStrategy,
            ThreeArgusConsumer<D[], Predicate<D[]>, PropertyMapping<?>> setArrayValue) {
        super(getPropertyMapping, ignoreStrategy, setValue, getArrayPropertyMapping, ignoreArrayStrategy,
                setArrayValue);
    }

}
