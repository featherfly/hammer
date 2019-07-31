
package cn.featherfly.juorm.rdb.tpl.freemarker;

import java.io.IOException;
import java.io.Writer;
import java.util.Map;
import java.util.Set;

import cn.featherfly.common.db.metadata.TableMetadata;
import cn.featherfly.common.lang.LangUtils;
import cn.featherfly.juorm.rdb.jdbc.mapping.MappingFactory;
import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateDirectiveModel;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;
import freemarker.template.TemplateModelException;
import freemarker.template.TemplateScalarModel;

/**
 * <p>
 * WhereTemplateDirectiveModel
 * </p>
 *
 * @author zhongj
 */
public class PropertiesMappingDirectiveModel implements TemplateDirectiveModel {

    private static final String DEFAULT_PARAM_NAME_NAME = "table";

    private static final String PARAM_NAME_ALIAS = "alias";

    private MappingFactory mappingFactory;

    private String paramName;

    /**
     * @param mappingFactory
     */
    public PropertiesMappingDirectiveModel(MappingFactory mappingFactory) {
        this(DEFAULT_PARAM_NAME_NAME, mappingFactory);
    }

    /**
     * @param mappingFactory
     */
    public PropertiesMappingDirectiveModel(String paramName, MappingFactory mappingFactory) {
        super();
        this.mappingFactory = mappingFactory;
        this.paramName = paramName;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void execute(Environment env, @SuppressWarnings("rawtypes") Map params, TemplateModel[] loopVars,
            TemplateDirectiveBody body) throws TemplateException, IOException {
        String nameParam = null;
        String aliasParam = null;

        @SuppressWarnings("unchecked")
        Set<Map.Entry<String, Object>> entrySet = params.entrySet();

        for (Map.Entry<String, Object> ent : entrySet) {
            String paramName = ent.getKey();
            TemplateModel paramValue = (TemplateModel) ent.getValue();
            if (paramName.equals(paramName)) {
                if (!(paramValue instanceof TemplateScalarModel)) {
                    throw new TemplateModelException("The \"" + paramName + "\" parameter " + "must be a String.");
                }
                nameParam = ((TemplateScalarModel) paramValue).getAsString();
            } else if (paramName.equals(PARAM_NAME_ALIAS)) {
                if (!(paramValue instanceof TemplateScalarModel)) {
                    throw new TemplateModelException(
                            "The \"" + PARAM_NAME_ALIAS + "\" parameter " + "must be a String.");
                }
                aliasParam = ((TemplateScalarModel) paramValue).getAsString();
            } else {
                throw new TemplateModelException("Unsupported parameter: " + paramName);
            }
        }

        if (LangUtils.isEmpty(nameParam)) {
            throw new TemplateModelException("The \"" + paramName + "\" parameter " + "can not be null.");
        }

        // ---------------------------------------------------------------------
        // Do the actual directive execution:

        Writer out = env.getOut();
        final boolean aliasIsEmpty = LangUtils.isEmpty(aliasParam);
        final String alias = aliasParam;
        final StringBuilder result = new StringBuilder();
        TableMetadata tableMetadata = mappingFactory.getMetadata().getTable(nameParam.toUpperCase());
        tableMetadata.getColumns().forEach(column -> {
            if (aliasIsEmpty) {
                result.append(" " + column.getName() + ",");
            } else {
                result.append(" " + alias + "." + column.getName() + ",");
            }
        });
        if (result.length() > 0) {
            result.deleteCharAt(result.length() - 1);
        }
        out.write(result.toString());
    }
}
