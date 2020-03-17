package cn.featherfly.hammer.sqldb.tpl.freemarker.method;

import java.util.List;

import cn.featherfly.hammer.sqldb.sql.dialect.Dialect;
import cn.featherfly.hammer.tpl.TplException;
import cn.featherfly.hammer.tpl.freemarker.FreemarkerMethod;
import cn.featherfly.hammer.tpl.method.WrapMethod;
import freemarker.template.TemplateModelException;

/**
 * <p>
 * WrapMethodModel
 * </p>
 * 
 * @author zhongj
 */
public class WrapMethodModel implements FreemarkerMethod, WrapMethod {

    private Dialect dialect;

    /**
     * @param dialect dialect
     */
    public WrapMethodModel(Dialect dialect) {
        super();
        this.dialect = dialect;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Object exec(@SuppressWarnings("rawtypes") List arguments) throws TemplateModelException {
        if (arguments.size() != 1) {
            throw new TplException("Wrong arguments, only one argument allow");
        }
        return dialect.wrapName(arguments.get(0).toString());
    }
}