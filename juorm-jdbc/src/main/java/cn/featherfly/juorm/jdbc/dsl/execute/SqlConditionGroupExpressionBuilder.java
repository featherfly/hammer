
package cn.featherfly.juorm.jdbc.dsl.execute;

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
import cn.featherfly.juorm.dsl.execute.ConditionGroupExpression;
import cn.featherfly.juorm.dsl.execute.ConditionGroupLogic;
import cn.featherfly.juorm.expression.Expression;
import cn.featherfly.juorm.expression.ParamedExpression;
import cn.featherfly.juorm.jdbc.Jdbc;
import cn.featherfly.juorm.operator.LogicOperator;
import cn.featherfly.juorm.operator.QueryOperator;
import cn.featherfly.juorm.sql.dml.builder.SqlLogicExpression;

/**
 * <p>
 * sql condition group builder sql条件逻辑组构造器
 * </p>
 *
 * @author zhongj
 */
public class SqlConditionGroupExpressionBuilder
        implements ConditionGroupExpression, ConditionGroupLogic, SqlBuilder, ParamedExpression {

    /**
     * @param dialect dialect
     */
    public SqlConditionGroupExpressionBuilder(Jdbc jdbc) {
        this(jdbc, null);
    }

    /**
     * @param dialect    dialect
     * @param queryAlias queryAlias
     */
    public SqlConditionGroupExpressionBuilder(Jdbc jdbc, String queryAlias) {
        this(jdbc, null, queryAlias);
    }

    /**
     * @param dialect    dialect
     * @param parent     parent group
     * @param queryAlias queryAlias
     */
    SqlConditionGroupExpressionBuilder(Jdbc jdbc, SqlConditionGroupExpressionBuilder parent, String queryAlias) {
        this.jdbc = jdbc;
        this.parent = parent;
        this.queryAlias = queryAlias;
    }

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
            //            String condition = expression.build();
            String condition = expression.toString();
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

    /**
     * {@inheritDoc}
     */
    @Override
    public int execute() {
        return jdbc.getJdbcTemplate().update(build(), getParams());
    }

    // ********************************************************************
    // private method
    // ********************************************************************

    private SqlConditionGroupExpressionBuilder addCondition(Expression condition) {
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

    protected Jdbc jdbc;

    private SqlConditionGroupExpressionBuilder parent;

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
    public ConditionGroupLogic co(String name, String value) {
        return addCondition(
                new SqlConditionExpressionBuilder(jdbc.getDialect(), name, value, QueryOperator.CO, queryAlias));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ConditionGroupLogic ew(String name, String value) {
        return addCondition(
                new SqlConditionExpressionBuilder(jdbc.getDialect(), name, value, QueryOperator.EW, queryAlias));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ConditionGroupLogic eq(String name, Object value) {
        return addCondition(
                new SqlConditionExpressionBuilder(jdbc.getDialect(), name, value, QueryOperator.EQ, queryAlias));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> ConditionGroupLogic ge(String name, Number value) {
        return addCondition(
                new SqlConditionExpressionBuilder(jdbc.getDialect(), name, value, QueryOperator.GE, queryAlias));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> ConditionGroupLogic ge(String name, D value) {
        return addCondition(
                new SqlConditionExpressionBuilder(jdbc.getDialect(), name, value, QueryOperator.GE, queryAlias));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ConditionGroupLogic ge(String name, LocalTime value) {
        return addCondition(
                new SqlConditionExpressionBuilder(jdbc.getDialect(), name, value, QueryOperator.GE, queryAlias));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ConditionGroupLogic ge(String name, LocalDate value) {
        return addCondition(
                new SqlConditionExpressionBuilder(jdbc.getDialect(), name, value, QueryOperator.GE, queryAlias));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ConditionGroupLogic ge(String name, LocalDateTime value) {
        return addCondition(
                new SqlConditionExpressionBuilder(jdbc.getDialect(), name, value, QueryOperator.GE, queryAlias));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ConditionGroupLogic ge(String name, String value) {
        return addCondition(
                new SqlConditionExpressionBuilder(jdbc.getDialect(), name, value, QueryOperator.GE, queryAlias));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> ConditionGroupLogic gt(String name, Number value) {
        return addCondition(
                new SqlConditionExpressionBuilder(jdbc.getDialect(), name, value, QueryOperator.GT, queryAlias));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> ConditionGroupLogic gt(String name, D value) {
        return addCondition(
                new SqlConditionExpressionBuilder(jdbc.getDialect(), name, value, QueryOperator.GT, queryAlias));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ConditionGroupLogic gt(String name, LocalTime value) {
        return addCondition(
                new SqlConditionExpressionBuilder(jdbc.getDialect(), name, value, QueryOperator.GT, queryAlias));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ConditionGroupLogic gt(String name, LocalDate value) {
        return addCondition(
                new SqlConditionExpressionBuilder(jdbc.getDialect(), name, value, QueryOperator.GT, queryAlias));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ConditionGroupLogic gt(String name, LocalDateTime value) {
        return addCondition(
                new SqlConditionExpressionBuilder(jdbc.getDialect(), name, value, QueryOperator.GT, queryAlias));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ConditionGroupLogic gt(String name, String value) {
        return addCondition(
                new SqlConditionExpressionBuilder(jdbc.getDialect(), name, value, QueryOperator.GT, queryAlias));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ConditionGroupLogic in(String name, Object value) {
        return addCondition(
                new SqlConditionExpressionBuilder(jdbc.getDialect(), name, value, QueryOperator.IN, queryAlias));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ConditionGroupLogic inn(String name) {
        return addCondition(
                new SqlConditionExpressionBuilder(jdbc.getDialect(), name, null, QueryOperator.INN, queryAlias));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ConditionGroupLogic isn(String name) {
        return addCondition(
                new SqlConditionExpressionBuilder(jdbc.getDialect(), name, null, QueryOperator.ISN, queryAlias));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> ConditionGroupLogic le(String name, Number value) {
        return addCondition(
                new SqlConditionExpressionBuilder(jdbc.getDialect(), name, value, QueryOperator.LE, queryAlias));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> ConditionGroupLogic le(String name, D value) {
        return addCondition(
                new SqlConditionExpressionBuilder(jdbc.getDialect(), name, value, QueryOperator.LE, queryAlias));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ConditionGroupLogic le(String name, LocalTime value) {
        return addCondition(
                new SqlConditionExpressionBuilder(jdbc.getDialect(), name, value, QueryOperator.LE, queryAlias));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ConditionGroupLogic le(String name, LocalDate value) {
        return addCondition(
                new SqlConditionExpressionBuilder(jdbc.getDialect(), name, value, QueryOperator.LE, queryAlias));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ConditionGroupLogic le(String name, LocalDateTime value) {
        return addCondition(
                new SqlConditionExpressionBuilder(jdbc.getDialect(), name, value, QueryOperator.LE, queryAlias));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ConditionGroupLogic le(String name, String value) {
        return addCondition(
                new SqlConditionExpressionBuilder(jdbc.getDialect(), name, value, QueryOperator.LE, queryAlias));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> ConditionGroupLogic lt(String name, Number value) {
        return addCondition(
                new SqlConditionExpressionBuilder(jdbc.getDialect(), name, value, QueryOperator.LT, queryAlias));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> ConditionGroupLogic lt(String name, D value) {
        return addCondition(
                new SqlConditionExpressionBuilder(jdbc.getDialect(), name, value, QueryOperator.LT, queryAlias));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ConditionGroupLogic lt(String name, LocalTime value) {
        return addCondition(
                new SqlConditionExpressionBuilder(jdbc.getDialect(), name, value, QueryOperator.LT, queryAlias));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ConditionGroupLogic lt(String name, LocalDate value) {
        return addCondition(
                new SqlConditionExpressionBuilder(jdbc.getDialect(), name, value, QueryOperator.LT, queryAlias));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ConditionGroupLogic lt(String name, LocalDateTime value) {
        return addCondition(
                new SqlConditionExpressionBuilder(jdbc.getDialect(), name, value, QueryOperator.LT, queryAlias));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ConditionGroupLogic lt(String name, String value) {
        return addCondition(
                new SqlConditionExpressionBuilder(jdbc.getDialect(), name, value, QueryOperator.LT, queryAlias));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ConditionGroupLogic ne(String name, Object value) {
        return addCondition(
                new SqlConditionExpressionBuilder(jdbc.getDialect(), name, value, QueryOperator.NE, queryAlias));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ConditionGroupLogic nin(String name, Object value) {
        return addCondition(
                new SqlConditionExpressionBuilder(jdbc.getDialect(), name, value, QueryOperator.NIN, queryAlias));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ConditionGroupLogic sw(String name, String value) {
        return addCondition(
                new SqlConditionExpressionBuilder(jdbc.getDialect(), name, value, QueryOperator.SW, queryAlias));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ConditionGroupExpression group() {
        SqlConditionGroupExpressionBuilder group = new SqlConditionGroupExpressionBuilder(jdbc, this, queryAlias);
        addCondition(group);
        return group;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ConditionGroupLogic parent() {
        return parent;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ConditionGroupExpression and() {
        return addCondition(new SqlLogicOperatorExpressionBuilder(LogicOperator.AND));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ConditionGroupExpression or() {
        return addCondition(new SqlLogicOperatorExpressionBuilder(LogicOperator.OR));
    }
}
