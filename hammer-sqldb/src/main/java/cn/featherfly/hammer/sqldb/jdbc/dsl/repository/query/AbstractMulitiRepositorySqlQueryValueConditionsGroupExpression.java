
package cn.featherfly.hammer.sqldb.jdbc.dsl.repository.query;

import java.sql.Blob;
import java.sql.Clob;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.speedment.common.tuple.Tuple1;
import com.speedment.common.tuple.Tuples;

import cn.featherfly.common.constant.Chars;
import cn.featherfly.common.db.SqlUtils;
import cn.featherfly.common.db.builder.dml.SqlSortBuilder;
import cn.featherfly.common.db.builder.dml.basic.SqlSelectBasicBuilder;
import cn.featherfly.common.lang.Lang;
import cn.featherfly.common.operator.AggregateFunction;
import cn.featherfly.common.repository.builder.dml.SortBuilder;
import cn.featherfly.common.repository.mapping.RowMapper;
import cn.featherfly.common.structure.page.Limit;
import cn.featherfly.common.structure.page.PaginationResults;
import cn.featherfly.common.structure.page.SimplePaginationResults;
import cn.featherfly.hammer.config.dsl.QueryConditionConfig;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryValueConditionsGroup;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryValueConditionsGroupLogic;
import cn.featherfly.hammer.expression.query.QueryValueLimitExecutor;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryValueSortExpression;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryValueSortedExpression;
import cn.featherfly.hammer.sqldb.jdbc.Jdbc;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory.SqlPageQuery;
import cn.featherfly.hammer.sqldb.jdbc.dsl.repository.AbstractMulitiRepositorySqlConditionsGroupExpressionBase;
import cn.featherfly.hammer.sqldb.jdbc.dsl.repository.RepositorySqlQueryRelation;

/**
 * abstract muliti repository sql query conditions group expression.
 *
 * @author zhongj
 */
public abstract class AbstractMulitiRepositorySqlQueryValueConditionsGroupExpression extends
        AbstractMulitiRepositorySqlConditionsGroupExpressionBase<RepositoryQueryValueConditionsGroup,
                RepositoryQueryValueConditionsGroupLogic, Tuple1<Integer>, QueryConditionConfig,
                RepositorySqlQueryRelation, SqlSelectBasicBuilder>
        implements RepositoryQueryValueConditionsGroup, RepositoryQueryValueConditionsGroupLogic,
        RepositoryQueryValueSortExpression, RepositoryQueryValueSortedExpression {

    /** The sort builder. */
    private SqlSortBuilder sortBuilder;

    /** The limit. */
    private Limit limit;

    /** The sql page factory. */
    protected SqlPageFactory sqlPageFactory;

    /** The jdbc. */
    protected final Jdbc jdbc;

    /**
     * Instantiates a new abstract muliti repository sql query conditions group
     * expression.
     *
     * @param index          the index
     * @param queryRelation  the query relation
     * @param sqlPageFactory the sql page factory
     */
    protected AbstractMulitiRepositorySqlQueryValueConditionsGroupExpression(int index,
            RepositorySqlQueryRelation queryRelation, SqlPageFactory sqlPageFactory) {
        this(null, index, queryRelation, sqlPageFactory);
    }

    /**
     * Instantiates a new abstract muliti repository sql query conditions group
     * expression.
     *
     * @param parent         the parent
     * @param index          the index
     * @param queryRelation  the query relation
     * @param sqlPageFactory the sql page factory
     */
    protected AbstractMulitiRepositorySqlQueryValueConditionsGroupExpression(
            RepositoryQueryValueConditionsGroupLogic parent, int index, RepositorySqlQueryRelation queryRelation,
            SqlPageFactory sqlPageFactory) {
        super(parent, index, queryRelation);
        jdbc = queryRelation.getJdbc();
        this.sqlPageFactory = sqlPageFactory;
        if (parent == null) {
            // use root only, see getRootSortBuilder()
            sortBuilder = new SqlSortBuilder(dialect, repositoryAlias);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryValueLimitExecutor limit(Limit limit) {
        this.limit = limit;
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public long count() {
        repositoryRelation.getBuilder().clearColumns().addColumn(AggregateFunction.COUNT, Chars.STAR);
        return repositoryRelation.getJdbc().queryLong(getRoot().expression(), getRoot().getParams().toArray());
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public <E> List<E> list() {
        return (List<E>) list(Object.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> List<E> list(Class<E> type) {
        String sql = getRoot().expression();
        Object[] params = getRoot().getParams().toArray();
        if (limit != null) {
            SqlPageQuery<Object[]> pageQuery = sqlPageFactory.toPage(dialect, sql, limit.getOffset(), limit.getLimit(),
                    params);
            sql = pageQuery.getSql();
            params = pageQuery.getParams();
        }
        return jdbc.query(sql, type, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PaginationResults<Map<String, Object>> pagination() {
        String sql = getRoot().expression();
        String countSql = SqlUtils.convertSelectToCount(sql);
        Object[] params = getRoot().getParams().toArray();
        SimplePaginationResults<Map<String, Object>> pagination = new SimplePaginationResults<>(limit);
        if (limit != null) {
            SqlPageQuery<Object[]> pageQuery = sqlPageFactory.toPage(dialect, sql, limit.getOffset(), limit.getLimit(),
                    params);
            List<Map<String, Object>> list = jdbc.query(pageQuery.getSql(), pageQuery.getParams());
            pagination.setPageResults(list);
            int total = jdbc.queryInt(countSql, params);
            pagination.setTotal(total);
        } else {
            List<Map<String, Object>> list = jdbc.query(sql, params);
            pagination.setPageResults(list);
            pagination.setTotal(list.size());
        }
        return pagination;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> PaginationResults<E> pagination(Class<E> type) {
        String sql = getRoot().expression();
        String countSql = SqlUtils.convertSelectToCount(sql);
        Object[] params = getRoot().getParams().toArray();
        SimplePaginationResults<E> pagination = new SimplePaginationResults<>(limit);
        if (limit != null) {
            SqlPageQuery<Object[]> pageQuery = sqlPageFactory.toPage(dialect, sql, limit.getOffset(), limit.getLimit(),
                    params);
            List<E> list = jdbc.query(pageQuery.getSql(), type, pageQuery.getParams());
            pagination.setPageResults(list);
            int total = jdbc.queryInt(countSql, params);
            pagination.setTotal(total);
        } else {
            List<E> list = jdbc.query(sql, type, params);
            pagination.setPageResults(list);
            pagination.setTotal(list.size());
        }
        return pagination;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> PaginationResults<E> pagination(RowMapper<E> rowMapper) {
        String sql = getRoot().expression();
        String countSql = SqlUtils.convertSelectToCount(sql);
        Object[] params = getRoot().getParams().toArray();
        SimplePaginationResults<E> pagination = new SimplePaginationResults<>(limit);
        if (limit != null) {
            SqlPageQuery<Object[]> pageQuery = sqlPageFactory.toPage(dialect, sql, limit.getOffset(), limit.getLimit(),
                    params);
            List<E> list = jdbc.query(pageQuery.getSql(), rowMapper, pageQuery.getParams());
            pagination.setPageResults(list);
            int total = jdbc.queryInt(countSql, params);
            pagination.setTotal(total);
        } else {
            List<E> list = jdbc.query(sql, rowMapper, params);
            pagination.setPageResults(list);
            pagination.setTotal(list.size());
        }
        return pagination;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String string() {
        return jdbc.queryString(getRoot().expression(), getRoot().getParams().toArray());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Date date() {
        return jdbc.queryValue(getRoot().expression(), Date.class, getRoot().getParams().toArray());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LocalDate localDate() {
        return jdbc.queryValue(getRoot().expression(), LocalDate.class, getRoot().getParams().toArray());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LocalDateTime localDateTime() {
        return jdbc.queryValue(getRoot().expression(), LocalDateTime.class, getRoot().getParams().toArray());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LocalTime localTime() {
        return jdbc.queryValue(getRoot().expression(), LocalTime.class, getRoot().getParams().toArray());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp timestamp() {
        return jdbc.queryValue(getRoot().expression(), Timestamp.class, getRoot().getParams().toArray());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public byte[] bytes() {
        return jdbc.queryBytes(getRoot().expression(), getRoot().getParams().toArray());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Clob clob() {
        return jdbc.queryValue(getRoot().expression(), Clob.class, getRoot().getParams().toArray());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Blob blob() {
        return jdbc.queryValue(getRoot().expression(), Blob.class, getRoot().getParams().toArray());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean bool() {
        return jdbc.queryBool(getRoot().expression(), getRoot().getParams().toArray());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public byte byteValue() {
        return jdbc.queryByte(getRoot().expression(), getRoot().getParams().toArray());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public short shortValue() {
        return jdbc.queryShort(getRoot().expression(), getRoot().getParams().toArray());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int intValue() {
        return jdbc.queryInt(getRoot().expression(), getRoot().getParams().toArray());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public long longValue() {
        return jdbc.queryLong(getRoot().expression(), getRoot().getParams().toArray());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double doubleValue() {
        return jdbc.queryDouble(getRoot().expression(), getRoot().getParams().toArray());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> T value(Class<T> type) {
        return jdbc.queryValue(getRoot().expression(), type, getRoot().getParams().toArray());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> T value() {
        return jdbc.queryValue(getRoot().expression(), getRoot().getParams().toArray());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> T single(Class<T> type) {
        return jdbc.querySingle(getRoot().expression(), type, getRoot().getParams().toArray());
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public <T> T single() {
        return (T) single(Object.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> T unique(Class<T> type) {
        return jdbc.queryUnique(getRoot().expression(), type, getRoot().getParams().toArray());
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public <T> T unique() {
        return (T) unique(Object.class);
    }

    // ****************************************************************************************************************
    //	sort
    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryQueryValueSortExpression sort() {
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryQueryValueSortedExpression asc(String... names) {
        getRootSortBuilder().asc(names);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryQueryValueSortedExpression desc(String... names) {
        getRootSortBuilder().desc(names);
        return this;
    }

    // ****************************************************************************************************************
    //	private method
    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    protected Tuple1<Integer> createTuple() {
        return Tuples.of(0);
    }

    /**
     * Gets the root sort builder.
     *
     * @return the root sort builder
     */
    protected SortBuilder getRootSortBuilder() {
        return ((AbstractMulitiRepositorySqlQueryValueConditionsGroupExpression) getRoot()).sortBuilder;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String expression() {
        String condition = super.expression();
        if (parent == null) {
            String result = repositoryRelation.buildSelectSql();
            String sort = getRootSortBuilder().build();
            if (Lang.isEmpty(condition)) {
                return result + Chars.SPACE + sort;
            } else {
                return result + Chars.SPACE + dialect.getKeywords().where() + Chars.SPACE + condition + Chars.SPACE
                        + sort;
            }
        } else {
            return condition;
        }
    }
}
