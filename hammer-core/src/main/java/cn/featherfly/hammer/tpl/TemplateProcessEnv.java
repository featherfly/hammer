
package cn.featherfly.hammer.tpl;

import cn.featherfly.hammer.tpl.directive.TemplateDirective;
import cn.featherfly.hammer.tpl.method.TemplateMethod;

/**
 * <p>
 * TemplateFacotry
 * </p>
 *
 * @author zhongj
 */
public interface TemplateProcessEnv<D extends TemplateDirective, M extends TemplateMethod> {
    /**
     * create directives
     *
     * @return TemplateDirectives
     */
    TemplateDirectives<D> createDirectives();

    /**
     * create methods
     *
     * @return TemplateMethods
     */
    TemplateMethods<M> createMethods();

}
