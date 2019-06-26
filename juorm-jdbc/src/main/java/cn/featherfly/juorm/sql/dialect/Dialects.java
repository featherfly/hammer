
package cn.featherfly.juorm.sql.dialect;

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
