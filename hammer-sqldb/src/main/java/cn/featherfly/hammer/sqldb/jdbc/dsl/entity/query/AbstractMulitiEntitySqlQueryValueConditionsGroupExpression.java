
package cn.featherfly.hammer.sqldb.jdbc.dsl.entity.query;

import java.util.Arrays;
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
import cn.featherfly.hammer.config.dsl.QueryConditionConfig;
import cn.featherfly.hammer.expression.entity.query.EntityQueryValueConditionGroupExpression;
import cn.featherfly.hammer.expression.entity.query.EntityQueryValueConditionGroupLogicExpression;
import cn.featherfly.hammer.expression.entity.query.EntityQueryValueLimitExecutor;
import cn.featherfly.hammer.expression.entity.query.EntityQueryValueSortExpression;
import cn.featherfly.hammer.expression.entity.query.EntityQueryValueSortedExpression;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory.SqlPageQuery;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.AbstractMulitiEntitySqlConditionsGroupExpressionBase;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.EntitySqlQueryRelation;

/**
 * sql condition group expression. 条件逻辑组构造器.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public abstract class AbstractMulitiEntitySqlQueryValueConditionsGroupExpression<E, V,
    C extends EntityQueryValueConditionGroupExpression<E, V, C, L, EntityQueryValueSortExpression<E, V>>,
    L extends EntityQueryValueConditionGroupLogicExpression<E, V, C, L, EntityQueryValueSortExpression<E, V>>> extends
    AbstractMulitiEntitySqlConditionsGroupExpressionBase<E, C, L, QueryConditionConfig, EntitySqlQueryRelation,
        SqlSelectBasicBuilder>
    implements EntityQueryValueConditionGroupExpression<E, V, C, L, EntityQueryValueSortExpression<E, V>>,
    EntityQueryValueConditionGroupLogicExpression<E, V, C, L, EntityQueryValueSortExpression<E, V>>,
    EntityQueryValueSortExpression<E, V>, EntityQueryValueSortedExpression<E, V> {

    private Limit limit;

    private SqlSortBuilder sortBuilder;

    /** The sql page factory. */
    protected SqlPageFactory sqlPageFactory;

    protected final Class<E> queryType;

    protected final Class<V> valueType;

    /**
     * Instantiates a new abstract entity sql condition group expression.
     *
     * @param parent         the parent
     * @param factory        the factory
     * @param sqlPageFactory the sql page factory
     * @param queryRelation  the query relation
     * @param valueType      the value type
     */
    @SuppressWarnings("unchecked")
    protected AbstractMulitiEntitySqlQueryValueConditionsGroupExpression(L parent, JdbcMappingFactory factory,
        SqlPageFactory sqlPageFactory, EntitySqlQueryRelation queryRelation, Class<V> valueType) {
        super(parent, factory, queryRelation);
        this.sqlPageFactory = sqlPageFactory;
        this.valueType = valueType;
        queryType = (Class<E>) queryRelation.getEntityRelationTuple().get0().get().getClassMapping().getType();
        sortBuilder = new SqlSortBuilder(dialect, queryRelation.getEntityRelation(0).getTableAlias());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String expression() {
        StringBuilder result = new StringBuilder(super.expression());
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

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQueryValueLimitExecutor<E, V> limit(Limit limit) {
        this.limit = limit;
        return this;
    }

    /**
     * {@inheritDoc}
     */
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
        return entityRelation.getJdbc().query(execution.getExecution(), queryType, execution.getParams());
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
            SqlPageQuery<
                Object[]> pageQuery = sqlPageFactory.toPage(dialect, sql, limit.getOffset(), limit.getLimit(), params);
            List<E> list = entityRelation.getJdbc().query(pageQuery.getSql(), queryType, pageQuery.getParams());
            pagination.setPageResults(list);
            int total = entityRelation.getJdbc().queryInt(countSql, params);
            pagination.setTotal(total);
        } else {
            List<E> list = entityRelation.getJdbc().query(sql, queryType, params);
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
        return entityRelation.getJdbc().querySingle(execution.getExecution(), queryType, execution.getParams());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public E unique() {
        Execution execution = getExecution();
        return entityRelation.getJdbc().queryUnique(execution.getExecution(), queryType, execution.getParams());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PaginationResults<V> valuePagination() {
        String sql = getRoot().expression();
        String countSql = SqlUtils.convertSelectToCount(sql);
        Object[] params = getRoot().getParams().toArray();
        SimplePaginationResults<V> pagination = new SimplePaginationResults<>(limit);
        if (limit != null) {
            SqlPageQuery<
                Object[]> pageQuery = sqlPageFactory.toPage(dialect, sql, limit.getOffset(), limit.getLimit(), params);
            List<V> list = entityRelation.getJdbc().query(pageQuery.getSql(), valueType, pageQuery.getParams());
            pagination.setPageResults(list);
            int total = entityRelation.getJdbc().queryInt(countSql, params);
            pagination.setTotal(total);
        } else {
            List<V> list = entityRelation.getJdbc().query(sql, valueType, params);
            pagination.setPageResults(list);
            pagination.setTotal(list.size());
        }
        return pagination;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public V value() {
        Execution execution = getExecution();
        return entityRelation.getJdbc().querySingle(execution.getExecution(), valueType, execution.getParams());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<V> valueList() {
        Execution execution = getExecution();
        return entityRelation.getJdbc().query(execution.getExecution(), valueType, execution.getParams());
    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public String string() {
    //        Execution execution = getExecution();
    //        return entityRelation.getJdbc().queryString(execution.getExecution(), execution.getParams());
    //        //        String sql = getRoot().expression();
    //        //        Object[] params = getRoot().getParams().toArray();
    //        //        if (limit != null) {
    //        //            SqlPageQuery<Object[]> pageQuery = sqlPageFactory.toPage(dialect, sql, limit.getOffset(), limit.getLimit(),
    //        //                    params);
    //        //            sql = pageQuery.getSql();
    //        //            params = pageQuery.getParams();
    //        //        }
    //        //        return entityRelation.getJdbc().queryString(sql, params);
    //    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public Date date() {
    //        Execution execution = getExecution();
    //        return entityRelation.getJdbc().queryValue(execution.getExecution(), Date.class, execution.getParams());
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public LocalDate localDate() {
    //        Execution execution = getExecution();
    //        return entityRelation.getJdbc().queryValue(execution.getExecution(), LocalDate.class, execution.getParams());
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public LocalDateTime localDateTime() {
    //        Execution execution = getExecution();
    //        return entityRelation.getJdbc().queryValue(execution.getExecution(), LocalDateTime.class,
    //                execution.getParams());
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public LocalTime localTime() {
    //        Execution execution = getExecution();
    //        return entityRelation.getJdbc().queryValue(execution.getExecution(), LocalTime.class, execution.getParams());
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public Timestamp timestamp() {
    //        Execution execution = getExecution();
    //        return entityRelation.getJdbc().queryValue(execution.getExecution(), Timestamp.class, execution.getParams());
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public byte[] bytes() {
    //        Execution execution = getExecution();
    //        return entityRelation.getJdbc().queryBytes(execution.getExecution(), execution.getParams());
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public Clob clob() {
    //        Execution execution = getExecution();
    //        return entityRelation.getJdbc().queryValue(execution.getExecution(), Clob.class, execution.getParams());
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public Blob blob() {
    //        Execution execution = getExecution();
    //        return entityRelation.getJdbc().queryValue(execution.getExecution(), Blob.class, execution.getParams());
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public boolean bool() {
    //        Execution execution = getExecution();
    //        return entityRelation.getJdbc().queryBool(execution.getExecution(), execution.getParams());
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public byte byteValue() {
    //        Execution execution = getExecution();
    //        return entityRelation.getJdbc().queryByte(execution.getExecution(), execution.getParams());
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public short shortValue() {
    //        Execution execution = getExecution();
    //        return entityRelation.getJdbc().queryShort(execution.getExecution(), execution.getParams());
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public int intValue() {
    //        Execution execution = getExecution();
    //        return entityRelation.getJdbc().queryInt(execution.getExecution(), execution.getParams());
    //        //        String sql = getRoot().expression();
    //        //        Object[] params = getRoot().getParams().toArray();
    //        //        if (limit != null) {
    //        //            SqlPageQuery<Object[]> pageQuery = sqlPageFactory.toPage(dialect, sql, limit.getOffset(), limit.getLimit(),
    //        //                    params);
    //        //            sql = pageQuery.getSql();
    //        //            params = pageQuery.getParams();
    //        //        }
    //        //        return entityRelation.getJdbc().queryInt(sql, params);
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public long longValue() {
    //        Execution execution = getExecution();
    //        return entityRelation.getJdbc().queryLong(execution.getExecution(), execution.getParams());
    //        //        String sql = getRoot().expression();
    //        //        Object[] params = getRoot().getParams().toArray();
    //        //        if (limit != null) {
    //        //            SqlPageQuery<Object[]> pageQuery = sqlPageFactory.toPage(dialect, sql, limit.getOffset(), limit.getLimit(),
    //        //                    params);
    //        //            sql = pageQuery.getSql();
    //        //            params = pageQuery.getParams();
    //        //        }
    //        //        return entityRelation.getJdbc().queryLong(sql, params);
    //    }
    //
    //    //    /**
    //    //     * {@inheritDoc}
    //    //     */
    //    //    @Override
    //    //    public <N extends Number> N number(Class<N> type) {
    //    //        return value(type);
    //    //        //        Execution execution = getExecution();
    //    //        //        return entityRelation.getJdbc().queryValue(execution.getExecution(), type, execution.getParams());
    //    //
    //    //        //        String sql = getRoot().expression();
    //    //        //        Object[] params = getRoot().getParams().toArray();
    //    //        //        if (limit != null) {
    //    //        //            SqlPageQuery<Object[]> pageQuery = sqlPageFactory.toPage(dialect, sql, limit.getOffset(), limit.getLimit(),
    //    //        //                    params);
    //    //        //            sql = pageQuery.getSql();
    //    //        //            params = pageQuery.getParams();
    //    //        //        }
    //    //        //        return entityRelation.getJdbc().queryValue(sql, type, params);
    //    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <T> T value(Class<T> type) {
    //        Execution execution = getExecution();
    //        return entityRelation.getJdbc().queryValue(execution.getExecution(), type, execution.getParams());
    //    }

    // ****************************************************************************************************************
    // sort
    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQueryValueSortExpression<E, V> sort() {
        return this;
    }

    /**
     * Asc.
     *
     * @param names the names
     * @return the entity query sorted expression
     */
    //        @Override
    public EntityQueryValueSortedExpression<E, V> asc(String... names) {
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
    public EntityQueryValueSortedExpression<E, V> asc(List<String> names) {
        getRootSortBuilder().asc(ClassMappingUtils.getColumnNames(classMapping, names));
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> EntityQueryValueSortedExpression<E, V> asc(SerializableFunction<E, R> name) {
        return asc(getPropertyName(name));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQueryValueSortedExpression<E, V> asc(
        @SuppressWarnings("unchecked") SerializableFunction<E, ?>... names) {
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
    public EntityQueryValueSortedExpression<E, V> desc(String... names) {
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
    public EntityQueryValueSortedExpression<E, V> desc(List<String> names) {
        getRootSortBuilder().desc(ClassMappingUtils.getColumnNames(classMapping, names));
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> EntityQueryValueSortedExpression<E, V> desc(SerializableFunction<E, R> name) {
        return desc(getPropertyName(name));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQueryValueSortedExpression<E, V> desc(
        @SuppressWarnings("unchecked") SerializableFunction<E, ?>... names) {
        String[] nameArray = Arrays.stream(names).map(LambdaUtils::getLambdaPropertyName)
            .toArray(value -> new String[value]);
        return desc(nameArray);
    }

    // ****************************************************************************************************************
    //	private method
    // ****************************************************************************************************************

    @SuppressWarnings("unchecked")
    private SortBuilder getRootSortBuilder() {
        return ((AbstractMulitiEntitySqlQueryValueConditionsGroupExpression<E, V, C, L>) getRoot()).sortBuilder;
    }

    private Execution getExecution() {
        String sql = getRoot().expression();
        Object[] params = getRoot().getParams().toArray();
        if (limit != null) {
            SqlPageQuery<
                Object[]> pageQuery = sqlPageFactory.toPage(dialect, sql, limit.getOffset(), limit.getLimit(), params);
            sql = pageQuery.getSql();
            params = pageQuery.getParams();
        }
        return new SimpleExecution(sql, params);
    }
}
