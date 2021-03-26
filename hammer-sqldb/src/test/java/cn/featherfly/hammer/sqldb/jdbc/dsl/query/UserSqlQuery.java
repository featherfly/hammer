
package cn.featherfly.hammer.sqldb.jdbc.dsl.query;

import cn.featherfly.common.db.mapping.JdbcMappingFactory;

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
        return new UserSqlQueryEntity(query.find("user"), mappingFactory);
    }
}
