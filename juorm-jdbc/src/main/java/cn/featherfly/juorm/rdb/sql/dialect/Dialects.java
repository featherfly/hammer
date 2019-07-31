
package cn.featherfly.juorm.rdb.sql.dialect;

/**
 * <p>
 * Dialects
 * </p>
 *
 * @author zhongj
 */
public interface Dialects {

    Dialect MYSQL = new MySQLDialect();

    Dialect ORACLE = new OracleDialect();

    Dialect POSTGRESQL = new PostgreSQLDialect();
}
