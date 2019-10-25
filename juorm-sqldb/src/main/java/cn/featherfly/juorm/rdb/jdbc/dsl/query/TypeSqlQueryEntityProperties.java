
package cn.featherfly.juorm.rdb.jdbc.dsl.query;

import java.util.ArrayList;
import java.util.List;

import cn.featherfly.common.lang.ClassUtils;
import cn.featherfly.common.lang.LambdaUtils;
import cn.featherfly.common.lang.LambdaUtils.SerializedLambdaInfo;
import cn.featherfly.common.lang.function.SerializableFunction;
import cn.featherfly.common.structure.page.Page;
import cn.featherfly.juorm.dml.AliasManager;
import cn.featherfly.juorm.dsl.query.TypeQueryConditionGroupExpression;
import cn.featherfly.juorm.dsl.query.TypeQueryEntityProperties;
import cn.featherfly.juorm.dsl.query.TypeQueryWithEntity;
import cn.featherfly.juorm.expression.query.TypeQueryExecutor;
import cn.featherfly.juorm.mapping.ClassMapping;
import cn.featherfly.juorm.mapping.MappingFactory;
import cn.featherfly.juorm.mapping.PropertyMapping;
import cn.featherfly.juorm.rdb.jdbc.Jdbc;
import cn.featherfly.juorm.rdb.jdbc.JuormJdbcException;

/**
 * <p>
 * SqlQueryProperties
 * </p>
 *
 * @author zhongj
 */
public class TypeSqlQueryEntityProperties extends AbstractSqlQueryEntityProperties<TypeSqlQueryEntityProperties>
        implements TypeSqlQueryEntity, TypeQueryEntityProperties {

    List<TypeSqlQueryWith> typeSqlQueryWiths = new ArrayList<>();

    /**
     * @param jdbc         jdbc
     * @param classMapping classMapping
     * @param aliasManager aliasManager
     */
    public TypeSqlQueryEntityProperties(Jdbc jdbc, ClassMapping<?> classMapping, MappingFactory factory,
            AliasManager aliasManager) {
        super(jdbc, classMapping, factory, aliasManager);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TypeQueryConditionGroupExpression where() {
        return new TypeSqlQueryExpression(jdbc, classMapping, selectBuilder);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> List<E> list() {
        return new TypeSqlQueryExpression(jdbc, classMapping, selectBuilder).list();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TypeQueryExecutor limit(Integer limit) {
        return new TypeSqlQueryExpression(jdbc, classMapping, selectBuilder).limit(limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TypeQueryExecutor limit(Integer offset, Integer limit) {
        return new TypeSqlQueryExpression(jdbc, classMapping, selectBuilder).limit(offset, limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TypeQueryExecutor limit(Page page) {
        return new TypeSqlQueryExpression(jdbc, classMapping, selectBuilder).limit(page);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> TypeQueryWithEntity with(SerializableFunction<T, R> propertyName) {
        SerializedLambdaInfo joinInfo = LambdaUtils.getLambdaInfo(propertyName);
        TypeSqlQueryWith typeSqlQueryWith = with(classMapping, selectBuilder.getTableAlias(), joinInfo);
        if (typeSqlQueryWith != null) {
            return typeSqlQueryWith;
        }

        for (TypeSqlQueryWith with : typeSqlQueryWiths) {
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
        throw new JuormJdbcException("there is no relation find for lambda property -> "
                + joinInfo.getMethodInstanceClassName() + "." + joinInfo.getMethodName());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> TypeQueryWithEntity with(SerializableFunction<T, R> propertyName, int index) {
        if (index <= 0) {
            throw new JuormJdbcException("index must > 0");
        }
        if (index > typeSqlQueryWiths.size()) {
            throw new JuormJdbcException("index must < invoke with method times");
        }
        SerializedLambdaInfo joinInfo = LambdaUtils.getLambdaInfo(propertyName);
        TypeSqlQueryWith with = typeSqlQueryWiths.get(index - 1);
        return with(with.joinTypeClassMapping, with.joinTableAlias, joinInfo);
    }

    private TypeSqlQueryWith with(ClassMapping<?> cm, String tableAlias, SerializedLambdaInfo joinInfo) {
        String name = LambdaUtils.getLambdaPropertyName(joinInfo.getSerializedLambda());
        if (cm.getType().getName().equals(joinInfo.getMethodInstanceClassName())) {
            // 表示是查找对象的属性，可以连表查询，也可以查询返回到查询对象的指定属性上
            ClassMapping<?> joinClassMapping = factory.getClassMapping(joinInfo.getMethod().getReturnType());
            PropertyMapping pm = cm.getPropertyMapping(name);
            TypeSqlQueryWith typeSqlQueryWith = new TypeSqlQueryWith(this, aliasManager, factory, cm, tableAlias,
                    pm.getRepositoryFieldName(), joinClassMapping,
                    getPkMapping(joinClassMapping).getRepositoryFieldName(), name);
            typeSqlQueryWiths.add(typeSqlQueryWith);
            return typeSqlQueryWith;
        } else if (ClassUtils.isParent(cm.getType(), joinInfo.getMethod().getReturnType())) {
            // 表示是查找对象是with对象的属性，可以进行连表查询，但是不能返回到查询对象上，因为没有指明返回对象属性
            ClassMapping<?> joinClassMapping = factory
                    .getClassMapping(ClassUtils.forName(joinInfo.getMethodInstanceClassName()));
            PropertyMapping pm = joinClassMapping.getPropertyMapping(name);

            TypeSqlQueryWith typeSqlQueryWith = new TypeSqlQueryWith(this, aliasManager, factory, cm, tableAlias,
                    getIdName(), joinClassMapping, pm.getRepositoryFieldName());
            typeSqlQueryWiths.add(typeSqlQueryWith);
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
            throw new JuormJdbcException(String.format("there is more than one privary key property in type(%s)",
                    classMapping.getType().getName()));
        } else if (classMapping.getPrivaryKeyPropertyMappings().size() == 0) {
            throw new JuormJdbcException(
                    String.format("there is no privary key property in type(%s)", classMapping.getType().getName()));
        }
        return classMapping.getPrivaryKeyPropertyMappings().get(0);
    }

}
