
package cn.featherfly.hammer.sqldb.jdbc.dsl.query;

import java.util.List;

import cn.featherfly.common.db.mapping.JdbcClassMapping;
import cn.featherfly.common.db.mapping.JdbcPropertyMapping;
import cn.featherfly.common.lang.ClassUtils;
import cn.featherfly.common.lang.LambdaUtils;
import cn.featherfly.common.lang.LambdaUtils.SerializedLambdaInfo;
import cn.featherfly.common.lang.function.SerializableFunction;
import cn.featherfly.common.lang.function.SerializableFunction1;
import cn.featherfly.common.lang.function.SerializableFunction2;
import cn.featherfly.hammer.dsl.query.type.EntityQueryConditionGroup;
import cn.featherfly.hammer.dsl.query.type.EntityQueryConditionGroupLogic;
import cn.featherfly.hammer.dsl.query.type.EntityQueryEntityProperties;
import cn.featherfly.hammer.dsl.query.type.EntityQueryRelation5;
import cn.featherfly.hammer.dsl.query.type.EntityQueryRelation6;
import cn.featherfly.hammer.dsl.query.type.EntityQueryRelationEntity5;
import cn.featherfly.hammer.expression.query.type.EntityQueryRelateExpression6RRRRR;
import cn.featherfly.hammer.expression.query.type.EntityQueryRelationExpression6;

/**
 * @author zhongj
 */
public class EntitySqlQueryRelation5<E, R1, R2, R3, R4, R5, J1, J2> extends AbstractEntitySqlQueryRelation<E, J1, J2>
        implements EntitySqlQuery<E>, EntityQueryRelation5<E, R1, R2, R3, R4, R5>,
        EntityQueryRelationEntity5<E, R1, R2, R3, R4, R5> {

    /**
     * Instantiates a new entity sql query relation 5.
     *
     * @param sqlQueryEntityProperties  the sql query entity properties
     * @param conditionTypeClassMapping the condition type class mapping
     * @param conditionTableAlias       the condition table alias
     * @param conditionTableColumn      the condition table column
     * @param joinTypeClassMapping      the join type class mapping
     * @param joinTableColumn           the join table column
     * @param fetchProperty             the fetch property
     * @param relationParts             the relation parts
     */
    public EntitySqlQueryRelation5(EntitySqlQueryEntityProperties<E> sqlQueryEntityProperties,
            JdbcClassMapping<J1> conditionTypeClassMapping, String conditionTableAlias, String conditionTableColumn,
            JdbcClassMapping<J2> joinTypeClassMapping, String joinTableColumn, String fetchProperty,
            List<EntitySqlQueryRelationPart<?, ?>> relationParts) {
        super(sqlQueryEntityProperties, conditionTypeClassMapping, conditionTableAlias, conditionTableColumn,
                joinTypeClassMapping, joinTableColumn, fetchProperty, relationParts);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQueryRelationEntity5<E, R1, R2, R3, R4, R5> fetch() {
        fetch0();
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public <RE extends EntityQueryRelateExpression6RRRRR<E, R1, R2, R3, R4, R5, R6, EntityQueryEntityProperties<E>,
            QR, EntityQueryConditionGroup<E>, EntityQueryConditionGroupLogic<E>>,
            QR extends EntityQueryRelationExpression6<E, R1, R2, R3, R4, R5, R6, EntityQueryEntityProperties<E>,
                    EntityQueryConditionGroup<E>, EntityQueryConditionGroupLogic<E>>,
            R6> RE join(SerializableFunction<E, R6> propertyName) {
        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(propertyName);
        JdbcClassMapping<R6> joinTypeMapping2 = factory.getClassMapping((Class<R6>) info.getPropertyType());
        JdbcPropertyMapping cpm = relationPart.conditionTypeClassMapping.getPropertyMapping(info.getPropertyName());
        EntityQueryRelation6<E, R1, R2, R3, R4, R5,
                R6> r = new EntitySqlQueryRelation6<>(sqlQueryEntityProperties, relationPart.joinTypeClassMapping,
                        relationPart.conditionTableAlias, cpm.getRepositoryFieldName(), joinTypeMapping2,
                        joinTypeMapping2.getPrivaryKeyPropertyMappings().get(0).getRepositoryFieldName(),
                        cpm.getPropertyName(), relationParts);
        return (RE) r;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public <RE extends EntityQueryRelateExpression6RRRRR<E, R1, R2, R3, R4, R5, R6, EntityQueryEntityProperties<E>,
            QR, EntityQueryConditionGroup<E>, EntityQueryConditionGroupLogic<E>>,
            QR extends EntityQueryRelationExpression6<E, R1, R2, R3, R4, R5, R6, EntityQueryEntityProperties<E>,
                    EntityQueryConditionGroup<E>, EntityQueryConditionGroupLogic<E>>,
            R6> RE join(SerializableFunction2<R6, E> propertyName) {
        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(propertyName);
        JdbcClassMapping<R6> joinTypeMapping = factory
                .getClassMapping((Class<R6>) ClassUtils.forName(info.getMethodInstanceClassName()));
        JdbcPropertyMapping jpm = joinTypeMapping.getPropertyMapping(info.getPropertyName());
        EntityQueryRelation6<E, R1, R2, R3, R4, R5,
                R6> r = new EntitySqlQueryRelation6<>(sqlQueryEntityProperties, relationPart.joinTypeClassMapping,
                        relationPart.conditionTableAlias, jpm.getRepositoryFieldName(), joinTypeMapping,
                        joinTypeMapping.getPrivaryKeyPropertyMappings().get(0).getRepositoryFieldName(), null,
                        // YUFEI_TODO 后续来根据映射关系看能不能进行处理
                        relationParts);
        return (RE) r;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public <RE extends EntityQueryRelateExpression6RRRRR<E, R1, R2, R3, R4, R5, E, EntityQueryEntityProperties<E>,
            QR, EntityQueryConditionGroup<E>, EntityQueryConditionGroupLogic<E>>,
            QR extends EntityQueryRelationExpression6<E, R1, R2, R3, R4, R5, E, EntityQueryEntityProperties<E>,
                    EntityQueryConditionGroup<E>, EntityQueryConditionGroupLogic<E>>> RE join(
                            SerializableFunction1<E, E> propertyName) {
        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(propertyName);
        JdbcClassMapping<E> joinTypeMapping = factory.getClassMapping((Class<E>) info.getPropertyType());
        JdbcPropertyMapping cpm = relationPart.conditionTypeClassMapping.getPropertyMapping(info.getPropertyName());
        EntityQueryRelation6<E, R1, R2, R3, R4, R5,
                E> r = new EntitySqlQueryRelation6<>(sqlQueryEntityProperties, relationPart.joinTypeClassMapping,
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
    public <RE extends EntityQueryRelateExpression6RRRRR<E, R1, R2, R3, R4, R5, R6, EntityQueryEntityProperties<E>,
            QR, EntityQueryConditionGroup<E>, EntityQueryConditionGroupLogic<E>>,
            QR extends EntityQueryRelationExpression6<E, R1, R2, R3, R4, R5, R6, EntityQueryEntityProperties<E>,
                    EntityQueryConditionGroup<E>, EntityQueryConditionGroupLogic<E>>,
            R6> RE join1(SerializableFunction<R1, R6> propertyName) {
        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(propertyName);
        JdbcClassMapping<R6> joinTypeMapping2 = factory.getClassMapping((Class<R6>) info.getPropertyType());
        JdbcPropertyMapping cpm = relationPart.joinTypeClassMapping.getPropertyMapping(info.getPropertyName());
        EntityQueryRelation6<E, R1, R2, R3, R4, R5,
                R6> r = new EntitySqlQueryRelation6<>(sqlQueryEntityProperties, relationPart.joinTypeClassMapping,
                        relationPart.joinTableAlias, cpm.getRepositoryFieldName(), joinTypeMapping2,
                        joinTypeMapping2.getPrivaryKeyPropertyMappings().get(0).getRepositoryFieldName(),
                        fetchProperty(1, cpm.getPropertyName()), relationParts);
        return (RE) r;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public <RE extends EntityQueryRelateExpression6RRRRR<E, R1, R2, R3, R4, R5, R6, EntityQueryEntityProperties<E>,
            QR, EntityQueryConditionGroup<E>, EntityQueryConditionGroupLogic<E>>,
            QR extends EntityQueryRelationExpression6<E, R1, R2, R3, R4, R5, R6, EntityQueryEntityProperties<E>,
                    EntityQueryConditionGroup<E>, EntityQueryConditionGroupLogic<E>>,
            R6> RE join1(SerializableFunction2<R6, R1> propertyName) {
        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(propertyName);
        JdbcClassMapping<R6> joinTypeMapping2 = factory
                .getClassMapping((Class<R6>) ClassUtils.forName(info.getMethodInstanceClassName()));
        JdbcPropertyMapping jpm = joinTypeMapping2.getPropertyMapping(info.getPropertyName());
        // R2(column) fk R1(pk)
        EntityQueryRelation6<E, R1, R2, R3, R4, R5, R6> r = new EntitySqlQueryRelation6<>(sqlQueryEntityProperties,
                relationPart.joinTypeClassMapping, relationPart.joinTableAlias,
                relationPart.joinTypeClassMapping.getPrivaryKeyPropertyMappings().get(0).getRepositoryFieldName(),
                joinTypeMapping2, jpm.getRepositoryFieldName(), null
                // YUFEI_TODO 后续来根据映射关系看能不能进行处理
                , relationParts);
        return (RE) r;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public <RE extends EntityQueryRelateExpression6RRRRR<E, R1, R2, R3, R4, R5, R1, EntityQueryEntityProperties<E>,
            QR, EntityQueryConditionGroup<E>, EntityQueryConditionGroupLogic<E>>,
            QR extends EntityQueryRelationExpression6<E, R1, R2, R3, R4, R5, R1, EntityQueryEntityProperties<E>,
                    EntityQueryConditionGroup<E>, EntityQueryConditionGroupLogic<E>>> RE join1(
                            SerializableFunction1<R1, R1> propertyName) {
        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(propertyName);
        JdbcPropertyMapping cpm = relationPart.joinTypeClassMapping.getPropertyMapping(info.getPropertyName());
        EntityQueryRelation6<E, R1, R2, R3, R4, R5, R1> r = new EntitySqlQueryRelation6<>(sqlQueryEntityProperties,
                relationPart.joinTypeClassMapping, relationPart.joinTableAlias, cpm.getRepositoryFieldName(),
                relationPart.joinTypeClassMapping,
                relationPart.joinTypeClassMapping.getPrivaryKeyPropertyMappings().get(0).getRepositoryFieldName(),
                fetchProperty(1, cpm.getPropertyName()), relationParts);
        return (RE) r;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public <RE extends EntityQueryRelateExpression6RRRRR<E, R1, R2, R3, R4, R5, R6, EntityQueryEntityProperties<E>,
            QR, EntityQueryConditionGroup<E>, EntityQueryConditionGroupLogic<E>>,
            QR extends EntityQueryRelationExpression6<E, R1, R2, R3, R4, R5, R6, EntityQueryEntityProperties<E>,
                    EntityQueryConditionGroup<E>, EntityQueryConditionGroupLogic<E>>,
            R6> RE join2(SerializableFunction<R2, R6> propertyName) {
        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(propertyName);
        JdbcClassMapping<R6> joinTypeMapping2 = factory.getClassMapping((Class<R6>) info.getPropertyType());
        JdbcPropertyMapping cpm = relationPart.joinTypeClassMapping.getPropertyMapping(info.getPropertyName());
        EntityQueryRelation6<E, R1, R2, R3, R4, R5,
                R6> r = new EntitySqlQueryRelation6<>(sqlQueryEntityProperties, relationPart.joinTypeClassMapping,
                        relationPart.joinTableAlias, cpm.getRepositoryFieldName(), joinTypeMapping2,
                        joinTypeMapping2.getPrivaryKeyPropertyMappings().get(0).getRepositoryFieldName(),
                        fetchProperty(2, cpm.getPropertyName()), relationParts);
        return (RE) r;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public <RE extends EntityQueryRelateExpression6RRRRR<E, R1, R2, R3, R4, R5, R6, EntityQueryEntityProperties<E>,
            QR, EntityQueryConditionGroup<E>, EntityQueryConditionGroupLogic<E>>,
            QR extends EntityQueryRelationExpression6<E, R1, R2, R3, R4, R5, R6, EntityQueryEntityProperties<E>,
                    EntityQueryConditionGroup<E>, EntityQueryConditionGroupLogic<E>>,
            R6> RE join2(SerializableFunction2<R6, R2> propertyName) {
        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(propertyName);
        JdbcClassMapping<R6> joinTypeMapping2 = factory
                .getClassMapping((Class<R6>) ClassUtils.forName(info.getMethodInstanceClassName()));
        JdbcPropertyMapping jpm = joinTypeMapping2.getPropertyMapping(info.getPropertyName());
        // R2(column) fk R1(pk)
        EntityQueryRelation6<E, R1, R2, R3, R4, R5, R6> r = new EntitySqlQueryRelation6<>(sqlQueryEntityProperties,
                relationPart.joinTypeClassMapping, relationPart.joinTableAlias,
                relationPart.joinTypeClassMapping.getPrivaryKeyPropertyMappings().get(0).getRepositoryFieldName(),
                joinTypeMapping2, jpm.getRepositoryFieldName(), null
                // YUFEI_TODO 后续来根据映射关系看能不能进行处理
                , relationParts);
        return (RE) r;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public <RE extends EntityQueryRelateExpression6RRRRR<E, R1, R2, R3, R4, R5, R2, EntityQueryEntityProperties<E>,
            QR, EntityQueryConditionGroup<E>, EntityQueryConditionGroupLogic<E>>,
            QR extends EntityQueryRelationExpression6<E, R1, R2, R3, R4, R5, R2, EntityQueryEntityProperties<E>,
                    EntityQueryConditionGroup<E>, EntityQueryConditionGroupLogic<E>>> RE join2(
                            SerializableFunction1<R2, R2> propertyName) {
        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(propertyName);
        JdbcPropertyMapping cpm = relationPart.joinTypeClassMapping.getPropertyMapping(info.getPropertyName());
        EntityQueryRelation6<E, R1, R2, R3, R4, R5, R2> r = new EntitySqlQueryRelation6<>(sqlQueryEntityProperties,
                relationPart.joinTypeClassMapping, relationPart.joinTableAlias, cpm.getRepositoryFieldName(),
                relationPart.joinTypeClassMapping,
                relationPart.joinTypeClassMapping.getPrivaryKeyPropertyMappings().get(0).getRepositoryFieldName(),
                fetchProperty(2, cpm.getPropertyName()), relationParts);
        return (RE) r;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public <RE extends EntityQueryRelateExpression6RRRRR<E, R1, R2, R3, R4, R5, R6, EntityQueryEntityProperties<E>,
            QR, EntityQueryConditionGroup<E>, EntityQueryConditionGroupLogic<E>>,
            QR extends EntityQueryRelationExpression6<E, R1, R2, R3, R4, R5, R6, EntityQueryEntityProperties<E>,
                    EntityQueryConditionGroup<E>, EntityQueryConditionGroupLogic<E>>,
            R6> RE join3(SerializableFunction<R3, R6> propertyName) {
        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(propertyName);
        JdbcClassMapping<R6> joinTypeMapping2 = factory.getClassMapping((Class<R6>) info.getPropertyType());
        JdbcPropertyMapping cpm = relationPart.joinTypeClassMapping.getPropertyMapping(info.getPropertyName());
        EntityQueryRelation6<E, R1, R2, R3, R4, R5,
                R6> r = new EntitySqlQueryRelation6<>(sqlQueryEntityProperties, relationPart.joinTypeClassMapping,
                        relationPart.joinTableAlias, cpm.getRepositoryFieldName(), joinTypeMapping2,
                        joinTypeMapping2.getPrivaryKeyPropertyMappings().get(0).getRepositoryFieldName(),
                        fetchProperty(3, cpm.getPropertyName()), relationParts);
        return (RE) r;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public <RE extends EntityQueryRelateExpression6RRRRR<E, R1, R2, R3, R4, R5, R6, EntityQueryEntityProperties<E>,
            QR, EntityQueryConditionGroup<E>, EntityQueryConditionGroupLogic<E>>,
            QR extends EntityQueryRelationExpression6<E, R1, R2, R3, R4, R5, R6, EntityQueryEntityProperties<E>,
                    EntityQueryConditionGroup<E>, EntityQueryConditionGroupLogic<E>>,
            R6> RE join3(SerializableFunction2<R6, R3> propertyName) {
        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(propertyName);
        JdbcClassMapping<R6> joinTypeMapping2 = factory
                .getClassMapping((Class<R6>) ClassUtils.forName(info.getMethodInstanceClassName()));
        JdbcPropertyMapping jpm = joinTypeMapping2.getPropertyMapping(info.getPropertyName());
        // R2(column) fk R1(pk)
        EntityQueryRelation6<E, R1, R2, R3, R4, R5, R6> r = new EntitySqlQueryRelation6<>(sqlQueryEntityProperties,
                relationPart.joinTypeClassMapping, relationPart.joinTableAlias,
                relationPart.joinTypeClassMapping.getPrivaryKeyPropertyMappings().get(0).getRepositoryFieldName(),
                joinTypeMapping2, jpm.getRepositoryFieldName(), null
                // YUFEI_TODO 后续来根据映射关系看能不能进行处理
                , relationParts);
        return (RE) r;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public <RE extends EntityQueryRelateExpression6RRRRR<E, R1, R2, R3, R4, R5, R3, EntityQueryEntityProperties<E>,
            QR, EntityQueryConditionGroup<E>, EntityQueryConditionGroupLogic<E>>,
            QR extends EntityQueryRelationExpression6<E, R1, R2, R3, R4, R5, R3, EntityQueryEntityProperties<E>,
                    EntityQueryConditionGroup<E>, EntityQueryConditionGroupLogic<E>>> RE join3(
                            SerializableFunction1<R3, R3> propertyName) {
        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(propertyName);
        JdbcPropertyMapping cpm = relationPart.joinTypeClassMapping.getPropertyMapping(info.getPropertyName());
        EntityQueryRelation6<E, R1, R2, R3, R4, R5, R3> r = new EntitySqlQueryRelation6<>(sqlQueryEntityProperties,
                relationPart.joinTypeClassMapping, relationPart.joinTableAlias, cpm.getRepositoryFieldName(),
                relationPart.joinTypeClassMapping,
                relationPart.joinTypeClassMapping.getPrivaryKeyPropertyMappings().get(0).getRepositoryFieldName(),
                fetchProperty(3, cpm.getPropertyName()), relationParts);
        return (RE) r;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public <RE extends EntityQueryRelateExpression6RRRRR<E, R1, R2, R3, R4, R5, R6, EntityQueryEntityProperties<E>,
            QR, EntityQueryConditionGroup<E>, EntityQueryConditionGroupLogic<E>>,
            QR extends EntityQueryRelationExpression6<E, R1, R2, R3, R4, R5, R6, EntityQueryEntityProperties<E>,
                    EntityQueryConditionGroup<E>, EntityQueryConditionGroupLogic<E>>,
            R6> RE join4(SerializableFunction<R4, R6> propertyName) {
        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(propertyName);
        JdbcClassMapping<R6> joinTypeMapping2 = factory.getClassMapping((Class<R6>) info.getPropertyType());
        JdbcPropertyMapping cpm = relationPart.joinTypeClassMapping.getPropertyMapping(info.getPropertyName());
        EntityQueryRelation6<E, R1, R2, R3, R4, R5,
                R6> r = new EntitySqlQueryRelation6<>(sqlQueryEntityProperties, relationPart.joinTypeClassMapping,
                        relationPart.joinTableAlias, cpm.getRepositoryFieldName(), joinTypeMapping2,
                        joinTypeMapping2.getPrivaryKeyPropertyMappings().get(0).getRepositoryFieldName(),
                        fetchProperty(4, cpm.getPropertyName()), relationParts);
        return (RE) r;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public <RE extends EntityQueryRelateExpression6RRRRR<E, R1, R2, R3, R4, R5, R6, EntityQueryEntityProperties<E>,
            QR, EntityQueryConditionGroup<E>, EntityQueryConditionGroupLogic<E>>,
            QR extends EntityQueryRelationExpression6<E, R1, R2, R3, R4, R5, R6, EntityQueryEntityProperties<E>,
                    EntityQueryConditionGroup<E>, EntityQueryConditionGroupLogic<E>>,
            R6> RE join4(SerializableFunction2<R6, R4> propertyName) {
        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(propertyName);
        JdbcClassMapping<R6> joinTypeMapping2 = factory
                .getClassMapping((Class<R6>) ClassUtils.forName(info.getMethodInstanceClassName()));
        JdbcPropertyMapping jpm = joinTypeMapping2.getPropertyMapping(info.getPropertyName());
        // R2(column) fk R1(pk)
        EntityQueryRelation6<E, R1, R2, R3, R4, R5, R6> r = new EntitySqlQueryRelation6<>(sqlQueryEntityProperties,
                relationPart.joinTypeClassMapping, relationPart.joinTableAlias,
                relationPart.joinTypeClassMapping.getPrivaryKeyPropertyMappings().get(0).getRepositoryFieldName(),
                joinTypeMapping2, jpm.getRepositoryFieldName(), null
                // YUFEI_TODO 后续来根据映射关系看能不能进行处理
                , relationParts);
        return (RE) r;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public <RE extends EntityQueryRelateExpression6RRRRR<E, R1, R2, R3, R4, R5, R4, EntityQueryEntityProperties<E>,
            QR, EntityQueryConditionGroup<E>, EntityQueryConditionGroupLogic<E>>,
            QR extends EntityQueryRelationExpression6<E, R1, R2, R3, R4, R5, R4, EntityQueryEntityProperties<E>,
                    EntityQueryConditionGroup<E>, EntityQueryConditionGroupLogic<E>>> RE join4(
                            SerializableFunction1<R4, R4> propertyName) {
        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(propertyName);
        JdbcPropertyMapping cpm = relationPart.joinTypeClassMapping.getPropertyMapping(info.getPropertyName());
        EntityQueryRelation6<E, R1, R2, R3, R4, R5, R4> r = new EntitySqlQueryRelation6<>(sqlQueryEntityProperties,
                relationPart.joinTypeClassMapping, relationPart.joinTableAlias, cpm.getRepositoryFieldName(),
                relationPart.joinTypeClassMapping,
                relationPart.joinTypeClassMapping.getPrivaryKeyPropertyMappings().get(0).getRepositoryFieldName(),
                fetchProperty(4, cpm.getPropertyName()), relationParts);
        return (RE) r;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public <RE extends EntityQueryRelateExpression6RRRRR<E, R1, R2, R3, R4, R5, R6, EntityQueryEntityProperties<E>,
            QR, EntityQueryConditionGroup<E>, EntityQueryConditionGroupLogic<E>>,
            QR extends EntityQueryRelationExpression6<E, R1, R2, R3, R4, R5, R6, EntityQueryEntityProperties<E>,
                    EntityQueryConditionGroup<E>, EntityQueryConditionGroupLogic<E>>,
            R6> RE join5(SerializableFunction<R5, R6> propertyName) {
        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(propertyName);
        JdbcClassMapping<R6> joinTypeMapping2 = factory.getClassMapping((Class<R6>) info.getPropertyType());
        JdbcPropertyMapping cpm = relationPart.joinTypeClassMapping.getPropertyMapping(info.getPropertyName());
        EntityQueryRelation6<E, R1, R2, R3, R4, R5,
                R6> r = new EntitySqlQueryRelation6<>(sqlQueryEntityProperties, relationPart.joinTypeClassMapping,
                        relationPart.joinTableAlias, cpm.getRepositoryFieldName(), joinTypeMapping2,
                        joinTypeMapping2.getPrivaryKeyPropertyMappings().get(0).getRepositoryFieldName(),
                        fetchProperty(5, cpm.getPropertyName()), relationParts);
        return (RE) r;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <RE extends EntityQueryRelateExpression6RRRRR<E, R1, R2, R3, R4, R5, R6, EntityQueryEntityProperties<E>,
            QR, EntityQueryConditionGroup<E>, EntityQueryConditionGroupLogic<E>>,
            QR extends EntityQueryRelationExpression6<E, R1, R2, R3, R4, R5, R6, EntityQueryEntityProperties<E>,
                    EntityQueryConditionGroup<E>, EntityQueryConditionGroupLogic<E>>,
            R6> RE join5(SerializableFunction2<R6, R5> propertyName) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public <RE extends EntityQueryRelateExpression6RRRRR<E, R1, R2, R3, R4, R5, R5, EntityQueryEntityProperties<E>,
            QR, EntityQueryConditionGroup<E>, EntityQueryConditionGroupLogic<E>>,
            QR extends EntityQueryRelationExpression6<E, R1, R2, R3, R4, R5, R5, EntityQueryEntityProperties<E>,
                    EntityQueryConditionGroup<E>, EntityQueryConditionGroupLogic<E>>> RE join5(
                            SerializableFunction1<R5, R5> propertyName) {
        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(propertyName);
        JdbcPropertyMapping cpm = relationPart.joinTypeClassMapping.getPropertyMapping(info.getPropertyName());
        EntityQueryRelation6<E, R1, R2, R3, R4, R5, R5> r = new EntitySqlQueryRelation6<>(sqlQueryEntityProperties,
                relationPart.joinTypeClassMapping, relationPart.joinTableAlias, cpm.getRepositoryFieldName(),
                relationPart.joinTypeClassMapping,
                relationPart.joinTypeClassMapping.getPrivaryKeyPropertyMappings().get(0).getRepositoryFieldName(),
                fetchProperty(5, cpm.getPropertyName()), relationParts);
        return (RE) r;
    }

}
