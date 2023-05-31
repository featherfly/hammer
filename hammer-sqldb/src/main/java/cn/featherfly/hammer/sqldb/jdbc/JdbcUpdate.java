
/*
 * All rights Reserved, Designed By zhongj
 * @Title: JdbcQuery.java
 * @Package cn.featherfly.hammer.sqldb.jdbc
 * @Description: JdbcUpdate
 * @author: zhongj
 * @date: 2023-07-10 16:15:10
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.jdbc;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * The Interface JdbcUpdate.
 *
 * @author zhongj
 */
public interface JdbcUpdate {
    /**
     * Update.
     *
     * @param sql  the sql
     * @param args the args
     * @return the int
     */
    int update(String sql, Object... args);

    //    /**
    //     * Update.
    //     *
    //     * @param sql  the sql
    //     * @param args the args
    //     * @return the int
    //     */
    //    int update(String sql, BeanPropertyValue<?>... args);

    /**
     * Update.
     *
     * @param sql  the sql
     * @param args the args
     * @return the int
     */
    int update(String sql, Map<String, Object> args);

    /**
     * Update.
     *
     * @param <T>                the generic type
     * @param sql                sql
     * @param generatedKeyHolder the key supplier
     * @param args               args
     * @return map list
     */
    <T extends Serializable> int update(String sql, GeneratedKeyHolder<T> generatedKeyHolder, Object... args);

    //    /**
    //     * Update.
    //     *
    //     * @param <T>                the generic type
    //     * @param sql                the sql
    //     * @param generatedKeyHolder the generated key holder
    //     * @param args               the args
    //     * @return the int
    //     */
    //    <T extends Serializable> int update(String sql, GeneratedKeyHolder<T> generatedKeyHolder,
    //            BeanPropertyValue<?>... args);

    /**
     * Update.
     *
     * @param <T>                the generic type
     * @param sql                sql
     * @param generatedKeyHolder the key supplier
     * @param args               args
     * @return map list
     */
    <T extends Serializable> int update(String sql, GeneratedKeyHolder<T> generatedKeyHolder, Map<String, Object> args);

    /**
     * batch update.
     *
     * @param <T>      the generic type
     * @param sql      the sql
     * @param argsList the batch args list
     * @return the int
     */
    default <T extends Serializable> int[] updateBatch(String sql, List<Object[]> argsList) {
        return updateBatch(sql, null, argsList);
    }

    /**
     * batch update.
     *
     * @param <T>                the generic type
     * @param sql                the sql
     * @param generatedKeyHolder the generated key holder
     * @param argsList           the batch args list
     * @return the int
     */
    <T extends Serializable> int[] updateBatch(String sql, GeneratedKeyHolder<T> generatedKeyHolder,
            List<Object[]> argsList);

    /**
     * batch update.
     *
     * @param <T>       the generic type
     * @param sql       the sql
     * @param batchArgs the batch args array
     * @return the int
     */
    default <T extends Serializable> int[] updateBatch(String sql, Map<String, Object>[] batchArgs) {
        return updateBatch(sql, null, batchArgs);
    }

    /**
     * batch update.
     *
     * @param <T>                the generic type
     * @param sql                the sql
     * @param generatedKeyHolder the generated key holder
     * @param batchArgs          the batch args array
     * @return the int
     */
    <T extends Serializable> int[] updateBatch(String sql, GeneratedKeyHolder<T> generatedKeyHolder,
            Map<String, Object>[] batchArgs);

    /**
     * batch update.
     *
     * @param <T>       the generic type
     * @param sql       sql
     * @param batchSize the batch size
     * @param args      args
     * @return map list
     */
    default <T extends Serializable> int updateBatch(String sql, int batchSize, Object... args) {
        return updateBatch(sql, batchSize, null, args);
    }

    /**
     * batch update.
     *
     * @param sql       the sql
     * @param batchSize the batch size
     * @param args      the args
     * @return the int
     */
    default int updateBatch(String sql, int batchSize, Map<String, Object> args) {
        return updateBatch(sql, batchSize, null, args);
    }

    /**
     * batch update.
     *
     * @param <T>                the generic type
     * @param sql                the sql
     * @param batchSize          the batch size
     * @param generatedKeyHolder the generated key holder
     * @param args               the args
     * @return the int
     */
    <T extends Serializable> int updateBatch(String sql, int batchSize, GeneratedKeyHolder<T> generatedKeyHolder,
            Map<String, Object> args);

    /**
     * Update.
     *
     * @param <T>                the generic type
     * @param sql                sql
     * @param batchSize          the batch size
     * @param generatedKeyHolder the key supplier
     * @param args               args
     * @return map list
     */
    <T extends Serializable> int updateBatch(String sql, int batchSize, GeneratedKeyHolder<T> generatedKeyHolder,
            Object... args);
}
