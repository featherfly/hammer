package cn.featherfly.hammer.sqldb.jdbc;

import java.sql.ResultSet;

/**
 * ObjectFactory.
 *
 * @author zhongj
 * @param <T> the generic type
 */
public interface MapperObjectFactory<T> {

    /**
     * Gets the mapped class.
     *
     * @return the mapped class
     */
    Class<T> getMappedClass();

    /**
     * Creates the.
     *
     * @param rs the rs
     * @return the t
     */
    T create(ResultSet rs);
}
