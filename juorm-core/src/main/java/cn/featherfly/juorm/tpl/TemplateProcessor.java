
package cn.featherfly.juorm.tpl;

import java.util.Map;

/**
 * <p>
 * TemplateFactory
 * </p>
 *
 * @author zhongj
 */
public interface TemplateProcessor<D, M> {
    /**
     * <p>
     * create template and process
     * </p>
     *
     * @param templateName templateName
     * @param sourceCode   sourceCode
     * @param params       params
     * @param templateEnv  templateEnv
     * @return template processed result
     */
    String process(String templateName, String sourceCode, Map<String, Object> params, TemplateEnv<D, M> templateEnv);
}
