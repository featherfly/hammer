package cn.featherfly.juorm.expression;

/**
 * <p>
 * 排序构建接口
 * </p>
 *
 * @author zhongj
 */
public interface SortExpression extends Expression {
    /**
     * <p>
     * 添加升序条件
     * </p>
     *
     * @param names 名称
     * @return this
     */
    SortExpression asc(String... names);

    /**
     * <p>
     * 添加降序条件
     * </p>
     *
     * @param names 名称
     * @return this
     */
    SortExpression desc(String... names);

}