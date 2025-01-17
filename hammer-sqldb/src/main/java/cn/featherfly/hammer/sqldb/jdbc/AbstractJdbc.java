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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.ToIntBiFunction;

import org.apache.commons.collections4.iterators.ArrayIterator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.featherfly.common.bean.BeanProperty;
import cn.featherfly.common.bean.BeanPropertyValue;
import cn.featherfly.common.bean.Property;
import cn.featherfly.common.bean.PropertyAccessorFactory;
import cn.featherfly.common.db.FieldValueOperator;
import cn.featherfly.common.db.JdbcException;
import cn.featherfly.common.db.SqlUtils;
import cn.featherfly.common.db.dialect.Dialect;
import cn.featherfly.common.db.mapper.SqlResultSet;
import cn.featherfly.common.db.mapping.SqlTypeMappingManager;
import cn.featherfly.common.db.metadata.DatabaseMetadata;
import cn.featherfly.common.db.metadata.ResultSetConcurrency;
import cn.featherfly.common.db.metadata.ResultSetType;
import cn.featherfly.common.lang.ArrayUtils;
import cn.featherfly.common.lang.AssertIllegalArgument;
import cn.featherfly.common.lang.ClassUtils;
import cn.featherfly.common.lang.Lang;
import cn.featherfly.common.lang.Str;
import cn.featherfly.common.lang.reflect.Type;
import cn.featherfly.common.repository.Execution;
import cn.featherfly.common.repository.MulitiQuery;
import cn.featherfly.common.repository.ParamedQueryExecutor;
import cn.featherfly.common.repository.mapper.MulitiQueryRowMapper;
import cn.featherfly.common.repository.mapper.MulitiQueryTupleMapperBuilder;
import cn.featherfly.common.repository.mapper.RowMapper;
import cn.featherfly.common.tuple.MutableTuple;
import cn.featherfly.common.tuple.Tuple;
import cn.featherfly.common.tuple.Tuple2;
import cn.featherfly.common.tuple.Tuple3;
import cn.featherfly.common.tuple.Tuple4;
import cn.featherfly.common.tuple.Tuple5;
import cn.featherfly.common.tuple.Tuple6;
import cn.featherfly.common.tuple.Tuples;
import cn.featherfly.hammer.sqldb.jdbc.mapper.MulitiQueryTupleMapperBuilderImpl;
import cn.featherfly.hammer.tpl.ArrayParamedExecutionExecutor;
import cn.featherfly.hammer.tpl.MapParamedExecutionExecutor;

/**
 * AbstractJdbc.
 *
 * @author zhongj
 */
public abstract class AbstractJdbc implements Jdbc {

    protected static final String CALL = "call";

    /** The logger. */
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final Set<JdbcExecutionInterceptor> interceptors = new LinkedHashSet<>(0);

    /** The dialect. */
    protected final Dialect dialect;

    /** The manager. */
    protected final SqlTypeMappingManager manager;

    /** The metadata. */
    protected final DatabaseMetadata metadata;

    /** The property accessor factory. */
    protected final PropertyAccessorFactory propertyAccessorFactory;

    /**
     * Instantiates a new abstract jdbc.
     *
     * @param dialect the dialect
     * @param metadata the metadata
     * @param manager the manager
     * @param propertyAccessorFactory the property accessor factory
     */
    protected AbstractJdbc(Dialect dialect, DatabaseMetadata metadata, SqlTypeMappingManager manager,
        PropertyAccessorFactory propertyAccessorFactory) {
        super();
        this.dialect = dialect;
        this.manager = manager;
        this.metadata = metadata;
        this.propertyAccessorFactory = propertyAccessorFactory;
    }

    @Override
    public PropertyAccessorFactory getPropertyAccessorFactory() {
        return propertyAccessorFactory;
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
        Serializable... args) {
        if (metadata.getTable(tableName).getPrimaryColumns().size() == 1) {
            return update(
                getDialect().dml().insert(tableName, metadata.getTable(tableName).getPrimaryColumns().get(0).getName(),
                    columnNames, metadata.getTable(tableName).getPrimaryColumns().get(0).isAutoincrement()),
                keyHolder, args);
        } else {
            return update(getDialect().dml().insert(tableName, columnNames, false), keyHolder, args);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int insertBatch(String tableName, String[] columnNames, int batchSize, Serializable... args) {
        if (args.length % columnNames.length != 0) {
            throw new JdbcException("batch size is not explicit (args.length % columnNames.length != 0)");
        }
        int actualBatchSize = args.length / columnNames.length;
        String pkColumn = null;
        boolean autoincrement = false;
        if (metadata.getTable(tableName).getPrimaryColumns().size() == 1) {
            pkColumn = metadata.getTable(tableName).getPrimaryColumns().get(0).getName();
            autoincrement = metadata.getTable(tableName).getPrimaryColumns().get(0).isAutoincrement();
        }
        if (batchSize >= actualBatchSize) { // 表示批量执行数的最大限制小于等于参数计算出的实际需要的批量执行数
            return updateBatch(
                getDialect().dml().insertBatch(tableName, pkColumn, columnNames, actualBatchSize, autoincrement),
                actualBatchSize, args);
        } else {
            int index = batchSize * columnNames.length;
            return updateBatch(
                getDialect().dml().insertBatch(tableName, pkColumn, columnNames, batchSize, autoincrement), batchSize,
                Arrays.copyOfRange(args, 0, index))
                + insertBatch(tableName, columnNames, actualBatchSize - batchSize,
                    Arrays.copyOfRange(args, index, args.length));
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int upsert(String tableName, String[] columnNames, String[] uniqueColumns, Serializable... args) {
        if (metadata.getTable(tableName).getPrimaryColumns().size() == 1) {
            return update(getDialect().dml().upsert(tableName,
                metadata.getTable(tableName).getPrimaryColumns().get(0).getName(), columnNames, uniqueColumns,
                metadata.getTable(tableName).getPrimaryColumns().get(0).isAutoincrement()), args);
        } else {
            return update(getDialect().dml().upsert(tableName, columnNames, uniqueColumns, false), args);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T extends Serializable> int update(String sql, GeneratedKeyHolder<T> keyHolder, Serializable... args) {
        return executeUpdate(sql, keyHolder, args);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T extends Serializable> int update(String sql, GeneratedKeyHolder<T> keySupplier,
        Map<String, Serializable> args) {
        sql = Lang.ifNotNull(sql, String::trim);
        if (Lang.isEmpty(sql)) {
            return 0;
        }
        logger.debug("sql -> {}, args -> {}", sql, args);
        Execution execution = SqlUtils.convertNamedParamSql(sql, args);
        return update(execution.getExecution(), keySupplier, execution.getParams());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T extends Serializable> int updateBatch(String sql, int batchSize, GeneratedKeysHolder<T> keySupplier,
        Serializable... args) {
        sql = Lang.ifNotNull(sql, String::trim);
        if (Lang.isEmpty(sql)) {
            return 0;
        }
        return executeUpdateBatch(sql, batchSize, keySupplier, args);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T extends Serializable> int updateBatch(String sql, int batchSize, GeneratedKeysHolder<T> keySupplier,
        Map<String, Serializable> args) {
        sql = Lang.ifNotNull(sql, String::trim);
        if (Lang.isEmpty(sql)) {
            return 0;
        }
        logger.debug("sql -> {}, args -> {}", sql, args);
        Execution execution = SqlUtils.convertNamedParamSql(sql, args);
        return executeUpdateBatch(execution.getExecution(), batchSize, keySupplier, execution.getParams());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T extends Serializable> int[] updateBatch(String sql, GeneratedKeysHolder<T> generatedKeysHolder,
        Serializable[]... argsList) {
        sql = Lang.ifNotNull(sql, String::trim);
        if (Lang.isEmpty(sql)) {
            return ArrayUtils.EMPTY_INT_ARRAY;
        }
        return executeUpdateBatch((prep, args) -> setParams(prep, args), sql, generatedKeysHolder, argsList);
    }

    @Override
    public <T extends Serializable> int[] updateBatch(String sql, GeneratedKeysHolder<T> generatedKeyHolder,
        Iterable<Serializable[]> argsIter) {
        sql = Lang.ifNotNull(sql, String::trim);
        if (Lang.isEmpty(sql)) {
            return ArrayUtils.EMPTY_INT_ARRAY;
        }
        return executeUpdateBatch((prep, args) -> setParams(prep, args), sql, generatedKeyHolder, argsIter, -1);
    }

    @Override
    public <T extends Serializable> int[] updateBatch(String sql, GeneratedKeysHolder<T> generatedKeyHolder,
        BiConsumer<PreparedStatement, Consumer<Serializable[]>> setArgs) {
        sql = Lang.ifNotNull(sql, String::trim);
        if (Lang.isEmpty(sql)) {
            return ArrayUtils.EMPTY_INT_ARRAY;
        }
        return executeUpdateBatch(sql, generatedKeyHolder, setArgs);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T extends Serializable> int[] updateBatch(String sql, GeneratedKeysHolder<T> generatedKeyHolder,
        Map<String, Serializable>[] batchArgs) {
        if (Lang.isNotEmpty(sql) && Lang.isNotEmpty(batchArgs)) {
            logger.debug("sql -> {}", sql);
            sql = sql.trim();
            List<Serializable[]> argsList = new ArrayList<>(batchArgs.length);
            Execution execution = null;
            for (Map<String, Serializable> arg : batchArgs) {
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

    private <T extends Serializable> int executeUpdate(String sql, GeneratedKeyHolder<T> generatedKeyHolder,
        Serializable... args) {
        sql = Lang.ifNotNull(sql, String::trim);
        if (Lang.isEmpty(sql)) {
            return 0;
        }
        return executeUpdate(prep -> setParams(prep, args), sql, generatedKeyHolder, args);
    }

    private <T extends Serializable> int executeUpdate(Consumer<PreparedStatement> setParams, String sql,
        GeneratedKeyHolder<T> generatedKeyHolder, Serializable... args) {
        JdbcExecution execution = preHandle(sql, args);
        sql = execution.getExecution();
        args = execution.getParams();
        logger.debug("execute sql -> {}\n args[{}] -> {}", sql, args.length, args);
        Connection connection = getConnection();
        try (PreparedStatement prep = generatedKeyHolder == null ? connection.prepareStatement(sql)
            : connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            setParams.accept(prep);
            int result = prep.executeUpdate();
            // 不是查询操作，没有查询结果
            postHandle(execution);
            if (generatedKeyHolder != null && result == 1) {
                try (ResultSet res = prep.getGeneratedKeys()) {
                    if (res.next()) {
                        generatedKeyHolder.acceptKey(getGenereteKey(generatedKeyHolder.getType(), res));
                    }
                }
            }
            return result;
        } catch (SQLException e) {
            releaseConnection(connection);
            throw new JdbcException(Str.format("executeUpdate: \nsql: {0} \nargs: {1}", sql, Arrays.toString(args)),
                e);
        } finally {
            releaseConnection(connection);
        }
    }

    private <T extends Serializable> int executeUpdateBatch(String sql, int batchSize,
        GeneratedKeysHolder<T> generatedKeysHolder, Serializable... args) {
        logger.debug("sql -> {}, args -> {}", sql, args);
        return executeUpdateBatch(prep -> setParams(prep, args), sql, batchSize, generatedKeysHolder, args);
    }

    private <T extends Serializable> int executeUpdateBatch(Consumer<PreparedStatement> setParams, String sql,
        int batchSize, GeneratedKeysHolder<T> generatedKeysHolder, Serializable... args) {
        JdbcExecution execution = preHandle(sql, args);
        sql = execution.getExecution();
        args = execution.getParams();
        logger.debug("execute sql -> {}\n args -> {}", sql, args);
        Connection connection = getConnection();
        try (PreparedStatement prep = generatedKeysHolder == null ? connection.prepareStatement(sql)
            : connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            setParams.accept(prep);
            int result = prep.executeUpdate();
            // 不是查询操作，没有查询结果
            postHandle(execution);
            if (generatedKeysHolder != null) {
                try (ResultSet res = prep.getGeneratedKeys()) {
                    List<T> keys = new ArrayList<>();
                    while (res.next()) {
                        keys.add(getGenereteKey(generatedKeysHolder.getType(), res));
                    }
                    generatedKeysHolder.acceptKey(keys);
                }
            }
            return result;
        } catch (SQLException e) {
            releaseConnection(connection);
            throw new JdbcException(Str.format("executeUpdate: \nsql: {0} \nargs: {1}", sql, Arrays.toString(args)),
                e);
        } finally {
            releaseConnection(connection);
        }
    }

    private <T extends Serializable> int[] executeUpdateBatch(BiConsumer<PreparedStatement, Serializable[]> setParams,
        String sql, GeneratedKeysHolder<T> generatedKeysHolder, Serializable[][] batchArgs) {
        return executeUpdateBatch(setParams, sql, generatedKeysHolder, () -> new ArrayIterator<>(batchArgs),
            batchArgs.length);
        //        StringBuilder message = new StringBuilder();
        //        if (logger.isDebugEnabled()) {
        //            message.append("execute batch -> ").append(sql).append("\n").append("  batch size -> ")
        //                .append(batchArgs.length).append("\n");
        //        }
        //        //        DataSource ds = getDataSource();
        //        //        Connection connection = getConnection(ds);
        //        Connection connection = getConnection();
        //        try (PreparedStatement prep = generatedKeysHolder == null ? connection.prepareStatement(sql)
        //            : connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
        //            List<JdbcExecution> jdbcExecutions = new ArrayList<>(batchArgs.length);
        //            for (Serializable[] args : batchArgs) {
        //                JdbcExecution execution = preHandle(sql, args);
        //                jdbcExecutions.add(execution);
        //                if (logger.isDebugEnabled()) {
        //                    message.append("    args -> ").append(Arrays.toString(execution.getParams())).append("\n");
        //                }
        //                setParams.accept(prep, args);
        //                prep.addBatch();
        //            }
        //            if (logger.isDebugEnabled()) {
        //                logger.debug(message.toString());
        //            }
        //            int[] results = prep.executeBatch();
        //            // 不是查询操作，没有查询结果
        //            for (JdbcExecution execution : jdbcExecutions) {
        //                postHandle(execution);
        //            }
        //            if (generatedKeysHolder != null) {
        //                try (ResultSet res = prep.getGeneratedKeys()) {
        //                    List<T> keys = new ArrayList<>();
        //                    while (res.next()) {
        //                        T value = getGenereteKey(generatedKeysHolder.getType(), res);
        //                        keys.add(value);
        //                    }
        //                    generatedKeysHolder.acceptKey(keys);
        //                }
        //            }
        //            return results;
        //        } catch (SQLException e) {
        //            releaseConnection(connection);
        //            StringBuilder strArgs = new StringBuilder();
        //            int index = 0;
        //            for (Serializable[] args : batchArgs) {
        //                strArgs.append("\n    batch[").append(index++).append("]: ").append(Arrays.toString(args));
        //            }
        //            throw new JdbcException(
        //                Str.format("executeUpdateBatch: \n  sql: {0} \n  args: {1}", sql, strArgs.toString()), e);
        //        } finally {
        //            releaseConnection(connection);
        //        }
    }

    private <T extends Serializable> int[] executeUpdateBatch(BiConsumer<PreparedStatement, Serializable[]> setParams,
        String sql, GeneratedKeysHolder<T> generatedKeysHolder, Iterable<Serializable[]> argsIter, int batchSize) {
        StringBuilder message = new StringBuilder();
        if (logger.isDebugEnabled()) {
            message.append("execute batch -> ").append(sql).append("\n");
            if (batchSize > 0) {
                message.append("  batch size -> ").append(batchSize).append("\n");
            }
        }
        Connection connection = getConnection();
        try (PreparedStatement prep = generatedKeysHolder == null ? connection.prepareStatement(sql)
            : connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            List<JdbcExecution> jdbcExecutions = new ArrayList<>();
            for (Serializable[] args : argsIter) {
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
                postHandle(execution);
            }
            if (generatedKeysHolder != null) {
                try (ResultSet res = prep.getGeneratedKeys()) {
                    List<T> keys = new ArrayList<>();
                    while (res.next()) {
                        T value = getGenereteKey(generatedKeysHolder.getType(), res);
                        keys.add(value);
                    }
                    generatedKeysHolder.acceptKey(keys);
                }
            }

            return results;
        } catch (SQLException e) {
            releaseConnection(connection);
            StringBuilder strArgs = new StringBuilder();
            int index = 0;
            for (Serializable[] args : argsIter) {
                strArgs.append("\n    batch[").append(index++).append("]: ").append(Arrays.toString(args));
            }
            throw new JdbcException(
                Str.format("executeUpdateBatch: \n  sql: {0} \n  args: {1}", sql, strArgs.toString()), e);
        } finally {
            releaseConnection(connection);
        }
    }

    private <T extends Serializable> int[] executeUpdateBatch(String sql, GeneratedKeysHolder<T> generatedKeysHolder,
        BiConsumer<PreparedStatement, Consumer<Serializable[]>> setArgs) {
        StringBuilder message = new StringBuilder();
        if (logger.isDebugEnabled()) {
            message.append("execute batch -> ").append(sql).append("\n");
        }
        Connection connection = getConnection();
        try (PreparedStatement prep = generatedKeysHolder == null ? connection.prepareStatement(sql)
            : connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            List<JdbcExecution> jdbcExecutions = new ArrayList<>();
            setArgs.accept(prep, (args) -> {
                JdbcExecution execution = preHandle(sql, args);
                jdbcExecutions.add(execution);
                if (logger.isDebugEnabled()) {
                    message.append("    args -> ").append(Arrays.toString(execution.getParams())).append("\n");
                }
            });
            logger.debug(message.toString());
            int[] results = prep.executeBatch();
            // 不是查询操作，没有查询结果
            for (JdbcExecution execution : jdbcExecutions) {
                postHandle(execution);
            }
            if (generatedKeysHolder != null) {
                try (ResultSet res = prep.getGeneratedKeys()) {
                    List<T> keys = new ArrayList<>();
                    while (res.next()) {
                        T value = getGenereteKey(generatedKeysHolder.getType(), res);
                        keys.add(value);
                    }
                    generatedKeysHolder.acceptKey(keys);
                }
            }

            return results;
        } catch (SQLException e) {
            releaseConnection(connection);
            //            StringBuilder strArgs = new StringBuilder();
            //            int index = 0;
            //            for (Serializable[] args : argsIter) {
            //                strArgs.append("\n    batch[").append(index++).append("]: ").append(Arrays.toString(args));
            //            }
            //            throw new JdbcException(Str.format("executeUpdateBatch: \n  sql: {0} \n  args: {1}", sql, strArgs.toString()), e);
            throw new JdbcException(Str.format("executeUpdateBatch: \n  sql: {0} \n", sql), e);
        } finally {
            releaseConnection(connection);
        }
    }

    /**
     * Gets the generete key.
     *
     * @param <T> the generic type
     * @param type the type
     * @param res the res
     * @return the generete key
     */
    private <T extends Serializable> T getGenereteKey(Type<T> type, ResultSet res) {
        T value;
        if (type instanceof Property) {
            value = manager.get(res, 1, (Property<?, T>) type);
        } else {
            value = manager.get(res, 1, type.getType());
        }
        logger.debug("auto generated key: {}", value);
        return value;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ParamedQueryExecutor query(String sql, Serializable... args) {
        // ArrayParamedExecutionExecutor has no page query api, so SqlPageFactory may be null
        return new ArrayParamedExecutionExecutor<>(new JdbcExecutor(this, propertyAccessorFactory, null), sql, args);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ParamedQueryExecutor query(String sql, Map<String, Serializable> args) {
        // MapParamedExecutionExecutor has no page query api, so SqlPageFactory may be null
        return new MapParamedExecutionExecutor<>(new JdbcExecutor(this, propertyAccessorFactory, null), sql, args);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Map<String, Serializable>> queryList(String sql, Map<String, Serializable> args) {
        return queryList(sql, new MapRowMapper(manager), args);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Map<String, Serializable>> queryList(String sql, Serializable... args) {
        return queryList(sql, new MapRowMapper(manager), args);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> List<T> queryList(String sql, RowMapper<T> rowMapper, Map<String, Serializable> args) {
        logger.debug("sql -> {}, args -> {}", sql, args);
        Execution execution = SqlUtils.convertNamedParamSql(sql, args);
        return queryList(execution.getExecution(), rowMapper, execution.getParams());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> List<T> queryList(String sql, RowMapper<T> rowMapper, Serializable... args) {
        List<T> list = new ArrayList<>();
        sql = Lang.ifNotNull(sql, String::trim);
        if (Lang.isEmpty(sql)) {
            return list;
        }

        JdbcExecution execution = preHandle(sql, args);
        sql = execution.getExecution();
        args = execution.getParams();
        logger.debug("execute sql -> {}\n args -> {}", sql, args);
        Connection con = getConnection();
        try (PreparedStatement prep = con.prepareStatement(sql)) {
            setParams(prep, args);
            try (ResultSet rs = prep.executeQuery()) {
                SqlResultSet sqlResultSet = new SqlResultSet(rs);
                int i = 0;
                while (rs.next()) {
                    list.add(rowMapper.mapRow(sqlResultSet, i++));
                }
                return postHandle(execution.setOriginalResult(list));
            }
        } catch (SQLException e) {
            releaseConnection(con);
            con = null;
            throw new JdbcException(Str.format("query: \nsql: {0} \nargs: {1}", sql, Arrays.toString(args)), e);
        } finally {
            releaseConnection(con);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> List<T> queryList(String sql, Class<T> elementType, Map<String, Serializable> args) {
        logger.debug("sql -> {}, args -> {}, elementType -> {}", sql, args, elementType);
        Execution execution = SqlUtils.convertNamedParamSql(sql, args);
        return queryList(execution.getExecution(), elementType, execution.getParams());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> List<T> queryList(String sql, Class<T> elementType, Serializable... args) {
        return queryList(sql, getTypeMapper(elementType), args);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1, T2> List<Tuple2<T1, T2>> queryList(String sql, Class<T1> elementType1, Class<T2> elementType2,
        Tuple2<String, String> prefixes, Map<String, Serializable> args) {
        logger.debug("sql -> {}, args -> {}, elementType1 -> {}, elementType2 -> {}", sql, args, elementType1,
            elementType2);
        Execution execution = SqlUtils.convertNamedParamSql(sql, args);
        return queryList(execution.getExecution(), elementType1, elementType2, prefixes, execution.getParams());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1, T2, T3> List<Tuple3<T1, T2, T3>> queryList(String sql, Class<T1> elementType1, Class<T2> elementType2,
        Class<T3> elementType3, Tuple3<String, String, String> prefixes, Map<String, Serializable> args) {
        logger.debug("sql -> {}, args -> {}, elementType1 -> {}, elementType2 -> {}, elementType3 -> {}", sql, args,
            elementType1, elementType2, elementType3);
        Execution execution = SqlUtils.convertNamedParamSql(sql, args);
        return queryList(execution.getExecution(), elementType1, elementType2, elementType3, prefixes,
            execution.getParams());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1, T2, T3, T4> List<Tuple4<T1, T2, T3, T4>> queryList(String sql, Class<T1> elementType1,
        Class<T2> elementType2, Class<T3> elementType3, Class<T4> elementType4,
        Tuple4<String, String, String, String> prefixes, Map<String, Serializable> args) {
        logger.debug(
            "sql -> {}, args -> {}, elementType1 -> {}, elementType2 -> {}, elementType3 -> {}, elementType4 -> {}",
            sql, args, elementType1, elementType2, elementType3, elementType4);
        Execution execution = SqlUtils.convertNamedParamSql(sql, args);
        return queryList(execution.getExecution(), elementType1, elementType2, elementType3, elementType4, prefixes,
            execution.getParams());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1, T2, T3, T4, T5> List<Tuple5<T1, T2, T3, T4, T5>> queryList(String sql, Class<T1> elementType1,
        Class<T2> elementType2, Class<T3> elementType3, Class<T4> elementType4, Class<T5> elementType5,
        Tuple5<String, String, String, String, String> prefixes, Map<String, Serializable> args) {
        logger.debug(
            "sql -> {}, args -> {}, elementType1 -> {}, elementType2 -> {}, elementType3 -> {}, elementType4 -> {}, elementType5 -> {}",
            sql, args, elementType1, elementType2, elementType3, elementType4, elementType5);
        Execution execution = SqlUtils.convertNamedParamSql(sql, args);
        return queryList(execution.getExecution(), elementType1, elementType2, elementType3, elementType4, elementType5,
            prefixes, execution.getParams());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1, T2, T3, T4, T5, T6> List<Tuple6<T1, T2, T3, T4, T5, T6>> queryList(String sql, Class<T1> elementType1,
        Class<T2> elementType2, Class<T3> elementType3, Class<T4> elementType4, Class<T5> elementType5,
        Class<T6> elementType6, Tuple6<String, String, String, String, String, String> prefixes,
        Map<String, Serializable> args) {
        logger.debug(
            "sql -> {}, args -> {}, elementType1 -> {}, elementType2 -> {}, elementType3 -> {}, elementType4 -> {}, elementType5 -> {}, elementType6 -> {}",
            sql, args, elementType1, elementType2, elementType3, elementType4, elementType5, elementType6);
        Execution execution = SqlUtils.convertNamedParamSql(sql, args);
        return queryList(execution.getExecution(), elementType1, elementType2, elementType3, elementType4, elementType5,
            elementType6, prefixes, execution.getParams());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1, T2> List<Tuple2<T1, T2>> queryList(String sql, Class<T1> elementType1, Class<T2> elementType2,
        Tuple2<String, String> prefixes, Serializable... args) {
        //        SQLType sqlType = manager.getSqlType(elementType);
        //        RowMapper<T> rowMapper = null;
        //        if (sqlType == null) {
        //            rowMapper = new NestedBeanPropertyRowMapper<>(elementType, manager);
        //        } else {
        //            rowMapper = new SingleColumnRowMapper<>(elementType, manager);
        //        }
        //        return query(sql, rowMapper, args);
        return queryList(sql,
            new TupleNestedBeanPropertyRowMapper<>(ArrayUtils.toList(elementType1, elementType2), prefixes, manager),
            args);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1, T2, T3> List<Tuple3<T1, T2, T3>> queryList(String sql, Class<T1> elementType1, Class<T2> elementType2,
        Class<T3> elementType3, Tuple3<String, String, String> prefixes, Serializable... args) {
        return queryList(sql, new TupleNestedBeanPropertyRowMapper<>(
            ArrayUtils.toList(elementType1, elementType2, elementType3), prefixes, manager), args);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1, T2, T3, T4> List<Tuple4<T1, T2, T3, T4>> queryList(String sql, Class<T1> elementType1,
        Class<T2> elementType2, Class<T3> elementType3, Class<T4> elementType4,
        Tuple4<String, String, String, String> prefixes, Serializable... args) {
        return queryList(sql, new TupleNestedBeanPropertyRowMapper<>(
            ArrayUtils.toList(elementType1, elementType2, elementType3, elementType4), prefixes, manager), args);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1, T2, T3, T4, T5> List<Tuple5<T1, T2, T3, T4, T5>> queryList(String sql, Class<T1> elementType1,
        Class<T2> elementType2, Class<T3> elementType3, Class<T4> elementType4, Class<T5> elementType5,
        Tuple5<String, String, String, String, String> prefixes, Serializable... args) {
        return queryList(sql,
            new TupleNestedBeanPropertyRowMapper<>(
                ArrayUtils.toList(elementType1, elementType2, elementType3, elementType4, elementType5), prefixes,
                manager),
            args);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1, T2, T3, T4, T5, T6> List<Tuple6<T1, T2, T3, T4, T5, T6>> queryList(String sql, Class<T1> elementType1,
        Class<T2> elementType2, Class<T3> elementType3, Class<T4> elementType4, Class<T5> elementType5,
        Class<T6> elementType6, Tuple6<String, String, String, String, String, String> prefixes, Serializable... args) {
        return queryList(sql,
            new TupleNestedBeanPropertyRowMapper<>(
                ArrayUtils.toList(elementType1, elementType2, elementType3, elementType4, elementType5, elementType6),
                prefixes, manager),
            args);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JdbcRowIterable<Map<String, Serializable>> queryEach(String sql, Map<String, Serializable> args) {
        return queryEach(sql, new MapRowMapper(manager), args);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JdbcRowIterable<Map<String, Serializable>> queryEach(String sql, Serializable... args) {
        return queryEach(sql, new MapRowMapper(manager), args);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> JdbcRowIterable<T> queryEach(String sql, RowMapper<T> rowMapper, Map<String, Serializable> args) {
        sql = Lang.ifNotNull(sql, String::trim);
        if (Lang.isEmpty(sql)) {
            return new JdbcRowIterable<>(null, rowMapper);
        }
        logger.debug("sql -> {}, args -> {}", sql, args);
        Execution execution = SqlUtils.convertNamedParamSql(sql, args);
        return queryEach0(execution.getExecution(), rowMapper, execution.getParams());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> JdbcRowIterable<T> queryEach(String sql, RowMapper<T> rowMapper, Serializable... args) {
        sql = Lang.ifNotNull(sql, String::trim);
        if (Lang.isEmpty(sql)) {
            return new JdbcRowIterable<>(null, rowMapper);
        }
        return queryEach0(sql, rowMapper, args);
    }

    private <T> JdbcRowIterable<T> queryEach0(String sql, RowMapper<T> rowMapper, Serializable... args) {
        JdbcExecution execution = preHandle(sql, args);
        sql = execution.getExecution();
        args = execution.getParams();
        logger.debug("execute sql -> {}\n args -> {}", sql, args);
        Connection con = getConnection();
        try {
            PreparedStatement prep = con.prepareStatement(sql);
            setParams(prep, args);
            ResultSet rs = prep.executeQuery();
            SqlResultSet sqlResultSet = new SqlResultSet(rs);
            return new JdbcRowIterable<>(sqlResultSet, rowMapper);
            //                return postHandle(execution.setOriginalResult(list), sql, args);
        } catch (SQLException e) {
            releaseConnection(con);
            throw new JdbcException(Str.format("queryEach: \nsql: {0} \nargs: {1}", sql, Arrays.toString(args)), e);
        } finally {
            // 不能关闭prep,因为会级联关闭ResultSet，不知道是api定义如此，还是连接池的特定实现
            //            if (!(prep instanceof AbstractCascadedCloseStatement)) {
            //                // 因为AbstractCascadedCloseStatement会级联关闭打开的ResultSet
            //                JdbcUtils.close(prep);
            //            }
            releaseConnection(con);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> JdbcRowIterable<T> queryEach(String sql, Class<T> elementType, Map<String, Serializable> args) {
        return queryEach(sql, getTypeMapper(elementType), args);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> JdbcRowIterable<T> queryEach(String sql, Class<T> elementType, Serializable... args) {
        return queryEach(sql, getTypeMapper(elementType), args);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1, T2> JdbcRowIterable<Tuple2<T1, T2>> queryEach(String sql, Class<T1> elementType1, Class<T2> elementType2,
        Tuple2<String, String> prefixes, Map<String, Serializable> args) {
        logger.debug("sql -> {}, args -> {}, elementType1 -> {}, elementType2 -> {}", sql, args, elementType1,
            elementType2);
        Execution execution = SqlUtils.convertNamedParamSql(sql, args);
        return queryEach(execution.getExecution(), elementType1, elementType2, prefixes, execution.getParams());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1, T2, T3> JdbcRowIterable<Tuple3<T1, T2, T3>> queryEach(String sql, Class<T1> elementType1,
        Class<T2> elementType2, Class<T3> elementType3, Tuple3<String, String, String> prefixes,
        Map<String, Serializable> args) {
        logger.debug("sql -> {}, args -> {}, elementType1 -> {}, elementType2 -> {}, elementType3 -> {}", sql, args,
            elementType1, elementType2, elementType3);
        Execution execution = SqlUtils.convertNamedParamSql(sql, args);
        return queryEach(execution.getExecution(), elementType1, elementType2, elementType3, prefixes,
            execution.getParams());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1, T2, T3, T4> JdbcRowIterable<Tuple4<T1, T2, T3, T4>> queryEach(String sql, Class<T1> elementType1,
        Class<T2> elementType2, Class<T3> elementType3, Class<T4> elementType4,
        Tuple4<String, String, String, String> prefixes, Map<String, Serializable> args) {
        logger.debug(
            "sql -> {}, args -> {}, elementType1 -> {}, elementType2 -> {}, elementType3 -> {}, elementType4 -> {}",
            sql, args, elementType1, elementType2, elementType3, elementType4);
        Execution execution = SqlUtils.convertNamedParamSql(sql, args);
        return queryEach(execution.getExecution(), elementType1, elementType2, elementType3, elementType4, prefixes,
            execution.getParams());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1, T2, T3, T4, T5> JdbcRowIterable<Tuple5<T1, T2, T3, T4, T5>> queryEach(String sql, Class<T1> elementType1,
        Class<T2> elementType2, Class<T3> elementType3, Class<T4> elementType4, Class<T5> elementType5,
        Tuple5<String, String, String, String, String> prefixes, Map<String, Serializable> args) {
        logger.debug(
            "sql -> {}, args -> {}, elementType1 -> {}, elementType2 -> {}, elementType3 -> {}, elementType4 -> {}, elementType5 -> {}",
            sql, args, elementType1, elementType2, elementType3, elementType4, elementType5);
        Execution execution = SqlUtils.convertNamedParamSql(sql, args);
        return queryEach(execution.getExecution(), elementType1, elementType2, elementType3, elementType4, elementType5,
            prefixes, execution.getParams());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1, T2, T3, T4, T5, T6> JdbcRowIterable<Tuple6<T1, T2, T3, T4, T5, T6>> queryEach(String sql,
        Class<T1> elementType1, Class<T2> elementType2, Class<T3> elementType3, Class<T4> elementType4,
        Class<T5> elementType5, Class<T6> elementType6, Tuple6<String, String, String, String, String, String> prefixes,
        Map<String, Serializable> args) {
        logger.debug(
            "sql -> {}, args -> {}, elementType1 -> {}, elementType2 -> {}, elementType3 -> {}, elementType4 -> {}, elementType5 -> {}, elementType6 -> {}",
            sql, args, elementType1, elementType2, elementType3, elementType4, elementType5, elementType6);
        Execution execution = SqlUtils.convertNamedParamSql(sql, args);
        return queryEach(execution.getExecution(), elementType1, elementType2, elementType3, elementType4, elementType5,
            elementType6, prefixes, execution.getParams());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1, T2> JdbcRowIterable<Tuple2<T1, T2>> queryEach(String sql, Class<T1> elementType1, Class<T2> elementType2,
        Tuple2<String, String> prefixes, Serializable... args) {
        return queryEach(sql,
            new TupleNestedBeanPropertyRowMapper<>(ArrayUtils.toList(elementType1, elementType2), prefixes, manager),
            args);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1, T2, T3> JdbcRowIterable<Tuple3<T1, T2, T3>> queryEach(String sql, Class<T1> elementType1,
        Class<T2> elementType2, Class<T3> elementType3, Tuple3<String, String, String> prefixes, Serializable... args) {
        return queryEach(sql, new TupleNestedBeanPropertyRowMapper<>(
            ArrayUtils.toList(elementType1, elementType2, elementType3), prefixes, manager), args);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1, T2, T3, T4> JdbcRowIterable<Tuple4<T1, T2, T3, T4>> queryEach(String sql, Class<T1> elementType1,
        Class<T2> elementType2, Class<T3> elementType3, Class<T4> elementType4,
        Tuple4<String, String, String, String> prefixes, Serializable... args) {
        return queryEach(sql, new TupleNestedBeanPropertyRowMapper<>(
            ArrayUtils.toList(elementType1, elementType2, elementType3, elementType4), prefixes, manager), args);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1, T2, T3, T4, T5> JdbcRowIterable<Tuple5<T1, T2, T3, T4, T5>> queryEach(String sql, Class<T1> elementType1,
        Class<T2> elementType2, Class<T3> elementType3, Class<T4> elementType4, Class<T5> elementType5,
        Tuple5<String, String, String, String, String> prefixes, Serializable... args) {
        return queryEach(sql,
            new TupleNestedBeanPropertyRowMapper<>(
                ArrayUtils.toList(elementType1, elementType2, elementType3, elementType4, elementType5), prefixes,
                manager),
            args);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1, T2, T3, T4, T5, T6> JdbcRowIterable<Tuple6<T1, T2, T3, T4, T5, T6>> queryEach(String sql,
        Class<T1> elementType1, Class<T2> elementType2, Class<T3> elementType3, Class<T4> elementType4,
        Class<T5> elementType5, Class<T6> elementType6, Tuple6<String, String, String, String, String, String> prefixes,
        Serializable... args) {
        return queryEach(sql,
            new TupleNestedBeanPropertyRowMapper<>(
                ArrayUtils.toList(elementType1, elementType2, elementType3, elementType4, elementType5, elementType6),
                prefixes, manager),
            args);
    }

    //    @Override
    //    public <T> RowIterable<T> queryEach(String sql, Class<T> elementType, BeanPropertyValue<?>... args) {
    //        SQLType sqlType = manager.getSqlType(elementType);
    //        RowMapper<T> rowMapper = null;
    //        if (sqlType == null) {
    //            rowMapper = new NestedBeanPropertyRowMapper<>(elementType, manager);
    //        } else {
    //            rowMapper = new SingleColumnRowMapper<>(elementType, manager);
    //        }
    //        return queryEach(sql, rowMapper, args);
    //    }

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
    public Map<String, Serializable> querySingle(String sql, Map<String, Serializable> args) {
        return querySingle(sql, new MapRowMapper(manager), args);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Map<String, Serializable> querySingle(String sql, Serializable... args) {
        return querySingle(sql, new MapRowMapper(manager), args);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> T querySingle(String sql, RowMapper<T> rowMapper, Serializable... args) {
        sql = Lang.ifNotNull(sql, String::trim);
        if (Lang.isEmpty(sql)) {
            return null;
        }

        JdbcExecution execution = preHandle(sql, args);
        sql = execution.getExecution();
        args = execution.getParams();
        logger.debug("execute sql -> {}\n args -> {}", sql, args);
        Connection conn = getConnection();
        try (PreparedStatement prep = conn.prepareStatement(sql, ResultSet.TYPE_FORWARD_ONLY,
            ResultSet.CONCUR_UPDATABLE)) {
            setParams(prep, args);
            try (ResultSet rs = prep.executeQuery()) {
                T result = null;
                int i = 0;
                SqlResultSet sqlResultSet = new SqlResultSet(rs);
                while (rs.next()) {
                    assertSingleResult(i + 1);
                    result = rowMapper.mapRow(sqlResultSet, i++);
                }
                return postHandle(execution.setOriginalResult(result));
            }
        } catch (SQLException e) {
            releaseConnection(conn);
            conn = null;
            throw new JdbcException(Str.format("querySingle: \nsql: {0} \nargs: {1}", sql, Arrays.toString(args)),
                e);
        } finally {
            releaseConnection(conn);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> T querySingle(String sql, RowMapper<T> rowMapper, Map<String, Serializable> args) {
        logger.debug("sql -> {}, args -> {}", sql, args);
        Execution execution = SqlUtils.convertNamedParamSql(sql, args);
        return querySingle(execution.getExecution(), rowMapper, execution.getParams());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> T querySingle(String sql, Class<T> elementType, Serializable... args) {
        return querySingle(sql, getTypeMapper(elementType), args);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> T querySingle(String sql, Class<T> elementType, Map<String, Serializable> args) {
        return querySingle(sql, getTypeMapper(elementType), args);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1, T2> Tuple2<T1, T2> querySingle(String sql, Class<T1> elementType1, Class<T2> elementType2,
        Tuple2<String, String> prefixes, Map<String, Serializable> args) {
        return singleResult(queryList(sql, elementType1, elementType2, prefixes, args));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1, T2, T3> Tuple3<T1, T2, T3> querySingle(String sql, Class<T1> elementType1, Class<T2> elementType2,
        Class<T3> elementType3, Tuple3<String, String, String> prefixes, Map<String, Serializable> args) {
        return singleResult(queryList(sql, elementType1, elementType2, elementType3, prefixes, args));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1, T2, T3, T4> Tuple4<T1, T2, T3, T4> querySingle(String sql, Class<T1> elementType1,
        Class<T2> elementType2, Class<T3> elementType3, Class<T4> elementType4,
        Tuple4<String, String, String, String> prefixes, Map<String, Serializable> args) {
        return singleResult(queryList(sql, elementType1, elementType2, elementType3, elementType4, prefixes, args));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1, T2, T3, T4, T5> Tuple5<T1, T2, T3, T4, T5> querySingle(String sql, Class<T1> elementType1,
        Class<T2> elementType2, Class<T3> elementType3, Class<T4> elementType4, Class<T5> elementType5,
        Tuple5<String, String, String, String, String> prefixes, Map<String, Serializable> args) {
        return singleResult(
            queryList(sql, elementType1, elementType2, elementType3, elementType4, elementType5, prefixes, args));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1, T2> Tuple2<T1, T2> querySingle(String sql, Class<T1> elementType1, Class<T2> elementType2,
        Tuple2<String, String> prefixes, Serializable... args) {
        return singleResult(queryList(sql, elementType1, elementType2, prefixes, args));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1, T2, T3> Tuple3<T1, T2, T3> querySingle(String sql, Class<T1> elementType1, Class<T2> elementType2,
        Class<T3> elementType3, Tuple3<String, String, String> prefixes, Serializable... args) {
        return singleResult(queryList(sql, elementType1, elementType2, elementType3, prefixes, args));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1, T2, T3, T4> Tuple4<T1, T2, T3, T4> querySingle(String sql, Class<T1> elementType1,
        Class<T2> elementType2, Class<T3> elementType3, Class<T4> elementType4,
        Tuple4<String, String, String, String> prefixes, Serializable... args) {
        return singleResult(queryList(sql, elementType1, elementType2, elementType3, elementType4, prefixes, args));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1, T2, T3, T4, T5> Tuple5<T1, T2, T3, T4, T5> querySingle(String sql, Class<T1> elementType1,
        Class<T2> elementType2, Class<T3> elementType3, Class<T4> elementType4, Class<T5> elementType5,
        Tuple5<String, String, String, String, String> prefixes, Serializable... args) {
        return singleResult(
            queryList(sql, elementType1, elementType2, elementType3, elementType4, elementType5, prefixes, args));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1, T2, T3, T4, T5, T6> Tuple6<T1, T2, T3, T4, T5, T6> querySingle(String sql, Class<T1> elementType1,
        Class<T2> elementType2, Class<T3> elementType3, Class<T4> elementType4, Class<T5> elementType5,
        Class<T6> elementType6, Tuple6<String, String, String, String, String, String> prefixes,
        Map<String, Serializable> args) {
        return singleResult(queryList(sql, elementType1, elementType2, elementType3, elementType4, elementType5,
            elementType6, prefixes, args));
    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <T> T querySingle(String sql, Class<T> elementType, BeanPropertyValue<?>... args) {
    //        return singleResult(query(sql, elementType, args));
    //    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Map<String, Serializable> queryUnique(String sql, Map<String, Serializable> args) {
        return queryUnique(sql, new MapRowMapper(manager), args);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Map<String, Serializable> queryUnique(String sql, Serializable... args) {
        return queryUnique(sql, new MapRowMapper(manager), args);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> T queryUnique(String sql, RowMapper<T> rowMapper, Serializable... args) {
        sql = Lang.ifNotNull(sql, String::trim);
        if (Lang.isEmpty(sql)) {
            return null;
        }

        JdbcExecution execution = preHandle(sql, args);
        sql = execution.getExecution();
        args = execution.getParams();
        logger.debug("execute sql -> {}\n args -> {}", sql, args);
        Connection conn = getConnection();
        try (PreparedStatement prep = conn.prepareStatement(sql, ResultSet.TYPE_FORWARD_ONLY,
            ResultSet.CONCUR_UPDATABLE)) {
            setParams(prep, args);
            try (ResultSet rs = prep.executeQuery()) {
                T result = null;
                int i = 0;
                SqlResultSet sqlResultSet = new SqlResultSet(rs);
                while (rs.next()) {
                    assertSingleResult(i + 1);
                    result = rowMapper.mapRow(sqlResultSet, i++);
                }
                assertNullableResult(result);
                return postHandle(execution.setOriginalResult(result));
            }
        } catch (SQLException e) {
            releaseConnection(conn);
            conn = null;
            throw new JdbcException(Str.format("querySingle: \nsql: {0} \nargs: {1}", sql, Arrays.toString(args)),
                e);
        } finally {
            releaseConnection(conn);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> T queryUnique(String sql, RowMapper<T> rowMapper, Map<String, Serializable> args) {
        logger.debug("sql -> {}, args -> {}", sql, args);
        Execution execution = SqlUtils.convertNamedParamSql(sql, args);
        return queryUnique(execution.getExecution(), rowMapper, execution.getParams());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> T queryUnique(String sql, Class<T> elementType, Map<String, Serializable> args) {
        return queryUnique(sql, getTypeMapper(elementType), args);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> T queryUnique(String sql, Class<T> elementType, Serializable... args) {
        return queryUnique(sql, getTypeMapper(elementType), args);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1, T2> Tuple2<T1, T2> queryUnique(String sql, Class<T1> elementType1, Class<T2> elementType2,
        Tuple2<String, String> prefixes, Map<String, Serializable> args) {
        return nullableSingleResult(queryList(sql, elementType1, elementType2, prefixes, args));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1, T2, T3> Tuple3<T1, T2, T3> queryUnique(String sql, Class<T1> elementType1, Class<T2> elementType2,
        Class<T3> elementType3, Tuple3<String, String, String> prefixes, Map<String, Serializable> args) {
        return nullableSingleResult(queryList(sql, elementType1, elementType2, elementType3, prefixes, args));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1, T2, T3, T4> Tuple4<T1, T2, T3, T4> queryUnique(String sql, Class<T1> elementType1,
        Class<T2> elementType2, Class<T3> elementType3, Class<T4> elementType4,
        Tuple4<String, String, String, String> prefixes, Map<String, Serializable> args) {
        return nullableSingleResult(
            queryList(sql, elementType1, elementType2, elementType3, elementType4, prefixes, args));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1, T2, T3, T4, T5> Tuple5<T1, T2, T3, T4, T5> queryUnique(String sql, Class<T1> elementType1,
        Class<T2> elementType2, Class<T3> elementType3, Class<T4> elementType4, Class<T5> elementType5,
        Tuple5<String, String, String, String, String> prefixes, Map<String, Serializable> args) {
        return nullableSingleResult(
            queryList(sql, elementType1, elementType2, elementType3, elementType4, elementType5, prefixes, args));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1, T2, T3, T4, T5, T6> Tuple6<T1, T2, T3, T4, T5, T6> queryUnique(String sql, Class<T1> elementType1,
        Class<T2> elementType2, Class<T3> elementType3, Class<T4> elementType4, Class<T5> elementType5,
        Class<T6> elementType6, Tuple6<String, String, String, String, String, String> prefixes,
        Map<String, Serializable> args) {
        return nullableSingleResult(queryList(sql, elementType1, elementType2, elementType3, elementType4, elementType5,
            elementType6, prefixes, args));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1, T2, T3, T4, T5, T6> Tuple6<T1, T2, T3, T4, T5, T6> querySingle(String sql, Class<T1> elementType1,
        Class<T2> elementType2, Class<T3> elementType3, Class<T4> elementType4, Class<T5> elementType5,
        Class<T6> elementType6, Tuple6<String, String, String, String, String, String> prefixes, Serializable... args) {
        return singleResult(queryList(sql, elementType1, elementType2, elementType3, elementType4, elementType5,
            elementType6, prefixes, args));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Tuple2<Map<String, Serializable>, Integer> querySingleUpdate(String sql,
        ToIntBiFunction<ResultSet, Map<String, Serializable>> setValueOperator, Map<String, Serializable> args) {
        return querySingleUpdate(sql, new MapRowMapper(manager), setValueOperator, args);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Tuple2<Map<String, Serializable>, Integer> querySingleUpdate(String sql,
        ToIntBiFunction<ResultSet, Map<String, Serializable>> setValueOperator, Serializable... args) {
        return querySingleUpdate(sql, new MapRowMapper(manager), setValueOperator, args);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> Tuple2<T, Integer> querySingleUpdate(String sql, RowMapper<T> rowMapper,
        ToIntBiFunction<ResultSet, T> setValueOperator, Serializable... args) {
        sql = Lang.ifNotNull(sql, String::trim);
        if (Lang.isEmpty(sql)) {
            return null;
        }

        JdbcExecution execution = preHandle(sql, args);
        sql = execution.getExecution();
        args = execution.getParams();
        logger.debug("execute sql -> {}\n args -> {}", sql, args);

        if (metadata.getFeatures().supportsResultSetConcurrency(ResultSetType.FORWARD_ONLY,
            ResultSetConcurrency.CONCUR_UPDATABLE)) {
            Connection conn = getConnection();
            try (PreparedStatement prep = conn.prepareStatement(sql, ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_UPDATABLE)) {
                setParams(prep, args);
                try (ResultSet rs = prep.executeQuery()) {
                    T result = null;
                    int i = 0;
                    int size = 0;
                    SqlResultSet sqlResultSet = new SqlResultSet(rs);
                    if (rs.next()) {
                        result = rowMapper.mapRow(sqlResultSet, i++);
                        result = postHandle(execution.setOriginalResult(result));
                        size = setValueOperator.applyAsInt(rs, result);
                    }
                    // 判断查询的数量，大于1则抛出异常
                    while (rs.next()) {
                        throwMoreThanOneResult();
                    }
                    return Tuples.of(result, size);
                }
            } catch (SQLException e) {
                releaseConnection(conn);
                conn = null;
                throw new JdbcException(
                    Str.format("querySingleUpdate: \nsql: {0} \nargs: {1}", sql, Arrays.toString(args)), e);
            } finally {
                releaseConnection(conn);
            }
        } else {
            throw new JdbcException("unsupport for CONCUR_UPDATABLE");
        }

        //        if (metadata.getFeatures().supportsResultSetConcurrency(ResultSetType.SCROLL_SENSITIVE,
        //                ResultSetConcurrency.CONCUR_UPDATABLE)
        //                || metadata.getFeatures().supportsResultSetConcurrency(ResultSetType.SCROLL_INSENSITIVE,
        //                        ResultSetConcurrency.CONCUR_UPDATABLE)) {
        //            Connection conn = getConnection();
        //            try (PreparedStatement prep = conn.prepareStatement(sql, ResultSet.TYPE_FORWARD_ONLY,
        //                    ResultSet.CONCUR_UPDATABLE)) {
        //                setParams(prep, args);
        //                try (ResultSet rs = prep.executeQuery()) {
        //                    T result = null;
        //                    int i = 0;
        //                    while (rs.next()) {
        //                        assertSingleResult(i + 1);
        //                        result = rowMapper.mapRow(new SqlResultSet(rs), i++);
        //                    }
        //                    result = postHandle(execution.setOriginalResult(result));
        //                    // 先确定是否超出一条数据，再来处理游标
        //                    rs.previous();
        //                    int size = setValueOperator.applyAsInt(rs, result);
        //                    return Tuples.of(result, size);
        //                    //                    return setValueOperator.apply(rs,
        //                    //                            postHandle(execution.setOriginalResult(singleResult(list)), sql, args));
        //                }
        //            } catch (SQLException e) {
        //                releaseConnection(conn);
        //                conn = null;
        //                throw new JdbcException(
        //                        Str.format("querySingleUpdate: \nsql: {0} \nargs: {1}", sql, Arrays.toString(args)), e);
        //            } finally {
        //                releaseConnection(conn);
        //            }
        //        } else if (metadata.getFeatures().supportsResultSetConcurrency(ResultSetType.FORWARD_ONLY,
        //                ResultSetConcurrency.CONCUR_UPDATABLE)) {
        //            Connection conn = getConnection();
        //            try (PreparedStatement prep = conn.prepareStatement(sql, ResultSet.TYPE_FORWARD_ONLY,
        //                    ResultSet.CONCUR_UPDATABLE)) {
        //
        //                setParams(prep, args);
        //                try (ResultSet rs = prep.executeQuery()) {
        //                    T result = null;
        //                    int i = 0;
        //                    int size = 0;
        //                    if (rs.next()) {
        //                        result = rowMapper.mapRow(new SqlResultSet(rs), i++);
        //                        result = postHandle(execution.setOriginalResult(result));
        //                        size = setValueOperator.applyAsInt(rs, result);
        //                    }
        //                    // 判断查询的数量，大于1则抛出异常
        //                    while (rs.next()) {
        //                        i++;
        //                    }
        //                    assertSingleResult(i);
        //
        //                    return Tuples.of(result, size);
        //                }
        //            } catch (SQLException e) {
        //                releaseConnection(conn);
        //                conn = null;
        //                throw new JdbcException(
        //                        Str.format("querySingleUpdate: \nsql: {0} \nargs: {1}", sql, Arrays.toString(args)), e);
        //            } finally {
        //                releaseConnection(conn);
        //            }
        //        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> Tuple2<T, Integer> querySingleUpdate(String sql, RowMapper<T> rowMapper,
        ToIntBiFunction<ResultSet, T> setValueOperator, Map<String, Serializable> args) {
        logger.debug("sql -> {}, args -> {}", sql, args);
        Execution execution = SqlUtils.convertNamedParamSql(sql, args);
        return querySingleUpdate(execution.getExecution(), rowMapper, setValueOperator, execution.getParams());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> Tuple2<T, Integer> querySingleUpdate(String sql, Class<T> elementType,
        ToIntBiFunction<ResultSet, T> setValueOperator, Map<String, Serializable> args) {
        return querySingleUpdate(sql, new NestedBeanPropertyRowMapper<>(elementType, manager), setValueOperator, args);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> Tuple2<T, Integer> querySingleUpdate(String sql, Class<T> elementType,
        ToIntBiFunction<ResultSet, T> setValueOperator, Serializable... args) {
        return querySingleUpdate(sql, new NestedBeanPropertyRowMapper<>(elementType, manager), setValueOperator, args);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1, T2> Tuple2<T1, T2> queryUnique(String sql, Class<T1> elementType1, Class<T2> elementType2,
        Tuple2<String, String> prefixes, Serializable... args) {
        return nullableSingleResult(queryList(sql, elementType1, elementType2, prefixes, args));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1, T2, T3> Tuple3<T1, T2, T3> queryUnique(String sql, Class<T1> elementType1, Class<T2> elementType2,
        Class<T3> elementType3, Tuple3<String, String, String> prefixes, Serializable... args) {
        return nullableSingleResult(queryList(sql, elementType1, elementType2, elementType3, prefixes, args));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1, T2, T3, T4> Tuple4<T1, T2, T3, T4> queryUnique(String sql, Class<T1> elementType1,
        Class<T2> elementType2, Class<T3> elementType3, Class<T4> elementType4,
        Tuple4<String, String, String, String> prefixes, Serializable... args) {
        return nullableSingleResult(
            queryList(sql, elementType1, elementType2, elementType3, elementType4, prefixes, args));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1, T2, T3, T4, T5> Tuple5<T1, T2, T3, T4, T5> queryUnique(String sql, Class<T1> elementType1,
        Class<T2> elementType2, Class<T3> elementType3, Class<T4> elementType4, Class<T5> elementType5,
        Tuple5<String, String, String, String, String> prefixes, Serializable... args) {
        return nullableSingleResult(
            queryList(sql, elementType1, elementType2, elementType3, elementType4, elementType5, prefixes, args));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1, T2, T3, T4, T5, T6> Tuple6<T1, T2, T3, T4, T5, T6> queryUnique(String sql, Class<T1> elementType1,
        Class<T2> elementType2, Class<T3> elementType3, Class<T4> elementType4, Class<T5> elementType5,
        Class<T6> elementType6, Tuple6<String, String, String, String, String, String> prefixes, Serializable... args) {
        return nullableSingleResult(queryList(sql, elementType1, elementType2, elementType3, elementType4, elementType5,
            elementType6, prefixes, args));
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public <T> T queryValue(String sql, Map<String, Serializable> args) {
        return (T) queryValue(sql, Object.class, args);
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public <T> T queryValue(String sql, Serializable... args) {
        return (T) queryValue(sql, Object.class, args);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> T queryValue(String sql, Class<T> valueType, Map<String, Serializable> args) {
        return queryValue(sql, new SingleColumnRowMapper<>(valueType, manager), args);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> T queryValue(String sql, Class<T> valueType, Serializable... args) {
        return queryValue(sql, new SingleColumnRowMapper<>(valueType, manager), args);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> T queryValue(String sql, RowMapper<T> rowMapper, Map<String, Serializable> args) {
        logger.debug("sql -> {}, args -> {}", sql, args);
        Execution execution = SqlUtils.convertNamedParamSql(sql, args);
        return queryValue(execution.getExecution(), rowMapper, execution.getParams());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean queryBool(String sql, Serializable... args) {
        boolean result = false;
        sql = Lang.ifNotNull(sql, String::trim);
        if (Lang.isEmpty(sql)) {
            return result;
        }
        JdbcExecution execution = preHandle(sql, args);
        sql = execution.getExecution();
        args = execution.getParams();
        logger.debug("execute sql -> {}\n args -> {}", sql, args);
        Connection con = getConnection();
        try (PreparedStatement prep = con.prepareStatement(sql)) {
            setParams(prep, args);
            try (ResultSet rs = prep.executeQuery()) {
                int i = 0;
                while (rs.next()) {
                    i++;
                    assertSingleResult(i);
                    result = rs.getBoolean(1);
                }
                return postHandle(execution.setOriginalResult(result));
            }
        } catch (SQLException e) {
            releaseConnection(con);
            con = null;
            throw new JdbcException(Str.format("query: \nsql: {0} \nargs: {1}", sql, Arrays.toString(args)), e);
        } finally {
            releaseConnection(con);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean queryBool(String sql, Map<String, Serializable> args) {
        logger.debug("sql -> {}, args -> {}, resultType -> {}", sql, args, boolean.class);
        Execution execution = SqlUtils.convertNamedParamSql(sql, args);
        return queryBool(execution.getExecution(), execution.getParams());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> T queryValue(String sql, RowMapper<T> rowMapper, Serializable... args) {
        List<T> results = queryList(sql, rowMapper, args);
        return nullableSingleResult(results);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public byte queryByte(String sql, Serializable... args) {
        byte result = 0;
        sql = Lang.ifNotNull(sql, String::trim);
        if (Lang.isEmpty(sql)) {
            return result;
        }
        JdbcExecution execution = preHandle(sql, args);
        sql = execution.getExecution();
        args = execution.getParams();
        logger.debug("execute sql -> {}\n args -> {}", sql, args);
        Connection con = getConnection();
        try (PreparedStatement prep = con.prepareStatement(sql)) {
            setParams(prep, args);
            try (ResultSet rs = prep.executeQuery()) {
                int i = 0;
                while (rs.next()) {
                    i++;
                    assertSingleResult(i);
                    result = rs.getByte(1);
                }
                return postHandle(execution.setOriginalResult(result));
            }
        } catch (SQLException e) {
            releaseConnection(con);
            con = null;
            throw new JdbcException(Str.format("query: \nsql: {0} \nargs: {1}", sql, Arrays.toString(args)), e);
        } finally {
            releaseConnection(con);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public byte queryByte(String sql, Map<String, Serializable> args) {
        logger.debug("sql -> {}, args -> {}, resultType -> {}", sql, args, byte.class);
        Execution execution = SqlUtils.convertNamedParamSql(sql, args);
        return queryByte(execution.getExecution(), execution.getParams());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public byte[] queryBytes(String sql, Serializable... args) {
        byte[] result = new byte[0];
        sql = Lang.ifNotNull(sql, String::trim);
        if (Lang.isEmpty(sql)) {
            return result;
        }

        JdbcExecution execution = preHandle(sql, args);
        sql = execution.getExecution();
        args = execution.getParams();
        logger.debug("execute sql -> {}\n args -> {}", sql, args);
        Connection con = getConnection();
        try (PreparedStatement prep = con.prepareStatement(sql)) {
            setParams(prep, args);
            try (ResultSet rs = prep.executeQuery()) {
                int i = 0;
                while (rs.next()) {
                    i++;
                    assertSingleResult(i);
                    result = rs.getBytes(1);
                }
                return postHandle(execution.setOriginalResult(result));
            }
        } catch (SQLException e) {
            releaseConnection(con);
            con = null;
            throw new JdbcException(Str.format("query: \nsql: {0} \nargs: {1}", sql, Arrays.toString(args)), e);
        } finally {
            releaseConnection(con);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public byte[] queryBytes(String sql, Map<String, Serializable> args) {
        logger.debug("sql -> {}, args -> {}, resultType -> {}", sql, args, byte[].class);
        Execution execution = SqlUtils.convertNamedParamSql(sql, args);
        return queryBytes(execution.getExecution(), execution.getParams());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public short queryShort(String sql, Serializable... args) {
        short result = 0;
        sql = Lang.ifNotNull(sql, String::trim);
        if (Lang.isEmpty(sql)) {
            return result;
        }

        JdbcExecution execution = preHandle(sql, args);
        sql = execution.getExecution();
        args = execution.getParams();
        logger.debug("execute sql -> {}\n args -> {}", sql, args);
        Connection con = getConnection();
        try (PreparedStatement prep = con.prepareStatement(sql)) {
            setParams(prep, args);
            try (ResultSet rs = prep.executeQuery()) {
                int i = 0;
                while (rs.next()) {
                    i++;
                    assertSingleResult(i);
                    result = rs.getShort(1);
                }
                return postHandle(execution.setOriginalResult(result));
            }
        } catch (SQLException e) {
            releaseConnection(con);
            con = null;
            throw new JdbcException(Str.format("query: \nsql: {0} \nargs: {1}", sql, Arrays.toString(args)), e);
        } finally {
            releaseConnection(con);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public short queryShort(String sql, Map<String, Serializable> args) {
        logger.debug("sql -> {}, args -> {}, resultType -> {}", sql, args, short.class);
        Execution execution = SqlUtils.convertNamedParamSql(sql, args);
        return queryShort(execution.getExecution(), execution.getParams());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int queryInt(String sql, Serializable... args) {
        int result = 0;
        sql = Lang.ifNotNull(sql, String::trim);
        if (Lang.isEmpty(sql)) {
            return result;
        }
        JdbcExecution execution = preHandle(sql, args);
        sql = execution.getExecution();
        args = execution.getParams();
        logger.debug("execute sql -> {}\n args -> {}", sql, args);
        Connection con = getConnection();
        try (PreparedStatement prep = con.prepareStatement(sql)) {
            setParams(prep, args);
            try (ResultSet rs = prep.executeQuery()) {
                int i = 0;
                while (rs.next()) {
                    i++;
                    assertSingleResult(i);
                    result = rs.getInt(1);
                }
                return postHandle(execution.setOriginalResult(result));
            }
        } catch (SQLException e) {
            releaseConnection(con);
            con = null;
            throw new JdbcException(Str.format("query: \nsql: {0} \nargs: {1}", sql, Arrays.toString(args)), e);
        } finally {
            releaseConnection(con);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int queryInt(String sql, Map<String, Serializable> args) {
        logger.debug("sql -> {}, args -> {}, resultType -> {}", sql, args, int.class);
        Execution execution = SqlUtils.convertNamedParamSql(sql, args);
        return queryInt(execution.getExecution(), execution.getParams());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public long queryLong(String sql, Serializable... args) {
        long result = 0;
        sql = Lang.ifNotNull(sql, String::trim);
        if (Lang.isEmpty(sql)) {
            return result;
        }
        JdbcExecution execution = preHandle(sql, args);
        sql = execution.getExecution();
        args = execution.getParams();
        logger.debug("execute sql -> {}\n args -> {}", sql, args);
        Connection con = getConnection();
        try (PreparedStatement prep = con.prepareStatement(sql)) {
            setParams(prep, args);
            try (ResultSet rs = prep.executeQuery()) {
                int i = 0;
                while (rs.next()) {
                    i++;
                    assertSingleResult(i);
                    result = rs.getLong(1);
                }
                return postHandle(execution.setOriginalResult(result));
            }
        } catch (SQLException e) {
            releaseConnection(con);
            con = null;
            throw new JdbcException(Str.format("query: \nsql: {0} \nargs: {1}", sql, Arrays.toString(args)), e);
        } finally {
            releaseConnection(con);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public long queryLong(String sql, Map<String, Serializable> args) {
        logger.debug("sql -> {}, args -> {}, resultType -> {}", sql, args, long.class);
        Execution execution = SqlUtils.convertNamedParamSql(sql, args);
        return queryLong(execution.getExecution(), execution.getParams());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double queryDouble(String sql, Serializable... args) {
        double result = 0;
        sql = Lang.ifNotNull(sql, String::trim);
        if (Lang.isEmpty(sql)) {
            return result;
        }
        JdbcExecution execution = preHandle(sql, args);
        sql = execution.getExecution();
        args = execution.getParams();
        logger.debug("execute sql -> {}\n args -> {}", sql, args);
        Connection con = getConnection();
        try (PreparedStatement prep = con.prepareStatement(sql)) {
            setParams(prep, args);
            try (ResultSet rs = prep.executeQuery()) {
                int i = 0;
                while (rs.next()) {
                    i++;
                    assertSingleResult(i);
                    result = rs.getDouble(1);
                }
                return postHandle(execution.setOriginalResult(result));
            }
        } catch (SQLException e) {
            releaseConnection(con);
            con = null;
            throw new JdbcException(Str.format("query: \nsql: {0} \nargs: {1}", sql, Arrays.toString(args)), e);
        } finally {
            releaseConnection(con);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double queryDouble(String sql, Map<String, Serializable> args) {
        logger.debug("sql -> {}, args -> {}, resultType -> {}", sql, args, double.class);
        Execution execution = SqlUtils.convertNamedParamSql(sql, args);
        return queryDouble(execution.getExecution(), execution.getParams());
    }

    // ****************************************************************************************************************
    //	call
    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    public int call(String name, Serializable... args) {
        String procedure = getProcedure(name, args.length);
        JdbcExecution execution = preHandle(procedure, args);
        procedure = execution.getExecution();
        args = execution.getParams();
        Connection con = getConnection();
        try (CallableStatement call = con.prepareCall(procedure)) {
            Map<Integer, Class<? extends Serializable>> outParams = setParams(call, args);
            call.execute();
            setOutParams(call, outParams, args);
            postHandle(execution);
            return call.getUpdateCount();
        } catch (SQLException e) {
            releaseConnection(con);
            con = null;
            throw new JdbcException(
                Str.format("call procedure: \nprocedure: {0} \nargs: {1}", procedure, Arrays.toString(args)), e);
        } finally {
            releaseConnection(con);
        }
    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public int call(String name, SequencedMap<String, Serializable> args) {
    //        String procedure = getProcedure(name, args.size());
    //        JdbcExecution execution = preHandle(procedure, args.values().toArray());
    //        procedure = execution.getExecution();
    //        Serializable[] newArgs = execution.getParams();
    //        Connection con = getConnection();
    //        try (CallableStatement call = con.prepareCall(procedure)) {
    //            Map<Integer, Class<?>> outParams = setParams(call, newArgs);
    //            call.execute();
    //            setOutParams(call, outParams, args);
    //            postHandle(execution);
    //            return call.getUpdateCount();
    //        } catch (SQLException e) {
    //            //            releaseConnection(con, dataSource);
    //            releaseConnection(con);
    //            con = null;
    //            throw new JdbcException(
    //                    Str.format("call procedure: \nprocedure: {0} \nargs: {1}", procedure, newArgs.toString()), e);
    //        } finally {
    //            releaseConnection(con);
    //        }
    //    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T extends MutableTuple> int call(String name, T args) {
        String procedure = getProcedure(name, args.degree());
        JdbcExecution execution = preHandle(procedure,
            args.stream().map(opt -> opt.orElse(null)).toArray(n -> new Serializable[n]));
        procedure = execution.getExecution();
        Serializable[] newArgs = execution.getParams();
        Connection con = getConnection();
        try (CallableStatement call = con.prepareCall(procedure)) {
            Map<Integer, Class<? extends Serializable>> outParams = setParams(call, newArgs);
            call.execute();
            setOutParams(call, outParams, args);
            postHandle(execution);
            return call.getUpdateCount();
        } catch (SQLException e) {
            releaseConnection(con);
            con = null;
            throw new JdbcException(
                Str.format("call procedure: \nprocedure: {0} \nargs: {1}", procedure, newArgs.toString()), e);
        } finally {
            releaseConnection(con);
        }
    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //    @SuppressWarnings("rawtypes")
    //    @Override
    //    public int call(String name, Map<String, Serializable> args) {
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
    //                    Str.format("call procedure: \nprocedure: {0} \nargs: {1}", procedure, args.toString()), e);
    //        } finally {
    //            releaseConnection(con, getDataSource());
    //        }
    //    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Map<String, Serializable>> callQuery(String name, Serializable... args) {
        return callQuery(name, new MapRowMapper(manager), args);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> List<T> callQuery(String name, RowMapper<T> rowMapper, Serializable... args) {
        String procedure = getProcedure(name, args.length);
        JdbcExecution execution = preHandle(procedure, args);
        procedure = execution.getExecution();
        args = execution.getParams();
        Connection con = getConnection();
        try (CallableStatement call = con.prepareCall(procedure)) {
            Map<Integer, Class<? extends Serializable>> outParams = setParams(call, args);
            try (ResultSet rs = call.executeQuery()) {
                setOutParams(call, outParams, args);
                //                postHandle(execution, procedure, args);
                List<T> list = new ArrayList<>();
                int i = 0;
                SqlResultSet sqlResultSet = new SqlResultSet(rs);
                while (rs.next()) {
                    list.add(rowMapper.mapRow(sqlResultSet, i++));
                }
                return postHandle(execution.setOriginalResult(list));
            }
        } catch (SQLException e) {
            releaseConnection(con);
            con = null;
            throw new JdbcException(
                Str.format("call procedure query: \nprocedure: {0} \nargs: {1}", procedure, Arrays.toString(args)),
                e);
        } finally {
            releaseConnection(con);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> List<T> callQuery(String name, Class<T> elementType, Serializable... args) {
        return callQuery(name, getTypeMapper(elementType), args);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MulitiQuery callMultiQuery(String name, Serializable... args) {
        String procedure = getProcedure(name, args.length);
        JdbcExecution execution = preHandle(procedure, args);
        procedure = execution.getExecution();
        args = execution.getParams();
        Connection con = getConnection();
        try {
            CallableStatement call = con.prepareCall(procedure);
            Map<Integer, Class<? extends Serializable>> outParams = setParams(call, args);
            call.execute();
            setOutParams(call, outParams, args);
            return new JdbcProcedureMulitiQuery(call, manager, this::getTypeMapper,
                (list) -> postHandle(execution.setOriginalResult(list)));
        } catch (SQLException e) {
            releaseConnection(con);
            con = null;
            throw new JdbcException(
                Str.format("call procedure query: \nprocedure: {0} \nargs: {1}", procedure, Arrays.toString(args)),
                e);
        } finally {
            releaseConnection(con);
        }
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public <T extends Tuple> T callMultiQuery(String name,
        Function<MulitiQueryTupleMapperBuilder, MulitiQueryRowMapper<T>> mapperFunction, Serializable... args) {
        String procedure = getProcedure(name, args.length);
        JdbcExecution execution = preHandle(procedure, args);
        procedure = execution.getExecution();
        args = execution.getParams();
        Connection con = getConnection();
        try {
            CallableStatement call = con.prepareCall(procedure);
            Map<Integer, Class<? extends Serializable>> outParams = setParams(call, args);
            MulitiQueryRowMapper<T> mulitiQueryRowMapper = mapperFunction
                .apply(new MulitiQueryTupleMapperBuilderImpl(this, propertyAccessorFactory));
            RowMapper<?>[] rowMappers = mulitiQueryRowMapper.getRowMappers();

            List<List<?>> all = new ArrayList<>();
            int index = 0;
            try (ResultSet rs = call.executeQuery()) {
                setOutParams(call, outParams, args);
                List<Object> list = extractToList(rs, rowMappers[index]);
                all.add(list);
                index++;
                postHandle(execution.setOriginalResult(list));

                while (call.getMoreResults()) {
                    list = extractToList(call.getResultSet(), rowMappers[index]);
                    all.add(list);
                    index++;
                    postHandle(execution.setOriginalResult(list));
                }
            }
            //            @SuppressWarnings("rawtypes")
            //            List[] listArray = CollectionUtils.toArray(all, List.class);
            //            return (T) Tuples.ofArray(listArray);
            return (T) Tuples.ofArray(all.toArray());
        } catch (SQLException e) {
            releaseConnection(con);
            con = null;
            throw new JdbcException(
                Str.format("call procedure query: \nprocedure: {0} \nargs: {1}", procedure, Arrays.toString(args)),
                e);
        } finally {
            releaseConnection(con);
        }
    }

    private List<Object> extractToList(ResultSet rs, RowMapper<?> rowMapper) throws SQLException {
        SqlResultSet sqlResultSet = new SqlResultSet(rs);
        List<Object> list = new ArrayList<>();
        int row = 0;
        while (rs.next()) {
            list.add(rowMapper.mapRow(sqlResultSet, row));
            row++;
        }
        return list;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1, T2> List<Tuple2<T1, T2>> callQuery(String name, Class<T1> elementType1, Class<T2> elementType2,
        Tuple2<String, String> prefixes, Serializable... args) {
        return callQuery(name,
            new TupleNestedBeanPropertyRowMapper<>(ArrayUtils.toList(elementType1, elementType2), prefixes, manager),
            args);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1, T2, T3> List<Tuple3<T1, T2, T3>> callQuery(String name, Class<T1> elementType1, Class<T2> elementType2,
        Class<T3> elementType3, Tuple3<String, String, String> prefixes, Serializable... args) {
        return callQuery(name, new TupleNestedBeanPropertyRowMapper<>(
            ArrayUtils.toList(elementType1, elementType2, elementType3), prefixes, manager), args);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1, T2, T3, T4> List<Tuple4<T1, T2, T3, T4>> callQuery(String name, Class<T1> elementType1,
        Class<T2> elementType2, Class<T3> elementType3, Class<T4> elementType4,
        Tuple4<String, String, String, String> prefixes, Serializable... args) {
        return callQuery(name, new TupleNestedBeanPropertyRowMapper<>(
            ArrayUtils.toList(elementType1, elementType2, elementType3, elementType4), prefixes, manager), args);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1, T2, T3, T4, T5> List<Tuple5<T1, T2, T3, T4, T5>> callQuery(String name, Class<T1> elementType1,
        Class<T2> elementType2, Class<T3> elementType3, Class<T4> elementType4, Class<T5> elementType5,
        Tuple5<String, String, String, String, String> prefixes, Serializable... args) {
        return callQuery(name,
            new TupleNestedBeanPropertyRowMapper<>(
                ArrayUtils.toList(elementType1, elementType2, elementType3, elementType4, elementType5), prefixes,
                manager),
            args);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Map<String, Serializable> callQuerySingle(String name, Serializable... args) {
        return callQuerySingle(name, new MapRowMapper(manager), args);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> T callQuerySingle(String name, RowMapper<T> rowMapper, Serializable... args) {
        if (Lang.isEmpty(name)) {
            return null;
        }

        String procedure = getProcedure(name, args.length);
        JdbcExecution execution = preHandle(procedure, args);
        procedure = execution.getExecution();
        args = execution.getParams();
        Connection con = getConnection();
        try (CallableStatement call = con.prepareCall(procedure)) {
            Map<Integer, Class<? extends Serializable>> outParams = setParams(call, args);
            try (ResultSet rs = call.executeQuery()) {
                setOutParams(call, outParams, args);
                int i = 0;
                T result = null;
                SqlResultSet sqlResultSet = new SqlResultSet(rs);
                while (rs.next()) {
                    assertSingleResult(i + 1);
                    result = rowMapper.mapRow(sqlResultSet, i++);
                }
                return postHandle(execution.setOriginalResult(result));
            }
        } catch (SQLException e) {
            releaseConnection(con);
            con = null;
            throw new JdbcException(
                Str.format("call procedure query: \nprocedure: {0} \nargs: {1}", procedure, Arrays.toString(args)),
                e);
        } finally {
            releaseConnection(con);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> T callQuerySingle(String name, Class<T> elementType, Serializable... args) {
        return callQuerySingle(name, new NestedBeanPropertyRowMapper<>(elementType, manager), args);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1, T2> Tuple2<T1, T2> callQuerySingle(String name, Class<T1> elementType1, Class<T2> elementType2,
        Tuple2<String, String> prefixes, Serializable... args) {
        return singleResult(callQuery(name, elementType1, elementType2, prefixes, args));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1, T2, T3> Tuple3<T1, T2, T3> callQuerySingle(String name, Class<T1> elementType1, Class<T2> elementType2,
        Class<T3> elementType3, Tuple3<String, String, String> prefixes, Serializable... args) {
        return singleResult(callQuery(name, elementType1, elementType2, elementType3, prefixes, args));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1, T2, T3, T4> Tuple4<T1, T2, T3, T4> callQuerySingle(String name, Class<T1> elementType1,
        Class<T2> elementType2, Class<T3> elementType3, Class<T4> elementType4,
        Tuple4<String, String, String, String> prefixes, Serializable... args) {
        return singleResult(callQuery(name, elementType1, elementType2, elementType3, elementType4, prefixes, args));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1, T2, T3, T4, T5> Tuple5<T1, T2, T3, T4, T5> callQuerySingle(String name, Class<T1> elementType1,
        Class<T2> elementType2, Class<T3> elementType3, Class<T4> elementType4, Class<T5> elementType5,
        Tuple5<String, String, String, String, String> prefixes, Serializable... args) {
        return singleResult(
            callQuery(name, elementType1, elementType2, elementType3, elementType4, elementType5, prefixes, args));
    }

    // ****************************************************************************************************************
    //	execution executor
    // ****************************************************************************************************************

    private String getProcedure(String name, int argnum) {
        AssertIllegalArgument.isNotBlank(name, "procedureName");
        name = name.trim();
        if (name.charAt(0) == '{') {
            return name;
        }
        if (name.length() > 5 && name.charAt(4) == ' ' && name.substring(0, 4).equalsIgnoreCase(CALL)) {
            return name;
        }

        StringBuilder procedure = new StringBuilder();
        procedure.append(CALL).append(" ").append(name).append("(");
        for (int i = 0; i < argnum; i++) {
            procedure.append("?,");
        }
        if (argnum > 0) {
            procedure.deleteCharAt(procedure.length() - 1);
        }
        procedure.append(")");
        return procedure.toString();
    }

    /**
     * Sets the param.
     *
     * @param prep the prep
     * @param index the index
     * @param argu the arg
     */
    protected void setParam(PreparedStatement prep, int index, Serializable argu) {
        if (argu instanceof FieldValueOperator) {
            ((FieldValueOperator<?>) argu).set(prep, index);
        } else if (argu instanceof BeanPropertyValue) {
            @SuppressWarnings("unchecked")
            BeanPropertyValue<?, Serializable> bpv = (BeanPropertyValue<?, Serializable>) argu;
            BeanProperty<?, Serializable> bp = bpv.getBeanProperty();
            manager.set(prep, index, bpv.getValue(), bp);
        } else {
            manager.set(prep, index, argu);
        }
        //            else {
        //            if (argu == null) {
        //                manager.set(prep, index, argu);
        //            } else if (argu instanceof Collection) {
        //                int i = index;
        //                for (Object arg : (Collection<?>) argu) {
        //                    manager.set(prep, i, arg);
        //                    i++;
        //                }
        //                return i > index ? i-- : index;
        //            } else if (argu.getClass().isArray()) {
        //                int i = 0;
        //                for (; i < Array.getLength(argu); i++) {
        //                    Object arg = Array.get(argu, i);
        //                    manager.set(prep, i, arg);
        //                }
        //                return i + index > index ? i + index - 1 : index;
        //            } else {
        //                manager.set(prep, index, argu);
        //            }
        //        }
        //        return index;
    }

    /**
     * Sets the params.
     *
     * @param prep the prep
     * @param args the args
     */
    protected void setParams(PreparedStatement prep, Serializable... args) {
        for (int i = 0; i < args.length; i++) {
            Serializable arg = args[i];
            setParam(prep, i + 1, arg);
        }
    }

    /**
     * Sets the params.
     *
     * @param prep the prep
     * @param args the args
     */
    protected void setParams(PreparedStatement prep,
        @SuppressWarnings("unchecked") BeanPropertyValue<?, Serializable>... args) {
        for (int i = 0; i < args.length; i++) {
            BeanProperty<?, Serializable> argBp = args[i].getBeanProperty();
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
    protected Map<Integer, Class<? extends Serializable>> setParams(CallableStatement call, Serializable... args) {
        Map<Integer, Class<? extends Serializable>> outParamMap = new HashMap<>(0);
        try {
            ParameterMetaData meta = call.getParameterMetaData();
            if (meta.getParameterCount() != args.length) {
                throw new JdbcException(Str.format("procedure parameter count[{0}] not equals args length[{1}]",
                    meta.getParameterCount(), args.length));
            }
            for (int i = 1; i <= args.length; i++) {
                if (meta.isNullable(i) == ParameterMetaData.parameterNoNulls) {
                    throw new JdbcException(Str.format("procedure parameter[{0}] can not be null", i));
                }
                Serializable arg = args[i - 1];
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

    @SuppressWarnings("unchecked")
    private void setOutParamMap(Map<Integer, Class<? extends Serializable>> outParamMap, int index, Serializable arg,
        ParameterMetaData meta) throws SQLException {
        if (arg == null) {
            outParamMap.put(index, (Class<Serializable>) ClassUtils.forName(meta.getParameterClassName(index)));
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
    //    protected Map<String, ProcedureOutParameter> setParams(CallableStatement call, Map<String, Serializable> args) {
    //        return JdbcUtils.setParameters(call, args, manager.isEnumWithOrdinal());
    //    }

    /**
     * Sets the params.
     *
     * @param call the CallableStatement
     * @param outParams the out params
     * @param args the args
     */
    protected void setOutParams(CallableStatement call, Map<Integer, Class<? extends Serializable>> outParams,
        Serializable[] args) {
        for (Entry<Integer, Class<? extends Serializable>> entry : outParams.entrySet()) {
            int index = entry.getKey();
            args[index - 1] = manager.getParam(call, index, entry.getValue());
        }
    }

    //    /**
    //     * Sets the params.
    //     *
    //     * @param call      the CallableStatement
    //     * @param outParams the out params
    //     * @param args      the args
    //     */
    //    protected void setOutParams(CallableStatement call, Map<Integer, Class<?>> outParams,
    //            SequencedMap<String, Serializable> args) {
    //        String[] keys = Lang.toArray(args.keySet());
    //        for (Entry<Integer, Class<?>> entry : outParams.entrySet()) {
    //            int index = entry.getKey();
    //            args.put(keys[index - 1], manager.getParam(call, index, entry.getValue()));
    //        }
    //    }

    /**
     * Sets the params.
     *
     * @param <T> the generic type
     * @param call the CallableStatement
     * @param outParams the out params
     * @param args the args
     */
    protected <T extends MutableTuple> void setOutParams(CallableStatement call,
        Map<Integer, Class<? extends Serializable>> outParams, T args) {
        for (Entry<Integer, Class<? extends Serializable>> entry : outParams.entrySet()) {
            // jdbc parameter index start with 1
            int index = entry.getKey();
            // tuple index start with 0
            args.set(index - 1, manager.getParam(call, index, entry.getValue()));
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

    private JdbcExecution preHandle(String sql, Serializable... params) {
        JdbcExecution jdbcExecution = new JdbcExecution(this, sql, params);
        for (JdbcExecutionInterceptor interceptor : interceptors) {
            interceptor.preHandle(jdbcExecution);
        }
        return jdbcExecution;
    }

    @SuppressWarnings("unchecked")
    private <O> O postHandle(JdbcExecution jdbcExecution) {
        for (JdbcExecutionInterceptor interceptor : interceptors) {
            interceptor.postHandle(jdbcExecution);
        }
        return (O) jdbcExecution.getResult();
    }

    private void throwMoreThanOneResult() {
        throw new JdbcException("results size must be 1, but more than 1");
    }

    private void assertSingleResult(int size) {
        if (size > 1) {
            // ENHANCE 优化错误消息
            throw new JdbcException(Str.format("results size must be 1, but is {0}", size));
        }
    }

    private void assertNullableResult(Object results) {
        if (Lang.isEmpty(results)) {
            // ENHANCE 优化错误消息
            throw new JdbcException("results is empty");
        }
    }

    private <T> T singleResult(Collection<T> results) {
        if (Lang.isEmpty(results)) {
            return null;
        }
        assertSingleResult(results.size());
        return results.iterator().next();
    }

    private <T> T nullableSingleResult(Collection<T> results) {
        assertNullableResult(results);
        assertSingleResult(results.size());
        return results.iterator().next();
    }

    private <T> RowMapper<T> getTypeMapper(Class<T> elementType) {
        if (elementType == Object.class || manager.getSqlType(elementType) != null) {
            return new SingleColumnRowMapper<>(elementType, manager);
        } else {
            return new NestedBeanPropertyRowMapper<>(propertyAccessorFactory.create(elementType), manager);
        }
    }

    /**
     * Release connection.
     *
     * @param res the res
     * @throws SQLException the SQL exception
     */
    protected void releaseConnection(ResultSet res) {
        try {
            releaseConnection(res.getStatement().getConnection());
        } catch (SQLException e) {
            throw new JdbcException(e);
        }
    }

    /**
     * Release connection.
     *
     * @param connection the connection
     */
    protected abstract void releaseConnection(Connection connection);

    /**
     * Gets the connection.
     *
     * @return the connection
     */
    protected abstract Connection getConnection();
}
