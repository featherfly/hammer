
package cn.featherfly.hammer.sqldb.dsl.entity;

import java.util.function.Supplier;

import cn.featherfly.common.db.builder.dml.basic.SqlJoinOnBasicBuilder2;
import cn.featherfly.common.db.builder.dml.basic.SqlUpdateSetBasicBuilder;
import cn.featherfly.common.db.dialect.Join;
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
     * @param jdbc the jdbc
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
    public <T> EntitySqlUpdateRelation join(Join join, JdbcClassMapping<T> joinClassMapping,
        Supplier<Expression> onExpression) {
        AssertIllegalArgument.isNotNull(joinClassMapping, "joinClassMapping");
        addFilterable(joinClassMapping);
        EntityRelation<?> jerm = getEntityRelation(index - 1);
        updateBuilder.join(new SqlJoinOnBasicBuilder2(jdbc.getDialect(), join, joinClassMapping.getRepositoryName(),
            jerm.getTableAlias(), onExpression.get().expression()));
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntitySqlUpdateRelation join(Join join, int sourceIndex, String propertyName,
        JdbcClassMapping<?> joinClassMapping, String joinPropertyName, boolean returnType) {
        // IMPLSOON update还未实现此join方法
        throw new NotImplementedException();
    }

    // ****************************************************************************************************************
    //	protected method
    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    protected void initBuilder(EntityRelation<?> erm) {
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
