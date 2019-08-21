
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
     * 
     * <p>
     * create template and process
     * </p>
     * 
     * @param templateName
     * @param sourceCode
     * @param params
     * @param templateEnv
     * @return template processed result
     */
    String process(String templateName, String sourceCode,
            Map<String, Object> params, TemplateEnv<D, M> templateEnv);
}
