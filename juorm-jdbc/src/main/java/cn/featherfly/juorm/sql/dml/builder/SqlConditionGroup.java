
package cn.featherfly.juorm.sql.dml.builder;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import cn.featherfly.common.lang.LangUtils;
import cn.featherfly.common.lang.StringUtils;
import cn.featherfly.juorm.dml.builder.BuilderException;
import cn.featherfly.juorm.dml.builder.ConditionBuildUtils;
import cn.featherfly.juorm.dml.builder.ConditionBuilder;
import cn.featherfly.juorm.dml.builder.ConditionGroup;
import cn.featherfly.juorm.dml.builder.Expression;
import cn.featherfly.juorm.dml.builder.ExpressionBuilder;
import cn.featherfly.juorm.dml.builder.LogicBuilder;
import cn.featherfly.juorm.dml.builder.ParamedExpression;
import cn.featherfly.juorm.dml.builder.SortBuilder;
import cn.featherfly.juorm.operator.LogicOperator;
import cn.featherfly.juorm.operator.QueryOperator;

/**
 * <p>
 * sql condition group builder
 * sql条件逻辑组构造器
 * </p>
 *
 * @author zhongj
 */
public class SqlConditionGroup implements ConditionGroup, SqlConditionBuilder{

	
    /**
     * @param sort SortBuilder
     */
    public SqlConditionGroup(SortBuilder sort) {
        this(null, sort);
    }
    
    /**
     * @param queryAlias queryAlias
     * @param sort SortBuilder
     */
    public SqlConditionGroup(String queryAlias, SortBuilder sort) {
        this(null, sort, queryAlias);
    }
    
//    /**
//	 * @param parent 上级组
//	 * @param top 顶级组
//	 */
//	SqlConditionGroup(SqlConditionGroup parent, SqlConditionGroup top) {
//		this(parent, top, null);
//	}
	
	
	/**
     * @param parent 上级组
     * @param sort 排序器
     * @param queryAlias queryAlias
     */
    SqlConditionGroup(SqlConditionGroup parent, SortBuilder sort, String queryAlias) {
        this.sort = sort;
        this.parent = parent;
        this.queryAlias = queryAlias;
    }

	/**
     * {@inheritDoc}
     */
	@Override
	public ExpressionBuilder and() {
		addCondition(new SqlLogicExpression(LogicOperator.AND));
		return this;
	}
	/**
     * {@inheritDoc}
     */
	@Override
	public ExpressionBuilder or() {
		addCondition(new SqlLogicExpression(LogicOperator.OR));
		return this;
	}

//	/**
//     * {@inheritDoc}
//     */
//	@Override
//	public LogicBuilder add(String name, Object value,
//			QueryOperator queryOperator) {
//		addCondition(new SqlConditionExpression(name, queryAlias, value, queryOperator));
//		return this;
//	}

	/**
     * {@inheritDoc}
     */
	@Override
	public LogicBuilder lt(String name, Object value) {
		addCondition(new SqlConditionExpression(name, queryAlias, value, QueryOperator.LT));
		return this;
	}
	/**
     * {@inheritDoc}
     */
	@Override
	public LogicBuilder le(String name, Object value) {
		addCondition(new SqlConditionExpression(name, queryAlias, value, QueryOperator.LE));
		return this;
	}
	/**
     * {@inheritDoc}
     */
	@Override
	public LogicBuilder eq(String name, Object value) {
		addCondition(new SqlConditionExpression(name, queryAlias, value, QueryOperator.EQ));
		return this;
	}
	/**
     * {@inheritDoc}
     */
	@Override
	public LogicBuilder ne(String name, Object value) {
		addCondition(new SqlConditionExpression(name, queryAlias, value, QueryOperator.NE));
		return this;
	}
	/**
     * {@inheritDoc}
     */
	@Override
	public LogicBuilder ge(String name, Object value) {
		addCondition(new SqlConditionExpression(name, queryAlias, value, QueryOperator.GE));
		return this;
	}
	/**
     * {@inheritDoc}
     */
	@Override
	public LogicBuilder gt(String name, Object value) {
		addCondition(new SqlConditionExpression(name, queryAlias, value, QueryOperator.GT));
		return this;
	}
	/**
     * {@inheritDoc}
     */
	@Override
	public LogicBuilder sw(String name, Object value) {
		addCondition(new SqlConditionExpression(name, queryAlias, value, QueryOperator.SW));
		return this;
	}
	/**
     * {@inheritDoc}
     */
	@Override
	public LogicBuilder co(String name, Object value) {
		addCondition(new SqlConditionExpression(name, queryAlias, value, QueryOperator.CO));
		return this;
	}
	/**
     * {@inheritDoc}
     */
	@Override
	public LogicBuilder ew(String name, Object value) {
		addCondition(new SqlConditionExpression(name, queryAlias, value, QueryOperator.EW));
		return this;
	}
	/**
     * {@inheritDoc}
     */
	@Override
	public LogicBuilder in(String name, Object value) {
		addCondition(new SqlConditionExpression(name, queryAlias, value, QueryOperator.IN));
		return this;
	}
	/**
     * {@inheritDoc}
     */
	@Override
	public LogicBuilder nin(String name, Object value) {
		addCondition(new SqlConditionExpression(name, queryAlias, value, QueryOperator.NIN));
		return this;
	}
	/**
     * {@inheritDoc}
     */
	@Override
	public LogicBuilder isn(String name) {
		addCondition(new SqlConditionExpression(name, queryAlias, null, QueryOperator.ISN));
		return this;
	}
	/**
     * {@inheritDoc}
     */
	@Override
	public LogicBuilder inn(String name) {
		addCondition(new SqlConditionExpression(name, queryAlias, null, QueryOperator.INN));
		return this;
	}

	/**
     * {@inheritDoc}
     */
	@Override
	public ExpressionBuilder group() {
		SqlConditionGroup group = new SqlConditionGroup(this, sort, queryAlias);
		addCondition(group);
		return group;
	}

	/**
     * {@inheritDoc}
     */
	@Override
	public LogicBuilder parent() {
		return parent;
	}
	
	/**
     * {@inheritDoc}
     */
    @Override
    public SortBuilder sort() {
        return sort;
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

		List<String> availableConditions = new ArrayList<String>();
		List<Expression> availableExpressions = new ArrayList<Expression>();
		for (Expression expression : conditions) {
			String condition = expression.build();
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
	public Object getParamValue() {
		return getParamValues();
	}
	
	/**
     * {@inheritDoc}
     */
    @Override
    public List<Object> getParamValues() {
        List<Object> params = new ArrayList<Object>();
        for (Expression condition : conditions) {
            if (condition instanceof ParamedExpression) {
                Object param = ((ParamedExpression) condition).getParamValue();
                if (LangUtils.isNotEmpty(param)) {
                    if (param instanceof Collection) {
                        params.addAll((Collection<?>) param);
                    } else if (param.getClass().isArray()){
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

	// ********************************************************************
	//	private method
	// ********************************************************************

	private void addCondition(Expression condition) {
		if (previousCondition != null) {
			if (previousCondition.getClass().isInstance(condition)) {
				throw new BuilderException("语法错误，连续相同类型的表达式：" + condition.getClass().getName());
			}
		}
		previousCondition = condition;
		this.conditions.add(condition);
	}

	// ********************************************************************
	//	property
	// ********************************************************************

	private List<Expression> conditions = new ArrayList<Expression>();

	private SqlConditionGroup parent;
	
	private SortBuilder sort;

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
     * @return queryAlias
     */
    public String getQueryAlias() {
        return queryAlias;
    }

    /**
     * 设置queryAlias
     * @param queryAlias queryAlias
     */
    public void setQueryAlias(String queryAlias) {
        this.queryAlias = queryAlias;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ConditionBuilder where() {
        return this;
    }
}
