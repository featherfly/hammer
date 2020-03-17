
package cn.featherfly.hammer.dsl.query;

import cn.featherfly.hammer.expression.query.TypeQueryEntityExpression;

/**
 * <p>
 * dsl for query data
 * </p>
 *
 * @author zhongj
 */
public interface TypeQueryEntity extends
        TypeQueryEntityExpression<TypeQueryEntityProperties, TypeQueryWith, TypeQueryWithEntity, TypeQueryConditionGroupExpression, TypeQueryConditionGroupLogicExpression, RepositoryTypeQueryConditionGroupExpression, RepositoryTypeQueryConditionGroupLogicExpression> {
}
