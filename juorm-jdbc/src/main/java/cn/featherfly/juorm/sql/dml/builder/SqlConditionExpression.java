
package cn.featherfly.juorm.sql.dml.builder;

import java.lang.reflect.Array;
import java.util.Collection;

import cn.featherfly.common.lang.LangUtils;
import cn.featherfly.common.structure.HashChainMap;
import cn.featherfly.juorm.dml.builder.BuilderException;
import cn.featherfly.juorm.dml.builder.ParamedExpression;
import cn.featherfly.juorm.operator.QueryOperator;

/**
 * <p>
 * sql condition expression
 * sql 条件表达式
 * </p>
 *
 * @author zhongj
 */
public class SqlConditionExpression implements ParamedExpression{
    
    public static final HashChainMap<QueryOperator, String> QUERY_OPERATOR_MAP = new HashChainMap<>();
    static {
        QUERY_OPERATOR_MAP.putChain(QueryOperator.LT, "<")
            .putChain(QueryOperator.LE, "<=")
            .putChain(QueryOperator.GT, ">")
            .putChain(QueryOperator.GE, ">=")
            .putChain(QueryOperator.EQ, "=")
            .putChain(QueryOperator.NE, "!=")
            .putChain(QueryOperator.SW, "like")
            .putChain(QueryOperator.CO, "like")
            .putChain(QueryOperator.EW, "like")
            .putChain(QueryOperator.ISN, "is null")
            .putChain(QueryOperator.INN, "is not null")
            .putChain(QueryOperator.IN, "in")
            .putChain(QueryOperator.NIN, "not in");
    }

	private String name;

	private Object value;

	private String queryAlias;

	private Object paramValue;

	private QueryOperator queryOperator;

	/**
	 * @param name 名称
	 * @param value 值
	 * @param queryOperator 查询运算符（查询类型）
	 */
	SqlConditionExpression(String name, Object value, QueryOperator queryOperator) {
		this(name, null, value , queryOperator);
	}
	/**
	 * @param name 名称
	 * @param queryAlias 查询别名
	 * @param value 值
	 * @param queryOperator 查询运算符（查询类型）
	 */
	SqlConditionExpression(String name, String queryAlias, Object value, QueryOperator queryOperator) {
		if (queryOperator == null) {
			throw new BuilderException("#query.operator.null");
		}
		this.name = name;
		this.value = value;
		this.queryAlias = queryAlias;
		this.queryOperator = queryOperator;
		if (LangUtils.isNotEmpty(value)) {
			switch (queryOperator) {
				case SW:
					paramValue = value + "%"; break;
				case CO:
					paramValue = "%" + value + "%"; break;
				case EW:
					paramValue = "%" + value; break;
				default:
					paramValue = value;
			}
		}
	}

	/**
	 * 返回name
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * 返回queryOperator
	 * @return queryOperator
	 */
	public QueryOperator getQueryOperator() {
		return queryOperator;
	}

	/**
	 * 返回alias
	 * @return alias
	 */
	public String getQueryAlias() {
		return queryAlias;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Object getParamValue() {
		return paramValue;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String build() {
		StringBuilder condition = new StringBuilder();
		if (LangUtils.isNotEmpty(queryAlias)) {
			 condition.append(queryAlias).append(".");
		}
		if (LangUtils.isEmpty(name)) {
			return "";
		} else if (QueryOperator.ISN == queryOperator || QueryOperator.INN == queryOperator) {
			condition.append(name)
					.append(" ")
					.append(toOperator(queryOperator));
		} else if (LangUtils.isNotEmpty(value)) {
			if (QueryOperator.IN == queryOperator || QueryOperator.NIN == queryOperator) {
				int length = 1;
				if (value instanceof Collection) {
					length = ((Collection<?>) value).size();
				} else if (value.getClass().isArray()){
					length = Array.getLength(value);
				}
				condition.append(name)
					.append(" ")
					.append(toOperator(queryOperator))
					.append(" (");
				for (int i = 0; i < length; i++) {
					if (i > 0) {
						condition.append(",");
					}
					condition.append("?");
				}
				condition.append(")");
			} else {
				condition.append(name)
					.append(" ")
					.append(toOperator(queryOperator))
					.append(" ?");;
			}
		} else {
			return "";
		}
		return condition.toString();
	}
	
	private String toOperator(QueryOperator queryOperator) {
	    return QUERY_OPERATOR_MAP.get(queryOperator);
	}
}
