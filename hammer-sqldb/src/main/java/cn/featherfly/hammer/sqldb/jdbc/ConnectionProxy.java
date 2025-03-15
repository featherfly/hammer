
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2025-03-16 06:11:16
 * @Copyright: 2025 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.jdbc;

import java.sql.Array;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.NClob;
import java.sql.PreparedStatement;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.SQLXML;
import java.sql.Savepoint;
import java.sql.Statement;
import java.sql.Struct;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;

/**
 * ConnectionProxy.
 *
 * @author zhongj
 */
public class ConnectionProxy implements Connection {

    protected final Connection proxy;

    /**
     * Instantiates a new connection proxy.
     *
     * @param connection the connection
     */
    public ConnectionProxy(Connection connection) {
        super();
        proxy = connection;
    }

    /**
     * Unwrap.
     *
     * @param <T> the generic type
     * @param iface the iface
     * @return the t
     * @throws SQLException the SQL exception
     * @see java.sql.Wrapper#unwrap(java.lang.Class)
     */
    @Override
    public <T> T unwrap(Class<T> iface) throws SQLException {
        return proxy.unwrap(iface);
    }

    /**
     * Checks if is wrapper for.
     *
     * @param iface the iface
     * @return true, if is wrapper for
     * @throws SQLException the SQL exception
     * @see java.sql.Wrapper#isWrapperFor(java.lang.Class)
     */
    @Override
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return proxy.isWrapperFor(iface);
    }

    /**
     * Creates the statement.
     *
     * @return the statement
     * @throws SQLException the SQL exception
     * @see java.sql.Connection#createStatement()
     */
    @Override
    public Statement createStatement() throws SQLException {
        return proxy.createStatement();
    }

    /**
     * Prepare statement.
     *
     * @param sql the sql
     * @return the prepared statement
     * @throws SQLException the SQL exception
     * @see java.sql.Connection#prepareStatement(java.lang.String)
     */
    @Override
    public PreparedStatement prepareStatement(String sql) throws SQLException {
        return proxy.prepareStatement(sql);
    }

    /**
     * Prepare call.
     *
     * @param sql the sql
     * @return the callable statement
     * @throws SQLException the SQL exception
     * @see java.sql.Connection#prepareCall(java.lang.String)
     */
    @Override
    public CallableStatement prepareCall(String sql) throws SQLException {
        return proxy.prepareCall(sql);
    }

    /**
     * Native SQL.
     *
     * @param sql the sql
     * @return the string
     * @throws SQLException the SQL exception
     * @see java.sql.Connection#nativeSQL(java.lang.String)
     */
    @Override
    public String nativeSQL(String sql) throws SQLException {
        return proxy.nativeSQL(sql);
    }

    /**
     * Sets the auto commit.
     *
     * @param autoCommit the new auto commit
     * @throws SQLException the SQL exception
     * @see java.sql.Connection#setAutoCommit(boolean)
     */
    @Override
    public void setAutoCommit(boolean autoCommit) throws SQLException {
        proxy.setAutoCommit(autoCommit);
    }

    /**
     * Gets the auto commit.
     *
     * @return the auto commit
     * @throws SQLException the SQL exception
     * @see java.sql.Connection#getAutoCommit()
     */
    @Override
    public boolean getAutoCommit() throws SQLException {
        return proxy.getAutoCommit();
    }

    /**
     * Commit.
     *
     * @throws SQLException the SQL exception
     * @see java.sql.Connection#commit()
     */
    @Override
    public void commit() throws SQLException {
        proxy.commit();
    }

    /**
     * Rollback.
     *
     * @throws SQLException the SQL exception
     * @see java.sql.Connection#rollback()
     */
    @Override
    public void rollback() throws SQLException {
        proxy.rollback();
    }

    /**
     * Close.
     *
     * @throws SQLException the SQL exception
     * @see java.sql.Connection#close()
     */
    @Override
    public void close() throws SQLException {
        proxy.close();
    }

    /**
     * Checks if is closed.
     *
     * @return true, if is closed
     * @throws SQLException the SQL exception
     * @see java.sql.Connection#isClosed()
     */
    @Override
    public boolean isClosed() throws SQLException {
        return proxy.isClosed();
    }

    /**
     * Gets the meta data.
     *
     * @return the meta data
     * @throws SQLException the SQL exception
     * @see java.sql.Connection#getMetaData()
     */
    @Override
    public DatabaseMetaData getMetaData() throws SQLException {
        return proxy.getMetaData();
    }

    /**
     * Sets the read only.
     *
     * @param readOnly the new read only
     * @throws SQLException the SQL exception
     * @see java.sql.Connection#setReadOnly(boolean)
     */
    @Override
    public void setReadOnly(boolean readOnly) throws SQLException {
        proxy.setReadOnly(readOnly);
    }

    /**
     * Checks if is read only.
     *
     * @return true, if is read only
     * @throws SQLException the SQL exception
     * @see java.sql.Connection#isReadOnly()
     */
    @Override
    public boolean isReadOnly() throws SQLException {
        return proxy.isReadOnly();
    }

    /**
     * Sets the catalog.
     *
     * @param catalog the new catalog
     * @throws SQLException the SQL exception
     * @see java.sql.Connection#setCatalog(java.lang.String)
     */
    @Override
    public void setCatalog(String catalog) throws SQLException {
        proxy.setCatalog(catalog);
    }

    /**
     * Gets the catalog.
     *
     * @return the catalog
     * @throws SQLException the SQL exception
     * @see java.sql.Connection#getCatalog()
     */
    @Override
    public String getCatalog() throws SQLException {
        return proxy.getCatalog();
    }

    /**
     * Sets the transaction isolation.
     *
     * @param level the new transaction isolation
     * @throws SQLException the SQL exception
     * @see java.sql.Connection#setTransactionIsolation(int)
     */
    @Override
    public void setTransactionIsolation(int level) throws SQLException {
        proxy.setTransactionIsolation(level);
    }

    /**
     * Gets the transaction isolation.
     *
     * @return the transaction isolation
     * @throws SQLException the SQL exception
     * @see java.sql.Connection#getTransactionIsolation()
     */
    @Override
    public int getTransactionIsolation() throws SQLException {
        return proxy.getTransactionIsolation();
    }

    /**
     * Gets the warnings.
     *
     * @return the warnings
     * @throws SQLException the SQL exception
     * @see java.sql.Connection#getWarnings()
     */
    @Override
    public SQLWarning getWarnings() throws SQLException {
        return proxy.getWarnings();
    }

    /**
     * Clear warnings.
     *
     * @throws SQLException the SQL exception
     * @see java.sql.Connection#clearWarnings()
     */
    @Override
    public void clearWarnings() throws SQLException {
        proxy.clearWarnings();
    }

    /**
     * Creates the statement.
     *
     * @param resultSetType the result set type
     * @param resultSetConcurrency the result set concurrency
     * @return the statement
     * @throws SQLException the SQL exception
     * @see java.sql.Connection#createStatement(int, int)
     */
    @Override
    public Statement createStatement(int resultSetType, int resultSetConcurrency) throws SQLException {
        return proxy.createStatement(resultSetType, resultSetConcurrency);
    }

    /**
     * Prepare statement.
     *
     * @param sql the sql
     * @param resultSetType the result set type
     * @param resultSetConcurrency the result set concurrency
     * @return the prepared statement
     * @throws SQLException the SQL exception
     * @see java.sql.Connection#prepareStatement(java.lang.String, int, int)
     */
    @Override
    public PreparedStatement prepareStatement(String sql, int resultSetType, int resultSetConcurrency)
        throws SQLException {
        return proxy.prepareStatement(sql, resultSetType, resultSetConcurrency);
    }

    /**
     * Prepare call.
     *
     * @param sql the sql
     * @param resultSetType the result set type
     * @param resultSetConcurrency the result set concurrency
     * @return the callable statement
     * @throws SQLException the SQL exception
     * @see java.sql.Connection#prepareCall(java.lang.String, int, int)
     */
    @Override
    public CallableStatement prepareCall(String sql, int resultSetType, int resultSetConcurrency) throws SQLException {
        return proxy.prepareCall(sql, resultSetType, resultSetConcurrency);
    }

    /**
     * Gets the type map.
     *
     * @return the type map
     * @throws SQLException the SQL exception
     * @see java.sql.Connection#getTypeMap()
     */
    @Override
    public Map<String, Class<?>> getTypeMap() throws SQLException {
        return proxy.getTypeMap();
    }

    /**
     * Sets the type map.
     *
     * @param map the map
     * @throws SQLException the SQL exception
     * @see java.sql.Connection#setTypeMap(java.util.Map)
     */
    @Override
    public void setTypeMap(Map<String, Class<?>> map) throws SQLException {
        proxy.setTypeMap(map);
    }

    /**
     * Sets the holdability.
     *
     * @param holdability the new holdability
     * @throws SQLException the SQL exception
     * @see java.sql.Connection#setHoldability(int)
     */
    @Override
    public void setHoldability(int holdability) throws SQLException {
        proxy.setHoldability(holdability);
    }

    /**
     * Gets the holdability.
     *
     * @return the holdability
     * @throws SQLException the SQL exception
     * @see java.sql.Connection#getHoldability()
     */
    @Override
    public int getHoldability() throws SQLException {
        return proxy.getHoldability();
    }

    /**
     * Sets the savepoint.
     *
     * @return the savepoint
     * @throws SQLException the SQL exception
     * @see java.sql.Connection#setSavepoint()
     */
    @Override
    public Savepoint setSavepoint() throws SQLException {
        return proxy.setSavepoint();
    }

    /**
     * Sets the savepoint.
     *
     * @param name the name
     * @return the savepoint
     * @throws SQLException the SQL exception
     * @see java.sql.Connection#setSavepoint(java.lang.String)
     */
    @Override
    public Savepoint setSavepoint(String name) throws SQLException {
        return proxy.setSavepoint(name);
    }

    /**
     * Rollback.
     *
     * @param savepoint the savepoint
     * @throws SQLException the SQL exception
     * @see java.sql.Connection#rollback(java.sql.Savepoint)
     */
    @Override
    public void rollback(Savepoint savepoint) throws SQLException {
        proxy.rollback(savepoint);
    }

    /**
     * Release savepoint.
     *
     * @param savepoint the savepoint
     * @throws SQLException the SQL exception
     * @see java.sql.Connection#releaseSavepoint(java.sql.Savepoint)
     */
    @Override
    public void releaseSavepoint(Savepoint savepoint) throws SQLException {
        proxy.releaseSavepoint(savepoint);
    }

    /**
     * Creates the statement.
     *
     * @param resultSetType the result set type
     * @param resultSetConcurrency the result set concurrency
     * @param resultSetHoldability the result set holdability
     * @return the statement
     * @throws SQLException the SQL exception
     * @see java.sql.Connection#createStatement(int, int, int)
     */
    @Override
    public Statement createStatement(int resultSetType, int resultSetConcurrency, int resultSetHoldability)
        throws SQLException {
        return proxy.createStatement(resultSetType, resultSetConcurrency, resultSetHoldability);
    }

    /**
     * Prepare statement.
     *
     * @param sql the sql
     * @param resultSetType the result set type
     * @param resultSetConcurrency the result set concurrency
     * @param resultSetHoldability the result set holdability
     * @return the prepared statement
     * @throws SQLException the SQL exception
     * @see java.sql.Connection#prepareStatement(java.lang.String, int, int, int)
     */
    @Override
    public PreparedStatement prepareStatement(String sql, int resultSetType, int resultSetConcurrency,
        int resultSetHoldability) throws SQLException {
        return proxy.prepareStatement(sql, resultSetType, resultSetConcurrency, resultSetHoldability);
    }

    /**
     * Prepare call.
     *
     * @param sql the sql
     * @param resultSetType the result set type
     * @param resultSetConcurrency the result set concurrency
     * @param resultSetHoldability the result set holdability
     * @return the callable statement
     * @throws SQLException the SQL exception
     * @see java.sql.Connection#prepareCall(java.lang.String, int, int, int)
     */
    @Override
    public CallableStatement prepareCall(String sql, int resultSetType, int resultSetConcurrency,
        int resultSetHoldability) throws SQLException {
        return proxy.prepareCall(sql, resultSetType, resultSetConcurrency, resultSetHoldability);
    }

    /**
     * Prepare statement.
     *
     * @param sql the sql
     * @param autoGeneratedKeys the auto generated keys
     * @return the prepared statement
     * @throws SQLException the SQL exception
     * @see java.sql.Connection#prepareStatement(java.lang.String, int)
     */
    @Override
    public PreparedStatement prepareStatement(String sql, int autoGeneratedKeys) throws SQLException {
        return proxy.prepareStatement(sql, autoGeneratedKeys);
    }

    /**
     * Prepare statement.
     *
     * @param sql the sql
     * @param columnIndexes the column indexes
     * @return the prepared statement
     * @throws SQLException the SQL exception
     * @see java.sql.Connection#prepareStatement(java.lang.String, int[])
     */
    @Override
    public PreparedStatement prepareStatement(String sql, int[] columnIndexes) throws SQLException {
        return proxy.prepareStatement(sql, columnIndexes);
    }

    /**
     * Prepare statement.
     *
     * @param sql the sql
     * @param columnNames the column names
     * @return the prepared statement
     * @throws SQLException the SQL exception
     * @see java.sql.Connection#prepareStatement(java.lang.String, java.lang.String[])
     */
    @Override
    public PreparedStatement prepareStatement(String sql, String[] columnNames) throws SQLException {
        return proxy.prepareStatement(sql, columnNames);
    }

    /**
     * Creates the clob.
     *
     * @return the clob
     * @throws SQLException the SQL exception
     * @see java.sql.Connection#createClob()
     */
    @Override
    public Clob createClob() throws SQLException {
        return proxy.createClob();
    }

    /**
     * Creates the blob.
     *
     * @return the blob
     * @throws SQLException the SQL exception
     * @see java.sql.Connection#createBlob()
     */
    @Override
    public Blob createBlob() throws SQLException {
        return proxy.createBlob();
    }

    /**
     * Creates the N clob.
     *
     * @return the n clob
     * @throws SQLException the SQL exception
     * @see java.sql.Connection#createNClob()
     */
    @Override
    public NClob createNClob() throws SQLException {
        return proxy.createNClob();
    }

    /**
     * Creates the SQLXML.
     *
     * @return the sqlxml
     * @throws SQLException the SQL exception
     * @see java.sql.Connection#createSQLXML()
     */
    @Override
    public SQLXML createSQLXML() throws SQLException {
        return proxy.createSQLXML();
    }

    /**
     * Checks if is valid.
     *
     * @param timeout the timeout
     * @return true, if is valid
     * @throws SQLException the SQL exception
     * @see java.sql.Connection#isValid(int)
     */
    @Override
    public boolean isValid(int timeout) throws SQLException {
        return proxy.isValid(timeout);
    }

    /**
     * Sets the client info.
     *
     * @param name the name
     * @param value the value
     * @throws SQLClientInfoException the SQL client info exception
     * @see java.sql.Connection#setClientInfo(java.lang.String, java.lang.String)
     */
    @Override
    public void setClientInfo(String name, String value) throws SQLClientInfoException {
        proxy.setClientInfo(name, value);
    }

    /**
     * Sets the client info.
     *
     * @param properties the new client info
     * @throws SQLClientInfoException the SQL client info exception
     * @see java.sql.Connection#setClientInfo(java.util.Properties)
     */
    @Override
    public void setClientInfo(Properties properties) throws SQLClientInfoException {
        proxy.setClientInfo(properties);
    }

    /**
     * Gets the client info.
     *
     * @param name the name
     * @return the client info
     * @throws SQLException the SQL exception
     * @see java.sql.Connection#getClientInfo(java.lang.String)
     */
    @Override
    public String getClientInfo(String name) throws SQLException {
        return proxy.getClientInfo(name);
    }

    /**
     * Gets the client info.
     *
     * @return the client info
     * @throws SQLException the SQL exception
     * @see java.sql.Connection#getClientInfo()
     */
    @Override
    public Properties getClientInfo() throws SQLException {
        return proxy.getClientInfo();
    }

    /**
     * Creates the array of.
     *
     * @param typeName the type name
     * @param elements the elements
     * @return the array
     * @throws SQLException the SQL exception
     * @see java.sql.Connection#createArrayOf(java.lang.String, java.lang.Object[])
     */
    @Override
    public Array createArrayOf(String typeName, Object[] elements) throws SQLException {
        return proxy.createArrayOf(typeName, elements);
    }

    /**
     * Creates the struct.
     *
     * @param typeName the type name
     * @param attributes the attributes
     * @return the struct
     * @throws SQLException the SQL exception
     * @see java.sql.Connection#createStruct(java.lang.String, java.lang.Object[])
     */
    @Override
    public Struct createStruct(String typeName, Object[] attributes) throws SQLException {
        return proxy.createStruct(typeName, attributes);
    }

    /**
     * Sets the schema.
     *
     * @param schema the new schema
     * @throws SQLException the SQL exception
     * @see java.sql.Connection#setSchema(java.lang.String)
     */
    @Override
    public void setSchema(String schema) throws SQLException {
        proxy.setSchema(schema);
    }

    /**
     * Gets the schema.
     *
     * @return the schema
     * @throws SQLException the SQL exception
     * @see java.sql.Connection#getSchema()
     */
    @Override
    public String getSchema() throws SQLException {
        return proxy.getSchema();
    }

    /**
     * Abort.
     *
     * @param executor the executor
     * @throws SQLException the SQL exception
     * @see java.sql.Connection#abort(java.util.concurrent.Executor)
     */
    @Override
    public void abort(Executor executor) throws SQLException {
        proxy.abort(executor);
    }

    /**
     * Sets the network timeout.
     *
     * @param executor the executor
     * @param milliseconds the milliseconds
     * @throws SQLException the SQL exception
     * @see java.sql.Connection#setNetworkTimeout(java.util.concurrent.Executor, int)
     */
    @Override
    public void setNetworkTimeout(Executor executor, int milliseconds) throws SQLException {
        proxy.setNetworkTimeout(executor, milliseconds);
    }

    /**
     * Gets the network timeout.
     *
     * @return the network timeout
     * @throws SQLException the SQL exception
     * @see java.sql.Connection#getNetworkTimeout()
     */
    @Override
    public int getNetworkTimeout() throws SQLException {
        return proxy.getNetworkTimeout();
    }

}
