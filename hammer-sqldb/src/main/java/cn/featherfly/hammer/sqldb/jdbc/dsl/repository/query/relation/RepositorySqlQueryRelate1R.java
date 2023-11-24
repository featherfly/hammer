/*
 * All rights Reserved, Designed By zhongj
 * @Title: EntitySqlQueryRelate1R.java
 * @Package cn.featherfly.hammer.sqldb.jdbc.dsl.entity.query.relation
 * @Description: todo (用一句话描述该文件做什么)
 * @author: zhongj
 * @date: 2023年9月26日 下午5:51:29
 * @version V1.0
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */

package cn.featherfly.hammer.sqldb.jdbc.dsl.repository.query.relation;

import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;

import com.speedment.common.tuple.Tuple2;

import cn.featherfly.common.db.metadata.DatabaseMetadata;
import cn.featherfly.common.repository.builder.AliasManager;
import cn.featherfly.common.repository.function.RepositoryFunction;
import cn.featherfly.common.repository.mapping.RowMapper;
import cn.featherfly.common.structure.page.Limit;
import cn.featherfly.hammer.config.dsl.QueryConfig;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroup2;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroupLogic2;
import cn.featherfly.hammer.dsl.repository.query.relation.RepositoryQueryRelate1R;
import cn.featherfly.hammer.dsl.repository.query.relation.RepositoryQueryRelate2RR;
import cn.featherfly.hammer.dsl.repository.query.relation.RepositoryQueryRelatedExpression;
import cn.featherfly.hammer.dsl.repository.query.relation.RepositoryQueryRelatedFetched1F;
import cn.featherfly.hammer.dsl.repository.query.relation.RepositoryQueryRelatedFetched2RF;
import cn.featherfly.hammer.expression.query.QueryLimitExecutor;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryExpression2;
import cn.featherfly.hammer.expression.repository.query.RepositoryQuerySortExpression2;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;
import cn.featherfly.hammer.sqldb.jdbc.dsl.repository.RepositorySqlQueryRelation;
import cn.featherfly.hammer.sqldb.jdbc.dsl.repository.query.AbstractRepositorySqlQueryJoinFetch1;

/**
 * The Class RepositorySqlQueryRelate1R.
 *
 * @author zhongj
 */
public class RepositorySqlQueryRelate1R
        //        extends AbstractRepositorySqlQueryFetch<RepositoryQueryRelatedFetched1F, RepositoryQueryRelatedFetched1F>
        extends AbstractRepositorySqlQueryJoinFetch1<RepositoryQueryRelatedFetched1F>
        implements RepositoryQueryRelate1R {

    //    /**
    //     * Instantiates a new repository sql query relate 1 R.
    //     *
    //     * @param parent             the parent
    //     * @param index              the index
    //     * @param repositoryRelation the repository relation
    //     * @param sqlPageFactory     the sql page factory
    //     * @param conditionConfig    the condition config
    //     */
    //    public RepositorySqlQueryRelate1R(AbstractRepositorySqlQueryFetch2 parent, int index,
    //            RepositorySqlQueryRelation repositoryRelation, SqlPageFactory sqlPageFactory,
    //            QueryConditionConfig conditionConfig) {
    //        super(parent, index, repositoryRelation, sqlPageFactory, conditionConfig);
    //    }
    //
    //    /**
    //     * Instantiates a new repository sql query relate 1 R.
    //     *
    //     * @param repositoryRelation the repository relation
    //     * @param index              the index
    //     * @param sqlPageFactory     the sql page factory
    //     * @param conditionConfig    the condition config
    //     * @param selectBuilder      the select builder
    //     */
    //    public RepositorySqlQueryRelate1R(RepositorySqlQueryRelation repositoryRelation, int index,
    //            SqlPageFactory sqlPageFactory, QueryConditionConfig conditionConfig, SqlSelectBasicBuilder selectBuilder) {
    //        super(repositoryRelation, index, sqlPageFactory, conditionConfig, selectBuilder);
    //    }

    /**
     * Instantiates a new repository sql query relate 1 R.
     *
     * @param repositoryRelation the repository relation
     * @param databaseMetadata   the database metadata
     * @param sqlPageFactory     the sql page factory
     * @param aliasManager       the alias manager
     * @param tableName          the table name
     */
    public RepositorySqlQueryRelate1R(RepositorySqlQueryRelation repositoryRelation, DatabaseMetadata databaseMetadata,
            SqlPageFactory sqlPageFactory, AliasManager aliasManager, String tableName) {
        this(repositoryRelation, databaseMetadata, sqlPageFactory, aliasManager, tableName,
                aliasManager.put(tableName));
    }

    /**
     * Instantiates a new repository sql query relate 1 R.
     *
     * @param repositoryRelation the repository relation
     * @param databaseMetadata   the database metadata
     * @param sqlPageFactory     the sql page factory
     * @param aliasManager       the alias manager
     * @param tableName          the table name
     * @param tableAlias         the table alias
     */
    public RepositorySqlQueryRelate1R(RepositorySqlQueryRelation repositoryRelation, DatabaseMetadata databaseMetadata,
            SqlPageFactory sqlPageFactory, AliasManager aliasManager, String tableName, String tableAlias) {
        super(repositoryRelation, 1, databaseMetadata, sqlPageFactory, aliasManager, tableName, tableAlias);
        repositoryRelation.addFilterable(tableName, tableAlias);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryQueryConditionsGroup2<RepositoryQuerySortExpression2<QueryLimitExecutor>,
            QueryLimitExecutor> where() {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryQueryConditionsGroup2<RepositoryQuerySortExpression2<QueryLimitExecutor>,
            QueryLimitExecutor> where(
                    Consumer<RepositoryQueryConditionsGroup2<RepositoryQuerySortExpression2<QueryLimitExecutor>,
                            QueryLimitExecutor>> consumer) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryQuerySortExpression2<QueryLimitExecutor> sort() {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Map<String, Object>> list() {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> List<E> list(RowMapper<E> rowMapper) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> List<E> list(Class<E> type) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryLimitExecutor limit(Limit limit) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryQueryExpression2<
            RepositoryQueryConditionsGroup2<RepositoryQuerySortExpression2<QueryLimitExecutor>, QueryLimitExecutor>,
            RepositoryQueryConditionsGroupLogic2<RepositoryQuerySortExpression2<QueryLimitExecutor>,
                    QueryLimitExecutor>,
            RepositoryQuerySortExpression2<QueryLimitExecutor>, QueryLimitExecutor> configure(
                    Consumer<QueryConfig> configure) {
        configure.accept(repositoryRelation.getConfig());
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryQueryRelatedExpression<RepositoryQueryRelate2RR, RepositoryQueryRelatedFetched2RF> join(
            Consumer<Tuple2<RepositoryFunction, RepositoryFunction>> repositories) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryQueryRelatedExpression<RepositoryQueryRelate2RR, RepositoryQueryRelatedFetched2RF> join(
            Function<Tuple2<String, String>, String> repositories, String repository) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryQueryRelatedExpression<RepositoryQueryRelate2RR, RepositoryQueryRelatedFetched2RF> join(
            BiConsumer<RepositoryFunction, RepositoryFunction> repositories) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryQueryRelatedExpression<RepositoryQueryRelate2RR, RepositoryQueryRelatedFetched2RF> join(
            String repository) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryQueryRelatedExpression<RepositoryQueryRelate2RR, RepositoryQueryRelatedFetched2RF> join2(
            String repository) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }
}
