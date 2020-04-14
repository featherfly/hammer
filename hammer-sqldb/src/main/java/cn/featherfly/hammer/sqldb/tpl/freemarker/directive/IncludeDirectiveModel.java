package cn.featherfly.hammer.sqldb.tpl.freemarker.directive;

import java.io.IOException;
import java.util.Map;

import cn.featherfly.common.lang.LangUtils;
import cn.featherfly.hammer.tpl.TplConfigFactory;
import cn.featherfly.hammer.tpl.TplException;
import cn.featherfly.hammer.tpl.TplExecuteConfig;
import cn.featherfly.hammer.tpl.TplExecuteId;
import cn.featherfly.hammer.tpl.TplExecuteIdFileImpl;
import cn.featherfly.hammer.tpl.directive.IncludeDirective;
import cn.featherfly.hammer.tpl.freemarker.FreemarkerDirective;
import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;
import freemarker.template.TemplateModelException;
import freemarker.template.TemplateScalarModel;

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
        String id = getId(params);
        @SuppressWarnings("unchecked")
        String file = getFile(params);
        if (LangUtils.isNotEmpty(file)) {
            includeTemplateName = file + TplConfigFactory.ID_SIGN + id;
        } else {
            TplExecuteId executeId = new TplExecuteIdFileImpl(environment.getCurrentNamespace().getTemplate().getName());
            TplExecuteConfig config = tplConfigFactory.getConfig(executeId);
            includeTemplateName = config.getName() + TplConfigFactory.ID_SIGN + id;
        }
        environment.include(environment.getTemplateForInclusion(includeTemplateName, null, true));
    }

    /**
     * Gets the id.
     *
     * @param params the params
     * @return the id
     * @throws TemplateModelException the template model exception
     */
    private String getId(Map<String, TemplateModel> params) throws TemplateModelException {
        String id;
        TemplateModel paramValue = params.get(ID_PARAM);
        if (paramValue == null) {
            throw new TplException("The \"" + ID_PARAM + "\" parameter " + "can not be null.");
        }
        if (!(paramValue instanceof TemplateScalarModel)) {
            throw new TplException("The \"" + ID_PARAM + "\" parameter " + "must be a String.");
        }
        id = ((TemplateScalarModel) paramValue).getAsString();
        return id;
    }

    /**
     * Gets the file.
     *
     * @param params the params
     * @return the file
     * @throws TemplateModelException the template model exception
     */
    private String getFile(Map<String, TemplateModel> params) throws TemplateModelException {
        String file = null;
        TemplateModel paramValue = params.get(FILE_PARAM);
        if (paramValue != null) {
            if (!(paramValue instanceof TemplateScalarModel)) {
                throw new TplException("The \"" + FILE_PARAM + "\" parameter " + "must be a String.");
            }
            file = ((TemplateScalarModel) paramValue).getAsString();
        }
        return file;
    }
}