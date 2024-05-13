package cn.featherfly.hammer.sqldb.tpl.freemarker.directive;

import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.Map;

import cn.featherfly.common.lang.CollectionUtils;
import cn.featherfly.common.lang.Lang;
import cn.featherfly.hammer.tpl.TplConfigFactory;
import cn.featherfly.hammer.tpl.TplExecuteConfig;
import cn.featherfly.hammer.tpl.TplExecuteConfig.Param;
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
            includeTemplateName = tplConfigFactory.getTemplateConfig().getTplExecuteIdParser().format(name, namespace);

            // ENHANCE 下面的逻辑最优是在预编译的时候执行
            setIncluded(tplConfigFactory.getConfig(includeTemplateName), tplConfigFactory.getTemplateConfig()
                    .getTplExecuteIdParser().parse(environment.getCurrentNamespace().getTemplate().getName()));
        } else {
            TplExecuteId executeId = tplConfigFactory.getTemplateConfig().getTplExecuteIdParser()
                    .parse(environment.getCurrentNamespace().getTemplate().getName());
            TplExecuteConfig includeConfig = tplConfigFactory.getConfig(tplConfigFactory.getTemplateConfig()
                    .getTplExecuteIdParser().format(name, executeId.getNamespace()));
            includeTemplateName = includeConfig.getExecuteId();

            // ENHANCE 下面的逻辑最优是在预编译的时候执行
            setIncluded(includeConfig, executeId);
        }
        environment.include(environment.getTemplateForInclusion(includeTemplateName,
                tplConfigFactory.getTemplateConfig().getCharset().name(), true));
    }

    private void setIncluded(TplExecuteConfig includeConfig, TplExecuteId tplExecuteId) {
        if (Lang.isNotEmpty(includeConfig.getParams())) {
            TplExecuteConfig config = tplConfigFactory.getConfig(tplExecuteId);
            if (!config.isIncluded()) {
                LinkedHashSet<Param> ps = new LinkedHashSet<>();
                CollectionUtils.addAll(ps, config.getParams());

                CollectionUtils.addAll(ps, includeConfig.getParams());

                config.setParams(CollectionUtils.toArray(ps, Param.class));
                // FIXME 如果引入模板前有参数，引入的模板有参数，引入后还有参数，那么这里的参数顺序是错误的
                // t1[name, age, t2, gender, t3, descp] t2[price, amount] t3[address, mobile]
                // 正确顺序是 name, age, price, amount, gender, address, mobile, descp
                // 当前逻辑的顺序是 name, age, gender, descp, price, amount, address, mobile
                config.setIncluded(true); //
            }
        }
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