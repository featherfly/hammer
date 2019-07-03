package cn.featherfly.juorm.mapping;

/**
 * <p>
 * 记录行映射接口
 * </p>
 *
 * @param <E> 要映射的具体类
 * @param <D> 需要包装的数据集
 * @author zhongj
 */
public interface RowMapper<E> {
    /**
     * <p>
     * 映射记录到指定的对象
     * </p>
     *
     * @param res    数据集
     * @param rowNum 行数
     * @return 记录映射的对象
     */
    E mapRow(ResultSet res, int rowNum);
}