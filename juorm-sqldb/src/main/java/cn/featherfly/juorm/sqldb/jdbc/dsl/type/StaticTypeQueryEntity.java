
package cn.featherfly.juorm.sqldb.jdbc.dsl.type;

import java.util.List;

import cn.featherfly.common.lang.ClassUtils;
import cn.featherfly.common.structure.page.Page;
import cn.featherfly.juorm.mapping.ClassMapping;
import cn.featherfly.juorm.sqldb.jdbc.dsl.query.SqlQueryConditionGroupExpression;
import cn.featherfly.juorm.sqldb.jdbc.dsl.query.SqlQueryEntityProperties;
import cn.featherfly.juorm.sqldb.jdbc.mapping.ClassMappingUtils;
import cn.featherfly.juorm.sqldb.jdbc.mapping.JdbcMappingFactory;

/**
 * <p>
 * TypeQueryEntity
 * </p>
 * .
 *
 * @author zhongj
 * @param <E> the element type
 * @param <C> the generic type
 * @param <Q> the generic type
 */
public abstract class StaticTypeQueryEntity<E, C extends StaticTypeQueryConditionGroupExpression<E, C>,
        Q extends StaticTypeQueryEntity<E, C, Q>> {

    /** The type. */
    protected Class<E> type;

    /** The query entity properties. */
    private SqlQueryEntityProperties queryEntityProperties;

    /** The set property. */
    protected boolean setProperty;

    /** The mappping. */
    protected ClassMapping<E> mappping;

    /**
     * Instantiates a new type query entity.
     *
     * @param queryEntityProperties the query entity properties
     * @param mappingFactory        the mapping factory
     */
    public StaticTypeQueryEntity(SqlQueryEntityProperties queryEntityProperties, JdbcMappingFactory mappingFactory) {
        type = ClassUtils.getSuperClassGenricType(this.getClass());
        this.queryEntityProperties = queryEntityProperties;
        mappping = mappingFactory.getClassMapping(type);
    }

    /**
     * Where.
     *
     * @return the c
     */
    public C where() {
        setProperties();
        return createCondition((SqlQueryConditionGroupExpression) queryEntityProperties.where());
    }

    /**
     * List.
     *
     * @return the list
     */
    public List<E> list() {
        setProperties();
        return queryEntityProperties.list(type);
    }

    /**
     * Limit.
     *
     * @param limit the limit
     * @return the type query executor
     */
    public StaticTypeQueryExecutor<E> limit(Integer limit) {
        setProperties();
        return new StaticTypeQueryExecutor<>(type, queryEntityProperties.limit(limit));
    }

    /**
     * Limit.
     *
     * @param offset the offset
     * @param limit  the limit
     * @return the type query executor
     */
    public StaticTypeQueryExecutor<E> limit(Integer offset, Integer limit) {
        setProperties();
        return new StaticTypeQueryExecutor<>(type, queryEntityProperties.limit(offset, limit));
    }

    /**
     * Limit.
     *
     * @param page the page
     * @return the type query executor
     */
    public StaticTypeQueryExecutor<E> limit(Page page) {
        setProperties();
        return new StaticTypeQueryExecutor<>(type, queryEntityProperties.limit(page));
    }

    /**
     * Sets the properties.
     */
    private void setProperties() {
        if (!setProperty) {
            System.out.println(ClassMappingUtils.getSelectColumns(mappping));
            queryEntityProperties.propertyAlias(ClassMappingUtils.getSelectColumns(mappping));
        }
    }

    /**
     * Creates the condition.
     *
     * @param queryConditionGroupExpression the query condition group expression
     * @return the c
     */
    protected abstract C createCondition(SqlQueryConditionGroupExpression queryConditionGroupExpression);
}
