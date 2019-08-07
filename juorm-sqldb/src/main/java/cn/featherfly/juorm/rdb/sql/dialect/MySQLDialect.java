package cn.featherfly.juorm.rdb.sql.dialect;

import java.sql.Types;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.featherfly.common.db.SqlUtils;
import cn.featherfly.common.lang.DateUtils;
import cn.featherfly.common.lang.LangUtils;

/**
 * <p>
 * Mysql数据库方言实现类.
 * </p>
 *
 * @author zhongj
 */
public class MySQLDialect extends AbstractDialect {

    private static final Logger LOGGER = LoggerFactory.getLogger(MySQLDialect.class);

    /**
     */
    MySQLDialect() {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getPaginationSql(String sql, int start, int limit) {
        return getPaginationSql(sql, start, false);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getParamNamedPaginationSql(String sql, int start, int limit) {
        return getPaginationSql(sql, start, true);
    }

    private String getPaginationSql(String sql, int start, boolean isParamNamed) {
        sql = sql.trim();
        boolean isForUpdate = false;
        if (isForUpdate(sql)) {
            sql = sql.substring(0, sql.length() - UPDATE_STRING.length());
            isForUpdate = true;
        }
        final int sqlLengthOffset = 50;
        StringBuilder pagingSelect = new StringBuilder(sql.length() + sqlLengthOffset);
        pagingSelect.append(sql);
        if (isParamNamed) {
            if (start > 0) {
                pagingSelect.append(String.format(" LIMIT :%s,:%s", START_PARAM_NAME, LIMIT_PARAM_NAME));
            } else {
                pagingSelect.append(String.format(" LIMIT :%s", LIMIT_PARAM_NAME));
            }
        } else {
            if (start > 0) {
                pagingSelect.append(" LIMIT ?,?");
            } else {
                pagingSelect.append(" LIMIT ?");
            }
        }
        if (isForUpdate) {
            pagingSelect.append(UPDATE_STRING);
        }
        LOGGER.debug("原始Sql：{}", sql);
        LOGGER.debug("分页Sql：{}", pagingSelect);
        return pagingSelect.toString();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String convertValueToSql(Object value, int sqlType) {
        StringBuilder sqlPart = new StringBuilder();
        if (value == null) {
            sqlPart.append("null");
        } else {
            switch (sqlType) {
                case Types.BIGINT:
                case Types.BIT:
                case Types.BOOLEAN:
                case Types.DECIMAL:
                case Types.DOUBLE:
                case Types.FLOAT:
                case Types.INTEGER:
                case Types.NULL:
                case Types.NUMERIC:
                case Types.TINYINT:
                    sqlPart.append(value);
                    break;
                case Types.DATE:
                case Types.TIME:
                case Types.TIMESTAMP:
                    if (value instanceof Date) {
                        sqlPart.append("'").append(DateUtils.formart((Date) value, "yyyy-MM-dd HH:mm:ss")).append("'");
                    } else {
                        sqlPart.append("'").append(value).append("'");
                        break;
                    }
                    break;
                default:
                    sqlPart.append("'").append(SqlUtils.transferStringForSql(value.toString())).append("'");
                    break;
            }
        }
        return sqlPart.toString();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String wrapName(String name) {
        if (LangUtils.isNotEmpty(name)) {
            return "`" + name + "`";
        }
        return name;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getFkCheck(boolean check) {
        return "SET FOREIGN_KEY_CHECKS=" + (check ? 1 : 0);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String convertTableOrColumnName(String tableOrColumnName) {
        if (LangUtils.isEmpty(tableOrColumnName)) {
            return tableOrColumnName;
        }
        // String result = columnOrTableName;
        // if (isTableAndColumnNameUppercase()) {
        // result = result.toUpperCase();
        // } else {
        // result = result.toLowerCase();
        // }

        return "`" + super.convertTableOrColumnName(tableOrColumnName) + "`";
    }
}