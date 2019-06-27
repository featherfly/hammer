
package cn.featherfly.juorm.dsl.query;

/**
 * <p>
 * dsl for query
 * </p>
 *
 * @author zhongj
 */
public interface Query {
    QueryData find(Data repository);
}
