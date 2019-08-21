
package cn.featherfly.juorm.tpl;

/**
 * <p>
 * TemplateFacotry
 * </p>
 * 
 * @author zhongj
 */
public interface TemplateEnv<D, M> {

    TemplateDirectives<D> createDirectives();

    TemplateMethods<M> createMethods();

}
