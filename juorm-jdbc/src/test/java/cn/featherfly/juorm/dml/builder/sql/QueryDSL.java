
package cn.featherfly.juorm.dml.builder.sql;

import cn.featherfly.juorm.dml.builder.QueryBuilder;
import cn.featherfly.juorm.sql.dml.builder.SqlQueryBuilder;

/**
 * <p>
 * DSLRunner
 * </p>
 * 
 * @author zhongj
 */
public class QueryDSL<E> {

    private QueryBuilder queryBuilder;
    
//    private JdbcTemplate jdbcTemplate;
    
    public <E> E list() {
        QueryBuilder queryBuilder = new SqlQueryBuilder();
        return null;
    }
    
    public <E> E single() {
        QueryBuilder queryBuilder = new SqlQueryBuilder();
        return null;
        
        /*
           query
               .find("user")
               .with("name", "age")               
                .filer()
                .sort()
                .
           query
               .select()
               .from()
                .
         */
    }
}
