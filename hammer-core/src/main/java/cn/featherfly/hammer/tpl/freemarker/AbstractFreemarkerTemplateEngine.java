
package cn.featherfly.hammer.tpl.freemarker;

import java.io.IOException;
import java.io.Serializable;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.featherfly.common.lang.Strings;
import cn.featherfly.hammer.HammerException;
import cn.featherfly.hammer.config.tpl.TemplateConfig;
import cn.featherfly.hammer.debug.TplConfigDebugMessage;
import cn.featherfly.hammer.tpl.TemplateDirectives;
import cn.featherfly.hammer.tpl.TemplateEngine;
import cn.featherfly.hammer.tpl.TemplateMethods;
import cn.featherfly.hammer.tpl.TemplateProcessEnv;
import cn.featherfly.hammer.tpl.TplConfigFactory;
import cn.featherfly.hammer.tpl.TplExecuteConfig;
import freemarker.cache.StringTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

/**
 * AbstractFreemarkerTemplateEngine.
 *
 * @author zhongj
 * @param <T> the generic type
 */
public abstract class AbstractFreemarkerTemplateEngine<
    T extends TemplateProcessEnv<FreemarkerDirective, FreemarkerMethod>>
    implements TemplateEngine<T, FreemarkerDirective, FreemarkerMethod> {

    /** The logger. */
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    private Configuration cfg;

    private StringTemplateLoader templateLoader;

    /**
     * Instantiates a new abstract freemarker template engine.
     *
     * @param configFactory TplConfigFactory
     * @param templateConfig the template config
     * @param sharedTemplateDirectives the shared template directives
     * @param sharedTemplateMethods the shared template methods
     */
    protected AbstractFreemarkerTemplateEngine(TplConfigFactory configFactory, TemplateConfig templateConfig,
        TemplateDirectives<FreemarkerDirective> sharedTemplateDirectives,
        TemplateMethods<FreemarkerMethod> sharedTemplateMethods) {
        cfg = new Configuration(Configuration.VERSION_2_3_31);
        cfg.setDefaultEncoding(templateConfig.getCharset().name());
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);

        for (Entry<String, FreemarkerDirective> e : sharedTemplateDirectives.getDirectiveMapAfterCheck(true)
            .entrySet()) {
            cfg.setSharedVariable(e.getKey(), e.getValue());
        }

        for (Entry<String, FreemarkerMethod> e : sharedTemplateMethods.getMethodeMapAfterCheck(true).entrySet()) {
            cfg.setSharedVariable(e.getKey(), e.getValue());
        }

        templateLoader = new StringTemplateLoader();
        TplConfigDebugMessage configDebugMessage = new TplConfigDebugMessage(logger.isDebugEnabled());

        Map<String, TplExecuteConfig> templateMap = new HashMap<>();
        configFactory.getAllConfigs().forEach(configs -> {
            configs.values().forEach(c -> {
                TplExecuteConfig config = (TplExecuteConfig) c;
                //                configDebugMessage.addConfig(config.getTplName(), config.getExecuteId(), config.getNamespace(),
                //                        config.getFilePath());
                //                TplExecuteConfig tplConfig = templateMap.get(config.getTplName());
                configDebugMessage.addConfig(config.getExecuteId(), config.getName(), config.getNamespace(),
                    config.getFilePath());
                TplExecuteConfig tplConfig = templateMap.get(config.getExecuteId());
                if (tplConfig != null) {
                    throw new HammerException(
                        Strings.format("duplicate template name {0} with {1} , {1}", config.getExecuteId(),
                            config.getFilePath(), tplConfig.getFileDirectory() + "/" + tplConfig.getFileName()));
                }
                templateLoader.putTemplate(config.getExecuteId(), config.getContent());
            });
        });
        //        if (logger.isDebugEnabled()) {
        //            debugMessage.append("---------- template loader load template end ----------");
        //            logger.debug(debugMessage.toString());
        //        }
        logger.debug("\n{}", configDebugMessage);
        cfg.setTemplateLoader(templateLoader);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void putTemplate(String templateName, String templateContent) {
        templateLoader.putTemplate(templateName, templateContent);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String process(String templateName, String sourceCode, Map<String, Serializable> params,
        TemplateDirectives<FreemarkerDirective> templateDirectives, TemplateMethods<FreemarkerMethod> templateMethods) {
        logger.debug("execute template name : {}", templateName);
        Map<String, Object> root = new HashMap<>();
        root.putAll(params);
        templateDirectives.getDirectiveMapAfterCheck(false).forEach((k, v) -> {
            root.put(k, v);
        });
        templateMethods.getMethodeMapAfterCheck(false).forEach((k, v) -> {
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
