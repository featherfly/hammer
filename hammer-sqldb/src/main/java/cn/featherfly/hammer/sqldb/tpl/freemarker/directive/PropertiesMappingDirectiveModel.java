
package cn.featherfly.hammer.sqldb.tpl.freemarker.directive;

import java.io.IOException;
import java.io.Writer;
import java.util.Map;
import java.util.Set;

import cn.featherfly.common.db.Table;
import cn.featherfly.common.db.mapping.ClassMappingUtils;
import cn.featherfly.common.db.mapping.JdbcClassMapping;
import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.common.lang.Lang;
import cn.featherfly.common.lang.WordUtils;
import cn.featherfly.hammer.tpl.TplException;
import cn.featherfly.hammer.tpl.directive.PropertiesMappingDirective;
import cn.featherfly.hammer.tpl.freemarker.FreemarkerDirective;
import freemarker.core.Environment;
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
public class PropertiesMappingDirectiveModel extends PropertiesMappingDirective implements FreemarkerDirective {

    private JdbcMappingFactory mappingFactory;

    /**
     * @param mappingFactory mappingFactory
     * @param resultType     resultType
     */
    public PropertiesMappingDirectiveModel(JdbcMappingFactory mappingFactory, Class<?> resultType) {
        this(DEFAULT_PARAM_NAME_NAME, mappingFactory, resultType);
    }

    /**
     * @param paramName      paramName
     * @param mappingFactory mappingFactory
     * @param resultType     resultType
     */
    public PropertiesMappingDirectiveModel(String paramName, JdbcMappingFactory mappingFactory, Class<?> resultType) {
        super(paramName, mappingFactory, resultType);
        // FIXME 这里暂时还没有把接口抽出来，暂时只定义了一个接口符号，后续来改
        this.mappingFactory = mappingFactory;
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
            if (paramName.equals(this.paramName)) {
                if (!(paramValue instanceof TemplateScalarModel)) {
                    throw new TplException("The \"" + paramName + "\" parameter " + "must be a String.");
                }
                nameParam = ((TemplateScalarModel) paramValue).getAsString();
            } else if (paramName.equals(PARAM_NAME_ALIAS)) {
                if (!(paramValue instanceof TemplateScalarModel)) {
                    throw new TplException("The \"" + PARAM_NAME_ALIAS + "\" parameter " + "must be a String.");
                }
                aliasParam = ((TemplateScalarModel) paramValue).getAsString();
            } else if (paramName.equals(PARAM_NAME_MAPPING)) {
                if (!(paramValue instanceof TemplateScalarModel)) {
                    throw new TplException("The \"" + PARAM_NAME_MAPPING + "\" parameter " + "must be a String.");
                }
                String mappingClassName = ((TemplateScalarModel) paramValue).getAsString();
                try {
                    mappingType = Class.forName(mappingClassName);
                } catch (ClassNotFoundException e) {
                    throw new TplException("The \"" + PARAM_NAME_MAPPING + "\" parameter " + mappingClassName
                            + " exception -> " + e.getMessage());
                }
            } else {
                throw new TplException("Unsupported parameter: " + paramName);
            }
        }

        if (mappingType == null) {
            mappingType = resultType;
        }

        JdbcClassMapping<?> classMapping = null;
        if (mappingType == null) {
            if (Lang.isEmpty(nameParam)) {
                throw new TplException(
                        "The \"" + paramName + "\" parameter " + "can not be null when result type is not mapped");
            }
        } else {
            classMapping = mappingFactory.getClassMapping(mappingType);
        }

        // ---------------------------------------------------------------------
        // Do the actual directive execution:

        Writer out = env.getOut();
        final boolean aliasIsEmpty = Lang.isEmpty(aliasParam);
        final String alias = aliasParam;
        final StringBuilder result = new StringBuilder();

        if (classMapping == null) {
            Table tableMetadata = mappingFactory.getMetadata().getTable(nameParam.toUpperCase());
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
