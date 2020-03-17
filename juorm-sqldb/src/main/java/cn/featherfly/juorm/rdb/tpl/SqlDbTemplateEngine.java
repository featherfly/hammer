
package cn.featherfly.juorm.rdb.tpl;

import cn.featherfly.juorm.tpl.TemplateEngine;
import cn.featherfly.juorm.tpl.directive.TemplateDirective;
import cn.featherfly.juorm.tpl.method.TemplateMethod;

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
