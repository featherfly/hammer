
package cn.featherfly.hammer.sqldb.jdbc.dsl.query;

import java.util.function.Predicate;

import cn.featherfly.common.db.mapping.JdbcClassMapping;
import cn.featherfly.common.lang.function.SerializableFunction;
import cn.featherfly.common.lang.function.SerializableFunction2;
import cn.featherfly.common.lang.function.SerializableFunction3;
import cn.featherfly.hammer.dsl.query.type.EntityQueryConditionGroupExpression;
import cn.featherfly.hammer.dsl.query.type.EntityQueryConditionGroupLogicExpression;
import cn.featherfly.hammer.dsl.query.type.EntityQueryEntityProperties;
import cn.featherfly.hammer.dsl.query.type.EntityQueryRelation7;
import cn.featherfly.hammer.dsl.query.type.EntityQueryRelationEntity7;
import cn.featherfly.hammer.expression.query.type.EntityQueryRelationEntityExpression8;
import cn.featherfly.hammer.expression.query.type.EntityQueryRelationExpression8;

/**
 * The Class EntitySqlQueryRelation7.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <R1> the generic type
 * @param <R2> the generic type
 * @param <R3> the generic type
 * @param <R4> the generic type
 * @param <R5> the generic type
 * @param <R6> the generic type
 * @param <R7> the generic type
 * @param <J1> the generic type
 * @param <J2> the generic type
 */
public class EntitySqlQueryRelation7<E, R1, R2, R3, R4, R5, R6, R7, J1, J2>
        extends AbstractEntitySqlQueryRelation<E, J1, J2> implements EntitySqlQuery<E>,
        EntityQueryRelation7<E, R1, R2, R3, R4, R5, R6, R7>, EntityQueryRelationEntity7<E, R1, R2, R3, R4, R5, R6, R7> {

    /**
     * Instantiates a new entity sql query relation 7.
     *
     * @param sqlQueryEntityProperties  the sql query entity properties
     * @param conditionTypeClassMapping the condition type class mapping
     * @param conditionTableAlias       the condition table alias
     * @param conditionTableColumn      the condition table column
     * @param joinTypeClassMapping      the join type class mapping
     * @param joinTableColumn           the join table column
     * @param fetchProperty             the fetch property
     * @param ignorePolicy              the ignore policy
     */
    public EntitySqlQueryRelation7(EntitySqlQueryEntityProperties<E> sqlQueryEntityProperties,
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
    public <RE extends EntityQueryRelationEntityExpression8<E, R1, R2, R3, R4, R5, R6, R7, R8, EntityQueryEntityProperties<E>, QR, EntityQueryConditionGroupExpression<E>, EntityQueryConditionGroupLogicExpression<E>>,
            QR extends EntityQueryRelationExpression8<E, R1, R2, R3, R4, R5, R6, R7, R8, EntityQueryEntityProperties<E>, EntityQueryConditionGroupExpression<E>, EntityQueryConditionGroupLogicExpression<E>>,
            R8> RE join(SerializableFunction<E, R8> propertyName) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <RE extends EntityQueryRelationEntityExpression8<E, R1, R2, R3, R4, R5, R6, R7, R8, EntityQueryEntityProperties<E>, QR, EntityQueryConditionGroupExpression<E>, EntityQueryConditionGroupLogicExpression<E>>,
            QR extends EntityQueryRelationExpression8<E, R1, R2, R3, R4, R5, R6, R7, R8, EntityQueryEntityProperties<E>, EntityQueryConditionGroupExpression<E>, EntityQueryConditionGroupLogicExpression<E>>,
            R8> RE join(SerializableFunction2<R8, E> propertyName) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <RE extends EntityQueryRelationEntityExpression8<E, R1, R2, R3, R4, R5, R6, R7, E, EntityQueryEntityProperties<E>, QR, EntityQueryConditionGroupExpression<E>, EntityQueryConditionGroupLogicExpression<E>>,
            QR extends EntityQueryRelationExpression8<E, R1, R2, R3, R4, R5, R6, R7, E, EntityQueryEntityProperties<E>, EntityQueryConditionGroupExpression<E>, EntityQueryConditionGroupLogicExpression<E>>> RE join(
                    SerializableFunction3<E, E> propertyName) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <RE extends EntityQueryRelationEntityExpression8<E, R1, R2, R3, R4, R5, R6, R7, R8, EntityQueryEntityProperties<E>, QR, EntityQueryConditionGroupExpression<E>, EntityQueryConditionGroupLogicExpression<E>>,
            QR extends EntityQueryRelationExpression8<E, R1, R2, R3, R4, R5, R6, R7, R8, EntityQueryEntityProperties<E>, EntityQueryConditionGroupExpression<E>, EntityQueryConditionGroupLogicExpression<E>>,
            R8> RE join1(SerializableFunction<R1, R8> propertyName) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <RE extends EntityQueryRelationEntityExpression8<E, R1, R2, R3, R4, R5, R6, R7, R8, EntityQueryEntityProperties<E>, QR, EntityQueryConditionGroupExpression<E>, EntityQueryConditionGroupLogicExpression<E>>,
            QR extends EntityQueryRelationExpression8<E, R1, R2, R3, R4, R5, R6, R7, R8, EntityQueryEntityProperties<E>, EntityQueryConditionGroupExpression<E>, EntityQueryConditionGroupLogicExpression<E>>,
            R8> RE join1(SerializableFunction2<R8, R1> propertyName) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <RE extends EntityQueryRelationEntityExpression8<E, R1, R2, R3, R4, R5, R6, R7, R1, EntityQueryEntityProperties<E>, QR, EntityQueryConditionGroupExpression<E>, EntityQueryConditionGroupLogicExpression<E>>,
            QR extends EntityQueryRelationExpression8<E, R1, R2, R3, R4, R5, R6, R7, R1, EntityQueryEntityProperties<E>, EntityQueryConditionGroupExpression<E>, EntityQueryConditionGroupLogicExpression<E>>> RE join1(
                    SerializableFunction3<R1, R1> propertyName) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <RE extends EntityQueryRelationEntityExpression8<E, R1, R2, R3, R4, R5, R6, R7, R8, EntityQueryEntityProperties<E>, QR, EntityQueryConditionGroupExpression<E>, EntityQueryConditionGroupLogicExpression<E>>,
            QR extends EntityQueryRelationExpression8<E, R1, R2, R3, R4, R5, R6, R7, R8, EntityQueryEntityProperties<E>, EntityQueryConditionGroupExpression<E>, EntityQueryConditionGroupLogicExpression<E>>,
            R8> RE join2(SerializableFunction<R2, R8> propertyName) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <RE extends EntityQueryRelationEntityExpression8<E, R1, R2, R3, R4, R5, R6, R7, R8, EntityQueryEntityProperties<E>, QR, EntityQueryConditionGroupExpression<E>, EntityQueryConditionGroupLogicExpression<E>>,
            QR extends EntityQueryRelationExpression8<E, R1, R2, R3, R4, R5, R6, R7, R8, EntityQueryEntityProperties<E>, EntityQueryConditionGroupExpression<E>, EntityQueryConditionGroupLogicExpression<E>>,
            R8> RE join2(SerializableFunction2<R8, R2> propertyName) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <RE extends EntityQueryRelationEntityExpression8<E, R1, R2, R3, R4, R5, R6, R7, R2, EntityQueryEntityProperties<E>, QR, EntityQueryConditionGroupExpression<E>, EntityQueryConditionGroupLogicExpression<E>>,
            QR extends EntityQueryRelationExpression8<E, R1, R2, R3, R4, R5, R6, R7, R2, EntityQueryEntityProperties<E>, EntityQueryConditionGroupExpression<E>, EntityQueryConditionGroupLogicExpression<E>>> RE join2(
                    SerializableFunction3<R2, R2> propertyName) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <RE extends EntityQueryRelationEntityExpression8<E, R1, R2, R3, R4, R5, R6, R7, R8, EntityQueryEntityProperties<E>, QR, EntityQueryConditionGroupExpression<E>, EntityQueryConditionGroupLogicExpression<E>>,
            QR extends EntityQueryRelationExpression8<E, R1, R2, R3, R4, R5, R6, R7, R8, EntityQueryEntityProperties<E>, EntityQueryConditionGroupExpression<E>, EntityQueryConditionGroupLogicExpression<E>>,
            R8> RE join3(SerializableFunction<R3, R8> propertyName) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <RE extends EntityQueryRelationEntityExpression8<E, R1, R2, R3, R4, R5, R6, R7, R8, EntityQueryEntityProperties<E>, QR, EntityQueryConditionGroupExpression<E>, EntityQueryConditionGroupLogicExpression<E>>,
            QR extends EntityQueryRelationExpression8<E, R1, R2, R3, R4, R5, R6, R7, R8, EntityQueryEntityProperties<E>, EntityQueryConditionGroupExpression<E>, EntityQueryConditionGroupLogicExpression<E>>,
            R8> RE join3(SerializableFunction2<R8, R3> propertyName) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <RE extends EntityQueryRelationEntityExpression8<E, R1, R2, R3, R4, R5, R6, R7, R3, EntityQueryEntityProperties<E>, QR, EntityQueryConditionGroupExpression<E>, EntityQueryConditionGroupLogicExpression<E>>,
            QR extends EntityQueryRelationExpression8<E, R1, R2, R3, R4, R5, R6, R7, R3, EntityQueryEntityProperties<E>, EntityQueryConditionGroupExpression<E>, EntityQueryConditionGroupLogicExpression<E>>> RE join3(
                    SerializableFunction3<R3, R3> propertyName) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <RE extends EntityQueryRelationEntityExpression8<E, R1, R2, R3, R4, R5, R6, R7, R8, EntityQueryEntityProperties<E>, QR, EntityQueryConditionGroupExpression<E>, EntityQueryConditionGroupLogicExpression<E>>,
            QR extends EntityQueryRelationExpression8<E, R1, R2, R3, R4, R5, R6, R7, R8, EntityQueryEntityProperties<E>, EntityQueryConditionGroupExpression<E>, EntityQueryConditionGroupLogicExpression<E>>,
            R8> RE join4(SerializableFunction<R4, R8> propertyName) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <RE extends EntityQueryRelationEntityExpression8<E, R1, R2, R3, R4, R5, R6, R7, R8, EntityQueryEntityProperties<E>, QR, EntityQueryConditionGroupExpression<E>, EntityQueryConditionGroupLogicExpression<E>>,
            QR extends EntityQueryRelationExpression8<E, R1, R2, R3, R4, R5, R6, R7, R8, EntityQueryEntityProperties<E>, EntityQueryConditionGroupExpression<E>, EntityQueryConditionGroupLogicExpression<E>>,
            R8> RE join4(SerializableFunction2<R8, R4> propertyName) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <RE extends EntityQueryRelationEntityExpression8<E, R1, R2, R3, R4, R5, R6, R7, R4, EntityQueryEntityProperties<E>, QR, EntityQueryConditionGroupExpression<E>, EntityQueryConditionGroupLogicExpression<E>>,
            QR extends EntityQueryRelationExpression8<E, R1, R2, R3, R4, R5, R6, R7, R4, EntityQueryEntityProperties<E>, EntityQueryConditionGroupExpression<E>, EntityQueryConditionGroupLogicExpression<E>>> RE join4(
                    SerializableFunction3<R4, R4> propertyName) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <RE extends EntityQueryRelationEntityExpression8<E, R1, R2, R3, R4, R5, R6, R7, R8, EntityQueryEntityProperties<E>, QR, EntityQueryConditionGroupExpression<E>, EntityQueryConditionGroupLogicExpression<E>>,
            QR extends EntityQueryRelationExpression8<E, R1, R2, R3, R4, R5, R6, R7, R8, EntityQueryEntityProperties<E>, EntityQueryConditionGroupExpression<E>, EntityQueryConditionGroupLogicExpression<E>>,
            R8> RE join5(SerializableFunction<R5, R8> propertyName) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <RE extends EntityQueryRelationEntityExpression8<E, R1, R2, R3, R4, R5, R6, R7, R8, EntityQueryEntityProperties<E>, QR, EntityQueryConditionGroupExpression<E>, EntityQueryConditionGroupLogicExpression<E>>,
            QR extends EntityQueryRelationExpression8<E, R1, R2, R3, R4, R5, R6, R7, R8, EntityQueryEntityProperties<E>, EntityQueryConditionGroupExpression<E>, EntityQueryConditionGroupLogicExpression<E>>,
            R8> RE join5(SerializableFunction2<R8, R5> propertyName) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <RE extends EntityQueryRelationEntityExpression8<E, R1, R2, R3, R4, R5, R6, R7, R5, EntityQueryEntityProperties<E>, QR, EntityQueryConditionGroupExpression<E>, EntityQueryConditionGroupLogicExpression<E>>,
            QR extends EntityQueryRelationExpression8<E, R1, R2, R3, R4, R5, R6, R7, R5, EntityQueryEntityProperties<E>, EntityQueryConditionGroupExpression<E>, EntityQueryConditionGroupLogicExpression<E>>> RE join5(
                    SerializableFunction3<R5, R5> propertyName) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <RE extends EntityQueryRelationEntityExpression8<E, R1, R2, R3, R4, R5, R6, R7, R8, EntityQueryEntityProperties<E>, QR, EntityQueryConditionGroupExpression<E>, EntityQueryConditionGroupLogicExpression<E>>,
            QR extends EntityQueryRelationExpression8<E, R1, R2, R3, R4, R5, R6, R7, R8, EntityQueryEntityProperties<E>, EntityQueryConditionGroupExpression<E>, EntityQueryConditionGroupLogicExpression<E>>,
            R8> RE join6(SerializableFunction<R6, R8> propertyName) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <RE extends EntityQueryRelationEntityExpression8<E, R1, R2, R3, R4, R5, R6, R7, R8, EntityQueryEntityProperties<E>, QR, EntityQueryConditionGroupExpression<E>, EntityQueryConditionGroupLogicExpression<E>>,
            QR extends EntityQueryRelationExpression8<E, R1, R2, R3, R4, R5, R6, R7, R8, EntityQueryEntityProperties<E>, EntityQueryConditionGroupExpression<E>, EntityQueryConditionGroupLogicExpression<E>>,
            R8> RE join6(SerializableFunction2<R8, R6> propertyName) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <RE extends EntityQueryRelationEntityExpression8<E, R1, R2, R3, R4, R5, R6, R7, R6, EntityQueryEntityProperties<E>, QR, EntityQueryConditionGroupExpression<E>, EntityQueryConditionGroupLogicExpression<E>>,
            QR extends EntityQueryRelationExpression8<E, R1, R2, R3, R4, R5, R6, R7, R6, EntityQueryEntityProperties<E>, EntityQueryConditionGroupExpression<E>, EntityQueryConditionGroupLogicExpression<E>>> RE join6(
                    SerializableFunction3<R6, R6> propertyName) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <RE extends EntityQueryRelationEntityExpression8<E, R1, R2, R3, R4, R5, R6, R7, R8, EntityQueryEntityProperties<E>, QR, EntityQueryConditionGroupExpression<E>, EntityQueryConditionGroupLogicExpression<E>>,
            QR extends EntityQueryRelationExpression8<E, R1, R2, R3, R4, R5, R6, R7, R8, EntityQueryEntityProperties<E>, EntityQueryConditionGroupExpression<E>, EntityQueryConditionGroupLogicExpression<E>>,
            R8> RE join7(SerializableFunction<R7, R8> propertyName) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <RE extends EntityQueryRelationEntityExpression8<E, R1, R2, R3, R4, R5, R6, R7, R8, EntityQueryEntityProperties<E>, QR, EntityQueryConditionGroupExpression<E>, EntityQueryConditionGroupLogicExpression<E>>,
            QR extends EntityQueryRelationExpression8<E, R1, R2, R3, R4, R5, R6, R7, R8, EntityQueryEntityProperties<E>, EntityQueryConditionGroupExpression<E>, EntityQueryConditionGroupLogicExpression<E>>,
            R8> RE join7(SerializableFunction2<R8, R7> propertyName) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <RE extends EntityQueryRelationEntityExpression8<E, R1, R2, R3, R4, R5, R6, R7, R7, EntityQueryEntityProperties<E>, QR, EntityQueryConditionGroupExpression<E>, EntityQueryConditionGroupLogicExpression<E>>,
            QR extends EntityQueryRelationExpression8<E, R1, R2, R3, R4, R5, R6, R7, R7, EntityQueryEntityProperties<E>, EntityQueryConditionGroupExpression<E>, EntityQueryConditionGroupLogicExpression<E>>> RE join7(
                    SerializableFunction3<R7, R7> propertyName) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQueryRelationEntity7<E, R1, R2, R3, R4, R5, R6, R7> fetch() {
        fetch0();
        return this;
    }
}
