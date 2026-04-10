
package cn.featherfly.hammer.dsl.repository.query.relation;

import java.io.Serializable;
import java.util.Map;

import cn.featherfly.data.query.LimitAwareQuery1;
import cn.featherfly.data.query.QueryMapperSetter1;
import cn.featherfly.hammer.dsl.repository.RepositoryJoin;
import cn.featherfly.hammer.dsl.repository.RepositoryOnExpression3;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroup3F;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroupLogic3F;
import cn.featherfly.hammer.dsl.repository.query.sort.RepositoryQuerySortedExpression3F;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryExpression3;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryRelateExpression;
import cn.featherfly.hammer.expression.repository.query.RepositoryQuerySortExpression3;

/**
 * The Interface RepositoryQueryRelate2RR.
 *
 * @author zhongj
 */
public interface RepositoryQueryRelate2 extends RepositoryQueryRelateExpression<RepositoryQueryRelatedFetched2F>,
    RepositoryQueryExpression3<RepositoryQueryConditionsGroup3F, RepositoryQueryConditionsGroupLogic3F,
        RepositoryQuerySortExpression3<RepositoryQuerySortedExpression3F, LimitAwareQuery1<Map<String, Serializable>>>,
        RepositoryQuerySortedExpression3F, LimitAwareQuery1<Map<String, Serializable>>>,
    RepositoryJoin<RepositoryOnExpression3<RepositoryQueryRelate3>, RepositoryQueryRelate3>, QueryMapperSetter1 {

}
