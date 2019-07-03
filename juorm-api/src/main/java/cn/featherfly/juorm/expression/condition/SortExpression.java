package cn.featherfly.juorm.expression.condition;

/**
 * <p>
 * 排序构建接口
 * </p>
 *
 * @author zhongj
 */
public interface SortExpression<S extends SortExpression<S>> extends Expression {
    /**
     * <p>
     * 添加升序条件
     * </p>
     *
     * @param names 名称
     * @return this
     */
    S asc(String... names);

    /**
     * <p>
     * 添加降序条件
     * </p>
     *
     * @param names 名称
     * @return this
     */
    S desc(String... names);

}