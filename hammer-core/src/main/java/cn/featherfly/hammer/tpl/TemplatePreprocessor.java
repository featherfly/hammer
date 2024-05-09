
package cn.featherfly.hammer.tpl;

/**
 * PreCompiler.
 *
 * @author zhongj
 */
@FunctionalInterface
public interface TemplatePreprocessor {

    /**
     * Process.
     *
     * @param template         the template value
     * @param tplExecuteConfig the tpl execute config
     * @return processed template value
     */
    String process(String template, TplExecuteConfig tplExecuteConfig);
}
