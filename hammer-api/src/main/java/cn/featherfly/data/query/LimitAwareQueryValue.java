
package cn.featherfly.data.query;

/**
 * limit aware query.
 *
 * @author zhongj
 */
public interface LimitAwareQueryValue extends QueryValueLimitExecutor, QueryCountExecutor, QueryMapperLimitedSetter1 {
}
