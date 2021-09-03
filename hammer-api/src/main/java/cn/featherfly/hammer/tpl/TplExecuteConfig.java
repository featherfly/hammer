
package cn.featherfly.hammer.tpl;

/**
 * <p>
 * Config
 * </p>
 *
 * @author zhongj
 */
public class TplExecuteConfig {

    private String fileName;

    private String fileDirectory;

    private String name;

    private TplType type = TplType.AUTO;

    private String query;

    private String count;

    private Boolean precompile;

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
    public TplType getType() {
        return type;
    }

    /**
     * 设置type
     *
     * @param type type
     */
    public void setType(TplType type) {
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
     * get precompile value
     *
     * @return precompile
     */
    public Boolean getPrecompile() {
        return precompile;
    }

    /**
     * set precompile value
     *
     * @param precompile precompile
     */
    public void setPrecompile(Boolean precompile) {
        this.precompile = precompile;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "TplExecuteConfig [fileName=" + fileName + ", fileDirectory=" + fileDirectory + ", name=" + name
                + ", type=" + type + ", query=" + query + ", count=" + count + ", precompile=" + precompile
                + ", executeId=" + executeId + ", tplName=" + tplName + "]";
    }
}
