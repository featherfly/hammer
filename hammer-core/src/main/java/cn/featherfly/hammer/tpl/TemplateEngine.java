
package cn.featherfly.hammer.tpl;

import java.io.Serializable;
import java.util.Map;

import cn.featherfly.hammer.tpl.directive.TemplateDirective;
import cn.featherfly.hammer.tpl.method.TemplateMethod;

/**
 * TemplateEngine.
 *
 * @author zhongj
 * @param <T> the generic type
 * @param <D> the generic type
 * @param <M> the generic type
 */
public interface TemplateEngine<T extends TemplateProcessEnv<D, M>, D extends TemplateDirective,
    M extends TemplateMethod> {

    /**
     * create template and process.
     *
     * @param templateName templateName
     * @param sourceCode sourceCode
     * @param params params
     * @param templateDirectives the template directives
     * @param templateMethods the template methods
     * @return template processed result
     */
    String process(String templateName, String sourceCode, Map<String, Serializable> params,
        TemplateDirectives<D> templateDirectives, TemplateMethods<M> templateMethods);

    /**
     * Put template.
     *
     * @param templateName the template name
     * @param templateContent the template content
     */
    void putTemplate(String templateName, String templateContent);

    /**
     * create template env to process.
     *
     * @return TemplateEnv
     */
    T createTemplateProcessEnv();
}
