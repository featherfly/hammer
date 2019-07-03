
package cn.featherfly.juorm.jdbc;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Date;

import cn.featherfly.common.lang.LangUtils;

/**
 * <p>
 * JdbcRes
 * </p>
 *
 * @author zhongj
 */
public class SqlResultSet implements cn.featherfly.juorm.mapping.ResultSet {

    private ResultSet proxy;

    /**
     * @param proxy java.sql.ResultSet
     */
    public SqlResultSet(ResultSet proxy) {
        super();
        this.proxy = proxy;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getRowNum() {
        try {
            return proxy.getRow();
        } catch (SQLException e) {
            throw new JuormJdbcException(e);
        }
    }

    /**
     * @param columnIndex
     * @return
     * @throws SQLException
     * @see java.sql.ResultSet#getString(int)
     */
    @Override
    public String getString(int columnIndex) {
        try {
            return proxy.getString(columnIndex);
        } catch (SQLException e) {
            throw new JuormJdbcException(e);
        }
    }

    /**
     * @param columnIndex
     * @return
     * @throws SQLException
     * @see java.sql.ResultSet#getByte(int)
     */
    @Override
    public byte getByte(int columnIndex) {
        try {
            return proxy.getByte(columnIndex);
        } catch (SQLException e) {
            throw new JuormJdbcException(e);
        }
    }

    /**
     * @param columnIndex
     * @return
     * @throws SQLException
     * @see java.sql.ResultSet#getInt(int)
     */
    @Override
    public int getInt(int columnIndex) {
        try {
            return proxy.getInt(columnIndex);
        } catch (SQLException e) {
            throw new JuormJdbcException(e);
        }
    }

    /**
     * @param columnIndex
     * @return
     * @throws SQLException
     * @see java.sql.ResultSet#getLong(int)
     */
    @Override
    public long getLong(int columnIndex) {
        try {
            return proxy.getLong(columnIndex);
        } catch (SQLException e) {
            throw new JuormJdbcException(e);
        }
    }

    /**
     * @param columnIndex
     * @return
     * @throws SQLException
     * @see java.sql.ResultSet#getFloat(int)
     */
    @Override
    public float getFloat(int columnIndex) {
        try {
            return proxy.getFloat(columnIndex);
        } catch (SQLException e) {
            throw new JuormJdbcException(e);
        }
    }

    /**
     * @param columnIndex
     * @return
     * @throws SQLException
     * @see java.sql.ResultSet#getDouble(int)
     */
    @Override
    public double getDouble(int columnIndex) {
        try {
            return proxy.getDouble(columnIndex);
        } catch (SQLException e) {
            throw new JuormJdbcException(e);
        }
    }

    /**
     * @param columnIndex
     * @return
     * @throws SQLException
     * @see java.sql.ResultSet#getBytes(int)
     */
    @Override
    public byte[] getBytes(int columnIndex) {
        try {
            return proxy.getBytes(columnIndex);
        } catch (SQLException e) {
            throw new JuormJdbcException(e);
        }
    }

    /**
     * @param columnIndex
     * @return
     * @throws SQLException
     * @see java.sql.ResultSet#getDate(int)
     */
    @Override
    public Date getDate(int columnIndex) {
        try {
            return proxy.getDate(columnIndex);
        } catch (SQLException e) {
            throw new JuormJdbcException(e);
        }
    }

    /**
     * @param columnLabel
     * @return
     * @throws SQLException
     * @see java.sql.ResultSet#getString(java.lang.String)
     */
    @Override
    public String getString(String columnLabel) {
        try {
            return proxy.getString(columnLabel);
        } catch (SQLException e) {
            throw new JuormJdbcException(e);
        }
    }

    /**
     * @param columnLabel
     * @return
     * @throws SQLException
     * @see java.sql.ResultSet#getByte(java.lang.String)
     */
    @Override
    public byte getByte(String columnLabel) {
        try {
            return proxy.getByte(columnLabel);
        } catch (SQLException e) {
            throw new JuormJdbcException(e);
        }
    }

    /**
     * @param columnLabel
     * @return
     * @throws SQLException
     * @see java.sql.ResultSet#getInt(java.lang.String)
     */
    @Override
    public int getInt(String columnLabel) {
        try {
            return proxy.getInt(columnLabel);
        } catch (SQLException e) {
            throw new JuormJdbcException(e);
        }
    }

    /**
     * @param columnLabel
     * @return
     * @throws SQLException
     * @see java.sql.ResultSet#getLong(java.lang.String)
     */
    @Override
    public long getLong(String columnLabel) {
        try {
            return proxy.getLong(columnLabel);
        } catch (SQLException e) {
            throw new JuormJdbcException(e);
        }
    }

    /**
     * @param columnLabel
     * @return
     * @throws SQLException
     * @see java.sql.ResultSet#getFloat(java.lang.String)
     */
    @Override
    public float getFloat(String columnLabel) {
        try {
            return proxy.getFloat(columnLabel);
        } catch (SQLException e) {
            throw new JuormJdbcException(e);
        }
    }

    /**
     * @param columnLabel
     * @return
     * @throws SQLException
     * @see java.sql.ResultSet#getDouble(java.lang.String)
     */
    @Override
    public double getDouble(String columnLabel) {
        try {
            return proxy.getDouble(columnLabel);
        } catch (SQLException e) {
            throw new JuormJdbcException(e);
        }
    }

    /**
     * @param columnLabel
     * @return
     * @throws SQLException
     * @see java.sql.ResultSet#getBytes(java.lang.String)
     */
    @Override
    public byte[] getBytes(String columnLabel) {
        try {
            return proxy.getBytes(columnLabel);
        } catch (SQLException e) {
            throw new JuormJdbcException(e);
        }
    }

    /**
     * @param columnLabel
     * @return
     * @throws SQLException
     * @see java.sql.ResultSet#getDate(java.lang.String)
     */
    @Override
    public Date getDate(String columnLabel) {
        try {
            return proxy.getDate(columnLabel);
        } catch (SQLException e) {
            throw new JuormJdbcException(e);
        }
    }

    /**
     * @param columnIndex
     * @return
     * @throws SQLException
     * @see java.sql.ResultSet#getObject(int)
     */
    @Override
    public Object getObject(int columnIndex) {
        try {
            return proxy.getObject(columnIndex);
        } catch (SQLException e) {
            throw new JuormJdbcException(e);
        }
    }

    /**
     * @param columnLabel
     * @return
     * @throws SQLException
     * @see java.sql.ResultSet#getObject(java.lang.String)
     */
    @Override
    public Object getObject(String columnLabel) {
        try {
            return proxy.getObject(columnLabel);
        } catch (SQLException e) {
            throw new JuormJdbcException(e);
        }
    }

    /**
     * @param columnIndex
     * @return
     * @throws SQLException
     * @see java.sql.ResultSet#getBigDecimal(int)
     */
    @Override
    public BigDecimal getBigDecimal(int columnIndex) {
        try {
            return proxy.getBigDecimal(columnIndex);
        } catch (SQLException e) {
            throw new JuormJdbcException(e);
        }
    }

    /**
     * @param columnLabel
     * @return
     * @throws SQLException
     * @see java.sql.ResultSet#getBigDecimal(java.lang.String)
     */
    @Override
    public BigDecimal getBigDecimal(String columnLabel) {
        try {
            return proxy.getBigDecimal(columnLabel);
        } catch (SQLException e) {
            throw new JuormJdbcException(e);
        }
    }

    /**
     * @param <T>
     * @param columnIndex
     * @param type
     * @return
     * @throws SQLException
     * @see java.sql.ResultSet#getObject(int, java.lang.Class)
     */
    @Override
    public <T> T getObject(int columnIndex, Class<T> type) {
        try {
            return proxy.getObject(columnIndex, type);
        } catch (SQLException e) {
            throw new JuormJdbcException(e);
        }
    }

    /**
     * @param <T>
     * @param columnLabel
     * @param type
     * @return
     * @throws SQLException
     * @see java.sql.ResultSet#getObject(java.lang.String, java.lang.Class)
     */
    @Override
    public <T> T getObject(String columnLabel, Class<T> type) {
        try {
            return proxy.getObject(columnLabel, type);
        } catch (SQLException e) {
            throw new JuormJdbcException(e);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T extends Enum<T>> T getEnum(int index, Class<T> type) {
        try {
            if (proxy.getType() == Types.INTEGER || proxy.getType() == Types.TINYINT
                    || proxy.getType() == Types.SMALLINT) {
                return LangUtils.toEnum(type, proxy.getInt(index));
            } else if (proxy.getType() == Types.VARCHAR || proxy.getType() == Types.NVARCHAR
                    || proxy.getType() == Types.CHAR || proxy.getType() == Types.NCHAR
                    || proxy.getType() == Types.LONGVARCHAR || proxy.getType() == Types.LONGNVARCHAR) {
                return LangUtils.toEnum(type, proxy.getString(index));
            }
            // TODO 标准化
            throw new JuormJdbcException("can not convert type " + proxy.getType() + " to enum " + type.getName());
        } catch (SQLException e) {
            throw new JuormJdbcException(e);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T extends Enum<T>> T getEnum(String name, Class<T> type) {
        try {
            if (proxy.getType() == Types.INTEGER || proxy.getType() == Types.TINYINT
                    || proxy.getType() == Types.SMALLINT) {
                return LangUtils.toEnum(type, proxy.getInt(name));
            } else if (proxy.getType() == Types.VARCHAR || proxy.getType() == Types.NVARCHAR
                    || proxy.getType() == Types.CHAR || proxy.getType() == Types.NCHAR
                    || proxy.getType() == Types.LONGVARCHAR || proxy.getType() == Types.LONGNVARCHAR) {
                return LangUtils.toEnum(type, proxy.getString(name));
            }
            // TODO 标准化
            throw new JuormJdbcException("can not convert type " + proxy.getType() + " to enum " + type.getName());
        } catch (SQLException e) {
            throw new JuormJdbcException(e);
        }
    }

}
