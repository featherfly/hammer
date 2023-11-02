
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
 * jdbc update.
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
    default int update(String sql, Object... args) {
        return update(sql, (GeneratedKeyHolder<Serializable>) null, args);
    }

    /**
     * Update.
     *
     * @param sql  the sql
     * @param args the args
     * @return the int
     */
    default int update(String sql, Map<String, Object> args) {
        return update(sql, null, args);
    }

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
     * batch update. use jdbc batch execute.
     *
     * @param <T>       the generic type
     * @param sql       the sql
     * @param argsArray the batch args array
     * @return the int
     */
    default <T extends Serializable> int[] updateBatch(String sql, Object[]... argsArray) {
        return updateBatch(sql, (GeneratedKeysHolder<T>) null, argsArray);
    }

    /**
     * batch update. use jdbc batch execute.
     *
     * @param sql      the sql
     * @param argsList the batch args list
     * @return the int
     */
    default int[] updateBatch(String sql, List<Object[]> argsList) {
        return updateBatch(sql, null, argsList);
    }

    /**
     * batch update. use jdbc batch execute.
     *
     * @param <T>                the generic type
     * @param sql                the sql
     * @param generatedKeyHolder the generated key holder
     * @param argsList           the batch args list
     * @return the int
     */
    <T extends Serializable> int[] updateBatch(String sql, GeneratedKeysHolder<T> generatedKeyHolder,
            Object[]... argsList);

    /**
     * batch update. use jdbc batch execute.
     *
     * @param <T>                the generic type
     * @param sql                the sql
     * @param generatedKeyHolder the generated key holder
     * @param argsList           the batch args list
     * @return the int
     */
    default <T extends Serializable> int[] updateBatch(String sql, GeneratedKeysHolder<T> generatedKeyHolder,
            List<Object[]> argsList) {
        return updateBatch(sql, generatedKeyHolder, argsList.toArray(new Object[argsList.size()][]));
    }

    /**
     * batch update. use jdbc batch execute.
     *
     * @param sql       the sql
     * @param batchArgs the batch args array
     * @return the int
     */
    default int[] updateBatch(String sql, Map<String, Object>[] batchArgs) {
        return updateBatch(sql, null, batchArgs);
    }

    /**
     * batch update. use jdbc batch execute.
     *
     * @param <T>                the generic type
     * @param sql                the sql
     * @param generatedKeyHolder the generated key holder
     * @param batchArgs          the batch args array
     * @return the int
     */
    <T extends Serializable> int[] updateBatch(String sql, GeneratedKeysHolder<T> generatedKeyHolder,
            Map<String, Object>[] batchArgs);

    /**
     * batch update.
     *
     * @param sql       sql
     * @param batchSize the batch size
     * @param args      args
     * @return map list
     */
    default int updateBatch(String sql, int batchSize, Object... args) {
        return updateBatch(sql, batchSize, (GeneratedKeysHolder<Serializable>) null, args);
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
    <T extends Serializable> int updateBatch(String sql, int batchSize, GeneratedKeysHolder<T> generatedKeyHolder,
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
    <T extends Serializable> int updateBatch(String sql, int batchSize, GeneratedKeysHolder<T> generatedKeyHolder,
            Object... args);
}
