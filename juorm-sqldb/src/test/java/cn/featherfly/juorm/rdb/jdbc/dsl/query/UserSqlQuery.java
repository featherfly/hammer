
package cn.featherfly.juorm.rdb.jdbc.dsl.query;

import cn.featherfly.juorm.rdb.jdbc.mapping.MappingFactory;

/**
 * <p>
 * UserUpdate
 * </p>
 *
 * @author zhongj
 */
public class UserSqlQuery {

    private SqlQuery query;

    private MappingFactory mappingFactory;

    /**
     * @param query
     * @param mappingFactory
     */
    public UserSqlQuery(SqlQuery query, MappingFactory mappingFactory) {
        super();
        this.query = query;
        this.mappingFactory = mappingFactory;
    }

    public UserSqlQueryEntity find() {
        return new UserSqlQueryEntity(
                (SqlQueryEntityProperties) query.find("user"), mappingFactory);
    }
}
