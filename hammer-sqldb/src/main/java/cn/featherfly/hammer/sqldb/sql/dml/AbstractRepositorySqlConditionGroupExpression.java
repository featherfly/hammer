
package cn.featherfly.hammer.sqldb.sql.dml;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import com.speedment.common.tuple.Tuple2;
import com.speedment.common.tuple.Tuple3;

import cn.featherfly.common.db.builder.SqlBuilder;
import cn.featherfly.common.db.dialect.Dialect;
import cn.featherfly.common.db.mapping.ClassMappingUtils;
import cn.featherfly.common.lang.LambdaUtils;
import cn.featherfly.common.lang.LambdaUtils.SerializableSupplierLambdaInfo;
import cn.featherfly.common.lang.function.DateSupplier;
import cn.featherfly.common.lang.function.LocalDateSupplier;
import cn.featherfly.common.lang.function.LocalDateTimeSupplier;
import cn.featherfly.common.lang.function.LocalTimeSupplier;
import cn.featherfly.common.lang.function.NumberSupplier;
import cn.featherfly.common.lang.function.ReturnDateFunction;
import cn.featherfly.common.lang.function.ReturnEnumFunction;
import cn.featherfly.common.lang.function.ReturnLocalDateFunction;
import cn.featherfly.common.lang.function.ReturnLocalDateTimeFunction;
import cn.featherfly.common.lang.function.ReturnLocalTimeFunction;
import cn.featherfly.common.lang.function.ReturnNumberFunction;
import cn.featherfly.common.lang.function.ReturnStringFunction;
import cn.featherfly.common.lang.function.SerializableFunction;
import cn.featherfly.common.lang.function.SerializableSupplier;
import cn.featherfly.common.lang.function.StringSupplier;
import cn.featherfly.common.repository.builder.AliasManager;
import cn.featherfly.common.repository.mapping.ClassMapping;
import cn.featherfly.common.repository.mapping.MappingFactory;
import cn.featherfly.common.repository.operate.LogicOperator;
import cn.featherfly.common.repository.operate.QueryOperator;
import cn.featherfly.hammer.expression.RepositoryConditionGroupLogicExpression;
import cn.featherfly.hammer.expression.condition.ParamedExpression;
import cn.featherfly.hammer.expression.condition.RepositoryConditionsGroupExpression;
import cn.featherfly.hammer.expression.condition.property.DateExpression;
import cn.featherfly.hammer.expression.condition.property.EnumExpression;
import cn.featherfly.hammer.expression.condition.property.NumberExpression;
import cn.featherfly.hammer.expression.condition.property.ObjectExpression;
import cn.featherfly.hammer.expression.condition.property.RepositorySimpleDateExpression;
import cn.featherfly.hammer.expression.condition.property.RepositorySimpleEnumExpression;
import cn.featherfly.hammer.expression.condition.property.RepositorySimpleNumberExpression;
import cn.featherfly.hammer.expression.condition.property.RepositorySimpleObjectExpression;
import cn.featherfly.hammer.expression.condition.property.RepositorySimpleStringExpression;
import cn.featherfly.hammer.expression.condition.property.SimpleDateExpression;
import cn.featherfly.hammer.expression.condition.property.SimpleEnumExpression;
import cn.featherfly.hammer.expression.condition.property.SimpleNumberExpression;
import cn.featherfly.hammer.expression.condition.property.SimpleObjectExpression;
import cn.featherfly.hammer.expression.condition.property.SimpleStringExpression;
import cn.featherfly.hammer.expression.condition.property.StringExpression;

/**
 * <p>
 * sql condition group builder sql条件逻辑组构造器
 * </p>
 * .
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
@SuppressWarnings("unchecked")
public abstract class AbstractRepositorySqlConditionGroupExpression<C extends RepositoryConditionsGroupExpression<C, L>,
        L extends RepositoryConditionGroupLogicExpression<C, L>> extends AbstractSqlConditionExpression<L>
        implements RepositoryConditionsGroupExpression<C, L>, RepositoryConditionGroupLogicExpression<C, L>, SqlBuilder,
        ParamedExpression {

    /** The class mapping. */
    protected ClassMapping<?> classMapping;

    private String queryAlias;

    /** The alias manager. */
    protected AliasManager aliasManager;

    /** The factory. */
    protected MappingFactory factory;

    /**
     * Instantiates a new abstract repository sql condition group expression.
     *
     * @param dialect      dialect
     * @param factory      MappingFactory
     * @param aliasManager aliasManager
     */
    public AbstractRepositorySqlConditionGroupExpression(Dialect dialect, MappingFactory factory,
            AliasManager aliasManager) {
        this(dialect, factory, aliasManager, null, null);
    }

    /**
     * Instantiates a new abstract repository sql condition group expression.
     *
     * @param dialect      dialect
     * @param factory      MappingFactory
     * @param aliasManager aliasManager
     * @param queryAlias   queryAlias
     */
    public AbstractRepositorySqlConditionGroupExpression(Dialect dialect, MappingFactory factory,
            AliasManager aliasManager, String queryAlias) {
        this(dialect, factory, aliasManager, null, queryAlias, null);
    }

    /**
     * Instantiates a new abstract repository sql condition group expression.
     *
     * @param dialect      dialect
     * @param factory      MappingFactory
     * @param aliasManager aliasManager
     * @param queryAlias   queryAlias
     * @param classMapping classMapping
     */
    public AbstractRepositorySqlConditionGroupExpression(Dialect dialect, MappingFactory factory,
            AliasManager aliasManager, String queryAlias, ClassMapping<?> classMapping) {
        this(dialect, factory, aliasManager, null, queryAlias, classMapping);
    }

    /**
     * Instantiates a new abstract repository sql condition group expression.
     *
     * @param dialect      dialect
     * @param factory      MappingFactory
     * @param aliasManager aliasManager
     * @param parent       parent group
     * @param queryAlias   queryAlias
     * @param classMapping classMapping
     */
    protected AbstractRepositorySqlConditionGroupExpression(Dialect dialect, MappingFactory factory,
            AliasManager aliasManager, L parent, String queryAlias, ClassMapping<?> classMapping) {
        super(dialect, parent);
        this.queryAlias = queryAlias;
        this.classMapping = classMapping;
        this.aliasManager = aliasManager;
        this.factory = factory;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public C and() {
        return (C) addCondition(new SqlLogicOperatorExpressionBuilder(LogicOperator.AND));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public C or() {
        return (C) addCondition(new SqlLogicOperatorExpressionBuilder(LogicOperator.OR));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public C group() {
        // SqlConditionGroupExpressionBuilder group = new
        // SqlConditionGroupExpressionBuilder(
        // jdbc, this, queryAlias);
        C group = createGroup((L) this, queryAlias);
        addCondition(group);
        return group;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L group(Function<C, L> group) {
        group.apply(group());
        return endGroup();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L endGroup() {
        if (parent != null) {
            return parent;
        } else {
            return (L) this;
        }
    }

    /**
     * Creates the group.
     *
     * @param parent     the parent
     * @param queryAlias the query alias
     * @return the c
     */
    protected abstract C createGroup(L parent, String queryAlias);

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> L co(Class<T> repository, String name, String value) {
        return co(getTableName(repository), name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L co(int repositoryIndex, String name, String value) {
        return (L) addCondition(
                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
                        QueryOperator.CO, aliasManager.getAlias(repositoryIndex)));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> L co(ReturnStringFunction<T> name, String value) {
        return co(getPropertyName(name), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L co(String name, String value) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect,
                ClassMappingUtils.getColumnName(name, classMapping), value, QueryOperator.CO, queryAlias));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L co(String repository, String name, String value) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect,
                ClassMappingUtils.getColumnName(name, classMapping), value, QueryOperator.CO, queryAlias));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> L eq(Class<T> repository, String name, Object value) {
        return eq(getTableName(repository), name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(int repositoryIndex, String name, Object value) {
        return (L) addCondition(
                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
                        QueryOperator.EQ, aliasManager.getAlias(repositoryIndex)));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> L eq(SerializableFunction<T, R> name, Object value) {
        return eq(getPropertyName(name), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(String name, Object value) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect,
                ClassMappingUtils.getColumnName(name, classMapping), value, QueryOperator.EQ, queryAlias));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(String repository, String name, Object value) {
        return (L) addCondition(
                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
                        QueryOperator.EQ, aliasManager.getAlias(repository)));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> L eq(SerializableFunction<T, R> repository, SerializableFunction<T, R> property, Object value) {
        return eq(getPropertyName(repository), getPropertyName(property), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> L eq(SerializableSupplier<T> repository, SerializableFunction<T, R> property) {
        Tuple3<String, String, Object> tuple = conditionResult(repository, property);
        return eq(tuple.get0(), tuple.get1(), tuple.get2());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> L ew(Class<T> repository, String name, String value) {
        return ew(getTableName(repository), name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ew(int repositoryIndex, String name, String value) {
        return (L) addCondition(
                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
                        QueryOperator.EW, aliasManager.getAlias(repositoryIndex)));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> L ew(ReturnStringFunction<T> name, String value) {
        return ew(getPropertyName(name), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ew(String name, String value) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect,
                ClassMappingUtils.getColumnName(name, classMapping), value, QueryOperator.EW, queryAlias));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ew(String repository, String name, String value) {
        return (L) addCondition(
                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
                        QueryOperator.EW, aliasManager.getAlias(repository)));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date, T> L ge(Class<T> repository, String name, D value) {
        return ge(getTableName(repository), name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> L ge(Class<T> repository, String name, LocalDate value) {
        return ge(getTableName(repository), name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> L ge(Class<T> repository, String name, LocalDateTime value) {
        return ge(getTableName(repository), name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> L ge(Class<T> repository, String name, LocalTime value) {
        return ge(getTableName(repository), name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number, T> L ge(Class<T> repository, String name, N value) {
        return ge(getTableName(repository), name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> L ge(Class<T> repository, String name, String value) {
        return ge(getTableName(repository), name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L ge(int repositoryIndex, String name, D value) {
        return (L) addCondition(
                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
                        QueryOperator.GE, aliasManager.getAlias(repositoryIndex)));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(int repositoryIndex, String name, LocalDate value) {
        return (L) addCondition(
                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
                        QueryOperator.GE, aliasManager.getAlias(repositoryIndex)));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(int repositoryIndex, String name, LocalDateTime value) {
        return (L) addCondition(
                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
                        QueryOperator.GE, aliasManager.getAlias(repositoryIndex)));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(int repositoryIndex, String name, LocalTime value) {
        return (L) addCondition(
                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
                        QueryOperator.GE, aliasManager.getAlias(repositoryIndex)));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L ge(int repositoryIndex, String name, N value) {
        return (L) addCondition(
                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
                        QueryOperator.GE, aliasManager.getAlias(repositoryIndex)));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(int repositoryIndex, String name, String value) {
        return (L) addCondition(
                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
                        QueryOperator.GE, aliasManager.getAlias(repositoryIndex)));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, D extends Date> L ge(ReturnDateFunction<T, D> name, D value) {
        return ge(getPropertyName(name), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> L ge(ReturnLocalDateFunction<T> name, LocalDate value) {
        return ge(getPropertyName(name), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> L ge(ReturnLocalDateTimeFunction<T> name, LocalDateTime value) {
        return ge(getPropertyName(name), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> L ge(ReturnLocalTimeFunction<T> name, LocalTime value) {
        return ge(getPropertyName(name), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, N extends Number> L ge(ReturnNumberFunction<T, N> name, N value) {
        return ge(getPropertyName(name), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> L ge(ReturnStringFunction<T> name, String value) {
        return ge(getPropertyName(name), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L ge(String name, D value) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect,
                ClassMappingUtils.getColumnName(name, classMapping), value, QueryOperator.GE, queryAlias));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(String name, LocalDate value) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect,
                ClassMappingUtils.getColumnName(name, classMapping), value, QueryOperator.GE, queryAlias));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(String name, LocalDateTime value) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect,
                ClassMappingUtils.getColumnName(name, classMapping), value, QueryOperator.GE, queryAlias));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(String name, LocalTime value) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect,
                ClassMappingUtils.getColumnName(name, classMapping), value, QueryOperator.GE, queryAlias));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L ge(String name, N value) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect,
                ClassMappingUtils.getColumnName(name, classMapping), value, QueryOperator.GE, queryAlias));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(String name, String value) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect,
                ClassMappingUtils.getColumnName(name, classMapping), value, QueryOperator.GE, queryAlias));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L ge(String repository, String name, D value) {
        return (L) addCondition(
                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
                        QueryOperator.GE, aliasManager.getAlias(repository)));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(String repository, String name, LocalDate value) {
        return (L) addCondition(
                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
                        QueryOperator.GE, aliasManager.getAlias(repository)));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(String repository, String name, LocalDateTime value) {
        return (L) addCondition(
                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
                        QueryOperator.GE, aliasManager.getAlias(repository)));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(String repository, String name, LocalTime value) {
        return (L) addCondition(
                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
                        QueryOperator.GE, aliasManager.getAlias(repository)));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L ge(String repository, String name, N value) {
        return (L) addCondition(
                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
                        QueryOperator.GE, aliasManager.getAlias(repository)));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(String repository, String name, String value) {
        return (L) addCondition(
                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
                        QueryOperator.GE, aliasManager.getAlias(repository)));
    }

    /**
     * 返回queryAlias.
     *
     * @return queryAlias
     */
    public String getQueryAlias() {
        return queryAlias;
    }

    /**
     * Gets the root.
     *
     * @return the root
     */
    protected AbstractRepositorySqlConditionGroupExpression<C, L> getRoot() {
        L p = endGroup();
        L p2 = p.endGroup();
        while (p != p2) {
            p = p.endGroup();
        }
        return (AbstractRepositorySqlConditionGroupExpression<C, L>) p;
    }

    private <T> String getTableName(Class<T> repository) {
        return factory.getClassMapping(repository).getRepositoryName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date, T> L gt(Class<T> repository, String name, D value) {
        return gt(getTableName(repository), name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> L gt(Class<T> repository, String name, LocalDate value) {
        return gt(getTableName(repository), name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> L gt(Class<T> repository, String name, LocalDateTime value) {
        return gt(getTableName(repository), name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> L gt(Class<T> repository, String name, LocalTime value) {
        return gt(getTableName(repository), name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number, T> L gt(Class<T> repository, String name, N value) {
        return gt(getTableName(repository), name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> L gt(Class<T> repository, String name, String value) {
        return gt(getTableName(repository), name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L gt(int repositoryIndex, String name, D value) {
        return (L) addCondition(
                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
                        QueryOperator.GT, aliasManager.getAlias(repositoryIndex)));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(int repositoryIndex, String name, LocalDate value) {
        return (L) addCondition(
                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
                        QueryOperator.GT, aliasManager.getAlias(repositoryIndex)));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(int repositoryIndex, String name, LocalDateTime value) {
        return (L) addCondition(
                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
                        QueryOperator.GT, aliasManager.getAlias(repositoryIndex)));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(int repositoryIndex, String name, LocalTime value) {
        return (L) addCondition(
                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
                        QueryOperator.GT, aliasManager.getAlias(repositoryIndex)));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L gt(int repositoryIndex, String name, N value) {
        return (L) addCondition(
                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
                        QueryOperator.GT, aliasManager.getAlias(repositoryIndex)));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(int repositoryIndex, String name, String value) {
        return (L) addCondition(
                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
                        QueryOperator.GT, aliasManager.getAlias(repositoryIndex)));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, D extends Date> L gt(ReturnDateFunction<T, D> name, D value) {
        return gt(getPropertyName(name), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> L gt(ReturnLocalDateFunction<T> name, LocalDate value) {
        return gt(getPropertyName(name), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> L gt(ReturnLocalDateTimeFunction<T> name, LocalDateTime value) {
        return gt(getPropertyName(name), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> L gt(ReturnLocalTimeFunction<T> name, LocalTime value) {
        return gt(getPropertyName(name), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, N extends Number> L gt(ReturnNumberFunction<T, N> name, N value) {
        return gt(getPropertyName(name), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> L gt(ReturnStringFunction<T> name, String value) {
        return gt(getPropertyName(name), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L gt(String name, D value) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect,
                ClassMappingUtils.getColumnName(name, classMapping), value, QueryOperator.GT, queryAlias));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(String name, LocalDate value) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect,
                ClassMappingUtils.getColumnName(name, classMapping), value, QueryOperator.GT, queryAlias));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(String name, LocalDateTime value) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect,
                ClassMappingUtils.getColumnName(name, classMapping), value, QueryOperator.GT, queryAlias));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(String name, LocalTime value) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect,
                ClassMappingUtils.getColumnName(name, classMapping), value, QueryOperator.GT, queryAlias));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L gt(String name, N value) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect,
                ClassMappingUtils.getColumnName(name, classMapping), value, QueryOperator.GT, queryAlias));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(String name, String value) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect,
                ClassMappingUtils.getColumnName(name, classMapping), value, QueryOperator.GT, queryAlias));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L gt(String repository, String name, D value) {
        return (L) addCondition(
                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
                        QueryOperator.GT, aliasManager.getAlias(repository)));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(String repository, String name, LocalDate value) {
        return (L) addCondition(
                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
                        QueryOperator.GT, aliasManager.getAlias(repository)));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(String repository, String name, LocalDateTime value) {
        return (L) addCondition(
                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
                        QueryOperator.GT, aliasManager.getAlias(repository)));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(String repository, String name, LocalTime value) {
        return (L) addCondition(
                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
                        QueryOperator.GT, aliasManager.getAlias(repository)));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L gt(String repository, String name, N value) {
        return (L) addCondition(
                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
                        QueryOperator.GT, aliasManager.getAlias(repository)));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(String repository, String name, String value) {
        return (L) addCondition(
                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
                        QueryOperator.GT, aliasManager.getAlias(repository)));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> L in(Class<T> repository, String name, Object value) {
        return in(getTableName(repository), name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(int repositoryIndex, String name, Object value) {
        return (L) addCondition(
                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
                        QueryOperator.IN, aliasManager.getAlias(repositoryIndex)));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> L in(SerializableFunction<T, R> name, Object value) {
        return in(getPropertyName(name), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(String name, Object value) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect,
                ClassMappingUtils.getColumnName(name, classMapping), value, QueryOperator.IN, queryAlias));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(String repository, String name, Object value) {
        return (L) addCondition(
                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
                        QueryOperator.IN, aliasManager.getAlias(repository)));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> L inn(Class<T> repository, String name) {
        return inn(getTableName(repository), name);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L inn(int repositoryIndex, String name) {
        return (L) addCondition(
                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), null,
                        QueryOperator.INN, aliasManager.getAlias(repositoryIndex)));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> L inn(SerializableFunction<T, R> name) {
        return inn(getPropertyName(name));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L inn(String name) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect,
                ClassMappingUtils.getColumnName(name, classMapping), null, QueryOperator.INN, queryAlias));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L inn(String repository, String name) {
        return (L) addCondition(
                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), null,
                        QueryOperator.INN, aliasManager.getAlias(repository)));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> L isn(Class<T> repository, String name) {
        return isn(getTableName(repository), name);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L isn(int repositoryIndex, String name) {
        return (L) addCondition(
                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), null,
                        QueryOperator.ISN, aliasManager.getAlias(repositoryIndex)));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> L isn(SerializableFunction<T, R> name) {
        return isn(getPropertyName(name));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L isn(String name) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect,
                ClassMappingUtils.getColumnName(name, classMapping), null, QueryOperator.ISN, queryAlias));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L isn(String repository, String name) {
        return (L) addCondition(
                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), null,
                        QueryOperator.ISN, aliasManager.getAlias(repository)));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date, T> L le(Class<T> repository, String name, D value) {
        return le(getTableName(repository), name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> L le(Class<T> repository, String name, LocalDate value) {
        return le(getTableName(repository), name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> L le(Class<T> repository, String name, LocalDateTime value) {
        return le(getTableName(repository), name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> L le(Class<T> repository, String name, LocalTime value) {
        return le(getTableName(repository), name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number, T> L le(Class<T> repository, String name, N value) {
        return le(getTableName(repository), name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> L le(Class<T> repository, String name, String value) {
        return le(getTableName(repository), name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L le(int repositoryIndex, String name, D value) {
        return (L) addCondition(
                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
                        QueryOperator.LE, aliasManager.getAlias(repositoryIndex)));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(int repositoryIndex, String name, LocalDate value) {
        return (L) addCondition(
                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
                        QueryOperator.LE, aliasManager.getAlias(repositoryIndex)));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(int repositoryIndex, String name, LocalDateTime value) {
        return (L) addCondition(
                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
                        QueryOperator.LE, aliasManager.getAlias(repositoryIndex)));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(int repositoryIndex, String name, LocalTime value) {
        return (L) addCondition(
                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
                        QueryOperator.LE, aliasManager.getAlias(repositoryIndex)));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L le(int repositoryIndex, String name, N value) {
        return (L) addCondition(
                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
                        QueryOperator.LE, aliasManager.getAlias(repositoryIndex)));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(int repositoryIndex, String name, String value) {
        return (L) addCondition(
                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
                        QueryOperator.LE, aliasManager.getAlias(repositoryIndex)));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, D extends Date> L le(ReturnDateFunction<T, D> name, D value) {
        return le(getPropertyName(name), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> L le(ReturnLocalDateFunction<T> name, LocalDate value) {
        return le(getPropertyName(name), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> L le(ReturnLocalDateTimeFunction<T> name, LocalDateTime value) {
        return le(getPropertyName(name), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> L le(ReturnLocalTimeFunction<T> name, LocalTime value) {
        return le(getPropertyName(name), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, N extends Number> L le(ReturnNumberFunction<T, N> name, N value) {
        return le(getPropertyName(name), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> L le(ReturnStringFunction<T> name, String value) {
        return le(getPropertyName(name), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L le(String name, D value) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect,
                ClassMappingUtils.getColumnName(name, classMapping), value, QueryOperator.LE, queryAlias));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(String name, LocalDate value) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect,
                ClassMappingUtils.getColumnName(name, classMapping), value, QueryOperator.LE, queryAlias));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(String name, LocalDateTime value) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect,
                ClassMappingUtils.getColumnName(name, classMapping), value, QueryOperator.LE, queryAlias));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(String name, LocalTime value) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect,
                ClassMappingUtils.getColumnName(name, classMapping), value, QueryOperator.LE, queryAlias));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L le(String name, N value) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect,
                ClassMappingUtils.getColumnName(name, classMapping), value, QueryOperator.LE, queryAlias));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(String name, String value) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect,
                ClassMappingUtils.getColumnName(name, classMapping), value, QueryOperator.LE, queryAlias));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L le(String repository, String name, D value) {
        return (L) addCondition(
                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
                        QueryOperator.LE, aliasManager.getAlias(repository)));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(String repository, String name, LocalDate value) {
        return (L) addCondition(
                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
                        QueryOperator.LE, aliasManager.getAlias(repository)));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(String repository, String name, LocalDateTime value) {
        return (L) addCondition(
                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
                        QueryOperator.LE, aliasManager.getAlias(repository)));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(String repository, String name, LocalTime value) {
        return (L) addCondition(
                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
                        QueryOperator.LE, aliasManager.getAlias(repository)));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L le(String repository, String name, N value) {
        return (L) addCondition(
                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
                        QueryOperator.LE, aliasManager.getAlias(repository)));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(String repository, String name, String value) {
        return (L) addCondition(
                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
                        QueryOperator.LE, aliasManager.getAlias(repository)));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date, T> L lt(Class<T> repository, String name, D value) {
        return lt(getTableName(repository), name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> L lt(Class<T> repository, String name, LocalDate value) {
        return lt(getTableName(repository), name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> L lt(Class<T> repository, String name, LocalDateTime value) {
        return lt(getTableName(repository), name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> L lt(Class<T> repository, String name, LocalTime value) {
        return lt(getTableName(repository), name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number, T> L lt(Class<T> repository, String name, N value) {
        return lt(getTableName(repository), name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> L lt(Class<T> repository, String name, String value) {
        return lt(getTableName(repository), name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L lt(int repositoryIndex, String name, D value) {
        return (L) addCondition(
                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
                        QueryOperator.LT, aliasManager.getAlias(repositoryIndex)));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(int repositoryIndex, String name, LocalDate value) {
        return (L) addCondition(
                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
                        QueryOperator.LT, aliasManager.getAlias(repositoryIndex)));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(int repositoryIndex, String name, LocalDateTime value) {
        return (L) addCondition(
                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
                        QueryOperator.LT, aliasManager.getAlias(repositoryIndex)));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(int repositoryIndex, String name, LocalTime value) {
        return (L) addCondition(
                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
                        QueryOperator.LT, aliasManager.getAlias(repositoryIndex)));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L lt(int repositoryIndex, String name, N value) {
        return (L) addCondition(
                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
                        QueryOperator.LT, aliasManager.getAlias(repositoryIndex)));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(int repositoryIndex, String name, String value) {
        return (L) addCondition(
                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
                        QueryOperator.LT, aliasManager.getAlias(repositoryIndex)));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, D extends Date> L lt(ReturnDateFunction<T, D> name, D value) {
        return lt(getPropertyName(name), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> L lt(ReturnLocalDateFunction<T> name, LocalDate value) {
        return lt(getPropertyName(name), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> L lt(ReturnLocalDateTimeFunction<T> name, LocalDateTime value) {
        return lt(getPropertyName(name), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> L lt(ReturnLocalTimeFunction<T> name, LocalTime value) {
        return lt(getPropertyName(name), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, N extends Number> L lt(ReturnNumberFunction<T, N> name, N value) {
        return lt(getPropertyName(name), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> L lt(ReturnStringFunction<T> name, String value) {
        return lt(getPropertyName(name), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L lt(String name, D value) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect,
                ClassMappingUtils.getColumnName(name, classMapping), value, QueryOperator.LT, queryAlias));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(String name, LocalDate value) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect,
                ClassMappingUtils.getColumnName(name, classMapping), value, QueryOperator.LT, queryAlias));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(String name, LocalDateTime value) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect,
                ClassMappingUtils.getColumnName(name, classMapping), value, QueryOperator.LT, queryAlias));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(String name, LocalTime value) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect,
                ClassMappingUtils.getColumnName(name, classMapping), value, QueryOperator.LT, queryAlias));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L lt(String name, N value) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect,
                ClassMappingUtils.getColumnName(name, classMapping), value, QueryOperator.LT, queryAlias));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(String name, String value) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect,
                ClassMappingUtils.getColumnName(name, classMapping), value, QueryOperator.LT, queryAlias));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L lt(String repository, String name, D value) {
        return (L) addCondition(
                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
                        QueryOperator.LT, aliasManager.getAlias(repository)));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(String repository, String name, LocalDate value) {
        return (L) addCondition(
                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
                        QueryOperator.LT, aliasManager.getAlias(repository)));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(String repository, String name, LocalDateTime value) {
        return (L) addCondition(
                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
                        QueryOperator.LT, aliasManager.getAlias(repository)));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(String repository, String name, LocalTime value) {
        return (L) addCondition(
                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
                        QueryOperator.LT, aliasManager.getAlias(repository)));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L lt(String repository, String name, N value) {
        return (L) addCondition(
                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
                        QueryOperator.LT, aliasManager.getAlias(repository)));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(String repository, String name, String value) {
        return (L) addCondition(
                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
                        QueryOperator.LT, aliasManager.getAlias(repository)));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> L ne(Class<T> repository, String name, Object value) {
        return ne(getTableName(repository), name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(int repositoryIndex, String name, Object value) {
        return (L) addCondition(
                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
                        QueryOperator.NE, aliasManager.getAlias(repositoryIndex)));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> L ne(SerializableFunction<T, R> name, Object value) {
        return ne(getPropertyName(name), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(String name, Object value) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect,
                ClassMappingUtils.getColumnName(name, classMapping), value, QueryOperator.NE, queryAlias));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(String repository, String name, Object value) {
        return (L) addCondition(
                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
                        QueryOperator.NE, aliasManager.getAlias(repository)));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> L ne(SerializableFunction<T, R> repository, SerializableFunction<T, R> property, Object value) {
        return ne(getPropertyName(repository), getPropertyName(property), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> L ne(SerializableSupplier<T> repository, SerializableFunction<T, R> property) {
        Tuple3<String, String, Object> tuple = conditionResult(repository, property);
        return ne(tuple.get0(), tuple.get1(), tuple.get2());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> L nin(Class<T> repository, String name, Object value) {
        return nin(getTableName(repository), name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nin(int repositoryIndex, String name, Object value) {
        return (L) addCondition(
                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
                        QueryOperator.NIN, aliasManager.getAlias(repositoryIndex)));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> L nin(SerializableFunction<T, R> name, Object value) {
        return nin(getPropertyName(name), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nin(String name, Object value) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect,
                ClassMappingUtils.getColumnName(name, classMapping), value, QueryOperator.NIN, queryAlias));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nin(String repository, String name, Object value) {
        return (L) addCondition(
                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
                        QueryOperator.NIN, aliasManager.getAlias(repository)));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> ObjectExpression<C, L> property(Class<T> repository, String name) {
        return property(getTableName(repository), name);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ObjectExpression<C, L> property(int repositoryIndex, String name) {
        return new RepositorySimpleObjectExpression<>(repositoryIndex,
                ClassMappingUtils.getColumnName(name, classMapping), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> ObjectExpression<C, L> property(SerializableFunction<T, R> name) {
        return property(getPropertyName(name));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ObjectExpression<C, L> property(String name) {
        return new SimpleObjectExpression<>(ClassMappingUtils.getColumnName(name, classMapping), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ObjectExpression<C, L> property(String repository, String name) {
        return new RepositorySimpleObjectExpression<>(repository, ClassMappingUtils.getColumnName(name, classMapping),
                this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> DateExpression<C, L> propertyDate(Class<T> repository, String name) {
        return propertyDate(getTableName(repository), name);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DateExpression<C, L> propertyDate(int repositoryIndex, String name) {
        return new RepositorySimpleDateExpression<>(repositoryIndex,
                ClassMappingUtils.getColumnName(name, classMapping), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R extends Date> DateExpression<C, L> propertyDate(SerializableFunction<T, R> name) {
        return propertyDate(getPropertyName(name));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DateExpression<C, L> propertyDate(String name) {
        return new SimpleDateExpression<>(ClassMappingUtils.getColumnName(name, classMapping), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DateExpression<C, L> propertyDate(String repository, String name) {
        return new RepositorySimpleDateExpression<>(repository, ClassMappingUtils.getColumnName(name, classMapping),
                this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> EnumExpression<C, L> propertyEnum(Class<T> repository, String name) {
        return propertyEnum(getTableName(repository), name);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EnumExpression<C, L> propertyEnum(int repositoryIndex, String name) {
        return new RepositorySimpleEnumExpression<>(repositoryIndex,
                ClassMappingUtils.getColumnName(name, classMapping), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R extends Enum<?>> EnumExpression<C, L> propertyEnum(SerializableFunction<T, R> name) {
        return propertyEnum(getPropertyName(name));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EnumExpression<C, L> propertyEnum(String name) {
        return new SimpleEnumExpression<>(ClassMappingUtils.getColumnName(name, classMapping), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EnumExpression<C, L> propertyEnum(String repository, String name) {
        return new RepositorySimpleEnumExpression<>(repository, ClassMappingUtils.getColumnName(name, classMapping),
                this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> NumberExpression<C, L> propertyNumber(Class<T> repository, String name) {
        return propertyNumber(getTableName(repository), name);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public NumberExpression<C, L> propertyNumber(int repositoryIndex, String name) {
        return new RepositorySimpleNumberExpression<>(repositoryIndex,
                ClassMappingUtils.getColumnName(name, classMapping), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R extends Number> NumberExpression<C, L> propertyNumber(SerializableFunction<T, R> name) {
        return propertyNumber(getPropertyName(name));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public NumberExpression<C, L> propertyNumber(String name) {
        return new SimpleNumberExpression<>(ClassMappingUtils.getColumnName(name, classMapping), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public NumberExpression<C, L> propertyNumber(String repository, String name) {
        return new RepositorySimpleNumberExpression<>(repository, ClassMappingUtils.getColumnName(name, classMapping),
                this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> StringExpression<C, L> propertyString(Class<T> repository, String name) {
        return propertyString(getTableName(repository), name);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public StringExpression<C, L> propertyString(int repositoryIndex, String name) {
        return new RepositorySimpleStringExpression<>(repositoryIndex,
                ClassMappingUtils.getColumnName(name, classMapping), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> StringExpression<C, L> propertyString(SerializableFunction<T, String> name) {
        return propertyString(getPropertyName(name));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public StringExpression<C, L> propertyString(String name) {
        return new SimpleStringExpression<>(ClassMappingUtils.getColumnName(name, classMapping), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public StringExpression<C, L> propertyString(String repository, String name) {
        return new RepositorySimpleStringExpression<>(repository, ClassMappingUtils.getColumnName(name, classMapping),
                this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> StringExpression<C, L> property(ReturnStringFunction<T> name) {
        return propertyString(getPropertyName(name));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R extends Number> NumberExpression<C, L> property(ReturnNumberFunction<T, R> name) {
        return propertyNumber(getPropertyName(name));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R extends Date> DateExpression<C, L> property(ReturnDateFunction<T, R> name) {
        return propertyDate(getPropertyName(name));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R extends Enum<?>> EnumExpression<C, L> property(ReturnEnumFunction<T, R> name) {
        return propertyEnum(getPropertyName(name));
    }

    // ********************************************************************
    // property
    // ********************************************************************

    /**
     * 设置queryAlias.
     *
     * @param queryAlias queryAlias
     */
    public void setQueryAlias(String queryAlias) {
        this.queryAlias = queryAlias;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> L sw(Class<T> repository, String name, String value) {
        return sw(getTableName(repository), name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L sw(int repositoryIndex, String name, String value) {
        return (L) addCondition(
                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
                        QueryOperator.SW, aliasManager.getAlias(repositoryIndex)));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> L sw(ReturnStringFunction<T> name, String value) {
        return sw(getPropertyName(name), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L sw(String name, String value) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect,
                ClassMappingUtils.getColumnName(name, classMapping), value, QueryOperator.SW, queryAlias));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L sw(String repository, String name, String value) {
        return (L) addCondition(
                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
                        QueryOperator.SW, aliasManager.getAlias(repository)));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L co(StringSupplier property) {
        SerializableSupplierLambdaInfo<String> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        return co(info.getSerializedLambdaInfo().getPropertyName(), info.getValue());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ew(StringSupplier property) {
        SerializableSupplierLambdaInfo<String> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        return co(info.getSerializedLambdaInfo().getPropertyName(), info.getValue());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L eq(SerializableSupplier<R> property) {
        //        SerializableSupplierLambdaInfo<R> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        //        return eq(info.getSerializedLambdaInfo().getPropertyName(), info.getValue());
        //        Tuple2<String, R> tuple = supplier(LambdaUtils.getSerializableSupplierLambdaInfo(property));
        //        return eq(tuple.get0(), tuple.get1());
        List<Tuple2<String, Optional<R>>> tuples = supplier(LambdaUtils.getSerializableSupplierLambdaInfo(property));
        L l = null;
        C c = (C) this;
        if (tuples.size() > 1) {
            c = group();
        }
        for (Tuple2<String, Optional<R>> tuple : tuples) {
            if (l != null) {
                c = l.and();
            }
            l = c.ne(tuple.get0(), tuple.get1().orElseGet(() -> null));
        }
        if (tuples.size() > 1) {
            l = l.endGroup();
        }
        return l;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L in(SerializableSupplier<R> property) {
        SerializableSupplierLambdaInfo<R> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        return in(info.getSerializedLambdaInfo().getPropertyName(), info.getValue());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L ne(SerializableSupplier<R> property) {
        //        SerializableSupplierLambdaInfo<R> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        //        return ne(info.getSerializedLambdaInfo().getPropertyName(), info.getValue());
        //        Tuple2<String, R> tuple = supplier(LambdaUtils.getSerializableSupplierLambdaInfo(property));
        //        return eq(tuple.get0(), tuple.get1());
        List<Tuple2<String, Optional<R>>> tuples = supplier(LambdaUtils.getSerializableSupplierLambdaInfo(property));
        L l = null;
        C c = (C) this;
        if (tuples.size() > 1) {
            c = group();
        }
        for (Tuple2<String, Optional<R>> tuple : tuples) {
            if (l != null) {
                c = l.and();
            }
            l = c.ne(tuple.get0(), tuple.get1().orElseGet(() -> null));
        }
        if (tuples.size() > 1) {
            l = l.endGroup();
        }
        return l;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L nin(SerializableSupplier<R> property) {
        SerializableSupplierLambdaInfo<R> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        return nin(info.getSerializedLambdaInfo().getPropertyName(), info.getValue());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L sw(StringSupplier property) {
        SerializableSupplierLambdaInfo<String> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        return sw(info.getSerializedLambdaInfo().getPropertyName(), info.getValue());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Date> L ge(DateSupplier<R> property) {
        SerializableSupplierLambdaInfo<R> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        return ge(info.getSerializedLambdaInfo().getPropertyName(), info.getValue());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Number> L ge(NumberSupplier<R> property) {
        SerializableSupplierLambdaInfo<R> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        return ge(info.getSerializedLambdaInfo().getPropertyName(), info.getValue());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(LocalDateSupplier property) {
        SerializableSupplierLambdaInfo<LocalDate> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        return ge(info.getSerializedLambdaInfo().getPropertyName(), info.getValue());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(LocalTimeSupplier property) {
        SerializableSupplierLambdaInfo<LocalTime> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        return ge(info.getSerializedLambdaInfo().getPropertyName(), info.getValue());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(LocalDateTimeSupplier property) {
        SerializableSupplierLambdaInfo<LocalDateTime> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        return ge(info.getSerializedLambdaInfo().getPropertyName(), info.getValue());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(StringSupplier property) {
        SerializableSupplierLambdaInfo<String> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        return ge(info.getSerializedLambdaInfo().getPropertyName(), info.getValue());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Number> L gt(NumberSupplier<R> property) {
        SerializableSupplierLambdaInfo<R> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        return gt(info.getSerializedLambdaInfo().getPropertyName(), info.getValue());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Date> L gt(DateSupplier<R> property) {
        SerializableSupplierLambdaInfo<R> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        return gt(info.getSerializedLambdaInfo().getPropertyName(), info.getValue());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(LocalDateSupplier property) {
        SerializableSupplierLambdaInfo<LocalDate> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        return gt(info.getSerializedLambdaInfo().getPropertyName(), info.getValue());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(LocalTimeSupplier property) {
        SerializableSupplierLambdaInfo<LocalTime> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        return gt(info.getSerializedLambdaInfo().getPropertyName(), info.getValue());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(LocalDateTimeSupplier property) {
        SerializableSupplierLambdaInfo<LocalDateTime> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        return gt(info.getSerializedLambdaInfo().getPropertyName(), info.getValue());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(StringSupplier property) {
        SerializableSupplierLambdaInfo<String> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        return gt(info.getSerializedLambdaInfo().getPropertyName(), info.getValue());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Date> L le(DateSupplier<R> property) {
        SerializableSupplierLambdaInfo<R> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        return le(info.getSerializedLambdaInfo().getPropertyName(), info.getValue());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Number> L le(NumberSupplier<R> property) {
        SerializableSupplierLambdaInfo<R> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        return le(info.getSerializedLambdaInfo().getPropertyName(), info.getValue());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(LocalDateSupplier property) {
        SerializableSupplierLambdaInfo<LocalDate> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        return le(info.getSerializedLambdaInfo().getPropertyName(), info.getValue());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(LocalTimeSupplier property) {
        SerializableSupplierLambdaInfo<LocalTime> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        return le(info.getSerializedLambdaInfo().getPropertyName(), info.getValue());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(LocalDateTimeSupplier property) {
        SerializableSupplierLambdaInfo<LocalDateTime> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        return le(info.getSerializedLambdaInfo().getPropertyName(), info.getValue());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(StringSupplier property) {
        SerializableSupplierLambdaInfo<String> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        return le(info.getSerializedLambdaInfo().getPropertyName(), info.getValue());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Number> L lt(NumberSupplier<R> property) {
        SerializableSupplierLambdaInfo<R> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        return lt(info.getSerializedLambdaInfo().getPropertyName(), info.getValue());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Date> L lt(DateSupplier<R> property) {
        SerializableSupplierLambdaInfo<R> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        return lt(info.getSerializedLambdaInfo().getPropertyName(), info.getValue());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(LocalDateSupplier property) {
        SerializableSupplierLambdaInfo<LocalDate> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        return lt(info.getSerializedLambdaInfo().getPropertyName(), info.getValue());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(LocalTimeSupplier property) {
        SerializableSupplierLambdaInfo<LocalTime> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        return lt(info.getSerializedLambdaInfo().getPropertyName(), info.getValue());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(LocalDateTimeSupplier property) {
        SerializableSupplierLambdaInfo<LocalDateTime> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        return lt(info.getSerializedLambdaInfo().getPropertyName(), info.getValue());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(StringSupplier property) {
        SerializableSupplierLambdaInfo<String> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        return lt(info.getSerializedLambdaInfo().getPropertyName(), info.getValue());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lk(String repository, String name, String value) {
        return (L) addCondition(
                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
                        QueryOperator.LK, aliasManager.getAlias(repository)));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> L lk(Class<T> repository, String name, String value) {
        return lk(getTableName(repository), name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lk(int repositoryIndex, String name, String value) {
        return (L) addCondition(
                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
                        QueryOperator.LK, aliasManager.getAlias(repositoryIndex)));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lk(String name, String value) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect,
                ClassMappingUtils.getColumnName(name, classMapping), value, QueryOperator.LK, queryAlias));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> L lk(ReturnStringFunction<T> name, String value) {
        return lk(getPropertyName(name), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lk(StringSupplier property) {
        SerializableSupplierLambdaInfo<String> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        return lk(info.getSerializedLambdaInfo().getPropertyName(), info.getValue());
    }

    /**
     * Supplier.
     *
     * @param <R>  the generic type
     * @param info the info
     * @return the list
     */
    protected <R> List<Tuple2<String, Optional<R>>> supplier(SerializableSupplierLambdaInfo<R> info) {
        return supplier(info, classMapping);
    }

    /**
     * Properties.
     *
     * @param <T>        the generic type
     * @param <R>        the generic type
     * @param repository the repository
     * @param property   the property
     * @return the tuple 3
     */
    protected <T, R> Tuple3<String, String, Object> conditionResult(SerializableSupplier<T> repository,
            SerializableFunction<T, R> property) {
        return conditionResult(repository, property, factory);
    }
}
