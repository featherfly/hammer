
package cn.featherfly.db.dsl.builder.sql;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import cn.featherfly.common.db.PaginationWrapper;
import cn.featherfly.common.db.dialect.Dialect;
import cn.featherfly.common.lang.ArrayUtils;
import cn.featherfly.common.lang.CollectionUtils;
import cn.featherfly.common.lang.StringUtils;
import cn.featherfly.common.structure.page.Pagination;
import cn.featherfly.db.dsl.builder.BuilderException;
import cn.featherfly.db.dsl.builder.ConditionBuildUtils;
import cn.featherfly.db.dsl.builder.FindBuilder;
import cn.featherfly.db.dsl.builder.QueryBuilder;

/**
 * <p>
 * sql query builder
 * </p>
 *
 * @author zhongj
 */
public class SqlQueryBuilder implements QueryBuilder, cn.featherfly.db.dsl.builder.sql.QueryBuilder {

    private SqlConditionGroup conditionGroup;

    private SqlSortBuilder sortBuilder;

    private SqlFindBuilder findBuilder;

    private SqlSelectBuilder selectBuilder;

    /**
     */
    public SqlQueryBuilder() {
        sortBuilder = new SqlSortBuilder();
        conditionGroup = new SqlConditionGroup(sortBuilder);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String build() {
        StringBuilder result = new StringBuilder();
        if (findBuilder != null) {
            result.append(findBuilder.build());
        } else if (selectBuilder != null) {
            result.append(selectBuilder.build());
        }
        String condition = conditionGroup.build();
        if (StringUtils.isNotBlank(condition)) {
            ConditionBuildUtils.appendCondition(result, "where");
            ConditionBuildUtils.appendCondition(result, condition);
        }
        ConditionBuildUtils.appendCondition(result, sortBuilder.build());

        if (this.pagination != null) {
            if (this.dialect == null) {
                throw new BuilderException("需要分页时，dialect不能为空");
            }
            PaginationWrapper<Object> pw = new PaginationWrapper<Object>(pagination);
            return dialect.getPaginationSql(result.toString(), pw.getStart(), pw.getLimit()).trim();
        } else {
            return result.toString().trim();
        }
    }

    /**
     * <p>
     * 获取查询参数
     * </p>
     * 
     * @return 查询参数
     */
    @SuppressWarnings("unchecked")
    public List<Object> getParams() {
        List<Object> result = new ArrayList<Object>();
        Object param = conditionGroup.getParamValue();
        if (param == null) {
            result.add(param);
        } else if (param instanceof Collection) {
            result.addAll((Collection<Object>) param);
        } else if (param.getClass().isArray()) {
            int length = Array.getLength(param);
            for (int i = 0; i < length; i++) {
                result.add(Array.get(param, i));
            }
        }
        if (this.pagination != null) {
            if (this.dialect == null) {
                throw new BuilderException("需要分页时，dialect不能为空");
            }
            PaginationWrapper<Object> pw = new PaginationWrapper<Object>(pagination);
            Object[] params = dialect.getPaginationSqlParameter(result.toArray(), pw.getStart(), pw.getLimit());
            result.clear();
            CollectionUtils.addAll(result, params);
        }
        return result;
    }

    // ********************************************************************
    // find
    // ********************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    public FindBuilder find(String target) {
        return find(target, null);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public FindBuilder find(String target, String alias) {
        conditionGroup.setQueryAlias(alias);
        findBuilder = new SqlFindBuilder(target, alias, conditionGroup);
        return findBuilder;
    }

    // ********************************************************************
    // select
    // ********************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    public SelectBuilder select(String columnName) {
        return select(new String[] {columnName});
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SelectBuilder select(String... columnNames) {
        return select(ArrayUtils.toList(columnNames));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SelectBuilder select(Collection<String> columnNames) {
        return getSelectBuilder().select(columnNames);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SqlConditionBuilder from(String tableName) {
        return from(tableName, null);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SqlConditionBuilder from(String tableName, String alias) {
        conditionGroup.setQueryAlias(alias);
        return getSelectBuilder().from(tableName, alias);
    }

    // ********************************************************************
    // property
    // ********************************************************************

    private Dialect dialect;

    private Pagination pagination;
        
    /**
     * 返回dialect
     * 
     * @return dialect
     */
    public Dialect getDialect() {
        return dialect;
    }

    /**
     * 设置dialect
     * 
     * @param dialect
     *            dialect
     */
    public void setDialect(Dialect dialect) {
        this.dialect = dialect;
    }

    /**
     * 返回pagination
     * 
     * @return pagination
     */
    public Pagination getPagination() {
        return pagination;
    }

    /**
     * 设置pagination
     * 
     * @param pagination
     *            pagination
     */
    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }
    
    /**
     * 返回selectBuilder
     * @return selectBuilder
     */
    private SqlSelectBuilder getSelectBuilder() {
        if (selectBuilder == null) {
            selectBuilder = new SqlSelectBuilder(conditionGroup);
        }
        return selectBuilder;
    }
}
