
package cn.featherfly.juorm.dsl.execute;

/**
 * <p>
 * Update
 * </p>
 *
 * @author zhongj
 */
public interface Update<U extends ExecutableUpdate<U>> {

    U set(String property, Object value);

    <N extends Number> U increase(String property, N value);
}
