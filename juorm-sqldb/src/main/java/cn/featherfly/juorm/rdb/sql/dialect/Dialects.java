
package cn.featherfly.juorm.rdb.sql.dialect;

/**
 * <p>
 * Dialects
 * </p>
 *
 * @author zhongj
 */
public interface Dialects {

    MySQLDialect MYSQL = new MySQLDialect();

    OracleDialect ORACLE = new OracleDialect();

    PostgreSQLDialect POSTGRESQL = new PostgreSQLDialect();
}
