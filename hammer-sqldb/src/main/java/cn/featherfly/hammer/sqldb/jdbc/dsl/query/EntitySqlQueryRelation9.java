//
//package cn.featherfly.hammer.sqldb.jdbc.dsl.query;
//
//import java.util.List;
//
//import org.apache.commons.lang3.NotImplementedException;
//
//import cn.featherfly.common.db.mapping.JdbcClassMapping;
//import cn.featherfly.hammer.dsl.query.type.EntityQueryRelation9;
//import cn.featherfly.hammer.dsl.query.type.EntityQueryRelationEntity9;
//
///**
// * @author zhongj
// */
//public class EntitySqlQueryRelation9<E, R1, R2, R3, R4, R5, R6, R7, R8, R9, J1, J2>
//        extends AbstractEntitySqlQueryRelation<E, J1, J2>
//        implements EntitySqlQuery<E>, EntityQueryRelation9<E, R1, R2, R3, R4, R5, R6, R7, R8, R9>,
//        EntityQueryRelationEntity9<E, R1, R2, R3, R4, R5, R6, R7, R8, R9> {
//
//    /**
//     * Instantiates a new entity sql query relation 9.
//     *
//     * @param sqlQueryEntityProperties  the sql query entity properties
//     * @param conditionTypeClassMapping the condition type class mapping
//     * @param conditionTableAlias       the condition table alias
//     * @param conditionTableColumn      the condition table column
//     * @param joinTypeClassMapping      the join type class mapping
//     * @param joinTableColumn           the join table column
//     * @param fetchProperty             the fetch property
//     * @param relationParts             the relation parts
//     */
//    public EntitySqlQueryRelation9(EntitySqlQueryEntityProperties<E> sqlQueryEntityProperties,
//            JdbcClassMapping<J1> conditionTypeClassMapping, String conditionTableAlias, String conditionTableColumn,
//            JdbcClassMapping<J2> joinTypeClassMapping, String joinTableColumn, String fetchProperty,
//            List<EntitySqlQueryRelationPart<?, ?>> relationParts) {
//        super(sqlQueryEntityProperties, conditionTypeClassMapping, conditionTableAlias, conditionTableColumn,
//                joinTypeClassMapping, joinTableColumn, fetchProperty, relationParts);
//        // IMPLSOON 后续来实现
//        throw new NotImplementedException();
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public EntityQueryRelationEntity9<E, R1, R2, R3, R4, R5, R6, R7, R8, R9> fetch() {
//        fetch0();
//        return this;
//    }
//
//}
