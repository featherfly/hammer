
package cn.featherfly.hammer.dsl.repository.query.relation;

import java.io.Serializable;
import java.util.Map;

import cn.featherfly.data.query.LimitAwareQuery1;
import cn.featherfly.data.query.QueryMapperSetter1;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroup6F;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroupLogic6F;
import cn.featherfly.hammer.dsl.repository.query.sort.RepositoryQuerySortedExpression6F;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryExpression6;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryRelateExpression;
import cn.featherfly.hammer.expression.repository.query.RepositoryQuerySortExpression6;

/**
 * The Interface RepositoryQueryRelate5RRRRR.
 *
 * @author zhongj
 */
public interface RepositoryQueryRelate5 extends RepositoryQueryRelateExpression<RepositoryQueryRelatedFetched5F>,
    RepositoryQueryExpression6<RepositoryQueryConditionsGroup6F, RepositoryQueryConditionsGroupLogic6F,
        RepositoryQuerySortExpression6<RepositoryQuerySortedExpression6F, LimitAwareQuery1<Map<String, Serializable>>>,
        RepositoryQuerySortedExpression6F, LimitAwareQuery1<Map<String, Serializable>>>,
    QueryMapperSetter1 {

}
