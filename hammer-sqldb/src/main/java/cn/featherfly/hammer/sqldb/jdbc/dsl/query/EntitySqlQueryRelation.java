
package cn.featherfly.hammer.sqldb.jdbc.dsl.query;

import java.util.ArrayList;

import cn.featherfly.common.db.mapping.JdbcClassMapping;
import cn.featherfly.common.db.mapping.JdbcPropertyMapping;
import cn.featherfly.common.lang.ClassUtils;
import cn.featherfly.common.lang.LambdaUtils;
import cn.featherfly.common.lang.LambdaUtils.SerializedLambdaInfo;
import cn.featherfly.common.lang.function.SerializableFunction;
import cn.featherfly.common.lang.function.SerializableFunction1;
import cn.featherfly.common.lang.function.SerializableFunction2;
import cn.featherfly.hammer.dsl.query.type.EntityQueryConditionGroupExpression;
import cn.featherfly.hammer.dsl.query.type.EntityQueryConditionGroupLogicExpression;
import cn.featherfly.hammer.dsl.query.type.EntityQueryEntityProperties;
import cn.featherfly.hammer.dsl.query.type.EntityQueryRelation;
import cn.featherfly.hammer.dsl.query.type.EntityQueryRelation2;
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
     */
    public EntitySqlQueryRelation(EntitySqlQueryEntityProperties<E> sqlQueryEntityProperties,
            JdbcClassMapping<E> conditionTypeClassMapping, String conditionTableAlias, String conditionTableColumn,
            JdbcClassMapping<R1> joinTypeClassMapping, String joinTableColumn, String fetchProperty) {
        super(sqlQueryEntityProperties, conditionTypeClassMapping, conditionTableAlias, conditionTableColumn,
                joinTypeClassMapping, joinTableColumn, fetchProperty, new ArrayList<>());
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public <RE extends EntityQueryRelationEntityExpression2<E, R1, R2, EntityQueryEntityProperties<E>, QR,
            EntityQueryConditionGroupExpression<E>, EntityQueryConditionGroupLogicExpression<E>>,
            QR extends EntityQueryRelationExpression2<E, R1, R2, EntityQueryEntityProperties<E>,
                    EntityQueryConditionGroupExpression<E>, EntityQueryConditionGroupLogicExpression<E>>,
            R2> RE join(SerializableFunction<E, R2> propertyName) {
        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(propertyName);
        JdbcClassMapping<R2> joinTypeMapping = factory.getClassMapping((Class<R2>) info.getPropertyType());
        JdbcPropertyMapping cpm = relationPart.conditionTypeClassMapping.getPropertyMapping(info.getPropertyName());
        // E(column) fk R(pk)
        EntityQueryRelation2<E, E,
                R2> r = new EntitySqlQueryRelation2<>(sqlQueryEntityProperties, relationPart.conditionTypeClassMapping,
                        relationPart.conditionTableAlias, cpm.getRepositoryFieldName(), joinTypeMapping,
                        joinTypeMapping.getPrivaryKeyPropertyMappings().get(0).getRepositoryFieldName(),
                        cpm.getPropertyName(), relationParts);
        return (RE) r;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public <RE extends EntityQueryRelationEntityExpression2<E, R1, R2, EntityQueryEntityProperties<E>, QR,
            EntityQueryConditionGroupExpression<E>, EntityQueryConditionGroupLogicExpression<E>>,
            QR extends EntityQueryRelationExpression2<E, R1, R2, EntityQueryEntityProperties<E>,
                    EntityQueryConditionGroupExpression<E>, EntityQueryConditionGroupLogicExpression<E>>,
            R2> RE join(SerializableFunction2<R2, E> propertyName) {
        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(propertyName);
        JdbcClassMapping<R2> joinTypeMapping = factory
                .getClassMapping((Class<R2>) ClassUtils.forName(info.getMethodInstanceClassName()));
        JdbcPropertyMapping jpm = joinTypeMapping.getPropertyMapping(info.getPropertyName());
        EntityQueryRelation2<E, E,
                R2> r = new EntitySqlQueryRelation2<>(sqlQueryEntityProperties, relationPart.conditionTypeClassMapping,
                        relationPart.conditionTableAlias,
                        relationPart.conditionTypeClassMapping.getPrivaryKeyPropertyMappings().get(0)
                                .getRepositoryFieldName(),
                        joinTypeMapping, jpm.getRepositoryFieldName(), null,
                        // YUFEI_TODO 后续来根据映射关系看能不能进行处理
                        relationParts);
        return (RE) r;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public <RE extends EntityQueryRelationEntityExpression2<E, R1, E, EntityQueryEntityProperties<E>, QR,
            EntityQueryConditionGroupExpression<E>, EntityQueryConditionGroupLogicExpression<E>>,
            QR extends EntityQueryRelationExpression2<E, R1, E, EntityQueryEntityProperties<E>,
                    EntityQueryConditionGroupExpression<E>, EntityQueryConditionGroupLogicExpression<E>>> RE join(
                            SerializableFunction1<E, E> propertyName) {
        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(propertyName);
        JdbcClassMapping<E> joinTypeMapping = factory.getClassMapping((Class<E>) info.getPropertyType());
        JdbcPropertyMapping cpm = relationPart.conditionTypeClassMapping.getPropertyMapping(info.getPropertyName());
        EntityQueryRelation2<E, E,
                E> r = new EntitySqlQueryRelation2<>(sqlQueryEntityProperties, relationPart.conditionTypeClassMapping,
                        relationPart.conditionTableAlias, cpm.getRepositoryFieldName(), joinTypeMapping,
                        joinTypeMapping.getPrivaryKeyPropertyMappings().get(0).getRepositoryFieldName(),
                        cpm.getPropertyName(), relationParts);
        return (RE) r;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public <RE extends EntityQueryRelationEntityExpression2<E, R1, R2, EntityQueryEntityProperties<E>, QR,
            EntityQueryConditionGroupExpression<E>, EntityQueryConditionGroupLogicExpression<E>>,
            QR extends EntityQueryRelationExpression2<E, R1, R2, EntityQueryEntityProperties<E>,
                    EntityQueryConditionGroupExpression<E>, EntityQueryConditionGroupLogicExpression<E>>,
            R2> RE join1(SerializableFunction<R1, R2> propertyName) {
        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(propertyName);
        JdbcClassMapping<R2> joinTypeMapping = factory.getClassMapping((Class<R2>) info.getPropertyType());
        JdbcPropertyMapping cpm = relationPart.joinTypeClassMapping.getPropertyMapping(info.getPropertyName());
        // R1(column) fk R2(pk)
        EntityQueryRelation2<E, R1,
                R2> r = new EntitySqlQueryRelation2<>(sqlQueryEntityProperties, relationPart.joinTypeClassMapping,
                        relationPart.joinTableAlias, cpm.getRepositoryFieldName(), joinTypeMapping,
                        joinTypeMapping.getPrivaryKeyPropertyMappings().get(0).getRepositoryFieldName(),
                        fetchProperty(1, cpm.getPropertyName()), relationParts);
        return (RE) r;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public <RE extends EntityQueryRelationEntityExpression2<E, R1, R2, EntityQueryEntityProperties<E>, QR,
            EntityQueryConditionGroupExpression<E>, EntityQueryConditionGroupLogicExpression<E>>,
            QR extends EntityQueryRelationExpression2<E, R1, R2, EntityQueryEntityProperties<E>,
                    EntityQueryConditionGroupExpression<E>, EntityQueryConditionGroupLogicExpression<E>>,
            R2> RE join1(SerializableFunction2<R2, R1> propertyName) {
        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(propertyName);
        JdbcClassMapping<R2> joinTypeMapping2 = factory
                .getClassMapping((Class<R2>) ClassUtils.forName(info.getMethodInstanceClassName()));
        JdbcPropertyMapping jpm = joinTypeMapping2.getPropertyMapping(info.getPropertyName());
        // R2(column) fk R1(pk)
        EntityQueryRelation2<E, R1,
                R2> r = new EntitySqlQueryRelation2<>(sqlQueryEntityProperties, relationPart.joinTypeClassMapping,
                        relationPart.joinTableAlias,
                        relationPart.joinTypeClassMapping.getPrivaryKeyPropertyMappings().get(0)
                                .getRepositoryFieldName(),
                        joinTypeMapping2, jpm.getRepositoryFieldName(), null,
                        // YUFEI_TODO 后续来根据映射关系看能不能进行处理
                        relationParts);
        return (RE) r;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public <RE extends EntityQueryRelationEntityExpression2<E, R1, R1, EntityQueryEntityProperties<E>, QR,
            EntityQueryConditionGroupExpression<E>, EntityQueryConditionGroupLogicExpression<E>>,
            QR extends EntityQueryRelationExpression2<E, R1, R1, EntityQueryEntityProperties<E>,
                    EntityQueryConditionGroupExpression<E>, EntityQueryConditionGroupLogicExpression<E>>> RE join1(
                            SerializableFunction1<R1, R1> propertyName) {
        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(propertyName);
        JdbcPropertyMapping cpm = relationPart.joinTypeClassMapping.getPropertyMapping(info.getPropertyName());
        EntityQueryRelation2<
                E, R1, R1> r = new EntitySqlQueryRelation2<>(sqlQueryEntityProperties,
                        relationPart.joinTypeClassMapping, relationPart.joinTableAlias, cpm.getRepositoryFieldName(),
                        relationPart.joinTypeClassMapping, relationPart.joinTypeClassMapping
                                .getPrivaryKeyPropertyMappings().get(0).getRepositoryFieldName(),
                        fetchProperty(1, cpm.getPropertyName()), relationParts);
        return (RE) r;
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
