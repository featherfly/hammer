
package cn.featherfly.hammer.tpl;

import java.util.HashSet;
import java.util.Set;

import cn.featherfly.common.lang.ArrayUtils;

/**
 * The Class TplExecuteConfig.
 *
 * @author zhongj
 */
public class TplExecuteConfig {

    public static final String PARAM_NAMES = "paramNames";
    public static final String IN_PARAM_NAMES = "inParamNames";
    public static final String IN_PARAM_INDEXS = "inParamIndexs";
    public static final String PARAMS_FORMAT = "paramsFormat";

    private String fileName;

    private String fileDirectory;

    private ExecutionType type = ExecutionType.AUTO;

    private String content;

    private String count;

    private Boolean precompile;

    // template name
    private String name;

    // template namespace
    private String namespace;

    // template execute id
    private String executeId;

    private String tplName;

    private String[] paramNames = null;

    private String[] inParamNames = ArrayUtils.EMPTY_STRING_ARRAY;

    private Param[] params = null;

    private Set<Integer> inParamIndexs = new HashSet<>(0);

    private ParamsFormat paramsFormat = ParamsFormat.AUTO;

    // ----------------------------------------------------------------------------------------------------------------

    private boolean included;

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
    public ExecutionType getType() {
        return type;
    }

    /**
     * 设置type.
     *
     * @param type type
     */
    public void setType(ExecutionType type) {
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
     * get inParamNames value
     *
     * @return inParamNames
     */
    public String[] getInParamNames() {
        return inParamNames;
    }

    /**
     * get inParamIndexs value
     *
     * @return inParamIndexs
     */
    public Set<Integer> getInParamIndexs() {
        return inParamIndexs;
    }

    /**
     * set inParamIndexs value
     *
     * @param inParamIndexs inParamIndexs
     */
    public void setInParamIndexs(Set<Integer> inParamIndexs) {
        this.inParamIndexs = inParamIndexs;
    }

    /**
     * set inParamNames value
     *
     * @param inParamNames inParamNames
     */
    public void setInParamNames(String[] inParamNames) {
        this.inParamNames = inParamNames;
    }

    /**
     * get paramsFormat value
     *
     * @return paramsFormat
     */
    public ParamsFormat getParamsFormat() {
        return paramsFormat;
    }

    /**
     * set paramsFormat value
     *
     * @param paramsFormat paramsFormat
     */
    public void setParamsFormat(ParamsFormat paramsFormat) {
        this.paramsFormat = paramsFormat;
    }

    /**
     * get paramNames value
     *
     * @return paramNames
     */
    public String[] getParamNames() {
        return paramNames;
    }

    /**
     * set paramNames value
     *
     * @param paramNames paramNames
     */
    public void setParamNames(String[] paramNames) {
        this.paramNames = paramNames;
    }

    /**
     * get params value
     *
     * @return params
     */
    public Param[] getParams() {
        return params;
    }

    /**
     * get included value
     *
     * @return includes
     */
    public boolean isIncluded() {
        return included;
    }

    /**
     * set included value.
     *
     * @param included the new included
     */
    public void setIncluded(boolean included) {
        this.included = included;
    }

    /**
     * set params value
     *
     * @param params params
     */
    public void setParams(Param[] params) {
        this.params = params;
        Set<String> inNames = new HashSet<>();
        inParamIndexs.clear();
        paramNames = new String[params.length];
        for (int i = 0; i < params.length; i++) {
            Param p = params[i];
            paramNames[i] = p.name;
            if (p.inParam) {
                inNames.add(p.name);
                inParamIndexs.add(i);
            }
        }
        inParamNames = inNames.toArray(new String[inNames.size()]);
    }

    public enum ParamsFormat {
        /**
         * the program automatically decides
         */
        AUTO,
        /**
         * indexd param
         */
        INDEX,
        /**
         * named param
         */
        NAME;
    }

    /**
     * The Class Param.
     *
     * @author zhongj
     */
    public static class Param {

        /**
         * Instantiates a new param.
         *
         * @param name the name
         */
        public Param(String name) {
            this(name, null, false);
        }

        /**
         * Instantiates a new param.
         *
         * @param name        the name
         * @param transverter the transverter
         */
        public Param(String name, String transverter) {
            this(name, transverter, false);
        }

        /**
         * Instantiates a new param.
         *
         * @param name    the name
         * @param inParam the in param
         */
        public Param(String name, boolean inParam) {
            this(name, null, inParam);
        }

        /**
         * Instantiates a new param.
         *
         * @param name        the name
         * @param transverter the transverter
         */
        public Param(String name, String transverter, boolean inParam) {
            super();
            this.name = name;
            this.transverter = transverter;
            this.inParam = inParam;
        }

        private final String name;

        private final String transverter;

        private final boolean inParam;

        /**
         * 返回name.
         *
         * @return name
         */
        public String getName() {
            return name;
        }

        /**
         * get inParam value
         *
         * @return inParam
         */
        public boolean isInParam() {
            return inParam;
        }

        /**
         * 返回transverter.
         *
         * @return transverter
         */
        public String getTransverter() {
            return transverter;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public String toString() {
            return "Param [name=" + name + ", inParam=" + inParam + ", transverter=" + transverter + "]";
        }

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "TplExecuteConfig [fileName=" + fileName + ", fileDirectory=" + fileDirectory + ", tplName=" + tplName
                + ", name=" + name + ", namespace=" + namespace + ", executeId=" + executeId + ", type=" + type
                + ", precompile=" + precompile + ", paramsFormat=" + paramsFormat + ", inParamNames=" + inParamNames
                + ", query=" + content + ", count=" + count + "]";
    }
}
