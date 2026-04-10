
package cn.featherfly.hammer.dsl.repository.query.relation;

import java.io.Serializable;
import java.util.Map;

import cn.featherfly.data.query.LimitAwareQuery1;
import cn.featherfly.data.query.QueryMapperSetter1;
import cn.featherfly.hammer.dsl.repository.RepositoryJoin;
import cn.featherfly.hammer.dsl.repository.RepositoryOnExpression4;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroup4F;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroupLogic4F;
import cn.featherfly.hammer.dsl.repository.query.sort.RepositoryQuerySortedExpression4F;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryExpression4;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryRelateExpression;
import cn.featherfly.hammer.expression.repository.query.RepositoryQuerySortExpression4;

/**
 * The Interface RepositoryQueryRelate3RRR.
 *
 * @author zhongj
 */
public interface RepositoryQueryRelate3 extends RepositoryQueryRelateExpression<RepositoryQueryRelatedFetched3F>,
    RepositoryQueryExpression4<RepositoryQueryConditionsGroup4F, RepositoryQueryConditionsGroupLogic4F,
        RepositoryQuerySortExpression4<RepositoryQuerySortedExpression4F, LimitAwareQuery1<Map<String, Serializable>>>,
        RepositoryQuerySortedExpression4F, LimitAwareQuery1<Map<String, Serializable>>>,
    RepositoryJoin<RepositoryOnExpression4<RepositoryQueryRelate4>, RepositoryQueryRelate4>, QueryMapperSetter1 {

}
