package cn.featherfly.juorm.rdb.tpl.freemarker.method;

import java.util.List;

import cn.featherfly.juorm.rdb.sql.dialect.Dialect;
import cn.featherfly.juorm.tpl.method.WrapMethod;
import freemarker.template.TemplateMethodModelEx;
import freemarker.template.TemplateModelException;

public class WrapMethodModel implements TemplateMethodModelEx, WrapMethod {

    private Dialect dialect;

    /**
     * @param dialect
     */
    public WrapMethodModel(Dialect dialect) {
        super();
        this.dialect = dialect;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Object exec(@SuppressWarnings("rawtypes") List arguments)
            throws TemplateModelException {
        if (arguments.size() != 1) {
            throw new TemplateModelException(
                    "Wrong arguments, only one argument allow");
        }
        return dialect.wrapName(arguments.get(0).toString());
    }
}