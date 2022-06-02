package cn.featherfly.hammer.sqldb.jdbc;

import java.sql.ResultSet;

/**
 * ObjectFactory.
 *
 * @author zhongj
 */
public interface MapperObjectFactory<T> {

    /**
     * Creates the.
     *
     * @param rs the rs
     * @return the t
     */
    T create(ResultSet rs);
}
