
package cn.featherfly.juorm.expression;

/**
 * <p>
 * Repository
 * </p>
 *
 * @author zhongj
 */
public interface Repository {
    /**
     * get repository name
     *
     * @return name
     */
    String name();

    /**
     * get repository name alias
     *
     * @return name alias
     */
    String alias();
}
