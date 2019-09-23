
package cn.featherfly.juorm.rdb.jdbc.dsl.query;

import java.util.List;

import cn.featherfly.common.lang.LangUtils;
import cn.featherfly.common.lang.function.SerializableFunction;
import cn.featherfly.common.structure.page.Page;
import cn.featherfly.juorm.dml.AliasManager;
import cn.featherfly.juorm.dsl.query.TypeQueryConditionGroupExpression;
import cn.featherfly.juorm.dsl.query.TypeQueryWith;
import cn.featherfly.juorm.dsl.query.TypeQueryWithEntity;
import cn.featherfly.juorm.expression.query.TypeQueryExecutor;
import cn.featherfly.juorm.mapping.ClassMapping;
import cn.featherfly.juorm.mapping.MappingFactory;
import cn.featherfly.juorm.rdb.jdbc.JuormJdbcException;
import cn.featherfly.juorm.rdb.sql.dml.builder.basic.SqlSelectJoinOnBasicBuilder;

/**
 * <p>
 * SqlQueryWith
 * </p>
 *
 * @author zhongj
 */
public class TypeSqlQueryWith implements TypeQueryWith, TypeQueryWithEntity {

    protected TypeSqlQueryEntityProperties sqlQueryEntityProperties;

    protected String conditionTableAlias;

    protected String conditionTableColumn;

    protected String joinTableAlias;

    protected String joinTableColumn;

    protected SqlSelectJoinOnBasicBuilder selectJoinOnBasicBuilder;

    protected MappingFactory factory;

    protected ClassMapping<?> conditionTypeClassMapping;

    protected ClassMapping<?> joinTypeClassMapping;

    protected String fetchProperty;

    protected String fetchPropertyAlias;

    /**
     * @param sqlQueryEntityProperties
     * @param aliasManager
     * @param factory
     * @param conditionTypeClassMapping
     * @param conditionTableAlias
     * @param conditionTableColumn
     * @param joinTypeClassMapping
     * @param joinTableColumn
     */
    public TypeSqlQueryWith(TypeSqlQueryEntityProperties sqlQueryEntityProperties, AliasManager aliasManager,
            MappingFactory factory, ClassMapping<?> conditionTypeClassMapping, String conditionTableAlias,
            String conditionTableColumn, ClassMapping<?> joinTypeClassMapping, String joinTableColumn) {
        this(sqlQueryEntityProperties, aliasManager, factory, conditionTypeClassMapping, conditionTableAlias,
                conditionTableColumn, joinTypeClassMapping, joinTableColumn, null);
    }

    /**
     * @param sqlQueryEntityProperties
     * @param aliasManager
     * @param factory
     * @param conditionTypeClassMapping
     * @param conditionTableAlias
     * @param conditionTableColumn
     * @param joinTypeClassMapping
     * @param joinTableColumn
     * @param fetchProperty
     */
    public TypeSqlQueryWith(TypeSqlQueryEntityProperties sqlQueryEntityProperties, AliasManager aliasManager,
            MappingFactory factory, ClassMapping<?> conditionTypeClassMapping, String conditionTableAlias,
            String conditionTableColumn, ClassMapping<?> joinTypeClassMapping, String joinTableColumn,
            String fetchProperty) {
        super();
        this.sqlQueryEntityProperties = sqlQueryEntityProperties;
        this.factory = factory;
        this.conditionTypeClassMapping = conditionTypeClassMapping;
        this.conditionTableAlias = conditionTableAlias;
        this.conditionTableColumn = conditionTableColumn;
        joinTableAlias = aliasManager.put(joinTypeClassMapping.getRepositoryName());
        this.joinTableColumn = joinTableColumn;
        this.joinTypeClassMapping = joinTypeClassMapping;
        this.fetchProperty = fetchProperty;
        fetchPropertyAlias = joinTableAlias;
        on();
    }

    private TypeQueryWithEntity on() {
        selectJoinOnBasicBuilder = sqlQueryEntityProperties.getSelectBuilder().join(conditionTableAlias,
                conditionTableColumn, joinTypeClassMapping, joinTableAlias, joinTableColumn);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> TypeQueryWithEntity with(SerializableFunction<T, R> propertyName) {
        return sqlQueryEntityProperties.with(propertyName);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> TypeQueryWithEntity with(SerializableFunction<T, R> propertyName, int index) {
        return sqlQueryEntityProperties.with(propertyName, index);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TypeQueryWith fetch() {
        if (LangUtils.isEmpty(fetchProperty)) {
            // TODO 后续细化描述
            throw new JuormJdbcException("can not fetch because there is no relation for find type");
        }
        selectJoinOnBasicBuilder.fetch(fetchProperty, fetchPropertyAlias);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TypeQueryConditionGroupExpression where() {
        return sqlQueryEntityProperties.where();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> List<E> list() {
        return sqlQueryEntityProperties.list();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TypeQueryExecutor limit(Integer limit) {
        return sqlQueryEntityProperties.limit(limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TypeQueryExecutor limit(Integer offset, Integer limit) {
        return sqlQueryEntityProperties.limit(offset, limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TypeQueryExecutor limit(Page page) {
        return sqlQueryEntityProperties.limit(page);
    }

}
