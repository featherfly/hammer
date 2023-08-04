//
//package cn.featherfly.hammer.sqldb.jdbc.dsl.entity.query.relation;
//
//import cn.featherfly.common.db.builder.dml.basic.SqlSelectBasicBuilder;
//import cn.featherfly.common.db.mapping.JdbcClassMapping;
//import cn.featherfly.common.db.mapping.JdbcPropertyMapping;
//import cn.featherfly.common.lang.Lang;
//import cn.featherfly.hammer.sqldb.SqldbHammerException;
//
///**
// * The Class EntitySqlQueryRelationImpl.
// *
// * @author zhongj
// * @param <R1> the join type1
// * @param <R2> the join type2
// * @param <RS> the return type
// */
//public class EntitySqlQueryRelationImpl<R1, R2, RS> extends AbstractEntitySqlQueryRelation<R1, R2, RS> {
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
//    public EntitySqlQueryRelationImpl(SqlSelectBasicBuilder selectBuilder,
//            JdbcClassMapping<R1> conditionTypeClassMapping, String conditionTableAlias, String conditionTableColumn,
//            JdbcClassMapping<R2> joinTypeClassMapping, String joinTableColumn, String joinTableAlias,
//            String fetchProperty) {
//        super(selectBuilder, conditionTypeClassMapping, conditionTableAlias, conditionTableColumn, joinTypeClassMapping,
//                joinTableColumn, joinTableAlias, fetchProperty);
//    }
//
//    /**
//     * Fetch 0.
//     */
//    @Override
//    public void fetch() {
//        if (Lang.isEmpty(fetchProperty)) {
//            // ENHANCE 后续细化描述
//            throw new SqldbHammerException("can not fetch because there is no relation for find type");
//        }
//        for (JdbcPropertyMapping pm : joinTypeClassMapping.getPropertyMappings()) {
//            if (pm.isPrimaryKey()) {
//                continue; // join表的主键不需要，因为在关联的表中就有外键存在
//            }
//            switch (pm.getMode()) {
//                case EMBEDDED:
//                    for (JdbcPropertyMapping spm : pm.getPropertyMappings()) {
//                        selectJoinOnBasicBuilder.addColumn(spm.getRepositoryFieldName(),
//                                fetchProperty + "." + spm.getPropertyFullName());
//                    }
//                    break;
//                case MANY_TO_ONE:
//                    for (JdbcPropertyMapping spm : pm.getPropertyMappings()) {
//                        selectJoinOnBasicBuilder.addColumn(pm.getRepositoryFieldName(),
//                                fetchProperty + "." + spm.getPropertyFullName());
//                    }
//                    break;
//                default:
//                    selectJoinOnBasicBuilder.addColumn(pm.getRepositoryFieldName(),
//                            fetchProperty + "." + pm.getPropertyFullName());
//            }
//        }
//    }
//}
