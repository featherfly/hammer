
package cn.featherfly.juorm.sql.dml;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import cn.featherfly.common.lang.LangUtils;
import cn.featherfly.common.lang.StringUtils;
import cn.featherfly.juorm.dml.builder.BuilderException;
import cn.featherfly.juorm.dml.builder.ConditionBuildUtils;
import cn.featherfly.juorm.expression.ConditionGroupExpression;
import cn.featherfly.juorm.expression.ConditionGroupLogicExpression;
import cn.featherfly.juorm.expression.condition.Expression;
import cn.featherfly.juorm.expression.condition.ParamedExpression;
import cn.featherfly.juorm.expression.condition.property.DateExpression;
import cn.featherfly.juorm.expression.condition.property.EnumExpression;
import cn.featherfly.juorm.expression.condition.property.NumberExpression;
import cn.featherfly.juorm.expression.condition.property.ObjectExpression;
import cn.featherfly.juorm.expression.condition.property.SimpleObjectExpression;
import cn.featherfly.juorm.expression.condition.property.StringExpression;
import cn.featherfly.juorm.operator.LogicOperator;
import cn.featherfly.juorm.operator.QueryOperator;
import cn.featherfly.juorm.sql.dialect.Dialect;
import cn.featherfly.juorm.sql.dml.builder.SqlLogicExpression;

/**
 * <p>
 * sql condition group builder sql条件逻辑组构造器
 * </p>
 *
 * @author zhongj
 */
@SuppressWarnings("unchecked")
public abstract class AbstractSqlConditionGroupExpression<C extends ConditionGroupExpression<C, L>,
        L extends ConditionGroupLogicExpression<C, L>>
        implements ConditionGroupExpression<C, L>, ConditionGroupLogicExpression<C, L>, SqlBuilder, ParamedExpression {

    /**
     * @param dialect dialect
     */
    public AbstractSqlConditionGroupExpression(Dialect dialect) {
        this(dialect, null);
    }

    /**
     * @param dialect    dialect
     * @param queryAlias queryAlias
     */
    public AbstractSqlConditionGroupExpression(Dialect dialect, String queryAlias) {
        this(dialect, null, queryAlias);
    }

    /**
     * @param dialect    dialect
     * @param parent     parent group
     * @param queryAlias queryAlias
     */
    protected AbstractSqlConditionGroupExpression(Dialect dialect, L parent, String queryAlias) {
        this.dialect = dialect;
        this.parent = parent;
        this.queryAlias = queryAlias;
        i = System.currentTimeMillis();
    }

    public long i;

    /**
     * {@inheritDoc}
     */
    @Override
    public String build() {
        StringBuilder result = new StringBuilder();
        if (conditions.size() > 0) {
            Expression last = conditions.get(conditions.size() - 1);
            if (last instanceof SqlLogicExpression) {
                throw new BuilderException(((SqlLogicExpression) last).getLogicOperator() + " 后没有跟条件表达式");
            }
        }

        List<String> availableConditions = new ArrayList<>();
        List<Expression> availableExpressions = new ArrayList<>();
        for (Expression expression : conditions) {
            // String condition = expression.build();
            String condition = expression.expression();
            if (StringUtils.isNotBlank(condition)) {
                availableConditions.add(condition);
                availableExpressions.add(expression);
            } else {
                if (availableExpressions.size() > 0) {
                    Expression pre = availableExpressions.get(availableExpressions.size() - 1);
                    if (pre instanceof SqlLogicExpression) {
                        availableExpressions.remove(availableExpressions.size() - 1);
                        availableConditions.remove(availableConditions.size() - 1);
                    }
                }
            }
        }

        if (availableExpressions.size() > 0) {
            if (availableExpressions.get(0) instanceof SqlLogicExpression) {
                availableExpressions.remove(0);
                availableConditions.remove(0);
            }
        }

        for (String condition : availableConditions) {
            ConditionBuildUtils.appendCondition(result, condition);
        }
        if (result.length() > 0 && parent != null) {
            return " ( " + result.toString() + " ) ";
        } else {
            return result.toString();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String expression() {
        return build();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Object getParam() {
        return getParams();
    }

    public List<Object> getParams() {
        List<Object> params = new ArrayList<>();
        for (Expression condition : conditions) {
            if (condition instanceof ParamedExpression) {
                Object param = ((ParamedExpression) condition).getParam();
                if (LangUtils.isNotEmpty(param)) {
                    if (param instanceof Collection) {
                        params.addAll((Collection<?>) param);
                    } else if (param.getClass().isArray()) {
                        int length = Array.getLength(param);
                        for (int i = 0; i < length; i++) {
                            params.add(Array.get(param, i));
                        }
                    } else {
                        params.add(param);
                    }
                }
            }
        }
        return params;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return build();
    }

    // ********************************************************************
    // private method
    // ********************************************************************

    private Object addCondition(Expression condition) {
        if (previousCondition != null) {
            if (previousCondition.getClass().isInstance(condition)) {
                throw new BuilderException("语法错误，连续相同类型的表达式：" + condition.getClass().getName());
            }
        }
        previousCondition = condition;
        conditions.add(condition);
        return this;
    }

    // ********************************************************************
    // property
    // ********************************************************************

    private List<Expression> conditions = new ArrayList<>();

    protected Dialect dialect;

    protected L parent;

    private Expression previousCondition;

    private String queryAlias;

    /*
     * 忽略空值
     */
    private boolean ignoreEmpty = true;

    public boolean isIgnoreEmpty() {
        return ignoreEmpty;
    }

    public void setIgnoreEmpty(boolean ignoreEmpty) {
        this.ignoreEmpty = ignoreEmpty;
    }

    public List<Expression> getConditions() {
        return conditions;
    }

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

    /**
     * {@inheritDoc}
     */
    @Override
    public L co(String name, String value) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, QueryOperator.CO, queryAlias));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ew(String name, String value) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, QueryOperator.EW, queryAlias));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(String name, Object value) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, QueryOperator.EQ, queryAlias));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L ge(String name, Number value) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, QueryOperator.GE, queryAlias));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L ge(String name, D value) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, QueryOperator.GE, queryAlias));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(String name, LocalTime value) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, QueryOperator.GE, queryAlias));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(String name, LocalDate value) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, QueryOperator.GE, queryAlias));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(String name, LocalDateTime value) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, QueryOperator.GE, queryAlias));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(String name, String value) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, QueryOperator.GE, queryAlias));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L gt(String name, Number value) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, QueryOperator.GT, queryAlias));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L gt(String name, D value) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, QueryOperator.GT, queryAlias));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(String name, LocalTime value) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, QueryOperator.GT, queryAlias));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(String name, LocalDate value) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, QueryOperator.GT, queryAlias));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(String name, LocalDateTime value) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, QueryOperator.GT, queryAlias));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(String name, String value) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, QueryOperator.GT, queryAlias));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(String name, Object value) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, QueryOperator.IN, queryAlias));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L inn(String name) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, null, QueryOperator.INN, queryAlias));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L isn(String name) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, null, QueryOperator.ISN, queryAlias));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L le(String name, Number value) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, QueryOperator.LE, queryAlias));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L le(String name, D value) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, QueryOperator.LE, queryAlias));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(String name, LocalTime value) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, QueryOperator.LE, queryAlias));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(String name, LocalDate value) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, QueryOperator.LE, queryAlias));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(String name, LocalDateTime value) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, QueryOperator.LE, queryAlias));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(String name, String value) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, QueryOperator.LE, queryAlias));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L lt(String name, Number value) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, QueryOperator.LT, queryAlias));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L lt(String name, D value) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, QueryOperator.LT, queryAlias));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(String name, LocalTime value) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, QueryOperator.LT, queryAlias));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(String name, LocalDate value) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, QueryOperator.LT, queryAlias));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(String name, LocalDateTime value) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, QueryOperator.LT, queryAlias));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(String name, String value) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, QueryOperator.LT, queryAlias));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(String name, Object value) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, QueryOperator.NE, queryAlias));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nin(String name, Object value) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, QueryOperator.NIN, queryAlias));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L sw(String name, String value) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, QueryOperator.SW, queryAlias));
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
        return new SimpleObjectExpression<>(name, this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public StringExpression<C, L> propertyString(String name) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public NumberExpression<C, L> propertyNumber(String name) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DateExpression<C, L> propertyDate(String name) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EnumExpression<C, L> propertyEnum(String name) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

}
