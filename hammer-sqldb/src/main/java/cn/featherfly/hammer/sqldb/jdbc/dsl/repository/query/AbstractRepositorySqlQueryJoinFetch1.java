
package cn.featherfly.hammer.sqldb.jdbc.dsl.repository.query;

import cn.featherfly.common.db.metadata.DatabaseMetadata;
import cn.featherfly.common.repository.builder.AliasManager;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryRelateExpression;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;
import cn.featherfly.hammer.sqldb.jdbc.dsl.repository.RepositorySqlQueryRelation;

/**
 * AbstractRepositorySqlQueryFetch.
 *
 * @author zhongj
 * @param <Q>  the element type
 * @param <Q2> the generic type
 */
public abstract class AbstractRepositorySqlQueryJoinFetch1<Q extends RepositoryQueryRelateExpression<Q>>
        extends AbstractRepositorySqlQueryJoin<Q> implements RepositoryQueryRelateExpression<Q> {

    /**
     * Instantiates a new abstract repository sql query join fetch 1.
     *
     * @param repositorySqlQueryFetch the repository sql query fetch
     */
    protected AbstractRepositorySqlQueryJoinFetch1(AbstractRepositorySqlQueryJoinFetch1<Q> repositorySqlQueryFetch) {
        super(repositorySqlQueryFetch);
    }

    /**
     * Instantiates a new abstract repository sql query join fetch 1.
     *
     * @param repositoryRelation the repository relation
     * @param index              the index
     * @param databaseMetadata   the database metadata
     * @param sqlPageFactory     the sql page factory
     * @param aliasManager       the alias manager
     * @param tableName          the table name
     * @param tableAlias         the table alias
     */
    protected AbstractRepositorySqlQueryJoinFetch1(RepositorySqlQueryRelation repositoryRelation, int index,
            DatabaseMetadata databaseMetadata, SqlPageFactory sqlPageFactory, AliasManager aliasManager,
            String tableName, String tableAlias) {
        super(repositoryRelation, index, databaseMetadata, sqlPageFactory, aliasManager, tableName, tableAlias);
    }
}
