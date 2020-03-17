
package cn.featherfly.hammer.dsl.query;

import cn.featherfly.hammer.expression.query.TypeQueryWithExpression;

/**
 * <p>
 * dsl for query data
 * </p>
 *
 * @author zhongj
 */
public interface TypeQueryWith extends
        TypeQueryWithExpression<TypeQueryWith, TypeQueryWithEntity, RepositoryTypeQueryConditionGroupExpression, RepositoryTypeQueryConditionGroupLogicExpression> {
}
