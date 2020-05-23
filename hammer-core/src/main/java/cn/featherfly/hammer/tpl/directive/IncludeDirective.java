package cn.featherfly.hammer.tpl.directive;

import cn.featherfly.hammer.tpl.TplConfigFactory;

/**
 * <p>
 * IncludeDirective
 * </p>
 *
 * @author zhongj
 */
public abstract class IncludeDirective implements TemplateDirective {

    protected static final String NAME_SPACE_PARAM = "namespace";

    protected static final String ID_PARAM = "id";

    protected TplConfigFactory tplConfigFactory;

    /**
     * @param tplConfigFactory tplConfigFactory
     */
    public IncludeDirective(TplConfigFactory tplConfigFactory) {
        super();
        this.tplConfigFactory = tplConfigFactory;
    }

}