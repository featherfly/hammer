
package cn.featherfly.juorm.rdb.tpl.freemarker.directive;

import java.io.IOException;
import java.io.Writer;
import java.util.Map;

import cn.featherfly.juorm.rdb.sql.dialect.Dialect;
import cn.featherfly.juorm.tpl.directive.WrapDirective;
import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateDirectiveModel;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;
import freemarker.template.TemplateModelException;
import freemarker.template.TemplateScalarModel;

/**
 * <p>
 * WhereTemplateDirectiveModel
 * </p>
 *
 * @author zhongj
 */
public class WrapTemplateDirectiveModel implements TemplateDirectiveModel, WrapDirective {

    private Dialect dialect;

    /**
     * @param dialect
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
        Writer out = env.getOut();
        out.write(dialect.wrapName(value));
    }

    private String getValue(Map<String, TemplateModel> params) throws TemplateModelException {
        String value;
        TemplateModel paramValue = params.get(PARAM_NAME_VALUE);
        if (paramValue == null) {
            throw new TemplateModelException("The \"" + PARAM_NAME_VALUE + "\" parameter " + "can not be null.");
        }
        if (!(paramValue instanceof TemplateScalarModel)) {
            throw new TemplateModelException("The \"" + PARAM_NAME_VALUE + "\" parameter " + "must be a String.");
        }
        value = ((TemplateScalarModel) paramValue).getAsString();
        return value;
    }

}
