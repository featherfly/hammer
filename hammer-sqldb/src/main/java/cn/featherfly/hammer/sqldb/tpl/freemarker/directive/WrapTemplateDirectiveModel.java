
package cn.featherfly.hammer.sqldb.tpl.freemarker.directive;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Map;

import cn.featherfly.common.db.dialect.Dialect;
import cn.featherfly.hammer.tpl.TplException;
import cn.featherfly.hammer.tpl.directive.WrapDirective;
import cn.featherfly.hammer.tpl.freemarker.FreemarkerDirective;
import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;
import freemarker.template.TemplateModelException;
import freemarker.template.TemplateScalarModel;

/**
 * <p>
 * WrapTemplateDirectiveModel
 * </p>
 *
 * @author zhongj
 */
public class WrapTemplateDirectiveModel implements FreemarkerDirective, WrapDirective {

    private Dialect dialect;

    /**
     * @param dialect dialect
     */
    public WrapTemplateDirectiveModel(Dialect dialect) {
        super();
        this.dialect = dialect;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void execute(Environment env, @SuppressWarnings("rawtypes") Map params, TemplateModel[] loopVars,
            TemplateDirectiveBody body) throws TemplateException, IOException {
        @SuppressWarnings("unchecked")
        String value = getValue(params);
        if (value == null) {
            if (body != null) {
                StringWriter stringWriter = new StringWriter();
                body.render(stringWriter);
                value = stringWriter.toString().trim();
            }
        }
        if (value != null) {
            Writer out = env.getOut();
            out.write(dialect.wrapName(value));
        }
    }

    private String getValue(Map<String, TemplateModel> params) throws TemplateModelException {
        String value = null;
        TemplateModel paramValue = params.get(PARAM_NAME_VALUE);
        //        if (paramValue == null) {
        //            throw new TplException("The \"" + PARAM_NAME_VALUE + "\" parameter " + "can not be null.");
        //        }
        if (paramValue != null) {

            if (!(paramValue instanceof TemplateScalarModel)) {
                throw new TplException("The \"" + PARAM_NAME_VALUE + "\" parameter " + "must be a String.");
            }
            value = ((TemplateScalarModel) paramValue).getAsString();
        }
        return value;
    }

}
