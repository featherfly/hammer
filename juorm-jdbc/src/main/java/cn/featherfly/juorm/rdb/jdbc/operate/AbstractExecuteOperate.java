
package cn.featherfly.juorm.rdb.jdbc.operate;

import java.sql.PreparedStatement;

import cn.featherfly.juorm.rdb.jdbc.Jdbc;
import cn.featherfly.juorm.rdb.jdbc.mapping.ClassMapping;

/**
 * <p>
 * 数据库操作的抽象类
 * </p>
 *
 * @param <T> 对象类型
 * @author zhongj
 * @since 1.0
 * @version 1.0
 */
public abstract class AbstractExecuteOperate<T> extends AbstractOperate<T> {

    /**
     * 使用给定数据源以及给定对象生成其相应的操作.
     *
     * @param jdbc         jdbc
     * @param classMapping classMapping
     */
    public AbstractExecuteOperate(Jdbc jdbc, ClassMapping<T> classMapping) {
        super(jdbc, classMapping);
    }

    /**
     * 使用给定数据源以及给定对象生成其相应的操作.
     *
     * @param jdbc         jdbc
     * @param classMapping classMapping
     * @param dataBase     具体库
     */
    public AbstractExecuteOperate(Jdbc jdbc, ClassMapping<T> classMapping, String dataBase) {
        super(jdbc, classMapping, dataBase);
    }

    /**
     * <p>
     * 执行操作. 操作的类型由具体子类构造的不同SQL来区分.
     * </p>
     *
     * @param entity 对象
     * @return 操作影响的数据行数
     */
    public int execute(final T entity) {
        return jdbc.execute(con -> {
            PreparedStatement prep = null;
            prep = con.prepareStatement(sql);
            setParameter(prep, entity);
            logger.debug("execute sql: {}", sql);
            int result = prep.executeUpdate();
            prep.close();
            return result;
        });
    }

    // ********************************************************************
    //	property
    // ********************************************************************

}
