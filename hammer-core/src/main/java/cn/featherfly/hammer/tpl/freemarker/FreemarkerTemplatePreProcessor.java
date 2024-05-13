
package cn.featherfly.hammer.tpl.freemarker;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.featherfly.hammer.config.tpl.TemplateConfig;
import cn.featherfly.hammer.tpl.TemplatePreprocessor;
import cn.featherfly.hammer.tpl.TplExecuteConfig;
import cn.featherfly.hammer.tpl.TplExecuteConfig.ParamsFormat;
import cn.featherfly.hammer.tpl.freemarker.processor.Parser;

/**
 * FreemarkerPreCompiler.
 *
 * @author zhongj
 */
public class FreemarkerTemplatePreProcessor implements TemplatePreprocessor {

    /** The logger. */
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    private TemplateConfig templateConfig;

    /**
     * Instantiates a new freemarker template pre processor.
     *
     * @param templateConfig the template config
     */
    public FreemarkerTemplatePreProcessor(TemplateConfig templateConfig) {
        this.templateConfig = templateConfig;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String process(String value, TplExecuteConfig tplExecuteConfig) {
        Parser parser = new Parser(templateConfig);
        String s = parser.parse(value, tplExecuteConfig);
        if (!templateConfig.isPrecompileNamedParamPlaceholder()) {
            tplExecuteConfig.setParamsFormat(ParamsFormat.INDEX);
        }
        if (logger.isDebugEnabled()) {
            logger.debug("\nsource:\n{}\nresult:\n{}", String.format("    %s", value.replaceAll("\n", "\n        ")),
                    String.format("    %s", s.replaceAll("\n", "\n      ")));
        }
        return s;
    }
}
