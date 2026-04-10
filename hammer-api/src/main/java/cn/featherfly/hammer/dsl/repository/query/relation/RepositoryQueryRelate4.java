
package cn.featherfly.hammer.dsl.repository.query.relation;

import java.io.Serializable;
import java.util.Map;

import cn.featherfly.data.query.LimitAwareQuery1;
import cn.featherfly.data.query.QueryMapperSetter1;
import cn.featherfly.hammer.dsl.repository.RepositoryJoin;
import cn.featherfly.hammer.dsl.repository.RepositoryOnExpression5;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroup5F;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroupLogic5F;
import cn.featherfly.hammer.dsl.repository.query.sort.RepositoryQuerySortedExpression5F;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryExpression5;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryRelateExpression;
import cn.featherfly.hammer.expression.repository.query.RepositoryQuerySortExpression5;

/**
 * The Interface RepositoryQueryRelate4RRRR.
 *
 * @author zhongj
 */
public interface RepositoryQueryRelate4 extends RepositoryQueryRelateExpression<RepositoryQueryRelatedFetched4F>,
    RepositoryQueryExpression5<RepositoryQueryConditionsGroup5F, RepositoryQueryConditionsGroupLogic5F,
        RepositoryQuerySortExpression5<RepositoryQuerySortedExpression5F, LimitAwareQuery1<Map<String, Serializable>>>,
        RepositoryQuerySortedExpression5F, LimitAwareQuery1<Map<String, Serializable>>>,
    RepositoryJoin<RepositoryOnExpression5<RepositoryQueryRelate5>, RepositoryQueryRelate5>, QueryMapperSetter1 {

}
