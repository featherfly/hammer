
package cn.featherfly.hammer.sqldb.sql.dml;

import java.sql.Blob;
import java.sql.Clob;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import cn.featherfly.common.constant.Chars;
import cn.featherfly.common.db.SqlUtils;
import cn.featherfly.common.db.builder.dml.SqlSortBuilder;
import cn.featherfly.common.db.builder.dml.basic.SqlSelectBasicBuilder;
import cn.featherfly.common.db.mapping.ClassMappingUtils;
import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.lang.LambdaUtils;
import cn.featherfly.common.lang.Lang;
import cn.featherfly.common.operator.AggregateFunction;
import cn.featherfly.common.repository.Execution;
import cn.featherfly.common.repository.SimpleExecution;
import cn.featherfly.common.repository.builder.dml.SortBuilder;
import cn.featherfly.common.structure.page.Limit;
import cn.featherfly.common.structure.page.PaginationResults;
import cn.featherfly.common.structure.page.SimplePaginationResults;
import cn.featherfly.hammer.expression.entity.query.EntityQueryLimitExecutor;
import cn.featherfly.hammer.expression.entity.query.EntityQuerySortExpression;
import cn.featherfly.hammer.expression.entity.query.EntityQuerySortedExpression;
import cn.featherfly.hammer.expression.entity.query.EntityQueryValueConditionGroupExpression;
import cn.featherfly.hammer.expression.entity.query.EntityQueryValueConditionGroupLogicExpression;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory.SqlPageQuery;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.EntitySqlQueryRelation;

/**
 * sql condition group expression. 条件逻辑组构造器.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public abstract class AbstractEntitySqlQueryValueConditionGroupExpression<E,
        C extends EntityQueryValueConditionGroupExpression<E, C, L, EntityQuerySortExpression<E>>,
        L extends EntityQueryValueConditionGroupLogicExpression<E, C, L, EntityQuerySortExpression<E>>>
        extends AbstractEntitySqlConditionGroupExpressionBase<E, EntitySqlQueryRelation, SqlSelectBasicBuilder, C, L>
        implements EntityQueryValueConditionGroupExpression<E, C, L, EntityQuerySortExpression<E>>,
        EntityQueryValueConditionGroupLogicExpression<E, C, L, EntityQuerySortExpression<E>>,
        EntityQuerySortExpression<E>, EntityQuerySortedExpression<E> {

    private Limit limit;

    private SqlSortBuilder sortBuilder;

    /** The sql page factory. */
    protected SqlPageFactory sqlPageFactory;

    /**
     * Instantiates a new abstract entity sql condition group expression.
     *
     * @param parent         the parent
     * @param factory        the factory
     * @param sqlPageFactory the sql page factory
     * @param queryRelation  the query relation
     */
    protected AbstractEntitySqlQueryValueConditionGroupExpression(L parent, JdbcMappingFactory factory,
            SqlPageFactory sqlPageFactory, EntitySqlQueryRelation queryRelation) {
        super(parent, factory, queryRelation);
        this.sqlPageFactory = sqlPageFactory;
        sortBuilder = new SqlSortBuilder(dialect, queryRelation.getEntityRelationMapping(0).getTableAlias());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String build() {
        StringBuilder result = new StringBuilder(super.build());
        String sort = sortBuilder.build();
        if (result.length() > 0) {
            if (Lang.isNotEmpty(sort)) {
                return result.append(Chars.SPACE).append(sort).toString();
            } else {
                return result.toString();
            }
        } else {
            return sort;
        }
    }

    @Override
    public EntityQueryLimitExecutor<E> limit(Limit limit) {
        this.limit = limit;
        return this;
    }

    @Override
    public long count() {
        entityRelation.getBuilder().clearColumns().addColumn(AggregateFunction.COUNT, Chars.STAR);
        return entityRelation.getJdbc().queryLong(getRoot().expression(), getRoot().getParams().toArray());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<E> list() {
        Execution execution = getExecution();
        return entityRelation.getJdbc().query(execution.getExecution(), classMapping.getType(), execution.getParams());
        //        String sql = getRoot().expression();
        //        Object[] params = getRoot().getParams().toArray();
        //        if (limit != null) {
        //            SqlPageQuery<Object[]> pageQuery = sqlPageFactory.toPage(dialect, sql, limit.getOffset(), limit.getLimit(),
        //                    params);
        //            sql = pageQuery.getSql();
        //            params = pageQuery.getParams();
        //        }
        //        return entityRelation.getJdbc().query(sql, classMapping.getType(), params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PaginationResults<E> pagination() {
        String sql = getRoot().expression();
        String countSql = SqlUtils.convertSelectToCount(sql);
        Object[] params = getRoot().getParams().toArray();
        SimplePaginationResults<E> pagination = new SimplePaginationResults<>(limit);
        if (limit != null) {
            SqlPageQuery<Object[]> pageQuery = sqlPageFactory.toPage(dialect, sql, limit.getOffset(), limit.getLimit(),
                    params);
            List<E> list = entityRelation.getJdbc().query(pageQuery.getSql(), classMapping.getType(),
                    pageQuery.getParams());
            //            @SuppressWarnings("unchecked")
            //            List<E> list = (List<E>) entitySqlRelation.getJdbc().query(dialect.getPaginationSql(sql, limit.getOffset(), limit.getLimit()),
            //                    classMapping.getType(),
            //                    dialect.getPaginationSqlParameter(params, limit.getOffset(), limit.getLimit()));
            pagination.setPageResults(list);
            int total = entityRelation.getJdbc().queryInt(countSql, params);
            pagination.setTotal(total);
        } else {
            @SuppressWarnings("unchecked")
            List<E> list = (List<E>) entityRelation.getJdbc().query(sql, params, classMapping.getType());
            pagination.setPageResults(list);
            pagination.setTotal(list.size());
        }
        return pagination;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public E single() {
        Execution execution = getExecution();
        return entityRelation.getJdbc().querySingle(execution.getExecution(), classMapping.getType(),
                execution.getParams());
        //        String sql = getRoot().expression();
        //        Object[] params = getRoot().getParams().toArray();
        //        if (limit != null) {
        //            SqlPageQuery<Object[]> pageQuery = sqlPageFactory.toPage(dialect, sql, limit.getOffset(), limit.getLimit(),
        //                    params);
        //            sql = pageQuery.getSql();
        //            params = pageQuery.getParams();
        //            //            sql = dialect.getPaginationSql(sql, limit.getOffset(), limit.getLimit());
        //            //            params = dialect.getPaginationSqlParameter(params, limit.getOffset(), limit.getLimit());
        //        }
        //        return entityRelation.getJdbc().querySingle(sql, classMapping.getType(), params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public E unique() {
        Execution execution = getExecution();
        return entityRelation.getJdbc().queryUnique(execution.getExecution(), classMapping.getType(),
                execution.getParams());
        //        String sql = getRoot().expression();
        //        Object[] params = getRoot().getParams().toArray();
        //        if (limit != null) {
        //            SqlPageQuery<Object[]> pageQuery = sqlPageFactory.toPage(dialect, sql, limit.getOffset(), limit.getLimit(),
        //                    params);
        //            sql = pageQuery.getSql();
        //            params = pageQuery.getParams();
        //            //            sql = dialect.getPaginationSql(sql, limit.getOffset(), limit.getLimit());
        //            //            params = dialect.getPaginationSqlParameter(params, limit.getOffset(), limit.getLimit());
        //        }
        //        return entityRelation.getJdbc().queryUnique(sql, classMapping.getType(), params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String string() {
        Execution execution = getExecution();
        return entityRelation.getJdbc().queryString(execution.getExecution(), execution.getParams());
        //        String sql = getRoot().expression();
        //        Object[] params = getRoot().getParams().toArray();
        //        if (limit != null) {
        //            SqlPageQuery<Object[]> pageQuery = sqlPageFactory.toPage(dialect, sql, limit.getOffset(), limit.getLimit(),
        //                    params);
        //            sql = pageQuery.getSql();
        //            params = pageQuery.getParams();
        //        }
        //        return entityRelation.getJdbc().queryString(sql, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Date date() {
        Execution execution = getExecution();
        return entityRelation.getJdbc().queryValue(execution.getExecution(), Date.class, execution.getParams());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LocalDate localDate() {
        Execution execution = getExecution();
        return entityRelation.getJdbc().queryValue(execution.getExecution(), LocalDate.class, execution.getParams());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LocalDateTime localDateTime() {
        Execution execution = getExecution();
        return entityRelation.getJdbc().queryValue(execution.getExecution(), LocalDateTime.class,
                execution.getParams());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LocalTime localTime() {
        Execution execution = getExecution();
        return entityRelation.getJdbc().queryValue(execution.getExecution(), LocalTime.class, execution.getParams());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp timestamp() {
        Execution execution = getExecution();
        return entityRelation.getJdbc().queryValue(execution.getExecution(), Timestamp.class, execution.getParams());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public byte[] bytes() {
        Execution execution = getExecution();
        return entityRelation.getJdbc().queryBytes(execution.getExecution(), execution.getParams());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Clob clob() {
        Execution execution = getExecution();
        return entityRelation.getJdbc().queryValue(execution.getExecution(), Clob.class, execution.getParams());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Blob blob() {
        Execution execution = getExecution();
        return entityRelation.getJdbc().queryValue(execution.getExecution(), Blob.class, execution.getParams());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean bool() {
        Execution execution = getExecution();
        return entityRelation.getJdbc().queryBool(execution.getExecution(), execution.getParams());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public byte byteValue() {
        Execution execution = getExecution();
        return entityRelation.getJdbc().queryByte(execution.getExecution(), execution.getParams());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public short shortValue() {
        Execution execution = getExecution();
        return entityRelation.getJdbc().queryShort(execution.getExecution(), execution.getParams());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int intValue() {
        Execution execution = getExecution();
        return entityRelation.getJdbc().queryInt(execution.getExecution(), execution.getParams());
        //        String sql = getRoot().expression();
        //        Object[] params = getRoot().getParams().toArray();
        //        if (limit != null) {
        //            SqlPageQuery<Object[]> pageQuery = sqlPageFactory.toPage(dialect, sql, limit.getOffset(), limit.getLimit(),
        //                    params);
        //            sql = pageQuery.getSql();
        //            params = pageQuery.getParams();
        //        }
        //        return entityRelation.getJdbc().queryInt(sql, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public long longValue() {
        Execution execution = getExecution();
        return entityRelation.getJdbc().queryLong(execution.getExecution(), execution.getParams());
        //        String sql = getRoot().expression();
        //        Object[] params = getRoot().getParams().toArray();
        //        if (limit != null) {
        //            SqlPageQuery<Object[]> pageQuery = sqlPageFactory.toPage(dialect, sql, limit.getOffset(), limit.getLimit(),
        //                    params);
        //            sql = pageQuery.getSql();
        //            params = pageQuery.getParams();
        //        }
        //        return entityRelation.getJdbc().queryLong(sql, params);
    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <N extends Number> N number(Class<N> type) {
    //        return value(type);
    //        //        Execution execution = getExecution();
    //        //        return entityRelation.getJdbc().queryValue(execution.getExecution(), type, execution.getParams());
    //
    //        //        String sql = getRoot().expression();
    //        //        Object[] params = getRoot().getParams().toArray();
    //        //        if (limit != null) {
    //        //            SqlPageQuery<Object[]> pageQuery = sqlPageFactory.toPage(dialect, sql, limit.getOffset(), limit.getLimit(),
    //        //                    params);
    //        //            sql = pageQuery.getSql();
    //        //            params = pageQuery.getParams();
    //        //        }
    //        //        return entityRelation.getJdbc().queryValue(sql, type, params);
    //    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> T value(Class<T> type) {
        Execution execution = getExecution();
        return entityRelation.getJdbc().queryValue(execution.getExecution(), type, execution.getParams());
    }

    // ****************************************************************************************************************
    // sort
    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQuerySortExpression<E> sort() {
        return this;
    }

    /**
     * Asc.
     *
     * @param names the names
     * @return the entity query sorted expression
     */
    //        @Override
    public EntityQuerySortedExpression<E> asc(String... names) {
        getRootSortBuilder().asc(ClassMappingUtils.getColumnNames(classMapping, names));
        return this;
    }

    /**
     * Asc.
     *
     * @param names the names
     * @return the entity query sorted expression
     */
    //        @Override
    public EntityQuerySortedExpression<E> asc(List<String> names) {
        getRootSortBuilder().asc(ClassMappingUtils.getColumnNames(classMapping, names));
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> EntityQuerySortedExpression<E> asc(SerializableFunction<E, R> name) {
        return asc(getPropertyName(name));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQuerySortedExpression<E> asc(@SuppressWarnings("unchecked") SerializableFunction<E, ?>... names) {
        String[] nameArray = Arrays.stream(names).map(LambdaUtils::getLambdaPropertyName)
                .toArray(value -> new String[value]);
        return asc(nameArray);
    }

    //    /**
    //     * {@inheritDoc}
    //     */
    /**
     * Desc.
     *
     * @param names the names
     * @return the entity query sorted expression
     */
    //    @Override
    public EntityQuerySortedExpression<E> desc(String... names) {
        getRootSortBuilder().desc(ClassMappingUtils.getColumnNames(classMapping, names));
        return this;
    }

    //    /**
    //     * {@inheritDoc}
    //     */
    /**
     * Desc.
     *
     * @param names the names
     * @return the entity query sorted expression
     */
    //    @Override
    public EntityQuerySortedExpression<E> desc(List<String> names) {
        getRootSortBuilder().desc(ClassMappingUtils.getColumnNames(classMapping, names));
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> EntityQuerySortedExpression<E> desc(SerializableFunction<E, R> name) {
        return desc(getPropertyName(name));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQuerySortedExpression<E> desc(@SuppressWarnings("unchecked") SerializableFunction<E, ?>... names) {
        String[] nameArray = Arrays.stream(names).map(LambdaUtils::getLambdaPropertyName)
                .toArray(value -> new String[value]);
        return desc(nameArray);
    }

    // ****************************************************************************************************************
    //	private method
    // ****************************************************************************************************************

    private SortBuilder getRootSortBuilder() {
        return ((AbstractEntitySqlQueryValueConditionGroupExpression<E, C, L>) getRoot()).sortBuilder;
    }

    private Execution getExecution() {
        String sql = getRoot().expression();
        Object[] params = getRoot().getParams().toArray();
        if (limit != null) {
            SqlPageQuery<Object[]> pageQuery = sqlPageFactory.toPage(dialect, sql, limit.getOffset(), limit.getLimit(),
                    params);
            sql = pageQuery.getSql();
            params = pageQuery.getParams();
        }
        return new SimpleExecution(sql, params);
    }
}
