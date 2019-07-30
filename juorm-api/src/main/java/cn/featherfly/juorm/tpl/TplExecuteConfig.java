
package cn.featherfly.juorm.tpl;

/**
 * <p>
 * Config
 * </p>
 *
 * @author zhongj
 */
public class TplExecuteConfig {

    public enum Type {
        LIST, PAGE, PAGINATION, EXECUTE
    }

    private String name;

    private String directory;

    private Type type = Type.LIST;

    private String query;

    private String count;

    private boolean export;

    private String executeId;

    /**
     * 返回query
     *
     * @return query
     */
    public String getQuery() {
        return query;
    }

    /**
     * 设置query
     *
     * @param query query
     */
    public void setQuery(String query) {
        this.query = query;
    }

    /**
     * 返回count
     *
     * @return count
     */
    public String getCount() {
        return count;
    }

    /**
     * 设置count
     *
     * @param count count
     */
    public void setCount(String count) {
        this.count = count;
    }

    /**
     * 返回type
     *
     * @return type
     */
    public Type getType() {
        return type;
    }

    /**
     * 设置type
     *
     * @param type type
     */
    public void setType(Type type) {
        this.type = type;
    }

    /**
     * 返回name
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置name
     *
     * @param name name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 返回directory
     *
     * @return directory
     */
    public String getDirectory() {
        return directory;
    }

    /**
     * 设置directory
     *
     * @param directory directory
     */
    public void setDirectory(String directory) {
        this.directory = directory;
    }

    /**
     * 返回export
     *
     * @return export
     */
    public boolean isExport() {
        return export;
    }

    /**
     * 设置export
     *
     * @param export export
     */
    public void setExport(boolean export) {
        this.export = export;
    }

    /**
     * 返回executeId
     *
     * @return executeId
     */
    public String getExecuteId() {
        return executeId;
    }

    /**
     * 设置executeId
     *
     * @param executeId executeId
     */
    public void setExecuteId(String executeId) {
        this.executeId = executeId;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "TplExecuteConfig [name=" + name + ", directory=" + directory + ", type=" + type + ", query=" + query
                + ", count=" + count + ", export=" + export + ", executeId=" + executeId + "]";
    }
}
