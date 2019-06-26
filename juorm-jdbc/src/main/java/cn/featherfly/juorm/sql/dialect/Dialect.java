package cn.featherfly.juorm.sql.dialect;

import java.util.Map;

/**
 * <p>
 * 数据库方言的接口.
 * </p>
 * @author zhongj
 */
public interface Dialect {
    
    
    
	/**
	 * 命名参数查询的查询条件默认起始位置名称
	 */
	String START_PARAM_NAME = "dialect_paging_start";
	/**
	 * 命名参数查询的查询条件默认数量名称
	 */
	String LIMIT_PARAM_NAME = "dialect_paging_limit";
	/**
	 * 默认的查询返回条数
	 */
	int DEFAULT_LIMIT = 10;
	/**
	 * <p>
	 * 转换普通sql为带分页的sql
	 * </p>
	 * @param sql 带转换的sql
	 * @param start 起始数
	 * @param limit 数量
	 * @return 返回转换好的分页sql
	 */
	String getPaginationSql(String sql, int start, int limit);
	/**
	 * <p>
	 * 返回分页参数的数组
	 * </p>
	 * @param params 参数数组
	 * @param start 起始数
	 * @param limit 数量
	 * @return 分页参数的数组
	 */
	Object[] getPaginationSqlParameter(Object[] params,
			int start, int limit);
	/**
	 * <p>
	 * 返回分页参数的MAP
	 * </p>
	 * @param params 参数MAP
	 * @param start 起始数
	 * @param limit 数量
	 * @return 分页参数的MAP
	 */
	Map<String, Object> getPaginationSqlParameter(Map<String, Object> params,
			int start, int limit);
	/**
	 * <p>
	 * 转换普通命名sql为带分页的sql,此sql为带命名参数sql,
	 * 如select * from user where user_name = :username
	 * </p>
	 * @param sql 带转换的sql
	 * @param start 起始数
	 * @param limit 数量
	 * @return 返回转换好的分页sql
	 */
	String getParamNamedPaginationSql(String sql, int start, int limit);
	/**
	 * <p>
	 * 转换为SQL语句中使用的字符串
	 * </p>
	 * @param value 值
	 * @param sqlType sql类型
	 */
	String valueToSql(Object value, int sqlType);
	/**
	 * <p>
	 * 包装名称，避免关键字问题
	 * </p>
	 * @param name 名称（列明，表名等）
	 * @return 包装后的名称
	 */
	String wrapName(String name);
	/**
	 * <p>
	 * 返回设值外检检查SQL语句
	 * </p>
	 * @param check 是否检查外检
	 * @return 设值外检检查SQL语句
	 */
	String getFkCheck(boolean check);
}