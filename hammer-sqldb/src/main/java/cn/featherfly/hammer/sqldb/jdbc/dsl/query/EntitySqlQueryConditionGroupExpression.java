
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
import cn.featherfly.common.db.mapping.JdbcClassMapping;
import cn.featherfly.common.db.mapping.JdbcMappingFactory;
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
import cn.featherfly.common.operator.QueryOperator;
import cn.featherfly.common.repository.builder.AliasManager;
import cn.featherfly.common.structure.page.Limit;
import cn.featherfly.common.structure.page.Page;
import cn.featherfly.common.structure.page.PaginationResults;
import cn.featherfly.common.structure.page.SimplePaginationResults;
import cn.featherfly.hammer.dsl.query.type.EntityQueryConditionGroupExpression;
import cn.featherfly.hammer.dsl.query.type.EntityQueryConditionGroupLogicExpression;
import cn.featherfly.hammer.dsl.query.type.EntityQuerySortExpression;
import cn.featherfly.hammer.expression.query.type.EntityQueryLimitExecutor;
import cn.featherfly.hammer.sqldb.jdbc.Jdbc;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory.SqlPageQuery;
import cn.featherfly.hammer.sqldb.sql.dml.AbstractEntitySqlConditionGroupExpression;
import cn.featherfly.hammer.sqldb.sql.dml.SqlConditionExpressionBuilder;

/**
 * sql condition group builder sql条件逻辑组构造器 .
 *
 * @author zhongj
 */
public class EntitySqlQueryConditionGroupExpression<E> extends
        AbstractEntitySqlConditionGroupExpression<E, EntityQueryConditionGroupExpression<E>, EntityQueryConditionGroupLogicExpression<E>>
        implements EntityQueryConditionGroupExpression<E>, EntityQueryConditionGroupLogicExpression<E>,
        EntityQuerySortExpression<E> {

    /** The sort builder. */
    private SqlSortBuilder sortBuilder = new SqlSortBuilder(dialect);

    /** The limit. */
    private Limit limit;

    /** The factory. */
    protected JdbcMappingFactory factory;

    /** The alias manager. */
    protected AliasManager aliasManager;

    /**
     * Instantiates a new type sql query condition group expression.
     *
     * @param jdbc              jdbc
     * @param classMapping      classMapping
     * @param factory           the factory
     * @param sqlPageFactory    the sql page factory
     * @param aliasManager      the alias manager
     * @param entityQueryEntity the entity query entity
     * @param ignorePolicy      the ignore policy
     */
    public EntitySqlQueryConditionGroupExpression(Jdbc jdbc, JdbcClassMapping<E> classMapping,
            JdbcMappingFactory factory, SqlPageFactory sqlPageFactory, AliasManager aliasManager,
            EntitySqlQuery<E> entityQueryEntity, Predicate<Object> ignorePolicy) {
        this(jdbc, null, classMapping, factory, sqlPageFactory, aliasManager, entityQueryEntity, ignorePolicy);
    }

    /**
     * Instantiates a new type sql query condition group expression.
     *
     * @param jdbc              jdbc
     * @param queryAlias        queryAlias
     * @param classMapping      classMapping
     * @param factory           the factory
     * @param sqlPageFactory    the sql page factory
     * @param aliasManager      the alias manager
     * @param entityQueryEntity the entity query entity
     * @param ignorePolicy      the ignore policy
     */
    public EntitySqlQueryConditionGroupExpression(Jdbc jdbc, String queryAlias, JdbcClassMapping<E> classMapping,
            JdbcMappingFactory factory, SqlPageFactory sqlPageFactory, AliasManager aliasManager,
            EntitySqlQuery<E> entityQueryEntity, Predicate<Object> ignorePolicy) {
        this(null, jdbc, queryAlias, classMapping, factory, sqlPageFactory, aliasManager, entityQueryEntity,
                ignorePolicy);
    }

    /**
     * Instantiates a new type sql query condition group expression.
     *
     * @param parent            parent group
     * @param jdbc              the jdbc
     * @param queryAlias        queryAlias
     * @param classMapping      classMapping
     * @param factory           the factory
     * @param sqlPageFactory    the sql page factory
     * @param aliasManager      the alias manager
     * @param entityQueryEntity the entity query entity
     * @param ignorePolicy      the ignore policy
     */
    EntitySqlQueryConditionGroupExpression(EntityQueryConditionGroupLogicExpression<E> parent, Jdbc jdbc,
            String queryAlias, JdbcClassMapping<E> classMapping, JdbcMappingFactory factory,
            SqlPageFactory sqlPageFactory, AliasManager aliasManager, EntitySqlQuery<E> entityQueryEntity,
            Predicate<Object> ignorePolicy) {
        super(parent, jdbc.getDialect(), sqlPageFactory, queryAlias, classMapping, entityQueryEntity, ignorePolicy);
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
            String queryAlias, EntitySqlQuery<E> entityQueryEntity) {
        return new EntitySqlQueryConditionGroupExpression(parent, jdbc, queryAlias, classMapping, factory,
                sqlPageFactory, aliasManager, entityQueryEntity, ignorePolicy);
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
        // IMPLSOON 后续来实现
        throw new UnsupportedException();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQuerySortExpression<E> sort() {
        return this;
    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    public EntityQuerySortExpression<E> asc(String... names) {
        ((EntitySqlQueryConditionGroupExpression<E>) getRoot()).sortBuilder
                .asc(ClassMappingUtils.getColumnNames(classMapping, names));
        return this;
    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    public EntityQuerySortExpression<E> asc(List<String> names) {
        // YUFEI_TODO asc desc 需要和强类型绑定
        ((EntitySqlQueryConditionGroupExpression<E>) getRoot()).sortBuilder
                .asc(ClassMappingUtils.getColumnNames(classMapping, names));
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> EntityQuerySortExpression<E> asc(SerializableFunction<E, R> name) {
        // YUFEI_TODO asc desc 需要和强类型绑定
        return asc(getPropertyName(name));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> EntityQuerySortExpression<E> asc(@SuppressWarnings("unchecked") SerializableFunction<E, R>... names) {
        String[] nameArray = Arrays.stream(names).map(LambdaUtils::getLambdaPropertyName)
                .toArray(value -> new String[value]);
        return asc(nameArray);
    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    public EntityQuerySortExpression<E> desc(String... names) {
        ((EntitySqlQueryConditionGroupExpression<E>) getRoot()).sortBuilder
                .desc(ClassMappingUtils.getColumnNames(classMapping, names));
        return this;
    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    public EntityQuerySortExpression<E> desc(List<String> names) {
        ((EntitySqlQueryConditionGroupExpression<E>) getRoot()).sortBuilder
                .desc(ClassMappingUtils.getColumnNames(classMapping, names));
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> EntityQuerySortExpression<E> desc(SerializableFunction<E, R> name) {
        return desc(getPropertyName(name));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> EntityQuerySortExpression<E> desc(@SuppressWarnings("unchecked") SerializableFunction<E, R>... names) {
        String[] nameArray = Arrays.stream(names).map(LambdaUtils::getLambdaPropertyName)
                .toArray(value -> new String[value]);
        return desc(nameArray);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> EntityQueryConditionGroupLogicExpression<E> co(SerializableFunction<E, R> repository,
            SerializableFunction<R, String> property, String value) {
        //        IMPLSOON 后续来实现join
        //         //        IMPLSOON 后续来实现join
        //        entityQuery.join(repository);
        Tuple2<String, String> tuple = conditionResult(repository, property, value, factory);
        return (EntityQueryConditionGroupLogicExpression<E>) addCondition(new SqlConditionExpressionBuilder(dialect,
                tuple.get1(), value, QueryOperator.CO, aliasManager.getAlias(tuple.get0()), ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> EntityQueryConditionGroupLogicExpression<E> co(SerializableSupplier<R> repository,
            SerializableFunction<R, String> property) {
        //        IMPLSOON 后续来实现join
        //         //        IMPLSOON 后续来实现join
        //        entityQuery.join(repository);
        Tuple3<String, String, Object> tuple = conditionResult(repository, property, factory);
        return (EntityQueryConditionGroupLogicExpression<E>) addCondition(new SqlConditionExpressionBuilder(dialect,
                tuple.get1(), tuple.get2(), QueryOperator.CO, aliasManager.getAlias(tuple.get0()), ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> EntityQueryConditionGroupLogicExpression<E> ew(SerializableFunction<E, R> repository,
            SerializableFunction<R, String> property, String value) {
        //        IMPLSOON 后续来实现join
        //         //        IMPLSOON 后续来实现join
        //        entityQuery.join(repository);
        Tuple2<String, String> tuple = conditionResult(repository, property, value, factory);
        return (EntityQueryConditionGroupLogicExpression<E>) addCondition(new SqlConditionExpressionBuilder(dialect,
                tuple.get1(), value, QueryOperator.EW, aliasManager.getAlias(tuple.get0()), ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> EntityQueryConditionGroupLogicExpression<E> ew(SerializableSupplier<R> repository,
            SerializableFunction<R, String> property) {
        //        IMPLSOON 后续来实现join
        //         //        IMPLSOON 后续来实现join
        //        entityQuery.join(repository);
        Tuple3<String, String, Object> tuple = conditionResult(repository, property, factory);
        return (EntityQueryConditionGroupLogicExpression<E>) addCondition(new SqlConditionExpressionBuilder(dialect,
                tuple.get1(), tuple.get2(), QueryOperator.EW, aliasManager.getAlias(tuple.get0()), ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R, V> EntityQueryConditionGroupLogicExpression<E> eq(SerializableFunction<E, R> repository,
            SerializableFunction<R, V> property, V value) {
        //        IMPLSOON 后续来实现join
        //         //        IMPLSOON 后续来实现join
        //        entityQuery.join(repository);
        Tuple2<String, String> tuple = conditionResult(repository, property, value, factory);
        return (EntityQueryConditionGroupLogicExpression<E>) addCondition(new SqlConditionExpressionBuilder(dialect,
                tuple.get1(), value, QueryOperator.EQ, aliasManager.getAlias(tuple.get0()), ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R, V> EntityQueryConditionGroupLogicExpression<E> eq(SerializableSupplier<R> repository,
            SerializableFunction<R, V> property) {
        //        IMPLSOON 后续来实现join
        //        entityQuery.join(repository);
        Tuple3<String, String, Object> tuple = conditionResult(repository, property, factory);
        return (EntityQueryConditionGroupLogicExpression<E>) addCondition(new SqlConditionExpressionBuilder(dialect,
                tuple.get1(), tuple.get2(), QueryOperator.EQ, aliasManager.getAlias(tuple.get0()), ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R, N extends Number> EntityQueryConditionGroupLogicExpression<E> ge(SerializableFunction<E, R> repository,
            SerializableFunction<R, N> property, N value) {
        //        IMPLSOON 后续来实现join
        //        entityQuery.join(repository);
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
        //        IMPLSOON 后续来实现join
        //        entityQuery.join(repository);
        Tuple3<String, String, Object> tuple = conditionResult(repository, property, factory);
        return (EntityQueryConditionGroupLogicExpression<E>) addCondition(new SqlConditionExpressionBuilder(dialect,
                tuple.get1(), tuple.get2(), QueryOperator.GE, aliasManager.getAlias(tuple.get0()), ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R, D extends Date> EntityQueryConditionGroupLogicExpression<E> ge(SerializableFunction<E, R> repository,
            SerializableFunction<R, D> property, D value) {
        //        IMPLSOON 后续来实现join
        //        entityQuery.join(repository);
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
        //        IMPLSOON 后续来实现join
        //        entityQuery.join(repository);
        Tuple3<String, String, Object> tuple = conditionResult(repository, property, factory);
        return (EntityQueryConditionGroupLogicExpression<E>) addCondition(new SqlConditionExpressionBuilder(dialect,
                tuple.get1(), tuple.get2(), QueryOperator.GE, aliasManager.getAlias(tuple.get0()), ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> EntityQueryConditionGroupLogicExpression<E> ge(SerializableFunction<E, R> repository,
            SerializableFunction<R, LocalTime> property, LocalTime value) {
        //        IMPLSOON 后续来实现join
        //        entityQuery.join(repository);
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
        //        IMPLSOON 后续来实现join
        //        entityQuery.join(repository);
        Tuple3<String, String, Object> tuple = conditionResult(repository, property, factory);
        return (EntityQueryConditionGroupLogicExpression<E>) addCondition(new SqlConditionExpressionBuilder(dialect,
                tuple.get1(), tuple.get2(), QueryOperator.GE, aliasManager.getAlias(tuple.get0()), ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> EntityQueryConditionGroupLogicExpression<E> ge(SerializableFunction<E, R> repository,
            SerializableFunction<R, LocalDate> property, LocalDate value) {
        //        IMPLSOON 后续来实现join
        //        entityQuery.join(repository);
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
        //        IMPLSOON 后续来实现join
        //        entityQuery.join(repository);
        Tuple3<String, String, Object> tuple = conditionResult(repository, property, factory);
        return (EntityQueryConditionGroupLogicExpression<E>) addCondition(new SqlConditionExpressionBuilder(dialect,
                tuple.get1(), tuple.get2(), QueryOperator.GE, aliasManager.getAlias(tuple.get0()), ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> EntityQueryConditionGroupLogicExpression<E> ge(SerializableFunction<E, R> repository,
            SerializableFunction<R, LocalDateTime> property, LocalDateTime value) {
        //        IMPLSOON 后续来实现join
        //        entityQuery.join(repository);
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
        //        IMPLSOON 后续来实现join
        //        entityQuery.join(repository);
        Tuple3<String, String, Object> tuple = conditionResult(repository, property, factory);
        return (EntityQueryConditionGroupLogicExpression<E>) addCondition(new SqlConditionExpressionBuilder(dialect,
                tuple.get1(), tuple.get2(), QueryOperator.GE, aliasManager.getAlias(tuple.get0()), ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> EntityQueryConditionGroupLogicExpression<E> ge(SerializableFunction<E, R> repository,
            SerializableFunction<R, String> property, String value) {
        //        IMPLSOON 后续来实现join
        //        entityQuery.join(repository);
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
        //        IMPLSOON 后续来实现join
        //        entityQuery.join(repository);
        Tuple3<String, String, Object> tuple = conditionResult(repository, property, factory);
        return (EntityQueryConditionGroupLogicExpression<E>) addCondition(new SqlConditionExpressionBuilder(dialect,
                tuple.get1(), tuple.get2(), QueryOperator.GE, aliasManager.getAlias(tuple.get0()), ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R, N extends Number> EntityQueryConditionGroupLogicExpression<E> gt(SerializableFunction<E, R> repository,
            SerializableFunction<R, N> property, N value) {
        //        IMPLSOON 后续来实现join
        //        entityQuery.join(repository);
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
        //        IMPLSOON 后续来实现join
        //        entityQuery.join(repository);
        Tuple3<String, String, Object> tuple = conditionResult(repository, property, factory);
        return (EntityQueryConditionGroupLogicExpression<E>) addCondition(new SqlConditionExpressionBuilder(dialect,
                tuple.get1(), tuple.get2(), QueryOperator.GT, aliasManager.getAlias(tuple.get0()), ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R, D extends Date> EntityQueryConditionGroupLogicExpression<E> gt(SerializableFunction<E, R> repository,
            SerializableFunction<R, D> property, D value) {
        //        IMPLSOON 后续来实现join
        //        entityQuery.join(repository);
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
        //        IMPLSOON 后续来实现join
        //        entityQuery.join(repository);
        Tuple3<String, String, Object> tuple = conditionResult(repository, property, factory);
        return (EntityQueryConditionGroupLogicExpression<E>) addCondition(new SqlConditionExpressionBuilder(dialect,
                tuple.get1(), tuple.get2(), QueryOperator.GT, aliasManager.getAlias(tuple.get0()), ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> EntityQueryConditionGroupLogicExpression<E> gt(SerializableFunction<E, R> repository,
            SerializableFunction<R, LocalTime> property, LocalTime value) {
        //        IMPLSOON 后续来实现join
        //        entityQuery.join(repository);
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
        //        IMPLSOON 后续来实现join
        //        entityQuery.join(repository);
        Tuple3<String, String, Object> tuple = conditionResult(repository, property, factory);
        return (EntityQueryConditionGroupLogicExpression<E>) addCondition(new SqlConditionExpressionBuilder(dialect,
                tuple.get1(), tuple.get2(), QueryOperator.GT, aliasManager.getAlias(tuple.get0()), ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> EntityQueryConditionGroupLogicExpression<E> gt(SerializableFunction<E, R> repository,
            SerializableFunction<R, LocalDate> property, LocalDate value) {
        //        IMPLSOON 后续来实现join
        //        entityQuery.join(repository);
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
        //        IMPLSOON 后续来实现join
        //        entityQuery.join(repository);
        Tuple3<String, String, Object> tuple = conditionResult(repository, property, factory);
        return (EntityQueryConditionGroupLogicExpression<E>) addCondition(new SqlConditionExpressionBuilder(dialect,
                tuple.get1(), tuple.get2(), QueryOperator.GT, aliasManager.getAlias(tuple.get0()), ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> EntityQueryConditionGroupLogicExpression<E> gt(SerializableFunction<E, R> repository,
            SerializableFunction<R, LocalDateTime> property, LocalDateTime value) {
        //        IMPLSOON 后续来实现join
        //        entityQuery.join(repository);
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
        //        IMPLSOON 后续来实现join
        //        entityQuery.join(repository);
        Tuple3<String, String, Object> tuple = conditionResult(repository, property, factory);
        return (EntityQueryConditionGroupLogicExpression<E>) addCondition(new SqlConditionExpressionBuilder(dialect,
                tuple.get1(), tuple.get2(), QueryOperator.GT, aliasManager.getAlias(tuple.get0()), ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> EntityQueryConditionGroupLogicExpression<E> gt(SerializableFunction<E, R> repository,
            SerializableFunction<R, String> property, String value) {
        //        IMPLSOON 后续来实现join
        //        entityQuery.join(repository);
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
        //        IMPLSOON 后续来实现join
        //        entityQuery.join(repository);
        Tuple3<String, String, Object> tuple = conditionResult(repository, property, factory);
        return (EntityQueryConditionGroupLogicExpression<E>) addCondition(new SqlConditionExpressionBuilder(dialect,
                tuple.get1(), tuple.get2(), QueryOperator.GT, aliasManager.getAlias(tuple.get0()), ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R, V> EntityQueryConditionGroupLogicExpression<E> in(SerializableFunction<E, R> repository,
            SerializableFunction<R, V> property, V value) {
        //        IMPLSOON 后续来实现join
        //        entityQuery.join(repository);
        Tuple2<String, String> tuple = conditionResult(repository, property, value, factory);
        return (EntityQueryConditionGroupLogicExpression<E>) addCondition(new SqlConditionExpressionBuilder(dialect,
                tuple.get1(), value, QueryOperator.IN, aliasManager.getAlias(tuple.get0()), ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R, V> EntityQueryConditionGroupLogicExpression<E> in(SerializableSupplier<R> repository,
            SerializableFunction<R, V> property) {
        //        IMPLSOON 后续来实现join
        //        entityQuery.join(repository);
        Tuple3<String, String, Object> tuple = conditionResult(repository, property, factory);
        return (EntityQueryConditionGroupLogicExpression<E>) addCondition(new SqlConditionExpressionBuilder(dialect,
                tuple.get1(), tuple.get2(), QueryOperator.IN, aliasManager.getAlias(tuple.get0()), ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R, V> EntityQueryConditionGroupLogicExpression<E> inn(SerializableFunction<E, R> repository,
            SerializableFunction<R, V> property, Boolean value) {
        //        IMPLSOON 后续来实现join
        //        entityQuery.join(repository);
        Tuple2<String, String> tuple = conditionResult(repository, property, value, factory);
        return (EntityQueryConditionGroupLogicExpression<E>) addCondition(new SqlConditionExpressionBuilder(dialect,
                tuple.get1(), value, QueryOperator.INN, aliasManager.getAlias(tuple.get0()), ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R, V> EntityQueryConditionGroupLogicExpression<E> isn(SerializableFunction<E, R> repository,
            SerializableFunction<R, V> property) {
        return isn(repository, property, true);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R, V> EntityQueryConditionGroupLogicExpression<E> isn(SerializableFunction<E, R> repository,
            SerializableFunction<R, V> property, Boolean value) {
        //        IMPLSOON 后续来实现join
        //        entityQuery.join(repository);
        Tuple2<String, String> tuple = conditionResult(repository, property, value, factory);
        return (EntityQueryConditionGroupLogicExpression<E>) addCondition(new SqlConditionExpressionBuilder(dialect,
                tuple.get1(), value, QueryOperator.ISN, aliasManager.getAlias(tuple.get0()), ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R, N extends Number> EntityQueryConditionGroupLogicExpression<E> le(SerializableFunction<E, R> repository,
            SerializableFunction<R, N> property, N value) {
        //        IMPLSOON 后续来实现join
        //        entityQuery.join(repository);
        Tuple2<String, String> tuple = conditionResult(repository, property, value, factory);
        return (EntityQueryConditionGroupLogicExpression<E>) addCondition(new SqlConditionExpressionBuilder(dialect,
                tuple.get1(), value, QueryOperator.LE, aliasManager.getAlias(tuple.get0()), ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R, N extends Number> EntityQueryConditionGroupLogicExpression<E> le(SerializableSupplier<R> repository,
            ReturnNumberFunction<R, N> property) {
        //        IMPLSOON 后续来实现join
        //        entityQuery.join(repository);
        Tuple3<String, String, Object> tuple = conditionResult(repository, property, factory);
        return (EntityQueryConditionGroupLogicExpression<E>) addCondition(new SqlConditionExpressionBuilder(dialect,
                tuple.get1(), tuple.get2(), QueryOperator.LE, aliasManager.getAlias(tuple.get0()), ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R, D extends Date> EntityQueryConditionGroupLogicExpression<E> le(SerializableFunction<E, R> repository,
            SerializableFunction<R, D> property, D value) {
        //        IMPLSOON 后续来实现join
        //        entityQuery.join(repository);
        Tuple2<String, String> tuple = conditionResult(repository, property, value, factory);
        return (EntityQueryConditionGroupLogicExpression<E>) addCondition(new SqlConditionExpressionBuilder(dialect,
                tuple.get1(), value, QueryOperator.LE, aliasManager.getAlias(tuple.get0()), ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R, D extends Date> EntityQueryConditionGroupLogicExpression<E> le(SerializableSupplier<R> repository,
            ReturnDateFunction<R, D> property) {
        //        IMPLSOON 后续来实现join
        //        entityQuery.join(repository);
        Tuple3<String, String, Object> tuple = conditionResult(repository, property, factory);
        return (EntityQueryConditionGroupLogicExpression<E>) addCondition(new SqlConditionExpressionBuilder(dialect,
                tuple.get1(), tuple.get2(), QueryOperator.LE, aliasManager.getAlias(tuple.get0()), ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> EntityQueryConditionGroupLogicExpression<E> le(SerializableFunction<E, R> repository,
            SerializableFunction<R, LocalTime> property, LocalTime value) {
        //        IMPLSOON 后续来实现join
        //        entityQuery.join(repository);
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
        //        IMPLSOON 后续来实现join
        //        entityQuery.join(repository);
        Tuple3<String, String, Object> tuple = conditionResult(repository, property, factory);
        return (EntityQueryConditionGroupLogicExpression<E>) addCondition(new SqlConditionExpressionBuilder(dialect,
                tuple.get1(), tuple.get2(), QueryOperator.LE, aliasManager.getAlias(tuple.get0()), ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> EntityQueryConditionGroupLogicExpression<E> le(SerializableFunction<E, R> repository,
            SerializableFunction<R, LocalDate> property, LocalDate value) {
        //        IMPLSOON 后续来实现join
        //        entityQuery.join(repository);
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
        //        IMPLSOON 后续来实现join
        //        entityQuery.join(repository);
        Tuple3<String, String, Object> tuple = conditionResult(repository, property, factory);
        return (EntityQueryConditionGroupLogicExpression<E>) addCondition(new SqlConditionExpressionBuilder(dialect,
                tuple.get1(), tuple.get2(), QueryOperator.LE, aliasManager.getAlias(tuple.get0()), ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> EntityQueryConditionGroupLogicExpression<E> le(SerializableFunction<E, R> repository,
            SerializableFunction<R, LocalDateTime> property, LocalDateTime value) {
        //        IMPLSOON 后续来实现join
        //        entityQuery.join(repository);
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
        //        IMPLSOON 后续来实现join
        //        entityQuery.join(repository);
        Tuple3<String, String, Object> tuple = conditionResult(repository, property, factory);
        return (EntityQueryConditionGroupLogicExpression<E>) addCondition(new SqlConditionExpressionBuilder(dialect,
                tuple.get1(), tuple.get2(), QueryOperator.LE, aliasManager.getAlias(tuple.get0()), ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> EntityQueryConditionGroupLogicExpression<E> le(SerializableFunction<E, R> repository,
            SerializableFunction<R, String> property, String value) {
        //        IMPLSOON 后续来实现join
        //        entityQuery.join(repository);
        Tuple2<String, String> tuple = conditionResult(repository, property, value, factory);
        return (EntityQueryConditionGroupLogicExpression<E>) addCondition(new SqlConditionExpressionBuilder(dialect,
                tuple.get1(), value, QueryOperator.LE, aliasManager.getAlias(tuple.get0()), ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> EntityQueryConditionGroupLogicExpression<E> le(SerializableSupplier<R> repository,
            ReturnStringFunction<R> property) {
        //        IMPLSOON 后续来实现join
        //        entityQuery.join(repository);
        Tuple3<String, String, Object> tuple = conditionResult(repository, property, factory);
        return (EntityQueryConditionGroupLogicExpression<E>) addCondition(new SqlConditionExpressionBuilder(dialect,
                tuple.get1(), tuple.get2(), QueryOperator.LE, aliasManager.getAlias(tuple.get0()), ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R, N extends Number> EntityQueryConditionGroupLogicExpression<E> lt(SerializableFunction<E, R> repository,
            SerializableFunction<R, N> property, N value) {
        //        IMPLSOON 后续来实现join
        //        entityQuery.join(repository);
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
        //        IMPLSOON 后续来实现join
        //        entityQuery.join(repository);
        Tuple3<String, String, Object> tuple = conditionResult(repository, property, factory);
        return (EntityQueryConditionGroupLogicExpression<E>) addCondition(new SqlConditionExpressionBuilder(dialect,
                tuple.get1(), tuple.get2(), QueryOperator.LT, aliasManager.getAlias(tuple.get0()), ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R, D extends Date> EntityQueryConditionGroupLogicExpression<E> lt(SerializableFunction<E, R> repository,
            SerializableFunction<R, D> property, D value) {
        //        IMPLSOON 后续来实现join
        //        entityQuery.join(repository);
        Tuple2<String, String> tuple = conditionResult(repository, property, value, factory);
        return (EntityQueryConditionGroupLogicExpression<E>) addCondition(new SqlConditionExpressionBuilder(dialect,
                tuple.get1(), value, QueryOperator.LT, aliasManager.getAlias(tuple.get0()), ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, D extends Date> EntityQueryConditionGroupLogicExpression<E> lt(SerializableSupplier<T> repository,
            SerializableFunction<T, D> property) {
        //        IMPLSOON 后续来实现join
        //        entityQuery.join(repository);
        Tuple3<String, String, Object> tuple = conditionResult(repository, property, factory);
        return (EntityQueryConditionGroupLogicExpression<E>) addCondition(new SqlConditionExpressionBuilder(dialect,
                tuple.get1(), tuple.get2(), QueryOperator.LT, aliasManager.getAlias(tuple.get0()), ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> EntityQueryConditionGroupLogicExpression<E> lt(SerializableFunction<E, R> repository,
            SerializableFunction<R, LocalTime> property, LocalTime value) {
        //        IMPLSOON 后续来实现join
        //        entityQuery.join(repository);
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
        //        IMPLSOON 后续来实现join
        //        entityQuery.join(repository);
        Tuple3<String, String, Object> tuple = conditionResult(repository, property, factory);
        return (EntityQueryConditionGroupLogicExpression<E>) addCondition(new SqlConditionExpressionBuilder(dialect,
                tuple.get1(), tuple.get2(), QueryOperator.LT, aliasManager.getAlias(tuple.get0()), ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> EntityQueryConditionGroupLogicExpression<E> lt(SerializableFunction<E, R> repository,
            SerializableFunction<R, LocalDate> property, LocalDate value) {
        //        IMPLSOON 后续来实现join
        //        entityQuery.join(repository);
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
        //        IMPLSOON 后续来实现join
        //        entityQuery.join(repository);
        Tuple3<String, String, Object> tuple = conditionResult(repository, property, factory);
        return (EntityQueryConditionGroupLogicExpression<E>) addCondition(new SqlConditionExpressionBuilder(dialect,
                tuple.get1(), tuple.get2(), QueryOperator.LT, aliasManager.getAlias(tuple.get0()), ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> EntityQueryConditionGroupLogicExpression<E> lt(SerializableFunction<E, R> repository,
            SerializableFunction<R, LocalDateTime> property, LocalDateTime value) {
        //        IMPLSOON 后续来实现join
        //        entityQuery.join(repository);
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
        //        IMPLSOON 后续来实现join
        //        entityQuery.join(repository);
        Tuple3<String, String, Object> tuple = conditionResult(repository, property, factory);
        return (EntityQueryConditionGroupLogicExpression<E>) addCondition(new SqlConditionExpressionBuilder(dialect,
                tuple.get1(), tuple.get2(), QueryOperator.LT, aliasManager.getAlias(tuple.get0()), ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> EntityQueryConditionGroupLogicExpression<E> lt(SerializableFunction<E, R> repository,
            SerializableFunction<R, String> property, String value) {
        //        IMPLSOON 后续来实现join
        //        entityQuery.join(repository);
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
        //        IMPLSOON 后续来实现join
        //        entityQuery.join(repository);
        Tuple3<String, String, Object> tuple = conditionResult(repository, property, factory);
        return (EntityQueryConditionGroupLogicExpression<E>) addCondition(new SqlConditionExpressionBuilder(dialect,
                tuple.get1(), tuple.get2(), QueryOperator.LT, aliasManager.getAlias(tuple.get0()), ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R, V> EntityQueryConditionGroupLogicExpression<E> ne(SerializableFunction<E, R> repository,
            SerializableFunction<R, V> property, V value) {
        //        IMPLSOON 后续来实现join
        //        entityQuery.join(repository);
        Tuple2<String, String> tuple = conditionResult(repository, property, value, factory);
        return (EntityQueryConditionGroupLogicExpression<E>) addCondition(new SqlConditionExpressionBuilder(dialect,
                tuple.get1(), value, QueryOperator.EQ, aliasManager.getAlias(tuple.get0()), ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R, V> EntityQueryConditionGroupLogicExpression<E> ne(SerializableSupplier<R> repository,
            SerializableFunction<R, V> property) {
        //        IMPLSOON 后续来实现join
        //        entityQuery.join(repository);
        Tuple3<String, String, Object> tuple = conditionResult(repository, property, factory);
        return (EntityQueryConditionGroupLogicExpression<E>) addCondition(new SqlConditionExpressionBuilder(dialect,
                tuple.get1(), tuple.get2(), QueryOperator.NE, aliasManager.getAlias(tuple.get0()), ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R, V> EntityQueryConditionGroupLogicExpression<E> nin(SerializableFunction<E, R> repository,
            SerializableFunction<R, V> property, V value) {
        //        IMPLSOON 后续来实现join
        //        entityQuery.join(repository);
        Tuple2<String, String> tuple = conditionResult(repository, property, value, factory);
        return (EntityQueryConditionGroupLogicExpression<E>) addCondition(new SqlConditionExpressionBuilder(dialect,
                tuple.get1(), value, QueryOperator.NIN, aliasManager.getAlias(tuple.get0()), ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R, V> EntityQueryConditionGroupLogicExpression<E> nin(SerializableSupplier<R> repository,
            SerializableFunction<R, V> property) {
        //        IMPLSOON 后续来实现join
        //        entityQuery.join(repository);
        Tuple3<String, String, Object> tuple = conditionResult(repository, property, factory);
        return (EntityQueryConditionGroupLogicExpression<E>) addCondition(new SqlConditionExpressionBuilder(dialect,
                tuple.get1(), tuple.get2(), QueryOperator.NE, aliasManager.getAlias(tuple.get0()), ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> EntityQueryConditionGroupLogicExpression<E> sw(SerializableFunction<E, R> repository,
            SerializableFunction<R, String> property, String value) {
        //        IMPLSOON 后续来实现join
        //        entityQuery.join(repository);
        Tuple2<String, String> tuple = conditionResult(repository, property, value, factory);
        return (EntityQueryConditionGroupLogicExpression<E>) addCondition(new SqlConditionExpressionBuilder(dialect,
                tuple.get1(), value, QueryOperator.SW, aliasManager.getAlias(tuple.get0()), ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> EntityQueryConditionGroupLogicExpression<E> sw(SerializableSupplier<R> repository,
            SerializableFunction<R, String> property) {
        //        IMPLSOON 后续来实现join
        //        entityQuery.join(repository);
        Tuple3<String, String, Object> tuple = conditionResult(repository, property, factory);
        return (EntityQueryConditionGroupLogicExpression<E>) addCondition(new SqlConditionExpressionBuilder(dialect,
                tuple.get1(), tuple.get2(), QueryOperator.SW, aliasManager.getAlias(tuple.get0()), ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> EntityQueryConditionGroupLogicExpression<E> lk(SerializableFunction<E, R> repository,
            SerializableFunction<R, String> property, String value) {
        //        IMPLSOON 后续来实现join
        //        entityQuery.join(repository);
        Tuple2<String, String> tuple = conditionResult(repository, property, value, factory);
        return (EntityQueryConditionGroupLogicExpression<E>) addCondition(new SqlConditionExpressionBuilder(dialect,
                tuple.get1(), value, QueryOperator.LK, aliasManager.getAlias(tuple.get0()), ignorePolicy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> EntityQueryConditionGroupLogicExpression<E> lk(SerializableSupplier<R> repository,
            SerializableFunction<R, String> property) {
        //        IMPLSOON 后续来实现join
        //        entityQuery.join(repository);
        Tuple3<String, String, Object> tuple = conditionResult(repository, property, factory);
        return (EntityQueryConditionGroupLogicExpression<E>) addCondition(new SqlConditionExpressionBuilder(dialect,
                tuple.get1(), tuple.get2(), QueryOperator.LK, aliasManager.getAlias(tuple.get0()), ignorePolicy));
    }
}
