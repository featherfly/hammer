
package cn.featherfly.hammer.sqldb.jdbc.dsl.query;

import java.util.List;

import cn.featherfly.common.db.builder.dml.basic.SqlSelectJoinOnBasicBuilder;
import cn.featherfly.common.lang.Lang;
import cn.featherfly.common.lang.function.SerializableFunction;
import cn.featherfly.common.repository.builder.AliasManager;
import cn.featherfly.common.repository.mapping.ClassMapping;
import cn.featherfly.common.repository.mapping.MappingFactory;
import cn.featherfly.common.structure.page.Page;
import cn.featherfly.hammer.dsl.query.RepositoryTypeQueryConditionGroupExpression;
import cn.featherfly.hammer.dsl.query.TypeQueryWith;
import cn.featherfly.hammer.dsl.query.TypeQueryWithEntity;
import cn.featherfly.hammer.expression.query.TypeQueryLimitExecutor;
import cn.featherfly.hammer.sqldb.SqldbHammerException;

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
     * Instantiates a new type sql query with.
     *
     * @param sqlQueryEntityProperties  the sql query entity properties
     * @param aliasManager              the alias manager
     * @param factory                   the factory
     * @param conditionTypeClassMapping the condition type class mapping
     * @param conditionTableAlias       the condition table alias
     * @param conditionTableColumn      the condition table column
     * @param joinTypeClassMapping      the join type class mapping
     * @param joinTableColumn           the join table column
     */
    public TypeSqlQueryWith(TypeSqlQueryEntityProperties sqlQueryEntityProperties, AliasManager aliasManager,
            MappingFactory factory, ClassMapping<?> conditionTypeClassMapping, String conditionTableAlias,
            String conditionTableColumn, ClassMapping<?> joinTypeClassMapping, String joinTableColumn) {
        this(sqlQueryEntityProperties, aliasManager, factory, conditionTypeClassMapping, conditionTableAlias,
                conditionTableColumn, joinTypeClassMapping, joinTableColumn, null);
    }

    /**
     * Instantiates a new type sql query with.
     *
     * @param sqlQueryEntityProperties  the sql query entity properties
     * @param aliasManager              the alias manager
     * @param factory                   the factory
     * @param conditionTypeClassMapping the condition type class mapping
     * @param conditionTableAlias       the condition table alias
     * @param conditionTableColumn      the condition table column
     * @param joinTypeClassMapping      the join type class mapping
     * @param joinTableColumn           the join table column
     * @param fetchProperty             the fetch property
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
        if (Lang.isEmpty(fetchProperty)) {
            // TODO 后续细化描述
            throw new SqldbHammerException("can not fetch because there is no relation for find type");
        }
        selectJoinOnBasicBuilder.fetch(fetchProperty, fetchPropertyAlias);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryTypeQueryConditionGroupExpression where() {
        return new RepositoryTypeSqlQueryExpression(sqlQueryEntityProperties.jdbc, factory,
                sqlQueryEntityProperties.aliasManager, sqlQueryEntityProperties.classMapping,
                sqlQueryEntityProperties.selectBuilder);
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
    public TypeQueryLimitExecutor limit(Integer limit) {
        return sqlQueryEntityProperties.limit(limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TypeQueryLimitExecutor limit(Integer offset, Integer limit) {
        return sqlQueryEntityProperties.limit(offset, limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TypeQueryLimitExecutor limit(Page page) {
        return sqlQueryEntityProperties.limit(page);
    }

}
