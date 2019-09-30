
package cn.featherfly.juorm.rdb.sql.dml;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import cn.featherfly.common.lang.LambdaUtils;
import cn.featherfly.common.lang.LangUtils;
import cn.featherfly.common.lang.StringUtils;
import cn.featherfly.common.lang.function.SerializableFunction;
import cn.featherfly.juorm.dml.AliasManager;
import cn.featherfly.juorm.dml.builder.BuilderException;
import cn.featherfly.juorm.dml.builder.ConditionBuildUtils;
import cn.featherfly.juorm.expression.RepositoryConditionGroupLogicExpression;
import cn.featherfly.juorm.expression.condition.Expression;
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
import cn.featherfly.juorm.operator.LogicOperator;
import cn.featherfly.juorm.operator.QueryOperator;
import cn.featherfly.juorm.rdb.jdbc.mapping.ClassMappingUtils;
import cn.featherfly.juorm.rdb.sql.dialect.Dialect;
import cn.featherfly.juorm.rdb.sql.dml.builder.SqlLogicExpression;

/**
 * <p>
 * sql condition group builder sql条件逻辑组构造器
 * </p>
 *
 * @author zhongj
 */
@SuppressWarnings("unchecked")
public abstract class AbstractRepositorySqlConditionGroupExpression<C extends RepositoryConditionsGroupExpression<C, L>,
        L extends RepositoryConditionGroupLogicExpression<C, L>> implements RepositoryConditionsGroupExpression<C, L>,
        RepositoryConditionGroupLogicExpression<C, L>, SqlBuilder, ParamedExpression {

    /**
     * @param dialect      dialect
     * @param aliasManager aliasManager
     */
    public AbstractRepositorySqlConditionGroupExpression(Dialect dialect, AliasManager aliasManager) {
        this(dialect, aliasManager, null, null);
    }

    /**
     * @param dialect      dialect
     * @param aliasManager aliasManager
     * @param queryAlias   queryAlias
     */
    public AbstractRepositorySqlConditionGroupExpression(Dialect dialect, AliasManager aliasManager,
            String queryAlias) {
        this(dialect, aliasManager, null, queryAlias, null);
    }

    /**
     * @param dialect      dialect
     * @param aliasManager aliasManager
     * @param queryAlias   queryAlias
     * @param classMapping classMapping
     */
    public AbstractRepositorySqlConditionGroupExpression(Dialect dialect, AliasManager aliasManager, String queryAlias,
            ClassMapping<?> classMapping) {
        this(dialect, aliasManager, null, queryAlias, classMapping);
    }

    /**
     * @param dialect      dialect
     * @param aliasManager aliasManager
     * @param parent       parent group
     * @param queryAlias   queryAlias
     * @param classMapping classMapping
     */
    protected AbstractRepositorySqlConditionGroupExpression(Dialect dialect, AliasManager aliasManager, L parent,
            String queryAlias, ClassMapping<?> classMapping) {
        this.dialect = dialect;
        this.parent = parent;
        this.queryAlias = queryAlias;
        this.classMapping = classMapping;
        this.aliasManager = aliasManager;
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
    public <N extends Number> L ge(String name, Number value) {
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
    public <N extends Number> L gt(String name, Number value) {
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
    public <N extends Number> L le(String name, Number value) {
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
    public <N extends Number> L lt(String name, Number value) {
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
    public L co(String repository, String name, String value) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect,
                ClassMappingUtils.getColumnName(name, classMapping), value, QueryOperator.CO, queryAlias));
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
    public L eq(String repository, String name, Object value) {
        return (L) addCondition(
                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
                        QueryOperator.EQ, aliasManager.getAlias(repository)));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L ge(String repository, String name, Number value) {
        return (L) addCondition(
                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
                        QueryOperator.GE, aliasManager.getAlias(repository)));
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
    public L ge(String repository, String name, LocalTime value) {
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
    public L ge(String repository, String name, String value) {
        return (L) addCondition(
                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
                        QueryOperator.GE, aliasManager.getAlias(repository)));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L gt(String repository, String name, Number value) {
        return (L) addCondition(
                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
                        QueryOperator.GT, aliasManager.getAlias(repository)));
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
    public L gt(String repository, String name, LocalTime value) {
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
    public L gt(String repository, String name, String value) {
        return (L) addCondition(
                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
                        QueryOperator.GT, aliasManager.getAlias(repository)));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L le(int repositoryIndex, String name, Number value) {
        return (L) addCondition(
                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
                        QueryOperator.LE, aliasManager.getAlias(repositoryIndex)));
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
    public L le(int repositoryIndex, String name, LocalTime value) {
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
    public L le(int repositoryIndex, String name, String value) {
        return (L) addCondition(
                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
                        QueryOperator.LE, aliasManager.getAlias(repositoryIndex)));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L lt(int repositoryIndex, String name, Number value) {
        return (L) addCondition(
                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
                        QueryOperator.LT, aliasManager.getAlias(repositoryIndex)));
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
    public L lt(int repositoryIndex, String name, LocalTime value) {
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
    public L lt(int repositoryIndex, String name, String value) {
        return (L) addCondition(
                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
                        QueryOperator.LT, aliasManager.getAlias(repositoryIndex)));
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
    public L inn(String repository, String name) {
        return (L) addCondition(
                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), null,
                        QueryOperator.INN, aliasManager.getAlias(repository)));
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
    public <N extends Number> L le(String repository, String name, Number value) {
        return (L) addCondition(
                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
                        QueryOperator.LE, aliasManager.getAlias(repository)));
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
    public L le(String repository, String name, LocalTime value) {
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
    public L le(String repository, String name, String value) {
        return (L) addCondition(
                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
                        QueryOperator.LE, aliasManager.getAlias(repository)));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L lt(String repository, String name, Number value) {
        return (L) addCondition(
                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
                        QueryOperator.LT, aliasManager.getAlias(repository)));
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
    public L lt(String repository, String name, LocalTime value) {
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
    public L lt(String repository, String name, String value) {
        return (L) addCondition(
                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
                        QueryOperator.LT, aliasManager.getAlias(repository)));
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
    public L nin(String repository, String name, Object value) {
        return (L) addCondition(
                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
                        QueryOperator.NIN, aliasManager.getAlias(repository)));
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
    public L co(int repositoryIndex, String name, String value) {
        return (L) addCondition(
                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
                        QueryOperator.CO, aliasManager.getAlias(repositoryIndex)));
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
    public L eq(int repositoryIndex, String name, Object value) {
        return (L) addCondition(
                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
                        QueryOperator.EQ, aliasManager.getAlias(repositoryIndex)));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L ge(int repositoryIndex, String name, Number value) {
        return (L) addCondition(
                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
                        QueryOperator.GE, aliasManager.getAlias(repositoryIndex)));
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
    public L ge(int repositoryIndex, String name, LocalTime value) {
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
    public L ge(int repositoryIndex, String name, String value) {
        return (L) addCondition(
                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
                        QueryOperator.GE, aliasManager.getAlias(repositoryIndex)));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L gt(int repositoryIndex, String name, Number value) {
        return (L) addCondition(
                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
                        QueryOperator.GT, aliasManager.getAlias(repositoryIndex)));
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
    public L gt(int repositoryIndex, String name, LocalTime value) {
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
    public L gt(int repositoryIndex, String name, String value) {
        return (L) addCondition(
                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
                        QueryOperator.GT, aliasManager.getAlias(repositoryIndex)));
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
    public L inn(int repositoryIndex, String name) {
        return (L) addCondition(
                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), null,
                        QueryOperator.INN, aliasManager.getAlias(repositoryIndex)));
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
    public L ne(int repositoryIndex, String name, Object value) {
        return (L) addCondition(
                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
                        QueryOperator.NE, aliasManager.getAlias(repositoryIndex)));
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
    public L sw(int repositoryIndex, String name, String value) {
        return (L) addCondition(
                new SqlConditionExpressionBuilder(dialect, ClassMappingUtils.getColumnName(name, classMapping), value,
                        QueryOperator.SW, aliasManager.getAlias(repositoryIndex)));
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

    protected AbstractRepositorySqlConditionGroupExpression<C, L> getRoot() {
        L p = endGroup();
        L p2 = p.endGroup();
        while (p != p2) {
            p = p.endGroup();
        }
        return (AbstractRepositorySqlConditionGroupExpression<C, L>) p;
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
    public ObjectExpression<C, L> property(String repository, String name) {
        return new RepositorySimpleObjectExpression<>(repository, ClassMappingUtils.getColumnName(name, classMapping),
                this);
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
    public NumberExpression<C, L> propertyNumber(String repository, String name) {
        return new RepositorySimpleNumberExpression<>(repository, ClassMappingUtils.getColumnName(name, classMapping),
                this);
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
    public EnumExpression<C, L> propertyEnum(String repository, String name) {
        return new RepositorySimpleEnumExpression<>(repository, ClassMappingUtils.getColumnName(name, classMapping),
                this);
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
    public StringExpression<C, L> propertyString(int repositoryIndex, String name) {
        return new RepositorySimpleStringExpression<>(repositoryIndex,
                ClassMappingUtils.getColumnName(name, classMapping), this);
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
    public DateExpression<C, L> propertyDate(int repositoryIndex, String name) {
        return new RepositorySimpleDateExpression<>(repositoryIndex,
                ClassMappingUtils.getColumnName(name, classMapping), this);
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
    public <T, R, N extends Number> L ge(SerializableFunction<T, R> name, Number value) {
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
    public <T, R, N extends Number> L gt(SerializableFunction<T, R> name, Number value) {
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
    public <T, R, N extends Number> L le(SerializableFunction<T, R> name, Number value) {
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
    public <T, R, N extends Number> L lt(SerializableFunction<T, R> name, Number value) {
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

    protected <T, R> String getPropertyName(SerializableFunction<T, R> name) {
        return LambdaUtils.getLambdaPropertyName(name);
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

    protected ClassMapping<?> classMapping;

    private List<Expression> conditions = new ArrayList<>();

    protected Dialect dialect;

    protected L parent;

    private Expression previousCondition;

    private String queryAlias;

    protected AliasManager aliasManager;

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
}
