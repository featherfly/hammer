
package cn.featherfly.juorm.rdb.jdbc.tpl;

import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import cn.featherfly.common.lang.ClassLoaderUtils;
import cn.featherfly.common.lang.LangUtils;
import cn.featherfly.juorm.rdb.sqltpl.SqlExecute;
import cn.featherfly.juorm.rdb.sqltpl.SqlExecute.Type;
import cn.featherfly.juorm.rdb.sqltpl.SqlExecuteConfig;
import cn.featherfly.juorm.rdb.sqltpl.freemarker.AndTemplateDirectiveModel;
import cn.featherfly.juorm.rdb.sqltpl.freemarker.ConditionParamsManager;
import cn.featherfly.juorm.rdb.sqltpl.freemarker.OrTemplateDirectiveModel;
import cn.featherfly.juorm.rdb.sqltpl.freemarker.WhereTemplateDirectiveModel;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

/**
 * <p>
 * TestFreemarker
 * </p>
 *
 * @author zhongj
 */
public class TestTpl {

    public static SqlExecute createConfig(String table) {
        SqlExecute config = new SqlExecute();
        config.setQuery("select * from " + table);
        return config;
    }

    @Test
    void config() throws IOException {
        YAMLFactory yamlFactory = new YAMLFactory();
        ObjectMapper mapper = new ObjectMapper(yamlFactory);
        mapper.enable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        SqlExecuteConfig configs = new SqlExecuteConfig();
        configs.put("user", createConfig("user"));
        configs.put("role", createConfig("role"));
        configs.put("permission", createConfig("permission"));
        configs.put("select", "select * from shop");
        String yaml = mapper.writerFor(SqlExecuteConfig.class).writeValueAsString(configs);
        System.out.println(yaml);

        configs = mapper.readerFor(SqlExecuteConfig.class)
                .readValue(ClassLoaderUtils.getResourceAsStream("user.yaml", SqlExecuteConfig.class));

        System.out.println(configs);

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
    }

    @Test
    void template() throws IOException, TemplateException {
        System.out.println(ClassLoaderUtils.getResource("templates", TestTpl.class));

        Configuration cfg = new Configuration(Configuration.VERSION_2_3_28);

        cfg.setDirectoryForTemplateLoading(
                new File(ClassLoaderUtils.getResource("templates", TestTpl.class).getFile()));

        cfg.setDefaultEncoding("UTF-8");

        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);

        /* Create a data-model */
        ConditionParamsManager manager = new ConditionParamsManager();
        Map<String, Object> root = new HashMap<>();
        root.put("where", new WhereTemplateDirectiveModel());
        root.put("and", new AndTemplateDirectiveModel(manager));
        root.put("or", new OrTemplateDirectiveModel(manager));

        root.put("name", "yufei");
        root.put("age", 18);
        root.put("mobile", "1325824");
        root.put("sex", null);

        /* Get the template (uses cache internally) */
        Template temp = cfg.getTemplate("sql.ftl");

        /* Merge data-model with template */
        Writer out = new OutputStreamWriter(System.out);
        StringWriter writer = new StringWriter();
        temp.process(root, writer);
        System.out.println(writer.toString().replaceAll("\\n", ""));

        System.err.println(manager.getParamValuesMap());
    }
}
