
package cn.featherfly.hammer.expression;

/**
 * Repository.
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
