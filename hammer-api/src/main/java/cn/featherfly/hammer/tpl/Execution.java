
package cn.featherfly.hammer.tpl;

/**
 * <p>
 * Statement
 * </p>
 *
 * @author zhongj
 */
public interface Execution {
    /**
     * 返回Execute String
     *
     * @return Execute String
     */
    String getExecute();

    /**
     * 返回params
     *
     * @return params
     */
    Object[] getParams();
}
