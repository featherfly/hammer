
package cn.featherfly.hammer.tpl;

/**
 * The Class TplExecuteConfig.
 *
 * @author zhongj
 */
public class TplExecuteConfig {

    private String fileName;

    private String fileDirectory;

    private String name;

    private TplType type = TplType.AUTO;

    private String content;

    private String count;

    private Boolean precompile;

    private String namespace;

    private String executeId;

    private String tplName;

    /**
     * get content value
     *
     * @return content
     */
    public String getContent() {
        return content;
    }

    /**
     * set content value
     *
     * @param content content
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * 返回count.
     *
     * @return count
     */
    public String getCount() {
        return count;
    }

    /**
     * 设置count.
     *
     * @param count count
     */
    public void setCount(String count) {
        this.count = count;
    }

    /**
     * 返回type.
     *
     * @return type
     */
    public TplType getType() {
        return type;
    }

    /**
     * 设置type.
     *
     * @param type type
     */
    public void setType(TplType type) {
        this.type = type;
    }

    /**
     * 返回name.
     *
     * @return name
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * 设置name.
     *
     * @param name name
     */
    public void setFileName(String name) {
        fileName = name;
    }

    /**
     * 返回name.
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置name.
     *
     * @param name name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 返回directory.
     *
     * @return directory
     */
    public String getFileDirectory() {
        return fileDirectory;
    }

    /**
     * 设置directory.
     *
     * @param directory directory
     */
    public void setFileDirectory(String directory) {
        fileDirectory = directory;
    }

    /**
     * 返回executeId.
     *
     * @return executeId
     */
    public String getExecuteId() {
        return executeId;
    }

    /**
     * 设置executeId.
     *
     * @param executeId executeId
     */
    public void setExecuteId(String executeId) {
        this.executeId = executeId;
    }

    /**
     * 返回tplPath.
     *
     * @return tplPath
     */
    public String getTplName() {
        return tplName;
    }

    /**
     * 设置tplPath.
     *
     * @param tplPath tplPath
     */
    public void setTplName(String tplPath) {
        tplName = tplPath;
    }

    /**
     * get precompile value.
     *
     * @return precompile
     */
    public Boolean getPrecompile() {
        return precompile;
    }

    /**
     * set precompile value.
     *
     * @param precompile precompile
     */
    public void setPrecompile(Boolean precompile) {
        this.precompile = precompile;
    }

    /**
     * Gets the file path.
     *
     * @return the file path
     */
    public String getFilePath() {
        final String extClass = ".class";
        if (fileName.endsWith(extClass)) {
            int i = fileName.length() - extClass.length();
            return new StringBuilder(fileName.replaceAll("\\.", "/")).replace(i, i + 1, ".").toString();
        } else {
            return fileDirectory + "/" + fileName;
        }
    }

    /**
     * get namespace value.
     *
     * @return namespace
     */
    public String getNamespace() {
        return namespace;
    }

    /**
     * set namespace value.
     *
     * @param namespace namespace
     */
    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "TplExecuteConfig [fileName=" + fileName + ", fileDirectory=" + fileDirectory + ", name=" + name
                + ", type=" + type + ", query=" + content + ", count=" + count + ", precompile=" + precompile
                + ", namespace=" + namespace + ", executeId=" + executeId + ", tplName=" + tplName + "]";
    }
}
