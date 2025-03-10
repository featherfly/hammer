
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
import java.sql.PreparedStatement;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

import cn.featherfly.common.db.NamedParamSql;
import cn.featherfly.common.repository.Execution;

/**
 * jdbc update.
 *
 * @author zhongj
 */
public interface JdbcUpdate {
    /**
     * Update.
     *
     * @param sql the sql
     * @param args the args
     * @return the int
     */
    default int update(String sql, Serializable... args) {
        return update(sql, (GeneratedKeyHolder<Serializable>) null, args);
    }

    /**
     * Update.
     *
     * @param sql the sql
     * @param args the args
     * @return the int
     */
    default int update(String sql, Map<String, Serializable> args) {
        return update(sql, null, args);
    }

    /**
     * Update.
     *
     * @param sql the sql
     * @param args the args
     * @return the int
     */
    default int update(NamedParamSql sql, Map<String, Serializable> args) {
        Execution execution = sql.getExecution(args);
        return update(execution.getExecution(), execution.getParams());
    }

    /**
     * Update.
     *
     * @param <T> the generic type
     * @param sql sql
     * @param generatedKeyHolder the key supplier
     * @param args args
     * @return map list
     */
    <T extends Serializable> int update(String sql, GeneratedKeyHolder<T> generatedKeyHolder, Serializable... args);

    /**
     * Update.
     *
     * @param <T> the generic type
     * @param sql sql
     * @param generatedKeyHolder the key supplier
     * @param args args
     * @return map list
     */
    <T extends Serializable> int update(String sql, GeneratedKeyHolder<T> generatedKeyHolder,
        Map<String, Serializable> args);

    /**
     * Update.
     *
     * @param <T> the generic type
     * @param sql sql
     * @param generatedKeyHolder the key supplier
     * @param args args
     * @return map list
     */
    default <T extends Serializable> int update(NamedParamSql sql, GeneratedKeyHolder<T> generatedKeyHolder,
        Map<String, Serializable> args) {
        Execution execution = sql.getExecution(args);
        return update(execution.getExecution(), generatedKeyHolder, execution.getParams());
    }

    /**
     * batch update. use jdbc batch execute.
     *
     * @param sql the sql
     * @param argsArray the batch args array
     * @return the int
     */
    default int[] updateBatch(String sql, Serializable[]... argsArray) {
        return updateBatch(sql, (GeneratedKeysHolder<Serializable>) null, argsArray);
    }

    /**
     * batch update. use jdbc batch execute.
     *
     * @param sql the sql
     * @param argsList the batch args list
     * @return the int
     */
    default int[] updateBatch(String sql, List<Serializable[]> argsList) {
        return updateBatch(sql, null, argsList);
    }

    /**
     * batch update. use jdbc batch execute.
     *
     * @param <T> the generic type
     * @param sql the sql
     * @param generatedKeyHolder the generated key holder
     * @param argsList the batch args list
     * @return the int
     */
    <T extends Serializable> int[] updateBatch(String sql, GeneratedKeysHolder<T> generatedKeyHolder,
        Serializable[]... argsList);

    /**
     * batch update. use jdbc batch execute.
     *
     * @param <T> the generic type
     * @param sql the sql
     * @param generatedKeyHolder the generated key holder
     * @param argsList the batch args list
     * @return the int
     */
    default <T extends Serializable> int[] updateBatch(String sql, GeneratedKeysHolder<T> generatedKeyHolder,
        List<Serializable[]> argsList) {
        return updateBatch(sql, generatedKeyHolder, argsList.toArray(new Serializable[argsList.size()][]));
    }

    /**
     * batch update. use jdbc batch execute.
     *
     * @param sql the sql
     * @param argsIter the args iter
     * @return the int
     */
    default int[] updateBatch(String sql, Iterable<Serializable[]> argsIter) {
        return updateBatch(sql, (GeneratedKeysHolder<Serializable>) null, argsIter);
    }

    /**
     * batch update. use jdbc batch execute.
     *
     * @param <T> the generic type
     * @param sql the sql
     * @param generatedKeyHolder the generated key holder
     * @param argsIter the args iter
     * @return the int
     */
    <T extends Serializable> int[] updateBatch(String sql, GeneratedKeysHolder<T> generatedKeyHolder,
        Iterable<Serializable[]> argsIter);

    /**
     * batch update. use jdbc batch execute.
     *
     * @param sql the sql
     * @param setArgs the set args
     * @return the int
     */
    default int[] updateBatch(String sql, BiConsumer<PreparedStatement, Consumer<Serializable[]>> setArgs) {
        return updateBatch(sql, (GeneratedKeysHolder<Serializable>) null, setArgs);
    }

    /**
     * batch update. use jdbc batch execute.
     *
     * @param <T> the generic type
     * @param sql the sql
     * @param generatedKeyHolder the generated key holder
     * @param setArgs the set args
     * @return the int
     */
    <T extends Serializable> int[] updateBatch(String sql, GeneratedKeysHolder<T> generatedKeyHolder,
        BiConsumer<PreparedStatement, Consumer<Serializable[]>> setArgs);

    /**
     * batch update. use jdbc batch execute.
     *
     * @param sql the sql
     * @param batchArgs the batch args array
     * @return the int
     */
    default int[] updateBatch(String sql, Map<String, Serializable>[] batchArgs) {
        return updateBatch(sql, null, batchArgs);
    }

    /**
     * batch update. use jdbc batch execute.
     *
     * @param <T> the generic type
     * @param sql the sql
     * @param generatedKeyHolder the generated key holder
     * @param batchArgs the batch args array
     * @return the int
     */
    <T extends Serializable> int[] updateBatch(String sql, GeneratedKeysHolder<T> generatedKeyHolder,
        Map<String, Serializable>[] batchArgs);

    /**
     * batch update.
     *
     * @param sql sql
     * @param batchSize the batch size
     * @param args args
     * @return map list
     */
    default int updateBatch(String sql, int batchSize, Serializable... args) {
        return updateBatch(sql, batchSize, (GeneratedKeysHolder<Serializable>) null, args);
    }

    /**
     * batch update.
     *
     * @param sql the sql
     * @param batchSize the batch size
     * @param args the args
     * @return the int
     */
    default int updateBatch(String sql, int batchSize, Map<String, Serializable> args) {
        return updateBatch(sql, batchSize, null, args);
    }

    /**
     * batch update.
     *
     * @param <T> the generic type
     * @param sql the sql
     * @param batchSize the batch size
     * @param generatedKeyHolder the generated key holder
     * @param args the args
     * @return the int
     */
    <T extends Serializable> int updateBatch(String sql, int batchSize, GeneratedKeysHolder<T> generatedKeyHolder,
        Map<String, Serializable> args);

    /**
     * Update.
     *
     * @param <T> the generic type
     * @param sql sql
     * @param batchSize the batch size
     * @param generatedKeyHolder the key supplier
     * @param args args
     * @return map list
     */
    <T extends Serializable> int updateBatch(String sql, int batchSize, GeneratedKeysHolder<T> generatedKeyHolder,
        Serializable... args);
}
