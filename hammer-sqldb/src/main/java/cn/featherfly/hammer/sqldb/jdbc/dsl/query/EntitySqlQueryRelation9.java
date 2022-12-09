
package cn.featherfly.hammer.sqldb.jdbc.dsl.query;

import java.util.function.Predicate;

import cn.featherfly.common.db.mapping.JdbcClassMapping;
import cn.featherfly.hammer.dsl.query.type.EntityQueryRelation9;
import cn.featherfly.hammer.dsl.query.type.EntityQueryRelationEntity9;

/**
 * @author zhongj
 */
public class EntitySqlQueryRelation9<E, R1, R2, R3, R4, R5, R6, R7, R8, R9, J1, J2>
        extends AbstractEntitySqlQueryRelation<E, J1, J2>
        implements EntitySqlQuery<E>, EntityQueryRelation9<E, R1, R2, R3, R4, R5, R6, R7, R8, R9>,
        EntityQueryRelationEntity9<E, R1, R2, R3, R4, R5, R6, R7, R8, R9> {

    /**
     * @param sqlQueryEntityProperties
     * @param conditionTypeClassMapping
     * @param conditionTableAlias
     * @param conditionTableColumn
     * @param joinTypeClassMapping
     * @param joinTableColumn
     * @param fetchProperty
     * @param ignorePolicy
     */
    public EntitySqlQueryRelation9(EntitySqlQueryEntityProperties<E> sqlQueryEntityProperties,
            JdbcClassMapping<J1> conditionTypeClassMapping, String conditionTableAlias, String conditionTableColumn,
            JdbcClassMapping<J2> joinTypeClassMapping, String joinTableColumn, String fetchProperty,
            Predicate<Object> ignorePolicy) {
        super(sqlQueryEntityProperties, conditionTypeClassMapping, conditionTableAlias, conditionTableColumn,
                joinTypeClassMapping, joinTableColumn, fetchProperty, ignorePolicy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQueryRelationEntity9<E, R1, R2, R3, R4, R5, R6, R7, R8, R9> fetch() {
        fetch0();
        return this;
    }

}
