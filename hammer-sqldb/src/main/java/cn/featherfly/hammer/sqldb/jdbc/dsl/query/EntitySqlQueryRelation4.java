
package cn.featherfly.hammer.sqldb.jdbc.dsl.query;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

import cn.featherfly.common.db.mapping.JdbcClassMapping;
import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.common.lang.function.SerializableFunction;
import cn.featherfly.common.lang.function.SerializableFunction2;
import cn.featherfly.common.lang.function.SerializableFunction3;
import cn.featherfly.common.repository.builder.AliasManager;
import cn.featherfly.common.structure.page.Page;
import cn.featherfly.hammer.dsl.query.type.EntityQueryConditionGroupExpression;
import cn.featherfly.hammer.dsl.query.type.EntityQueryConditionGroupLogicExpression;
import cn.featherfly.hammer.dsl.query.type.EntityQueryEntityProperties;
import cn.featherfly.hammer.dsl.query.type.EntityQueryRelation4;
import cn.featherfly.hammer.dsl.query.type.EntityQueryRelationEntity4;
import cn.featherfly.hammer.expression.condition.ConditionGroupConfig;
import cn.featherfly.hammer.expression.query.type.EntityQueryLimitExecutor;
import cn.featherfly.hammer.expression.query.type.EntityQueryRelationEntityExpression5;
import cn.featherfly.hammer.expression.query.type.EntityQueryRelationExpression5;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;

/**
 * @author zhongj
 */
public class EntitySqlQueryRelation4<E, R1, R2, R3, R4> extends AbstractEntitySqlQueryRelation<E, R3, R4> implements
        EntitySqlQuery<E>, EntityQueryRelation4<E, R1, R2, R3, R4>, EntityQueryRelationEntity4<E, R1, R2, R3, R4> {

    /**
     * @param sqlQueryEntityProperties
     * @param aliasManager
     * @param factory
     * @param sqlPageFactory
     * @param conditionTypeClassMapping
     * @param conditionTableAlias
     * @param conditionTableColumn
     * @param joinTypeClassMapping
     * @param joinTableColumn
     * @param ignorePolicy
     */
    public EntitySqlQueryRelation4(EntitySqlQueryEntityProperties<E> sqlQueryEntityProperties,
            AliasManager aliasManager, JdbcMappingFactory factory, SqlPageFactory sqlPageFactory,
            JdbcClassMapping<E> conditionTypeClassMapping, String conditionTableAlias, String conditionTableColumn,
            JdbcClassMapping<R3> joinTypeClassMapping, String joinTableColumn, Predicate<Object> ignorePolicy) {
        super(sqlQueryEntityProperties, aliasManager, factory, sqlPageFactory, conditionTypeClassMapping,
                conditionTableAlias, conditionTableColumn, joinTypeClassMapping, joinTableColumn, ignorePolicy);
    }

    /**
     * @param sqlQueryEntityProperties
     * @param aliasManager
     * @param factory
     * @param sqlPageFactory
     * @param conditionTypeClassMapping
     * @param conditionTableAlias
     * @param conditionTableColumn
     * @param joinTypeClassMapping
     * @param joinTableColumn
     * @param fetchProperty
     * @param ignorePolicy
     */
    public EntitySqlQueryRelation4(EntitySqlQueryEntityProperties<E> sqlQueryEntityProperties,
            AliasManager aliasManager, JdbcMappingFactory factory, SqlPageFactory sqlPageFactory,
            JdbcClassMapping<E> conditionTypeClassMapping, String conditionTableAlias, String conditionTableColumn,
            JdbcClassMapping<R3> joinTypeClassMapping, String joinTableColumn, String fetchProperty,
            Predicate<Object> ignorePolicy) {
        super(sqlQueryEntityProperties, aliasManager, factory, sqlPageFactory, conditionTypeClassMapping,
                conditionTableAlias, conditionTableColumn, joinTypeClassMapping, joinTableColumn, fetchProperty,
                ignorePolicy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <RE extends EntityQueryRelationEntityExpression5<E, R1, R2, R3, R4, R5, EntityQueryEntityProperties<E>, QR, EntityQueryConditionGroupExpression<E>, EntityQueryConditionGroupLogicExpression<E>>,
            QR extends EntityQueryRelationExpression5<E, R1, R2, R3, R4, R5, EntityQueryEntityProperties<E>, EntityQueryConditionGroupExpression<E>, EntityQueryConditionGroupLogicExpression<E>>,
            R5> RE join(SerializableFunction<E, R5> propertyName) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <RE extends EntityQueryRelationEntityExpression5<E, R1, R2, R3, R4, R5, EntityQueryEntityProperties<E>, QR, EntityQueryConditionGroupExpression<E>, EntityQueryConditionGroupLogicExpression<E>>,
            QR extends EntityQueryRelationExpression5<E, R1, R2, R3, R4, R5, EntityQueryEntityProperties<E>, EntityQueryConditionGroupExpression<E>, EntityQueryConditionGroupLogicExpression<E>>,
            R5> RE join(SerializableFunction2<R5, E> propertyName) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <RE extends EntityQueryRelationEntityExpression5<E, R1, R2, R3, R4, E, EntityQueryEntityProperties<E>, QR, EntityQueryConditionGroupExpression<E>, EntityQueryConditionGroupLogicExpression<E>>,
            QR extends EntityQueryRelationExpression5<E, R1, R2, R3, R4, E, EntityQueryEntityProperties<E>, EntityQueryConditionGroupExpression<E>, EntityQueryConditionGroupLogicExpression<E>>> RE join(
                    SerializableFunction3<E, E> propertyName) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQueryConditionGroupExpression<E> where() {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQueryConditionGroupExpression<E> where(
            Consumer<ConditionGroupConfig<EntityQueryConditionGroupExpression<E>>> consumer) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<E> list() {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long count() {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQueryLimitExecutor<E> limit(Integer limit) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQueryLimitExecutor<E> limit(Integer offset, Integer limit) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQueryLimitExecutor<E> limit(Page page) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQueryRelationEntity4<E, R1, R2, R3, R4> fetch() {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <RE extends EntityQueryRelationEntityExpression5<E, R1, R2, R3, R4, R5, EntityQueryEntityProperties<E>, QR, EntityQueryConditionGroupExpression<E>, EntityQueryConditionGroupLogicExpression<E>>,
            QR extends EntityQueryRelationExpression5<E, R1, R2, R3, R4, R5, EntityQueryEntityProperties<E>, EntityQueryConditionGroupExpression<E>, EntityQueryConditionGroupLogicExpression<E>>,
            R5> RE join1(SerializableFunction<R1, R5> propertyName) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <RE extends EntityQueryRelationEntityExpression5<E, R1, R2, R3, R4, R5, EntityQueryEntityProperties<E>, QR, EntityQueryConditionGroupExpression<E>, EntityQueryConditionGroupLogicExpression<E>>,
            QR extends EntityQueryRelationExpression5<E, R1, R2, R3, R4, R5, EntityQueryEntityProperties<E>, EntityQueryConditionGroupExpression<E>, EntityQueryConditionGroupLogicExpression<E>>,
            R5> RE join1(SerializableFunction2<R5, R1> propertyName) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <RE extends EntityQueryRelationEntityExpression5<E, R1, R2, R3, R4, R1, EntityQueryEntityProperties<E>, QR, EntityQueryConditionGroupExpression<E>, EntityQueryConditionGroupLogicExpression<E>>,
            QR extends EntityQueryRelationExpression5<E, R1, R2, R3, R4, R1, EntityQueryEntityProperties<E>, EntityQueryConditionGroupExpression<E>, EntityQueryConditionGroupLogicExpression<E>>> RE join1(
                    SerializableFunction3<R1, R1> propertyName) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <RE extends EntityQueryRelationEntityExpression5<E, R1, R2, R3, R4, R5, EntityQueryEntityProperties<E>, QR, EntityQueryConditionGroupExpression<E>, EntityQueryConditionGroupLogicExpression<E>>,
            QR extends EntityQueryRelationExpression5<E, R1, R2, R3, R4, R5, EntityQueryEntityProperties<E>, EntityQueryConditionGroupExpression<E>, EntityQueryConditionGroupLogicExpression<E>>,
            R5> RE join2(SerializableFunction<R2, R5> propertyName) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <RE extends EntityQueryRelationEntityExpression5<E, R1, R2, R3, R4, R5, EntityQueryEntityProperties<E>, QR, EntityQueryConditionGroupExpression<E>, EntityQueryConditionGroupLogicExpression<E>>,
            QR extends EntityQueryRelationExpression5<E, R1, R2, R3, R4, R5, EntityQueryEntityProperties<E>, EntityQueryConditionGroupExpression<E>, EntityQueryConditionGroupLogicExpression<E>>,
            R5> RE join2(SerializableFunction2<R5, R2> propertyName) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <RE extends EntityQueryRelationEntityExpression5<E, R1, R2, R3, R4, R2, EntityQueryEntityProperties<E>, QR, EntityQueryConditionGroupExpression<E>, EntityQueryConditionGroupLogicExpression<E>>,
            QR extends EntityQueryRelationExpression5<E, R1, R2, R3, R4, R2, EntityQueryEntityProperties<E>, EntityQueryConditionGroupExpression<E>, EntityQueryConditionGroupLogicExpression<E>>> RE join2(
                    SerializableFunction3<R2, R2> propertyName) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <RE extends EntityQueryRelationEntityExpression5<E, R1, R2, R3, R4, R5, EntityQueryEntityProperties<E>, QR, EntityQueryConditionGroupExpression<E>, EntityQueryConditionGroupLogicExpression<E>>,
            QR extends EntityQueryRelationExpression5<E, R1, R2, R3, R4, R5, EntityQueryEntityProperties<E>, EntityQueryConditionGroupExpression<E>, EntityQueryConditionGroupLogicExpression<E>>,
            R5> RE join3(SerializableFunction<R3, R5> propertyName) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <RE extends EntityQueryRelationEntityExpression5<E, R1, R2, R3, R4, R5, EntityQueryEntityProperties<E>, QR, EntityQueryConditionGroupExpression<E>, EntityQueryConditionGroupLogicExpression<E>>,
            QR extends EntityQueryRelationExpression5<E, R1, R2, R3, R4, R5, EntityQueryEntityProperties<E>, EntityQueryConditionGroupExpression<E>, EntityQueryConditionGroupLogicExpression<E>>,
            R5> RE join3(SerializableFunction2<R5, R3> propertyName) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <RE extends EntityQueryRelationEntityExpression5<E, R1, R2, R3, R4, R3, EntityQueryEntityProperties<E>, QR, EntityQueryConditionGroupExpression<E>, EntityQueryConditionGroupLogicExpression<E>>,
            QR extends EntityQueryRelationExpression5<E, R1, R2, R3, R4, R3, EntityQueryEntityProperties<E>, EntityQueryConditionGroupExpression<E>, EntityQueryConditionGroupLogicExpression<E>>> RE join3(
                    SerializableFunction3<R3, R3> propertyName) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <RE extends EntityQueryRelationEntityExpression5<E, R1, R2, R3, R4, R5, EntityQueryEntityProperties<E>, QR, EntityQueryConditionGroupExpression<E>, EntityQueryConditionGroupLogicExpression<E>>,
            QR extends EntityQueryRelationExpression5<E, R1, R2, R3, R4, R5, EntityQueryEntityProperties<E>, EntityQueryConditionGroupExpression<E>, EntityQueryConditionGroupLogicExpression<E>>,
            R5> RE join4(SerializableFunction<R4, R5> propertyName) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <RE extends EntityQueryRelationEntityExpression5<E, R1, R2, R3, R4, R5, EntityQueryEntityProperties<E>, QR, EntityQueryConditionGroupExpression<E>, EntityQueryConditionGroupLogicExpression<E>>,
            QR extends EntityQueryRelationExpression5<E, R1, R2, R3, R4, R5, EntityQueryEntityProperties<E>, EntityQueryConditionGroupExpression<E>, EntityQueryConditionGroupLogicExpression<E>>,
            R5> RE join4(SerializableFunction2<R5, R4> propertyName) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <RE extends EntityQueryRelationEntityExpression5<E, R1, R2, R3, R4, R4, EntityQueryEntityProperties<E>, QR, EntityQueryConditionGroupExpression<E>, EntityQueryConditionGroupLogicExpression<E>>,
            QR extends EntityQueryRelationExpression5<E, R1, R2, R3, R4, R4, EntityQueryEntityProperties<E>, EntityQueryConditionGroupExpression<E>, EntityQueryConditionGroupLogicExpression<E>>> RE join4(
                    SerializableFunction3<R4, R4> propertyName) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

}
