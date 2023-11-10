
package cn.featherfly.hammer.sqldb.jdbc.dsl.repository;

import cn.featherfly.common.db.builder.dml.basic.SqlDeleteFromBasicBuilder;
import cn.featherfly.common.db.builder.dml.basic.SqlSelectJoinOnBasicBuilder;
import cn.featherfly.common.db.metadata.DatabaseMetadata;
import cn.featherfly.common.exception.NotImplementedException;
import cn.featherfly.common.repository.builder.AliasManager;
import cn.featherfly.hammer.config.dsl.DeleteConfig;
import cn.featherfly.hammer.sqldb.jdbc.Jdbc;

/**
 * abstract repository sql delete relation.
 *
 * @author zhongj
 */
public class RepositorySqlDeleteRelation
    extends RepositorySqlRelation<RepositorySqlDeleteRelation, SqlDeleteFromBasicBuilder> {

    private SqlDeleteFromBasicBuilder deleteBuilder;

    /**
     * Instantiates a new abstract sql query entity properties.
     *
     * @param jdbc         the jdbc
     * @param aliasManager aliasManager
     * @param metadata     the metadata
     * @param queryConfig  the query config
     */
    public RepositorySqlDeleteRelation(Jdbc jdbc, AliasManager aliasManager, DatabaseMetadata metadata,
        DeleteConfig queryConfig) {
        super(jdbc, aliasManager, metadata, queryConfig);
    }

    // ****************************************************************************************************************
    //	protected method
    // ****************************************************************************************************************

    @Override
    protected SqlSelectJoinOnBasicBuilder join0(String sourceTableAlias, String sourceColumn, String joinTable,
        String joinTableAlias, String joinTableColumn) {
        // IMPLSOON delete还未实现join
        throw new NotImplementedException();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected SqlSelectJoinOnBasicBuilder join0(String joinTable, String joinTableAlias, String onSql) {
        // IMPLSOON delete还未实现join
        throw new NotImplementedException();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void initBuilder(RepositoryRelation erm) {
        deleteBuilder = new SqlDeleteFromBasicBuilder(jdbc.getDialect(), erm.getRepository(), erm.getRepositoryAlias());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SqlDeleteFromBasicBuilder getBuilder() {
        return deleteBuilder;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public DeleteConfig getConfig() {
        return (DeleteConfig) conditionConfig;
    }

    // ********************************************************************
    //  private method
    // ********************************************************************

}
