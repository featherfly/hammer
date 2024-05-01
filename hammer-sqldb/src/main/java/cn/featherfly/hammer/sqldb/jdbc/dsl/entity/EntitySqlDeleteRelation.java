
package cn.featherfly.hammer.sqldb.jdbc.dsl.entity;

import java.util.function.Supplier;

import cn.featherfly.common.db.builder.dml.basic.SqlDeleteFromBasicBuilder;
import cn.featherfly.common.db.builder.dml.basic.SqlJoinOnBasicBuilder2;
import cn.featherfly.common.db.builder.dml.basic.SqlSelectJoinOnBasicBuilder;
import cn.featherfly.common.db.mapping.JdbcClassMapping;
import cn.featherfly.common.exception.NotImplementedException;
import cn.featherfly.common.lang.AssertIllegalArgument;
import cn.featherfly.common.repository.builder.AliasManager;
import cn.featherfly.hammer.config.dsl.DeleteConfig;
import cn.featherfly.hammer.expression.condition.Expression;
import cn.featherfly.hammer.sqldb.jdbc.Jdbc;

/**
 * abstract entity sql delete relation.
 *
 * @author zhongj
 */
public class EntitySqlDeleteRelation extends EntitySqlRelation<EntitySqlDeleteRelation, SqlDeleteFromBasicBuilder> {

    private SqlDeleteFromBasicBuilder deleteBuilder;

    /**
     * Instantiates a new abstract sql query entity properties.
     *
     * @param jdbc         the jdbc
     * @param aliasManager aliasManager
     * @param deleteConfig the delete config
     */
    public EntitySqlDeleteRelation(Jdbc jdbc, AliasManager aliasManager, DeleteConfig deleteConfig) {
        super(jdbc, aliasManager, deleteConfig);
        //        enableTableAlias = false;
    }

    // ----------------------------------------------------------------------------------------------------------------
    /**
     * Join.
     *
     * @param <T>              the generic type
     * @param joinClassMapping the join class mapping
     * @param onExpression     the on expression
     * @return the EntitySqlDeleteRelation
     */
    @Override
    public <T> EntitySqlDeleteRelation join(JdbcClassMapping<T> joinClassMapping, Supplier<Expression> onExpression) {
        AssertIllegalArgument.isNotNull(joinClassMapping, "joinClassMapping");
        addFilterable(joinClassMapping);
        EntityRelationMapping<?> jerm = getEntityRelationMapping(index - 1);
        deleteBuilder.join(new SqlJoinOnBasicBuilder2(jdbc.getDialect(), joinClassMapping.getRepositoryName(),
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
        // IMPLSOON delete还未实现join
        throw new NotImplementedException();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void initBuilder(EntityRelationMapping<?> erm) {
        deleteBuilder = new SqlDeleteFromBasicBuilder(jdbc.getDialect(), erm.getClassMapping().getRepositoryName(),
                erm.getTableAlias());
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
