package cn.featherfly.hammer.sqldb.tpl.freemarker.method;

import java.util.List;

import cn.featherfly.hammer.sqldb.tpl.freemarker.directive.StringReplaceDirectiveModel;
import cn.featherfly.hammer.tpl.TplException;
import cn.featherfly.hammer.tpl.freemarker.FreemarkerMethod;
import cn.featherfly.hammer.tpl.method.StringReplaceMethod;
import freemarker.template.TemplateModelException;

/**
 * string replace method model.
 *
 * @author zhongj
 */
public class StringReplaceMethodModel implements FreemarkerMethod, StringReplaceMethod {

    /**
     * Instantiates a new string replace method model.
     *
     * @param dialect dialect
     */
    public StringReplaceMethodModel() {
        super();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Object exec(@SuppressWarnings("rawtypes") List arguments) throws TemplateModelException {
        if (arguments.size() != 1) {
            throw new TplException("Wrong arguments, only one argument allow");
        }
        String value = arguments.get(0).toString();
        StringReplaceDirectiveModel.assertValid(value);
        return value;
    }
}