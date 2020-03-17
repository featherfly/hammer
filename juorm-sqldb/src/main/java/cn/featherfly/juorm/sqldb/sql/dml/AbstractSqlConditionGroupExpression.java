
package cn.featherfly.juorm.sqldb.sql.dml;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

import cn.featherfly.common.lang.function.SerializableFunction;
import cn.featherfly.juorm.expression.ConditionGroupExpression;
import cn.featherfly.juorm.expression.ConditionGroupLogicExpression;
import cn.featherfly.juorm.expression.condition.ParamedExpression;
import cn.featherfly.juorm.expression.condition.property.DateExpression;
import cn.featherfly.juorm.expression.condition.property.EnumExpression;
import cn.featherfly.juorm.expression.condition.property.NumberExpression;
import cn.featherfly.juorm.expression.condition.property.ObjectExpression;
import cn.featherfly.juorm.expression.condition.property.SimpleDateExpression;
import cn.featherfly.juorm.expression.condition.property.SimpleEnumExpression;
import cn.featherfly.juorm.expression.condition.property.SimpleNumberExpression;
import cn.featherfly.juorm.expression.condition.property.SimpleObjectExpression;
import cn.featherfly.juorm.expression.condition.property.SimpleStringExpression;
import cn.featherfly.juorm.expression.condition.property.StringExpression;
import cn.featherfly.juorm.mapping.ClassMapping;
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
public abstract class AbstractSqlConditionGroupExpression<C extends ConditionGroupExpression<C, L>,
        L extends ConditionGroupLogicExpression<C, L>> extends AbstractSqlConditionExpression<L>
        implements ConditionGroupExpression<C, L>, ConditionGroupLogicExpression<C, L>, SqlBuilder, ParamedExpression {

    /**
     * @param dialect dialect
     */
    public AbstractSqlConditionGroupExpression(Dialect dialect) {
        this(dialect, null, null);
    }

    /**
     * @param dialect    dialect
     * @param queryAlias queryAlias
     */
    public AbstractSqlConditionGroupExpression(Dialect dialect, String queryAlias) {
        this(dialect, null, queryAlias, null);
    }

    /**
     * @param dialect      dialect
     * @param queryAlias   queryAlias
     * @param classMapping classMapping
     */
    public AbstractSqlConditionGroupExpression(Dialect dialect, String queryAlias, ClassMapping<?> classMapping) {
        this(dialect, null, queryAlias, classMapping);
    }

    /**
     * @param dialect      dialect
     * @param parent       parent group
     * @param queryAlias   queryAlias
     * @param classMapping classMapping
     */
    protected AbstractSqlConditionGroupExpression(Dialect dialect, L parent, String queryAlias,
            ClassMapping<?> classMapping) {
        super(dialect, parent);
        this.queryAlias = queryAlias;
        this.classMapping = classMapping;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return build();
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
    public L ew(String name, String value) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect,
                ClassMappingUtils.getColumnName(name, classMapping), value, QueryOperator.EW, queryAlias));
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
    public <N extends Number> L ge(String name, N value) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect,
                ClassMappingUtils.getColumnName(name, classMapping), value, QueryOperator.GE, queryAlias));
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
    public L ge(String name, LocalTime value) {
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
    public L ge(String name, String value) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect,
                ClassMappingUtils.getColumnName(name, classMapping), value, QueryOperator.GE, queryAlias));
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
    public <D extends Date> L gt(String name, D value) {
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
    public L gt(String name, String value) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect,
                ClassMappingUtils.getColumnName(name, classMapping), value, QueryOperator.GT, queryAlias));
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
    public L inn(String name) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect,
                ClassMappingUtils.getColumnName(name, classMapping), null, QueryOperator.INN, queryAlias));
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
    public <N extends Number> L le(String name, N value) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect,
                ClassMappingUtils.getColumnName(name, classMapping), value, QueryOperator.LE, queryAlias));
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
    public L le(String name, LocalTime value) {
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
    public L le(String name, String value) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect,
                ClassMappingUtils.getColumnName(name, classMapping), value, QueryOperator.LE, queryAlias));
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
    public <D extends Date> L lt(String name, D value) {
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
    public L lt(String name, String value) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect,
                ClassMappingUtils.getColumnName(name, classMapping), value, QueryOperator.LT, queryAlias));
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
    public L nin(String name, Object value) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect,
                ClassMappingUtils.getColumnName(name, classMapping), value, QueryOperator.NIN, queryAlias));
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
    public C group() {
        // SqlConditionGroupExpressionBuilder group = new
        // SqlConditionGroupExpressionBuilder(
        // jdbc, this, queryAlias);
        C group = createGroup((L) this, queryAlias);
        addCondition(group);
        return group;
    }

    protected abstract C createGroup(L parent, String queryAlias);

    protected AbstractSqlConditionGroupExpression<C, L> getRoot() {
        L p = endGroup();
        L p2 = p.endGroup();
        while (p != p2) {
            p = p.endGroup();
        }
        return (AbstractSqlConditionGroupExpression<C, L>) p;
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
    public ObjectExpression<C, L> property(String name) {
        return new SimpleObjectExpression<>(ClassMappingUtils.getColumnName(name, classMapping), this);
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
    public NumberExpression<C, L> propertyNumber(String name) {
        return new SimpleNumberExpression<>(ClassMappingUtils.getColumnName(name, classMapping), this);
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
    public EnumExpression<C, L> propertyEnum(String name) {
        return new SimpleEnumExpression<>(ClassMappingUtils.getColumnName(name, classMapping), this);
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
    public <T, R> L ew(SerializableFunction<T, R> name, String value) {
        return ew(getPropertyName(name), value);
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
    public <T, R, N extends Number> L ge(SerializableFunction<T, R> name, N value) {
        return ge(getPropertyName(name), value);
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
    public <T, R> L ge(SerializableFunction<T, R> name, LocalTime value) {
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
    public <T, R> L ge(SerializableFunction<T, R> name, String value) {
        return ge(getPropertyName(name), value);
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
    public <T, R, D extends Date> L gt(SerializableFunction<T, R> name, D value) {
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
    public <T, R> L gt(SerializableFunction<T, R> name, String value) {
        return gt(getPropertyName(name), value);
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
    public <T, R> L inn(SerializableFunction<T, R> name) {
        return inn(getPropertyName(name));
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
    public <T, R, N extends Number> L le(SerializableFunction<T, R> name, N value) {
        return le(getPropertyName(name), value);
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
    public <T, R> L le(SerializableFunction<T, R> name, LocalTime value) {
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
    public <T, R> L le(SerializableFunction<T, R> name, String value) {
        return le(getPropertyName(name), value);
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
    public <T, R, D extends Date> L lt(SerializableFunction<T, R> name, D value) {
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
    public <T, R> L lt(SerializableFunction<T, R> name, String value) {
        return lt(getPropertyName(name), value);
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
    public <T, R> L nin(SerializableFunction<T, R> name, Object value) {
        return nin(getPropertyName(name), value);
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
    public <T, R> ObjectExpression<C, L> property(SerializableFunction<T, R> name) {
        return property(getPropertyName(name));
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
    public <T, R extends Number> NumberExpression<C, L> propertyNumber(SerializableFunction<T, R> name) {
        return propertyNumber(getPropertyName(name));
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
    public <T, R extends Enum<?>> EnumExpression<C, L> propertyEnum(SerializableFunction<T, R> name) {
        return propertyEnum(getPropertyName(name));
    }

    // ********************************************************************
    // private method
    // ********************************************************************

    // ********************************************************************
    // property
    // ********************************************************************

    protected ClassMapping<?> classMapping;

    private String queryAlias;

    /**
     * 返回queryAlias
     *
     * @return queryAlias
     */
    public String getQueryAlias() {
        return queryAlias;
    }

    /**
     * 设置queryAlias
     *
     * @param queryAlias queryAlias
     */
    public void setQueryAlias(String queryAlias) {
        this.queryAlias = queryAlias;
    }
}
