
package cn.featherfly.juorm.rdb.sqltpl;

import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import cn.featherfly.common.lang.ClassLoaderUtils;
import cn.featherfly.common.lang.LangUtils;
import cn.featherfly.juorm.rdb.sqltpl.SqlExecute.Type;
import cn.featherfly.juorm.rdb.sqltpl.freemarker.AndTemplateDirectiveModel;
import cn.featherfly.juorm.rdb.sqltpl.freemarker.ConditionParamsManager;
import cn.featherfly.juorm.rdb.sqltpl.freemarker.OrTemplateDirectiveModel;
import cn.featherfly.juorm.rdb.sqltpl.freemarker.WhereTemplateDirectiveModel;
import freemarker.cache.StringTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

/**
 * <p>
 * Config
 * </p>
 * 
 * @author zhongj
 */
public class SqlExecuteConfig extends HashMap<String, Object> {

    private ObjectMapper mapper;

    private Configuration cfg;

    /**
     * 
     */
    private static final long serialVersionUID = -3757923566368519179L;

    private String baseDir;

    /**
     */
    public SqlExecuteConfig() {
        mapper = new ObjectMapper(new YAMLFactory());
        mapper.enable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

        cfg = new Configuration(Configuration.VERSION_2_3_28);
        cfg.setTemplateLoader(new StringTemplateLoader());
        cfg.setDefaultEncoding("UTF-8");

        // cfg.setDirectoryForTemplateLoading(new File(ClassLoaderUtils
        // .getResource("templates", TestTpl.class).getFile()));

        cfg.setTemplateExceptionHandler(
                TemplateExceptionHandler.RETHROW_HANDLER);
    }

    /**
     * 返回baseDir
     * 
     * @return baseDir
     */
    public String getBaseDir() {
        return baseDir;
    }

    /**
     * 设置baseDir
     * 
     * @param baseDir
     *            baseDir
     */
    public void setBaseDir(String baseDir) {
        this.baseDir = baseDir;
    }

    public SqlExecuteConfig readConfig(String fileName) throws IOException {
        SqlExecuteConfig configs = mapper.readerFor(SqlExecuteConfig.class)
                .readValue(ClassLoaderUtils.getResourceAsStream(fileName,
                        SqlExecuteConfig.class));
        SqlExecuteConfig newConfigs = new SqlExecuteConfig();
        configs.forEach((k, v) -> {
            System.out.println("key " + k + " value " + v.getClass() + " " + v);
            SqlExecute config = new SqlExecute();
            if (v instanceof String) {
                config.setQuery(v.toString());
            } else {
                @SuppressWarnings("unchecked")
                Map<String, Object> map = (Map<String, Object>) v;
                if (LangUtils.isNotEmpty(map.get("query"))) {
                    config.setQuery(map.get("query").toString());
                }
                if (LangUtils.isNotEmpty(map.get("count"))) {
                    config.setCount(map.get("count").toString());
                }
                if (LangUtils.isNotEmpty(map.get("type"))) {
                    config.setType(Type.valueOf(map.get("type").toString()));
                }
            }
            System.out.println(config);
            newConfigs.put(k, config);
        });
        return newConfigs;
    }

    private void t() throws IOException {
        /* Create a data-model */

        /* Get the template (uses cache internally) */
        // Template temp = cfg.getTemplate("sql.ftl");

        // String name;
        // String sourceName;
        // Reader reader;
        // Template temp = new Template(null, null, null, cfg);

        /* Merge data-model with template */
        // Writer out = new OutputStreamWriter(System.out);
        // temp.process(root, out);
    }

    private String getSql(String sqlId, Map<String, Object> params)
            throws IOException, TemplateException {

        ConditionParamsManager manager = new ConditionParamsManager();
        Map<String, Object> root = new HashMap<>();
        root.putAll(params);

        root.put("where", new WhereTemplateDirectiveModel());
        root.put("and", new AndTemplateDirectiveModel(manager));
        root.put("or", new OrTemplateDirectiveModel(manager));

        String templateSql = null;
        // TODO 通过sqlId从配置中找到查询templateSql

        StringWriter stringWriter = new StringWriter();
        Template template = new Template(sqlId, templateSql, cfg);
        template.process(root, stringWriter);
        return stringWriter.toString();
    }
}
