
package cn.featherfly.hammer.sqldb.jdbc.dsl.query;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

import cn.featherfly.common.db.mapping.JdbcClassMapping;
import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.common.db.mapping.JdbcPropertyMapping;
import cn.featherfly.common.lang.ClassUtils;
import cn.featherfly.common.lang.LambdaUtils;
import cn.featherfly.common.lang.LambdaUtils.SerializedLambdaInfo;
import cn.featherfly.common.lang.function.SerializableFunction;
import cn.featherfly.common.lang.function.SerializableFunction2;
import cn.featherfly.common.lang.function.SerializableFunction3;
import cn.featherfly.common.repository.builder.AliasManager;
import cn.featherfly.common.repository.mapping.PropertyMapping;
import cn.featherfly.common.structure.page.Page;
import cn.featherfly.hammer.dsl.query.type.EntityQueryConditionGroupExpression;
import cn.featherfly.hammer.dsl.query.type.EntityQueryConditionGroupLogicExpression;
import cn.featherfly.hammer.dsl.query.type.EntityQueryEntityProperties;
import cn.featherfly.hammer.expression.condition.ConditionGroupConfig;
import cn.featherfly.hammer.expression.query.type.EntityQueryLimitExecutor;
import cn.featherfly.hammer.expression.query.type.EntityQueryRelationEntityExpression;
import cn.featherfly.hammer.expression.query.type.EntityQueryRelationExpression;
import cn.featherfly.hammer.sqldb.SqldbHammerException;
import cn.featherfly.hammer.sqldb.jdbc.Jdbc;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;

/**
 * EntitySqlQueryEntityProperties.
 *
 * @author zhongj
 * @param <E> the element type
 */
public class EntitySqlQueryEntityProperties<E>
        extends AbstractEntitySqlQueryEntityProperties<E, EntitySqlQueryEntityProperties<E>>
        implements EntitySqlQueryEntity<E>, EntityQueryEntityProperties<E> {

    // YUFEI_TODO 目前都是join 查询对象，需要join join的对象后续再来实现
    /** The type sql query withs. */
    List<AbstractEntitySqlQueryRelation<E, ?, ?>> sqlQueryRelations = new ArrayList<>();

    /**
     * Instantiates a new type sql query entity properties.
     *
     * @param jdbc           jdbc
     * @param classMapping   classMapping
     * @param factory        the factory
     * @param sqlPageFactory the sql page factory
     * @param aliasManager   aliasManager
     * @param ignorePolicy   the ignore policy
     */
    public EntitySqlQueryEntityProperties(Jdbc jdbc, JdbcClassMapping<E> classMapping, JdbcMappingFactory factory,
            SqlPageFactory sqlPageFactory, AliasManager aliasManager, Predicate<Object> ignorePolicy) {
        super(jdbc, classMapping, factory, sqlPageFactory, aliasManager, ignorePolicy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQueryConditionGroupExpression<E> where() {
        return new EntitySqlQueryExpression<>(jdbc, classMapping, this, factory, sqlPageFactory, aliasManager,
                selectBuilder, ignorePolicy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQueryConditionGroupExpression<E> where(
            Consumer<ConditionGroupConfig<EntityQueryConditionGroupExpression<E>>> consumer) {
        EntitySqlQueryExpression<E> entitySqlQueryExpression = new EntitySqlQueryExpression<>(jdbc, classMapping, this,
                factory, sqlPageFactory, aliasManager, selectBuilder, ignorePolicy);
        if (consumer != null) {
            consumer.accept(entitySqlQueryExpression);
        }
        return entitySqlQueryExpression;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<E> list() {
        return new EntitySqlQueryExpression<>(jdbc, classMapping, this, factory, sqlPageFactory, aliasManager,
                selectBuilder, ignorePolicy).list();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQueryLimitExecutor<E> limit(Integer limit) {
        return new EntitySqlQueryExpression<>(jdbc, classMapping, this, factory, sqlPageFactory, aliasManager,
                selectBuilder, ignorePolicy).limit(limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQueryLimitExecutor<E> limit(Integer offset, Integer limit) {
        return new EntitySqlQueryExpression<>(jdbc, classMapping, this, factory, sqlPageFactory, aliasManager,
                selectBuilder, ignorePolicy).limit(offset, limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQueryLimitExecutor<E> limit(Page page) {
        return new EntitySqlQueryExpression<>(jdbc, classMapping, this, factory, sqlPageFactory, aliasManager,
                selectBuilder, ignorePolicy).limit(page);
    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public Long count() {
    //        return new SqlQueryExpression(jdbc, sqlPageFactory, classMapping,
    //                selectBuilder.addColumn(Chars.STAR, AggregateFunction.COUNT), ignorePolicy).longInt();
    //    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <RE extends EntityQueryRelationEntityExpression<E, R, EntityQueryConditionGroupExpression<E>, EntityQueryConditionGroupLogicExpression<E>>,
    //            R> RE join(SerializableSupplier<R> propertyName) {
    //        SerializedLambdaInfo joinInfo = LambdaUtils.getLambdaInfo(propertyName);
    //        return join(joinInfo);
    //    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public <RE extends EntityQueryRelationEntityExpression<E, R, EntityQueryEntityProperties<E>, QR, EntityQueryConditionGroupExpression<E>, EntityQueryConditionGroupLogicExpression<E>>,
            QR extends EntityQueryRelationExpression<E, R, EntityQueryEntityProperties<E>, EntityQueryConditionGroupExpression<E>, EntityQueryConditionGroupLogicExpression<E>>,
            R> RE join(SerializableFunction<E, R> propertyName) {
        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(propertyName);
        JdbcClassMapping<R> joinTypeMapping = factory.getClassMapping((Class<R>) info.getPropertyType());
        JdbcPropertyMapping cpm = classMapping.getPropertyMapping(info.getPropertyName());
        // E(column) fk R(pk)
        return (RE) new EntitySqlQueryRelation<>(this, classMapping, tableAlias, cpm.getRepositoryFieldName(),
                joinTypeMapping, joinTypeMapping.getPrivaryKeyPropertyMappings().get(0).getRepositoryFieldName(),
                cpm.getPropertyName(), ignorePolicy);

        //        EntitySqlQueryEntityProperties<E> sqlQueryEntityProperties, AliasManager aliasManager,
        //        JdbcMappingFactory factory, SqlPageFactory sqlPageFactory, JdbcClassMapping<E> conditionTypeClassMapping,
        //        String conditionTableAlias, String conditionTableColumn, JdbcClassMapping<R1> joinTypeClassMapping,
        //        String joinTableColumn, Predicate<Object> ignorePolicy

        //        return (RE) _join(propertyName);
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public <RE extends EntityQueryRelationEntityExpression<E, R, EntityQueryEntityProperties<E>, QR, EntityQueryConditionGroupExpression<E>, EntityQueryConditionGroupLogicExpression<E>>,
            QR extends EntityQueryRelationExpression<E, R, EntityQueryEntityProperties<E>, EntityQueryConditionGroupExpression<E>, EntityQueryConditionGroupLogicExpression<E>>,
            R> RE join(SerializableFunction2<R, E> propertyName) {
        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(propertyName);
        JdbcClassMapping<E> joinTypeMapping = factory
                .getClassMapping((Class<E>) ClassUtils.forName(info.getMethodInstanceClassName()));
        // R(column) fk E(pk)
        return (RE) new EntitySqlQueryRelation<>(this, classMapping, tableAlias,
                classMapping.getPrivaryKeyPropertyMappings().get(0).getRepositoryFieldName(), joinTypeMapping,
                joinTypeMapping.getPropertyMapping(info.getPropertyName()).getRepositoryFieldName(), null, // YUFEI_TODO 后续来考虑是否需要强制获取
                ignorePolicy);

    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public <RE extends EntityQueryRelationEntityExpression<E, E, EntityQueryEntityProperties<E>, QR, EntityQueryConditionGroupExpression<E>, EntityQueryConditionGroupLogicExpression<E>>,
            QR extends EntityQueryRelationExpression<E, E, EntityQueryEntityProperties<E>, EntityQueryConditionGroupExpression<E>, EntityQueryConditionGroupLogicExpression<E>>> RE join(
                    SerializableFunction3<E, E> propertyName) {
        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(propertyName);
        JdbcClassMapping<E> joinTypeMapping = classMapping;
        JdbcPropertyMapping cpm = classMapping.getPropertyMapping(info.getPropertyName());
        // E(column) fk E(pk)
        return (RE) new EntitySqlQueryRelation<>(this, classMapping, tableAlias, cpm.getRepositoryFieldName(),
                joinTypeMapping, joinTypeMapping.getPrivaryKeyPropertyMappings().get(0).getRepositoryFieldName(),
                cpm.getPropertyName(), ignorePolicy);
    }

    //    <T, R> EntitySqlQueryRelation<E, R> with(SerializableFunction<T, R> propertyName, int index) {
    //        if (index <= 0) {
    //            throw new SqldbHammerException("index must > 0");
    //        }
    //        if (index > sqlQueryRelations.size()) {
    //            throw new SqldbHammerException("index must < invoke with method times");
    //        }
    //        SerializedLambdaInfo joinInfo = LambdaUtils.getLambdaInfo(propertyName);
    //        AbstractEntitySqlQueryRelation with = sqlQueryRelations.get(index - 1);
    //        // IMPLSOON join
    //        //        return with(with.joinTypeClassMapping, with.joinTableAlias, joinInfo);
    //        return null;
    //    }

    //    private <R> EntitySqlQueryRelation<E, R> _join(SerializableFunction<E, R> propertyName) {
    //        EntitySqlQueryWith<E> typeSqlQueryWith = with(classMapping, selectBuilder.getTableAlias(), joinInfo);
    //      IMPLSOON 后续来实现，先让编译通过
    //        SerializedLambdaInfo joinInfo = LambdaUtils.getLambdaInfo(propertyName);
    //        @SuppressWarnings("unchecked")
    //        EntitySqlQueryRelation<E, R> typeSqlQueryWith = join(classMapping, tableAlias, joinInfo,
    //                (Class<R>) joinInfo.getPropertyType());
    //        if (typeSqlQueryWith != null) {
    //            return typeSqlQueryWith;
    //        }
    //
    //        for (EntitySqlQueryRelation<E, ?> with : sqlQueryRelations) {
    //            if (classMapping != with.joinTypeClassMapping) {
    //                typeSqlQueryWith = join(with.joinTypeClassMapping, with.joinTableAlias, joinInfo);
    //                if (typeSqlQueryWith != null) {
    //                    return typeSqlQueryWith;
    //                }
    //            }
    //            if (classMapping != with.conditionTypeClassMapping) {
    //                typeSqlQueryWith = join(with.conditionTypeClassMapping, with.conditionTableAlias, joinInfo);
    //                if (typeSqlQueryWith != null) {
    //                    return typeSqlQueryWith;
    //                }
    //            }
    //        }
    //        throw new SqldbHammerException("there is no relation find for lambda property -> "
    //                + joinInfo.getMethodInstanceClassName() + "." + joinInfo.getMethodName());

    //        return null;
    //    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <R> EntityQueryRelationEntity<E> join(SerializableFunction<E, R> propertyName, int index) {
    //        if (index <= 0) {
    //            throw new SqldbHammerException("index must > 0");
    //        }
    //        if (index > entitySqlQueryWiths.size()) {
    //            throw new SqldbHammerException("index must < invoke with method times");
    //        }
    //        SerializedLambdaInfo joinInfo = LambdaUtils.getLambdaInfo(propertyName);
    //        EntitySqlQueryWith<?> with = entitySqlQueryWiths.get(index - 1);
    //        return join(with.joinTypeClassMapping, with.joinTableAlias, joinInfo);
    //    }

    //    private <R> EntitySqlQueryRelation<E, R> join(JdbcClassMapping<E> cm, String tableAlias,
    //            SerializedLambdaInfo joinInfo, Class<R> joinType) {
    //        String name = joinInfo.getPropertyName();
    //        if (cm.getType().getName().equals(joinInfo.getMethodInstanceClassName())) {
    //            // 表示是查找对象的属性，可以连表查询，也可以查询返回到查询对象的指定属性上
    //            JdbcClassMapping<?> joinClassMapping = factory.getClassMapping(joinInfo.getPropertyType());
    //            PropertyMapping pm = cm.getPropertyMapping(name);
    //            EntitySqlQueryRelation<E, ?> typeSqlQueryWith = new EntitySqlQueryRelation<>(this, aliasManager, factory,
    //                    sqlPageFactory, cm, tableAlias, pm.getRepositoryFieldName(), joinClassMapping,
    //                    getPkMapping(joinClassMapping).getRepositoryFieldName(), name, ignorePolicy);
    //            sqlQueryRelations.add(typeSqlQueryWith);
    //            // IMPLSOON 后续来处理类型
    //            return (EntitySqlQueryRelation<E, R>) typeSqlQueryWith;
    //        } else if (ClassUtils.isParent(cm.getType(), joinInfo.getPropertyType())) {
    //            // 表示是查找对象是with对象的属性，可以进行连表查询，但是不能返回到查询对象上，因为没有指明返回对象属性
    //            JdbcClassMapping<?> joinClassMapping = factory
    //                    .getClassMapping(ClassUtils.forName(joinInfo.getMethodInstanceClassName()));
    //            PropertyMapping pm = joinClassMapping.getPropertyMapping(name);
    //
    //            EntitySqlQueryRelation<E, ?> typeSqlQueryWith = new EntitySqlQueryRelation<>(this, aliasManager, factory,
    //                    sqlPageFactory, cm, tableAlias, getIdName(), joinClassMapping, pm.getRepositoryFieldName(),
    //                    ignorePolicy);
    //            sqlQueryRelations.add(typeSqlQueryWith);
    //            // IMPLSOON 后续来处理类型
    //            return (EntitySqlQueryRelation<E, R>) typeSqlQueryWith;
    //        } else {
    //            return null;
    //        }
    //    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected String getIdName() {
        return getPkMapping(classMapping).getRepositoryFieldName();
    }

    private PropertyMapping<?> getPkMapping(JdbcClassMapping<?> classMapping) {
        if (classMapping.getPrivaryKeyPropertyMappings().size() > 1) {
            throw new SqldbHammerException(String.format("there is more than one privary key property in type(%s)",
                    classMapping.getType().getName()));
        } else if (classMapping.getPrivaryKeyPropertyMappings().size() == 0) {
            throw new SqldbHammerException(
                    String.format("there is no privary key property in type(%s)", classMapping.getType().getName()));
        }
        return classMapping.getPrivaryKeyPropertyMappings().get(0);
    }
}
