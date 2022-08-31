
package cn.featherfly.hammer.sqldb.jdbc.dsl.query;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.function.Predicate;

import com.speedment.common.tuple.Tuple2;
import com.speedment.common.tuple.Tuple3;

import cn.featherfly.common.constant.Chars;
import cn.featherfly.common.db.SqlUtils;
import cn.featherfly.common.db.builder.dml.SqlSortBuilder;
import cn.featherfly.common.db.mapping.ClassMappingUtils;
import cn.featherfly.common.exception.UnsupportedException;
import cn.featherfly.common.lang.LambdaUtils;
import cn.featherfly.common.lang.Lang;
import cn.featherfly.common.lang.function.ReturnDateFunction;
import cn.featherfly.common.lang.function.ReturnLocalDateFunction;
import cn.featherfly.common.lang.function.ReturnLocalDateTimeFunction;
import cn.featherfly.common.lang.function.ReturnLocalTimeFunction;
import cn.featherfly.common.lang.function.ReturnNumberFunction;
import cn.featherfly.common.lang.function.ReturnStringFunction;
import cn.featherfly.common.lang.function.SerializableFunction;
import cn.featherfly.common.lang.function.SerializableSupplier;
import cn.featherfly.common.repository.builder.AliasManager;
import cn.featherfly.common.repository.mapping.ClassMapping;
import cn.featherfly.common.repository.mapping.MappingFactory;
import cn.featherfly.common.repository.operate.QueryOperator;
import cn.featherfly.common.structure.page.Limit;
import cn.featherfly.common.structure.page.Page;
import cn.featherfly.common.structure.page.PaginationResults;
import cn.featherfly.common.structure.page.SimplePaginationResults;
import cn.featherfly.hammer.dsl.query.EntityQueryConditionGroupExpression;
import cn.featherfly.hammer.dsl.query.EntityQueryConditionGroupLogicExpression;
import cn.featherfly.hammer.dsl.query.EntityQueryEntity;
import cn.featherfly.hammer.dsl.query.EntityQuerySortExpression;
import cn.featherfly.hammer.expression.query.EntityQueryLimitExecutor;
import cn.featherfly.hammer.sqldb.jdbc.Jdbc;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory.SqlPageQuery;
import cn.featherfly.hammer.sqldb.sql.dml.AbstractSqlConditionGroupExpression;
import cn.featherfly.hammer.sqldb.sql.dml.SqlConditionExpressionBuilder;

/**
 * <p>
 * sql condition group builder sql条件逻辑组构造器
 * </p>
 * .
 *
 * @author zhongj
 */
public class EntitySqlQueryConditionGroupExpression<E> extends
        AbstractSqlConditionGroupExpression<EntityQueryConditionGroupExpression<E>, EntityQueryConditionGroupLogicExpression<E>>
        implements EntityQueryConditionGroupExpression<E>, EntityQueryConditionGroupLogicExpression<E>,
        EntityQuerySortExpression<E> {

    /** The sort builder. */
    private SqlSortBuilder sortBuilder = new SqlSortBuilder(dialect);

    /** The limit. */
    private Limit limit;

    /** The factory. */
    protected MappingFactory factory;

    /** The alias manager. */
    protected AliasManager aliasManager;

    /**
     * Instantiates a new type sql query condition group expression.
     *
     * @param jdbc            jdbc
     * @param classMapping    classMapping
     * @param factory         the factory
     * @param sqlPageFactory  the sql page factory
     * @param aliasManager    the alias manager
     * @param typeQueryEntity the type query entity
     * @param ignorePolicy    the ignore policy
     */
    public EntitySqlQueryConditionGroupExpression(Jdbc jdbc, ClassMapping<?> classMapping, MappingFactory factory,
            SqlPageFactory sqlPageFactory, AliasManager aliasManager, EntityQueryEntity typeQueryEntity,
            Predicate<Object> ignorePolicy) {
        this(jdbc, null, classMapping, factory, sqlPageFactory, aliasManager, typeQueryEntity, ignorePolicy);
    }

    /**
     * Instantiates a new type sql query condition group expression.
     *
     * @param jdbc            jdbc
     * @param queryAlias      queryAlias
     * @param classMapping    classMapping
     * @param factory         the factory
     * @param sqlPageFactory  the sql page factory
     * @param aliasManager    the alias manager
     * @param typeQueryEntity the type query entity
     * @param ignorePolicy    the ignore policy
     */
    public EntitySqlQueryConditionGroupExpression(Jdbc jdbc, String queryAlias, ClassMapping<?> classMapping,
            MappingFactory factory, SqlPageFactory sqlPageFactory, AliasManager aliasManager,
            EntityQueryEntity<E> typeQueryEntity, Predicate<Object> ignorePolicy) {
        this(null, jdbc, queryAlias, classMapping, factory, sqlPageFactory, aliasManager, typeQueryEntity,
                ignorePolicy);
    }

    /**
     * Instantiates a new type sql query condition group expression.
     *
     * @param parent          parent group
     * @param jdbc            the jdbc
     * @param queryAlias      queryAlias
     * @param classMapping    classMapping
     * @param factory         the factory
     * @param sqlPageFactory  the sql page factory
     * @param aliasManager    the alias manager
     * @param typeQueryEntity the type query entity
     * @param ignorePolicy    the ignore policy
     */
    EntitySqlQueryConditionGroupExpression(EntityQueryConditionGroupLogicExpression<E> parent, Jdbc jdbc,
            String queryAlias, ClassMapping<?> classMapping, MappingFactory factory, SqlPageFactory sqlPageFactory,
            AliasManager aliasManager, EntityQueryEntity<E> typeQueryEntity, Predicate<Object> ignorePolicy) {
        super(parent, jdbc.getDialect(), sqlPageFactory, queryAlias, classMapping, typeQueryEntity, ignorePolicy);
        this.jdbc = jdbc;
        this.factory = factory;
        this.aliasManager = aliasManager;
    }

    // ********************************************************************
    // property
    // ********************************************************************

    /** The jdbc. */
    protected Jdbc jdbc;

    /**
     * {@inheritDoc}
     */
    @Override
    protected EntitySqlQueryConditionGroupExpression<E> createGroup(EntityQueryConditionGroupLogicExpression<E> parent,
            String queryAlias, EntityQueryEntity typeQueryEntity) {
        return new EntitySqlQueryConditionGroupExpression(parent, jdbc, queryAlias, classMapping, factory,
                sqlPageFactory, aliasManager, typeQueryEntity, ignorePolicy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String build() {
        String condition = super.build();
        if (parent == null) {
            if (Lang.isNotEmpty(condition)) {
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
    public EntityQueryLimitExecutor<E> limit(Integer limit) {
        return limit(0, limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQueryLimitExecutor<E> limit(Integer offset, Integer limit) {
        return limit(new Limit(offset, limit));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQueryLimitExecutor<E> limit(Page page) {
        return limit(new Limit(page));
    }

    /**
     * Limit.
     *
     * @param limit the limit
     * @return the type query limit executor
     */
    private EntityQueryLimitExecutor<E> limit(Limit limit) {
        this.limit = limit;
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<E> list() {
        String sql = getRoot().expression();
        Object[] params = getRoot().getParams().toArray();
        if (limit != null) {
            SqlPageQuery<Object[]> pageQuery = sqlPageFactory.toPage(dialect, sql, limit.getOffset(), limit.getLimit(),
                    params);
            sql = pageQuery.getSql();
            params = pageQuery.getParams();
            //            sql = dialect.getPaginationSql(sql, limit.getOffset(), limit.getLimit());
            //            params = dialect.getPaginationSqlParameter(params, limit.getOffset(), limit.getLimit());
        }
        return (List<E>) jdbc.query(sql, classMapping.getType(), params);
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
            @SuppressWarnings("unchecked")
            List<E> list = (List<E>) jdbc.query(pageQuery.getSql(), classMapping.getType(), pageQuery.getParams());
            //            @SuppressWarnings("unchecked")
            //            List<E> list = (List<E>) jdbc.query(dialect.getPaginationSql(sql, limit.getOffset(), limit.getLimit()),
            //                    classMapping.getType(),
            //                    dialect.getPaginationSqlParameter(params, limit.getOffset(), limit.getLimit()));
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
    public E single() {
        String sql = getRoot().expression();
        Object[] params = getRoot().getParams().toArray();
        if (limit != null) {
            SqlPageQuery<Object[]> pageQuery = sqlPageFactory.toPage(dialect, sql, limit.getOffset(), limit.getLimit(),
                    params);
            sql = pageQuery.getSql();
            params = pageQuery.getParams();
            //            sql = dialect.getPaginationSql(sql, limit.getOffset(), limit.getLimit());
            //            params = dialect.getPaginationSqlParameter(params, limit.getOffset(), limit.getLimit());
        }
        return (E) jdbc.querySingle(sql, classMapping.getType(), params);
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public E unique() {
        String sql = getRoot().expression();
        Object[] params = getRoot().getParams().toArray();
        if (limit != null) {
            SqlPageQuery<Object[]> pageQuery = sqlPageFactory.toPage(dialect, sql, limit.getOffset(), limit.getLimit(),
                    params);
            sql = pageQuery.getSql();
            params = pageQuery.getParams();
            //            sql = dialect.getPaginationSql(sql, limit.getOffset(), limit.getLimit());
            //            params = dialect.getPaginationSqlParameter(params, limit.getOffset(), limit.getLimit());
        }
        return (E) jdbc.queryUnique(sql, classMapping.getType(), params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long count() {
        throw new UnsupportedException();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQuerySortExpression<E> sort() {
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQuerySortExpression<E> asc(String... names) {
        ((EntitySqlQueryConditionGroupExpression<E>) getRoot()).sortBuilder
                .asc(ClassMappingUtils.getColumnNames(classMapping, names));
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQuerySortExpression<E> asc(List<String> names) {
        ((EntitySqlQueryConditionGroupExpression<E>) getRoot()).sortBuilder
                .asc(ClassMappingUtils.getColumnNames(classMapping, names));
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> EntityQuerySortExpression<E> asc(SerializableFunction<T, R> name) {
        return asc(getPropertyName(name));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> EntityQuerySortExpression<E> asc(@SuppressWarnings("unchecked") SerializableFunction<T, R>... names) {
        String[] nameArray = Arrays.stream(names).map(LambdaUtils::getLambdaPropertyName)
                .toArray(value -> new String[value]);
        return asc(nameArray);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQuerySortExpression<E> desc(String... names) {
        ((EntitySqlQueryConditionGroupExpression<E>) getRoot()).sortBuilder
                .desc(ClassMappingUtils.getColumnNames(classMapping, names));
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQuerySortExpression<E> desc(List<String> names) {
        ((EntitySqlQueryConditionGroupExpression<E>) getRoot()).sortBuilder
                .desc(ClassMappingUtils.getColumnNames(classMapping, names));
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> EntityQuerySortExpression<E> desc(SerializableFunction<T, R> name) {
        return desc(getPropertyName(name));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T,
            R> EntityQuerySortExpression<E> desc(@SuppressWarnings("unchecked") SerializableFunction<T, R>... names) {
        String[] nameArray = Arrays.stream(names).map(LambdaUtils::getLambdaPropertyName)
                .toArray(value -> new String[value]);
        return desc(nameArray);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> EntityQueryConditionGroupLogicExpression<E> co(SerializableFunction<T, R> repository,
            ReturnStringFunction<R> property, Object value) {
        typeQueryEntity.with(repository);
        Tuple2<String, String> tuple = conditionResult(repository, property, value, factory);
        return (EntityQueryConditionGroupLogicExpression<E>) addCondition(new SqlConditionExpressionBuilder(dialect,
                tuple.get1(), value, QueryOperator.CO, aliasManager.getAlias(tuple.get0()), ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> EntityQueryConditionGroupLogicExpression<E> co(SerializableSupplier<T> repository,
            ReturnStringFunction<T> property) {
        typeQueryEntity.with(repository);
        Tuple3<String, String, Object> tuple = conditionResult(repository, property, factory);
        return (EntityQueryConditionGroupLogicExpression<E>) addCondition(new SqlConditionExpressionBuilder(dialect,
                tuple.get1(), tuple.get2(), QueryOperator.CO, aliasManager.getAlias(tuple.get0()), ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> EntityQueryConditionGroupLogicExpression<E> ew(SerializableFunction<T, R> repository,
            ReturnStringFunction<R> property, Object value) {
        typeQueryEntity.with(repository);
        Tuple2<String, String> tuple = conditionResult(repository, property, value, factory);
        return (EntityQueryConditionGroupLogicExpression<E>) addCondition(new SqlConditionExpressionBuilder(dialect,
                tuple.get1(), value, QueryOperator.EW, aliasManager.getAlias(tuple.get0()), ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> EntityQueryConditionGroupLogicExpression<E> ew(SerializableSupplier<T> repository,
            ReturnStringFunction<T> property) {
        typeQueryEntity.with(repository);
        Tuple3<String, String, Object> tuple = conditionResult(repository, property, factory);
        return (EntityQueryConditionGroupLogicExpression<E>) addCondition(new SqlConditionExpressionBuilder(dialect,
                tuple.get1(), tuple.get2(), QueryOperator.EW, aliasManager.getAlias(tuple.get0()), ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <O, T, R> EntityQueryConditionGroupLogicExpression<E> eq(SerializableFunction<O, T> repository,
            SerializableFunction<T, R> property, R value) {
        typeQueryEntity.with(repository);
        Tuple2<String, String> tuple = conditionResult(repository, property, value, factory);
        return (EntityQueryConditionGroupLogicExpression<E>) addCondition(new SqlConditionExpressionBuilder(dialect,
                tuple.get1(), value, QueryOperator.EQ, aliasManager.getAlias(tuple.get0()), ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> EntityQueryConditionGroupLogicExpression<E> eq(SerializableSupplier<T> repository,
            SerializableFunction<T, R> property) {
        typeQueryEntity.with(repository);
        Tuple3<String, String, Object> tuple = conditionResult(repository, property, factory);
        return (EntityQueryConditionGroupLogicExpression<E>) addCondition(new SqlConditionExpressionBuilder(dialect,
                tuple.get1(), tuple.get2(), QueryOperator.EQ, aliasManager.getAlias(tuple.get0()), ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R, N extends Number> EntityQueryConditionGroupLogicExpression<E> ge(
            SerializableFunction<T, R> repository, ReturnNumberFunction<R, N> property, N value) {
        typeQueryEntity.with(repository);
        Tuple2<String, String> tuple = conditionResult(repository, property, value, factory);
        return (EntityQueryConditionGroupLogicExpression<E>) addCondition(new SqlConditionExpressionBuilder(dialect,
                tuple.get1(), value, QueryOperator.GE, aliasManager.getAlias(tuple.get0()), ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, N extends Number> EntityQueryConditionGroupLogicExpression<E> ge(SerializableSupplier<T> repository,
            ReturnNumberFunction<T, N> property) {
        typeQueryEntity.with(repository);
        Tuple3<String, String, Object> tuple = conditionResult(repository, property, factory);
        return (EntityQueryConditionGroupLogicExpression<E>) addCondition(new SqlConditionExpressionBuilder(dialect,
                tuple.get1(), tuple.get2(), QueryOperator.GE, aliasManager.getAlias(tuple.get0()), ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R, D extends Date> EntityQueryConditionGroupLogicExpression<E> ge(SerializableFunction<T, R> repository,
            ReturnDateFunction<R, D> property, D value) {
        typeQueryEntity.with(repository);
        Tuple2<String, String> tuple = conditionResult(repository, property, value, factory);
        return (EntityQueryConditionGroupLogicExpression<E>) addCondition(new SqlConditionExpressionBuilder(dialect,
                tuple.get1(), value, QueryOperator.GE, aliasManager.getAlias(tuple.get0()), ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, D extends Date> EntityQueryConditionGroupLogicExpression<E> ge(SerializableSupplier<T> repository,
            ReturnDateFunction<T, D> property) {
        typeQueryEntity.with(repository);
        Tuple3<String, String, Object> tuple = conditionResult(repository, property, factory);
        return (EntityQueryConditionGroupLogicExpression<E>) addCondition(new SqlConditionExpressionBuilder(dialect,
                tuple.get1(), tuple.get2(), QueryOperator.GE, aliasManager.getAlias(tuple.get0()), ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> EntityQueryConditionGroupLogicExpression<E> ge(SerializableFunction<T, R> repository,
            ReturnLocalTimeFunction<R> property, LocalTime value) {
        typeQueryEntity.with(repository);
        Tuple2<String, String> tuple = conditionResult(repository, property, value, factory);
        return (EntityQueryConditionGroupLogicExpression<E>) addCondition(new SqlConditionExpressionBuilder(dialect,
                tuple.get1(), value, QueryOperator.GE, aliasManager.getAlias(tuple.get0()), ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> EntityQueryConditionGroupLogicExpression<E> ge(SerializableSupplier<T> repository,
            ReturnLocalTimeFunction<T> property) {
        typeQueryEntity.with(repository);
        Tuple3<String, String, Object> tuple = conditionResult(repository, property, factory);
        return (EntityQueryConditionGroupLogicExpression<E>) addCondition(new SqlConditionExpressionBuilder(dialect,
                tuple.get1(), tuple.get2(), QueryOperator.GE, aliasManager.getAlias(tuple.get0()), ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> EntityQueryConditionGroupLogicExpression<E> ge(SerializableFunction<T, R> repository,
            ReturnLocalDateFunction<R> property, LocalDate value) {
        typeQueryEntity.with(repository);
        Tuple2<String, String> tuple = conditionResult(repository, property, value, factory);
        return (EntityQueryConditionGroupLogicExpression<E>) addCondition(new SqlConditionExpressionBuilder(dialect,
                tuple.get1(), value, QueryOperator.GE, aliasManager.getAlias(tuple.get0()), ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> EntityQueryConditionGroupLogicExpression<E> ge(SerializableSupplier<T> repository,
            ReturnLocalDateFunction<T> property) {
        typeQueryEntity.with(repository);
        Tuple3<String, String, Object> tuple = conditionResult(repository, property, factory);
        return (EntityQueryConditionGroupLogicExpression<E>) addCondition(new SqlConditionExpressionBuilder(dialect,
                tuple.get1(), tuple.get2(), QueryOperator.GE, aliasManager.getAlias(tuple.get0()), ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> EntityQueryConditionGroupLogicExpression<E> ge(SerializableFunction<T, R> repository,
            ReturnLocalDateTimeFunction<R> property, LocalDateTime value) {
        typeQueryEntity.with(repository);
        Tuple2<String, String> tuple = conditionResult(repository, property, value, factory);
        return (EntityQueryConditionGroupLogicExpression<E>) addCondition(new SqlConditionExpressionBuilder(dialect,
                tuple.get1(), value, QueryOperator.GE, aliasManager.getAlias(tuple.get0()), ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> EntityQueryConditionGroupLogicExpression<E> ge(SerializableSupplier<T> repository,
            ReturnLocalDateTimeFunction<T> property) {
        typeQueryEntity.with(repository);
        Tuple3<String, String, Object> tuple = conditionResult(repository, property, factory);
        return (EntityQueryConditionGroupLogicExpression<E>) addCondition(new SqlConditionExpressionBuilder(dialect,
                tuple.get1(), tuple.get2(), QueryOperator.GE, aliasManager.getAlias(tuple.get0()), ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> EntityQueryConditionGroupLogicExpression<E> ge(SerializableFunction<T, R> repository,
            ReturnStringFunction<R> property, String value) {
        typeQueryEntity.with(repository);
        Tuple2<String, String> tuple = conditionResult(repository, property, value, factory);
        return (EntityQueryConditionGroupLogicExpression<E>) addCondition(new SqlConditionExpressionBuilder(dialect,
                tuple.get1(), value, QueryOperator.GE, aliasManager.getAlias(tuple.get0()), ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> EntityQueryConditionGroupLogicExpression<E> ge(SerializableSupplier<T> repository,
            ReturnStringFunction<T> property) {
        typeQueryEntity.with(repository);
        Tuple3<String, String, Object> tuple = conditionResult(repository, property, factory);
        return (EntityQueryConditionGroupLogicExpression<E>) addCondition(new SqlConditionExpressionBuilder(dialect,
                tuple.get1(), tuple.get2(), QueryOperator.GE, aliasManager.getAlias(tuple.get0()), ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R, N extends Number> EntityQueryConditionGroupLogicExpression<E> gt(
            SerializableFunction<T, R> repository, ReturnNumberFunction<R, N> property, N value) {
        typeQueryEntity.with(repository);
        Tuple2<String, String> tuple = conditionResult(repository, property, value, factory);
        return (EntityQueryConditionGroupLogicExpression<E>) addCondition(new SqlConditionExpressionBuilder(dialect,
                tuple.get1(), value, QueryOperator.GT, aliasManager.getAlias(tuple.get0()), ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, N extends Number> EntityQueryConditionGroupLogicExpression<E> gt(SerializableSupplier<T> repository,
            ReturnNumberFunction<T, N> property) {
        typeQueryEntity.with(repository);
        Tuple3<String, String, Object> tuple = conditionResult(repository, property, factory);
        return (EntityQueryConditionGroupLogicExpression<E>) addCondition(new SqlConditionExpressionBuilder(dialect,
                tuple.get1(), tuple.get2(), QueryOperator.GT, aliasManager.getAlias(tuple.get0()), ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R, D extends Date> EntityQueryConditionGroupLogicExpression<E> gt(SerializableFunction<T, R> repository,
            ReturnDateFunction<R, D> property, D value) {
        typeQueryEntity.with(repository);
        Tuple2<String, String> tuple = conditionResult(repository, property, value, factory);
        return (EntityQueryConditionGroupLogicExpression<E>) addCondition(new SqlConditionExpressionBuilder(dialect,
                tuple.get1(), value, QueryOperator.GT, aliasManager.getAlias(tuple.get0()), ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, D extends Date> EntityQueryConditionGroupLogicExpression<E> gt(SerializableSupplier<T> repository,
            ReturnDateFunction<T, D> property) {
        typeQueryEntity.with(repository);
        Tuple3<String, String, Object> tuple = conditionResult(repository, property, factory);
        return (EntityQueryConditionGroupLogicExpression<E>) addCondition(new SqlConditionExpressionBuilder(dialect,
                tuple.get1(), tuple.get2(), QueryOperator.GT, aliasManager.getAlias(tuple.get0()), ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> EntityQueryConditionGroupLogicExpression<E> gt(SerializableFunction<T, R> repository,
            ReturnLocalTimeFunction<R> property, LocalTime value) {
        typeQueryEntity.with(repository);
        Tuple2<String, String> tuple = conditionResult(repository, property, value, factory);
        return (EntityQueryConditionGroupLogicExpression<E>) addCondition(new SqlConditionExpressionBuilder(dialect,
                tuple.get1(), value, QueryOperator.GT, aliasManager.getAlias(tuple.get0()), ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> EntityQueryConditionGroupLogicExpression<E> gt(SerializableSupplier<T> repository,
            ReturnLocalTimeFunction<T> property) {
        typeQueryEntity.with(repository);
        Tuple3<String, String, Object> tuple = conditionResult(repository, property, factory);
        return (EntityQueryConditionGroupLogicExpression<E>) addCondition(new SqlConditionExpressionBuilder(dialect,
                tuple.get1(), tuple.get2(), QueryOperator.GT, aliasManager.getAlias(tuple.get0()), ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> EntityQueryConditionGroupLogicExpression<E> gt(SerializableFunction<T, R> repository,
            ReturnLocalDateFunction<R> property, LocalDate value) {
        typeQueryEntity.with(repository);
        Tuple2<String, String> tuple = conditionResult(repository, property, value, factory);
        return (EntityQueryConditionGroupLogicExpression<E>) addCondition(new SqlConditionExpressionBuilder(dialect,
                tuple.get1(), value, QueryOperator.GT, aliasManager.getAlias(tuple.get0()), ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> EntityQueryConditionGroupLogicExpression<E> gt(SerializableSupplier<T> repository,
            ReturnLocalDateFunction<T> property) {
        typeQueryEntity.with(repository);
        Tuple3<String, String, Object> tuple = conditionResult(repository, property, factory);
        return (EntityQueryConditionGroupLogicExpression<E>) addCondition(new SqlConditionExpressionBuilder(dialect,
                tuple.get1(), tuple.get2(), QueryOperator.GT, aliasManager.getAlias(tuple.get0()), ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> EntityQueryConditionGroupLogicExpression<E> gt(SerializableFunction<T, R> repository,
            ReturnLocalDateTimeFunction<R> property, LocalDateTime value) {
        typeQueryEntity.with(repository);
        Tuple2<String, String> tuple = conditionResult(repository, property, value, factory);
        return (EntityQueryConditionGroupLogicExpression<E>) addCondition(new SqlConditionExpressionBuilder(dialect,
                tuple.get1(), value, QueryOperator.GT, aliasManager.getAlias(tuple.get0()), ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> EntityQueryConditionGroupLogicExpression<E> gt(SerializableSupplier<T> repository,
            ReturnLocalDateTimeFunction<T> property) {
        typeQueryEntity.with(repository);
        Tuple3<String, String, Object> tuple = conditionResult(repository, property, factory);
        return (EntityQueryConditionGroupLogicExpression<E>) addCondition(new SqlConditionExpressionBuilder(dialect,
                tuple.get1(), tuple.get2(), QueryOperator.GT, aliasManager.getAlias(tuple.get0()), ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> EntityQueryConditionGroupLogicExpression<E> gt(SerializableFunction<T, R> repository,
            ReturnStringFunction<R> property, String value) {
        typeQueryEntity.with(repository);
        Tuple2<String, String> tuple = conditionResult(repository, property, value, factory);
        return (EntityQueryConditionGroupLogicExpression<E>) addCondition(new SqlConditionExpressionBuilder(dialect,
                tuple.get1(), value, QueryOperator.GT, aliasManager.getAlias(tuple.get0()), ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> EntityQueryConditionGroupLogicExpression<E> gt(SerializableSupplier<T> repository,
            ReturnStringFunction<T> property) {
        typeQueryEntity.with(repository);
        Tuple3<String, String, Object> tuple = conditionResult(repository, property, factory);
        return (EntityQueryConditionGroupLogicExpression<E>) addCondition(new SqlConditionExpressionBuilder(dialect,
                tuple.get1(), tuple.get2(), QueryOperator.GT, aliasManager.getAlias(tuple.get0()), ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <O, T, R> EntityQueryConditionGroupLogicExpression<E> in(SerializableFunction<O, T> repository,
            SerializableFunction<T, R> property, Object value) {
        typeQueryEntity.with(repository);
        Tuple2<String, String> tuple = conditionResult(repository, property, value, factory);
        return (EntityQueryConditionGroupLogicExpression<E>) addCondition(new SqlConditionExpressionBuilder(dialect,
                tuple.get1(), value, QueryOperator.IN, aliasManager.getAlias(tuple.get0()), ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> EntityQueryConditionGroupLogicExpression<E> in(SerializableSupplier<T> repository,
            SerializableFunction<T, R> property) {
        typeQueryEntity.with(repository);
        Tuple3<String, String, Object> tuple = conditionResult(repository, property, factory);
        return (EntityQueryConditionGroupLogicExpression<E>) addCondition(new SqlConditionExpressionBuilder(dialect,
                tuple.get1(), tuple.get2(), QueryOperator.IN, aliasManager.getAlias(tuple.get0()), ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <O, T, R> EntityQueryConditionGroupLogicExpression<E> inn(SerializableFunction<O, T> repository,
            SerializableFunction<T, R> property) {
        return inn(repository, property, true);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <O, T, R> EntityQueryConditionGroupLogicExpression<E> inn(SerializableFunction<O, T> repository,
            SerializableFunction<T, R> property, Boolean value) {
        typeQueryEntity.with(repository);
        Tuple2<String, String> tuple = conditionResult(repository, property, value, factory);
        return (EntityQueryConditionGroupLogicExpression<E>) addCondition(new SqlConditionExpressionBuilder(dialect,
                tuple.get1(), value, QueryOperator.INN, aliasManager.getAlias(tuple.get0()), ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <O, T, R> EntityQueryConditionGroupLogicExpression<E> isn(SerializableFunction<O, T> repository,
            SerializableFunction<T, R> property) {
        return isn(repository, property, true);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <O, T, R> EntityQueryConditionGroupLogicExpression<E> isn(SerializableFunction<O, T> repository,
            SerializableFunction<T, R> property, Boolean value) {
        typeQueryEntity.with(repository);
        Tuple2<String, String> tuple = conditionResult(repository, property, value, factory);
        return (EntityQueryConditionGroupLogicExpression<E>) addCondition(new SqlConditionExpressionBuilder(dialect,
                tuple.get1(), value, QueryOperator.ISN, aliasManager.getAlias(tuple.get0()), ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R, N extends Number> EntityQueryConditionGroupLogicExpression<E> le(
            SerializableFunction<T, R> repository, ReturnNumberFunction<R, N> property, N value) {
        typeQueryEntity.with(repository);
        Tuple2<String, String> tuple = conditionResult(repository, property, value, factory);
        return (EntityQueryConditionGroupLogicExpression<E>) addCondition(new SqlConditionExpressionBuilder(dialect,
                tuple.get1(), value, QueryOperator.LE, aliasManager.getAlias(tuple.get0()), ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, N extends Number> EntityQueryConditionGroupLogicExpression<E> le(SerializableSupplier<T> repository,
            ReturnNumberFunction<T, N> property) {
        typeQueryEntity.with(repository);
        Tuple3<String, String, Object> tuple = conditionResult(repository, property, factory);
        return (EntityQueryConditionGroupLogicExpression<E>) addCondition(new SqlConditionExpressionBuilder(dialect,
                tuple.get1(), tuple.get2(), QueryOperator.LE, aliasManager.getAlias(tuple.get0()), ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R, D extends Date> EntityQueryConditionGroupLogicExpression<E> le(SerializableFunction<T, R> repository,
            ReturnDateFunction<R, D> property, D value) {
        typeQueryEntity.with(repository);
        Tuple2<String, String> tuple = conditionResult(repository, property, value, factory);
        return (EntityQueryConditionGroupLogicExpression<E>) addCondition(new SqlConditionExpressionBuilder(dialect,
                tuple.get1(), value, QueryOperator.LE, aliasManager.getAlias(tuple.get0()), ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, D extends Date> EntityQueryConditionGroupLogicExpression<E> le(SerializableSupplier<T> repository,
            ReturnDateFunction<T, D> property) {
        typeQueryEntity.with(repository);
        Tuple3<String, String, Object> tuple = conditionResult(repository, property, factory);
        return (EntityQueryConditionGroupLogicExpression<E>) addCondition(new SqlConditionExpressionBuilder(dialect,
                tuple.get1(), tuple.get2(), QueryOperator.LE, aliasManager.getAlias(tuple.get0()), ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> EntityQueryConditionGroupLogicExpression<E> le(SerializableFunction<T, R> repository,
            ReturnLocalTimeFunction<R> property, LocalTime value) {
        typeQueryEntity.with(repository);
        Tuple2<String, String> tuple = conditionResult(repository, property, value, factory);
        return (EntityQueryConditionGroupLogicExpression<E>) addCondition(new SqlConditionExpressionBuilder(dialect,
                tuple.get1(), value, QueryOperator.LE, aliasManager.getAlias(tuple.get0()), ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> EntityQueryConditionGroupLogicExpression<E> le(SerializableSupplier<T> repository,
            ReturnLocalTimeFunction<T> property) {
        typeQueryEntity.with(repository);
        Tuple3<String, String, Object> tuple = conditionResult(repository, property, factory);
        return (EntityQueryConditionGroupLogicExpression<E>) addCondition(new SqlConditionExpressionBuilder(dialect,
                tuple.get1(), tuple.get2(), QueryOperator.LE, aliasManager.getAlias(tuple.get0()), ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> EntityQueryConditionGroupLogicExpression<E> le(SerializableFunction<T, R> repository,
            ReturnLocalDateFunction<R> property, LocalDate value) {
        typeQueryEntity.with(repository);
        Tuple2<String, String> tuple = conditionResult(repository, property, value, factory);
        return (EntityQueryConditionGroupLogicExpression<E>) addCondition(new SqlConditionExpressionBuilder(dialect,
                tuple.get1(), value, QueryOperator.LE, aliasManager.getAlias(tuple.get0()), ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> EntityQueryConditionGroupLogicExpression<E> le(SerializableSupplier<T> repository,
            ReturnLocalDateFunction<T> property) {
        typeQueryEntity.with(repository);
        Tuple3<String, String, Object> tuple = conditionResult(repository, property, factory);
        return (EntityQueryConditionGroupLogicExpression<E>) addCondition(new SqlConditionExpressionBuilder(dialect,
                tuple.get1(), tuple.get2(), QueryOperator.LE, aliasManager.getAlias(tuple.get0()), ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> EntityQueryConditionGroupLogicExpression<E> le(SerializableFunction<T, R> repository,
            ReturnLocalDateTimeFunction<R> property, LocalDateTime value) {
        typeQueryEntity.with(repository);
        Tuple2<String, String> tuple = conditionResult(repository, property, value, factory);
        return (EntityQueryConditionGroupLogicExpression<E>) addCondition(new SqlConditionExpressionBuilder(dialect,
                tuple.get1(), value, QueryOperator.LE, aliasManager.getAlias(tuple.get0()), ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> EntityQueryConditionGroupLogicExpression<E> le(SerializableSupplier<T> repository,
            ReturnLocalDateTimeFunction<T> property) {
        typeQueryEntity.with(repository);
        Tuple3<String, String, Object> tuple = conditionResult(repository, property, factory);
        return (EntityQueryConditionGroupLogicExpression<E>) addCondition(new SqlConditionExpressionBuilder(dialect,
                tuple.get1(), tuple.get2(), QueryOperator.LE, aliasManager.getAlias(tuple.get0()), ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> EntityQueryConditionGroupLogicExpression<E> le(SerializableFunction<T, R> repository,
            ReturnStringFunction<R> property, String value) {
        typeQueryEntity.with(repository);
        Tuple2<String, String> tuple = conditionResult(repository, property, value, factory);
        return (EntityQueryConditionGroupLogicExpression<E>) addCondition(new SqlConditionExpressionBuilder(dialect,
                tuple.get1(), value, QueryOperator.LE, aliasManager.getAlias(tuple.get0()), ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> EntityQueryConditionGroupLogicExpression<E> le(SerializableSupplier<T> repository,
            ReturnStringFunction<T> property) {
        typeQueryEntity.with(repository);
        Tuple3<String, String, Object> tuple = conditionResult(repository, property, factory);
        return (EntityQueryConditionGroupLogicExpression<E>) addCondition(new SqlConditionExpressionBuilder(dialect,
                tuple.get1(), tuple.get2(), QueryOperator.LE, aliasManager.getAlias(tuple.get0()), ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R, N extends Number> EntityQueryConditionGroupLogicExpression<E> lt(
            SerializableFunction<T, R> repository, ReturnNumberFunction<R, N> property, N value) {
        typeQueryEntity.with(repository);
        Tuple2<String, String> tuple = conditionResult(repository, property, value, factory);
        return (EntityQueryConditionGroupLogicExpression<E>) addCondition(new SqlConditionExpressionBuilder(dialect,
                tuple.get1(), value, QueryOperator.LT, aliasManager.getAlias(tuple.get0()), ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, N extends Number> EntityQueryConditionGroupLogicExpression<E> lt(SerializableSupplier<T> repository,
            ReturnNumberFunction<T, N> property) {
        typeQueryEntity.with(repository);
        Tuple3<String, String, Object> tuple = conditionResult(repository, property, factory);
        return (EntityQueryConditionGroupLogicExpression<E>) addCondition(new SqlConditionExpressionBuilder(dialect,
                tuple.get1(), tuple.get2(), QueryOperator.LT, aliasManager.getAlias(tuple.get0()), ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R, D extends Date> EntityQueryConditionGroupLogicExpression<E> lt(SerializableFunction<T, R> repository,
            ReturnDateFunction<R, D> property, D value) {
        typeQueryEntity.with(repository);
        Tuple2<String, String> tuple = conditionResult(repository, property, value, factory);
        return (EntityQueryConditionGroupLogicExpression<E>) addCondition(new SqlConditionExpressionBuilder(dialect,
                tuple.get1(), value, QueryOperator.LT, aliasManager.getAlias(tuple.get0()), ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, D extends Date> EntityQueryConditionGroupLogicExpression<E> lt(SerializableSupplier<T> repository,
            ReturnDateFunction<T, D> property) {
        typeQueryEntity.with(repository);
        Tuple3<String, String, Object> tuple = conditionResult(repository, property, factory);
        return (EntityQueryConditionGroupLogicExpression<E>) addCondition(new SqlConditionExpressionBuilder(dialect,
                tuple.get1(), tuple.get2(), QueryOperator.LT, aliasManager.getAlias(tuple.get0()), ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> EntityQueryConditionGroupLogicExpression<E> lt(SerializableFunction<T, R> repository,
            ReturnLocalTimeFunction<R> property, LocalTime value) {
        typeQueryEntity.with(repository);
        Tuple2<String, String> tuple = conditionResult(repository, property, value, factory);
        return (EntityQueryConditionGroupLogicExpression<E>) addCondition(new SqlConditionExpressionBuilder(dialect,
                tuple.get1(), value, QueryOperator.LT, aliasManager.getAlias(tuple.get0()), ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> EntityQueryConditionGroupLogicExpression<E> lt(SerializableSupplier<T> repository,
            ReturnLocalTimeFunction<T> property) {
        typeQueryEntity.with(repository);
        Tuple3<String, String, Object> tuple = conditionResult(repository, property, factory);
        return (EntityQueryConditionGroupLogicExpression<E>) addCondition(new SqlConditionExpressionBuilder(dialect,
                tuple.get1(), tuple.get2(), QueryOperator.LT, aliasManager.getAlias(tuple.get0()), ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> EntityQueryConditionGroupLogicExpression<E> lt(SerializableFunction<T, R> repository,
            ReturnLocalDateFunction<R> property, LocalDate value) {
        typeQueryEntity.with(repository);
        Tuple2<String, String> tuple = conditionResult(repository, property, value, factory);
        return (EntityQueryConditionGroupLogicExpression<E>) addCondition(new SqlConditionExpressionBuilder(dialect,
                tuple.get1(), value, QueryOperator.LT, aliasManager.getAlias(tuple.get0()), ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> EntityQueryConditionGroupLogicExpression<E> lt(SerializableSupplier<T> repository,
            ReturnLocalDateFunction<T> property) {
        typeQueryEntity.with(repository);
        Tuple3<String, String, Object> tuple = conditionResult(repository, property, factory);
        return (EntityQueryConditionGroupLogicExpression<E>) addCondition(new SqlConditionExpressionBuilder(dialect,
                tuple.get1(), tuple.get2(), QueryOperator.LT, aliasManager.getAlias(tuple.get0()), ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> EntityQueryConditionGroupLogicExpression<E> lt(SerializableFunction<T, R> repository,
            ReturnLocalDateTimeFunction<R> property, LocalDateTime value) {
        typeQueryEntity.with(repository);
        Tuple2<String, String> tuple = conditionResult(repository, property, value, factory);
        return (EntityQueryConditionGroupLogicExpression<E>) addCondition(new SqlConditionExpressionBuilder(dialect,
                tuple.get1(), value, QueryOperator.LT, aliasManager.getAlias(tuple.get0()), ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> EntityQueryConditionGroupLogicExpression<E> lt(SerializableSupplier<T> repository,
            ReturnLocalDateTimeFunction<T> property) {
        typeQueryEntity.with(repository);
        Tuple3<String, String, Object> tuple = conditionResult(repository, property, factory);
        return (EntityQueryConditionGroupLogicExpression<E>) addCondition(new SqlConditionExpressionBuilder(dialect,
                tuple.get1(), tuple.get2(), QueryOperator.LT, aliasManager.getAlias(tuple.get0()), ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> EntityQueryConditionGroupLogicExpression<E> lt(SerializableFunction<T, R> repository,
            ReturnStringFunction<R> property, String value) {
        typeQueryEntity.with(repository);
        Tuple2<String, String> tuple = conditionResult(repository, property, value, factory);
        return (EntityQueryConditionGroupLogicExpression<E>) addCondition(new SqlConditionExpressionBuilder(dialect,
                tuple.get1(), value, QueryOperator.LT, aliasManager.getAlias(tuple.get0()), ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> EntityQueryConditionGroupLogicExpression<E> lt(SerializableSupplier<T> repository,
            ReturnStringFunction<T> property) {
        typeQueryEntity.with(repository);
        Tuple3<String, String, Object> tuple = conditionResult(repository, property, factory);
        return (EntityQueryConditionGroupLogicExpression<E>) addCondition(new SqlConditionExpressionBuilder(dialect,
                tuple.get1(), tuple.get2(), QueryOperator.LT, aliasManager.getAlias(tuple.get0()), ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <O, T, R> EntityQueryConditionGroupLogicExpression<E> ne(SerializableFunction<O, T> repository,
            SerializableFunction<T, R> property, R value) {
        typeQueryEntity.with(repository);
        Tuple2<String, String> tuple = conditionResult(repository, property, value, factory);
        return (EntityQueryConditionGroupLogicExpression<E>) addCondition(new SqlConditionExpressionBuilder(dialect,
                tuple.get1(), value, QueryOperator.EQ, aliasManager.getAlias(tuple.get0()), ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> EntityQueryConditionGroupLogicExpression<E> ne(SerializableSupplier<T> repository,
            SerializableFunction<T, R> property) {
        typeQueryEntity.with(repository);
        Tuple3<String, String, Object> tuple = conditionResult(repository, property, factory);
        return (EntityQueryConditionGroupLogicExpression<E>) addCondition(new SqlConditionExpressionBuilder(dialect,
                tuple.get1(), tuple.get2(), QueryOperator.NE, aliasManager.getAlias(tuple.get0()), ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <O, T, R> EntityQueryConditionGroupLogicExpression<E> nin(SerializableFunction<O, T> repository,
            SerializableFunction<T, R> property, Object value) {
        typeQueryEntity.with(repository);
        Tuple2<String, String> tuple = conditionResult(repository, property, value, factory);
        return (EntityQueryConditionGroupLogicExpression<E>) addCondition(new SqlConditionExpressionBuilder(dialect,
                tuple.get1(), value, QueryOperator.NIN, aliasManager.getAlias(tuple.get0()), ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> EntityQueryConditionGroupLogicExpression<E> nin(SerializableSupplier<T> repository,
            SerializableFunction<T, R> property) {
        typeQueryEntity.with(repository);
        Tuple3<String, String, Object> tuple = conditionResult(repository, property, factory);
        return (EntityQueryConditionGroupLogicExpression<E>) addCondition(new SqlConditionExpressionBuilder(dialect,
                tuple.get1(), tuple.get2(), QueryOperator.NE, aliasManager.getAlias(tuple.get0()), ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> EntityQueryConditionGroupLogicExpression<E> sw(SerializableFunction<T, R> repository,
            ReturnStringFunction<R> property, Object value) {
        typeQueryEntity.with(repository);
        Tuple2<String, String> tuple = conditionResult(repository, property, value, factory);
        return (EntityQueryConditionGroupLogicExpression<E>) addCondition(new SqlConditionExpressionBuilder(dialect,
                tuple.get1(), value, QueryOperator.SW, aliasManager.getAlias(tuple.get0()), ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> EntityQueryConditionGroupLogicExpression<E> sw(SerializableSupplier<T> repository,
            ReturnStringFunction<T> property) {
        typeQueryEntity.with(repository);
        Tuple3<String, String, Object> tuple = conditionResult(repository, property, factory);
        return (EntityQueryConditionGroupLogicExpression<E>) addCondition(new SqlConditionExpressionBuilder(dialect,
                tuple.get1(), tuple.get2(), QueryOperator.SW, aliasManager.getAlias(tuple.get0()), ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> EntityQueryConditionGroupLogicExpression<E> lk(SerializableFunction<T, R> repository,
            ReturnStringFunction<R> property, Object value) {
        typeQueryEntity.with(repository);
        Tuple2<String, String> tuple = conditionResult(repository, property, value, factory);
        return (EntityQueryConditionGroupLogicExpression<E>) addCondition(new SqlConditionExpressionBuilder(dialect,
                tuple.get1(), value, QueryOperator.LK, aliasManager.getAlias(tuple.get0()), ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> EntityQueryConditionGroupLogicExpression<E> lk(SerializableSupplier<T> repository,
            ReturnStringFunction<T> property) {
        typeQueryEntity.with(repository);
        Tuple3<String, String, Object> tuple = conditionResult(repository, property, factory);
        return (EntityQueryConditionGroupLogicExpression<E>) addCondition(new SqlConditionExpressionBuilder(dialect,
                tuple.get1(), tuple.get2(), QueryOperator.LK, aliasManager.getAlias(tuple.get0()), ignorePolicy));
    }
}
