
package cn.featherfly.hammer.sqldb.tpl.freemarker.directive;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Map;
import java.util.regex.Pattern;

import cn.featherfly.common.lang.Dates;
import cn.featherfly.hammer.tpl.TplException;
import cn.featherfly.hammer.tpl.directive.StringReplaceDirective;
import cn.featherfly.hammer.tpl.freemarker.FreemarkerDirective;
import freemarker.core.Environment;
import freemarker.template.TemplateBooleanModel;
import freemarker.template.TemplateDateModel;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;
import freemarker.template.TemplateModelException;
import freemarker.template.TemplateNumberModel;
import freemarker.template.TemplateScalarModel;

/**
 * StringReplaceDirectiveModel.
 *
 * @author zhongj
 */
public class StringReplaceDirectiveModel implements FreemarkerDirective, StringReplaceDirective {

    private static Pattern VALID = Pattern.compile("\\w+");

    /**
     * Instantiates a new string replace template directive model.
     */
    public StringReplaceDirectiveModel() {
        super();
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
            assertValid(value);
            Writer out = env.getOut();
            out.write(value);
        }
    }

    private String getValue(Map<String, TemplateModel> params) throws TemplateModelException {
        String value = null;
        TemplateModel paramValue = params.get(PARAM_NAME_VALUE);
        if (paramValue != null) {
            if (paramValue instanceof TemplateScalarModel) {
                value = ((TemplateScalarModel) paramValue).getAsString();
            } else if (paramValue instanceof TemplateNumberModel) {
                value = ((TemplateNumberModel) paramValue).getAsNumber().toString();
            } else if (paramValue instanceof TemplateBooleanModel) {
                value = ((TemplateBooleanModel) paramValue).getAsBoolean() + "";
            } else if (paramValue instanceof TemplateDateModel) {
                value = Dates.formatDate(((TemplateDateModel) paramValue).getAsDate());
            } else {
                throw new TplException(
                    "The \"" + PARAM_NAME_VALUE + "\" parameter " + "must be a [String|Number|Boolean|Date].");
            }
        }
        return value;
    }

    /**
     * Assert valid.
     *
     * @param value the value
     */
    public static void assertValid(String value) {
        if (!VALID.matcher(value).matches()) {
            throw new TplException("invalid string [ " + value + " ], please use [a-zA-Z_]");
        }
    }
}
