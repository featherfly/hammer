
package cn.featherfly.hammer.sqldb.jdbc.dsl.query;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

import cn.featherfly.common.lang.ClassUtils;
import cn.featherfly.common.lang.LambdaUtils;
import cn.featherfly.common.lang.LambdaUtils.SerializedLambdaInfo;
import cn.featherfly.common.lang.function.SerializableFunction;
import cn.featherfly.common.lang.function.SerializableFunction2;
import cn.featherfly.common.lang.function.SerializableFunction3;
import cn.featherfly.common.lang.function.SerializableSupplier;
import cn.featherfly.common.repository.builder.AliasManager;
import cn.featherfly.common.repository.mapping.ClassMapping;
import cn.featherfly.common.repository.mapping.MappingFactory;
import cn.featherfly.common.repository.mapping.PropertyMapping;
import cn.featherfly.common.structure.page.Page;
import cn.featherfly.hammer.dsl.query.EntityQueryConditionGroupExpression;
import cn.featherfly.hammer.dsl.query.EntityQueryEntityProperties;
import cn.featherfly.hammer.dsl.query.EntityQueryWithEntity;
import cn.featherfly.hammer.expression.condition.ConditionGroupConfig;
import cn.featherfly.hammer.expression.query.EntityQueryLimitExecutor;
import cn.featherfly.hammer.sqldb.SqldbHammerException;
import cn.featherfly.hammer.sqldb.jdbc.Jdbc;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;

/**
 * EntitySqlQueryEntityProperties.
 *
 * @author zhongj
 */
public class EntitySqlQueryEntityProperties<E>
        extends AbstractEntitySqlQueryEntityProperties<E, EntitySqlQueryEntityProperties<E>>
        implements EntitySqlQueryEntity<E>, EntityQueryEntityProperties<E> {

    /** The type sql query withs. */
    List<EntitySqlQueryWith<?>> entitySqlQueryWiths = new ArrayList<>();

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
    public EntitySqlQueryEntityProperties(Jdbc jdbc, ClassMapping<?> classMapping, MappingFactory factory,
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

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> EntityQueryWithEntity<E> with(SerializableSupplier<T> propertyName) {
        SerializedLambdaInfo joinInfo = LambdaUtils.getLambdaInfo(propertyName);
        return with(joinInfo);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> EntityQueryWithEntity<E> with(SerializableFunction2<R, E> propertyName) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQueryWithEntity<E> with(SerializableFunction3<E, E> propertyName) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> EntityQueryWithEntity<E> with(SerializableFunction<E, R> propertyName) {
        SerializedLambdaInfo joinInfo = LambdaUtils.getLambdaInfo(propertyName);
        return with(joinInfo);
    }

    private EntityQueryWithEntity<E> with(SerializedLambdaInfo joinInfo) {
        //        EntitySqlQueryWith<E> typeSqlQueryWith = with(classMapping, selectBuilder.getTableAlias(), joinInfo);
        //      IMPLSOON 后续来实现，先让编译通过
        EntitySqlQueryWith<E> typeSqlQueryWith = with(classMapping, "", joinInfo);
        if (typeSqlQueryWith != null) {
            return typeSqlQueryWith;
        }

        for (EntitySqlQueryWith<?> with : entitySqlQueryWiths) {
            if (classMapping != with.joinTypeClassMapping) {
                typeSqlQueryWith = with(with.joinTypeClassMapping, with.joinTableAlias, joinInfo);
                if (typeSqlQueryWith != null) {
                    return typeSqlQueryWith;
                }
            }
            if (classMapping != with.conditionTypeClassMapping) {
                typeSqlQueryWith = with(with.conditionTypeClassMapping, with.conditionTableAlias, joinInfo);
                if (typeSqlQueryWith != null) {
                    return typeSqlQueryWith;
                }
            }
        }
        throw new SqldbHammerException("there is no relation find for lambda property -> "
                + joinInfo.getMethodInstanceClassName() + "." + joinInfo.getMethodName());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> EntityQueryWithEntity<E> with(SerializableFunction<E, R> propertyName, int index) {
        if (index <= 0) {
            throw new SqldbHammerException("index must > 0");
        }
        if (index > entitySqlQueryWiths.size()) {
            throw new SqldbHammerException("index must < invoke with method times");
        }
        SerializedLambdaInfo joinInfo = LambdaUtils.getLambdaInfo(propertyName);
        EntitySqlQueryWith<?> with = entitySqlQueryWiths.get(index - 1);
        return with(with.joinTypeClassMapping, with.joinTableAlias, joinInfo);
    }

    private EntitySqlQueryWith<E> with(ClassMapping<?> cm, String tableAlias, SerializedLambdaInfo joinInfo) {
        String name = joinInfo.getPropertyName();
        if (cm.getType().getName().equals(joinInfo.getMethodInstanceClassName())) {
            // 表示是查找对象的属性，可以连表查询，也可以查询返回到查询对象的指定属性上
            ClassMapping<?> joinClassMapping = factory.getClassMapping(joinInfo.getPropertyType());
            PropertyMapping pm = cm.getPropertyMapping(name);
            EntitySqlQueryWith<E> typeSqlQueryWith = new EntitySqlQueryWith<>(this, aliasManager, factory,
                    sqlPageFactory, cm, tableAlias, pm.getRepositoryFieldName(), joinClassMapping,
                    getPkMapping(joinClassMapping).getRepositoryFieldName(), name, ignorePolicy);
            entitySqlQueryWiths.add(typeSqlQueryWith);
            return typeSqlQueryWith;
        } else if (ClassUtils.isParent(cm.getType(), joinInfo.getPropertyType())) {
            // 表示是查找对象是with对象的属性，可以进行连表查询，但是不能返回到查询对象上，因为没有指明返回对象属性
            ClassMapping<?> joinClassMapping = factory
                    .getClassMapping(ClassUtils.forName(joinInfo.getMethodInstanceClassName()));
            PropertyMapping pm = joinClassMapping.getPropertyMapping(name);

            EntitySqlQueryWith<E> typeSqlQueryWith = new EntitySqlQueryWith<>(this, aliasManager, factory,
                    sqlPageFactory, cm, tableAlias, getIdName(), joinClassMapping, pm.getRepositoryFieldName(),
                    ignorePolicy);
            entitySqlQueryWiths.add(typeSqlQueryWith);
            return typeSqlQueryWith;
        } else {
            return null;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected String getIdName() {
        return getPkMapping(classMapping).getRepositoryFieldName();
    }

    private PropertyMapping getPkMapping(ClassMapping<?> classMapping) {
        if (classMapping.getPrivaryKeyPropertyMappings().size() > 1) {
            throw new SqldbHammerException(String.format("there is more than one privary key property in type(%s)",
                    classMapping.getType().getName()));
        } else if (classMapping.getPrivaryKeyPropertyMappings().size() == 0) {
            throw new SqldbHammerException(
                    String.format("there is no privary key property in type(%s)", classMapping.getType().getName()));
        }
        return classMapping.getPrivaryKeyPropertyMappings().get(0);
    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <R> EntityQueryEntityProperties<E> id(SerializableFunction<E, R> propertyName) {
    //        // YUFEI_TODO Auto-generated method stub
    //        return null;
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <R> EntityQueryEntityProperties<E> property(SerializableFunction<E, R> propertyName) {
    //        // YUFEI_TODO Auto-generated method stub
    //        return null;
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <R> EntityQueryEntityProperties<E> property(SerializableFunction<E, R>... propertyNames) {
    //        // YUFEI_TODO Auto-generated method stub
    //        return null;
    //    }
}
