//
//package cn.featherfly.hammer.sqldb.jdbc.dsl.entity.query.relation;
//
//import cn.featherfly.common.db.builder.dml.basic.SqlSelectBasicBuilder;
//import cn.featherfly.common.db.builder.dml.basic.SqlSelectJoinOnBasicBuilder;
//import cn.featherfly.common.db.mapping.JdbcClassMapping;
//import cn.featherfly.common.lang.AssertIllegalArgument;
//
///**
// * The Class EntitySqlQueryRelationPart.
// *
// * @author zhongj
// * @param <R1> the join type1
// * @param <R2> the join type2
// * @param <RS> the return type
// */
//public abstract class AbstractEntitySqlQueryRelation<R1, R2, RS> implements EntitySqlQueryRelation2<R1, R2, RS> {
//
//    private SqlSelectBasicBuilder selectBuilder;
//
//    /** The condition table alias. */
//    protected String conditionTableAlias;
//
//    /** The condition table column. */
//    protected String conditionTableColumn;
//
//    /** The join table alias. */
//    protected String joinTableAlias;
//
//    /** The join table column. */
//    protected String joinTableColumn;
//
//    /** The select join on basic builder. */
//    protected SqlSelectJoinOnBasicBuilder selectJoinOnBasicBuilder;
//
//    /** The alias manager. */
//    //    protected AliasManager aliasManager;
//
//    /** The condition type class mapping. */
//    protected JdbcClassMapping<R1> conditionTypeClassMapping;
//
//    /** The join type class mapping. */
//    protected JdbcClassMapping<R2> joinTypeClassMapping;
//
//    /** The fetch property. */
//    protected String fetchProperty;
//
//    //    /**
//    //     * Instantiates a new type sql query with.
//    //     *
//    //     * @param sqlQueryEntityProperties  the sql query entity properties
//    //     * @param conditionTypeClassMapping the condition type class mapping
//    //     * @param conditionTableAlias       the condition table alias
//    //     * @param conditionTableColumn      the condition table column
//    //     * @param joinTypeClassMapping      the join type class mapping
//    //     * @param joinTableColumn           the join table column
//    //     * @param ignoreStrategy              the ignore strategy
//    //     */
//    //    public AbstractEntitySqlQueryRelation(EntitySqlQueryEntityProperties<E> sqlQueryEntityProperties,
//    //            JdbcClassMapping<E> conditionTypeClassMapping, String conditionTableAlias, String conditionTableColumn,
//    //            JdbcClassMapping<R1> joinTypeClassMapping, String joinTableColumn, Predicate<Object> ignoreStrategy) {
//    //        this(sqlQueryEntityProperties, conditionTypeClassMapping, conditionTableAlias, conditionTableColumn,
//    //                joinTypeClassMapping, joinTableColumn, null, ignoreStrategy);
//    //    }
//
//    /**
//     * Instantiates a new type sql query with.
//     *
//     * <pre>
//     * <code>
//     *  select * from user u join userinfo ui on u.id = ui.user_id
//     *  conditionTypeClassMapping&lt;UserInfo&gt;
//     *  joinTypeClassMapping&lt;User&gt;
//     * </code>
//     * </pre>
//     *
//     * @param selectBuilder             the select builder
//     * @param conditionTypeClassMapping the condition type class mapping
//     * @param conditionTableAlias       the condition table alias
//     * @param conditionTableColumn      the condition table column
//     * @param joinTypeClassMapping      the join type class mapping
//     * @param joinTableColumn           the join table column
//     * @param joinTableAlias            the join table alias
//     * @param fetchProperty             the query object fetch property
//     */
//    public AbstractEntitySqlQueryRelation(SqlSelectBasicBuilder selectBuilder,
//            JdbcClassMapping<R1> conditionTypeClassMapping, String conditionTableAlias, String conditionTableColumn,
//            JdbcClassMapping<R2> joinTypeClassMapping, String joinTableColumn, String joinTableAlias,
//            String fetchProperty) {
//        super();
//        AssertIllegalArgument.isNotNull(selectBuilder, "selectBuilder");
//        this.selectBuilder = selectBuilder;
//        this.conditionTypeClassMapping = conditionTypeClassMapping;
//        this.conditionTableAlias = conditionTableAlias;
//        this.conditionTableColumn = conditionTableColumn;
//        //        joinTableAlias = aliasManager.put(joinTypeClassMapping.getRepositoryName());
//        this.joinTableAlias = joinTableAlias;
//        this.joinTableColumn = joinTableColumn;
//        this.joinTypeClassMapping = joinTypeClassMapping;
//        this.fetchProperty = fetchProperty;
//        //        fetchPropertyAlias = aliasManager.put(fetchProperty);
//        on();
//    }
//
//    /**
//     * On.
//     *
//     * @return the entity sql query relation part
//     */
//    public AbstractEntitySqlQueryRelation<R1, R2, RS> on() {
//        selectJoinOnBasicBuilder = selectBuilder.join(conditionTableAlias, conditionTableColumn, joinTypeClassMapping,
//                joinTableAlias, joinTableColumn);
//        return this;
//    }
//}
