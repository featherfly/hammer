
package cn.featherfly.hammer.sqldb.tpl.freemarker.directive;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import cn.featherfly.common.lang.Str;
import cn.featherfly.hammer.sqldb.SqldbHammerException;
import cn.featherfly.hammer.tpl.TplException;
import cn.featherfly.hammer.tpl.directive.LogicDirective;
import cn.featherfly.hammer.tpl.freemarker.FreemarkerDirective;
import cn.featherfly.hammer.tpl.supports.WhereConditionParams;
import cn.featherfly.hammer.tpl.supports.WhereConditionParams.Param;
import freemarker.core.Environment;
import freemarker.template.TemplateBooleanModel;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;
import freemarker.template.TemplateScalarModel;

/**
 * LogicDirectiveModel.
 *
 * @author zhongj
 */
public abstract class LogicDirectiveModel implements FreemarkerDirective, LogicDirective {

    private static final String BETWEEN = "between";

    private static final Pattern CONDITION_PATTERN = Pattern.compile(
        "(\\w*\\.?[\\[`'\"]?\\w+[\\]`'\"]?) *(([=><]|<>|!=|>=|<=|!>|!<| like | in | is ) *(:\\w+|\\?)|(between) +(:\\w+|\\?) *(and) *(:\\w+|\\?))",
        Pattern.CASE_INSENSITIVE);

    /**
     * Instantiates a new logic template directive model.
     */
    protected LogicDirectiveModel() {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void execute(Environment env, @SuppressWarnings("rawtypes") Map params, TemplateModel[] loopVars,
        TemplateDirectiveBody body) throws TemplateException, IOException {

        Boolean ifParam = null;
        String nameParam = null;
        String transverterParam = null;
        boolean force = false;

        WhereConditionParams conditionParamsManager = (WhereConditionParams) env
            .getCustomAttribute(WhereDirectiveModel.CONDITION_PARAMS_MANAGER_KEY);

        if (conditionParamsManager == null) {
            throw new TplException(getLogicWorld() + " directive must be within the where directive");
        }

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
            } else if (paramName.equals(PARAM_NAME_TRANSVERTER)) {
                if (!(paramValue instanceof TemplateScalarModel)) {
                    throw new TplException("The \"" + PARAM_NAME_TRANSVERTER + "\" parameter " + "must be a String.");
                }
                transverterParam = ((TemplateScalarModel) paramValue).getAsString();
            } else if (paramName.equals(PARAM_NAME_FORCE)) {
                if (!(paramValue instanceof TemplateBooleanModel)) {
                    throw new TplException("The \"" + PARAM_NAME_FORCE + "\" parameter " + "must be a boolean.");
                }
                force = ((TemplateBooleanModel) paramValue).getAsBoolean();
            } else {
                throw new TplException("Unsupported parameter: " + paramName);
            }

        }

        // ---------------------------------------------------------------------
        // Do the actual directive execution:

        Writer out = env.getOut();
        if (body != null) {
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
            } else {
                String name = nameParam;
                if (ifParam.booleanValue()) { // 判断!ifParam，在conditionManager里加入filterNames
                    boolean needAppendLogicWorld = force || conditionParamsManager.isNeedAppendLogicWorld();
                    String condition = getContent(body);
                    name = getParamName(name, condition, conditionParamsManager);

                    for (String n : getParamNames(name)) {
                        Param param = null;
                        if (Str.isNotBlank(transverterParam)) {
                            param = new Param(n.trim(), transverterParam.trim());
                        } else {
                            param = new Param(n.trim());
                        }
                        conditionParamsManager.addParam(param);
                    }

                    if (needAppendLogicWorld) {
                        condition = " " + getLogicWorld() + " " + condition;
                    }
                    out.write(condition);
                } else {
                    conditionParamsManager.addFilterParamNames(getParamNames(name, conditionParamsManager, body));
                    out.write("");
                }
            }
        }
    }

    private String getContent(TemplateDirectiveBody body) throws TemplateException, IOException {
        StringWriter stringWriter = new StringWriter();
        body.render(stringWriter);
        return stringWriter.toString().trim();
    }

    private String[] getParamNames(String name) {
        if (name.contains(",")) {
            return name.split(",");
        } else {
            return new String[] { name };
        }
    }

    private String[] getParamNames(String name, WhereConditionParams conditionParamsManager,
        TemplateDirectiveBody body) throws TemplateException, IOException {
        return getParamNames(getParamName(name, conditionParamsManager, body));
    }

    private String getParamName(String name, WhereConditionParams conditionParamsManager, TemplateDirectiveBody body)
        throws TemplateException, IOException {
        if (org.apache.commons.lang3.StringUtils.isBlank(name)) {
            return getParamName(name, getContent(body), conditionParamsManager);
        } else {
            return name;
        }
    }

    private String getParamName(String name, String condition, WhereConditionParams conditionParamsManager) {
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
                if (conditionParamsManager.getParamNamed() != null && conditionParamsManager.getParamNamed() == true) {
                    throw new SqldbHammerException("不能name = ? 和 name = :name混合一起用");
                }
                conditionParamsManager.setParamNamed(false);

                name = m.group(1);
                if (org.apache.commons.lang3.StringUtils.isBlank(name) || betweenAnd) {
                    throw new IllegalArgumentException("[" + condition + "] "
                        + "查询条件无法获取条件名称，请直接在指令上设置参数名称<@and name=\"paramName\">或者<@and name=\"paramName1,paramName2\">");
                }
            } else if (paramType.startsWith(":")) {
                if (conditionParamsManager.getParamNamed() != null && conditionParamsManager.getParamNamed() == false) {
                    throw new SqldbHammerException("不能name = ? 和 name = :name混合一起用");
                }
                conditionParamsManager.setParamNamed(true);
                name = paramType.substring(1);
                if (betweenAnd) {
                    name = name + "," + m.group(8).substring(1);
                }
            }
        }
        return name;
    }

    protected abstract String getLogicWorld();

}
