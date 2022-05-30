package cn.featherfly.hammer.sqldb.jdbc.operate;

/**
 * execute operate.
 *
 * @author zhongj
 * @version 0.6.1
 * @since 0.6.1
 * @param <T> 对象类型
 */
public interface ExecuteOperate<T> {

    /**
     * 执行操作（insert, update, delete）.
     *
     * @param entity 对象
     * @return 操作影响的数据行数
     */
    int execute(final T entity);
}
