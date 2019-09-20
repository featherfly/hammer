
package cn.featherfly.juorm.rdb.jdbc.dsl.query;

import java.util.List;

import cn.featherfly.common.lang.LambdaUtils;
import cn.featherfly.common.lang.function.SerializableFunction;
import cn.featherfly.common.structure.page.Page;
import cn.featherfly.juorm.dml.AliasManager;
import cn.featherfly.juorm.dsl.query.TypeQueryConditionGroupExpression;
import cn.featherfly.juorm.dsl.query.TypeQueryEntityProperties;
import cn.featherfly.juorm.dsl.query.TypeQueryWithOn;
import cn.featherfly.juorm.expression.query.TypeQueryExecutor;
import cn.featherfly.juorm.mapping.ClassMapping;
import cn.featherfly.juorm.mapping.MappingFactory;
import cn.featherfly.juorm.rdb.jdbc.Jdbc;
import cn.featherfly.juorm.rdb.jdbc.mapping.ClassMappingUtils;
import cn.featherfly.juorm.rdb.sql.dml.builder.basic.SqlSelectBasicBuilder;

/**
 * <p>
 * SqlQueryProperties
 * </p>
 *
 * @author zhongj
 */
public class TypeSqlQueryEntityProperties extends AbstractSqlQueryEntityProperties<TypeSqlQueryEntityProperties>
        implements TypeSqlQueryEntity, TypeQueryEntityProperties {

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
    public <T, R> TypeQueryWithOn with(SerializableFunction<T, R> propertyName) {
        return with(LambdaUtils.getLambdaPropertyName(propertyName));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TypeQueryWithOn with(String propertyName) {
        return new TypeSqlQueryWith(this, aliasManager, factory, selectBuilder.getTableAlias(), getIdName(),
                ClassMappingUtils.getColumnName(propertyName, classMapping), aliasManager.put(propertyName));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> TypeQueryWithOn with(Class<T> repositoryType) {
        return new TypeSqlQueryWith(this, aliasManager, factory, selectBuilder.getTableAlias(), getIdName(),
                repositoryType);
    }

    /**
     * 返回selectBuilder
     *
     * @return selectBuilder
     */
    @Override
    SqlSelectBasicBuilder getSelectBuilder() {
        return selectBuilder;
    }
}
