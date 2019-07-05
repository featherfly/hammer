
package cn.featherfly.juorm.rdb.sqltpl.freemarker;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Map;

import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateDirectiveModel;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;

/**
 * <p>
 * WhereTemplateDirectiveModel
 * </p>
 * 
 * @author zhongj
 */
public class WhereTemplateDirectiveModel implements TemplateDirectiveModel {

    /**
     * {@inheritDoc}
     */
    @Override
    public void execute(Environment env,
            @SuppressWarnings("rawtypes") Map params, TemplateModel[] loopVars,
            TemplateDirectiveBody body) throws TemplateException, IOException {

        Writer out = env.getOut();
        if (body != null) {
            StringWriter stringWriter = new StringWriter();
            body.render(stringWriter);
            String condition = stringWriter.toString().trim();
            if (condition.length() > 0) {
                out.write(" where ");
                out.write(condition);
            }
        }
    }

}
