
package cn.featherfly.juorm.dsl.execute;

/**
 * <p>
 * Update
 * </p>
 *
 * @author zhongj
 */
public interface Update<U extends ExecutableExecutableUpdate<U>> {

    U set(String name, Object value);

    <N extends Number> U increase(String name, N value);
}
