
package cn.featherfly.hammer.sqldb.tpl.freemarker.directive;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import cn.featherfly.hammer.sqldb.SqldbHammerException;
import cn.featherfly.hammer.tpl.TplException;
import cn.featherfly.hammer.tpl.directive.LogicDirective;
import cn.featherfly.hammer.tpl.freemarker.FreemarkerDirective;
import cn.featherfly.hammer.tpl.supports.ConditionParamsManager;
import freemarker.core.Environment;
import freemarker.template.TemplateBooleanModel;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;
import freemarker.template.TemplateScalarModel;

/**
 * <p>
 * WhereTemplateDirectiveModel
 * </p>
 *
 * @author zhongj
 */
public abstract class LogicTemplateDirectiveModel implements FreemarkerDirective, LogicDirective {

    private static final String BETWEEN = "between";

    // (\w+) *([=><]|<>|!=|>=|<=| in | is ) *(:\w+|\?)
    // private static final Pattern CONDITION_PATTERN = Pattern
    // .compile("(\\w+) *([=><]|<>|!=|>=|<=| in | is ) *(:\\w+|\\?)",
    // Pattern.CASE_INSENSITIVE);

    // (\w+) *(([=><]|<>|!=|>=|<=| like | in | is ) *(:\w+|\?)|(between)
    // +(:\w+|\?) *(and) *(:\w+|\?))
    private static final Pattern CONDITION_PATTERN = Pattern.compile(
            "(\\w+) *(([=><]|<>|!=|>=|<=|!>|!<| like | in | is ) *(:\\w+|\\?)|(between) +(:\\w+|\\?) *(and) *(:\\w+|\\?))",
            Pattern.CASE_INSENSITIVE);

    private ConditionParamsManager conditionParamsManager;

    /**
     * @param conditionParamsManager conditionParamsManager
     */
    public LogicTemplateDirectiveModel(ConditionParamsManager conditionParamsManager) {
        this.conditionParamsManager = conditionParamsManager;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void execute(Environment env, @SuppressWarnings("rawtypes") Map params, TemplateModel[] loopVars,
            TemplateDirectiveBody body) throws TemplateException, IOException {

        Boolean ifParam = null;
        String nameParam = null;

        @SuppressWarnings("unchecked")
        Set<Map.Entry<String, Object>> entrySet = params.entrySet();

        for (Map.Entry<String, Object> ent : entrySet) {
            String paramName = ent.getKey();
            TemplateModel paramValue = (TemplateModel) ent.getValue();

            if (paramName.equals(PARAM_NAME_IF)) {
                if (!(paramValue instanceof TemplateBooleanModel)) {
                    throw new TplException("The \"" + PARAM_NAME_IF + "\" parameter " + "must be a boolean.");
                }
                ifParam = ((TemplateBooleanModel) paramValue).getAsBoolean();
            } else if (paramName.equals(PARAM_NAME_NAME)) {
                if (!(paramValue instanceof TemplateScalarModel)) {
                    throw new TplException("The \"" + PARAM_NAME_NAME + "\" parameter " + "must be a String.");
                }
                nameParam = ((TemplateScalarModel) paramValue).getAsString();
            } else {
                throw new TplException("Unsupported parameter: " + paramName);
            }
        }

        // ---------------------------------------------------------------------
        // Do the actual directive execution:

        Writer out = env.getOut();
        if (body != null) {
            // System.out.println("ifParam: " + ifParam + " amount: "
            // + conditionParamsManager.getAmount());
            if (ifParam == null) {
                boolean needAppendLogicWorld = conditionParamsManager.isNeedAppendLogicWorld();
                conditionParamsManager.startGroup();
                StringWriter stringWriter = new StringWriter();
                body.render(stringWriter);
                String condition = stringWriter.toString().trim();
                if (condition.length() > 0) {
                    String result = "";
                    if (needAppendLogicWorld) {
                        result = " " + getLogicWorld() + " ( " + condition + " )";
                    } else {
                        result = " ( " + condition + " )";
                    }
                    out.write(result);
                }
                conditionParamsManager.endGroup();
            } else if (ifParam) {
                String name = nameParam;
                boolean needAppendLogicWorld = conditionParamsManager.isNeedAppendLogicWorld();
                // if (conditionParamsManager.isNeedAppendLogicWorld()) {
                // out.write(" " + getLogicWorld() + " ");
                // }
                StringWriter stringWriter = new StringWriter();
                body.render(stringWriter);

                String condition = stringWriter.toString().trim();
                if (org.apache.commons.lang3.StringUtils.isBlank(name) && condition.length() > 0) {
                    Matcher m = null;
                    m = CONDITION_PATTERN.matcher(condition);
                    if (!m.matches()) {
                        throw new IllegalArgumentException(
                                "[" + condition + "] " + "查询条件无法获取条件名称，请直接在指令上设置参数名称<@and name=\"paramName\">");
                    }

                    String paramType = null;
                    boolean betweenAnd = false;
                    if (BETWEEN.equalsIgnoreCase(m.group(5))) {
                        paramType = m.group(6);
                        betweenAnd = true;
                    } else {
                        paramType = m.group(4);
                    }

                    if ("?".equals(paramType)) {
                        if (conditionParamsManager.getParamNamed() != null
                                && conditionParamsManager.getParamNamed() == true) {
                            throw new SqldbHammerException("不能name = ? 和 name = :name混合一起用");
                        }
                        conditionParamsManager.setParamNamed(false);

                        name = m.group(1);
                        if (org.apache.commons.lang3.StringUtils.isBlank(name) || betweenAnd) {
                            throw new IllegalArgumentException("[" + condition + "] "
                                    + "查询条件无法获取条件名称，请直接在指令上设置参数名称<@and name=\"paramName\">或者<@and name=\"paramName1,paramName2\">");
                        }
                    } else if (paramType.startsWith(":")) {
                        if (conditionParamsManager.getParamNamed() != null
                                && conditionParamsManager.getParamNamed() == false) {
                            throw new SqldbHammerException("不能name = ? 和 name = :name混合一起用");
                        }
                        conditionParamsManager.setParamNamed(true);
                        name = paramType.substring(1);
                        if (betweenAnd) {
                            name = name + "," + m.group(8).substring(1);
                        }
                    }
                }

                if (name.contains(",")) {
                    for (String n : name.split(",")) {
                        conditionParamsManager.addParam(n.trim());
                    }
                } else {
                    conditionParamsManager.addParam(name.trim());
                }
                if (needAppendLogicWorld) {
                    condition = " " + getLogicWorld() + " " + condition;
                }
                out.write(condition);
                // body.render(out);
            }
        }
    }

    protected abstract String getLogicWorld();

}
