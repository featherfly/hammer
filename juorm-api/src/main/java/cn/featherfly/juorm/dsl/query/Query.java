
package cn.featherfly.juorm.dsl.query;

import cn.featherfly.juorm.dsl.Repository;

/**
 * <p>
 * dsl for query
 * </p>
 *
 * @author zhongj
 */
public interface Query {
    QueryData find(Repository entity);
}
