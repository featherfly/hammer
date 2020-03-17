
package cn.featherfly.juorm.sqldb.sql.dialect;

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

    SQLiteDialect SQLITE = new SQLiteDialect();
}
