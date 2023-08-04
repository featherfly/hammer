
package cn.featherfly.hammer.sqldb.jdbc.dsl.entity;

import java.util.function.Predicate;

import cn.featherfly.common.db.builder.dml.basic.SqlUpdateSetBasicBuilder;
import cn.featherfly.common.repository.IgnoreStrategy;
import cn.featherfly.common.repository.builder.AliasManager;
import cn.featherfly.hammer.sqldb.jdbc.Jdbc;

/**
 * abstract entity sql query entity properties.
 *
 * @author zhongj
 */
public class EntitySqlUpdateRelation extends EntitySqlRelation<EntitySqlUpdateRelation, SqlUpdateSetBasicBuilder> {

    private SqlUpdateSetBasicBuilder updateBuilder;

    private Predicate<Object> setIgnoreStrategy;

    /**
     * Instantiates a new abstract sql query entity properties.
     *
     * @param jdbc         the jdbc
     * @param aliasManager aliasManager
     * @param ignoreStrategy the ignore strategy
     */
    public EntitySqlUpdateRelation(Jdbc jdbc, AliasManager aliasManager, Predicate<?> ignoreStrategy) {
        this(jdbc, aliasManager, ignoreStrategy, IgnoreStrategy.NONE);
    }

    /**
     * Instantiates a new abstract sql query entity properties.
     *
     * @param jdbc              the jdbc
     * @param aliasManager      aliasManager
     * @param ignoreStrategy      the ignore strategy
     * @param setIgnoreStrategy the set ignore strategy
     */
    @SuppressWarnings("unchecked")
    public EntitySqlUpdateRelation(Jdbc jdbc, AliasManager aliasManager, Predicate<?> ignoreStrategy,
            Predicate<?> setIgnoreStrategy) {
        super(jdbc, aliasManager, ignoreStrategy);
        this.setIgnoreStrategy = (Predicate<Object>) setIgnoreStrategy;
    }

    // ****************************************************************************************************************
    //	protected method
    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    protected void initBuilder(EntityRelationMapping<?> erm) {
        updateBuilder = new SqlUpdateSetBasicBuilder(jdbc.getDialect(), erm.getClassMapping().getRepositoryName(),
                erm.getTableAlias(), setIgnoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SqlUpdateSetBasicBuilder getBuilder() {
        return updateBuilder;
    }

    /**
     * get setIgnoreStrategy value
     *
     * @return setIgnoreStrategy
     */
    public Predicate<?> getSetIgnoreStrategy() {
        return setIgnoreStrategy;
    }

    // ********************************************************************
    //  private method
    // ********************************************************************

}
