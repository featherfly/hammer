
package cn.featherfly.juorm.sqldb.jdbc.dsl.query;

import cn.featherfly.juorm.sqldb.jdbc.dsl.query.SqlQuery;
import cn.featherfly.juorm.sqldb.jdbc.dsl.query.SqlQueryEntityProperties;
import cn.featherfly.juorm.sqldb.jdbc.mapping.JdbcMappingFactory;

/**
 * <p>
 * UserUpdate
 * </p>
 *
 * @author zhongj
 */
public class UserSqlQuery {

    private SqlQuery query;

    private JdbcMappingFactory mappingFactory;

    /**
     * @param query
     * @param mappingFactory
     */
    public UserSqlQuery(SqlQuery query, JdbcMappingFactory mappingFactory) {
        super();
        this.query = query;
        this.mappingFactory = mappingFactory;
    }

    public UserSqlQueryEntity find() {
        return new UserSqlQueryEntity(
                (SqlQueryEntityProperties) query.find("user"), mappingFactory);
    }
}
