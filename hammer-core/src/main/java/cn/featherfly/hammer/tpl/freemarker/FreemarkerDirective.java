
package cn.featherfly.hammer.tpl.freemarker;

import java.util.Map;

import cn.featherfly.common.lang.Strings;
import cn.featherfly.hammer.tpl.TplException;
import cn.featherfly.hammer.tpl.directive.TemplateDirective;
import freemarker.template.TemplateDirectiveModel;
import freemarker.template.TemplateModel;
import freemarker.template.TemplateModelException;
import freemarker.template.TemplateScalarModel;

/**
 * FreemarkerDirective.
 *
 * @author zhongj
 */
public interface FreemarkerDirective extends TemplateDirective, TemplateDirectiveModel {

    default String getStringValue(String tagName, Map<String, TemplateModel> params, String name, boolean nullable)
            throws TemplateModelException {
        TemplateModel paramValue = params.get(name);
        if (paramValue == null) {
            if (nullable) {
                return null;
            } else {
                throw new TplException(
                        Strings.format("The \"{}\" parameter of directive \"{}\" can not be null.", tagName, name));
            }
        }
        if (!(paramValue instanceof TemplateScalarModel)) {
            throw new TplException(
                    Strings.format("The \"{}\" parameter of directive \"{}\" must be a String.", tagName, name));
        }
        return ((TemplateScalarModel) paramValue).getAsString();
    }
}
