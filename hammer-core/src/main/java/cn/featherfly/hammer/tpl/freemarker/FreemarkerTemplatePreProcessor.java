
package cn.featherfly.hammer.tpl.freemarker;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.featherfly.hammer.tpl.TemplatePreprocessor;
import cn.featherfly.hammer.tpl.freemarker.processor.Parser;

/**
 * <p>
 * FreemarkerPreCompiler
 * </p>
 *
 * @author zhongj
 */
public class FreemarkerTemplatePreProcessor implements TemplatePreprocessor {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * {@inheritDoc}
     */
    @Override
    public String process(String value) {
        Parser parser = new Parser();
        String s = parser.parse(value);
        //        StringBuilder result = new StringBuilder();
        //        for (AbstractElement abstractElement : parser.getElements()) {
        //            result.append(abstractElement.getValue());
        //        }
        //        String s = result.toString();
        if (logger.isDebugEnabled()) {
            logger.debug("\nsource:\n{}\nresult:\n{}", String.format("    %s", value.replaceAll("\n", "\n        ")),
                    String.format("    %s", s.replaceAll("\n", "\n      ")));
        }
        return s;
    }
}
