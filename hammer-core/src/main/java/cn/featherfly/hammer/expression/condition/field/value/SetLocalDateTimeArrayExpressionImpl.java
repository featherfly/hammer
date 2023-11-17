
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2023-09-21 17:46:21
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.condition.field.value;

import java.time.LocalDateTime;
import java.util.function.Function;
import java.util.function.Predicate;

import cn.featherfly.common.function.ThreeArgusConsumer;
import cn.featherfly.common.repository.mapping.PropertyMapping;

/**
 * set LocalDateTime array expression implements.
 *
 * @author zhongj
 */
public class SetLocalDateTimeArrayExpressionImpl extends SetArrayExpressionImpl<LocalDateTime>
        implements SetLocalDateTimeArrayExpression {

    /**
     * Instantiates a new condition entity expression local date time and array
     * property expression impl.
     *
     * @param getPropertyMapping      the get property mapping
     * @param ignoreStrategy          the ignore strategy
     * @param setValue                the set value
     * @param getArrayPropertyMapping the get array property mapping
     * @param ignoreArrayStrategy     the ignore array strategy
     * @param setArrayValue           the set array value
     */
    public SetLocalDateTimeArrayExpressionImpl(Function<LocalDateTime, PropertyMapping<?>> getPropertyMapping,
            Predicate<?> ignoreStrategy,
            ThreeArgusConsumer<LocalDateTime, Predicate<LocalDateTime>, PropertyMapping<?>> setValue,
            Function<LocalDateTime[], PropertyMapping<?>> getArrayPropertyMapping,
            Predicate<LocalDateTime[]> ignoreArrayStrategy,
            ThreeArgusConsumer<LocalDateTime[], Predicate<LocalDateTime[]>, PropertyMapping<?>> setArrayValue) {
        super(getPropertyMapping, ignoreStrategy, setValue, getArrayPropertyMapping, ignoreArrayStrategy,
                setArrayValue);
    }

}
