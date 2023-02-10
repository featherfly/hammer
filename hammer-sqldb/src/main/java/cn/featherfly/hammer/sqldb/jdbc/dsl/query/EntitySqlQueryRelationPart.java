
package cn.featherfly.hammer.sqldb.jdbc.dsl.query;

import cn.featherfly.common.db.builder.dml.basic.SqlSelectBasicBuilder;
import cn.featherfly.common.db.builder.dml.basic.SqlSelectJoinOnBasicBuilder;
import cn.featherfly.common.db.mapping.JdbcClassMapping;
import cn.featherfly.common.db.mapping.JdbcPropertyMapping;
import cn.featherfly.common.lang.AssertIllegalArgument;
import cn.featherfly.common.lang.Lang;
import cn.featherfly.hammer.sqldb.SqldbHammerException;

/**
 * The Class EntitySqlQueryRelationPart.
 *
 * @author zhongj
 * @param <R1> the generic type
 * @param <R2> the generic type
 */
public class EntitySqlQueryRelationPart<R1, R2> {

    private SqlSelectBasicBuilder selectBuilder;

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

    /** The alias manager. */
    //    protected AliasManager aliasManager;

    /** The condition type class mapping. */
    protected JdbcClassMapping<R1> conditionTypeClassMapping;

    /** The join type class mapping. */
    protected JdbcClassMapping<R2> joinTypeClassMapping;

    /** The fetch property. */
    protected String fetchProperty;

    //    /**
    //     * Instantiates a new type sql query with.
    //     *
    //     * @param sqlQueryEntityProperties  the sql query entity properties
    //     * @param conditionTypeClassMapping the condition type class mapping
    //     * @param conditionTableAlias       the condition table alias
    //     * @param conditionTableColumn      the condition table column
    //     * @param joinTypeClassMapping      the join type class mapping
    //     * @param joinTableColumn           the join table column
    //     * @param ignorePolicy              the ignore policy
    //     */
    //    public AbstractEntitySqlQueryRelation(EntitySqlQueryEntityProperties<E> sqlQueryEntityProperties,
    //            JdbcClassMapping<E> conditionTypeClassMapping, String conditionTableAlias, String conditionTableColumn,
    //            JdbcClassMapping<R1> joinTypeClassMapping, String joinTableColumn, Predicate<Object> ignorePolicy) {
    //        this(sqlQueryEntityProperties, conditionTypeClassMapping, conditionTableAlias, conditionTableColumn,
    //                joinTypeClassMapping, joinTableColumn, null, ignorePolicy);
    //    }

    /**
     * Instantiates a new type sql query with.
     *
     * <pre>
     * <code>
     *  select * from user u join userinfo ui on u.id = ui.user_id
     *  conditionTypeClassMapping&lt;UserInfo&gt;
     *  joinTypeClassMapping&lt;User&gt;
     * </code>
     * </pre>
     *
     * @param selectBuilder             the select builder
     * @param conditionTypeClassMapping the condition type class mapping
     * @param conditionTableAlias       the condition table alias
     * @param conditionTableColumn      the condition table column
     * @param joinTypeClassMapping      the join type class mapping
     * @param joinTableColumn           the join table column
     * @param joinTableAlias            the join table alias
     * @param fetchProperty             the query object fetch property
     */
    public EntitySqlQueryRelationPart(SqlSelectBasicBuilder selectBuilder,
            JdbcClassMapping<R1> conditionTypeClassMapping, String conditionTableAlias, String conditionTableColumn,
            JdbcClassMapping<R2> joinTypeClassMapping, String joinTableColumn, String joinTableAlias,
            String fetchProperty) {
        super();
        AssertIllegalArgument.isNotNull(selectBuilder, "selectBuilder");
        this.selectBuilder = selectBuilder;
        this.conditionTypeClassMapping = conditionTypeClassMapping;
        this.conditionTableAlias = conditionTableAlias;
        this.conditionTableColumn = conditionTableColumn;
        //        joinTableAlias = aliasManager.put(joinTypeClassMapping.getRepositoryName());
        this.joinTableAlias = joinTableAlias;
        this.joinTableColumn = joinTableColumn;
        this.joinTypeClassMapping = joinTypeClassMapping;
        this.fetchProperty = fetchProperty;
        //        fetchPropertyAlias = aliasManager.put(fetchProperty);
        on();
    }

    /**
     * On.
     *
     * @return the entity sql query relation part
     */
    public EntitySqlQueryRelationPart<R1, R2> on() {
        selectJoinOnBasicBuilder = selectBuilder.join(conditionTableAlias, conditionTableColumn, joinTypeClassMapping,
                joinTableAlias, joinTableColumn);
        return this;
    }

    /**
     * Fetch 0.
     */
    public void fetch() {
        if (Lang.isEmpty(fetchProperty)) {
            // ENHANCE 后续细化描述
            throw new SqldbHammerException("can not fetch because there is no relation for find type");
        }
        for (JdbcPropertyMapping pm : joinTypeClassMapping.getPropertyMappings()) {
            if (pm.isPrimaryKey()) {
                continue; // join表的主键不需要，因为在关联的表中就有外键存在
            }
            switch (pm.getMode()) {
                case EMBEDDED:
                    for (JdbcPropertyMapping spm : pm.getPropertyMappings()) {
                        selectJoinOnBasicBuilder.addColumn(spm.getRepositoryFieldName(),
                                fetchProperty + "." + spm.getPropertyFullName());
                    }
                    break;
                case MANY_TO_ONE:
                    for (JdbcPropertyMapping spm : pm.getPropertyMappings()) {
                        selectJoinOnBasicBuilder.addColumn(pm.getRepositoryFieldName(),
                                fetchProperty + "." + spm.getPropertyFullName());
                    }
                    break;
                default:
                    selectJoinOnBasicBuilder.addColumn(pm.getRepositoryFieldName(),
                            fetchProperty + "." + pm.getPropertyFullName());
            }
        }
    }
}
