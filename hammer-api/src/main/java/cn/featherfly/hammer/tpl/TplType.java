
package cn.featherfly.hammer.tpl;

/**
 * template type.
 *
 * @author zhongj
 */
public enum TplType {
    /**
     * auto template type. the behaving show be be determined by implements.
     * <br/>
     * 自动，其行为由具体实现自行决定.
     */
    AUTO,
    /**
     * query template type.
     */
    QUERY,
    /**
     * execute template type（insert, update, delete and so on）.
     */
    EXECUTE;
}
