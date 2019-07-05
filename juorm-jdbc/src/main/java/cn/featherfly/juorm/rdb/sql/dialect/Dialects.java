
package cn.featherfly.juorm.rdb.sql.dialect;

/**
 * <p>
 * Dialects
 * </p>
 * 
 * @author zhongj
 */
public interface Dialects {
    
    Dialect MYSQL = new MySqlDialect();
    
    Dialect ORACLE = new OracleDialect();    
}
