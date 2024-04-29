
package cn.featherfly.hammer.sqldb.jdbc.dsl.repository;

import java.util.function.Supplier;

import cn.featherfly.common.db.builder.dml.basic.SqlDeleteFromBasicBuilder;
import cn.featherfly.common.db.builder.dml.basic.SqlJoinOnBasicBuilder2;
import cn.featherfly.common.db.builder.dml.basic.SqlJoinOnBuilder;
import cn.featherfly.common.db.metadata.DatabaseMetadata;
import cn.featherfly.common.lang.AssertIllegalArgument;
import cn.featherfly.common.repository.builder.AliasManager;
import cn.featherfly.hammer.config.dsl.DeleteConfig;
import cn.featherfly.hammer.expression.condition.Expression;
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
    //  public method
    // ****************************************************************************************************************

    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public RepositorySqlDeleteRelation join(int sourceIndex, String sourceField, String joinRepository,
    //        String joinRepositoryAlias, String joinField) {
    //        AssertIllegalArgument.isNotNull(joinRepository, "joinRepository");
    //        if (Lang.isEmpty(joinField)) {
    //            List<Column> pks = metadata.getTable(joinRepository).getPrimaryColumns();
    //            if (pks.size() == 1) {
    //                joinField = pks.get(0).getName();
    //            } else {
    //                AssertIllegalArgument.isNotNull(joinField, "joinField");
    //            }
    //        }
    //
    //        RepositoryRelation erm = getRepositoryRelation(sourceIndex);
    //
    //        if (Lang.isEmpty(sourceField)) {
    //            List<Column> pks = metadata.getTable(erm.getRepository()).getPrimaryColumns();
    //            if (pks.size() == 1) {
    //                sourceField = pks.get(0).getName();
    //            } else {
    //                AssertIllegalArgument.isNotNull(sourceField, "sourceField");
    //            }
    //        }
    //
    //        addFilterable(sourceIndex, sourceField, joinRepository, joinRepositoryAlias, joinField);
    //
    //        RepositoryRelation jerm = getRepositoryRelation(index - 1);
    //
    //        getBuilder().join(new SqlJoinOnBasicBuilder(jdbc.getDialect(), jerm.getRepository(), jerm.getRepositoryAlias(),
    //            joinField, erm.getRepositoryAlias(), sourceField));
    //
    //        return this;
    //    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositorySqlDeleteRelation join(String joinRepository, Supplier<Expression> onExpression) {
        AssertIllegalArgument.isNotNull(joinRepository, "joinRepository");
        addFilterable(joinRepository);
        RepositoryRelation jerm = getRepositoryRelation(index - 1);

        getBuilder().join(new SqlJoinOnBasicBuilder2(jdbc.getDialect(), jerm.getRepository(), jerm.getRepositoryAlias(),
            onExpression.get().expression()));
        return this;
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

    // ****************************************************************************************************************
    //	protected method
    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    protected RepositorySqlDeleteRelation join(SqlJoinOnBuilder joinOnBuilder) {
        getBuilder().join(joinOnBuilder);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void initBuilder(RepositoryRelation erm) {
        deleteBuilder = new SqlDeleteFromBasicBuilder(jdbc.getDialect(), erm.getRepository(), erm.getRepositoryAlias());
    }

    // ********************************************************************
    //  private method
    // ********************************************************************

}
