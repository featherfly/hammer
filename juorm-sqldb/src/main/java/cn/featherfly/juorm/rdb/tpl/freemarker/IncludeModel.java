package cn.featherfly.juorm.rdb.tpl.freemarker;

import java.io.IOException;
import java.util.Map;

import cn.featherfly.common.lang.LangUtils;
import cn.featherfly.juorm.tpl.TplConfigFactory;
import cn.featherfly.juorm.tpl.TplExecuteConfig;
import cn.featherfly.juorm.tpl.TplExecuteId;
import cn.featherfly.juorm.tpl.TplExecuteIdImpl;
import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateDirectiveModel;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;
import freemarker.template.TemplateModelException;
import freemarker.template.TemplateScalarModel;

public class IncludeModel implements TemplateDirectiveModel {

    private static final String FILE_PARAM = "file";

    private static final String ID_PARAM = "id";

    private TplConfigFactory tplConfigFactory;

    /**
     * @param tplConfigFactory
     */
    public IncludeModel(TplConfigFactory tplConfigFactory) {
        super();
        this.tplConfigFactory = tplConfigFactory;
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
            TplExecuteId executeId = new TplExecuteIdImpl(environment.getCurrentNamespace().getTemplate().getName());
            TplExecuteConfig config = tplConfigFactory.getConfig(executeId);
            includeTemplateName = config.getName() + TplConfigFactory.ID_SIGN + id;
        }
        environment.include(environment.getTemplateForInclusion(includeTemplateName, null, true));
    }

    private String getId(Map<String, TemplateModel> params) throws TemplateModelException {
        String id;
        TemplateModel paramValue = params.get(ID_PARAM);
        if (paramValue == null) {
            throw new TemplateModelException("The \"" + ID_PARAM + "\" parameter " + "can not be null.");
        }
        if (!(paramValue instanceof TemplateScalarModel)) {
            throw new TemplateModelException("The \"" + ID_PARAM + "\" parameter " + "must be a String.");
        }
        id = ((TemplateScalarModel) paramValue).getAsString();
        return id;
    }

    private String getFile(Map<String, TemplateModel> params) throws TemplateModelException {
        String file = null;
        TemplateModel paramValue = params.get(FILE_PARAM);
        if (paramValue != null) {
            if (!(paramValue instanceof TemplateScalarModel)) {
                throw new TemplateModelException("The \"" + FILE_PARAM + "\" parameter " + "must be a String.");
            }
            file = ((TemplateScalarModel) paramValue).getAsString();
        }
        return file;
    }
}