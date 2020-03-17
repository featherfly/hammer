
package cn.featherfly.hammer.sqldb.tpl;

import cn.featherfly.hammer.tpl.TemplateEngine;
import cn.featherfly.hammer.tpl.directive.TemplateDirective;
import cn.featherfly.hammer.tpl.method.TemplateMethod;

/**
 * <p>
 * SqlDbTemplateEngine
 * </p>
 *
 * @author zhongj
 */
public interface SqlDbTemplateEngine<D extends TemplateDirective, M extends TemplateMethod>
        extends TemplateEngine<SqlDbTemplateProcessEnv<D, M>, D, M> {

}
