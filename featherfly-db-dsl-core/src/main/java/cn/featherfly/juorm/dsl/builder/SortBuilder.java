package cn.featherfly.db.dsl.builder;

/**
 * <p>
 * 排序构建接口
 * </p>
 *
 * @author zhongj
 */
public interface SortBuilder extends Builder {
    /**
     * <p>
     * 添加升序条件
     * </p>
     * 
     * @param names
     *            名称
     * @return this
     */
    SortBuilder asc(String... names);

    /**
     * <p>
     * 添加降序条件
     * </p>
     * 
     * @param names
     *            名称
     * @return this
     */
    SortBuilder desc(String... names);

    /**
     * <p>
     * 添加升序条件到最前面
     * </p>
     * 
     * @param names
     *            名称
     * @return this
     */
    SortBuilder ascFirst(String... names);

    /**
     * <p>
     * 添加降序条件到最前面
     * </p>
     * 
     * @param names
     *            名称
     * @return this
     */
    SortBuilder descFirst(String... names);

    /**
     * <p>
     * 删除所有排序条件
     * </p>
     * 
     * @return this
     */
    SortBuilder clear();

}