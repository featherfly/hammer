package cn.featherfly.juorm.tpl.directive;

import cn.featherfly.juorm.tpl.TplConfigFactory;

/**
 * 
 * <p>
 * IncludeDirective
 * </p>
 * 
 * @author zhongj
 */
public abstract class IncludeDirective implements TemplateDirective {

    protected static final String FILE_PARAM = "file";

    protected static final String ID_PARAM = "id";

    protected TplConfigFactory tplConfigFactory;

    /**
     * @param tplConfigFactory
     */
    public IncludeDirective(TplConfigFactory tplConfigFactory) {
        super();
        this.tplConfigFactory = tplConfigFactory;
    }

}