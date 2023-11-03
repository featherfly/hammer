
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2024-03-04 18:25:04
 * @Copyright: 2024 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.jdbc.dsl.repository.query.relation;

import java.util.List;

import com.speedment.common.tuple.Tuple2;

import cn.featherfly.common.structure.page.PaginationResults;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroup2FF;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroupLogic2FF;
import cn.featherfly.hammer.dsl.repository.query.relation.RepositoryQueryOnExpression2;
import cn.featherfly.hammer.dsl.repository.query.relation.RepositoryQueryRelate2FR;
import cn.featherfly.hammer.dsl.repository.query.relation.RepositoryQueryRelatedFetched1F;
import cn.featherfly.hammer.dsl.repository.query.relation.RepositoryQueryRelatedFetched2FF;
import cn.featherfly.hammer.expression.query.QueryLimitExecutor2;
import cn.featherfly.hammer.expression.repository.query.RepositoryQuerySortExpression2;
import cn.featherfly.hammer.sqldb.jdbc.dsl.repository.query.AbstractRepositorySqlQuery2;
import cn.featherfly.hammer.sqldb.jdbc.dsl.repository.query.RepositorySqlQueryExpression2FF;

/**
 * RepositorySqlQueryRelatedFetched1F.
 *
 * @author zhongj
 */
public class RepositorySqlQueryRelatedFetched1F extends
    AbstractRepositorySqlQuery2<RepositoryQueryRelatedFetched1F, RepositoryQueryConditionsGroup2FF,
        RepositoryQueryConditionsGroupLogic2FF, RepositoryQuerySortExpression2<QueryLimitExecutor2>,
        QueryLimitExecutor2>
    implements RepositoryQueryRelatedFetched1F {

    /**
     * Instantiates a new repository sql query relate 1 F.
     *
     * @param repositorySqlQueryFetch the repository sql query fetch
     */
    public RepositorySqlQueryRelatedFetched1F(AbstractRepositorySqlQuery2<?, ?, ?, ?, ?> repositorySqlQueryFetch) {
        super(repositorySqlQueryFetch);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected RepositoryQueryRelatedFetched1F createFetched() {
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryQueryOnExpression2<RepositoryQueryRelate2FR, RepositoryQueryRelatedFetched2FF> join(
        String repository) {
        return new RepositorySqlQueryOn2<>(new RepositorySqlQueryRelate2FR(queryRelation, sqlPageFactory),
            queryRelation, repository, relate -> ((RepositorySqlQueryRelate2FR) relate).setIdName());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryQueryConditionsGroup2FF where() {
        return new RepositorySqlQueryExpression2FF(queryRelation, sqlPageFactory);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryQuerySortExpression2<QueryLimitExecutor2> sort() {
        return new RepositorySqlQueryExpression2FF(queryRelation, sqlPageFactory).sort();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E1, E2> List<Tuple2<E1, E2>> list(Tuple2<String, String> prefixes, Class<E1> type1, Class<E2> type2) {
        return new RepositorySqlQueryExpression2FF(queryRelation, sqlPageFactory).list(prefixes, type1, type2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E1, E2> Tuple2<E1, E2> single(Tuple2<String, String> prefixes, Class<E1> type1, Class<E2> type2) {
        return new RepositorySqlQueryExpression2FF(queryRelation, sqlPageFactory).single(prefixes, type1, type2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E1, E2> Tuple2<E1, E2> unique(Tuple2<String, String> prefixes, Class<E1> type1, Class<E2> type2) {
        return new RepositorySqlQueryExpression2FF(queryRelation, sqlPageFactory).unique(prefixes, type1, type2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E1, E2> PaginationResults<Tuple2<E1, E2>> pagination(Tuple2<String, String> prefixes, Class<E1> type1,
        Class<E2> type2) {
        return new RepositorySqlQueryExpression2FF(queryRelation, sqlPageFactory).pagination(prefixes, type1, type2);
    }

}
