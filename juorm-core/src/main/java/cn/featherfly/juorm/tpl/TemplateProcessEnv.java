
package cn.featherfly.juorm.tpl;

import cn.featherfly.juorm.tpl.directive.TemplateDirective;
import cn.featherfly.juorm.tpl.method.TemplateMethod;

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
