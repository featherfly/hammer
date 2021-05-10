
package cn.featherfly.hammer.sqldb.tpl.freemarker.directive;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Map;

import cn.featherfly.hammer.tpl.directive.WhereDirective;
import cn.featherfly.hammer.tpl.freemarker.FreemarkerDirective;
import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;

/**
 * <p>
 * WhereTemplateDirectiveModel
 * </p>
 *
 * @author zhongj
 */
public class WhereTemplateDirectiveModel implements FreemarkerDirective, WhereDirective {

    /**
     * {@inheritDoc}
     */
    @Override
    public void execute(Environment env, @SuppressWarnings("rawtypes") Map params, TemplateModel[] loopVars,
            TemplateDirectiveBody body) throws TemplateException, IOException {

        Writer out = env.getOut();
        if (body != null) {
            StringWriter stringWriter = new StringWriter();
            body.render(stringWriter);
            String condition = stringWriter.toString().trim();
            if (condition.length() > 0) {
                out.write(" where ");
                out.write(condition);
                //                out.write(condition.replaceAll("\n\n", "\n")); //TODO 后续加入配置来处理空白行的问题
                out.write(" ");
            }
        }
    }

}
