
package cn.featherfly.hammer.sqldb.jdbc.dsl.query;

import java.util.function.Predicate;

import cn.featherfly.common.db.mapping.JdbcClassMapping;
import cn.featherfly.common.db.mapping.JdbcPropertyMapping;
import cn.featherfly.common.lang.ClassUtils;
import cn.featherfly.common.lang.LambdaUtils;
import cn.featherfly.common.lang.LambdaUtils.SerializedLambdaInfo;
import cn.featherfly.common.lang.function.SerializableFunction;
import cn.featherfly.common.lang.function.SerializableFunction2;
import cn.featherfly.common.lang.function.SerializableFunction3;
import cn.featherfly.hammer.dsl.query.type.EntityQueryConditionGroupExpression;
import cn.featherfly.hammer.dsl.query.type.EntityQueryConditionGroupLogicExpression;
import cn.featherfly.hammer.dsl.query.type.EntityQueryEntityProperties;
import cn.featherfly.hammer.dsl.query.type.EntityQueryRelation;
import cn.featherfly.hammer.dsl.query.type.EntityQueryRelationEntity;
import cn.featherfly.hammer.expression.query.type.EntityQueryRelationEntityExpression2;
import cn.featherfly.hammer.expression.query.type.EntityQueryRelationExpression2;

/**
 * The Class EntitySqlQueryRelation.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <R1> the generic type
 */
public class EntitySqlQueryRelation<E, R1> extends AbstractEntitySqlQueryRelation<E, E, R1>
        implements EntitySqlQuery<E>, EntityQueryRelation<E, R1>, EntityQueryRelationEntity<E, R1> {

    /**
     * Instantiates a new type sql query with.
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
    public EntitySqlQueryRelation(EntitySqlQueryEntityProperties<E> sqlQueryEntityProperties,
            JdbcClassMapping<E> conditionTypeClassMapping, String conditionTableAlias, String conditionTableColumn,
            JdbcClassMapping<R1> joinTypeClassMapping, String joinTableColumn, String fetchProperty,
            Predicate<Object> ignorePolicy) {
        super(sqlQueryEntityProperties, conditionTypeClassMapping, conditionTableAlias, conditionTableColumn,
                joinTypeClassMapping, joinTableColumn, fetchProperty, ignorePolicy);
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public <RE extends EntityQueryRelationEntityExpression2<E, R1, R2, EntityQueryEntityProperties<E>, QR, EntityQueryConditionGroupExpression<E>, EntityQueryConditionGroupLogicExpression<E>>,
            QR extends EntityQueryRelationExpression2<E, R1, R2, EntityQueryEntityProperties<E>, EntityQueryConditionGroupExpression<E>, EntityQueryConditionGroupLogicExpression<E>>,
            R2> RE join(SerializableFunction<E, R2> propertyName) {

        //        return (RE) new EntitySqlQueryRelation<>(this, classMapping, tableAlias,
        //                classMapping.getPropertyMapping(info.getPropertyName()).getRepositoryFieldName(), joinTypeMapping,
        //                joinTypeMapping.getPrivaryKeyPropertyMappings().get(0).getRepositoryFieldName(),
        //                joinTypeMapping.getRepositoryName(), ignorePolicy);

        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(propertyName);
        JdbcClassMapping<R2> joinTypeMapping = factory.getClassMapping((Class<R2>) info.getPropertyType());
        JdbcPropertyMapping cpm = conditionTypeClassMapping.getPropertyMapping(info.getPropertyName());
        // E(column) fk R(pk)
        return (RE) new EntitySqlQueryRelation2<>(sqlQueryEntityProperties, conditionTypeClassMapping,
                conditionTableAlias, cpm.getRepositoryFieldName(), joinTypeMapping,
                joinTypeMapping.getPrivaryKeyPropertyMappings().get(0).getRepositoryFieldName(), cpm.getPropertyName(),
                ignorePolicy);
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public <RE extends EntityQueryRelationEntityExpression2<E, R1, R2, EntityQueryEntityProperties<E>, QR, EntityQueryConditionGroupExpression<E>, EntityQueryConditionGroupLogicExpression<E>>,
            QR extends EntityQueryRelationExpression2<E, R1, R2, EntityQueryEntityProperties<E>, EntityQueryConditionGroupExpression<E>, EntityQueryConditionGroupLogicExpression<E>>,
            R2> RE join(SerializableFunction2<R2, E> propertyName) {
        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(propertyName);
        JdbcClassMapping<E> joinTypeMapping = factory
                .getClassMapping((Class<E>) ClassUtils.forName(info.getMethodInstanceClassName()));
        JdbcPropertyMapping jpm = joinTypeMapping.getPropertyMapping(info.getPropertyName());
        return (RE) new EntitySqlQueryRelation2<>(sqlQueryEntityProperties, conditionTypeClassMapping,
                conditionTableAlias,
                conditionTypeClassMapping.getPrivaryKeyPropertyMappings().get(0).getRepositoryFieldName(),
                joinTypeMapping, jpm.getRepositoryFieldName(), null, // YUFEI_TODO 后续来考虑是否需要强制获取
                ignorePolicy);
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public <RE extends EntityQueryRelationEntityExpression2<E, R1, E, EntityQueryEntityProperties<E>, QR, EntityQueryConditionGroupExpression<E>, EntityQueryConditionGroupLogicExpression<E>>,
            QR extends EntityQueryRelationExpression2<E, R1, E, EntityQueryEntityProperties<E>, EntityQueryConditionGroupExpression<E>, EntityQueryConditionGroupLogicExpression<E>>> RE join(
                    SerializableFunction3<E, E> propertyName) {
        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(propertyName);
        JdbcClassMapping<E> joinTypeMapping = factory.getClassMapping((Class<E>) info.getPropertyType());
        JdbcPropertyMapping cpm = conditionTypeClassMapping.getPropertyMapping(info.getPropertyName());
        return (RE) new EntitySqlQueryRelation2<>(sqlQueryEntityProperties, conditionTypeClassMapping,
                conditionTableAlias, cpm.getRepositoryFieldName(), joinTypeMapping,
                joinTypeMapping.getPrivaryKeyPropertyMappings().get(0).getRepositoryFieldName(), cpm.getPropertyName(),
                ignorePolicy);
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public <RE extends EntityQueryRelationEntityExpression2<E, R1, R2, EntityQueryEntityProperties<E>, QR, EntityQueryConditionGroupExpression<E>, EntityQueryConditionGroupLogicExpression<E>>,
            QR extends EntityQueryRelationExpression2<E, R1, R2, EntityQueryEntityProperties<E>, EntityQueryConditionGroupExpression<E>, EntityQueryConditionGroupLogicExpression<E>>,
            R2> RE join1(SerializableFunction<R1, R2> propertyName) {
        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(propertyName);
        JdbcClassMapping<R2> joinTypeMapping1 = factory.getClassMapping((Class<R2>) info.getPropertyType());
        JdbcPropertyMapping cpm = joinTypeClassMapping.getPropertyMapping(info.getPropertyName());
        // R1(column) fk R2(pk)
        return (RE) new EntitySqlQueryRelation2<>(sqlQueryEntityProperties, joinTypeClassMapping, joinTableAlias,
                cpm.getRepositoryFieldName(), joinTypeMapping1,
                joinTypeMapping1.getPrivaryKeyPropertyMappings().get(0).getRepositoryFieldName(),
                joinTypeMapping1.getRepositoryName(), ignorePolicy);
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public <RE extends EntityQueryRelationEntityExpression2<E, R1, R2, EntityQueryEntityProperties<E>, QR, EntityQueryConditionGroupExpression<E>, EntityQueryConditionGroupLogicExpression<E>>,
            QR extends EntityQueryRelationExpression2<E, R1, R2, EntityQueryEntityProperties<E>, EntityQueryConditionGroupExpression<E>, EntityQueryConditionGroupLogicExpression<E>>,
            R2> RE join1(SerializableFunction2<R2, R1> propertyName) {
        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(propertyName);
        JdbcClassMapping<R1> joinTypeMapping1 = factory
                .getClassMapping((Class<R1>) ClassUtils.forName(info.getMethodInstanceClassName()));
        JdbcPropertyMapping jpm = joinTypeMapping1.getPropertyMapping(info.getPropertyName());
        // R2(column) fk R1(pk)
        return (RE) new EntitySqlQueryRelation2<>(sqlQueryEntityProperties, joinTypeClassMapping, joinTableAlias,
                joinTypeClassMapping.getPrivaryKeyPropertyMappings().get(0).getRepositoryFieldName(), joinTypeMapping1,
                jpm.getRepositoryFieldName(), null, ignorePolicy);
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public <RE extends EntityQueryRelationEntityExpression2<E, R1, R1, EntityQueryEntityProperties<E>, QR, EntityQueryConditionGroupExpression<E>, EntityQueryConditionGroupLogicExpression<E>>,
            QR extends EntityQueryRelationExpression2<E, R1, R1, EntityQueryEntityProperties<E>, EntityQueryConditionGroupExpression<E>, EntityQueryConditionGroupLogicExpression<E>>> RE join1(
                    SerializableFunction3<R1, R1> propertyName) {
        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(propertyName);
        JdbcPropertyMapping cpm = joinTypeClassMapping.getPropertyMapping(info.getPropertyName());
        return (RE) new EntitySqlQueryRelation2<>(sqlQueryEntityProperties, joinTypeClassMapping, joinTableAlias,
                cpm.getRepositoryFieldName(), joinTypeClassMapping,
                joinTypeClassMapping.getPrivaryKeyPropertyMappings().get(0).getRepositoryFieldName(),
                joinTypeClassMapping.getRepositoryName(), ignorePolicy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQueryRelationEntity<E, R1> fetch() {
        fetch0();
        return this;
    }
}
