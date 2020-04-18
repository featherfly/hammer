
package cn.featherfly.hammer.sqldb.sql.dml;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import cn.featherfly.common.db.builder.ConditionBuildUtils;
import cn.featherfly.common.db.builder.SqlBuilder;
import cn.featherfly.common.db.builder.dml.SqlLogicExpression;
import cn.featherfly.common.db.dialect.Dialect;
import cn.featherfly.common.lang.LambdaUtils;
import cn.featherfly.common.lang.LangUtils;
import cn.featherfly.common.lang.StringUtils;
import cn.featherfly.common.lang.function.SerializableFunction;
import cn.featherfly.common.repository.builder.BuilderException;
import cn.featherfly.hammer.expression.condition.Expression;
import cn.featherfly.hammer.expression.condition.ParamedExpression;

/**
 * <p>
 * sql condition group builder sql条件逻辑组构造器
 * </p>
 *
 * @author zhongj
 */
public abstract class AbstractSqlConditionExpression<L> implements SqlBuilder, ParamedExpression {

    /**
     * @param dialect dialect
     */
    public AbstractSqlConditionExpression(Dialect dialect) {
        this(dialect, null);
    }

    /**
     * @param dialect dialect
     * @param parent  parent group
     */
    protected AbstractSqlConditionExpression(Dialect dialect, L parent) {
        this.dialect = dialect;
        this.parent = parent;
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
            if (availableExpressions.get(availableExpressions.size() - 1) instanceof SqlLogicExpression) {
                availableExpressions.remove(availableExpressions.size() - 1);
                availableConditions.remove(availableConditions.size() - 1);
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
    // protected method
    // ********************************************************************

    protected <T, R> String getPropertyName(SerializableFunction<T, R> name) {
        return LambdaUtils.getLambdaPropertyName(name);
    }

    protected Object addCondition(Expression condition) {
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

    protected L parent;

    protected Dialect dialect;

    private Expression previousCondition;

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
}
