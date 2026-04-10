/*
 * All rights Reserved, Designed By zhongj
 * @Title: EntitySqlQueryRelate1R.java
 * @Package cn.featherfly.hammer.sqldb.jdbc.dsl.entity.query.relation
 * @Description: todo (用一句话描述该文件做什么)
 * @author: zhongj
 * @date: 2024年9月26日 下午5:51:29
 * @version V1.0
 * @Copyright: 2024 www.featherfly.cn Inc. All rights reserved.
 */

package cn.featherfly.hammer.sqldb.dsl.repository.query.relation;

import java.io.Serializable;
import java.util.Map;

import cn.featherfly.common.function.FoConsumer;
import cn.featherfly.common.function.FoFunction;
import cn.featherfly.common.repository.Repository;
import cn.featherfly.common.structure.page.Limit;
import cn.featherfly.data.query.LimitAwareQuery1;
import cn.featherfly.hammer.dsl.repository.RepositoryOnExpression4;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroup4F;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroupLogic4F;
import cn.featherfly.hammer.dsl.repository.query.relation.RepositoryQueryRelate3;
import cn.featherfly.hammer.dsl.repository.query.relation.RepositoryQueryRelate4;
import cn.featherfly.hammer.dsl.repository.query.relation.RepositoryQueryRelatedFetched3F;
import cn.featherfly.hammer.dsl.repository.query.sort.RepositoryQuerySortedExpression4F;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.repository.condition.field.RepositoryFieldOnlyExpression;
import cn.featherfly.hammer.expression.repository.query.RepositoryQuerySortExpression4;
import cn.featherfly.hammer.expression.repository.query.sort.RepositorySortExpression;
import cn.featherfly.hammer.expression.repository.query.sort.RepositorySortedExpression;
import cn.featherfly.hammer.sqldb.dsl.repository.RepositorySqlQueryRelation;
import cn.featherfly.hammer.sqldb.dsl.repository.query.AbstractRepositorySqlQuery4;
import cn.featherfly.hammer.sqldb.dsl.repository.query.RepositorySqlQueryExpression3F;
import cn.featherfly.hammer.sqldb.dsl.repository.query.RepositorySqlQueryExpression4F;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;

/**
 * The Class RepositorySqlQueryRelate3.
 *
 * @author zhongj
 */
public class RepositorySqlQueryRelate3 extends
    AbstractRepositorySqlQuery4<RepositoryQueryRelatedFetched3F, RepositoryQueryConditionsGroup4F,
        RepositoryQueryConditionsGroupLogic4F,
        RepositoryQuerySortExpression4<RepositoryQuerySortedExpression4F, LimitAwareQuery1<Map<String, Serializable>>>,
        RepositoryQuerySortedExpression4F, LimitAwareQuery1<Map<String, Serializable>>>
    implements RepositoryQueryRelate3 {

    /**
     * Instantiates a new repository sql query relate 3 RRR.
     *
     * @param queryRelation the query relation
     * @param sqlPageFactory the sql page factory
     */
    public RepositorySqlQueryRelate3(RepositorySqlQueryRelation queryRelation, SqlPageFactory sqlPageFactory) {
        super(queryRelation, sqlPageFactory);
    }

    /**
     * Instantiates a new repository sql query relate 3 RRR.
     *
     * @param abstractRepositorySqlQuery the abstract repository sql query
     */
    protected RepositorySqlQueryRelate3(AbstractRepositorySqlQuery4<?, ?, ?, ?, ?, ?> abstractRepositorySqlQuery) {
        super(abstractRepositorySqlQuery);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected RepositoryQueryRelatedFetched3F createFetched() {
        return new RepositorySqlQueryRelatedFetched3F(this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryQueryConditionsGroup4F where() {
        return new RepositorySqlQueryExpression4F(queryRelation, sqlPageFactory);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryQueryConditionsGroupLogic4F where(
        FoFunction<RepositoryFieldOnlyExpression, RepositoryFieldOnlyExpression, RepositoryFieldOnlyExpression,
            RepositoryFieldOnlyExpression, LogicExpression<?, ?>> repositoriesCondtionFuntion) {
        return where(new RepositorySqlQueryExpression4F(queryRelation, sqlPageFactory), repositoriesCondtionFuntion);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryQuerySortExpression4<RepositoryQuerySortedExpression4F,
        LimitAwareQuery1<Map<String, Serializable>>> sort() {
        return new RepositorySqlQueryExpression4F(queryRelation, sqlPageFactory).sort();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <S1 extends RepositorySortedExpression<S1>, S2 extends RepositorySortedExpression<S2>,
        S3 extends RepositorySortedExpression<S3>,
        S4 extends RepositorySortedExpression<S4>> RepositoryQuerySortedExpression4F sort(
            FoConsumer<RepositorySortExpression<S1>, RepositorySortExpression<S2>, RepositorySortExpression<S3>,
                RepositorySortExpression<S4>> repositorySortExpresions) {
        return new RepositorySqlQueryExpression4F(queryRelation, sqlPageFactory).sort(repositorySortExpresions);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryOnExpression4<RepositoryQueryRelate4> join(Repository repository) {
        return new RepositorySqlQueryOn4<>(new RepositorySqlQueryRelate4(queryRelation, sqlPageFactory), queryRelation,
            repository, relate -> ((RepositorySqlQueryRelate4) relate).setIdName());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LimitAwareQuery1<Map<String, Serializable>> limit(Limit limit) {
        return new RepositorySqlQueryExpression3F(queryRelation, sqlPageFactory).limit(limit);
    }

}
