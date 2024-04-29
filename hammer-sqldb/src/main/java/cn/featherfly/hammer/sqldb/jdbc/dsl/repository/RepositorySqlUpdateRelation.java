
package cn.featherfly.hammer.sqldb.jdbc.dsl.repository;

import java.util.function.Supplier;

import cn.featherfly.common.db.builder.dml.basic.SqlJoinOnBasicBuilder2;
import cn.featherfly.common.db.builder.dml.basic.SqlJoinOnBuilder;
import cn.featherfly.common.db.builder.dml.basic.SqlUpdateSetBasicBuilder;
import cn.featherfly.common.db.metadata.DatabaseMetadata;
import cn.featherfly.common.lang.AssertIllegalArgument;
import cn.featherfly.common.repository.builder.AliasManager;
import cn.featherfly.hammer.config.dsl.UpdateConfig;
import cn.featherfly.hammer.expression.condition.Expression;
import cn.featherfly.hammer.sqldb.jdbc.Jdbc;

/**
 * abstract repository sql update relation.
 *
 * @author zhongj
 */
public class RepositorySqlUpdateRelation
    extends RepositorySqlRelation<RepositorySqlUpdateRelation, SqlUpdateSetBasicBuilder> {

    private SqlUpdateSetBasicBuilder updateBuilder;

    //    /**
    //     * Instantiates a new abstract sql query entity properties.
    //     *
    //     * @param jdbc         the jdbc
    //     * @param aliasManager aliasManager
    //     * @param ignoreStrategy the ignore strategy
    //     */
    //    public EntitySqlUpdateRelation(Jdbc jdbc, AliasManager aliasManager, Predicate<?> ignoreStrategy) {
    //        this(jdbc, aliasManager, ignoreStrategy, IgnoreStrategy.NONE);
    //    }

    /**
     * Instantiates a new abstract sql query entity properties.
     *
     * @param jdbc         the jdbc
     * @param aliasManager aliasManager
     * @param metadata     the metadata
     * @param queryConfig  the query config
     */
    public RepositorySqlUpdateRelation(Jdbc jdbc, AliasManager aliasManager, DatabaseMetadata metadata,
        UpdateConfig queryConfig) {
        super(jdbc, aliasManager, metadata, queryConfig);
    }

    // ****************************************************************************************************************
    //  public method
    // ****************************************************************************************************************

    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public RepositorySqlUpdateRelation join(int sourceIndex, String sourceField, String joinRepository,
    //        String joinRepositoryAlias, String joinField) {
    //        AssertIllegalArgument.isNotNull(sourceField, "sourceField");
    //        AssertIllegalArgument.isNotNull(joinRepository, "joinRepository");
    //        AssertIllegalArgument.isNotNull(joinField, "joinField");
    //        RepositoryRelation erm = getRepositoryRelation(sourceIndex);
    //
    //        addFilterable(sourceIndex, sourceField, joinRepository, joinRepositoryAlias, joinField);
    //
    //        RepositoryRelation jerm = getRepositoryRelation(index - 1);
    //
    //        getBuilder().join(new SqlJoinOnBasicBuilder(jdbc.getDialect(), jerm.getRepository(), jerm.getRepositoryAlias(),
    //            joinRepositoryAlias, erm.getRepositoryAlias(), sourceField));
    //
    //        return this;
    //    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositorySqlUpdateRelation join(String joinRepository, Supplier<Expression> onExpression) {
        AssertIllegalArgument.isNotNull(joinRepository, "joinRepository");
        addFilterable(joinRepository);
        RepositoryRelation jerm = getRepositoryRelation(index - 1);

        updateBuilder.join(new SqlJoinOnBasicBuilder2(jdbc.getDialect(), jerm.getRepository(),
            jerm.getRepositoryAlias(), onExpression.get().expression()));
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SqlUpdateSetBasicBuilder getBuilder() {
        return updateBuilder;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public UpdateConfig getConfig() {
        return (UpdateConfig) conditionConfig;
    }

    // ****************************************************************************************************************
    //	protected method
    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    protected RepositorySqlUpdateRelation join(SqlJoinOnBuilder joinOnBuilder) {
        getBuilder().join(joinOnBuilder);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void initBuilder(RepositoryRelation erm) {
        updateBuilder = new SqlUpdateSetBasicBuilder(jdbc.getDialect(), erm.getRepository(), erm.getRepositoryAlias(),
            getConfig().getIgnoreStrategy()::test);
    }

    // ********************************************************************
    //  private method
    // ********************************************************************

}
