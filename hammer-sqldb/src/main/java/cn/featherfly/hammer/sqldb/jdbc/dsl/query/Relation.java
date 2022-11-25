
package cn.featherfly.hammer.sqldb.jdbc.dsl.query;

import java.util.function.Predicate;

import cn.featherfly.common.db.builder.dml.basic.SqlSelectJoinOnBasicBuilder;
import cn.featherfly.common.db.mapping.JdbcClassMapping;
import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.common.lang.AssertIllegalArgument;
import cn.featherfly.common.repository.builder.AliasManager;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;

/**
 * @author zhongj
 */
public class Relation<R1, R2> {

    /** The condition table alias. */
    protected String conditionTableAlias;

    /** The condition table column. */
    protected String conditionTableColumn;

    /** The join table alias. */
    protected String joinTableAlias;

    /** The join table column. */
    protected String joinTableColumn;

    /** The select join on basic builder. */
    protected SqlSelectJoinOnBasicBuilder selectJoinOnBasicBuilder;

    /** The factory. */
    protected JdbcMappingFactory factory;

    /** The sql page factory. */
    protected SqlPageFactory sqlPageFactory;

    /** The condition type class mapping. */
    protected JdbcClassMapping<R1> conditionTypeClassMapping;

    /** The join type class mapping. */
    protected JdbcClassMapping<R2> joinTypeClassMapping;

    /** The fetch property. */
    protected String fetchProperty;

    /** The fetch property alias. */
    protected String fetchPropertyAlias;

    /** The ignore policy. */
    protected Predicate<Object> ignorePolicy;

    /**
     * Instantiates a new type sql query with.
     *
     * @param sqlQueryEntityProperties  the sql query entity properties
     * @param aliasManager              the alias manager
     * @param factory                   the factory
     * @param sqlPageFactory            the sql page factory
     * @param conditionTypeClassMapping the condition type class mapping
     * @param conditionTableAlias       the condition table alias
     * @param conditionTableColumn      the condition table column
     * @param joinTypeClassMapping      the join type class mapping
     * @param joinTableColumn           the join table column
     * @param fetchProperty             the fetch property
     * @param ignorePolicy              the ignore policy
     */
    public Relation(AliasManager aliasManager, JdbcMappingFactory factory, SqlPageFactory sqlPageFactory,
            JdbcClassMapping<R1> conditionTypeClassMapping, String conditionTableAlias, String conditionTableColumn,
            JdbcClassMapping<R2> joinTypeClassMapping, String joinTableColumn, String fetchProperty,
            String fetchPropertyAlias, Predicate<Object> ignorePolicy) {
        super();
        this.factory = factory;
        this.sqlPageFactory = sqlPageFactory;
        this.conditionTypeClassMapping = conditionTypeClassMapping;
        this.conditionTableAlias = conditionTableAlias;
        this.conditionTableColumn = conditionTableColumn;
        joinTableAlias = aliasManager.put(joinTypeClassMapping.getRepositoryName());
        this.joinTableColumn = joinTableColumn;
        this.joinTypeClassMapping = joinTypeClassMapping;
        this.fetchProperty = fetchProperty;
        this.fetchPropertyAlias = fetchPropertyAlias;
        AssertIllegalArgument.isNotNull(ignorePolicy, "ignorePolicy");
        this.ignorePolicy = ignorePolicy;
    }
}
