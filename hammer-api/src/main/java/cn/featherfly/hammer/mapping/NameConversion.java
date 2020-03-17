
package cn.featherfly.hammer.mapping;

/**
 * <p>
 * name conversion
 * </p>
 *
 * @author zhongj
 */
public interface NameConversion<T> {
    /**
     * <p>
     * convert type to mapping name
     * </p>
     *
     * @param type type
     * @return mapping name
     */
    String getMappingName(T type);
}
