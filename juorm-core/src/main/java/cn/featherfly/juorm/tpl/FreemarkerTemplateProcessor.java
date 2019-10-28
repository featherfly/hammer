
package cn.featherfly.juorm.tpl;

import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.featherfly.juorm.JuormException;
import freemarker.cache.StringTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateDirectiveModel;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import freemarker.template.TemplateMethodModelEx;

/**
 * <p>
 * FreemarkerTemplateProxy
 * </p>
 *
 * @author zhongj
 */
public class FreemarkerTemplateProcessor implements TemplateProcessor<TemplateDirectiveModel, TemplateMethodModelEx> {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    private Configuration cfg;

    /**
     * @param configFactory TplConfigFactory
     */
    public FreemarkerTemplateProcessor(TplConfigFactory configFactory) {
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
            TemplateEnv<TemplateDirectiveModel, TemplateMethodModelEx> templateFacotry) {
        logger.debug("execute template name : {}", templateName);
        Map<String, Object> root = new HashMap<>();
        root.putAll(params);
        templateFacotry.createDirectives().getDirectiveMapAfterCheck().forEach((k, v) -> {
            root.put(k, v);
        });
        templateFacotry.createMethods().getMethodeMapAfterCheck().forEach((k, v) -> {
            root.put(k, v);
        });
        try {
            StringWriter stringWriter = new StringWriter();
            Template template = new Template(templateName, sourceCode, cfg);
            template.process(root, stringWriter);
            return stringWriter.toString();
        } catch (IOException | TemplateException e) {
            throw new JuormException(e);
        }
    }
}
