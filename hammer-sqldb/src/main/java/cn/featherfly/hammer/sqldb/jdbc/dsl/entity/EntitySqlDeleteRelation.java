
package cn.featherfly.hammer.sqldb.jdbc.dsl.entity;

import java.util.function.Predicate;

import cn.featherfly.common.db.builder.dml.basic.SqlDeleteFromBasicBuilder;
import cn.featherfly.common.repository.builder.AliasManager;
import cn.featherfly.hammer.sqldb.jdbc.Jdbc;

/**
 * abstract entity sql query entity properties.
 *
 * @author zhongj
 */
public class EntitySqlDeleteRelation extends EntitySqlRelation<EntitySqlDeleteRelation, SqlDeleteFromBasicBuilder> {

    private SqlDeleteFromBasicBuilder deleteBuilder;

    /**
     * Instantiates a new abstract sql query entity properties.
     *
     * @param dialect      the dialect
     * @param aliasManager aliasManager
     * @param ignoreStrategy the ignore strategy
     */
    public EntitySqlDeleteRelation(Jdbc jdbc, AliasManager aliasManager, Predicate<?> ignoreStrategy) {
        super(jdbc, aliasManager, ignoreStrategy);
    }

    // ****************************************************************************************************************
    //	protected method
    // ****************************************************************************************************************

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

    // ********************************************************************
    //  private method
    // ********************************************************************

}
