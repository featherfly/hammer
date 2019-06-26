
package cn.featherfly.juorm.dml.builder;

/**
 * <p>
 * Expression Builder
 * 表达式建造者
 * </p>
 *
 * @author zhongj
 */
public interface ExpressionBuilder extends Builder{
	/**
	 * 小于
	 * @param name 参数名称
	 * @param value 参数值
	 * @return LogicBuilder
	 */
	LogicBuilder lt(String name, Object value) ;
	/**
	 * 小于等于
	 * @param name 参数名称
	 * @param value 参数值
	 * @return LogicBuilder
	 */
	LogicBuilder le(String name, Object value) ;
	/**
	 * 等于
	 * @param name 参数名称
	 * @param value 参数值
	 * @return LogicBuilder
	 */
	LogicBuilder eq(String name, Object value) ;
	/**
	 * 不等于
	 * @param name 参数名称
	 * @param value 参数值
	 * @return LogicBuilder
	 */
	LogicBuilder ne(String name, Object value) ;
	/**
	 * 大于等于
	 * @param name 参数名称
	 * @param value 参数值
	 * @return LogicBuilder
	 */
	LogicBuilder ge(String name, Object value) ;
	/**
	 * 大于
	 * @param name 参数名称
	 * @param value 参数值
	 * @return LogicBuilder
	 */
	LogicBuilder gt(String name, Object value) ;
	/**
	 * 以XX开始
	 * @param name 参数名称
	 * @param value 参数值
	 * @return LogicBuilder
	 */
	LogicBuilder sw(String name, Object value) ;
	/**
	 * 包含
	 * @param name 参数名称
	 * @param value 参数值
	 * @return LogicBuilder
	 */
	LogicBuilder co(String name, Object value) ;
	/**
	 * 以XX结尾
	 * @param name 参数名称
	 * @param value 参数值
	 * @return LogicBuilder
	 */
	LogicBuilder ew(String name, Object value) ;
	/**
	 * 包含指定，sql中的in
	 * @param name 参数名称
	 * @param value 参数值
	 * @return LogicBuilder
	 */
	LogicBuilder in(String name, Object value);
	/**
	 * 不包含指定，sql中的not in
	 * @param name 参数名称
	 * @param value 参数值
	 * @return LogicBuilder
	 */
	LogicBuilder nin(String name, Object value);
	/**
	 * 为null的
	 * @param name 参数名称
	 * @return LogicBuilder
	 */
	LogicBuilder isn(String name) ;
	/**
	 * 不为null的
	 * @param name 参数名称
	 * @return LogicBuilder
	 */
	LogicBuilder inn(String name) ;
	/**
	 * <p>
	 * 在当前内部开启一个新的条件逻辑组
	 * </p>
	 * @return 新条件逻辑组
	 */
	ExpressionBuilder group();
}
