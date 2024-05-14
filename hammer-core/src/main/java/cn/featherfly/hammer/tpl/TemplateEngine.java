
package cn.featherfly.hammer.tpl;

import java.util.Map;

import cn.featherfly.hammer.tpl.directive.TemplateDirective;
import cn.featherfly.hammer.tpl.method.TemplateMethod;

/**
 * <p>
 * TemplateEngine
 * </p>
 *
 * @author zhongj
 */
public interface TemplateEngine<T extends TemplateProcessEnv<D, M>, D extends TemplateDirective,
        M extends TemplateMethod> {
    /**
     * create template and process.
     *
     * @param templateName templateName
     * @param sourceCode   sourceCode
     * @param params       params
     * @param templateEnv  templateEnv
     * @return template processed result
     */
    String process(String templateName, String sourceCode, Map<String, Object> params,
            TemplateProcessEnv<D, M> templateEnv);

    /**
     * Put template.
     *
     * @param templateName    the template name
     * @param templateContent the template content
     */
    void putTemplate(String templateName, String templateContent);

    /**
     * create template env to process
     *
     * @return TemplateEnv
     */
    T createTemplateProcessEnv();
}
