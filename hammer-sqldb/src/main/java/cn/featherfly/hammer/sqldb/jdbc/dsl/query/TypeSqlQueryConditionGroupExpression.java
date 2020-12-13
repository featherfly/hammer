
package cn.featherfly.hammer.sqldb.jdbc.dsl.query;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

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
import cn.featherfly.hammer.dsl.query.TypeQueryConditionGroupExpression;
import cn.featherfly.hammer.dsl.query.TypeQueryConditionGroupLogicExpression;
import cn.featherfly.hammer.dsl.query.TypeQueryEntity;
import cn.featherfly.hammer.dsl.query.TypeQuerySortExpression;
import cn.featherfly.hammer.expression.query.TypeQueryLimitExecutor;
import cn.featherfly.hammer.sqldb.jdbc.Jdbc;
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
public class TypeSqlQueryConditionGroupExpression extends
        AbstractSqlConditionGroupExpression<TypeQueryConditionGroupExpression, TypeQueryConditionGroupLogicExpression>
        implements TypeQueryConditionGroupExpression, TypeQueryConditionGroupLogicExpression, TypeQuerySortExpression {

    private SqlSortBuilder sortBuilder = new SqlSortBuilder(dialect);

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
     * @param aliasManager    the alias manager
     * @param typeQueryEntity the type query entity
     */
    public TypeSqlQueryConditionGroupExpression(Jdbc jdbc, ClassMapping<?> classMapping, MappingFactory factory,
            AliasManager aliasManager, TypeQueryEntity typeQueryEntity) {
        this(jdbc, null, classMapping, factory, aliasManager, typeQueryEntity);
    }

    /**
     * Instantiates a new type sql query condition group expression.
     *
     * @param jdbc            jdbc
     * @param queryAlias      queryAlias
     * @param classMapping    classMapping
     * @param factory         the factory
     * @param aliasManager    the alias manager
     * @param typeQueryEntity the type query entity
     */
    public TypeSqlQueryConditionGroupExpression(Jdbc jdbc, String queryAlias, ClassMapping<?> classMapping,
            MappingFactory factory, AliasManager aliasManager, TypeQueryEntity typeQueryEntity) {
        this(jdbc, null, queryAlias, classMapping, factory, aliasManager, typeQueryEntity);
    }

    /**
     * Instantiates a new type sql query condition group expression.
     *
     * @param jdbc            the jdbc
     * @param parent          parent group
     * @param queryAlias      queryAlias
     * @param classMapping    classMapping
     * @param factory         the factory
     * @param aliasManager    the alias manager
     * @param typeQueryEntity the type query entity
     */
    TypeSqlQueryConditionGroupExpression(Jdbc jdbc, TypeQueryConditionGroupLogicExpression parent, String queryAlias,
            ClassMapping<?> classMapping, MappingFactory factory, AliasManager aliasManager,
            TypeQueryEntity typeQueryEntity) {
        super(jdbc.getDialect(), parent, queryAlias, classMapping, typeQueryEntity);
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
    protected TypeSqlQueryConditionGroupExpression createGroup(TypeQueryConditionGroupLogicExpression parent,
            String queryAlias, TypeQueryEntity typeQueryEntity) {
        return new TypeSqlQueryConditionGroupExpression(jdbc, parent, queryAlias, classMapping, factory, aliasManager,
                typeQueryEntity);
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
        return (List<E>) jdbc.query(sql, classMapping.getType(), params);
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
                    classMapping.getType(),
                    dialect.getPaginationSqlParameter(params, limit.getOffset(), limit.getLimit()));
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
        return (E) jdbc.querySingle(sql, classMapping.getType(), params);
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
    public TypeQuerySortExpression sort() {
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TypeQuerySortExpression asc(String... names) {
        ((TypeSqlQueryConditionGroupExpression) getRoot()).sortBuilder
                .asc(ClassMappingUtils.getColumnNames(classMapping, names));
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TypeQuerySortExpression asc(List<String> names) {
        ((TypeSqlQueryConditionGroupExpression) getRoot()).sortBuilder
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
        ((TypeSqlQueryConditionGroupExpression) getRoot()).sortBuilder
                .desc(ClassMappingUtils.getColumnNames(classMapping, names));
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TypeQuerySortExpression desc(List<String> names) {
        ((TypeSqlQueryConditionGroupExpression) getRoot()).sortBuilder
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

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> TypeQueryConditionGroupLogicExpression co(SerializableFunction<T, R> repository,
            ReturnStringFunction<R> property, Object value) {
        typeQueryEntity.with(repository);
        Tuple2<String, String> tuple = conditionResult(repository, property, value, factory);
        return (TypeQueryConditionGroupLogicExpression) addCondition(new SqlConditionExpressionBuilder(dialect,
                tuple.get1(), value, QueryOperator.CO, aliasManager.getAlias(tuple.get0())));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> TypeQueryConditionGroupLogicExpression co(SerializableSupplier<T> repository,
            ReturnStringFunction<T> property) {
        typeQueryEntity.with(repository);
        Tuple3<String, String, Object> tuple = conditionResult(repository, property, factory);
        return (TypeQueryConditionGroupLogicExpression) addCondition(new SqlConditionExpressionBuilder(dialect,
                tuple.get1(), tuple.get2(), QueryOperator.CO, aliasManager.getAlias(tuple.get0())));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> TypeQueryConditionGroupLogicExpression ew(SerializableFunction<T, R> repository,
            ReturnStringFunction<R> property, Object value) {
        typeQueryEntity.with(repository);
        Tuple2<String, String> tuple = conditionResult(repository, property, value, factory);
        return (TypeQueryConditionGroupLogicExpression) addCondition(new SqlConditionExpressionBuilder(dialect,
                tuple.get1(), value, QueryOperator.EW, aliasManager.getAlias(tuple.get0())));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> TypeQueryConditionGroupLogicExpression ew(SerializableSupplier<T> repository,
            ReturnStringFunction<T> property) {
        typeQueryEntity.with(repository);
        Tuple3<String, String, Object> tuple = conditionResult(repository, property, factory);
        return (TypeQueryConditionGroupLogicExpression) addCondition(new SqlConditionExpressionBuilder(dialect,
                tuple.get1(), tuple.get2(), QueryOperator.EW, aliasManager.getAlias(tuple.get0())));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <O, T, R> TypeQueryConditionGroupLogicExpression eq(SerializableFunction<O, T> repository,
            SerializableFunction<T, R> property, Object value) {
        typeQueryEntity.with(repository);
        Tuple2<String, String> tuple = conditionResult(repository, property, value, factory);
        return (TypeQueryConditionGroupLogicExpression) addCondition(new SqlConditionExpressionBuilder(dialect,
                tuple.get1(), value, QueryOperator.EQ, aliasManager.getAlias(tuple.get0())));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> TypeQueryConditionGroupLogicExpression eq(SerializableSupplier<T> repository,
            SerializableFunction<T, R> property) {
        typeQueryEntity.with(repository);
        Tuple3<String, String, Object> tuple = conditionResult(repository, property, factory);
        return (TypeQueryConditionGroupLogicExpression) addCondition(new SqlConditionExpressionBuilder(dialect,
                tuple.get1(), tuple.get2(), QueryOperator.EQ, aliasManager.getAlias(tuple.get0())));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R, N extends Number> TypeQueryConditionGroupLogicExpression ge(SerializableFunction<T, R> repository,
            ReturnNumberFunction<R, N> property, N value) {
        typeQueryEntity.with(repository);
        Tuple2<String, String> tuple = conditionResult(repository, property, value, factory);
        return (TypeQueryConditionGroupLogicExpression) addCondition(new SqlConditionExpressionBuilder(dialect,
                tuple.get1(), value, QueryOperator.GE, aliasManager.getAlias(tuple.get0())));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, N extends Number> TypeQueryConditionGroupLogicExpression ge(SerializableSupplier<T> repository,
            ReturnNumberFunction<T, N> property) {
        typeQueryEntity.with(repository);
        Tuple3<String, String, Object> tuple = conditionResult(repository, property, factory);
        return (TypeQueryConditionGroupLogicExpression) addCondition(new SqlConditionExpressionBuilder(dialect,
                tuple.get1(), tuple.get2(), QueryOperator.GE, aliasManager.getAlias(tuple.get0())));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R, D extends Date> TypeQueryConditionGroupLogicExpression ge(SerializableFunction<T, R> repository,
            ReturnDateFunction<R, D> property, D value) {
        typeQueryEntity.with(repository);
        Tuple2<String, String> tuple = conditionResult(repository, property, value, factory);
        return (TypeQueryConditionGroupLogicExpression) addCondition(new SqlConditionExpressionBuilder(dialect,
                tuple.get1(), value, QueryOperator.GE, aliasManager.getAlias(tuple.get0())));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, D extends Date> TypeQueryConditionGroupLogicExpression ge(SerializableSupplier<T> repository,
            ReturnDateFunction<T, D> property) {
        typeQueryEntity.with(repository);
        Tuple3<String, String, Object> tuple = conditionResult(repository, property, factory);
        return (TypeQueryConditionGroupLogicExpression) addCondition(new SqlConditionExpressionBuilder(dialect,
                tuple.get1(), tuple.get2(), QueryOperator.GE, aliasManager.getAlias(tuple.get0())));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> TypeQueryConditionGroupLogicExpression ge(SerializableFunction<T, R> repository,
            ReturnLocalTimeFunction<R> property, LocalTime value) {
        typeQueryEntity.with(repository);
        Tuple2<String, String> tuple = conditionResult(repository, property, value, factory);
        return (TypeQueryConditionGroupLogicExpression) addCondition(new SqlConditionExpressionBuilder(dialect,
                tuple.get1(), value, QueryOperator.GE, aliasManager.getAlias(tuple.get0())));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> TypeQueryConditionGroupLogicExpression ge(SerializableSupplier<T> repository,
            ReturnLocalTimeFunction<T> property) {
        typeQueryEntity.with(repository);
        Tuple3<String, String, Object> tuple = conditionResult(repository, property, factory);
        return (TypeQueryConditionGroupLogicExpression) addCondition(new SqlConditionExpressionBuilder(dialect,
                tuple.get1(), tuple.get2(), QueryOperator.GE, aliasManager.getAlias(tuple.get0())));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> TypeQueryConditionGroupLogicExpression ge(SerializableFunction<T, R> repository,
            ReturnLocalDateFunction<R> property, LocalDate value) {
        typeQueryEntity.with(repository);
        Tuple2<String, String> tuple = conditionResult(repository, property, value, factory);
        return (TypeQueryConditionGroupLogicExpression) addCondition(new SqlConditionExpressionBuilder(dialect,
                tuple.get1(), value, QueryOperator.GE, aliasManager.getAlias(tuple.get0())));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> TypeQueryConditionGroupLogicExpression ge(SerializableSupplier<T> repository,
            ReturnLocalDateFunction<T> property) {
        typeQueryEntity.with(repository);
        Tuple3<String, String, Object> tuple = conditionResult(repository, property, factory);
        return (TypeQueryConditionGroupLogicExpression) addCondition(new SqlConditionExpressionBuilder(dialect,
                tuple.get1(), tuple.get2(), QueryOperator.GE, aliasManager.getAlias(tuple.get0())));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> TypeQueryConditionGroupLogicExpression ge(SerializableFunction<T, R> repository,
            ReturnLocalDateTimeFunction<R> property, LocalDateTime value) {
        typeQueryEntity.with(repository);
        Tuple2<String, String> tuple = conditionResult(repository, property, value, factory);
        return (TypeQueryConditionGroupLogicExpression) addCondition(new SqlConditionExpressionBuilder(dialect,
                tuple.get1(), value, QueryOperator.GE, aliasManager.getAlias(tuple.get0())));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> TypeQueryConditionGroupLogicExpression ge(SerializableSupplier<T> repository,
            ReturnLocalDateTimeFunction<T> property) {
        typeQueryEntity.with(repository);
        Tuple3<String, String, Object> tuple = conditionResult(repository, property, factory);
        return (TypeQueryConditionGroupLogicExpression) addCondition(new SqlConditionExpressionBuilder(dialect,
                tuple.get1(), tuple.get2(), QueryOperator.GE, aliasManager.getAlias(tuple.get0())));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> TypeQueryConditionGroupLogicExpression ge(SerializableFunction<T, R> repository,
            ReturnStringFunction<R> property, String value) {
        typeQueryEntity.with(repository);
        Tuple2<String, String> tuple = conditionResult(repository, property, value, factory);
        return (TypeQueryConditionGroupLogicExpression) addCondition(new SqlConditionExpressionBuilder(dialect,
                tuple.get1(), value, QueryOperator.GE, aliasManager.getAlias(tuple.get0())));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> TypeQueryConditionGroupLogicExpression ge(SerializableSupplier<T> repository,
            ReturnStringFunction<T> property) {
        typeQueryEntity.with(repository);
        Tuple3<String, String, Object> tuple = conditionResult(repository, property, factory);
        return (TypeQueryConditionGroupLogicExpression) addCondition(new SqlConditionExpressionBuilder(dialect,
                tuple.get1(), tuple.get2(), QueryOperator.GE, aliasManager.getAlias(tuple.get0())));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R, N extends Number> TypeQueryConditionGroupLogicExpression gt(SerializableFunction<T, R> repository,
            ReturnNumberFunction<R, N> property, N value) {
        typeQueryEntity.with(repository);
        Tuple2<String, String> tuple = conditionResult(repository, property, value, factory);
        return (TypeQueryConditionGroupLogicExpression) addCondition(new SqlConditionExpressionBuilder(dialect,
                tuple.get1(), value, QueryOperator.GT, aliasManager.getAlias(tuple.get0())));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, N extends Number> TypeQueryConditionGroupLogicExpression gt(SerializableSupplier<T> repository,
            ReturnNumberFunction<T, N> property) {
        typeQueryEntity.with(repository);
        Tuple3<String, String, Object> tuple = conditionResult(repository, property, factory);
        return (TypeQueryConditionGroupLogicExpression) addCondition(new SqlConditionExpressionBuilder(dialect,
                tuple.get1(), tuple.get2(), QueryOperator.GT, aliasManager.getAlias(tuple.get0())));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R, D extends Date> TypeQueryConditionGroupLogicExpression gt(SerializableFunction<T, R> repository,
            ReturnDateFunction<R, D> property, D value) {
        typeQueryEntity.with(repository);
        Tuple2<String, String> tuple = conditionResult(repository, property, value, factory);
        return (TypeQueryConditionGroupLogicExpression) addCondition(new SqlConditionExpressionBuilder(dialect,
                tuple.get1(), value, QueryOperator.GT, aliasManager.getAlias(tuple.get0())));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, D extends Date> TypeQueryConditionGroupLogicExpression gt(SerializableSupplier<T> repository,
            ReturnDateFunction<T, D> property) {
        typeQueryEntity.with(repository);
        Tuple3<String, String, Object> tuple = conditionResult(repository, property, factory);
        return (TypeQueryConditionGroupLogicExpression) addCondition(new SqlConditionExpressionBuilder(dialect,
                tuple.get1(), tuple.get2(), QueryOperator.GT, aliasManager.getAlias(tuple.get0())));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> TypeQueryConditionGroupLogicExpression gt(SerializableFunction<T, R> repository,
            ReturnLocalTimeFunction<R> property, LocalTime value) {
        typeQueryEntity.with(repository);
        Tuple2<String, String> tuple = conditionResult(repository, property, value, factory);
        return (TypeQueryConditionGroupLogicExpression) addCondition(new SqlConditionExpressionBuilder(dialect,
                tuple.get1(), value, QueryOperator.GT, aliasManager.getAlias(tuple.get0())));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> TypeQueryConditionGroupLogicExpression gt(SerializableSupplier<T> repository,
            ReturnLocalTimeFunction<T> property) {
        typeQueryEntity.with(repository);
        Tuple3<String, String, Object> tuple = conditionResult(repository, property, factory);
        return (TypeQueryConditionGroupLogicExpression) addCondition(new SqlConditionExpressionBuilder(dialect,
                tuple.get1(), tuple.get2(), QueryOperator.GT, aliasManager.getAlias(tuple.get0())));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> TypeQueryConditionGroupLogicExpression gt(SerializableFunction<T, R> repository,
            ReturnLocalDateFunction<R> property, LocalDate value) {
        typeQueryEntity.with(repository);
        Tuple2<String, String> tuple = conditionResult(repository, property, value, factory);
        return (TypeQueryConditionGroupLogicExpression) addCondition(new SqlConditionExpressionBuilder(dialect,
                tuple.get1(), value, QueryOperator.GT, aliasManager.getAlias(tuple.get0())));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> TypeQueryConditionGroupLogicExpression gt(SerializableSupplier<T> repository,
            ReturnLocalDateFunction<T> property) {
        typeQueryEntity.with(repository);
        Tuple3<String, String, Object> tuple = conditionResult(repository, property, factory);
        return (TypeQueryConditionGroupLogicExpression) addCondition(new SqlConditionExpressionBuilder(dialect,
                tuple.get1(), tuple.get2(), QueryOperator.GT, aliasManager.getAlias(tuple.get0())));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> TypeQueryConditionGroupLogicExpression gt(SerializableFunction<T, R> repository,
            ReturnLocalDateTimeFunction<R> property, LocalDateTime value) {
        typeQueryEntity.with(repository);
        Tuple2<String, String> tuple = conditionResult(repository, property, value, factory);
        return (TypeQueryConditionGroupLogicExpression) addCondition(new SqlConditionExpressionBuilder(dialect,
                tuple.get1(), value, QueryOperator.GT, aliasManager.getAlias(tuple.get0())));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> TypeQueryConditionGroupLogicExpression gt(SerializableSupplier<T> repository,
            ReturnLocalDateTimeFunction<T> property) {
        typeQueryEntity.with(repository);
        Tuple3<String, String, Object> tuple = conditionResult(repository, property, factory);
        return (TypeQueryConditionGroupLogicExpression) addCondition(new SqlConditionExpressionBuilder(dialect,
                tuple.get1(), tuple.get2(), QueryOperator.GT, aliasManager.getAlias(tuple.get0())));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> TypeQueryConditionGroupLogicExpression gt(SerializableFunction<T, R> repository,
            ReturnStringFunction<R> property, String value) {
        typeQueryEntity.with(repository);
        Tuple2<String, String> tuple = conditionResult(repository, property, value, factory);
        return (TypeQueryConditionGroupLogicExpression) addCondition(new SqlConditionExpressionBuilder(dialect,
                tuple.get1(), value, QueryOperator.GT, aliasManager.getAlias(tuple.get0())));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> TypeQueryConditionGroupLogicExpression gt(SerializableSupplier<T> repository,
            ReturnStringFunction<T> property) {
        typeQueryEntity.with(repository);
        Tuple3<String, String, Object> tuple = conditionResult(repository, property, factory);
        return (TypeQueryConditionGroupLogicExpression) addCondition(new SqlConditionExpressionBuilder(dialect,
                tuple.get1(), tuple.get2(), QueryOperator.GT, aliasManager.getAlias(tuple.get0())));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <O, T, R> TypeQueryConditionGroupLogicExpression in(SerializableFunction<O, T> repository,
            SerializableFunction<T, R> property, Object value) {
        typeQueryEntity.with(repository);
        Tuple2<String, String> tuple = conditionResult(repository, property, value, factory);
        return (TypeQueryConditionGroupLogicExpression) addCondition(new SqlConditionExpressionBuilder(dialect,
                tuple.get1(), value, QueryOperator.IN, aliasManager.getAlias(tuple.get0())));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> TypeQueryConditionGroupLogicExpression in(SerializableSupplier<T> repository,
            SerializableFunction<T, R> property) {
        typeQueryEntity.with(repository);
        Tuple3<String, String, Object> tuple = conditionResult(repository, property, factory);
        return (TypeQueryConditionGroupLogicExpression) addCondition(new SqlConditionExpressionBuilder(dialect,
                tuple.get1(), tuple.get2(), QueryOperator.IN, aliasManager.getAlias(tuple.get0())));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <O, T, R> TypeQueryConditionGroupLogicExpression inn(SerializableFunction<O, T> repository,
            SerializableFunction<T, R> property) {
        typeQueryEntity.with(repository);
        Tuple2<String, String> tuple = conditionResult(repository, property, null, factory);
        return (TypeQueryConditionGroupLogicExpression) addCondition(new SqlConditionExpressionBuilder(dialect,
                tuple.get1(), null, QueryOperator.INN, aliasManager.getAlias(tuple.get0())));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <O, T, R> TypeQueryConditionGroupLogicExpression isn(SerializableFunction<O, T> repository,
            SerializableFunction<T, R> property) {
        typeQueryEntity.with(repository);
        Tuple2<String, String> tuple = conditionResult(repository, property, null, factory);
        return (TypeQueryConditionGroupLogicExpression) addCondition(new SqlConditionExpressionBuilder(dialect,
                tuple.get1(), null, QueryOperator.ISN, aliasManager.getAlias(tuple.get0())));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R, N extends Number> TypeQueryConditionGroupLogicExpression le(SerializableFunction<T, R> repository,
            ReturnNumberFunction<R, N> property, N value) {
        typeQueryEntity.with(repository);
        Tuple2<String, String> tuple = conditionResult(repository, property, value, factory);
        return (TypeQueryConditionGroupLogicExpression) addCondition(new SqlConditionExpressionBuilder(dialect,
                tuple.get1(), value, QueryOperator.LE, aliasManager.getAlias(tuple.get0())));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, N extends Number> TypeQueryConditionGroupLogicExpression le(SerializableSupplier<T> repository,
            ReturnNumberFunction<T, N> property) {
        typeQueryEntity.with(repository);
        Tuple3<String, String, Object> tuple = conditionResult(repository, property, factory);
        return (TypeQueryConditionGroupLogicExpression) addCondition(new SqlConditionExpressionBuilder(dialect,
                tuple.get1(), tuple.get2(), QueryOperator.LE, aliasManager.getAlias(tuple.get0())));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R, D extends Date> TypeQueryConditionGroupLogicExpression le(SerializableFunction<T, R> repository,
            ReturnDateFunction<R, D> property, D value) {
        typeQueryEntity.with(repository);
        Tuple2<String, String> tuple = conditionResult(repository, property, value, factory);
        return (TypeQueryConditionGroupLogicExpression) addCondition(new SqlConditionExpressionBuilder(dialect,
                tuple.get1(), value, QueryOperator.LE, aliasManager.getAlias(tuple.get0())));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, D extends Date> TypeQueryConditionGroupLogicExpression le(SerializableSupplier<T> repository,
            ReturnDateFunction<T, D> property) {
        typeQueryEntity.with(repository);
        Tuple3<String, String, Object> tuple = conditionResult(repository, property, factory);
        return (TypeQueryConditionGroupLogicExpression) addCondition(new SqlConditionExpressionBuilder(dialect,
                tuple.get1(), tuple.get2(), QueryOperator.LE, aliasManager.getAlias(tuple.get0())));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> TypeQueryConditionGroupLogicExpression le(SerializableFunction<T, R> repository,
            ReturnLocalTimeFunction<R> property, LocalTime value) {
        typeQueryEntity.with(repository);
        Tuple2<String, String> tuple = conditionResult(repository, property, value, factory);
        return (TypeQueryConditionGroupLogicExpression) addCondition(new SqlConditionExpressionBuilder(dialect,
                tuple.get1(), value, QueryOperator.LE, aliasManager.getAlias(tuple.get0())));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> TypeQueryConditionGroupLogicExpression le(SerializableSupplier<T> repository,
            ReturnLocalTimeFunction<T> property) {
        typeQueryEntity.with(repository);
        Tuple3<String, String, Object> tuple = conditionResult(repository, property, factory);
        return (TypeQueryConditionGroupLogicExpression) addCondition(new SqlConditionExpressionBuilder(dialect,
                tuple.get1(), tuple.get2(), QueryOperator.LE, aliasManager.getAlias(tuple.get0())));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> TypeQueryConditionGroupLogicExpression le(SerializableFunction<T, R> repository,
            ReturnLocalDateFunction<R> property, LocalDate value) {
        typeQueryEntity.with(repository);
        Tuple2<String, String> tuple = conditionResult(repository, property, value, factory);
        return (TypeQueryConditionGroupLogicExpression) addCondition(new SqlConditionExpressionBuilder(dialect,
                tuple.get1(), value, QueryOperator.LE, aliasManager.getAlias(tuple.get0())));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> TypeQueryConditionGroupLogicExpression le(SerializableSupplier<T> repository,
            ReturnLocalDateFunction<T> property) {
        typeQueryEntity.with(repository);
        Tuple3<String, String, Object> tuple = conditionResult(repository, property, factory);
        return (TypeQueryConditionGroupLogicExpression) addCondition(new SqlConditionExpressionBuilder(dialect,
                tuple.get1(), tuple.get2(), QueryOperator.LE, aliasManager.getAlias(tuple.get0())));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> TypeQueryConditionGroupLogicExpression le(SerializableFunction<T, R> repository,
            ReturnLocalDateTimeFunction<R> property, LocalDateTime value) {
        typeQueryEntity.with(repository);
        Tuple2<String, String> tuple = conditionResult(repository, property, value, factory);
        return (TypeQueryConditionGroupLogicExpression) addCondition(new SqlConditionExpressionBuilder(dialect,
                tuple.get1(), value, QueryOperator.LE, aliasManager.getAlias(tuple.get0())));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> TypeQueryConditionGroupLogicExpression le(SerializableSupplier<T> repository,
            ReturnLocalDateTimeFunction<T> property) {
        typeQueryEntity.with(repository);
        Tuple3<String, String, Object> tuple = conditionResult(repository, property, factory);
        return (TypeQueryConditionGroupLogicExpression) addCondition(new SqlConditionExpressionBuilder(dialect,
                tuple.get1(), tuple.get2(), QueryOperator.LE, aliasManager.getAlias(tuple.get0())));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> TypeQueryConditionGroupLogicExpression le(SerializableFunction<T, R> repository,
            ReturnStringFunction<R> property, String value) {
        typeQueryEntity.with(repository);
        Tuple2<String, String> tuple = conditionResult(repository, property, value, factory);
        return (TypeQueryConditionGroupLogicExpression) addCondition(new SqlConditionExpressionBuilder(dialect,
                tuple.get1(), value, QueryOperator.LE, aliasManager.getAlias(tuple.get0())));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> TypeQueryConditionGroupLogicExpression le(SerializableSupplier<T> repository,
            ReturnStringFunction<T> property) {
        typeQueryEntity.with(repository);
        Tuple3<String, String, Object> tuple = conditionResult(repository, property, factory);
        return (TypeQueryConditionGroupLogicExpression) addCondition(new SqlConditionExpressionBuilder(dialect,
                tuple.get1(), tuple.get2(), QueryOperator.LE, aliasManager.getAlias(tuple.get0())));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R, N extends Number> TypeQueryConditionGroupLogicExpression lt(SerializableFunction<T, R> repository,
            ReturnNumberFunction<R, N> property, N value) {
        typeQueryEntity.with(repository);
        Tuple2<String, String> tuple = conditionResult(repository, property, value, factory);
        return (TypeQueryConditionGroupLogicExpression) addCondition(new SqlConditionExpressionBuilder(dialect,
                tuple.get1(), value, QueryOperator.LT, aliasManager.getAlias(tuple.get0())));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, N extends Number> TypeQueryConditionGroupLogicExpression lt(SerializableSupplier<T> repository,
            ReturnNumberFunction<T, N> property) {
        typeQueryEntity.with(repository);
        Tuple3<String, String, Object> tuple = conditionResult(repository, property, factory);
        return (TypeQueryConditionGroupLogicExpression) addCondition(new SqlConditionExpressionBuilder(dialect,
                tuple.get1(), tuple.get2(), QueryOperator.LT, aliasManager.getAlias(tuple.get0())));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R, D extends Date> TypeQueryConditionGroupLogicExpression lt(SerializableFunction<T, R> repository,
            ReturnDateFunction<R, D> property, D value) {
        typeQueryEntity.with(repository);
        Tuple2<String, String> tuple = conditionResult(repository, property, value, factory);
        return (TypeQueryConditionGroupLogicExpression) addCondition(new SqlConditionExpressionBuilder(dialect,
                tuple.get1(), value, QueryOperator.LT, aliasManager.getAlias(tuple.get0())));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, D extends Date> TypeQueryConditionGroupLogicExpression lt(SerializableSupplier<T> repository,
            ReturnDateFunction<T, D> property) {
        typeQueryEntity.with(repository);
        Tuple3<String, String, Object> tuple = conditionResult(repository, property, factory);
        return (TypeQueryConditionGroupLogicExpression) addCondition(new SqlConditionExpressionBuilder(dialect,
                tuple.get1(), tuple.get2(), QueryOperator.LT, aliasManager.getAlias(tuple.get0())));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> TypeQueryConditionGroupLogicExpression lt(SerializableFunction<T, R> repository,
            ReturnLocalTimeFunction<R> property, LocalTime value) {
        typeQueryEntity.with(repository);
        Tuple2<String, String> tuple = conditionResult(repository, property, value, factory);
        return (TypeQueryConditionGroupLogicExpression) addCondition(new SqlConditionExpressionBuilder(dialect,
                tuple.get1(), value, QueryOperator.LT, aliasManager.getAlias(tuple.get0())));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> TypeQueryConditionGroupLogicExpression lt(SerializableSupplier<T> repository,
            ReturnLocalTimeFunction<T> property) {
        typeQueryEntity.with(repository);
        Tuple3<String, String, Object> tuple = conditionResult(repository, property, factory);
        return (TypeQueryConditionGroupLogicExpression) addCondition(new SqlConditionExpressionBuilder(dialect,
                tuple.get1(), tuple.get2(), QueryOperator.LT, aliasManager.getAlias(tuple.get0())));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> TypeQueryConditionGroupLogicExpression lt(SerializableFunction<T, R> repository,
            ReturnLocalDateFunction<R> property, LocalDate value) {
        typeQueryEntity.with(repository);
        Tuple2<String, String> tuple = conditionResult(repository, property, value, factory);
        return (TypeQueryConditionGroupLogicExpression) addCondition(new SqlConditionExpressionBuilder(dialect,
                tuple.get1(), value, QueryOperator.LT, aliasManager.getAlias(tuple.get0())));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> TypeQueryConditionGroupLogicExpression lt(SerializableSupplier<T> repository,
            ReturnLocalDateFunction<T> property) {
        typeQueryEntity.with(repository);
        Tuple3<String, String, Object> tuple = conditionResult(repository, property, factory);
        return (TypeQueryConditionGroupLogicExpression) addCondition(new SqlConditionExpressionBuilder(dialect,
                tuple.get1(), tuple.get2(), QueryOperator.LT, aliasManager.getAlias(tuple.get0())));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> TypeQueryConditionGroupLogicExpression lt(SerializableFunction<T, R> repository,
            ReturnLocalDateTimeFunction<R> property, LocalDateTime value) {
        typeQueryEntity.with(repository);
        Tuple2<String, String> tuple = conditionResult(repository, property, value, factory);
        return (TypeQueryConditionGroupLogicExpression) addCondition(new SqlConditionExpressionBuilder(dialect,
                tuple.get1(), value, QueryOperator.LT, aliasManager.getAlias(tuple.get0())));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> TypeQueryConditionGroupLogicExpression lt(SerializableSupplier<T> repository,
            ReturnLocalDateTimeFunction<T> property) {
        typeQueryEntity.with(repository);
        Tuple3<String, String, Object> tuple = conditionResult(repository, property, factory);
        return (TypeQueryConditionGroupLogicExpression) addCondition(new SqlConditionExpressionBuilder(dialect,
                tuple.get1(), tuple.get2(), QueryOperator.LT, aliasManager.getAlias(tuple.get0())));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> TypeQueryConditionGroupLogicExpression lt(SerializableFunction<T, R> repository,
            ReturnStringFunction<R> property, String value) {
        typeQueryEntity.with(repository);
        Tuple2<String, String> tuple = conditionResult(repository, property, value, factory);
        return (TypeQueryConditionGroupLogicExpression) addCondition(new SqlConditionExpressionBuilder(dialect,
                tuple.get1(), value, QueryOperator.LT, aliasManager.getAlias(tuple.get0())));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> TypeQueryConditionGroupLogicExpression lt(SerializableSupplier<T> repository,
            ReturnStringFunction<T> property) {
        typeQueryEntity.with(repository);
        Tuple3<String, String, Object> tuple = conditionResult(repository, property, factory);
        return (TypeQueryConditionGroupLogicExpression) addCondition(new SqlConditionExpressionBuilder(dialect,
                tuple.get1(), tuple.get2(), QueryOperator.LT, aliasManager.getAlias(tuple.get0())));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <O, T, R> TypeQueryConditionGroupLogicExpression ne(SerializableFunction<O, T> repository,
            SerializableFunction<T, R> property, Object value) {
        typeQueryEntity.with(repository);
        Tuple2<String, String> tuple = conditionResult(repository, property, value, factory);
        return (TypeQueryConditionGroupLogicExpression) addCondition(new SqlConditionExpressionBuilder(dialect,
                tuple.get1(), value, QueryOperator.EQ, aliasManager.getAlias(tuple.get0())));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> TypeQueryConditionGroupLogicExpression ne(SerializableSupplier<T> repository,
            SerializableFunction<T, R> property) {
        typeQueryEntity.with(repository);
        Tuple3<String, String, Object> tuple = conditionResult(repository, property, factory);
        return (TypeQueryConditionGroupLogicExpression) addCondition(new SqlConditionExpressionBuilder(dialect,
                tuple.get1(), tuple.get2(), QueryOperator.NE, aliasManager.getAlias(tuple.get0())));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <O, T, R> TypeQueryConditionGroupLogicExpression nin(SerializableFunction<O, T> repository,
            SerializableFunction<T, R> property, Object value) {
        typeQueryEntity.with(repository);
        Tuple2<String, String> tuple = conditionResult(repository, property, value, factory);
        return (TypeQueryConditionGroupLogicExpression) addCondition(new SqlConditionExpressionBuilder(dialect,
                tuple.get1(), value, QueryOperator.NIN, aliasManager.getAlias(tuple.get0())));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> TypeQueryConditionGroupLogicExpression nin(SerializableSupplier<T> repository,
            SerializableFunction<T, R> property) {
        typeQueryEntity.with(repository);
        Tuple3<String, String, Object> tuple = conditionResult(repository, property, factory);
        return (TypeQueryConditionGroupLogicExpression) addCondition(new SqlConditionExpressionBuilder(dialect,
                tuple.get1(), tuple.get2(), QueryOperator.NE, aliasManager.getAlias(tuple.get0())));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> TypeQueryConditionGroupLogicExpression sw(SerializableFunction<T, R> repository,
            ReturnStringFunction<R> property, Object value) {
        typeQueryEntity.with(repository);
        Tuple2<String, String> tuple = conditionResult(repository, property, value, factory);
        return (TypeQueryConditionGroupLogicExpression) addCondition(new SqlConditionExpressionBuilder(dialect,
                tuple.get1(), value, QueryOperator.SW, aliasManager.getAlias(tuple.get0())));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> TypeQueryConditionGroupLogicExpression sw(SerializableSupplier<T> repository,
            ReturnStringFunction<T> property) {
        typeQueryEntity.with(repository);
        Tuple3<String, String, Object> tuple = conditionResult(repository, property, factory);
        return (TypeQueryConditionGroupLogicExpression) addCondition(new SqlConditionExpressionBuilder(dialect,
                tuple.get1(), tuple.get2(), QueryOperator.SW, aliasManager.getAlias(tuple.get0())));
    }
}
