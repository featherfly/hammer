
package cn.featherfly.hammer.sqldb.jdbc.dsl.query;

import java.util.Map;

import cn.featherfly.common.db.dialect.Join;
import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.hammer.dsl.query.QueryEntity;
import cn.featherfly.hammer.dsl.query.QueryEntityProperties;

/**
 * <p>
 * SqlQueryEntity
 * </p>
 * .
 *
 * @author zhongj
 */
public interface SqlQueryEntity extends QueryEntity {

    /**
     * <p>
     * 添加select的列
     * </p>
     * .
     *
     * @param <T>          the generic type
     * @param <R>          the generic type
     * @param propertyName propertyName
     * @param aliasName    alias name
     * @return QueryEntityPropertiesExpression
     */
    <T, R> QueryEntityProperties propertyAlias(SerializableFunction<T, R> propertyName, String aliasName);

    /**
     * <p>
     * 添加select的列
     * </p>
     * .
     *
     * @param columnName propertyName
     * @param aliasName  alias name
     * @return QueryEntityPropertiesExpression
     */
    QueryEntityProperties propertyAlias(String columnName, String aliasName);

    /**
     * <p>
     * 批量添加select的列
     * </p>
     * .
     *
     * @param columnNameMap key is columnName, value is asName
     * @return QueryEntityPropertiesExpression
     */
    QueryEntityProperties propertyAlias(Map<String, String> columnNameMap);

    /**
     * Join.
     *
     * @param repositoryName the repository name
     * @return the sql query with on
     */
    @Override
    default SqlQueryWithOn join(String repositoryName) {
        return join(Join.INNER_JOIN, repositoryName);
    }

    /**
     * Join.
     *
     * @param join           the join
     * @param repositoryName the repository name
     * @return the sql query with on
     */
    SqlQueryWithOn join(Join join, String repositoryName);

    //    /**
    //     * Join.
    //     *
    //     * @param <T>            the generic type
    //     * @param repositoryType the repository type
    //     * @return the sql query with on
    //     */
    //    @Override
    //    default <T> SqlQueryWithOn join(Class<T> repositoryType) {
    //        return join(Join.INNER_JOIN, repositoryType);
    //    }

    //    /**
    //     * Join.
    //     *
    //     * @param <T>            the generic type
    //     * @param join           the join
    //     * @param repositoryType the repository type
    //     * @return the sql query with on
    //     */
    //    <T> SqlQueryWithOn join(Join join, Class<T> repositoryType);

}
