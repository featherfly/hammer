
package cn.featherfly.hammer.sqldb.tpl;

import cn.featherfly.hammer.tpl.TemplateEngine;
import cn.featherfly.hammer.tpl.directive.TemplateDirective;
import cn.featherfly.hammer.tpl.method.TemplateMethod;

/**
 * SqlDbTemplateEngine.
 *
 * @author zhongj
 * @param <D> the generic type
 * @param <M> the generic type
 */
public interface SqlDbTemplateEngine<D extends TemplateDirective, M extends TemplateMethod>
    extends TemplateEngine<SqlDbTemplateProcessEnv<D, M>, D, M> {

}
