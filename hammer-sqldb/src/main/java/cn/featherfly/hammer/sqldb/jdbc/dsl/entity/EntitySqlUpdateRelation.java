
package cn.featherfly.hammer.sqldb.jdbc.dsl.entity;

import java.util.function.Supplier;

import cn.featherfly.common.db.builder.dml.basic.SqlJoinOnBasicBuilder2;
import cn.featherfly.common.db.builder.dml.basic.SqlSelectJoinOnBasicBuilder;
import cn.featherfly.common.db.builder.dml.basic.SqlUpdateSetBasicBuilder;
import cn.featherfly.common.db.mapping.JdbcClassMapping;
import cn.featherfly.common.exception.NotImplementedException;
import cn.featherfly.common.lang.AssertIllegalArgument;
import cn.featherfly.common.repository.builder.AliasManager;
import cn.featherfly.hammer.config.dsl.UpdateConfig;
import cn.featherfly.hammer.expression.condition.Expression;
import cn.featherfly.hammer.sqldb.jdbc.Jdbc;

/**
 * abstract entity sql update relation.
 *
 * @author zhongj
 */
public class EntitySqlUpdateRelation extends EntitySqlRelation<EntitySqlUpdateRelation, SqlUpdateSetBasicBuilder> {

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
     * @param updateConfig the update config
     */
    public EntitySqlUpdateRelation(Jdbc jdbc, AliasManager aliasManager, UpdateConfig updateConfig) {
        super(jdbc, aliasManager, updateConfig);
    }

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> EntitySqlUpdateRelation join(JdbcClassMapping<T> joinClassMapping, Supplier<Expression> onExpression) {
        AssertIllegalArgument.isNotNull(joinClassMapping, "joinClassMapping");
        addFilterable(joinClassMapping);
        EntityRelationMapping<?> jerm = getEntityRelationMapping(index - 1);
        updateBuilder.join(new SqlJoinOnBasicBuilder2(jdbc.getDialect(), joinClassMapping.getRepositoryName(),
            jerm.getTableAlias(), onExpression.get().expression()));
        return this;
    }

    // ****************************************************************************************************************
    //	protected method
    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    protected SqlSelectJoinOnBasicBuilder join0(String tableAlias, String columnName,
        JdbcClassMapping<?> joinClassMapping, String joinTableAlias, String joinTableColumnName) {
        // IMPLSOON update还未实现join
        throw new NotImplementedException();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void initBuilder(EntityRelationMapping<?> erm) {
        updateBuilder = new SqlUpdateSetBasicBuilder(jdbc.getDialect(), erm.getClassMapping().getRepositoryName(),
            erm.getTableAlias(), getConfig().getIgnoreStrategy()::test);
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

    // ********************************************************************
    //  private method
    // ********************************************************************

}
