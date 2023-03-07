/*
 * All rights Reserved, Designed By zhongj
 * @Title: AbstractJdbc.java
 * @Package cn.featherfly.hammer.sqldb.jdbc
 * @Description: AbstractJdbc
 * @author: zhongj
 * @date: 2021年12月3日 下午9:07:01
 * @Copyright: 2021 www.featherfly.cn Inc. All rights reserved.
 */

package cn.featherfly.hammer.sqldb.jdbc;

import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLType;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.speedment.common.tuple.Tuple2;
import com.speedment.common.tuple.Tuple3;
import com.speedment.common.tuple.Tuple4;
import com.speedment.common.tuple.Tuple5;

import cn.featherfly.common.bean.BeanProperty;
import cn.featherfly.common.bean.BeanPropertyValue;
import cn.featherfly.common.db.FieldValueOperator;
import cn.featherfly.common.db.JdbcException;
import cn.featherfly.common.db.JdbcUtils;
import cn.featherfly.common.db.SqlUtils;
import cn.featherfly.common.db.dialect.Dialect;
import cn.featherfly.common.db.dialect.SQLiteDialect;
import cn.featherfly.common.db.mapping.SqlResultSet;
import cn.featherfly.common.db.mapping.SqlTypeMappingManager;
import cn.featherfly.common.lang.ArrayUtils;
import cn.featherfly.common.lang.AssertIllegalArgument;
import cn.featherfly.common.lang.ClassUtils;
import cn.featherfly.common.lang.Lang;
import cn.featherfly.common.lang.Strings;
import cn.featherfly.common.lang.reflect.Type;
import cn.featherfly.common.repository.Execution;
import cn.featherfly.common.repository.mapping.RowMapper;

/**
 * AbstractJdbc.
 *
 * @author zhongj
 */
public abstract class AbstractJdbc implements Jdbc {

    /** The logger. */
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    /** The data source. */
    protected DataSource dataSource;

    /** The dialect. */
    protected Dialect dialect;

    /** The manager. */
    protected SqlTypeMappingManager manager;

    /** The interceptors. */
    protected final List<JdbcExecutionInterceptor> interceptors = new ArrayList<>(0);

    /**
     * Instantiates a new abstract jdbc.
     *
     * @param dataSource the data source
     * @param dialect    the dialect
     * @param manager    the manager
     */
    protected AbstractJdbc(DataSource dataSource, Dialect dialect, SqlTypeMappingManager manager) {
        super();
        setDataSource(dataSource);
        this.dialect = dialect;
        this.manager = manager;
    }

    /**
     * set dataSource.
     *
     * @param dataSource dataSource
     */
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DataSource getDataSource() {
        return dataSource;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SqlTypeMappingManager getSqlTypeMappingManager() {
        return manager;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Dialect getDialect() {
        return dialect;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T extends Serializable> int insert(String tableName, String[] columnNames, GeneratedKeyHolder<T> keyHolder,
            Object... args) {
        return update(getDialect().buildInsertSql(tableName, columnNames), keyHolder, args);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int insertBatch(String tableName, String[] columnNames, int batchSize, Object... args) {
        if (args.length % columnNames.length != 0) {
            throw new JdbcException("batch size is not explicit (args.length % columnNames.length != 0)");
        }
        int actualBatchSize = args.length / columnNames.length;
        if (batchSize >= actualBatchSize) { // 表示批量执行数的最大限制小于等于参数计算出的实际需要的批量执行数
            return updateBatch(getDialect().buildInsertBatchSql(tableName, columnNames, actualBatchSize),
                    actualBatchSize, args);
        } else {
            int index = batchSize * columnNames.length;
            return updateBatch(getDialect().buildInsertBatchSql(tableName, columnNames, batchSize), batchSize,
                    Arrays.copyOfRange(args, 0, index))
                    + insertBatch(tableName, columnNames, actualBatchSize - batchSize,
                            Arrays.copyOfRange(args, index, args.length));
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int upsert(String tableName, String[] columnNames, String[] uniqueColumns, Object... args) {
        return update(getDialect().buildUpsertSql(tableName, columnNames, uniqueColumns), args);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T extends Serializable> int update(String sql, GeneratedKeyHolder<T> keyHolder, Object... args) {
        return updateBatch(sql, 1, keyHolder, args);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T extends Serializable> int updateBatch(String sql, int batchSize, GeneratedKeyHolder<T> keySupplier,
            Object... args) {
        if (Lang.isNotEmpty(sql)) {
            sql = sql.trim();
            return executeUpdate(sql, batchSize, keySupplier, args);
        }
        return 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T extends Serializable> int updateBatch(String sql, int batchSize, GeneratedKeyHolder<T> keySupplier,
            Map<String, Object> args) {
        if (Lang.isNotEmpty(sql)) {
            sql = sql.trim();
            logger.debug("sql -> {}, args -> {}", sql, args);
            Execution execution = SqlUtils.convertNamedParamSql(sql, args);
            return executeUpdate(execution.getExecution(), batchSize, keySupplier, execution.getParams());
        }
        return 0;
    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <T extends Serializable> int update(String sql, GeneratedKeyHolder<T> keySupplier,
    //            BeanPropertyValue<?>... args) {
    //        if (Lang.isNotEmpty(sql)) {
    //            sql = sql.trim();
    //            return executeUpdate(sql, 1, keySupplier, args);
    //        }
    //        return 0;
    //    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T extends Serializable> int update(String sql, GeneratedKeyHolder<T> keySupplier,
            Map<String, Object> args) {
        logger.debug("sql -> {}, args -> {}", sql, args);
        Execution execution = SqlUtils.convertNamedParamSql(sql, args);
        return update(execution.getExecution(), keySupplier, execution.getParams());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int update(String sql, Map<String, Object> args) {
        logger.debug("sql -> {}, args -> {}", sql, args);
        Execution execution = SqlUtils.convertNamedParamSql(sql, args);
        return update(execution.getExecution(), execution.getParams());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int update(String sql, Object... args) {
        if (Lang.isNotEmpty(sql)) {
            sql = sql.trim();
            return executeUpdate(sql, 1, args);
        }
        return 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T extends Serializable> int[] updateBatch(String sql, GeneratedKeyHolder<T> generatedKeyHolder,
            List<Object[]> argsList) {
        if (Lang.isNotEmpty(sql)) {
            sql = sql.trim();
            return executeUpdateBatch((prep, args) -> setParams(prep, args), sql, generatedKeyHolder, argsList);
        }
        return ArrayUtils.EMPTY_INT_ARRAY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T extends Serializable> int[] updateBatch(String sql, GeneratedKeyHolder<T> generatedKeyHolder,
            Map<String, Object>[] batchArgs) {
        if (Lang.isNotEmpty(sql) && Lang.isNotEmpty(batchArgs)) {
            logger.debug("sql -> {}", sql);
            sql = sql.trim();
            List<Object[]> argsList = new ArrayList<>(batchArgs.length);
            Execution execution = null;
            for (Map<String, Object> arg : batchArgs) {
                execution = SqlUtils.convertNamedParamSql(sql, arg);
                argsList.add(execution.getParams());
            }
            return updateBatch(execution.getExecution(), generatedKeyHolder, argsList);
        }
        return ArrayUtils.EMPTY_INT_ARRAY;
    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public int update(String sql, BeanPropertyValue<?>... args) {
    //        if (Lang.isNotEmpty(sql)) {
    //            sql = sql.trim();
    //            return executeUpdate(sql, 1, args);
    //        }
    //        return 0;
    //    }

    private int executeUpdate(String sql, int batchSize, Object... args) {
        return executeUpdate(sql, batchSize, null, args);
    }

    private <T extends Serializable> int executeUpdate(String sql, int batchSize,
            GeneratedKeyHolder<T> generatedKeyHolder, Object... args) {
        logger.debug("sql -> {}, args -> {}", sql, args);
        return executeUpdate(prep -> setParams(prep, args), sql, batchSize, generatedKeyHolder, args);
    }

    //    private int executeUpdate(String sql, int batchSize, BeanPropertyValue<?>... args) {
    //        return executeUpdate(sql, batchSize, null, args);
    //    }
    //
    //    private <T extends Serializable> int executeUpdate(String sql, int batchSize,
    //            GeneratedKeyHolder<T> generatedKeyHolder, BeanPropertyValue<?>... argsBp) {
    //        logger.debug("sql -> {}, args -> {}", sql, argsBp);
    //        return executeUpdate(prep -> setParams(prep, argsBp), sql, batchSize, generatedKeyHolder,
    //                Arrays.stream(argsBp).map(arg -> arg.getValue()).toArray());
    //    }

    /**
     * Gets the generete key.
     *
     * @param <T>  the generic type
     * @param type the type
     * @param res  the res
     * @return the generete key
     */
    private <T extends Serializable> T getGenereteKey(Type<T> type, ResultSet res) {
        T value;
        if (type instanceof BeanProperty) {
            value = manager.get(res, 1, (BeanProperty<T>) type);
        } else {
            value = manager.get(res, 1, type.getType());
        }
        logger.debug("auto generated key: {}", value);
        return value;
    }

    private <T extends Serializable> int[] executeUpdateBatch(BiConsumer<PreparedStatement, Object[]> setParams,
            String sql, GeneratedKeyHolder<T> generatedKeyHolder, List<Object[]> argsList) {
        StringBuilder message = new StringBuilder();
        if (logger.isDebugEnabled()) {
            message.append("execute batch -> ").append(sql).append("\n").append("  batch size -> ")
                    .append(argsList.size()).append("\n");
        }
        DataSource ds = getDataSource();
        Connection connection = getConnection(ds);
        try (PreparedStatement prep = generatedKeyHolder == null ? connection.prepareStatement(sql)
                : connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            List<JdbcExecution> jdbcExecutions = new ArrayList<>(argsList.size());
            for (Object[] args : argsList) {
                JdbcExecution execution = preHandle(sql, args);
                jdbcExecutions.add(execution);
                if (logger.isDebugEnabled()) {
                    message.append("    args -> ").append(Arrays.toString(execution.getParams())).append("\n");
                }
                setParams.accept(prep, args);
                prep.addBatch();
            }
            if (logger.isDebugEnabled()) {
                logger.debug(message.toString());
            }
            int[] results = prep.executeBatch();
            // 不是查询操作，没有查询结果
            for (JdbcExecution execution : jdbcExecutions) {
                postHandle(execution, sql, execution.getParams());
            }
            if (generatedKeyHolder != null) {
                try (ResultSet res = prep.getGeneratedKeys()) {
                    int row = 0;
                    if (dialect instanceof SQLiteDialect) { // res.isLast() not supported by sqlite
                        while (res.next()) {
                            T value = getGenereteKey(generatedKeyHolder.getType(), res);
                            generatedKeyHolder.acceptKey(value, row++);
                        }
                    } else {
                        if (res.next()) {
                            if (res.isLast()) {
                                T value = getGenereteKey(generatedKeyHolder.getType(), res);
                                generatedKeyHolder.acceptKey(value, row);
                            } else {
                                List<T> keys = new ArrayList<>();
                                keys.add(getGenereteKey(generatedKeyHolder.getType(), res));
                                while (res.next()) {
                                    keys.add(getGenereteKey(generatedKeyHolder.getType(), res));
                                }
                                generatedKeyHolder.acceptKey(keys);
                            }
                        }
                    }
                }
            }
            return results;
        } catch (SQLException e) {
            releaseConnection(connection, ds);
            StringBuilder strArgs = new StringBuilder();
            int index = 0;
            for (Object[] args : argsList) {
                strArgs.append("\n    batch[").append(index++).append("]: ").append(Arrays.toString(args));
            }
            throw new JdbcException(
                    Strings.format("executeUpdateBatch: \n  sql: {0} \n  args: {1}", sql, strArgs.toString()), e);
        } finally {
            releaseConnection(connection, getDataSource());
        }
    }

    private <T extends Serializable> int executeUpdate(Consumer<PreparedStatement> setParams, String sql, int batchSize,
            GeneratedKeyHolder<T> generatedKeyHolder, Object... args) {
        JdbcExecution execution = preHandle(sql, args);
        sql = execution.getExecution();
        args = execution.getParams();
        logger.debug("execute sql -> {}, args -> {}", sql, args);
        DataSource ds = getDataSource();
        Connection connection = getConnection(ds);
        try (PreparedStatement prep = generatedKeyHolder == null ? connection.prepareStatement(sql)
                : connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            setParams.accept(prep);
            int result = prep.executeUpdate();
            // 不是查询操作，没有查询结果
            postHandle(execution, sql, args);
            if (generatedKeyHolder != null && (batchSize == 1 && result == 1 || batchSize > 1)) {
                try (ResultSet res = prep.getGeneratedKeys()) {
                    int row = 0;
                    if (dialect instanceof SQLiteDialect) { // res.isLast() not supported by sqlite
                        while (res.next()) {
                            T value = getGenereteKey(generatedKeyHolder.getType(), res);
                            generatedKeyHolder.acceptKey(value, row++);
                        }
                    } else {
                        if (res.next()) {
                            if (res.isLast()) {
                                T value = getGenereteKey(generatedKeyHolder.getType(), res);
                                generatedKeyHolder.acceptKey(value, row);
                            } else {
                                List<T> keys = new ArrayList<>();
                                keys.add(getGenereteKey(generatedKeyHolder.getType(), res));
                                while (res.next()) {
                                    keys.add(getGenereteKey(generatedKeyHolder.getType(), res));
                                }
                                generatedKeyHolder.acceptKey(keys);
                            }
                        }
                    }
                }
            }
            return result;
        } catch (SQLException e) {
            releaseConnection(connection, ds);
            throw new JdbcException(Strings.format("executeUpdate: \nsql: {0} \nargs: {1}", sql, Arrays.toString(args)),
                    e);
        } finally {
            releaseConnection(connection, getDataSource());
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Map<String, Object>> query(String sql, Map<String, Object> args) {
        logger.debug("sql -> {}, args -> {}", sql, args);
        Execution execution = SqlUtils.convertNamedParamSql(sql, args);
        return query(execution.getExecution(), execution.getParams());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Map<String, Object>> query(String sql, Object... args) {
        if (Lang.isNotEmpty(sql)) {
            sql = sql.trim();
            JdbcExecution execution = preHandle(sql, args);
            sql = execution.getExecution();
            args = execution.getParams();
            logger.debug("execute sql -> {}, args -> {}", sql, args);
            DataSource ds = getDataSource();
            Connection con = getConnection(ds);
            try (PreparedStatement prep = con.prepareStatement(sql)) {
                setParams(prep, args);
                try (ResultSet rs = prep.executeQuery()) {
                    return postHandle(execution.setOriginalResult(JdbcUtils.getResultSetMaps(rs, manager)), sql, args);
                }
            } catch (SQLException e) {
                releaseConnection(con, ds);
                con = null;
                throw new JdbcException(Strings.format("query: \nsql: {0} \nargs: {1}", sql, Arrays.toString(args)), e);
            } finally {
                releaseConnection(con, getDataSource());
            }
        }
        return new ArrayList<>();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> List<T> query(String sql, RowMapper<T> rowMapper, Map<String, Object> args) {
        logger.debug("sql -> {}, args -> {}", sql, args);
        Execution execution = SqlUtils.convertNamedParamSql(sql, args);
        return query(execution.getExecution(), rowMapper, execution.getParams());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> List<T> query(String sql, Class<T> elementType, Map<String, Object> args) {
        logger.debug("sql -> {}, args -> {}, elementType -> {}", sql, args, elementType);
        Execution execution = SqlUtils.convertNamedParamSql(sql, args);
        return query(execution.getExecution(), elementType, execution.getParams());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1, T2> List<Tuple2<T1, T2>> query(String sql, Class<T1> elementType1, Class<T2> elementType2,
            Tuple2<String, String> prefixes, Map<String, Object> args) {
        logger.debug("sql -> {}, args -> {}, elementType1 -> {}, elementType2 -> {}", sql, args, elementType1,
                elementType2);
        Execution execution = SqlUtils.convertNamedParamSql(sql, args);
        return query(execution.getExecution(), elementType1, elementType2, prefixes, execution.getParams());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1, T2, T3> List<Tuple3<T1, T2, T3>> query(String sql, Class<T1> elementType1, Class<T2> elementType2,
            Class<T3> elementType3, Tuple3<String, String, String> prefixes, Map<String, Object> args) {
        logger.debug("sql -> {}, args -> {}, elementType1 -> {}, elementType2 -> {}, elementType3 -> {}", sql, args,
                elementType1, elementType2, elementType3);
        Execution execution = SqlUtils.convertNamedParamSql(sql, args);
        return query(execution.getExecution(), elementType1, elementType2, elementType3, prefixes,
                execution.getParams());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1, T2, T3, T4> List<Tuple4<T1, T2, T3, T4>> query(String sql, Class<T1> elementType1,
            Class<T2> elementType2, Class<T3> elementType3, Class<T4> elementType4,
            Tuple4<String, String, String, String> prefixes, Map<String, Object> args) {
        logger.debug(
                "sql -> {}, args -> {}, elementType1 -> {}, elementType2 -> {}, elementType3 -> {}, elementType4 -> {}",
                sql, args, elementType1, elementType2, elementType3, elementType4);
        Execution execution = SqlUtils.convertNamedParamSql(sql, args);
        return query(execution.getExecution(), elementType1, elementType2, elementType3, elementType4, prefixes,
                execution.getParams());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1, T2, T3, T4, T5> List<Tuple5<T1, T2, T3, T4, T5>> query(String sql, Class<T1> elementType1,
            Class<T2> elementType2, Class<T3> elementType3, Class<T4> elementType4, Class<T5> elementType5,
            Tuple5<String, String, String, String, String> prefixes, Map<String, Object> args) {
        logger.debug(
                "sql -> {}, args -> {}, elementType1 -> {}, elementType2 -> {}, elementType3 -> {}, elementType4 -> {}, elementType5 -> {}",
                sql, args, elementType1, elementType2, elementType3, elementType4, elementType5);
        Execution execution = SqlUtils.convertNamedParamSql(sql, args);
        return query(execution.getExecution(), elementType1, elementType2, elementType3, elementType4, elementType5,
                prefixes, execution.getParams());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> List<T> query(String sql, Class<T> elementType, Object... args) {
        SQLType sqlType = manager.getSqlType(elementType);
        RowMapper<T> rowMapper = null;
        if (sqlType == null) {
            rowMapper = new NestedBeanPropertyRowMapper<>(elementType, manager);
        } else {
            rowMapper = new SingleColumnRowMapper<>(elementType, manager);
        }
        return query(sql, rowMapper, args);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1, T2> List<Tuple2<T1, T2>> query(String sql, Class<T1> elementType1, Class<T2> elementType2,
            Tuple2<String, String> prefixes, Object... args) {
        //        SQLType sqlType = manager.getSqlType(elementType);
        //        RowMapper<T> rowMapper = null;
        //        if (sqlType == null) {
        //            rowMapper = new NestedBeanPropertyRowMapper<>(elementType, manager);
        //        } else {
        //            rowMapper = new SingleColumnRowMapper<>(elementType, manager);
        //        }
        //        return query(sql, rowMapper, args);
        return query(sql, new TupleNestedBeanPropertyRowMapper<>(ArrayUtils.toList(elementType1, elementType2),
                prefixes, manager), args);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1, T2, T3> List<Tuple3<T1, T2, T3>> query(String sql, Class<T1> elementType1, Class<T2> elementType2,
            Class<T3> elementType3, Tuple3<String, String, String> prefixes, Object... args) {
        return query(sql, new TupleNestedBeanPropertyRowMapper<>(
                ArrayUtils.toList(elementType1, elementType2, elementType3), prefixes, manager), args);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1, T2, T3, T4> List<Tuple4<T1, T2, T3, T4>> query(String sql, Class<T1> elementType1,
            Class<T2> elementType2, Class<T3> elementType3, Class<T4> elementType4,
            Tuple4<String, String, String, String> prefixes, Object... args) {
        return query(sql,
                new TupleNestedBeanPropertyRowMapper<>(
                        ArrayUtils.toList(elementType1, elementType2, elementType3, elementType4), prefixes, manager),
                args);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1, T2, T3, T4, T5> List<Tuple5<T1, T2, T3, T4, T5>> query(String sql, Class<T1> elementType1,
            Class<T2> elementType2, Class<T3> elementType3, Class<T4> elementType4, Class<T5> elementType5,
            Tuple5<String, String, String, String, String> prefixes, Object... args) {
        return query(sql,
                new TupleNestedBeanPropertyRowMapper<>(
                        ArrayUtils.toList(elementType1, elementType2, elementType3, elementType4, elementType5),
                        prefixes, manager),
                args);
    }

    //    @Override
    //    public <T> List<T> query(String sql, Class<T> elementType, BeanPropertyValue<?>... args) {
    //        SQLType sqlType = manager.getSqlType(elementType);
    //        RowMapper<T> rowMapper = null;
    //        if (sqlType == null) {
    //            rowMapper = new NestedBeanPropertyRowMapper<>(elementType, manager);
    //        } else {
    //            rowMapper = new SingleColumnRowMapper<>(elementType, manager);
    //        }
    //        return query(sql, rowMapper, args);
    //    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> List<T> query(String sql, RowMapper<T> rowMapper, Object... args) {
        List<T> list = new ArrayList<>();
        if (Lang.isNotEmpty(sql)) {
            sql = sql.trim();
            JdbcExecution execution = preHandle(sql, args);
            sql = execution.getExecution();
            args = execution.getParams();
            logger.debug("execute sql -> {}, args -> {}", sql, args);
            DataSource ds = getDataSource();
            Connection con = getConnection(ds);
            try (PreparedStatement prep = con.prepareStatement(sql)) {
                setParams(prep, args);
                try (ResultSet rs = prep.executeQuery()) {
                    int i = 0;
                    while (rs.next()) {
                        list.add(rowMapper.mapRow(new SqlResultSet(rs), i++));
                    }
                    return postHandle(execution.setOriginalResult(list), sql, args);
                }
            } catch (SQLException e) {
                releaseConnection(con, ds);
                con = null;
                throw new JdbcException(Strings.format("query: \nsql: {0} \nargs: {1}", sql, Arrays.toString(args)), e);
            } finally {
                releaseConnection(con, getDataSource());
            }
        }
        return list;
    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <T> List<T> query(String sql, RowMapper<T> rowMapper, BeanPropertyValue<?>... args) {
    //        return query(prep -> setParams(prep, args), sql, rowMapper,
    //                Arrays.stream(args).map(arg -> arg.getValue()).toArray());
    //    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Map<String, Object> querySingle(String sql, Map<String, Object> args) {
        return singleResult(query(sql, args));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Map<String, Object> querySingle(String sql, Object... args) {
        return singleResult(query(sql, args));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> T querySingle(String sql, RowMapper<T> rowMapper, Object... args) {
        return singleResult(query(sql, rowMapper, args));
    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <T> T querySingle(String sql, RowMapper<T> rowMapper, BeanPropertyValue<?>... args) {
    //        return singleResult(query(sql, rowMapper, args));
    //    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> T querySingle(String sql, RowMapper<T> rowMapper, Map<String, Object> args) {
        return singleResult(query(sql, rowMapper, args));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> T querySingle(String sql, Class<T> elementType, Map<String, Object> args) {
        return singleResult(query(sql, elementType, args));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1, T2> Tuple2<T1, T2> querySingle(String sql, Class<T1> elementType1, Class<T2> elementType2,
            Tuple2<String, String> prefixes, Map<String, Object> args) {
        return singleResult(query(sql, elementType1, elementType2, prefixes, args));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1, T2, T3> Tuple3<T1, T2, T3> querySingle(String sql, Class<T1> elementType1, Class<T2> elementType2,
            Class<T3> elementType3, Tuple3<String, String, String> prefixes, Map<String, Object> args) {
        return singleResult(query(sql, elementType1, elementType2, elementType3, prefixes, args));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1, T2, T3, T4> Tuple4<T1, T2, T3, T4> querySingle(String sql, Class<T1> elementType1,
            Class<T2> elementType2, Class<T3> elementType3, Class<T4> elementType4,
            Tuple4<String, String, String, String> prefixes, Map<String, Object> args) {
        return singleResult(query(sql, elementType1, elementType2, elementType3, elementType4, prefixes, args));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1, T2, T3, T4, T5> Tuple5<T1, T2, T3, T4, T5> querySingle(String sql, Class<T1> elementType1,
            Class<T2> elementType2, Class<T3> elementType3, Class<T4> elementType4, Class<T5> elementType5,
            Tuple5<String, String, String, String, String> prefixes, Map<String, Object> args) {
        return singleResult(
                query(sql, elementType1, elementType2, elementType3, elementType4, elementType5, prefixes, args));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> T querySingle(String sql, Class<T> elementType, Object... args) {
        return singleResult(query(sql, elementType, args));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1, T2> Tuple2<T1, T2> querySingle(String sql, Class<T1> elementType1, Class<T2> elementType2,
            Tuple2<String, String> prefixes, Object... args) {
        return singleResult(query(sql, elementType1, elementType2, prefixes, args));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1, T2, T3> Tuple3<T1, T2, T3> querySingle(String sql, Class<T1> elementType1, Class<T2> elementType2,
            Class<T3> elementType3, Tuple3<String, String, String> prefixes, Object... args) {
        return singleResult(query(sql, elementType1, elementType2, elementType3, prefixes, args));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1, T2, T3, T4> Tuple4<T1, T2, T3, T4> querySingle(String sql, Class<T1> elementType1,
            Class<T2> elementType2, Class<T3> elementType3, Class<T4> elementType4,
            Tuple4<String, String, String, String> prefixes, Object... args) {
        return singleResult(query(sql, elementType1, elementType2, elementType3, elementType4, prefixes, args));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1, T2, T3, T4, T5> Tuple5<T1, T2, T3, T4, T5> querySingle(String sql, Class<T1> elementType1,
            Class<T2> elementType2, Class<T3> elementType3, Class<T4> elementType4, Class<T5> elementType5,
            Tuple5<String, String, String, String, String> prefixes, Object... args) {
        return singleResult(
                query(sql, elementType1, elementType2, elementType3, elementType4, elementType5, prefixes, args));
    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <T> T querySingle(String sql, Class<T> elementType, BeanPropertyValue<?>... args) {
    //        return singleResult(query(sql, elementType, args));
    //    }

    private <T> T singleResult(Collection<T> results) {
        if (results == null || results.size() <= 0) {
            return null;
        } else if (results.size() > 1) {
            // ENHANCE 优化错误消息
            throw new JdbcException(Strings.format("results size must be 1, but is {0}", results.size()));
        }
        return results.iterator().next();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Map<String, Object> queryUnique(String sql, Map<String, Object> args) {
        return nullableSingleResult(query(sql, args));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Map<String, Object> queryUnique(String sql, Object... args) {
        return nullableSingleResult(query(sql, args));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> T queryUnique(String sql, RowMapper<T> rowMapper, Object... args) {
        return nullableSingleResult(query(sql, rowMapper, args));
    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <T> T queryUnique(String sql, RowMapper<T> rowMapper, BeanPropertyValue<?>... args) {
    //        return nullableSingleResult(query(sql, rowMapper, args));
    //    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> T queryUnique(String sql, RowMapper<T> rowMapper, Map<String, Object> args) {
        return nullableSingleResult(query(sql, rowMapper, args));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> T queryUnique(String sql, Class<T> elementType, Map<String, Object> args) {
        return nullableSingleResult(query(sql, elementType, args));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1, T2> Tuple2<T1, T2> queryUnique(String sql, Class<T1> elementType1, Class<T2> elementType2,
            Tuple2<String, String> prefixes, Map<String, Object> args) {
        return nullableSingleResult(query(sql, elementType1, elementType2, prefixes, args));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1, T2, T3> Tuple3<T1, T2, T3> queryUnique(String sql, Class<T1> elementType1, Class<T2> elementType2,
            Class<T3> elementType3, Tuple3<String, String, String> prefixes, Map<String, Object> args) {
        return nullableSingleResult(query(sql, elementType1, elementType2, elementType3, prefixes, args));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1, T2, T3, T4> Tuple4<T1, T2, T3, T4> queryUnique(String sql, Class<T1> elementType1,
            Class<T2> elementType2, Class<T3> elementType3, Class<T4> elementType4,
            Tuple4<String, String, String, String> prefixes, Map<String, Object> args) {
        return nullableSingleResult(query(sql, elementType1, elementType2, elementType3, elementType4, prefixes, args));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1, T2, T3, T4, T5> Tuple5<T1, T2, T3, T4, T5> queryUnique(String sql, Class<T1> elementType1,
            Class<T2> elementType2, Class<T3> elementType3, Class<T4> elementType4, Class<T5> elementType5,
            Tuple5<String, String, String, String, String> prefixes, Map<String, Object> args) {
        return nullableSingleResult(
                query(sql, elementType1, elementType2, elementType3, elementType4, elementType5, prefixes, args));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> T queryUnique(String sql, Class<T> elementType, Object... args) {
        return nullableSingleResult(query(sql, elementType, args));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1, T2> Tuple2<T1, T2> queryUnique(String sql, Class<T1> elementType1, Class<T2> elementType2,
            Tuple2<String, String> prefixes, Object... args) {
        return nullableSingleResult(query(sql, elementType1, elementType2, prefixes, args));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1, T2, T3> Tuple3<T1, T2, T3> queryUnique(String sql, Class<T1> elementType1, Class<T2> elementType2,
            Class<T3> elementType3, Tuple3<String, String, String> prefixes, Object... args) {
        return nullableSingleResult(query(sql, elementType1, elementType2, elementType3, prefixes, args));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1, T2, T3, T4> Tuple4<T1, T2, T3, T4> queryUnique(String sql, Class<T1> elementType1,
            Class<T2> elementType2, Class<T3> elementType3, Class<T4> elementType4,
            Tuple4<String, String, String, String> prefixes, Object... args) {
        return nullableSingleResult(query(sql, elementType1, elementType2, elementType3, elementType4, prefixes, args));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1, T2, T3, T4, T5> Tuple5<T1, T2, T3, T4, T5> queryUnique(String sql, Class<T1> elementType1,
            Class<T2> elementType2, Class<T3> elementType3, Class<T4> elementType4, Class<T5> elementType5,
            Tuple5<String, String, String, String, String> prefixes, Object... args) {
        return nullableSingleResult(
                query(sql, elementType1, elementType2, elementType3, elementType4, elementType5, prefixes, args));
    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <T> T queryUnique(String sql, Class<T> elementType, BeanPropertyValue<?>... args) {
    //        return nullableSingleResult(query(sql, elementType, args));
    //    }

    private <T> T nullableSingleResult(Collection<T> results) {
        if (Lang.isEmpty(results)) {
            // ENHANCE 优化错误消息
            throw new JdbcException("results is empty");
        }
        if (results.size() > 1) {
            // ENHANCE 优化错误消息
            throw new JdbcException(Strings.format("results size must be 1, but is {0}", results.size()));
        }
        return results.iterator().next();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> T queryValue(String sql, Class<T> valueType, Map<String, Object> args) {
        return queryValue(sql, new SingleColumnRowMapper<>(valueType, manager), args);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> T queryValue(String sql, Class<T> valueType, Object... args) {
        return queryValue(sql, new SingleColumnRowMapper<>(valueType, manager), args);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> T queryValue(String sql, RowMapper<T> rowMapper, Map<String, Object> args) {
        logger.debug("sql -> {}, args -> {}", sql, args);
        Execution execution = SqlUtils.convertNamedParamSql(sql, args);
        return queryValue(execution.getExecution(), rowMapper, execution.getParams());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> T queryValue(String sql, RowMapper<T> rowMapper, Object... args) {
        List<T> results = query(sql, rowMapper, args);
        return nullableSingleResult(results);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int call(String name, Object... args) {
        String procedure = getProcedure(name, args.length);
        JdbcExecution execution = preHandle(procedure, args);
        procedure = execution.getExecution();
        args = execution.getParams();
        Connection con = getConnection(dataSource);
        try (CallableStatement call = con.prepareCall(procedure)) {
            Map<Integer, Class<?>> outParams = setParams(call, args);
            call.execute();
            setOutParams(call, outParams, args);
            postHandle(execution, procedure, args);
            return call.getUpdateCount();
        } catch (SQLException e) {
            releaseConnection(con, dataSource);
            con = null;
            throw new JdbcException(
                    Strings.format("call procedure: \nprocedure: {0} \nargs: {1}", procedure, Arrays.toString(args)),
                    e);
        } finally {
            releaseConnection(con, getDataSource());
        }
    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //    @SuppressWarnings("rawtypes")
    //    @Override
    //    public int call(String name, Map<String, Object> args) {
    //        String procedure = getProcedure(name, args.size());
    //        Connection con = getConnection(dataSource);
    //        try (CallableStatement call = con.prepareCall(procedure)) {
    //            Map<String, ProcedureOutParameter> outParams = setParams(call, args);
    //            call.execute();
    //            setOutParams2(call, outParams);
    //            return call.getUpdateCount();
    //        } catch (SQLException e) {
    //            releaseConnection(con, dataSource);
    //            con = null;
    //            throw new JdbcException(
    //                    Strings.format("call procedure: \nprocedure: {0} \nargs: {1}", procedure, args.toString()), e);
    //        } finally {
    //            releaseConnection(con, getDataSource());
    //        }
    //    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Map<String, Object>> callQuery(String name, Object... args) {
        String procedure = getProcedure(name, args.length);
        JdbcExecution execution = preHandle(procedure, args);
        procedure = execution.getExecution();
        args = execution.getParams();
        Connection con = getConnection(dataSource);
        try (CallableStatement call = con.prepareCall(procedure)) {
            Map<Integer, Class<?>> outParams = setParams(call, args);
            try (ResultSet rs = call.executeQuery()) {
                setOutParams(call, outParams, args);
                return postHandle(execution.setOriginalResult(JdbcUtils.getResultSetMaps(rs, manager)), procedure,
                        args);
            }
        } catch (SQLException e) {
            releaseConnection(con, dataSource);
            con = null;
            throw new JdbcException(Strings.format("call procedure query: \nprocedure: {0} \nargs: {1}", procedure,
                    Arrays.toString(args)), e);
        } finally {
            releaseConnection(con, getDataSource());
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> List<T> callQuery(String name, RowMapper<T> rowMapper, Object... args) {
        String procedure = getProcedure(name, args.length);
        JdbcExecution execution = preHandle(procedure, args);
        procedure = execution.getExecution();
        args = execution.getParams();
        Connection con = getConnection(dataSource);
        try (CallableStatement call = con.prepareCall(procedure)) {
            Map<Integer, Class<?>> outParams = setParams(call, args);
            try (ResultSet rs = call.executeQuery()) {
                setOutParams(call, outParams, args);
                postHandle(execution, procedure, args);
                List<T> list = new ArrayList<>();
                int i = 0;
                while (rs.next()) {
                    list.add(rowMapper.mapRow(new SqlResultSet(rs), i++));
                }
                return postHandle(execution.setOriginalResult(list), procedure, args);
            }
        } catch (SQLException e) {
            releaseConnection(con, dataSource);
            con = null;
            throw new JdbcException(Strings.format("call procedure query: \nprocedure: {0} \nargs: {1}", procedure,
                    Arrays.toString(args)), e);
        } finally {
            releaseConnection(con, getDataSource());
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> List<T> callQuery(String name, Class<T> elementType, Object... args) {
        SQLType sqlType = manager.getSqlType(elementType);
        RowMapper<T> rowMapper = null;
        if (sqlType == null) {
            rowMapper = new NestedBeanPropertyRowMapper<>(elementType, manager);
        } else {
            rowMapper = new SingleColumnRowMapper<>(elementType, manager);
        }
        return callQuery(name, rowMapper, args);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1, T2> List<Tuple2<T1, T2>> callQuery(String name, Class<T1> elementType1, Class<T2> elementType2,
            Tuple2<String, String> prefixes, Object... args) {
        return callQuery(name, new TupleNestedBeanPropertyRowMapper<>(ArrayUtils.toList(elementType1, elementType2),
                prefixes, manager), args);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1, T2, T3> List<Tuple3<T1, T2, T3>> callQuery(String name, Class<T1> elementType1, Class<T2> elementType2,
            Class<T3> elementType3, Tuple3<String, String, String> prefixes, Object... args) {
        return callQuery(name, new TupleNestedBeanPropertyRowMapper<>(
                ArrayUtils.toList(elementType1, elementType2, elementType3), prefixes, manager), args);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1, T2, T3, T4> List<Tuple4<T1, T2, T3, T4>> callQuery(String name, Class<T1> elementType1,
            Class<T2> elementType2, Class<T3> elementType3, Class<T4> elementType4,
            Tuple4<String, String, String, String> prefixes, Object... args) {
        return callQuery(name,
                new TupleNestedBeanPropertyRowMapper<>(
                        ArrayUtils.toList(elementType1, elementType2, elementType3, elementType4), prefixes, manager),
                args);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1, T2, T3, T4, T5> List<Tuple5<T1, T2, T3, T4, T5>> callQuery(String name, Class<T1> elementType1,
            Class<T2> elementType2, Class<T3> elementType3, Class<T4> elementType4, Class<T5> elementType5,
            Tuple5<String, String, String, String, String> prefixes, Object... args) {
        return callQuery(name,
                new TupleNestedBeanPropertyRowMapper<>(
                        ArrayUtils.toList(elementType1, elementType2, elementType3, elementType4, elementType5),
                        prefixes, manager),
                args);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Map<String, Object> callQuerySingle(String name, Object... args) {
        return singleResult(callQuery(name, args));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> T callQuerySingle(String name, RowMapper<T> rowMapper, Object... args) {
        return singleResult(callQuery(name, rowMapper, args));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> T callQuerySingle(String name, Class<T> elementType, Object... args) {
        return singleResult(callQuery(name, elementType, args));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1, T2> Tuple2<T1, T2> callQuerySingle(String name, Class<T1> elementType1, Class<T2> elementType2,
            Tuple2<String, String> prefixes, Object... args) {
        return singleResult(callQuery(name, elementType1, elementType2, prefixes, args));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1, T2, T3> Tuple3<T1, T2, T3> callQuerySingle(String name, Class<T1> elementType1, Class<T2> elementType2,
            Class<T3> elementType3, Tuple3<String, String, String> prefixes, Object... args) {
        return singleResult(callQuery(name, elementType1, elementType2, elementType3, prefixes, args));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1, T2, T3, T4> Tuple4<T1, T2, T3, T4> callQuerySingle(String name, Class<T1> elementType1,
            Class<T2> elementType2, Class<T3> elementType3, Class<T4> elementType4,
            Tuple4<String, String, String, String> prefixes, Object... args) {
        return singleResult(callQuery(name, elementType1, elementType2, elementType3, elementType4, prefixes, args));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1, T2, T3, T4, T5> Tuple5<T1, T2, T3, T4, T5> callQuerySingle(String name, Class<T1> elementType1,
            Class<T2> elementType2, Class<T3> elementType3, Class<T4> elementType4, Class<T5> elementType5,
            Tuple5<String, String, String, String, String> prefixes, Object... args) {
        return singleResult(
                callQuery(name, elementType1, elementType2, elementType3, elementType4, elementType5, prefixes, args));
    }

    private String getProcedure(String name, int argnum) {
        AssertIllegalArgument.isNotBlank(name, "procedureName");
        StringBuilder procedure = new StringBuilder("{call ");
        procedure.append(name).append("(");
        for (int i = 0; i < argnum; i++) {
            procedure.append("?,");
        }
        if (argnum > 0) {
            procedure.deleteCharAt(procedure.length() - 1);
        }
        procedure.append(")}");
        return procedure.toString();
    }

    /**
     * Sets the param.
     *
     * @param prep  the prep
     * @param index the index
     * @param argu  the arg
     */
    protected void setParam(PreparedStatement prep, int index, Object argu) {
        if (argu instanceof FieldValueOperator) {
            ((FieldValueOperator<?>) argu).set(prep, index);
        } else if (argu instanceof BeanPropertyValue) {
            @SuppressWarnings("unchecked")
            BeanPropertyValue<Object> bpv = (BeanPropertyValue<Object>) argu;
            BeanProperty<Object> bp = bpv.getBeanProperty();
            manager.set(prep, index, bpv.getValue(), bp);
        } else {
            manager.set(prep, index, argu);
        }
    }

    /**
     * Sets the params.
     *
     * @param prep the prep
     * @param args the args
     */
    protected void setParams(PreparedStatement prep, Object... args) {
        for (int i = 0; i < args.length; i++) {
            Object arg = args[i];
            setParam(prep, i + 1, arg);
        }
    }

    /**
     * Sets the params.
     *
     * @param prep the prep
     * @param args the args
     */
    protected void setParams(PreparedStatement prep, BeanPropertyValue<?>... args) {
        for (int i = 0; i < args.length; i++) {
            @SuppressWarnings("unchecked")
            BeanProperty<Object> argBp = (BeanProperty<Object>) args[i].getBeanProperty();
            manager.set(prep, i + 1, args[i].getValue(), argBp);
        }
    }

    /**
     * set call in inout params.
     *
     * @param call the CallableStatement
     * @param args the args
     * @return the out parameter index and class map
     */
    protected Map<Integer, Class<?>> setParams(CallableStatement call, Object... args) {
        Map<Integer, Class<?>> outParamMap = new HashMap<>(0);
        try {
            ParameterMetaData meta = call.getParameterMetaData();
            if (meta.getParameterCount() != args.length) {
                throw new JdbcException(Strings.format("procedure parameter count[{0}] not equals args length[{1}]",
                        meta.getParameterCount(), args.length));
            }
            for (int i = 1; i <= args.length; i++) {
                Object arg = args[i - 1];
                int mode = meta.getParameterMode(i);
                if (mode == ParameterMetaData.parameterModeOut) {
                    setOutParamMap(outParamMap, i, arg, meta);
                } else if (mode == ParameterMetaData.parameterModeInOut) {
                    setOutParamMap(outParamMap, i, arg, meta);
                    setParam(call, i, arg);
                } else {
                    setParam(call, i, arg);
                }
            }
        } catch (SQLException e) {
            throw new JdbcException(e);
        }
        return outParamMap;
    }

    private void setOutParamMap(Map<Integer, Class<?>> outParamMap, int index, Object arg, ParameterMetaData meta)
            throws SQLException {
        if (arg == null) {
            outParamMap.put(index, ClassUtils.forName(meta.getParameterClassName(index)));
        } else {
            outParamMap.put(index, arg.getClass());
        }
    }

    //    /**
    //     * Sets the params.
    //     *
    //     * @param call the CallableStatement
    //     * @param args the args
    //     * @return the map
    //     */
    //    @SuppressWarnings("rawtypes")
    //    protected Map<String, ProcedureOutParameter> setParams(CallableStatement call, Map<String, Object> args) {
    //        return JdbcUtils.setParameters(call, args, manager.isEnumWithOrdinal());
    //    }

    /**
     * Sets the params.
     *
     * @param call      the CallableStatement
     * @param outParams the out params
     */
    protected void setOutParams(CallableStatement call, Map<Integer, Class<?>> outParams, Object[] args) {
        for (Entry<Integer, Class<?>> entry : outParams.entrySet()) {
            int index = entry.getKey();
            args[index - 1] = manager.getParam(call, index, entry.getValue());
        }
    }

    /**
     * Adds the interceptor.
     *
     * @param interceptor the interceptor
     */
    public void addInterceptor(JdbcExecutionInterceptor interceptor) {
        if (interceptor != null) {
            interceptors.add(interceptor);
        }

    }

    /**
     * Adds the interceptor.
     *
     * @param interceptors the interceptors
     */
    public void addInterceptor(List<JdbcExecutionInterceptor> interceptors) {
        if (interceptors != null) {
            for (JdbcExecutionInterceptor jdbcExecutionInterceptor : interceptors) {
                addInterceptor(jdbcExecutionInterceptor);
            }
        }
    }

    /**
     * Adds the interceptor.
     *
     * @param interceptors the interceptors
     */
    public void addInterceptor(JdbcExecutionInterceptor... interceptors) {
        if (interceptors != null) {
            for (JdbcExecutionInterceptor jdbcExecutionInterceptor : interceptors) {
                addInterceptor(jdbcExecutionInterceptor);
            }
        }
    }

    private JdbcExecution preHandle(String sql, Object... params) {
        JdbcExecution jdbcExecution = new JdbcExecution(this, sql, params);
        for (JdbcExecutionInterceptor interceptor : interceptors) {
            interceptor.preHandle(jdbcExecution);
        }
        return jdbcExecution;
    }

    @SuppressWarnings("unchecked")
    private <O> O postHandle(JdbcExecution jdbcExecution, String sql, Object... params) {
        for (JdbcExecutionInterceptor interceptor : interceptors) {
            interceptor.postHandle(jdbcExecution);
        }
        return (O) jdbcExecution.getResult();
    }

    /**
     * Release connection.
     *
     * @param connection the connection
     * @param dataSource the data source
     */
    protected abstract void releaseConnection(Connection connection, DataSource dataSource);

    /**
     * Gets the connection.
     *
     * @param dataSource the data source
     * @return the connection
     */
    protected abstract Connection getConnection(DataSource dataSource);
}
