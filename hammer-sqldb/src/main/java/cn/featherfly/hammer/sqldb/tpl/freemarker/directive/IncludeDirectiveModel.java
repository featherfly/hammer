package cn.featherfly.hammer.sqldb.tpl.freemarker.directive;

import java.io.IOException;
import java.util.Map;

import cn.featherfly.common.lang.Lang;
import cn.featherfly.hammer.tpl.TplConfigFactory;
import cn.featherfly.hammer.tpl.TplExecuteConfig;
import cn.featherfly.hammer.tpl.TplExecuteId;
import cn.featherfly.hammer.tpl.directive.IncludeDirective;
import cn.featherfly.hammer.tpl.freemarker.FreemarkerDirective;
import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;
import freemarker.template.TemplateModelException;

/**
 * The Class IncludeDirectiveModel.
 */
public class IncludeDirectiveModel extends IncludeDirective implements FreemarkerDirective {

    /**
     * Instantiates a new include directive model.
     *
     * @param tplConfigFactory the tpl config factory
     */
    public IncludeDirectiveModel(TplConfigFactory tplConfigFactory) {
        super(tplConfigFactory);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void execute(Environment environment, @SuppressWarnings("rawtypes") Map params, TemplateModel[] loopVars,
            TemplateDirectiveBody body) throws TemplateException, IOException {
        String includeTemplateName = null;
        @SuppressWarnings("unchecked")
        String name = getName(params);
        @SuppressWarnings("unchecked")
        String namespace = getNamespace(params);
        if (Lang.isNotEmpty(namespace)) {
            //            includeTemplateName = file + TplConfigFactory.ID_SIGN + id;
            includeTemplateName = tplConfigFactory.getParser().format(name, namespace);
        } else {
            TplExecuteId executeId = tplConfigFactory.getParser()
                    .parse(environment.getCurrentNamespace().getTemplate().getName());
            TplExecuteConfig config = tplConfigFactory
                    .getConfig(tplConfigFactory.getParser().format(name, executeId.getNamespace()));
            //            TplExecuteConfig config = tplConfigFactory.getConfigs(executeId.getNamespace()).getConfig(name);
            //            TplExecuteId executeId = new TplExecuteIdFileImpl(name, namespace, )
            //                    .parse(environment.getCurrentNamespace().getTemplate().getName());
            //            includeTemplateName = StringUtils.substringBefore(config.getTplName(),
            //                    tplConfigFactory.getParser().getSeparator()) + tplConfigFactory.getParser().getSeparator() + name;
            //            includeTemplateName = StringUtils.substringBefore(config.getExecuteId(),
            //                    tplConfigFactory.getParser().getSeparator()) + tplConfigFactory.getParser().getSeparator() + name;
            includeTemplateName = config.getExecuteId();
        }
        environment.include(environment.getTemplateForInclusion(includeTemplateName, null, true));
    }

    /**
     * Gets the name.
     *
     * @param params the params
     * @return the name
     * @throws TemplateModelException the template model exception
     */
    private String getName(Map<String, TemplateModel> params) throws TemplateModelException {
        return getStringValue(TAG_NAME, params, NAME_PARAM, false);
    }

    /**
     * Gets the file.
     *
     * @param params the params
     * @return the file
     * @throws TemplateModelException the template model exception
     */
    private String getNamespace(Map<String, TemplateModel> params) throws TemplateModelException {
        return getStringValue(TAG_NAME, params, NAME_SPACE_PARAM, true);
        //        String file = null;
        //        TemplateModel paramValue = params.get(NAME_SPACE_PARAM);
        //        if (paramValue != null) {
        //            if (!(paramValue instanceof TemplateScalarModel)) {
        //                throw new TplException("The \"" + NAME_SPACE_PARAM + "\" parameter " + "must be a String.");
        //            }
        //            file = ((TemplateScalarModel) paramValue).getAsString();
        //        }
        //        return file;
    }
}