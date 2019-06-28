
package cn.featherfly.juorm.dsl.execute;

/**
 * <p>
 * update value
 * </p>
 *
 * @author zhongj
 */
public interface UpdateValue<T> {

    UpdateValue<T> set(T value);
}
