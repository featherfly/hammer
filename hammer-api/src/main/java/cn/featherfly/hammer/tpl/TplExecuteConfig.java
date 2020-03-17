
package cn.featherfly.hammer.tpl;

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

    private String fileName;

    private String fileDirectory;

    private String name;

    private Type type = Type.LIST;

    private String query;

    private String count;

    private String executeId;

    private String tplName;

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
    public String getFileName() {
        return fileName;
    }

    /**
     * 设置name
     *
     * @param name name
     */
    public void setFileName(String name) {
        fileName = name;
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
    public String getFileDirectory() {
        return fileDirectory;
    }

    /**
     * 设置directory
     *
     * @param directory directory
     */
    public void setFileDirectory(String directory) {
        fileDirectory = directory;
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
     * 返回tplPath
     *
     * @return tplPath
     */
    public String getTplName() {
        return tplName;
    }

    /**
     * 设置tplPath
     *
     * @param tplPath tplPath
     */
    public void setTplName(String tplPath) {
        tplName = tplPath;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "TplExecuteConfig [fileName=" + fileName + ", fileDirectory=" + fileDirectory + ", name=" + name
                + ", type=" + type + ", query=" + query + ", count=" + count + ", executeId=" + executeId + ", tplName="
                + tplName + "]";
    }
}
