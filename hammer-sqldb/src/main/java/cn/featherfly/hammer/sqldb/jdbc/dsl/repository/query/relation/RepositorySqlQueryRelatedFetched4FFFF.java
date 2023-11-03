
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2024-04-04 18:25:04
 * @Copyright: 2024 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.jdbc.dsl.repository.query.relation;

import cn.featherfly.hammer.dsl.repository.query.relation.RepositoryQueryOnExpression5;
import cn.featherfly.hammer.dsl.repository.query.relation.RepositoryQueryRelate5FFFFR;
import cn.featherfly.hammer.dsl.repository.query.relation.RepositoryQueryRelatedFetched4FFFF;
import cn.featherfly.hammer.dsl.repository.query.relation.RepositoryQueryRelatedFetched5FFFFF;
import cn.featherfly.hammer.sqldb.jdbc.dsl.repository.query.AbstractRepositorySqlQuery5;
import cn.featherfly.hammer.sqldb.jdbc.dsl.repository.query.AbstractRepositorySqlQuery5FFFFF;

/**
 * The Class RepositorySqlQueryRelatedFetched4FFFF.
 *
 * @author zhongj
 */
public class RepositorySqlQueryRelatedFetched4FFFF extends
    AbstractRepositorySqlQuery5FFFFF<RepositoryQueryRelatedFetched4FFFF> implements RepositoryQueryRelatedFetched4FFFF {

    /**
     * Instantiates a new repository sql query related fetched 4 FFFF.
     *
     * @param repositorySqlQueryFetch the repository sql query fetch
     */
    public RepositorySqlQueryRelatedFetched4FFFF(AbstractRepositorySqlQuery5<?, ?, ?, ?, ?> repositorySqlQueryFetch) {
        super(repositorySqlQueryFetch);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected RepositoryQueryRelatedFetched4FFFF createFetched() {
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryQueryOnExpression5<RepositoryQueryRelate5FFFFR, RepositoryQueryRelatedFetched5FFFFF> join(
        String repository) {
        //        Timer timer = Timer.start();
        //        Timer timer2 = Timer.start();
        //        // YUFEI_TEST 测试代码，后续删除
        //        RepositoryQueryRelate5FFFFR r = new RepositorySqlQueryRelate5FFFFR(queryRelation, sqlPageFactory);
        //        System.out.println(Strings.format("new query relate use time {}", timer2.stop()));
        //        RepositoryQueryOnExpression5<RepositoryQueryRelate5FFFFR,
        //            RepositoryQueryRelatedFetched5FFFFF> on = new RepositorySqlQueryOn5<>(r, queryRelation, repository,
        //                relate -> ( //
        //                (RepositorySqlQueryRelate5FFFFR) relate).setIdName());
        //        System.out.println(Strings.format("join use time {}", timer.stop()));
        //        return on;
        return new RepositorySqlQueryOn5<>(new RepositorySqlQueryRelate5FFFFR(queryRelation, sqlPageFactory),
            queryRelation, repository, relate -> ((RepositorySqlQueryRelate5FFFFR) relate).setIdName());
    }

}
