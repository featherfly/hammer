
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
import cn.featherfly.common.lang.function.SerializableFunction3;
import cn.featherfly.hammer.dsl.query.type.EntityQueryConditionGroupExpression;
import cn.featherfly.hammer.dsl.query.type.EntityQueryConditionGroupLogicExpression;
import cn.featherfly.hammer.dsl.query.type.EntityQueryEntityProperties;
import cn.featherfly.hammer.dsl.query.type.EntityQueryRelation2;
import cn.featherfly.hammer.dsl.query.type.EntityQueryRelation3;
import cn.featherfly.hammer.dsl.query.type.EntityQueryRelationEntity2;
import cn.featherfly.hammer.expression.query.type.EntityQueryRelationEntityExpression3;
import cn.featherfly.hammer.expression.query.type.EntityQueryRelationExpression3;

/**
 * @author zhongj
 */
public class EntitySqlQueryRelation2<E, R1, R2> extends AbstractEntitySqlQueryRelation<E, R1, R2>
        implements EntitySqlQuery<E>, EntityQueryRelation2<E, R1, R2>, EntityQueryRelationEntity2<E, R1, R2> {

    //    /**
    //     * @param sqlQueryEntityProperties
    //     * @param aliasManager
    //     * @param factory
    //     * @param sqlPageFactory
    //     * @param conditionTypeClassMapping
    //     * @param conditionTableAlias
    //     * @param conditionTableColumn
    //     * @param joinTypeClassMapping
    //     * @param joinTableColumn
    //     * @param ignorePolicy
    //     */
    //    public EntitySqlQueryRelation2(EntitySqlQueryEntityProperties<E> sqlQueryEntityProperties,
    //            JdbcClassMapping<E> conditionTypeClassMapping, String conditionTableAlias, String conditionTableColumn,
    //            JdbcClassMapping<R1> joinTypeClassMapping, String joinTableColumn, Predicate<Object> ignorePolicy) {
    //        super(sqlQueryEntityProperties, conditionTypeClassMapping, conditionTableAlias, conditionTableColumn,
    //                joinTypeClassMapping, joinTableColumn, ignorePolicy);
    //    }

    /**
     * Instantiates a new entity sql query relation 2.
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
    public EntitySqlQueryRelation2(EntitySqlQueryEntityProperties<E> sqlQueryEntityProperties,
            JdbcClassMapping<R1> conditionTypeClassMapping, String conditionTableAlias, String conditionTableColumn,
            JdbcClassMapping<R2> joinTypeClassMapping, String joinTableColumn, String fetchProperty,
            List<EntitySqlQueryRelationPart<?, ?>> relationParts) {
        super(sqlQueryEntityProperties, conditionTypeClassMapping, conditionTableAlias, conditionTableColumn,
                joinTypeClassMapping, joinTableColumn, fetchProperty, relationParts);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQueryRelationEntity2<E, R1, R2> fetch() {
        fetch0();
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public <RE extends EntityQueryRelationEntityExpression3<E, R1, R2, R3, EntityQueryEntityProperties<E>, QR,
            EntityQueryConditionGroupExpression<E>, EntityQueryConditionGroupLogicExpression<E>>,
            QR extends EntityQueryRelationExpression3<E, R1, R2, R3, EntityQueryEntityProperties<E>,
                    EntityQueryConditionGroupExpression<E>, EntityQueryConditionGroupLogicExpression<E>>,
            R3> RE join(SerializableFunction<E, R3> propertyName) {
        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(propertyName);
        JdbcClassMapping<R3> joinTypeMapping2 = factory.getClassMapping((Class<R3>) info.getPropertyType());
        EntitySqlQueryRelationPart<E, R1> rp = (EntitySqlQueryRelationPart<E, R1>) relationParts.get(0);
        JdbcPropertyMapping cpm = rp.conditionTypeClassMapping.getPropertyMapping(info.getPropertyName());
        EntityQueryRelation3<E, R1, R2,
                R3> r = new EntitySqlQueryRelation3<>(sqlQueryEntityProperties, rp.conditionTypeClassMapping,
                        rp.conditionTableAlias, cpm.getRepositoryFieldName(), joinTypeMapping2,
                        joinTypeMapping2.getPrivaryKeyPropertyMappings().get(0).getRepositoryFieldName(),
                        cpm.getPropertyName(), relationParts);
        return (RE) r;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public <RE extends EntityQueryRelationEntityExpression3<E, R1, R2, R3, EntityQueryEntityProperties<E>, QR,
            EntityQueryConditionGroupExpression<E>, EntityQueryConditionGroupLogicExpression<E>>,
            QR extends EntityQueryRelationExpression3<E, R1, R2, R3, EntityQueryEntityProperties<E>,
                    EntityQueryConditionGroupExpression<E>, EntityQueryConditionGroupLogicExpression<E>>,
            R3> RE join(SerializableFunction2<R3, E> propertyName) {
        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(propertyName);
        JdbcClassMapping<R3> joinTypeMapping = factory
                .getClassMapping((Class<R3>) ClassUtils.forName(info.getMethodInstanceClassName()));
        JdbcPropertyMapping jpm = joinTypeMapping.getPropertyMapping(info.getPropertyName());
        EntitySqlQueryRelationPart<E, R1> rp = (EntitySqlQueryRelationPart<E, R1>) relationParts.get(0);
        EntityQueryRelation3<E, R1, R2,
                R3> r = new EntitySqlQueryRelation3<>(sqlQueryEntityProperties, rp.conditionTypeClassMapping,
                        rp.conditionTableAlias,
                        rp.conditionTypeClassMapping.getPrivaryKeyPropertyMappings().get(0).getRepositoryFieldName(),
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
    public <RE extends EntityQueryRelationEntityExpression3<E, R1, R2, E, EntityQueryEntityProperties<E>, QR,
            EntityQueryConditionGroupExpression<E>, EntityQueryConditionGroupLogicExpression<E>>,
            QR extends EntityQueryRelationExpression3<E, R1, R2, E, EntityQueryEntityProperties<E>,
                    EntityQueryConditionGroupExpression<E>, EntityQueryConditionGroupLogicExpression<E>>> RE join(
                            SerializableFunction1<E, E> propertyName) {
        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(propertyName);
        JdbcClassMapping<E> joinTypeMapping = factory.getClassMapping((Class<E>) info.getPropertyType());
        EntitySqlQueryRelationPart<E, R1> rp = (EntitySqlQueryRelationPart<E, R1>) relationParts.get(0);
        JdbcPropertyMapping cpm = rp.conditionTypeClassMapping.getPropertyMapping(info.getPropertyName());
        EntityQueryRelation3<E, R1, R2,
                E> r = new EntitySqlQueryRelation3<>(sqlQueryEntityProperties, rp.conditionTypeClassMapping,
                        rp.conditionTableAlias, cpm.getRepositoryFieldName(), joinTypeMapping,
                        joinTypeMapping.getPrivaryKeyPropertyMappings().get(0).getRepositoryFieldName(),
                        cpm.getPropertyName(), relationParts);
        return (RE) r;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public <RE extends EntityQueryRelationEntityExpression3<E, R1, R2, R3, EntityQueryEntityProperties<E>, QR,
            EntityQueryConditionGroupExpression<E>, EntityQueryConditionGroupLogicExpression<E>>,
            QR extends EntityQueryRelationExpression3<E, R1, R2, R3, EntityQueryEntityProperties<E>,
                    EntityQueryConditionGroupExpression<E>, EntityQueryConditionGroupLogicExpression<E>>,
            R3> RE join1(SerializableFunction<R1, R3> propertyName) {
        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(propertyName);
        JdbcClassMapping<R3> joinTypeMapping2 = factory.getClassMapping((Class<R3>) info.getPropertyType());
        EntitySqlQueryRelationPart<E, R1> rp = (EntitySqlQueryRelationPart<E, R1>) relationParts.get(0);
        JdbcPropertyMapping cpm = rp.joinTypeClassMapping.getPropertyMapping(info.getPropertyName());
        // R1(column) fk R2(pk)
        EntityQueryRelation3<E, R1, R2,
                R3> r = new EntitySqlQueryRelation3<>(sqlQueryEntityProperties, rp.joinTypeClassMapping,
                        rp.joinTableAlias, cpm.getRepositoryFieldName(), joinTypeMapping2,
                        joinTypeMapping2.getPrivaryKeyPropertyMappings().get(0).getRepositoryFieldName(),
                        fetchProperty(1, cpm.getPropertyName()), relationParts);
        return (RE) r;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public <RE extends EntityQueryRelationEntityExpression3<E, R1, R2, R3, EntityQueryEntityProperties<E>, QR,
            EntityQueryConditionGroupExpression<E>, EntityQueryConditionGroupLogicExpression<E>>,
            QR extends EntityQueryRelationExpression3<E, R1, R2, R3, EntityQueryEntityProperties<E>,
                    EntityQueryConditionGroupExpression<E>, EntityQueryConditionGroupLogicExpression<E>>,
            R3> RE join1(SerializableFunction2<R3, R1> propertyName) {
        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(propertyName);
        JdbcClassMapping<R3> joinTypeMapping2 = factory
                .getClassMapping((Class<R3>) ClassUtils.forName(info.getMethodInstanceClassName()));
        JdbcPropertyMapping jpm = joinTypeMapping2.getPropertyMapping(info.getPropertyName());
        EntitySqlQueryRelationPart<E, R1> rp = (EntitySqlQueryRelationPart<E, R1>) relationParts.get(0);
        // R2(column) fk R1(pk)
        EntityQueryRelation3<E, R1, R2,
                R3> r = new EntitySqlQueryRelation3<>(sqlQueryEntityProperties, rp.joinTypeClassMapping,
                        rp.joinTableAlias,
                        rp.joinTypeClassMapping.getPrivaryKeyPropertyMappings().get(0).getRepositoryFieldName(),
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
    public <RE extends EntityQueryRelationEntityExpression3<E, R1, R2, R1, EntityQueryEntityProperties<E>, QR,
            EntityQueryConditionGroupExpression<E>, EntityQueryConditionGroupLogicExpression<E>>,
            QR extends EntityQueryRelationExpression3<E, R1, R2, R1, EntityQueryEntityProperties<E>,
                    EntityQueryConditionGroupExpression<E>, EntityQueryConditionGroupLogicExpression<E>>> RE join1(
                            SerializableFunction1<R1, R1> propertyName) {
        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(propertyName);
        EntitySqlQueryRelationPart<E, R1> rp = (EntitySqlQueryRelationPart<E, R1>) relationParts.get(0);
        JdbcPropertyMapping cpm = rp.joinTypeClassMapping.getPropertyMapping(info.getPropertyName());
        EntityQueryRelation3<E, R1, R2,
                R1> r = new EntitySqlQueryRelation3<>(sqlQueryEntityProperties, rp.joinTypeClassMapping,
                        rp.joinTableAlias, cpm.getRepositoryFieldName(), rp.joinTypeClassMapping,
                        rp.joinTypeClassMapping.getPrivaryKeyPropertyMappings().get(0).getRepositoryFieldName(),
                        fetchProperty(1, cpm.getPropertyName()), relationParts);
        return (RE) r;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public <RE extends EntityQueryRelationEntityExpression3<E, R1, R2, R3, EntityQueryEntityProperties<E>, QR,
            EntityQueryConditionGroupExpression<E>, EntityQueryConditionGroupLogicExpression<E>>,
            QR extends EntityQueryRelationExpression3<E, R1, R2, R3, EntityQueryEntityProperties<E>,
                    EntityQueryConditionGroupExpression<E>, EntityQueryConditionGroupLogicExpression<E>>,
            R3> RE join2(SerializableFunction1<R2, R3> propertyName) {
        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(propertyName);
        JdbcClassMapping<R3> joinTypeMapping = factory.getClassMapping((Class<R3>) info.getPropertyType());
        EntitySqlQueryRelationPart<?, R2> rp = (EntitySqlQueryRelationPart<?, R2>) relationParts.get(1);
        JdbcPropertyMapping cpm = rp.joinTypeClassMapping.getPropertyMapping(info.getPropertyName());
        EntityQueryRelation3<E, R1, R2,
                R3> r = new EntitySqlQueryRelation3<>(sqlQueryEntityProperties, rp.joinTypeClassMapping,
                        rp.joinTableAlias, cpm.getRepositoryFieldName(), joinTypeMapping,
                        joinTypeMapping.getPrivaryKeyPropertyMappings().get(0).getRepositoryFieldName(),
                        fetchProperty(2, cpm.getPropertyName()), relationParts);
        return (RE) r;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public <RE extends EntityQueryRelationEntityExpression3<E, R1, R2, R3, EntityQueryEntityProperties<E>, QR,
            EntityQueryConditionGroupExpression<E>, EntityQueryConditionGroupLogicExpression<E>>,
            QR extends EntityQueryRelationExpression3<E, R1, R2, R3, EntityQueryEntityProperties<E>,
                    EntityQueryConditionGroupExpression<E>, EntityQueryConditionGroupLogicExpression<E>>,
            R3> RE join2(SerializableFunction2<R3, R2> propertyName) {
        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(propertyName);
        JdbcClassMapping<R3> joinTypeMapping2 = factory
                .getClassMapping((Class<R3>) ClassUtils.forName(info.getMethodInstanceClassName()));
        JdbcPropertyMapping jpm = joinTypeMapping2.getPropertyMapping(info.getPropertyName());
        EntitySqlQueryRelationPart<?, R2> rp = (EntitySqlQueryRelationPart<?, R2>) relationParts.get(1);
        EntityQueryRelation3<E, R1, R2,
                R3> r = new EntitySqlQueryRelation3<>(sqlQueryEntityProperties, rp.joinTypeClassMapping,
                        rp.joinTableAlias,
                        rp.joinTypeClassMapping.getPrivaryKeyPropertyMappings().get(0).getRepositoryFieldName(),
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
    public <RE extends EntityQueryRelationEntityExpression3<E, R1, R2, R2, EntityQueryEntityProperties<E>, QR,
            EntityQueryConditionGroupExpression<E>, EntityQueryConditionGroupLogicExpression<E>>,
            QR extends EntityQueryRelationExpression3<E, R1, R2, R2, EntityQueryEntityProperties<E>,
                    EntityQueryConditionGroupExpression<E>, EntityQueryConditionGroupLogicExpression<E>>> RE join2(
                            SerializableFunction3<R2, R2> propertyName) {
        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(propertyName);
        EntitySqlQueryRelationPart<?, R2> rp = (EntitySqlQueryRelationPart<?, R2>) relationParts.get(1);
        JdbcPropertyMapping cpm = rp.joinTypeClassMapping.getPropertyMapping(info.getPropertyName());
        EntityQueryRelation3<E, R1, R2,
                R2> r = new EntitySqlQueryRelation3<>(sqlQueryEntityProperties, rp.joinTypeClassMapping,
                        rp.joinTableAlias, cpm.getRepositoryFieldName(), rp.joinTypeClassMapping,
                        rp.joinTypeClassMapping.getPrivaryKeyPropertyMappings().get(0).getRepositoryFieldName(),
                        fetchProperty(2, cpm.getPropertyName()), relationParts);
        return (RE) r;
    }
}
