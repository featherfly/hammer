
/*
 * All rights Reserved, Designed By zhongj
 * @Title: ConditionEntityExpressionLongProperty2Proxy.java
 * @Description: ConditionEntityExpressionLongProperty2Proxy
 * @author: zhongj
 * @date: 2023-09-21 17:46:21
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.propery;

import java.util.function.Function;
import java.util.function.Predicate;

import cn.featherfly.common.function.ThreeArgusConsumer;
import cn.featherfly.common.repository.mapping.PropertyMapping;
import cn.featherfly.hammer.expression.entity.condition.ConditionEntityExpressionStringPropertyExpression;

/**
 * The Class ConditionEntityExpressionStringPropertyExpressionImpl.
 *
 * @author zhongj
 */
public class ConditionEntityExpressionStringPropertyExpressionImpl
        extends ConditionEntityExpressionPropertyExpressionImpl<String>
        implements ConditionEntityExpressionStringPropertyExpression {

    /**
     * Instantiates a new condition entity expression string property expression
     * impl.
     *
     * @param propertyMapping the property mapping
     * @param ignoreStrategy  the ignore strategy
     * @param setValue        the set value
     */
    public ConditionEntityExpressionStringPropertyExpressionImpl(Function<String, PropertyMapping<?>> propertyMapping,
            Predicate<?> ignoreStrategy, ThreeArgusConsumer<String, Predicate<String>, PropertyMapping<?>> setValue) {
        super(propertyMapping, ignoreStrategy, setValue);
    }

}
