
package cn.featherfly.hammer.tpl.freemarker;

import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.featherfly.hammer.HammerException;
import cn.featherfly.hammer.tpl.TemplateEngine;
import cn.featherfly.hammer.tpl.TemplateProcessEnv;
import cn.featherfly.hammer.tpl.TplConfigFactory;
import cn.featherfly.hammer.tpl.TplExecuteConfig;
import freemarker.cache.StringTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

/**
 * <p>
 * AbstractFreemarkerTemplateEngine
 * </p>
 *
 * @author zhongj
 */
public abstract class AbstractFreemarkerTemplateEngine<
        T extends TemplateProcessEnv<FreemarkerDirective, FreemarkerMethod>>
        implements TemplateEngine<T, FreemarkerDirective, FreemarkerMethod> {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    private Configuration cfg;

    /**
     * @param configFactory TplConfigFactory
     */
    public AbstractFreemarkerTemplateEngine(TplConfigFactory configFactory) {
        cfg = new Configuration(Configuration.VERSION_2_3_28);
        cfg.setDefaultEncoding("UTF-8");
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);

        StringTemplateLoader templateLoader = new StringTemplateLoader();
        configFactory.getAllConfigs().forEach(configs -> {
            configs.values().forEach(c -> {
                TplExecuteConfig config = (TplExecuteConfig) c;
                logger.debug("put template name: {}", config.getTplName());
                templateLoader.putTemplate(config.getTplName(), config.getQuery());
            });
        });
        cfg.setTemplateLoader(templateLoader);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String process(String templateName, String sourceCode, Map<String, Object> params,
            TemplateProcessEnv<FreemarkerDirective, FreemarkerMethod> templateProcessEnv) {
        logger.debug("execute template name : {}", templateName);
        Map<String, Object> root = new HashMap<>();
        root.putAll(params);
        templateProcessEnv.createDirectives().getDirectiveMapAfterCheck().forEach((k, v) -> {
            root.put(k, v);
        });
        templateProcessEnv.createMethods().getMethodeMapAfterCheck().forEach((k, v) -> {
            root.put(k, v);
        });
        try {
            StringWriter stringWriter = new StringWriter();
            Template template = new Template(templateName, sourceCode, cfg);
            template.process(root, stringWriter);
            return stringWriter.toString();
        } catch (IOException | TemplateException e) {
            throw new HammerException(e);
        }
    }
}
