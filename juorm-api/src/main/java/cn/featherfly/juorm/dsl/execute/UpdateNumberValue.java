
package cn.featherfly.juorm.dsl.execute;

/**
 * <p>
 * update number value
 * </p>
 *
 * @author zhongj
 */
public interface UpdateNumberValue<T extends Number> extends UpdateValue<T> {

    UpdateNumberValue<T> increase(T value);
}
