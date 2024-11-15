
package cn.featherfly.hammer.sqldb.tpl.freemarker.directive;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Map;

import cn.featherfly.hammer.config.tpl.TemplateConfig;
import cn.featherfly.hammer.tpl.directive.WhereDirective;
import cn.featherfly.hammer.tpl.freemarker.FreemarkerDirective;
import cn.featherfly.hammer.tpl.supports.WhereConditionParams;
import cn.featherfly.hammer.tpl.supports.ConditionParamsManager;
import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;

/**
 * WhereDirectiveModel.
 *
 * @author zhongj
 */
public class WhereDirectiveModel implements FreemarkerDirective, WhereDirective {

    /** The Constant CONDITION_PARAMS_MANAGER_KEY. */
    public static final String CONDITION_PARAMS_MANAGER_KEY = "__ConditionParamsManager__";

    private final ConditionParamsManager conditionParamsManagers;

    /**
     * Instantiates a new where directive model.
     *
     * @param templateConfig the template config
     */
    public WhereDirectiveModel(TemplateConfig templateConfig) {
        super();
        conditionParamsManagers = new ConditionParamsManager(templateConfig.getParamIndexToName());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void execute(Environment env, @SuppressWarnings("rawtypes") Map params, TemplateModel[] loopVars,
        TemplateDirectiveBody body) throws TemplateException, IOException {
        Writer out = env.getOut();
        if (body != null) {
            StringWriter stringWriter = new StringWriter();
            // 设置 ConditionParamsManager
            WhereConditionParams paramsManager = conditionParamsManagers.addWhere();
            env.setCustomAttribute(CONDITION_PARAMS_MANAGER_KEY, paramsManager);
            body.render(stringWriter);
            String condition = stringWriter.toString().trim();
            if (condition.length() > 0) {
                out.write(" where ");
                out.write(condition);
                //                out.write(condition.replaceAll("\n\n", "\n")); //ENHANCE 后续加入配置来处理空白行的问题
                out.write(" ");
            }
            // 移除 ConditionParamsManager
            env.removeCustomAttribute(CONDITION_PARAMS_MANAGER_KEY);
        }
    }

    /**
     * Gets the condition params managers.
     *
     * @return the condition params managers
     */
    public ConditionParamsManager getConditionParamsManagers() {
        return conditionParamsManagers;
    }
}
