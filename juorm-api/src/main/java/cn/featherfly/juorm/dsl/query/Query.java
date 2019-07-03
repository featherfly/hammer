
package cn.featherfly.juorm.dsl.query;

import cn.featherfly.juorm.expression.query.QueryEntity;
import cn.featherfly.juorm.expression.query.QueryEntityProperties;

/**
 * <p>
 * dsl for query
 * </p>
 *
 * @author zhongj
 */
public interface Query<Q extends QueryEntity<Q, QP>,
        QP extends QueryEntityProperties<Q, QP>> extends
        cn.featherfly.juorm.expression.query.Query<Q, QP, QueryConditionGroupExpression, QueryConditionGroupLogicExpression> {
    @Override
    Q find(String repository);
}
