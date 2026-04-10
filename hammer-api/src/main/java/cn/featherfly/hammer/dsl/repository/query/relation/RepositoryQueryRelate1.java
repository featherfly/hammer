
package cn.featherfly.hammer.dsl.repository.query.relation;

import java.io.Serializable;
import java.util.Map;

import cn.featherfly.data.query.LimitAwareQuery1;
import cn.featherfly.data.query.QueryMapperSetter1;
import cn.featherfly.hammer.dsl.repository.RepositoryJoin;
import cn.featherfly.hammer.dsl.repository.RepositoryOnExpression2;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQuery2;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroup2F;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroupLogic2F;
import cn.featherfly.hammer.dsl.repository.query.sort.RepositoryQuerySortedExpression2F;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryRelateExpression;
import cn.featherfly.hammer.expression.repository.query.RepositoryQuerySortExpression2;

/**
 * The Interface EntityQueryRelate1R.
 *
 * @author zhongj
 */
public interface RepositoryQueryRelate1 extends RepositoryQueryRelateExpression<RepositoryQueryRelatedFetched1F>,
    RepositoryQuery2<RepositoryQueryConditionsGroup2F, RepositoryQueryConditionsGroupLogic2F,
        RepositoryQuerySortExpression2<RepositoryQuerySortedExpression2F, LimitAwareQuery1<Map<String, Serializable>>>,
        RepositoryQuerySortedExpression2F, LimitAwareQuery1<Map<String, Serializable>>>,
    RepositoryJoin<RepositoryOnExpression2<RepositoryQueryRelate2>, RepositoryQueryRelate2>, QueryMapperSetter1 {

}
