
package cn.featherfly.hammer.sqldb.jdbc.dsl.query;

import java.util.Arrays;
import java.util.List;

import cn.featherfly.common.constant.Chars;
import cn.featherfly.common.db.SqlUtils;
import cn.featherfly.common.lang.LambdaUtils;
import cn.featherfly.common.lang.LangUtils;
import cn.featherfly.common.lang.function.SerializableFunction;
import cn.featherfly.common.structure.page.Limit;
import cn.featherfly.common.structure.page.Page;
import cn.featherfly.common.structure.page.PaginationResults;
import cn.featherfly.common.structure.page.SimplePaginationResults;
import cn.featherfly.hammer.dml.AliasManager;
import cn.featherfly.hammer.dsl.query.RepositoryTypeQueryConditionGroupExpression;
import cn.featherfly.hammer.dsl.query.RepositoryTypeQueryConditionGroupLogicExpression;
import cn.featherfly.hammer.dsl.query.TypeQuerySortExpression;
import cn.featherfly.hammer.expression.query.TypeQueryLimitExecutor;
import cn.featherfly.hammer.mapping.ClassMapping;
import cn.featherfly.hammer.mapping.MappingFactory;
import cn.featherfly.hammer.sqldb.jdbc.Jdbc;
import cn.featherfly.hammer.sqldb.jdbc.mapping.ClassMappingUtils;
import cn.featherfly.hammer.sqldb.sql.dml.AbstractRepositorySqlConditionGroupExpression;
import cn.featherfly.hammer.sqldb.sql.dml.builder.SqlSortBuilder;

/**
 * <p>
 * sql condition group builder sql条件逻辑组构造器
 * </p>
 *
 * @author zhongj
 */
public class RepositoryTypeSqlQueryConditionGroupExpression extends
        AbstractRepositorySqlConditionGroupExpression<RepositoryTypeQueryConditionGroupExpression, RepositoryTypeQueryConditionGroupLogicExpression>
        implements RepositoryTypeQueryConditionGroupExpression, RepositoryTypeQueryConditionGroupLogicExpression,
        TypeQuerySortExpression {

    private SqlSortBuilder sortBuilder = new SqlSortBuilder(dialect);

    private Limit limit;

    /**
     * @param jdbc         jdbc
     * @param factory      MappingFactory
     * @param aliasManager aliasManager
     * @param classMapping classMapping
     */
    public RepositoryTypeSqlQueryConditionGroupExpression(Jdbc jdbc, MappingFactory factory, AliasManager aliasManager,
            ClassMapping<?> classMapping) {
        this(jdbc, factory, aliasManager, null, classMapping);
    }

    /**
     * @param jdbc         jdbc
     * @param factory      MappingFactory
     * @param aliasManager aliasManager
     * @param queryAlias   queryAlias
     * @param classMapping classMapping
     */
    public RepositoryTypeSqlQueryConditionGroupExpression(Jdbc jdbc, MappingFactory factory, AliasManager aliasManager,
            String queryAlias, ClassMapping<?> classMapping) {
        this(jdbc, factory, aliasManager, null, queryAlias, classMapping);
    }

    /**
     * @param dialect      dialect
     * @param factory      MappingFactory
     * @param aliasManager aliasManager
     * @param parent       parent group
     * @param queryAlias   queryAlias
     * @param classMapping classMapping
     */
    RepositoryTypeSqlQueryConditionGroupExpression(Jdbc jdbc, MappingFactory factory, AliasManager aliasManager,
            RepositoryTypeQueryConditionGroupLogicExpression parent, String queryAlias, ClassMapping<?> classMapping) {
        super(jdbc.getDialect(), factory, aliasManager, parent, queryAlias, classMapping);
        this.jdbc = jdbc;
    }

    // ********************************************************************
    // property
    // ********************************************************************

    protected Jdbc jdbc;

    /**
     * {@inheritDoc}
     */
    @Override
    protected RepositoryTypeQueryConditionGroupExpression createGroup(
            RepositoryTypeQueryConditionGroupLogicExpression parent, String queryAlias) {
        return new RepositoryTypeSqlQueryConditionGroupExpression(jdbc, factory, aliasManager, parent, queryAlias,
                classMapping);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String build() {
        String condition = super.build();
        if (parent == null) {
            if (LangUtils.isNotEmpty(condition)) {
                return dialect.getKeywords().where() + Chars.SPACE + super.build() + Chars.SPACE + sortBuilder.build();
            } else {
                return super.build() + Chars.SPACE + sortBuilder.build();
            }
        } else {
            return super.build();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TypeQueryLimitExecutor limit(Integer limit) {
        return limit(0, limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TypeQueryLimitExecutor limit(Integer offset, Integer limit) {
        return limit(new Limit(offset, limit));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TypeQueryLimitExecutor limit(Page page) {
        return limit(new Limit(page));
    }

    private TypeQueryLimitExecutor limit(Limit limit) {
        this.limit = limit;
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public <E> List<E> list() {
        String sql = getRoot().expression();
        Object[] params = getRoot().getParams().toArray();
        if (limit != null) {
            sql = dialect.getPaginationSql(sql, limit.getOffset(), limit.getLimit());
            params = dialect.getPaginationSqlParameter(params, limit.getOffset(), limit.getLimit());
        }
        return (List<E>) jdbc.query(sql, params, classMapping.getType());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> PaginationResults<E> pagination() {
        String sql = getRoot().expression();
        String countSql = SqlUtils.convertSelectToCount(sql);
        Object[] params = getRoot().getParams().toArray();
        SimplePaginationResults<E> pagination = new SimplePaginationResults<>(limit);
        if (limit != null) {
            @SuppressWarnings("unchecked")
            List<E> list = (List<E>) jdbc.query(dialect.getPaginationSql(sql, limit.getOffset(), limit.getLimit()),
                    dialect.getPaginationSqlParameter(params, limit.getOffset(), limit.getLimit()),
                    classMapping.getType());
            pagination.setPageResults(list);
            int total = jdbc.queryInt(countSql, params);
            pagination.setTotal(total);
        } else {
            @SuppressWarnings("unchecked")
            List<E> list = (List<E>) jdbc.query(sql, params, classMapping.getType());
            pagination.setPageResults(list);
            pagination.setTotal(list.size());
        }
        return pagination;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public <E> E single() {
        String sql = getRoot().expression();
        Object[] params = getRoot().getParams().toArray();
        if (limit != null) {
            sql = dialect.getPaginationSql(sql, limit.getOffset(), limit.getLimit());
            params = dialect.getPaginationSqlParameter(params, limit.getOffset(), limit.getLimit());
        }
        return (E) jdbc.querySingle(sql, params, classMapping.getType());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TypeQuerySortExpression sort() {
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TypeQuerySortExpression asc(String... names) {
        ((RepositoryTypeSqlQueryConditionGroupExpression) getRoot()).sortBuilder
                .asc(ClassMappingUtils.getColumnNames(classMapping, names));
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TypeQuerySortExpression asc(List<String> names) {
        ((RepositoryTypeSqlQueryConditionGroupExpression) getRoot()).sortBuilder
                .asc(ClassMappingUtils.getColumnNames(classMapping, names));
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> TypeQuerySortExpression asc(SerializableFunction<T, R> name) {
        return asc(getPropertyName(name));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> TypeQuerySortExpression asc(@SuppressWarnings("unchecked") SerializableFunction<T, R>... names) {
        String[] nameArray = Arrays.stream(names).map(LambdaUtils::getLambdaPropertyName)
                .toArray(value -> new String[value]);
        return asc(nameArray);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TypeQuerySortExpression desc(String... names) {
        ((RepositoryTypeSqlQueryConditionGroupExpression) getRoot()).sortBuilder
                .desc(ClassMappingUtils.getColumnNames(classMapping, names));
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TypeQuerySortExpression desc(List<String> names) {
        ((RepositoryTypeSqlQueryConditionGroupExpression) getRoot()).sortBuilder
                .desc(ClassMappingUtils.getColumnNames(classMapping, names));
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> TypeQuerySortExpression desc(SerializableFunction<T, R> name) {
        return desc(getPropertyName(name));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> TypeQuerySortExpression desc(@SuppressWarnings("unchecked") SerializableFunction<T, R>... names) {
        String[] nameArray = Arrays.stream(names).map(LambdaUtils::getLambdaPropertyName)
                .toArray(value -> new String[value]);
        return desc(nameArray);
    }
}
