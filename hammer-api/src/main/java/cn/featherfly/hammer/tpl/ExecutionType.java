
package cn.featherfly.hammer.tpl;

/**
 * execution type.
 *
 * @author zhongj
 */
public enum ExecutionType {
    /**
     * auto type. the behaving should be determined by implements.<br>
     * 自动，其行为由具体实现自行决定.
     */
    AUTO,
    /**
     * query type.
     */
    QUERY,
    /**
     * execute type（insert, update, delete and so on）.
     */
    EXECUTE;
}
