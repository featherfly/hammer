
package cn.featherfly.juorm.rdb.tpl.freemarker;

import java.io.IOException;
import java.io.Writer;
import java.util.Map;
import java.util.Set;

import cn.featherfly.common.db.metadata.TableMetadata;
import cn.featherfly.common.lang.LangUtils;
import cn.featherfly.common.lang.WordUtils;
import cn.featherfly.juorm.rdb.jdbc.mapping.ClassMapping;
import cn.featherfly.juorm.rdb.jdbc.mapping.ClassMappingUtils;
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

    private static final String PARAM_NAME_MAPPING = "mapping";

    private MappingFactory mappingFactory;

    private Class<?> resultType;

    private String paramName;

    /**
     * @param mappingFactory mappingFactory
     * @param resultType     resultType
     */
    public PropertiesMappingDirectiveModel(MappingFactory mappingFactory, Class<?> resultType) {
        this(DEFAULT_PARAM_NAME_NAME, mappingFactory, resultType);
    }

    /**
     * @param paramName      paramName
     * @param mappingFactory mappingFactory
     * @param resultType     resultType
     */
    public PropertiesMappingDirectiveModel(String paramName, MappingFactory mappingFactory, Class<?> resultType) {
        super();
        this.mappingFactory = mappingFactory;
        this.paramName = paramName;
        this.resultType = resultType;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void execute(Environment env, @SuppressWarnings("rawtypes") Map params, TemplateModel[] loopVars,
            TemplateDirectiveBody body) throws TemplateException, IOException {
        String nameParam = null;
        String aliasParam = null;
        Class<?> mappingType = null;

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
            } else if (paramName.equals(PARAM_NAME_MAPPING)) {
                if (!(paramValue instanceof TemplateScalarModel)) {
                    throw new TemplateModelException(
                            "The \"" + PARAM_NAME_MAPPING + "\" parameter " + "must be a String.");
                }
                String mappingClassName = ((TemplateScalarModel) paramValue).getAsString();
                try {
                    mappingType = Class.forName(mappingClassName);
                } catch (ClassNotFoundException e) {
                    throw new TemplateModelException("The \"" + PARAM_NAME_MAPPING + "\" parameter " + mappingClassName
                            + " exception -> " + e.getMessage());
                }
            } else {
                throw new TemplateModelException("Unsupported parameter: " + paramName);
            }
        }

        if (mappingType == null) {
            mappingType = resultType;
        }
        ClassMapping<?> classMapping = mappingFactory.getClassMapping(mappingType);

        if (LangUtils.isEmpty(nameParam) && classMapping == null) {
            throw new TemplateModelException(
                    "The \"" + paramName + "\" parameter " + "can not be null when result type is not mapped");
        }

        // ---------------------------------------------------------------------
        // Do the actual directive execution:

        Writer out = env.getOut();
        final boolean aliasIsEmpty = LangUtils.isEmpty(aliasParam);
        final String alias = aliasParam;
        final StringBuilder result = new StringBuilder();

        if (classMapping == null) {
            TableMetadata tableMetadata = mappingFactory.getMetadata().getTable(nameParam.toUpperCase());
            tableMetadata.getColumns().forEach(column -> {
                String propName = WordUtils.parseToUpperFirst(column.getName(), '_');
                if (aliasIsEmpty) {
                    result.append(" " + column.getName() + " as " + propName + ",");
                } else {
                    result.append(" " + alias + "." + column.getName() + " as " + propName + ",");
                }
            });
            if (result.length() > 0) {
                result.deleteCharAt(result.length() - 1);
            }
            out.write(result.toString());
        } else {
            out.write(ClassMappingUtils.getSelectColumnsSql(classMapping, alias, mappingFactory.getDialect()));
        }

    }
}
