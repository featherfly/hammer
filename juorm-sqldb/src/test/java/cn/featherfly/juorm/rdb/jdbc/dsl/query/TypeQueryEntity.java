
package cn.featherfly.juorm.rdb.jdbc.dsl.query;

import java.util.List;

import cn.featherfly.common.lang.ClassUtils;
import cn.featherfly.common.structure.page.Page;
import cn.featherfly.juorm.rdb.jdbc.mapping.ClassMapping;
import cn.featherfly.juorm.rdb.jdbc.mapping.ClassMappingUtils;
import cn.featherfly.juorm.rdb.jdbc.mapping.MappingFactory;

/**
 * <p>
 * TypeQueryEntity
 * </p>
 *
 * @author zhongj
 */
public abstract class TypeQueryEntity<E,
        C extends TypeQueryConditionGroupExpression<E, C>,
        Q extends TypeQueryEntity<E, C, Q>> {

    protected Class<E> type;

    private SqlQueryEntityProperties queryEntityProperties;

    protected boolean setProperty;

    protected ClassMapping<E> mappping;

    /**
     */
    public TypeQueryEntity(SqlQueryEntityProperties queryEntityProperties,
            MappingFactory mappingFactory) {
        type = ClassUtils.getSuperClassGenricType(this.getClass());
        this.queryEntityProperties = queryEntityProperties;
        mappping = mappingFactory.getClassMapping(type);
    }

    public C where() {
        setProperties();
        return createCondition(
                (SqlQueryConditionGroupExpression) queryEntityProperties
                        .where());
    }

    public List<E> list() {
        setProperties();
        return queryEntityProperties.list(type);
    }

    public TypeQueryExecutor<E> limit(Integer limit) {
        setProperties();
        return new TypeQueryExecutor<>(type,
                queryEntityProperties.limit(limit));
    }

    public TypeQueryExecutor<E> limit(Integer offset, Integer limit) {
        setProperties();
        return new TypeQueryExecutor<>(type,
                queryEntityProperties.limit(offset, limit));
    }

    public TypeQueryExecutor<E> limit(Page page) {
        setProperties();
        return new TypeQueryExecutor<>(type, queryEntityProperties.limit(page));
    }

    private void setProperties() {
        if (!setProperty) {
            System.out.println(ClassMappingUtils.getSelectColumns(mappping));
            queryEntityProperties
                    .property(ClassMappingUtils.getSelectColumns(mappping));
        }
    }

    protected abstract C createCondition(
            SqlQueryConditionGroupExpression queryConditionGroupExpression);
}
