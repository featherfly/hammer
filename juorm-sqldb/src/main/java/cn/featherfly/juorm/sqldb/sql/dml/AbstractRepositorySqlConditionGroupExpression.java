
package cn.featherfly.juorm.sqldb.sql.dml;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

import cn.featherfly.common.lang.function.SerializableFunction;
import cn.featherfly.juorm.dml.AliasManager;
import cn.featherfly.juorm.expression.RepositoryConditionGroupLogicExpression;
import cn.featherfly.juorm.expression.condition.ParamedExpression;
import cn.featherfly.juorm.expression.condition.RepositoryConditionsGroupExpression;
import cn.featherfly.juorm.expression.condition.property.DateExpression;
import cn.featherfly.juorm.expression.condition.property.EnumExpression;
import cn.featherfly.juorm.expression.condition.property.NumberExpression;
import cn.featherfly.juorm.expression.condition.property.ObjectExpression;
import cn.featherfly.juorm.expression.condition.property.RepositorySimpleDateExpression;
import cn.featherfly.juorm.expression.condition.property.RepositorySimpleEnumExpression;
import cn.featherfly.juorm.expression.condition.property.RepositorySimpleNumberExpression;
import cn.featherfly.juorm.expression.condition.property.RepositorySimpleObjectExpression;
import cn.featherfly.juorm.expression.condition.property.RepositorySimpleStringExpression;
import cn.featherfly.juorm.expression.condition.property.SimpleDateExpression;
import cn.featherfly.juorm.expression.condition.property.SimpleEnumExpression;
import cn.featherfly.juorm.expression.condition.property.SimpleNumberExpression;
import cn.featherfly.juorm.expression.condition.property.SimpleObjectExpression;
import cn.featherfly.juorm.expression.condition.property.SimpleStringExpression;
import cn.featherfly.juorm.expression.condition.property.StringExpression;
import cn.featherfly.juorm.mapping.ClassMapping;
import cn.featherfly.juorm.mapping.MappingFactory;
import cn.featherfly.juorm.operator.LogicOperator;
import cn.featherfly.juorm.operator.QueryOperator;
import cn.featherfly.juorm.sqldb.jdbc.mapping.ClassMappingUtils;
import cn.featherfly.juorm.sqldb.sql.dialect.Dialect;

/**
 * <p>
 * sql condition group builder sql条件逻辑组构造器
 * </p>
 *
 * @author zhongj
 */
@SuppressWarnings("unchecked")
public abstract class AbstractRepositorySqlConditionGroupExpression<C extends RepositoryConditionsGroupExpression<C, L>,
        L extends RepositoryConditionGroupLogicExpression<C, L>> extends AbstractSqlConditionExpression<L>
        implements RepositoryConditionsGroupExpression<C, L>, RepositoryConditionGroupLogicExpression<C, L>, SqlBuilder,
        ParamedExpression {

    protected ClassMapping<?> classMapping;

    private String queryAlias;

    protected AliasManager aliasManager;

    protected MappingFactory factory;

    /**
     * @param dialect      dialect
     * @param factory      MappingFactory
     * @param aliasManager aliasManager
     */
    public AbstractRepositorySqlConditionGroupExpression(Dialect dialect, MappingFactory factory,
            AliasManager aliasManager) {
        this(dialect, factory, aliasManager, null, null);
    }

    /**
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
    public L endGroup() {
        if (parent != null) {
            return parent;
        } else {
            return (L) this;
        }
    }

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
    public <T, R> L co(SerializableFunction<T, R> name, String value) {
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
    public <T, R> L ew(SerializableFunction<T, R> name, String value) {
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
    public <T, R, D extends Date> L ge(SerializableFunction<T, R> name, D value) {
        return ge(getPropertyName(name), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> L ge(SerializableFunction<T, R> name, LocalDate value) {
        return ge(getPropertyName(name), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> L ge(SerializableFunction<T, R> name, LocalDateTime value) {
        return ge(getPropertyName(name), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> L ge(SerializableFunction<T, R> name, LocalTime value) {
        return ge(getPropertyName(name), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R, N extends Number> L ge(SerializableFunction<T, R> name, N value) {
        return ge(getPropertyName(name), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> L ge(SerializableFunction<T, R> name, String value) {
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
     * 返回queryAlias
     *
     * @return queryAlias
     */
    public String getQueryAlias() {
        return queryAlias;
    }

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
    public <T, R, D extends Date> L gt(SerializableFunction<T, R> name, D value) {
        return gt(getPropertyName(name), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> L gt(SerializableFunction<T, R> name, LocalDate value) {
        return gt(getPropertyName(name), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> L gt(SerializableFunction<T, R> name, LocalDateTime value) {
        return gt(getPropertyName(name), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> L gt(SerializableFunction<T, R> name, LocalTime value) {
        return gt(getPropertyName(name), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R, N extends Number> L gt(SerializableFunction<T, R> name, N value) {
        return gt(getPropertyName(name), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> L gt(SerializableFunction<T, R> name, String value) {
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
    public <T, R, D extends Date> L le(SerializableFunction<T, R> name, D value) {
        return le(getPropertyName(name), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> L le(SerializableFunction<T, R> name, LocalDate value) {
        return le(getPropertyName(name), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> L le(SerializableFunction<T, R> name, LocalDateTime value) {
        return le(getPropertyName(name), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> L le(SerializableFunction<T, R> name, LocalTime value) {
        return le(getPropertyName(name), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R, N extends Number> L le(SerializableFunction<T, R> name, N value) {
        return le(getPropertyName(name), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> L le(SerializableFunction<T, R> name, String value) {
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
    public <T, R, D extends Date> L lt(SerializableFunction<T, R> name, D value) {
        return lt(getPropertyName(name), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> L lt(SerializableFunction<T, R> name, LocalDate value) {
        return lt(getPropertyName(name), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> L lt(SerializableFunction<T, R> name, LocalDateTime value) {
        return lt(getPropertyName(name), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> L lt(SerializableFunction<T, R> name, LocalTime value) {
        return lt(getPropertyName(name), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R, N extends Number> L lt(SerializableFunction<T, R> name, N value) {
        return lt(getPropertyName(name), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> L lt(SerializableFunction<T, R> name, String value) {
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

    // ********************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    public StringExpression<C, L> propertyString(String repository, String name) {
        return new RepositorySimpleStringExpression<>(repository, ClassMappingUtils.getColumnName(name, classMapping),
                this);
    }

    // ********************************************************************
    // property
    // ********************************************************************

    /**
     * 设置queryAlias
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
    public <T, R> L sw(SerializableFunction<T, R> name, String value) {
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
}
